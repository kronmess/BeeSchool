package beeoop;

public class Subject {
private String name;
private String category;
private String id;
	
	public Subject(){
		this.name = "";
		this.category = "";
		this.id = "";
	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String category){
		this.category = category;
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
}
