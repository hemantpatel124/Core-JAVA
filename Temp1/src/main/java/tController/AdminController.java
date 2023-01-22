package tController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tDAO.AdminDAO;
import tDAO.MemberDAO;
import tEmailServices.TEmailService;
import tModel.Admin;
import tModel.Member;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
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
				
				if(action.equalsIgnoreCase("admin_login")) {
					Admin a =new Admin();
					
					a.setEmail(request.getParameter("email"));
					a.setPassword(request.getParameter("password"));
					
					String email=request.getParameter("email");
					boolean flag=AdminDAO.checkEmail(email);
					
					
					if(flag==true) {
							Admin a1=AdminDAO.loginAdmin(a);
							if(a1==null) {
									request.setAttribute("msg1", "Password is incorrect !");
									request.getRequestDispatcher("admin_login.jsp").forward(request, response);	
							}
							else {
									HttpSession session=request.getSession();
									session.setAttribute("data", a1);
									request.getRequestDispatcher("admin_index.jsp").forward(request, response);
							}
					}
					else {
							request.setAttribute("msg", "Email id not registered !");
							request.getRequestDispatcher("admin_login.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("member_approved")) {
					
						int mid=Integer.parseInt(request.getParameter("mid"));
						String mailId=request.getParameter("email");
						AdminDAO.approvedMember(mid);
						
						boolean flag=MemberDAO.checkEmail(mailId);
						if(flag==true) {
							TEmailService s=new TEmailService();
							s.sendApprovelMail(mailId);
							request.setAttribute("email",mailId);
							request.setAttribute("msg1", "Mail send succesfully...");
							request.getRequestDispatcher("admin_index.jsp").forward(request, response);
						}
						else {
								request.setAttribute("msg", "wrong email id !!!");
								request.getRequestDispatcher("admin_index.jsp").forward(request, response);
						}
						
						
						//response.sendRedirect("admin_index.jsp");
				}
				else if(action.equalsIgnoreCase("mailSend")) {
						String emailId=request.getParameter("email");
						System.out.println("Email Id : "+emailId);
						
						boolean flag=MemberDAO.checkEmail(emailId);
						
						if(flag==true) {
							TEmailService s=new TEmailService();
							s.sendApprovelMail(emailId);
							request.setAttribute("email",emailId);
							request.setAttribute("msg1", "Mail send succesfully...");
							request.getRequestDispatcher("admin_index.jsp").forward(request, response);
						}
						else {
								request.setAttribute("msg", "wrong email id !!!");
								request.getRequestDispatcher("admin_index.jsp").forward(request, response);
						}
						
				}
				else if(action.equalsIgnoreCase("admin_login")) {
				
					String email=request.getParameter("email");
					String password=request.getParameter("password");
					
					boolean flag=AdminDAO.loginAdmin(email, password);
					
					if(flag==true) {
						request.getRequestDispatcher("admin_index.jsp").forward(request, response);	}
					else {
							request.setAttribute("msg", "Email or Password Incorrect!!!!");
							request.getRequestDispatcher("admin_login.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("notice_generate")) {
					String sub=request.getParameter("subject");
					String des=request.getParameter("description");
				    String datetime = AdminDAO.getLocalDateTime();
				    System.out.println("Local DateTime : "+datetime);
//					Calendar calendar = Calendar.getInstance();
//					java.util.Date currentTime = calendar.getTime();
//					LocalDateTime now = LocalDateTime.now();
//					System.out.println(now);
					
					//long date_time = currentTime.getTime();
					
					AdminDAO.noticeGenerat(datetime,sub, des);
					response.sendRedirect("admin_notice_manage.jsp");
				}
				else if(action.equalsIgnoreCase("showtime")) {
					LocalDateTime now = LocalDateTime.now();
					System.out.println("Timing : "+now);
				}
				
				
	}

}
