package kz.salta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import kz.salta.dao.StudentList;
import kz.salta.model.Student;


/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ArrayList<Student> list = StudentList.getStudents();
    	
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	try {
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<title> </title>");
    		out.println("</head>");
    		out.println("<body>");
    		out.println("</body>");
    		out.println("<h1>Список студентов !!!</h1>");
    		out.println("</body>");
    		out.println("</head>");
    	}finally {
    		out.close();
    	}
    }

}
