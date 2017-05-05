package AllServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Connection connection=DatabaseConnection.getConnection();
		Statement statement;
		try {
			boolean check=true;
			statement = connection.createStatement();
			ResultSet resultSet=statement.executeQuery("select * from userstable where email='"+email+"' ");
			HttpSession session = request.getSession();
			if(resultSet!=null){
						
				while(resultSet.next())
				{
					
					String dbpassword=resultSet.getString("Password");
					String TypeOfUser=resultSet.getString("TypeOfUser");
					if(dbpassword.equals(password)){
						
						
						if(TypeOfUser.equals("emp")) {
							check=false;
							session.setAttribute("email", email);
							request.getRequestDispatcher("TechTalkDetails.jsp").forward(request, response);
						}
						else {
							check=false;
							session.setAttribute("email", email);
							request.getRequestDispatcher("admin.jsp").forward(request, response);
						}
						
					}//end of if(dbpassword.equals(password))...
					
				}//end of while(resultSet.next())...
				
				if(check){
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}//end of if(resultSet!=null)...
			
			else{
				System.out.println("in else");
				session.setAttribute("email", "You are Not Registered");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			System.out.println("in SQLException");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}//end of doPost method......

}//end of class loginServlet.............
