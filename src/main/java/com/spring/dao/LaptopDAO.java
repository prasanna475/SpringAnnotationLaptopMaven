package com.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.Laptop;
@Repository
public class LaptopDAO {

	public void insertLaptopDetails(Laptop laptop) {
		// System.out.println("inside dao");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			pstmt = con.prepareStatement("insert into Laptop values(?,?,?)");
			pstmt.setInt(1, laptop.getModelNum());
			pstmt.setString(2, laptop.getName());
			pstmt.setInt(3, laptop.getCost());
			int i = pstmt.executeUpdate();
			System.out.println("row inserted"+laptop);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					pstmt.close();
					con.close();
				} else {
					System.out.println("connection is not opened");
				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}

	public List<Laptop> getLaptopDetails(int modelNum) {
		List<Laptop> laptopList=new ArrayList<Laptop>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "tiger");
			pstmt=con.prepareStatement("select * from Laptop where mNo=?");
			pstmt.setInt(1, 4324);
			rs=pstmt.executeQuery();
			while(rs.next()){
			Laptop laptop=new Laptop();
			laptop.setModelNum(rs.getInt("mNo"));
			laptop.setName(rs.getString("name"));
			laptop.setCost(rs.getInt("cost"));
		 laptop.setModelNum(modelNum);
		 laptopList.add(laptop);
			}	
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					if (con != null) {
						pstmt.close();
						con.close();
					} else {
						System.out.println("connection is not opened");
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		return laptopList;
	}

}
