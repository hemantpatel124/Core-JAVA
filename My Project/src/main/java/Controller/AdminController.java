package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import Model.User;

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
			User u =new User();
			
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			
			String email=request.getParameter("email");
			boolean flag=AdminDAO.checkEmail(email);
			
			
			if(flag==true) {
				User u1=AdminDAO.loginAdmin(u);
				if(u1==null) {
						request.setAttribute("msg1", "Password is incorrect !");
						request.getRequestDispatcher("admin_login.jsp").forward(request, response);	
				}
				else {
						HttpSession session=request.getSession();
						session.setAttribute("data", u1);
						request.getRequestDispatcher("admin_index.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "Email id not registered !");
				request.getRequestDispatcher("admin_login.jsp").forward(request, response);
			}
		}
		
		
	}

}
