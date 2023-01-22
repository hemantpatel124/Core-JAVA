package cController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cDAO.AdminDAO;
import cDAO.FacultyDAO;
import cDAO.StudentDAO;
import cModel.Admin;
import cModel.Faculty;
import cModel.Student;

/**
 * Servlet implementation class FacultyController
 */
@WebServlet("/FacultyController")
public class FacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("register")) {
			
			Faculty f=new Faculty();
			f.setDcode(Integer.parseInt(request.getParameter("dcode")));
			f.setFname(request.getParameter("name"));
			f.setFemail(request.getParameter("email"));
			f.setFcontact(Long.parseLong(request.getParameter("contact")));
			f.setFcity(request.getParameter("city"));
			f.setFpassword(request.getParameter("password"));
			FacultyDAO.insertFaculty(f);
			response.sendRedirect("faculty_login.jsp");
		}
		else if(action.equalsIgnoreCase("login")) {
			Faculty f =new Faculty();
			
			f.setFemail(request.getParameter("email"));
			f.setFpassword(request.getParameter("password"));
			
			String email=request.getParameter("email");
			boolean flag=FacultyDAO.checkEmail(email);
			
			
			if(flag==true) {
					Faculty f1=FacultyDAO.loginFaculty(f);
					if(f1==null) {
							request.setAttribute("msg1", "Password is incorrect !");
							request.getRequestDispatcher("faculty_login.jsp").forward(request, response);	
					}
					else {
							HttpSession session=request.getSession();
							session.setAttribute("data", f1);
							request.getRequestDispatcher("faculty_index.jsp").forward(request, response);
					}
			}
			else {
					request.setAttribute("msg", "Email id not registered !");
					request.getRequestDispatcher("faculty_login.jsp").forward(request, response);
			}
		}
	}

}
