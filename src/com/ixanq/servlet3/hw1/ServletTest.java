package com.ixanq.servlet3.hw1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		StudentDao studentDao = new StudentDao();
		Student stu = studentDao.queryByNameAndPassword(name,password);
		req.setAttribute("student",stu);
		if(stu==null){
			//��¼ʧ��,����ת������ҳ��
			req.getRequestDispatcher("hw1.html").forward(req, resp);
		}else{
			//��¼�ɹ�,�ض���result.htmlҳ��
			//resp.sendRedirect("result.html");
            req.getRequestDispatcher("hw1.html").forward(req, resp);
		}
	}
}







