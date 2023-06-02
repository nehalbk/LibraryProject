<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Add Borrower:
<form action="addborrower" method="post">
Enter your ID: 		<input type="text" name="borrower_id"> <br>
Enter book title: 	<input type="text" name="borrower_name"> <br>
Enter class: 	<input type="text" name="borrower_class"> <br>
<button type="submit">Submit</button>
</form>
Get Borrower:
<form action="getborrower" method="get">
Enter Borrower: 		<input type="text" name="borrower_id"> <br>
<button type="submit">Submit</button>
</form>
Delete Borrower:
<form action="deleteborrower" method="post">
Enter Borrower: 		<input type="text" name="borrower_id"> <br>
<button type="submit">Submit</button>
</form>
	
</body>
</html>