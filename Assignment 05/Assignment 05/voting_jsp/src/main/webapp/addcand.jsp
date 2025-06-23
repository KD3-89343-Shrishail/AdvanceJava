<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> Add new Candidate</h3>
<form method="post" action="savecand.jsp">
        		<div>
			 Name:<input type="text" name="name"><br>
		</div>
        		<div>
			Party:<input type="text" name="party"><br>
		</div>
        
        		<div>
			Votes:<input type="number" name="votes"><br>
		</div>
        
        
		<div>

			<input type="submit" value="Add Candidate"> 
			
		</div>
	</form>


</body>
</html>