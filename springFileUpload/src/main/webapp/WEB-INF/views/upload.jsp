<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RPA</title>
</head>
<body>
	<form name="fileForm" action="requestupload2" method="post" enctype="multipart/form-data">
		<input multiple="multiple" type="file" name="file" />
		<input type="text" name="src" />
		<input type="submit" value="전송" />
		
		<input type="button" action="prago" value="시작">
	</form>
	

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
//$("#start").click(function(){
//	$.ajax({
//		type:"POST"
//		url:"./rpaok.jsp"
//		success:function(result){
//			alert(data);
//		}
//	})
//})

</script>
</html>


