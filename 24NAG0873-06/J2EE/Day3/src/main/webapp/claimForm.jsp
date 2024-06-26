<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit a Claim</title>
</head>
<body>
<h2>Enter Claim Information</h2>
<form action="submitClaim" method="post">
<label for="claimantName">Claimant Name:</label>
<input type="text" id="claimantName" name="claimantName" required><br>
<label for="claimType">Claim Type:</label>
<input type="text" id="claimType" name="claimType" required><br>
<label for="claimAmount">Claim Amount:</label>
<input type="number" id="claimAmount" name="claimAmount" required><br>
<input type="submit" value="Submit">
</form>
</body>
</html>