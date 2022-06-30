contentType ="text/html;
charset=ISO-8859-1";
pageEncoding="ISO-8859-1" import="java.util.List,com.greatlearning.debate.event.entity.Student";

<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>

		<h1>Student Info</h1>

		<div style="border:1px solid blue;background-color:yellow;color:blue;">
	
		<%
			
		List<student> students= (List<student>) request.getStudent("studentInfo");
		
		out.println("<table border=1><tr><th>Id</th><th>Name</th><th>Department</th><th>Country</th><th>Delete</th></tr>");
		for (student:student)
		{
			
			out.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getDepartment()+"</td><td>"+s.getCountry()+"</td><td><a href='/student-details/Student/delete-student?id="+s.getId()+"'>Delete</a></td></tr>");
		}
		
		out.println("</table>");
		%>
		
		</div>
		
		<a href="/student-details/Student/show-form">Add More..Students</a>
		
	</div>
</body>
</html>