<html>
<h1>Success</h1>
<body>
<?php
if(isset($_GET['username'])){
	$username = $_GET['username'];
}
if(isset($_GET['password'])){
	$password = $_GET['password'];
}
$username = $_GET['username'];
$password = $_GET['password'];
echo "<p>You are ".$username." and login success</p>" ;
?>
</body>
</html>