package Model;

public class Product {
		private int pid, sid;
		private String pname,image,pcategory;
		private double price;
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getPcategory() {
			return pcategory;
		}
		public void setPcategory(String pcategory) {
			this.pcategory = pcategory;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Product [pid=" + pid + ", sid=" + sid + ", pname=" + pname + ", image=" + image + ", pcategory="
					+ pcategory + ", price=" + price + "]";
		}
		
		
		
		
}
