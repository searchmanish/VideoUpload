<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		$image = $_POST['image'];
                 $name = $_POST['name'];
	
		
		$path = "uploads/$name.mp4";
		
		
			file_put_contents($path,base64_decode($image));
			echo "Successfully Uploaded";
	
	}else{
		echo "Error";
	}
	?>


