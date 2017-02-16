package kz.salta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import kz.salta.dao.StudentDao;
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
    	System.out.println("Method type: "+request.getMethod());
    	String name=(request.getParameter("name")!=null && !request.getParameter("name").isEmpty())?request.getParameter("name"):"";
    	System.out.println("Parameter: "+request.getParameter("name"));
    	
    	ArrayList<Student> students = StudentDao.findByName(name);
    	request.setAttribute("students", students);
    	RequestDispatcher rd=request.getRequestDispatcher("jsp/success.jsp");
    	rd.forward(request, response);
    }

}
