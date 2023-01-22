package cModel;

public class Exam {
		private int eid,dcode,subid,fid,qid;
		private String question,option1,option2,option3,option4,correct_answer,status;
		public int getEid() {
			return eid;
		}
		public void setEid(int eid) {
			this.eid = eid;
		}
		public int getDcode() {
			return dcode;
		}
		public void setDcode(int dcode) {
			this.dcode = dcode;
		}
		public int getSubid() {
			return subid;
		}
		public void setSubid(int subid) {
			this.subid = subid;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public int getQid() {
			return qid;
		}
		public void setQid(int qid) {
			this.qid = qid;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getOption1() {
			return option1;
		}
		public void setOption1(String option1) {
			this.option1 = option1;
		}
		public String getOption2() {
			return option2;
		}
		public void setOption2(String option2) {
			this.option2 = option2;
		}
		public String getOption3() {
			return option3;
		}
		public void setOption3(String option3) {
			this.option3 = option3;
		}
		public String getOption4() {
			return option4;
		}
		public void setOption4(String option4) {
			this.option4 = option4;
		}
		public String getCorrect_answer() {
			return correct_answer;
		}
		public void setCorrect_answer(String correct_answer) {
			this.correct_answer = correct_answer;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Exam [eid=" + eid + ", dcode=" + dcode + ", subid=" + subid + ", fid=" + fid + ", qid=" + qid
					+ ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3="
					+ option3 + ", option4=" + option4 + ", correct_answer=" + correct_answer + ", status=" + status
					+ "]";
		}
		
		
		
		
		
}
