package com.guitar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.DAO.DaoImple;
import com.guitar.DAO.IDAO;

@WebServlet("/DelGuitarServlet")
public class DelGuitarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelGuitarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serialNumber = request.getParameter("serialNumber");
		System.out.println(serialNumber);
		IDAO dao = new DaoImple();
		dao.delGuitar(serialNumber);
		response.sendRedirect("backstage/GuitarSearch.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
