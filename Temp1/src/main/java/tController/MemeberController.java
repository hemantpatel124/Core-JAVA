package tController;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tDAO.AdminDAO;
import tDAO.MemberDAO;
import tEmailServices.TEmailService;
import tModel.Complain;
import tModel.Member;

/**
 * Servlet implementation class MemeberController
 */
@WebServlet("/MemeberController")
public class MemeberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemeberController() {
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
						
						Member m=new Member();
					
						m.setName(request.getParameter("name"));
						m.setEmail(request.getParameter("email"));
						m.setContact(Long.parseLong(request.getParameter("contact")));
						m.setFlno(request.getParameter("flno"));
						m.setProf(request.getParameter("prof"));
						m.setFmno(Integer.parseInt(request.getParameter("fmno")));
						m.setAddress(request.getParameter("address"));
						m.setPassword(request.getParameter("password"));
						m.setStatus("Pending");
						MemberDAO.insertMember(m);
						System.out.println(m);
						response.sendRedirect("index.jsp");
				}
				else if(action.equalsIgnoreCase("login")) {
						Member m=new Member();
						m.setEmail(request.getParameter("email"));
						m.setPassword(request.getParameter("password"));
						
						String email=request.getParameter("email");
						boolean status=MemberDAO.checkStatus(email);
						boolean flag=MemberDAO.checkEmail(email);
						
						if(status==false) {
							
							if(flag==true) {
									Member m1=MemberDAO.loginMember(m);
									if(m1==null) {
											request.setAttribute("msg1", "Password is incorrect !");
											request.getRequestDispatcher("login.jsp").forward(request, response);	
									}
									else {
											HttpSession session=request.getSession();
											session.setAttribute("data", m1);
											request.getRequestDispatcher("member_index.jsp").forward(request, response);
									}
							}
							else {
									request.setAttribute("msg", "Email id is not registred !");
									request.getRequestDispatcher("login.jsp").forward(request, response);
							}

						}
						else {
								request.setAttribute("msg2", "Email id under approvel process !");
								request.getRequestDispatcher("login.jsp").forward(request, response);
						}
				}
				else if(action.equalsIgnoreCase("getotp")) {
					String email=request.getParameter("email");
					boolean flag=MemberDAO.checkEmail(email);
					
					if(flag==true) {
						Random r = new Random();
						int num = r.nextInt(9999);
						TEmailService s=new TEmailService();
						s.sendOTPMail(email, num);
						request.setAttribute("email", email);
						request.setAttribute("otp", num);
						request.getRequestDispatcher("member_verify_otp.jsp").forward(request, response);
					}
					else {
						request.setAttribute("msg", "Email id not registered !");
						request.getRequestDispatcher("member_forgate_password.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("verify_otp")) {
					String email=request.getParameter("email");
					int otp1=Integer.parseInt(request.getParameter("otp1"));
					int otp2=Integer.parseInt(request.getParameter("otp2"));
					if(otp1==otp2) {
						request.setAttribute("email", email);
						request.getRequestDispatcher("member_new_password.jsp").forward(request, response);
					}
					else {
						request.setAttribute("email", email);
						request.setAttribute("otp", otp1);
						request.setAttribute("msg", "OTP not matched");
						request.getRequestDispatcher("member_verify_otp.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("update_password")) {
					String email=request.getParameter("email");
					String np=request.getParameter("new_password");
					String cnp=request.getParameter("confirm_new_password");
					
					if(np.equals(cnp)) {
						MemberDAO.updateNewPassword(cnp, email);
						response.sendRedirect("login.jsp");
					}
					else {
						request.setAttribute("msg", "New  password and Confirm new password is not matched !!!");
						request.getRequestDispatcher("member_new_password.jsp").forward(request, response);
					}
					
				}
						
					
			
				

	}

}
