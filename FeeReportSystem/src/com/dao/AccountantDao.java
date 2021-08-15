package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.servlet.Accountant;

public class AccountantDao {

	public static void saveAccountant(Accountant acc) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con
					.prepareStatement("insert into accountant(name,email,password,address,contact) values(?,?,?,?,?)");
			ps.setString(1, acc.getName());
			ps.setString(2, acc.getEmail());
			ps.setString(3, acc.getPassword());
			ps.setString(4, acc.getAddress());
			ps.setString(5, acc.getContact());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateAccountant(Accountant acc) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con
					.prepareStatement("update accountant set name=?,email=?,password=?,address=?,contact=? where id=?");
			ps.setString(1, acc.getName());
			ps.setString(2, acc.getEmail());
			ps.setString(3, acc.getPassword());
			ps.setString(4, acc.getAddress());
			ps.setString(5, acc.getContact());
			ps.setInt(6, acc.getId());
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteAccountant(int id) {
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("delete from accountant where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Accountant> getAllAccountant() {
		ArrayList<Accountant> list = new ArrayList<>();
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from accountant");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Accountant acc = new Accountant();
				acc.setId(rs.getInt("id"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPassword(rs.getString("password"));
				acc.setAddress(rs.getString("address"));
				acc.setContact(rs.getString("contact"));
				list.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Accountant getAccountantById(int id) {
		Accountant acc = new Accountant();
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from accountant where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				acc.setId(rs.getInt("id"));
				acc.setName(rs.getString("name"));
				acc.setEmail(rs.getString("email"));
				acc.setPassword(rs.getString("password"));
				acc.setAddress(rs.getString("address"));
				acc.setContact(rs.getString("contact"));

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public static boolean loginValidate(String email, String password) {
		boolean status = false;
		try {
			Connection con = DatabaseCon.getCon();
			PreparedStatement ps = con.prepareStatement("select * from accountant where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
