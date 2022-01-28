package net.javaservelet.registration.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaservelet.registration.dao.UserDao;
import net.javaservelet.registration.model.User;
/**
 * Servlet implementation class Userservelet
 */
@WebServlet("/register")
public class Userservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userdao = new UserDao();
	
	

    /**
     * Default constructor. 
     **/
    
	public Userservelet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String username= request.getParameter("username");
		String mobile_no= request.getParameter("mobile_no");
		String city= request.getParameter("city");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		
		User user = new User();
		user.setName(name);
		user.setUsername(username);
		user.setMobile_no(mobile_no);
		user.setCity(city);
		user.setEmail(email);
		user.setPassword(password);
		
		try{userdao.register(user);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("");
	}

}
