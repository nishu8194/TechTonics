package AllServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public registerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");		
		Connection connection=DatabaseConnection.getConnection();
		try {
			ResultSet rs=connection.createStatement().executeQuery("select * from userstable where email="+"'"+email+"'");
			if(rs.next()){
				request.setAttribute("registrationInfo", "User already registered");
				request.getRequestDispatcher("register.jsp").forward(request, response);
	
			}
			
			else{
				String password=request.getParameter("password");
				String TypeOfUser="emp";
				
					PreparedStatement preparedStatement=connection.prepareStatement("insert into userstable values(?,?,?)");
					preparedStatement.setString(1, email);
					preparedStatement.setString(2, password);
					preparedStatement.setString(3, TypeOfUser);				
					if(preparedStatement.executeUpdate()!=0)
					{
						request.setAttribute("registrationInfo", "You have Successfully Registered! You can SignIn now");
						request.getRequestDispatcher("login.jsp").forward(request, response);
						 
					}
					else
					{
						System.out.println("Some problem in registration");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}
			}
			
		} //end of try...
		catch (SQLException e) {
			
			e.printStackTrace();
		}//end of catch..
	}

}
