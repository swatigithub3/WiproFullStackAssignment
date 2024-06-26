<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Confirmation</title>
</head>
<body>
<h2>Claim Submitted Successfully</h2>
<p>Thank you, <strong>${claim.claimantName }</strong>, for submitting your claim.</p>
<p>Claim Type: <strong>${claim.claimType }</strong></p>
<p>Claim Amount: <strong>${claim.claimAmount}</strong></p>

</body>
</html>