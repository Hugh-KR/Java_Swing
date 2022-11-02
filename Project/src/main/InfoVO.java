package main;

public class InfoVO {
	private int id;
	private String name;
	private int grade;
	private String state;
	private String college;
	private String major;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "InfoVO [id=" + id + ", grade=" + grade + ", state=" + state + ", college=" + college + ", major="
				+ major + "]";
	}
	
	
}
