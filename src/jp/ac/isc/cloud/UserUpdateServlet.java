package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//try {
			   Connection users = null;
			   try {
			  //request.setCharacterEncoding("utf-8");
			   // Class.forName("com.mysql.jdbc.Driver");
			    //users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUn      icode=true&characterEncoding=utf8","root","");
			   users = DBConnection.openConnection();
			   String id = request.getParameter("updateId");
			    String name = request.getParameter("updatetName");
			    String picture = request.getParameter("updatePicture");
			    Statement state = users.createStatement();
			    state.executeUpdate("UPDATE INTO user_table VALUE('" + id + "','" + name +
			     "','" + picture + "')");
			    DBConnection.closeConnection(users, state);
			    //state.close();
			    //users.close();
			    response.sendRedirect("/select"); //UserSelectServletを呼び出す
			// } catch(ClassNotFoundException e) {
			  //  e.printStackTrace();
			   //}
			  } catch(SQLException e){
			   e.printStackTrace();
			  }

	}

}
