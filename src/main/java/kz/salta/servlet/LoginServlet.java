package kz.salta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kz.salta.model.User;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("title", "Welcome");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		
		if(username!=null && password!=null) {
			User user=new User(username,password);
			if(user.authValidate()) {
				rd=req.getRequestDispatcher("jsp/success.jsp");
				req.setAttribute("title", "Main Page");
				req.setAttribute("user", user);
			}else {
				System.out.println("Error");
			}
		}
		
		
		System.out.println(username+" "+password);
		rd.forward(req, resp);
	}

}
