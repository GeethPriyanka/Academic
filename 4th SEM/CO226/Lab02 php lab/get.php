<html>
<head> <title>My First </title></head>

<body>
 <h1> University of Peradeniya </h2>
 <br> </br>

<?php
	
	if (isset($_GET['username'])){		
		$username=$_GET['username'];
	}
	if (isset($_GET['password'])){		
		$password=$_GET['password'];
	}
	
	
	$username=$_GET['username'];
	$password=$_GET['password'];
	
	echo "<h2> ".$username." login success </h2>";
	
	if (isset($_GET['subject'])){		
		$subject=$_GET['subject'];
	}
	else{
		$size='';
	}
	
	$degree=$_GET['degree'];
	echo "<p>Selected subject area is ".$subject."</p>";
	echo "<p>Your degree program is ".$degree."</p>";
	
?>
</body>

</html>