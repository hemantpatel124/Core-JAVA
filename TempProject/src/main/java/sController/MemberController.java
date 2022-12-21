package sController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sDAO.MemberDAO;
import sModel.Member;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
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
			MemberDAO.insertMember(m);
			System.out.println(m);
			response.sendRedirect("index.jsp");
			
		}
		else if(action.equalsIgnoreCase("registration_status")) {
			Member m =new Member();
			
			m.setEmail(request.getParameter("email"));
			String email=request.getParameter("email");
			
			
			boolean status=MemberDAO.checkStatus(email);
			if(status==true) {
				request.setAttribute("msg", "Your Registration Approved..");
				request.getRequestDispatcher("registration_status.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg1", "Your Registration Under Process !!");
				request.getRequestDispatcher("registration_status.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login")) {
			request.setAttribute("msg1", "Welcome Member !!");
			request.getRequestDispatcher("member_index.jsp").forward(request, response);
		}
		
		
		
		
		
//		else if(action.equalsIgnoreCase("login")) {
//			Member m =new Member();
//			
//			m.setEmail(request.getParameter("email"));
//			m.setPassword(request.getParameter("password"));
//			
//			String email=request.getParameter("email");
//			
//			boolean status=MemberDAO.checkStatus(email);
//			boolean flag=MemberDAO.checkEmail(email);
//			
//			
//						
//				if(flag==true) {
//					Member m1=MemberDAO.loginMember(m);
//					if(m1==null) {
//							request.setAttribute("msg1", "Password is incorrect !");
//							request.getRequestDispatcher("member_login.jsp").forward(request, response);	
//					}
//					else {
//							HttpSession session=request.getSession();
//							session.setAttribute("data", m1);
//							request.getRequestDispatcher("member_index.jsp").forward(request, response);
//					}
//				}
//			
//			}
				
		
		
	
	
	}
	

}
