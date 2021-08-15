package com.servlet;

public class Student {
	private int rollno;
	private String name, email, gender, course;
	private int fee, paid, due;
	private String address, contact;

	public Student() {

	}

	public Student(String name, String email, String gender, String course, int fee, int paid, int due, String address,
			String contact) {

		this.name = name;
		this.email = email;
		this.gender = gender;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.contact = contact;
	}

	public Student(int rollno, String name, String email, String gender, String course, int fee, int paid, int due,
			String address, String contact) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.contact = contact;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
