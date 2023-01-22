package Controller;

import Model.Coustomer;
import DAO.CoustomerDAO;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import EmailServices.ServiceEmail;



/**
 * Servlet implementation class CoustomerController
 */
@WebServlet("/CoustomerController")
public class CoustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoustomerController() {
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
			
			Coustomer c=new Coustomer();
			
			c.setName(request.getParameter("name"));
			c.setContact(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			System.out.println(c);
			CoustomerDAO.insertCoustomer(c);
			response.sendRedirect("coustomer_login.jsp");
			
		}
		else if(action.equalsIgnoreCase("login")) {
			Coustomer c =new Coustomer();
			
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			
			String email=request.getParameter("email");
			boolean flag=CoustomerDAO.checkEmail(email);
			
			
			if(flag==true) {
				Coustomer c1=CoustomerDAO.loginCoustomer(c);
				if(c1==null) {
						request.setAttribute("msg1", "Password is incorrect !");
						request.getRequestDispatcher("coustomer_login.jsp").forward(request, response);	
				}
				else {
						HttpSession session=request.getSession();
						session.setAttribute("data", c1);
						request.getRequestDispatcher("coustomer_index.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Email id not registered !");
				request.getRequestDispatcher("coustomer_login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("change_password")) {
			Coustomer c=new Coustomer();
			int id=Integer.parseInt(request.getParameter("id"));
			String op=request.getParameter("old_password");
			String np=request.getParameter("new_password");
			String cnp=request.getParameter("confirm_password");
			boolean flag=CoustomerDAO.checkOldPassword(op,id);
			
			if(flag==true) {
					if(np.equals(cnp)) {
						CoustomerDAO.changePassword(np, id);
						response.sendRedirect("coustomer_index.jsp");
					}
					else {
						request.setAttribute("msg1", "New  password and Confirm new password is not matched !!!");
						request.getRequestDispatcher("coustomer_changepassword.jsp").forward(request, response);
					}
			}
			else {
				request.setAttribute("msg"," Please enter correct Old password!");
				request.getRequestDispatcher("coustomer_changepassword.jsp").forward(request, response);
			}
		}
		
		else if(action.equalsIgnoreCase("upadte_profile")) {
			Coustomer c=new Coustomer();
			
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setName(request.getParameter("name"));
			c.setContact(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			CoustomerDAO.updateCoustomerProfile(c);
			
			HttpSession session=request.getSession();
			session.setAttribute("data", c);
			request.getRequestDispatcher("coustomer_index.jsp").forward(request, response);
		
		}
		else if(action.equalsIgnoreCase("getotp")) {
				String email=request.getParameter("email");
				boolean flag=CoustomerDAO.checkEmail(email);
				
				if(flag==true) {
					Random r = new Random();
					int num = r.nextInt(9999);
					ServiceEmail s=new ServiceEmail();
					s.sendMail(email, num);
					request.setAttribute("email", email);
					request.setAttribute("otp", num);
					request.getRequestDispatcher("coustomer_verify_otp.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Email id not registered !");
					request.getRequestDispatcher("coustomer_forgate_password.jsp").forward(request, response);
				}
		}
		else if(action.equalsIgnoreCase("verify_otp")) {
			String email=request.getParameter("email");
			int otp1=Integer.parseInt(request.getParameter("otp1"));
			int otp2=Integer.parseInt(request.getParameter("otp2"));
			if(otp1==otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("coustomer_new_password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg", "OTP not matched");
				request.getRequestDispatcher("coustomer_verify_otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("new_password")) {
			String email=request.getParameter("email");
			String np=request.getParameter("np");
			String cnp=request.getParameter("cnp");
			
			if(np.equals(cnp)) {
				CoustomerDAO.updateNewPassword(cnp, email);
				response.sendRedirect("coustomer_login.jsp");
			}
			else {
				request.setAttribute("msg", "New  password and Confirm new password is not matched !!!");
				request.getRequestDispatcher("coustomer_new_password.jsp").forward(request, response);
			}
			
		}

	}

}
