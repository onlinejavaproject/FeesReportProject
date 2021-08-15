package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.Student;

public class StudentDao {
	
	public static void saveStudent(Student st) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con
					.prepareStatement("insert into student(name,email,gender,course,fee,paid,due,address,contact)"
							+ "values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getGender());
			ps.setString(4, st.getCourse());
			ps.setInt(5, st.getFee());
			ps.setInt(6, st.getPaid());
			ps.setInt(7, st.getDue());
			ps.setString(8, st.getAddress());
			ps.setString(9, st.getContact());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateStudent(Student st) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement(
					"update student set name=?,email=?,gender=?,course=?,fee=?,paid=?,due=?,address=?,contact=? where rollno=?");
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getGender());
			ps.setString(4, st.getCourse());
			ps.setInt(5, st.getFee());
			ps.setInt(6, st.getPaid());
			ps.setInt(7, st.getDue());
			ps.setString(8, st.getAddress());
			ps.setString(9, st.getContact());
			ps.setInt(10, st.getRollno());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudent(int rollno) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("delete from student where rollno=?");
			ps.setInt(1, rollno);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Student> getAllStudent() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student st = new Student();
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setAddress(rs.getString("address"));
				st.setContact(rs.getString("contact"));
				st.setCourse(rs.getString("course"));
				st.setGender(rs.getString("gender"));
				st.setFee(rs.getInt("fee"));
				st.setDue(rs.getInt("due"));
				st.setPaid(rs.getInt("paid"));
				st.setRollno(rs.getInt("rollno"));
				list.add(st);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static List<Student> getDues() {
		List<Student> list = new ArrayList<>();
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from student where due>0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student st = new Student();
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setAddress(rs.getString("address"));
				st.setContact(rs.getString("contact"));
				st.setCourse(rs.getString("course"));
				st.setGender(rs.getString("gender"));
				st.setFee(rs.getInt("fee"));
				st.setDue(rs.getInt("due"));
				st.setPaid(rs.getInt("paid"));
				st.setRollno(rs.getInt("rollno"));
				list.add(st);

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Student getStudentByRollNo(int rollno) {
		Student st = new Student();
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from student where rollno=?");
			ps.setInt(1, rollno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setAddress(rs.getString("address"));
				st.setContact(rs.getString("contact"));
				st.setCourse(rs.getString("course"));
				st.setGender(rs.getString("gender"));
				st.setFee(rs.getInt("fee"));
				st.setDue(rs.getInt("due"));
				st.setPaid(rs.getInt("paid"));
				st.setRollno(rs.getInt("rollno"));

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}
}
