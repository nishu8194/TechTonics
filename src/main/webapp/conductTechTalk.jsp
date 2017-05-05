<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Conduct Tech Talks</title>
 
      <link rel="stylesheet" href="css/style.css">

</head>

<body>
  <%String email=request.getParameter("email"); 
  	String[] name=email.split("@");
  	String finalName="";
  	if(name[0].contains(".")){
  		finalName=name[0].replaceAll("\\.", " ");
  	}
  	else{
		finalName=name[0];  		
  	}
  	
  %>
<div class="container">
	<section id="content">
		<form action="conductTechTalkServlet" method="post">
			<h1>Fill Details</h1>
			<div>
				<span style="font-size: large;color:gray;"><b>Employee Id :</b> </span> <input type="text" style="font-size: large;color:black" name="empId" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Topic :</b> </span> <input type="text" style="font-size: large;color:black" name="topic" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Date :</b> </span> <input type="text" style="font-size: large;color:black" name="date"  required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Day :</b> </span> <input type="text" style="font-size: large;color:black" name="day" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Name Of Presentor :</b> </span> <input type="text" style="font-size: large;color:black" name="presentor" value="<%=finalName %>" readonly="readonly" required />
			</div>
			<div>
				<input style="margin-left: 120px;font-size: x-large;" type="submit" value="Request" />
				
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="TechTalkDetails.jsp">BACK</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->

    <script src="js/index.js"></script>

</body>
</html>
