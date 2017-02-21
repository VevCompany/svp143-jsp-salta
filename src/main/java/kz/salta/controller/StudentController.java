package kz.salta.controller;

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
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Method type: "+request.getMethod());
    	
    	boolean newStudent = request.getParameter("newRecord")!=null?(request.getParameter("newRecord").equals("1")?true:false):false;
    	int id = request.getParameter("id")!=null ? Integer.parseInt(request.getParameter("id")):0;
    	
    	if(newStudent==true) {
    		createStudent(request,response);
    	}
    	else if(!newStudent && id!=0) {
    		System.out.println("update");
    		updateStudent(request,response);
    	}
    	
    	String name=(request.getParameter("name")!=null && !request.getParameter("name").isEmpty())?request.getParameter("name"):"";
    	System.out.println("Parameter: "+request.getParameter("name"));
    	
    	ArrayList<Student> students = StudentDao.findByName(name);
    	request.setAttribute("students", students);
    	RequestDispatcher rd=request.getRequestDispatcher("jsp/success.jsp");
    	rd.forward(request, response);
    }
    
    protected void createStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String name=(request.getParameter("name")!=null && !request.getParameter("name").isEmpty())?request.getParameter("name"):"";
    	if(!name.isEmpty()) {
    		System.out.println("cretae");
    		Student student=new Student(4L,request.getParameter("name"),request.getParameter("group_name"), Byte.parseByte(request.getParameter("age")));
    		StudentDao.createStudent(student);
    	}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("jsp/edit.jsp");
    		request.setAttribute("newRecord", 1);
    		request.setAttribute("id", 0);
    		request.setAttribute("name", "");
    		request.setAttribute("group_name", "");
    		request.setAttribute("age", "");
    		rd.forward(request, response);
    	}
    }
    
    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	Student student = StudentDao.getStudentById(Long.parseLong(request.getParameter("id")));
    	String name=(request.getParameter("name")!=null && !request.getParameter("name").isEmpty())?request.getParameter("name"):"";
    	if(!name.isEmpty()) {
    		System.out.println("update1");
    		StudentDao.updateStudent(student);
    	}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("jsp/edit.jsp");
    		request.setAttribute("newRecord", 0);
    		request.setAttribute("id", student.getId());
    		request.setAttribute("name", student.getName());
    		request.setAttribute("group_name", student.getGroupName());
    		request.setAttribute("age", student.getAge());
    		rd.forward(request, response);
    	}
    }

}
