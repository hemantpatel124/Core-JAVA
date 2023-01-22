package cDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cDatabase.CDBConnection;
import cModel.Exam;
import cModel.Subject;

public class ExamDAO {

	public static void insertQuestion(Exam e1) {
			
			try {
					Connection con=CDBConnection.createConnection();
					String sql="insert into questions_master (subid,question,option1,option2,option3,option4,correct_answer) values(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setInt(1, e1.getSubid());
					ps.setString(2, e1.getQuestion());
					ps.setString(3, e1.getOption1());
					ps.setString(4, e1.getOption2());
					ps.setString(5, e1.getOption3());
					ps.setString(6, e1.getOption4());
					ps.setString(7, e1.getCorrect_answer());
					ps.executeUpdate();
					System.out.println("Qustion Add successfull...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static List getQuestionListBySubId(int q){
		ArrayList<Exam> que_list=new ArrayList<Exam>();
		try {
					Connection con=CDBConnection.createConnection();
					String sql="select *from questions_master where subid=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,q);
					ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
						Exam e=new Exam();
						e.setQid(rs.getInt("qid"));
						e.setSubid(rs.getInt("subid"));
						e.setQuestion(rs.getString("question"));
						e.setOption1(rs.getString("option1"));
						e.setOption2(rs.getString("option2"));
						e.setOption3(rs.getString("option3"));
						e.setOption4(rs.getString("option4"));
						e.setCorrect_answer(rs.getString("correct_answer"));

						
						que_list.add(e);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return que_list;
		}
		
	public static void getResult(Exam e) {
		try {
			
			
					
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
		
	

}
