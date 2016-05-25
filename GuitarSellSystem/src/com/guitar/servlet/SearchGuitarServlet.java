package com.guitar.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.guitar.DAO.DaoImple;
import com.guitar.DAO.IDAO;
import com.guitar.beans.Guitar;


@WebServlet("/SearchGuitarServlet")
public class SearchGuitarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchGuitarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/x-json");  
	    response.setCharacterEncoding("UTF-8");  
	    response.setHeader("Cache-Control", "no-cache");  
		PrintWriter out=response.getWriter();
		IDAO dao = new DaoImple();
		List<Guitar> list = new ArrayList<Guitar>();
		list = dao.guitars();
		JSONArray ja=new JSONArray();
		ja.put(list);
		out.println(ja.toString());
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
