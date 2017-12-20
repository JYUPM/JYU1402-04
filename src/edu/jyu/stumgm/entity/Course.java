package edu.jyu.stumgm.entity;

public class Course {
	private int keyId; //id
	private String courseId; //课程号
	private String courseName;//课程名
	private int courseTime;	//课时
	private float courseCredit; //学分
	private int teacherId;	 //教师id
	
	public Course(){
	
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseTime() {
		return courseTime;
	}

	public void setCourseTime(int courseTime) {
		this.courseTime = courseTime;
	}

	public float getCourseCredit() {
		return courseCredit;
	}

	public void setCourseCredit(float courseCredit) {
		this.courseCredit = courseCredit;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}


	@Override
	public String toString() {
		return "Course [keyId=" + keyId + ", courseId=" + courseId
				+ ", courseName=" + courseName + ", courseTime=" + courseTime
				+ ", courseCredit=" + courseCredit + ", teacherId=" + teacherId
				+ "]";
	}
	

}
