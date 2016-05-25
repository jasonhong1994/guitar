package com.guitar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.guitar.beans.Guitar;

public class DaoImple implements IDAO {
	
	@Override
	public void addGuitar(String serialNumber, String builder, String model, String type, String backWood,
			String topWood, String price) {
		Connection Conn = DBUtil.open();
		String sql = "insert into Guitar(serialNumber,builder,model,type,backWood,topWood,price) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setString(2, builder);
			pstmt.setString(3, model);
			pstmt.setString(4, type);
			pstmt.setString(5, backWood);
			pstmt.setString(6, topWood);
			pstmt.setString(7, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
	}
	
	@Override
	public void delGuitar(String serialNumber) {
		Connection Conn = DBUtil.open();
		String sql = "delete from Guitar where serialNumber = ?";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
	}

	@Override
	public void updateGuitar(String serialNumber, String builder, String model, String type, String backWood,
			String topWood, String price) {
		
	}
	@Override
	public List<Guitar> guitars() {
		Connection Conn = DBUtil.open();
		String sql = "select * from Guitar";
		List<Guitar> inventory = new ArrayList<Guitar>();
		
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Guitar guitar = new Guitar();
				guitar.setSerialNumber(rs.getString(1));
				guitar.setBuilder(rs.getString(2));
				guitar.setModel(rs.getString(3));
				guitar.setType(rs.getString(4));
				guitar.setBackWood(rs.getString(5));
				guitar.setTopWood(rs.getString(6));
				guitar.setPrice(rs.getString(7));
				inventory.add(guitar);
			}
			return inventory;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
		return null;
	}

}
