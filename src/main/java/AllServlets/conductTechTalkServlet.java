package AllServlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class conductTechTalkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public conductTechTalkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int empId=Integer.parseInt(request.getParameter("empId"));
		String topic=request.getParameter("topic");
		String date=request.getParameter("date");
		String day=request.getParameter("day");
		String presentor=request.getParameter("presentor");
			
		Connection connection=DatabaseConnection.getConnection();
		try {			
				
					PreparedStatement preparedStatement=connection.prepareStatement("insert into requesttechtalk values(?,?,?,?,?)");
					preparedStatement.setInt(1, empId);
					preparedStatement.setString(2, topic);
					preparedStatement.setString(3, date);
					preparedStatement.setString(4, day);
					preparedStatement.setString(5, presentor);
					
					if(preparedStatement.executeUpdate()!=0)
					{
						request.setAttribute("conductInfo", "New Tech Talk request successfull!");
						request.getRequestDispatcher("requestSuccess.jsp").forward(request, response);
						 
					}
					else
					{
						System.out.println("Some problem in registration");
						request.getRequestDispatcher("TechTalkDetails.jsp").forward(request, response);
					}
			
			
		} //end of try...
		catch (SQLException e) {
			
			e.printStackTrace();
			request.getRequestDispatcher("TechTalkDetails.jsp").forward(request, response);
		}//end of catch..
	
	}

}
