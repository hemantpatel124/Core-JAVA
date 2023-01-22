package cController;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import cDAO.FacultyDAO;
import cDAO.StudentDAO;
import cModel.Faculty;
import cModel.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024
* 512)
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action=request.getParameter("action");
			
			if(action.equalsIgnoreCase("register")) {
				
				Student s=new Student();
				s.setDcode(Integer.parseInt(request.getParameter("dcode")));
				s.setSname(request.getParameter("name"));
				s.setSemail(request.getParameter("email"));
				s.setScontact(Long.parseLong(request.getParameter("contact")));
				s.setScity(request.getParameter("city"));
				s.setSpassword(request.getParameter("password"));
				StudentDAO.insertStudent(s);
				response.sendRedirect("student_login.jsp");
			}
			else if(action.equalsIgnoreCase("login")) {
				Student s =new Student();
				
				s.setSemail(request.getParameter("email"));
				s.setSpassword(request.getParameter("password"));
				
				String email=request.getParameter("email");
				boolean flag=StudentDAO.checkEmail(email);
				
				
				if(flag==true) {
						Student s1=StudentDAO.loginStudent(s);
						if(s1==null) {
								request.setAttribute("msg1", "Password is incorrect !");
								request.getRequestDispatcher("student_login.jsp").forward(request, response);	
						}
						else {
								HttpSession session=request.getSession();
								session.setAttribute("data", s1);
								request.getRequestDispatcher("student_index.jsp").forward(request, response);
						}
				}
				else {
						request.setAttribute("msg", "Email id not registered !");
						request.getRequestDispatcher("student_login.jsp").forward(request, response);
				}
			}
			else if(action.equalsIgnoreCase("update")) {
					
					Student s=new Student();
					s.setSid(Integer.parseInt(request.getParameter("sid")));
					s.setSname(request.getParameter("name"));
					s.setSgender(request.getParameter("gender"));
					//s.setSdob(Date.parse(request.getParameter("dob")));
					s.setSemail(request.getParameter("email"));
					s.setScontact(Long.parseLong(request.getParameter("contact")));
					s.setScity(request.getParameter("city"));
					
					StudentDAO.updateStudentProfile(s);
					
			}
			else if(action.equalsIgnoreCase("profilePhotoUpdate")) {
				Student s=new Student();
				
				//Product p = new Product();
				String savePath = "C:\\Users\\LENOVO\\eclipse-workspace\\College Management\\src\\main\\webapp\\image";
				File fileSaveDir = new File(savePath);
				if (!fileSaveDir.exists()) {
					fileSaveDir.mkdir();
				}
				Part file1 = request.getPart("image");
				String fileName = extractfilename(file1);
				file1.write(savePath + File.separator + fileName);
				String filePath = savePath + File.separator + fileName;

				String savePath2 = "C:\\Users\\LENOVO\\eclipse-workspace\\College Management\\src\\main\\webapp\\image";
				File imgSaveDir = new File(savePath2);
				if (!imgSaveDir.exists()) {
					imgSaveDir.mkdir();
				}
				
				
				s.setSid(Integer.parseInt(request.getParameter("sid")));
				s.setSphoto(fileName);
				StudentDAO.upadteProfilePhoto(s);
				
				
				response.sendRedirect("student_profile.jsp");
			}
	}

}
