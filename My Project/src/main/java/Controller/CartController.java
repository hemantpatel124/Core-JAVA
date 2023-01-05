package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CartDAO;
import DAO.WishlistDAO;
import Model.Cart;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String action=request.getParameter("action");
			if(action.equalsIgnoreCase("addtocart")) {
				Cart c=new Cart();
				c.setPid(Integer.parseInt(request.getParameter("pid")));
				c.setCusid(Integer.parseInt(request.getParameter("cusid")));
				int pid=Integer.parseInt(request.getParameter("pid"));
				int cusid=Integer.parseInt(request.getParameter("cusid"));
				boolean flag=CartDAO.checkProductIntoCart(pid,cusid);
				boolean flag1=true;
				if(flag==true) {	
					System.out.println("product alreday add..");
					response.sendRedirect("coustomer_index.jsp");
				}
				else {
						CartDAO.insertIntoCart(c);
						response.sendRedirect("coustomer_index.jsp");
				}
			}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("remove")) {
			Cart c=new Cart();
			c.setPid(Integer.parseInt(request.getParameter("pid")));
			
		}
		
	}

}
