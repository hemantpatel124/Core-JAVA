package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Model.User;

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
					
					User u=new User();
					
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
					User u =new User();
					
					u.setEmail(request.getParameter("email"));
					u.setPassword(request.getParameter("password"));
					
					String email=request.getParameter("email");
					boolean flag=SellerDAO.checkEmail(email);
					
					
					if(flag==true) {
						User u1=SellerDAO.loginSeller(u);
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
					User u=new User();
					
					u.setPassword(request.getParameter("old_password"));
					
					String password=request.getParameter("old_password");
					
					boolean flag=SellerDAO.checkPassword(password);
					
					if(flag==true) {
						User u2=new User();

						u2.setEmail(request.getParameter("email"));
						u2.setPassword(request.getParameter("confirm_password"));
						SellerDAO.changePassword(u2);
						
						System.out.println("Password"+u2);
						
						request.setAttribute("cngps", "Your password change Successfull ...");
						request.getRequestDispatcher("seller_login.jsp").forward(request, response);
						
					}
					else {
						request.setAttribute("wrolps"," Please enter correct Old password!");
						request.getRequestDispatcher("seller_changepassword.jsp").forward(request, response);
					}
				}
				else if(action.equalsIgnoreCase("edit_profile")) {
					//int id=Integer.parseInt(request.getParameter("id"));
					//User u=SellerDAO.getSellerDataById(id);
					//request.setAttribute("seller", u);
					//request.getRequestDispatcher("seller_edit_profile.jsp");
					response.sendRedirect("seller_edit_profile.jsp");
				}
				else if(action.equalsIgnoreCase("upadte_profile")) {
					User u=new User();
					
					u.setId(Integer.parseInt(request.getParameter("id")));
					u.setName(request.getParameter("name"));
					u.setContact(Long.parseLong(request.getParameter("contact")));
					u.setAddress(request.getParameter("address"));
					u.setEmail(request.getParameter("email"));
					SellerDAO.updateSellerProfile(u);
					request.setAttribute("msg", "Profile Update successfull...");
					request.getRequestDispatcher("seller_profile.jsp").forward(request, response);
				
				}
	}

}
