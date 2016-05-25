package com.guitar.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.DAO.DaoImple;
import com.guitar.DAO.IDAO;

@WebServlet("/AddGuitarServlet")
public class AddGuitarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddGuitarServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String serialNumber = request.getParameter("serialNumber");
		String builder = request.getParameter("builder");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String backWood = request.getParameter("backWood");
		String topWood = request.getParameter("topWood");
		String price = request.getParameter("price");
		
		if(!serialNumber.equals("") && serialNumber!=null && !price.equals("") && price!=null){
			System.out.println(serialNumber);
			IDAO dao = new DaoImple();
			dao.addGuitar(serialNumber, builder, model, type, backWood, topWood, price);
			out.print(1); 
		}else{
			out.print("请正确输入信息！");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
