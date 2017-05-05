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


public class updateTechTalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateTechTalk() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empID=Integer.parseInt(request.getParameter("empID"));
		String topic=request.getParameter("topic");
		String date=request.getParameter("date");
		String day=request.getParameter("day");
		String presentor=request.getParameter("presentor");
			
		Connection connection=DatabaseConnection.getConnection();
		try {			
					String query="update alltechtalks set EmpID="+empID+" , Topic='"+topic+"', Date='"+date+"',Day='"+day+"' ,Presentor='"+presentor+"' "+"where EmpId="+empID+";";
					
					Statement statement=connection.createStatement();
					
					int inserted=statement.executeUpdate(query);
					
					if(inserted!=0)
					{
						request.setAttribute("addInfo", "Tech Talk Updated successfully!");
						response.sendRedirect("admin.jsp");
						 
					}
					else
					{
						System.out.println("Some problem in Updation");					
						response.sendRedirect("admin.jsp");
					}
			
			
		} //end of try...
		catch (SQLException e) {
			DatabaseConnection.close();
			e.printStackTrace();
		}//end of catch..
	
		
	}

}
