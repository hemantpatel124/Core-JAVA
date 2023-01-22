package tController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import tDAO.AdminDAO;
import tDAO.BillingDAO;
import tModel.Bill_Generate; 

/**
 * Servlet implementation class BillingController
 */
@WebServlet("/BillingController")
public class BillingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingController() {
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
				
				if(action.equalsIgnoreCase("bill_generat")) {
					Bill_Generate b=new Bill_Generate();
					
					String date_time=AdminDAO.getLocalDateTime();
					b.setDobg(date_time);
					b.setProperty_tax(Integer.parseInt(request.getParameter("ptax")));
					b.setWater_charge(Integer.parseInt(request.getParameter("wchg")));
					b.setDrainage_charge(Integer.parseInt(request.getParameter("dchg")));
					b.setStreetlight_charge(Integer.parseInt(request.getParameter("slchg")));
					b.setFire_charge(Integer.parseInt(request.getParameter("fchg")));
					b.setOther_charge(Integer.parseInt(request.getParameter("ochg")));
					b.setTotal_amount(Integer.parseInt(request.getParameter("total_amount")));
					
					BillingDAO.generateBill(b);
					
					
					
					response.sendRedirect("admin_index.jsp");
				}
				
	}

}
