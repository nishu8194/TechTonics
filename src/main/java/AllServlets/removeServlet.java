package AllServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class removeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public removeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object empId=request.getParameter("id");
		Connection connection=DatabaseConnection.getConnection();
		try {
			Statement statement=connection.createStatement();
			int removed=statement.executeUpdate("delete from alltechtalks where EmpId="+empId);
			if(removed!=0){
				request.setAttribute("removeInfo", "Tech Talk Deleted successfully!");
				response.sendRedirect("admin.jsp");
				 
			}
			else
			{
				System.out.println("Some problem in Deletion");					
				response.sendRedirect("admin.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DatabaseConnection.close();
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
