package model;

public class AdminModel{
	
	private int StudentId;
	private String StudentName;
	private int Marks;
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminModel(int StudentId, String StudentName,int marks) {
		super();
		this.StudentId = StudentId;
		this.StudentName = StudentName;
		this.Marks=marks;

		
//Encapsulation
		
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int StudentId) {
		this.StudentId = StudentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int Marks) {
		this.Marks = Marks;
	}

}
	