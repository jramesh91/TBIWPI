<html>
<head>
<title>Registration Form</title>
<style type="text/css">
h3{font-family: Calibri; font-size: 22pt; font-style: normal; font-weight: bold; color:SlateBlue;
text-align: center; text-decoration: underline }
table{font-family: Calibri; color:white; font-size: 11pt; font-style: normal;width: 50%;
text-align:; background-color: SlateBlue; border-collapse: collapse; border: 2px solid navy}
table.inner{border: 0px}
</style>
</head>
 
<body>
<h3>Student Registration Form</h3>
<form action="RegisterServlet" method="POST">
 
<table align="center" cellpadding = "10">
 
<tr>
<td>Email</td>
<td><input type="text" name="email" maxlength="100" /></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
 
</form>
 
</body>
</html>