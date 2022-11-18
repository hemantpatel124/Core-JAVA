/*W.A.J.P to create a class Student with attributes roll no, name, age and course. 
 Initialize values through parameterized constructor. 
 If age of student is not in between 15 and 21 then generate user defined exception "AgeNotWithinRangeException". 
 If name contains numbers or special symbols raise exception "NameNotValidException". Define the two exception classes. 
 */
package assignment;

import java.util.Scanner;

class AgeNotWithinRangeException extends Exception{
	
	public String toString(){
		return("Age is  not between 15 and 21...");
	}
}

class NamenotValidException extends Exception{
	public String validName(){
		return("Name is not  valid,  Please enter the Name: ");
	}
}



class Student{
	int rollno,age;
	String name,course;
	
	public Student(int rn, String name, int age, String course) {
		this.rollno=rn;
		this.course=course;
		
		int temp=0;
		for(int i=0;i<name.length();i++) {
			char ch;
			ch=name.charAt(i);
			
			if(ch<'A' || ch>'Z' && ch<'a' || ch>'z') 
				temp=1;
		}
		
		try {
			if(temp==1) {
				throw new NamenotValidException();
			}
			else {
				this.name=name;
			}	
		}
		catch (NamenotValidException e1) {
			System.out.println(e1);
		}
		
		
		try {
				if(age>=15 && age<=21) {
					this.age=age;
				}
				else {
					throw new AgeNotWithinRangeException();
				}
		}
		catch (AgeNotWithinRangeException e2) {
			System.out.println(e2);
		}
	}
	
	public void display() {
		System.out.println("Roll no : "+rollno+"\nName : "+name+"\nAge : "+age+"\nCourse : "+course);
	}
	
}



public class A42 {
	
	public static void main(String[] args)throws AgeNotWithinRangeException, NamenotValidException {
		
		Scanner sc=new Scanner(System.in);
		
		int rno,age;
		String name, course;
		
		System.out.println("Enter student data : ");
		System.out.println("\nEnter Roll no : ");
		rno=sc.nextInt();
		System.out.println("Enter Nane : ");
		name=sc.next();
		System.out.println("Enter Age : ");
		age=sc.nextInt();
		System.out.println("Enter course name : ");
		course=sc.next();
		
		Student s=new Student(rno, name,age,course);
		//Student s1=new Student();
		
		s.display();
	}
}
