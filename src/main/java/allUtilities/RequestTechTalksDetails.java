package allUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import AllServlets.DatabaseConnection;

public class RequestTechTalksDetails {

	public ArrayList<TechTalksPojo> getRequestedTechTalks(){
		Connection connection=DatabaseConnection.getConnection();
		try {
			Statement statement=connection.createStatement();
			 ResultSet resultSet=statement.executeQuery("select * from requesttechtalk");
			 ArrayList<TechTalksPojo> listOfTechTalks=new ArrayList<TechTalksPojo>();
			  while(resultSet.next()){
				  TechTalksPojo techtalks=new TechTalksPojo();
				  techtalks.setEmpId(resultSet.getInt(1));
				  techtalks.setTopic(resultSet.getString(2));
				  techtalks.setDate(resultSet.getString(3));
				  techtalks.setDay(resultSet.getString(4));
				  techtalks.setPresentor(resultSet.getString(5));
				  listOfTechTalks.add(techtalks);
			  }
			  return listOfTechTalks;
			 
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
