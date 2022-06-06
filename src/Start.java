import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.management.Student;
import com.student.management.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to add student");
			System.out.println("PRESS 2 to Delete student");
			System.out.println("PRESS 3 to Display student");
			System.out.println("PRESS 4 to Exit App");
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				//add student..
				System.out.println("Enter user name: ");
				String name=br.readLine();
				System.out.println("Enter user phone: ");
				String phone=br.readLine();
				System.out.println("Enter user city: ");
				String city=br.readLine();
				
				//create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully...");
				}
				else {
					System.out.println("Something went wrong try again..");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//delete student
				System.out.println("Enter Student Id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.deleteStudent(userId);
				if(answer) {
					System.out.println("Student is deleted successfully...");
				}
				else {
					System.out.println("Something went wrong try again..");
				}
			}
			else if(c==3) {
				//display student
				StudentDao.showAll();
			}
			else if(c==4) {
				//exit
				break;
			}
			else {
				System.out.println("Please choose the correct option");
			}
		}
		System.out.println("Thankyou for using my Application...");
		System.out.println("See you soon...bye bye");

	}

}
