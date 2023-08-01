package model;

public class ResultModel{
	
	private int StudentId;
	private String Subject;
	private int Marks;
	public ResultModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultModel(int StudentId, String Subject,int marks) {
		super();
		this.StudentId = StudentId;
		this.Subject = Subject;
		this.Marks=marks;

		
//Encapsulation
		
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int StudentId) {
		this.StudentId = StudentId;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String Subject) {
		this.Subject = Subject;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int Marks) {
		this.Marks = Marks;
	}

}
	
