package Controller;

import java.io.IOException;
import java.security.Provider.Service;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Model.Seller;
import EmailServices.*;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
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
					
					Seller u=new Seller();
					
					u.setName(request.getParameter("name"));
					u.setContact(Long.parseLong(request.getParameter("contact")));
					u.setAddress(request.getParameter("address"));
					u.setEmail(request.getParameter("email"));
					u.setPassword(request.getParameter("password"));
					System.out.println(u);
					SellerDAO.insertSeller(u);
					response.sendRedirect("seller_login.jsp");
					
				}
				else if(action.equalsIgnoreCase("login")) {
					Seller u =new Seller();
					
					u.setEmail(request.getParameter("email"));
					u.setPassword(request.getParameter("password"));
					
					String email=request.getParameter("email");
					boolean flag=SellerDAO.checkEmail(email);
					
					
					if(flag==true) {
						Seller u1=SellerDAO.loginSeller(u);
						if(u1==null) {
								request.setAttribute("msg1", "Password is incorrect !");
								request.getRequestDispatcher("seller_login.jsp").forward(request, response);	
						}
						else {
								HttpSession session=request.getSession();
								session.setAttribute("data", u1);
								request.getRequestDispatcher("seller_index.jsp").forward(request, response);
						}
					}
					else {
						request.setAttribute("msg", "Email id not registered !");
						request.getRequestDispatcher("seller_login.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("change_password")) {
					Seller u=new Seller();
					int id=Integer.parseInt(request.getParameter("id"));
					String op=request.getParameter("old_password");
					String np=request.getParameter("new_password");
					String cnp=request.getParameter("confirm_password");
					boolean flag=SellerDAO.checkOldPassword(op,id);
					
					if(flag==true) {
							if(np.equals(cnp)) {
								SellerDAO.changePassword(np, id);
								response.sendRedirect("seller_index.jsp");
							}
							else {
								request.setAttribute("msg1", "New  password and Confirm new password is not matched !!!");
								request.getRequestDispatcher("seller_changepassword.jsp").forward(request, response);
							}
					}
					else {
						request.setAttribute("msg"," Please enter correct Old password!");
						request.getRequestDispatcher("seller_changepassword.jsp").forward(request, response);
					}
				}
				
				else if(action.equalsIgnoreCase("upadte_profile")) {
					Seller u=new Seller();
					
					u.setId(Integer.parseInt(request.getParameter("id")));
					u.setName(request.getParameter("name"));
					u.setContact(Long.parseLong(request.getParameter("contact")));
					u.setAddress(request.getParameter("address"));
					u.setEmail(request.getParameter("email"));
					SellerDAO.updateSellerProfile(u);
					
					HttpSession session=request.getSession();
					session.setAttribute("data", u);
					request.getRequestDispatcher("seller_index.jsp").forward(request, response);
				
				}
				else if(action.equalsIgnoreCase("getotp")) {
						String email=request.getParameter("email");
						boolean flag=SellerDAO.checkEmail(email);
						
						if(flag==true) {
							Random r = new Random();
							int num = r.nextInt(9999);
							ServiceEmail s=new ServiceEmail();
							s.sendMail(email, num);
							request.setAttribute("email", email);
							request.setAttribute("otp", num);
							request.getRequestDispatcher("seller_verify_otp.jsp").forward(request, response);
						}
						else {
							request.setAttribute("msg", "Email id not registered !");
							request.getRequestDispatcher("seller_forgate_password.jsp").forward(request, response);
						}
				}
				else if(action.equalsIgnoreCase("verify_otp")) {
					String email=request.getParameter("email");
					int otp1=Integer.parseInt(request.getParameter("otp1"));
					int otp2=Integer.parseInt(request.getParameter("otp2"));
					//String otp1=request.getParameter("otp1");
					//String otp2=request.getParameter("otp2");
					if(otp1==otp2) {
						request.setAttribute("email", email);
						request.getRequestDispatcher("seller_new_password.jsp").forward(request, response);
					}
					else {
						request.setAttribute("email", email);
						request.setAttribute("otp", otp1);
						request.setAttribute("msg", "OTP not matched");
						request.getRequestDispatcher("seller_verify_otp.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("new_password")) {
					String email=request.getParameter("email");
					String np=request.getParameter("np");
					String cnp=request.getParameter("cnp");
					
					if(np.equals(cnp)) {
						SellerDAO.updateNewPassword(cnp, email);
						response.sendRedirect("seller_login.jsp");
					}
					else {
						request.setAttribute("msg", "New  password and Confirm new password is not matched !!!");
						request.getRequestDispatcher("seller_new_password.jsp").forward(request, response);
					}
					
				}
				
	}

}
