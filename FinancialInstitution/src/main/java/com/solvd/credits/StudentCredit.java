package main.java.com.solvd.credits;

import main.java.com.solvd.people.Client;

public class StudentCredit extends Credit{
	private String studentName;
	private int studentFileNumber;
	private String career;
	private int careerDuration;
	
	public StudentCredit() {}
	
	public StudentCredit(int id, float amount, float interest, int fees, Client applicant, String studentName, int studentFileNumber, String career, int careerDuration) {
		super (id, amount, interest, fees, applicant);
		this.studentName = studentName;
		this.studentFileNumber = studentFileNumber;
		this.career = career;
		this.careerDuration = careerDuration;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentFileNumber() {
		return studentFileNumber;
	}

	public void setStudentFileNumber(int studentFileNumber) {
		this.studentFileNumber = studentFileNumber;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public int getCareerDuration() {
		return careerDuration;
	}

	public void setCareerDuration(int careerDuration) {
		this.careerDuration = careerDuration;
	}
	

	
}
