import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDemo {
	
		public static void main(String[] args) {
			LocalDateTime now = LocalDateTime.now();
			System.out.println("Timing : "+now);
			 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");  
		        String dateTime = now.format(format);  
		        System.out.println("After Formatting: " + dateTime); 
		}
}
