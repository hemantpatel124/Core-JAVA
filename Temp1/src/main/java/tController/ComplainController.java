package tController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tDAO.AdminDAO;
import tDAO.ComplainDAO;
import tDAO.MemberDAO;
import tEmailServices.TEmailService;
import tModel.Complain;

/**
 * Servlet implementation class ComplainController
 */
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
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
			
			if(action.equalsIgnoreCase("new_complain")) {
					
				Complain c=new Complain();
				String date_time=AdminDAO.getLocalDateTime();
				c.setMid(Integer.parseInt(request.getParameter("mid")));
				c.setDoc(date_time);
				c.setSubject(request.getParameter("subject"));
				c.setComplain(request.getParameter("complain"));
				c.setStatus("Pending");
				ComplainDAO.insertComplain(c);
				response.sendRedirect("member_complain.jsp");
			}
			else if(action.equalsIgnoreCase("replay_complain")) {
				Complain c=new Complain();
				String date_time=AdminDAO.getLocalDateTime();
				c.setCid(Integer.parseInt(request.getParameter("cid")));
				c.setReplay(request.getParameter("replay"));
				c.setDor(date_time);
				ComplainDAO.replayComplain(c);
				response.sendRedirect("admin_index.jsp");
			}
	}

}
