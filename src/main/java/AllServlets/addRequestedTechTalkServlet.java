package AllServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class addRequestedTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public addRequestedTechTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=DatabaseConnection.getConnection();	
		try {					
			int empID=Integer.parseInt(request.getParameter("id"));				
			Statement statement=connection.createStatement();
			String query="select * from requesttechtalk where EmpID="+empID;		
			ResultSet resultSet=statement.executeQuery(query);			
			String topic="";
			String date="";
			String day="";
			String presentor="";
			
			while(resultSet.next()){
					topic=resultSet.getString(2);
					date=resultSet.getString(3);
					day=resultSet.getString(4);
					presentor=resultSet.getString(5);			
			  }
					PreparedStatement preparedStatement=connection.prepareStatement("insert into alltechtalks values(?,?,?,?,?)");
					preparedStatement.setInt(1, empID);
					preparedStatement.setString(2, topic);
					preparedStatement.setString(3, date);
					preparedStatement.setString(4, day);
					preparedStatement.setString(5, presentor);
					
					if(preparedStatement.executeUpdate()!=0)
					{
						request.setAttribute("addInfo", "New Tech Talk Added successfully!");
						statement.executeUpdate("delete from requesttechtalk where EmpID="+empID);						
						request.getRequestDispatcher("admin.jsp").forward(request, response);
						 
					}
					else
					{
						System.out.println("Some problem in registration");
						request.getRequestDispatcher("admin.jsp").forward(request, response);
					}
			
			
		} //end of try...
		catch (SQLException e) {
			
			e.printStackTrace();
		}//end of catch..
	
	}

}
