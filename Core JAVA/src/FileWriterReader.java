import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
	
	public static void main(String[] args)throws IOException {
		
		String name="Hemant B Patel";
		
		FileWriter fw=new FileWriter("text2.txt");
		fw.write(name);
		fw.flush();
		fw.close();
		System.out.println("Written successfully");
		
		FileReader fr=new FileReader("text2.txt");
		int i;
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
		
	}
}
