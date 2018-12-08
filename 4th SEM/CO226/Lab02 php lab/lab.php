<html>
	<head><title>Lab exercise</title></head>
	
	<body>
	<h1>Your Information System</h1>
	
<?php
	
	if (isset($_GET['firstname'])){		
		$firstname=$_GET['firstname'];
	}
	
	$firstname=$_GET['firstname'];

	echo "<p>Thank you ".$firstname." for your purchase from our website</p>";
	
?>
	
	
	
	
	
	
	</body>




</html>