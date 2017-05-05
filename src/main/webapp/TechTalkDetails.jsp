<%@page import="allUtilities.TechTalksDetails"%>
<%@page import="allUtilities.TechTalksPojo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All tech talks</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript">
	function intrest(topic,date,day,person) {
		 var confirmed = confirm("Congratulations! You Are Registered To Attend The Tech Talk on "+topic+" Date :"+date+" Day :"+day+" Conducted by :"+person);	
	     return confirmed;
	}
</script>

</head>
<body>
<br><br><br><br>
<% Object email=session.getAttribute("email"); %>

<%
	TechTalksDetails techtalk=new TechTalksDetails();
	ArrayList<TechTalksPojo> listOfTechTalks= techtalk.getAllTechTalks();
%>

<nav id="myNavbar" class="navbar navbar-default navbar-inverse navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
                      
            <span class="navbar-brand">Welcome <%=email %></span>         
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="nav navbar-nav">
                <li class="active" style="margin-left: 50px"><a href="index.jsp" >Home</a></li>
                <li class="active"><a href="index.jsp" >Logout</a></li>
                <li class="active" style="margin-left: 450px"> <span class="navbar-brand"><b> EMPLOYEE</b></span>  </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <h1>All Tech Talks To be Conducted</h1>
        
        <form action="getAllTechTalks">
        	
        </form>
        
        <table style="margin-left: 50px" class="table table-hover">
        	<thead>
      <tr>
       
        <th style="font-size:x-large">Topic</th>
        <th style="font-size:x-large">Date</th>
        <th style="font-size:x-large">Day</th>
        <th style="font-size:x-large">Emp Id</th>
        <th style="font-size:x-large">Presentor</th>
        <th style="font-size:x-large">Apply</th>
      </tr>
    </thead>
    <tbody>
    <% for(TechTalksPojo techtalk2:listOfTechTalks){ 	
    	 %>
    	 <tr>
  	 		<td style="font-size:large;width:12% "> <%=techtalk2.getTopic() %></td>
    	 	<td style="font-size:large;width:12% "> <%=techtalk2.getDate() %></td>
    	 	<td style="font-size:large;width:12% "> <%=techtalk2.getDay() %></td>
    	 	<td style="font-size:large;width:12% "> <%=techtalk2.getEmpId() %></td>
    	 	<td style="font-size:large;width:12% "> <%=techtalk2.getPresentor() %></td>   	 	
    	 	<td style="width:12% "> <a href="#" onclick="return intrest('<%=techtalk2.getTopic() %>','<%=techtalk2.getDate() %>','<%=techtalk2.getDay() %>','<%=techtalk2.getPresentor() %>')" class="btn btn-success btn-lg">Intrested</a> </td>
    	 	
    	 </tr>
    <%}%>
    
   
    </tbody>
        </table>
        
        <p style="text-align: center;"><a href="conductTechTalk.jsp?email=<%=email %>" class="btn btn-success btn-lg">Conduct A Tech Talk</a></p>
    </div>
   
    <hr>
    <div class="row">
        <div class="col-sm-12">
            <footer>
               <p style="text-align: center;"><b>© Copyright 2017 ATMECS Tech Talk Portal</b></p>
            </footer>
        </div>
    </div>
</div>


</body>
</html>