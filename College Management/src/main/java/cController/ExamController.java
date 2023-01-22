package cController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cDAO.ExamDAO;
import cDAO.StudentDAO;
import cModel.Exam;
import cModel.Student;
import cModel.Subject;

/**
 * Servlet implementation class ExamController
 */
@WebServlet("/ExamController")
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExamController() {
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
		
		if(action.equalsIgnoreCase("add_qustion")) {
			
			Exam e=new Exam();
			e.setSubid(Integer.parseInt(request.getParameter("subid")));
			e.setQuestion(request.getParameter("question"));
			e.setOption1(request.getParameter("option1"));
			e.setOption2(request.getParameter("option2"));
			e.setOption3(request.getParameter("option3"));
			e.setOption4(request.getParameter("option4"));
			e.setCorrect_answer(request.getParameter("correct_answer"));
			
			
			ExamDAO.insertQuestion(e);
			response.sendRedirect("faculty_add_exam.jsp");
		}
		else if(action.equalsIgnoreCase("submit_exam")) {
			Exam e=new Exam();
			e.setQid(Integer.parseInt(request.getParameter("qid")));
			e.setCorrect_answer(request.getParameter("qid"));
			ExamDAO.getResult(e);
		}
		
		
	}

}
