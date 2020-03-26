package beeoop;
import java.util.ArrayList;

public class Student {
	private String name;
	private String gender;
	private String id;
	private ArrayList<Score> score;	
		public Student() {
			this.name = "";
			this.gender = "";
			this.id = "";
			this.score = new ArrayList<Score>();
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getGender() {
			return gender;
		}
		
		public void setGender(String category) {
			this.gender = category;
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		public ArrayList<Score> getScoreList()
		{
			return this.score;
		}
		public int getScore(String subjectID) {
			for (Score score : this.score) {
				if (score.getSubject().getId().equals(subjectID)){
					return score.getGrade();
				}
			}
			return 0;
		}
		public void setScore(Score score) {
			this.score.add(score);
		}
	}

