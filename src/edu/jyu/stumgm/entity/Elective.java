package edu.jyu.stumgm.entity;

public class Elective {
	private int keyId;
	private String courseId;
	private String studentId;
	private float grade;
	private int close;
	
	@Override
	public String toString() {
		return "Elective [keyId=" + keyId + ", courseId=" + courseId
				+ ", studentId=" + studentId + ", grade=" + grade + ", close="
				+ close + "]";
	}
	public Elective() {
		
	}
	public Elective(String courseId, String studentId, float grade, int close) {
		this.courseId = courseId;
		this.studentId = studentId;
		this.grade = grade;
		this.close = close;
	}
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public int getClose() {
		return close;
	}
	public void setClose(int close) {
		this.close = close;
	}
	
}
