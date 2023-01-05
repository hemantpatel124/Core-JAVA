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
import Model.Wishlist;

/**
 * Servlet implementation class WishlistController
 */
@WebServlet("/WishlistController")
public class WishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action=request.getParameter("action");
			if(action.equalsIgnoreCase("addtowishlist")) {
				Wishlist w=new Wishlist();
				w.setPid(Integer.parseInt(request.getParameter("pid")));
				w.setCusid(Integer.parseInt(request.getParameter("cusid")));
				
				int pid=Integer.parseInt(request.getParameter("pid"));
				int cusid=Integer.parseInt(request.getParameter("cusid"));
				boolean flag=WishlistDAO.checkProductIntoWishlist(pid,cusid);
				if(flag==true) {
					System.out.println("already add in wishlist..");
					response.sendRedirect("coustomer_index.jsp");
				}
				else {
						WishlistDAO.insertIntoWishlist(w);
						response.sendRedirect("coustomer_index.jsp");
				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
