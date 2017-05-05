<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="AllServlets.DatabaseConnection"%>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Update Tech Talks</title>
 
      <link rel="stylesheet" href="css/style.css">

</head>

<%  
	Object empID=request.getParameter("id");
	Connection connection=DatabaseConnection.getConnection();
	Statement statement = connection.createStatement();
	ResultSet resultSet=statement.executeQuery("select * from alltechtalks where EmpId='"+empID+"' ");
	String topic="";
	String date="";
	String day="";
	String presentor="";
	while(resultSet.next()){
		topic=resultSet.getString("Topic");
		date=resultSet.getString("Date");
		day=resultSet.getString("Day");
		presentor=resultSet.getString("Presentor");
	}
	%>
	
  <body>
<div class="container">
	<section id="content">
		<form action="updateTechTalk" method="post">
			<h1>Tech Talks Details</h1>
			<div>
				<span style="font-size: large;color:gray;"><b>Employee ID :</b> </span> <input type="text" style="font-size: large;color:black" name="empID" value="<%=empID %>" readonly="readonly" required  />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Topic :</b> </span> <input type="text" style="font-size: large;color:black" name="topic" value="<%=topic %>" placeholder="Topic" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Date :</b> </span> <input type="text" name="date" style="font-size: large;color:black" value="<%=date %>" placeholder="5 may" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Day :</b> </span> <input type="text" name="day" style="font-size: large;color:black" value="<%=day %>" placeholder="Thursday" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Presentor :</b> </span> <input type="text" name="presentor"  value="<%=presentor %>" placeholder="XYZ" required />
			</div>
			<div>
				<input style="margin-left: 120px;font-size: x-large;" type="submit" value="UPDATE" />
				
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="admin.jsp">BACK</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->

  
    <script src="js/index.js"></script>

</body>
</html>
