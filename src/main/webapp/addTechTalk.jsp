<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Adding New Tech Talks</title>
 
      <link rel="stylesheet" href="css/style.css">

</head>

<body>
  <body>
<div class="container">
	<section id="content">
		<form action="addTechTalk" method="post">
			<h1>Tech Talks Details</h1>
			<div>
				<span style="font-size: large;color:gray;"><b>Tech Talk code :</b> </span> <input type="text" name="techTalkCode" placeholder="100"  required  />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Topic :</b> </span> <input type="text" name="topic" placeholder="Topic" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Date :</b> </span> <input type="text" name="date" placeholder="5 may" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Day :</b> </span> <input type="text" name="day" placeholder="Thursday" required />
			</div>
			<div>
				<span style="font-size: large;color:gray;"><b>Presentor :</b> </span> <input type="text" name="presentor" placeholder="XYZ" required />
			</div>
			<div>
				<input style="margin-left: 120px;font-size: x-large;" type="submit" value="ADD" />
				
			</div>
		</form><!-- form -->
		<div class="button">
			<a href="admin.jsp">BACK</a>
		</div><!-- button -->
	</section><!-- content -->
</div><!-- container -->
</body>
  
    <script src="js/index.js"></script>

</body>
</html>
