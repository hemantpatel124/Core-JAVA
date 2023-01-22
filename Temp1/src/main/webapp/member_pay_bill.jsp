<%@page import="tModel.*"%>
<%@page import="tDAO.*"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>E-Society - Housing Society Website Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Barlow:wght@400;500;600;700;800;900&display=swap" rel="stylesheet"> 
        
        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
    	<%
    		Member m=null;
				if(session.getAttribute("data")!=null){
					m=(Member)session.getAttribute("data");
				}
				else{
					response.sendRedirect("login.jsp");
				}
    	%>
        <!-- Top Bar Start -->
        <div class="top-bar">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-md-12">
                        <div class="logo">
                            <a href="member_index.jsp">
                                <h1>E<span>Socity</span></h1>
                                <!-- <img src="img/logo.jpg" alt="Logo"> -->
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7 d-none d-lg-block">
                        <div class="row">
                            <div class="col-4">
                                <div class="top-bar-item">
                                    
                                    
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="fa fa-phone-alt"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Call Us</h3>
                                        <p>+91 9265922471</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="top-bar-item">
                                    <div class="top-bar-icon">
                                        <i class="far fa-envelope"></i>
                                    </div>
                                    <div class="top-bar-text">
                                        <h3>Email Us</h3>
                                        <p>info@esocity.com</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Top Bar End -->

        <!-- Nav Bar Start -->
        <div class="nav-bar">
            <div class="container">
                <nav class="navbar navbar-expand-lg bg-dark navbar-dark">
                    <a href="#" class="navbar-brand">MENU</a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto">
                            <a href="member_index.jsp" class="nav-item nav-link active">Home</a>
                            <a href="member_noticeboard.jsp" class="nav-item nav-link">Notice Board</a>
                            <a href="#" class="nav-item nav-link">Event</a>
                           
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Service</a>
                                <div class="dropdown-menu">
                                    <a href="member_complain.jsp" class="dropdown-item">Register  & View Status Complain </a>
                                    <a href="member_pay_bill.jsp" class="dropdown-item">Pay Bill</a>
                                    <a href="member_payment_history.jsp" class="dropdown-item">Payment History</a>
                                    <a href="member_opinion_poll.jsp" class="dropdown-item">Opinion Poll</a>
                                </div>
                            </div>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><%=m.getName() %></a>
                                <div class="dropdown-menu">
                                    <a href="member_upadte_profile.jsp" class="dropdown-item">Profile</a>
                                    <a href="member_changpassword.jsp" class="dropdown-item">Change Password</a>
                                    <a href="logout.jsp" class="dropdown-item">Logout</a>
                                </div>
                            </div>
                            <a href="member_helpdesk.jsp" class="nav-item nav-link">HelpDesk</a>
                        </div>
                        <div class="ml-auto">
                            <a class="btn btn-custom" href="logout.jsp">Logout</a>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!-- Nav Bar End -->

		<!-- Page Header Start -->
        <div class="page-header">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <h2>Pay Bill</h2>
                    </div>
                    <div class="col-12">
                        <a href="member_index.jsp">Home</a>
                        <a href="">Bill Pay</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page Header End -->
		
	   <!-- Contact Start -->
	   <%List<Bill_Generate> bill=BillingDAO.getBill(); %>
        <div class="contact">
            <div class="container">
                <div class="section-header text-center">
                  
                 <h2>Bill Pay</h2>
                	
                <form action="BillingController" method="post">
                      			<div>
                      				<table class="table table-light table-borderless table-hover  mb-0">
                    					<thead class="thead-dark">
                        					<tr>
                        						<th>Title</th>
                        						<th>Amount</th>
                        					</tr>
                    					</thead>
                    					<%for (Bill_Generate b:bill) {%>
                    					<tbody class="align-middle">
                    					<tr>	<th class="align-middle">Property Tax</th> <td> <%=b.getProperty_tax() %></td></tr>
                            			<tr>	<th class="align-middle">Water Charge</th> <td>	<%=b.getWater_charge() %></td></tr>
                            			<tr>	<th class="align-middle">Drainage Charge</th> <td> <%=b.getDrainage_charge() %></td></tr>
                            			<tr>	<th class="align-middle">Street Light Charge</th> <td> <%=b.getStreetlight_charge() %></td></tr>
                            			<tr>	<th class="align-middle">Fire Charge</th> <td>	<%=b.getFire_charge() %></td></tr>
                            			<tr>	<th class="align-middle">Other Charge</th> <td> <%=b.getOther_charge() %></td></tr>
                            			<tr>	<th class="align-middle">Total Amount</th> <th> <%=b.getTotal_amount() %></th></tr>
                            		    
                            		    </tbody>
                            		    <%} %>
                					</table>
                      			</div>
                              
                                <div>
                                    <button class="btn btn-custom" type="submit"  name="action" value="bill_print" >Pay Bill</button>
                                </div>
                            </form>
                
                </div>
                </div>
            </div>
        
        <!-- Contact End -->
		
        <!-- Footer Start -->
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-contact">
                            <h2>Get In Touch</h2>
                            <p><i class="fa fa-map-marker-alt"></i>123 Street, New York, USA</p>
                            <p><i class="fa fa-phone-alt"></i>+012 345 67890</p>
                            <p><i class="fa fa-envelope"></i>info@example.com</p>
                            <div class="footer-social">
                                <a class="btn" href=""><i class="fab fa-twitter"></i></a>
                                <a class="btn" href=""><i class="fab fa-facebook-f"></i></a>
                                <a class="btn" href=""><i class="fab fa-youtube"></i></a>
                                <a class="btn" href=""><i class="fab fa-instagram"></i></a>
                                <a class="btn" href=""><i class="fab fa-linkedin-in"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-link">
                            <h2>Popular Links</h2>
                            <a href="">About Us</a>
                            <a href="">Contact Us</a>
                            <a href="">Our Service</a>
                            <a href="">Service Points</a>
                            <a href="">Pricing Plan</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-link">
                            <h2>Useful Links</h2>
                            <a href="">Terms of use</a>
                            <a href="">Privacy policy</a>
                            <a href="">Cookies</a>
                            <a href="">Help</a>
                            <a href="">FQAs</a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-newsletter">
                            <h2>Newsletter</h2>
                            <form>
                                <input class="form-control" placeholder="Full Name">
                                <input class="form-control" placeholder="Email">
                                <button class="btn btn-custom">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container copyright">
                <p>&copy; <a href="#">Your Site Name</a>, All Right Reserved. Designed By <a href="https://htmlcodex.com">HTML Codex</a></p>
            </div>
        </div>
        <!-- Footer End -->
        
        <!-- Back to top button -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- Pre Loader -->
        <div id="loader" class="show">
            <div class="loader"></div>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        
        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
</html>
