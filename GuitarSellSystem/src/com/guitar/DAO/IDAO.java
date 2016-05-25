package com.guitar.DAO;

import java.util.List;

import com.guitar.beans.Guitar;

public interface IDAO {
	
	public void addGuitar(String serialNumber, String builder, 
			String model, String type, String backWood, String topWood,	String price);
	
	public void delGuitar(String serialNumber);
	public void updateGuitar(String serialNumber, String builder, 
			String model, String type, String backWood, String topWood,	String price);
	public List<Guitar> guitars();
}
