package beeoop;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
	Scanner ohyeah = new Scanner(System.in);
	private ArrayList<Subject> subjects = new ArrayList<Subject>();
	private ArrayList<Student> students = new ArrayList<Student>();
	int subjectCount = 1;	
	int studentCount = 1;
	int scoreCount = 1;
	public void insertSubject() {
		Scanner subjectInput = new Scanner(System.in);
		Subject subject = new Subject();
		while(true) {
		System.out.println("Input subject name [3-25 characters | must end with 'Subject']: ");
		String subjectName = subjectInput.nextLine();
		
		if(subjectName.length() >= 3  && subjectName.length() <= 25 && subjectName.endsWith(" Subject")) {
			for(Subject s : subjects) {
				if(s.getName().equals(subjectName)) {
					System.out.println("This subject already exists!");
		}
		}
			subject.setName(subjectName);
			break;
		}
		
		

		}
		while(true) {
			System.out.println("Input subject category [Main | Elective]: ");
			String subjectCategory = subjectInput.nextLine();
			if(subjectCategory.equals("Main") || subjectCategory.equals("Elective")) {
				subject.setCategory(subjectCategory);
				break;
			}
		}
		String ID = "SB" + 0 + 0 + subjectCount++;
		
		subject.setId(ID);
		this.subjects.add(subject);
		System.out.println("Inserted new subject");
	}
	
	public void viewSubject() {
		if(this.subjects.size() == 0) {
			System.out.println("No Data");
		}else {
			System.out.println("Subject ID       Subject Name          Subject Category");
			System.out.println("=============================================================");
			for(Subject subject : this.subjects) {
				System.out.println(subject.getId() +"           " + subject.getName() +  "           " + subject.getCategory());
			}
		}
		
	}
	public void insertStudent() {
		Student student = new Student();
		while(true) {
			System.out.println("Input student name [3-25 characters]: ");
			String studentName = ohyeah.next();
			if(studentName.length() > 3 && studentName.length() < 25) {
				student.setName(studentName);
				break;
			}
		}
		while(true) {
			System.out.println("Input student gender [Male | Female]");
			String studentGender = ohyeah.next();
			if(studentGender.equals("Male") || studentGender.equals("Female")) {
				student.setGender(studentGender);
				break;
			}
		}
		String ID = "ST" + 0 + 0 + studentCount++;
		student.setId(ID);
		this.students.add(student);
		System.out.println("Inserted new student");
	}
	public void viewStudent() {
		if(this.students.size() == 0) {
			System.out.println("No Data");
		}else {
			System.out.println("Student ID       Student Name          Student Gender");
			System.out.println("=============================================================");
			for(Student student : this.students) {
				System.out.println(student.getId() +"           " + student.getName() +  "           " + student.getGender());
			}
		}
	}
	public void insertStudentScore() {
		if (this.students.size() != 0 && this.subjects.size() != 0) {
			System.out.println("Student Data:");
			viewStudent();
			System.out.println("Subject Data:");
			viewSubject();
			Student student;
			studentCheck:
			while(true) {
				System.out.println("Enter student id:");
				String ID = ohyeah.next();
				for(Student st : students) {
					if(ID.equals(st.getId())){
						student  = st;
						break studentCheck;
					}
				}
			}
		
		Subject subject = null;
		while (true){
			System.out.println("Enter subject id: ");
			String subjectID  = ohyeah.next();
			boolean check = false;
			for(Subject s : this.subjects) {
				if(s.getId().equals(subjectID)) {
					subject = s;
					check = true;
					break;
				}
			}
			if (check = true) {
				if(student.getScore(subjectID) != 0){
					System.out.println("Subject score already inserted!");
				}else{
					break;
				}
			}
		}
		Score score = new Score();
		score.setSubject(subject);
		while(true)
		{
			System.out.println("Input score [0-100]: ");
			int inputScore = ohyeah.nextInt();
			if (inputScore >= 0 && inputScore <= 100)
			{
				score.setGrade(inputScore);
				break;
			}
		}
		String ID = "SC" + 0 + 0 + scoreCount++;
		score.setId(ID);
		student.setScore(score);
		System.out.println("Inserted score!");
	}
		else {
			System.out.println("Student data and Subject data must exists");
		}
	}
	public void viewStudentScore() {
		for (Student student : this.students) {
			viewStudent();
			System.out.println("Scores: ");
			System.out.println("-----------------------------------------------------------------");
			if (student.getScoreList().size() == 0) {
				System.out.println("No data");
			}
			else
			{
				for (Score score : student.getScoreList())
				{	
					System.out.println("Score ID       Subject Name         Subject Score");
					System.out.println(score.getId() + "		" + score.getSubject().getName() + "            " + Integer.toString(score.getGrade()));
				}
			}
			System.out.println("=============================================================");
		}
	}
	
		public void mainMenu() {
	while(true) {
		System.out.println("Bee School");
		System.out.println("========================");
		System.out.println("1. Insert New Subject");
		System.out.println("2. View All Subject");
		System.out.println("3. Insert New Student");
		System.out.println("4. View All Student");
		System.out.println("5. Insert Student Score");
		System.out.println("6. View Student Score");
		System.out.println("7. Exit");
		int choice = ohyeah.nextInt();
		
		if(choice > 7 || choice < 1) {
			System.out.println("Please choose a number between 1 and 7");
			}
		if(choice == 1) {
			insertSubject();
			
			}
		if(choice == 2) {
			viewSubject();
		}
		if(choice == 3) {
			insertStudent();
		}
		if(choice == 4) {
			viewStudent();
		}
		if(choice == 5) {
			insertStudentScore();
		}
		if(choice == 6) {
			viewStudentScore();
		}
		if(choice == 7) {
			System.exit(0);
			}
	
		
		}	
	}
	public static void main(String[] args) {
		School newSchool = new School();
		newSchool.mainMenu();
		
		
		
	}

}
