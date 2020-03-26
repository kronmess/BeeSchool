package beeoop;

public class Score {
	private String id;
	private int grade;
	private Subject subject;
	
	public Score() {
		this.id = "";
		this.grade = 0;
		this.subject = new Subject();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
