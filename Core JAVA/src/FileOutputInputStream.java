import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputInputStream {
	
	public static void main(String[] args) throws IOException{
		
		String s="Hemant B Patel";
		FileOutputStream fout=new FileOutputStream("text1.txt");
		byte[] b=s.getBytes();
		fout.write(b);
		fout.flush();
		fout.close();
		System.out.println("file written successfully");
		
		FileInputStream fin=new FileInputStream("text1.txt");
		int i;
		while((i=fin.read())!=-1) {
			System.out.print((char)i);
		}
	}
}
