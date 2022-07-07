<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Relations</title>
     <!--link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script-->
    <style>
        table, th, td {
          border: 1px solid black;
           border-collapse: collapse;
        }
        td {
          text-align: center;
        }
        table tr:nth-child(even) { background-color:#dddddd; }
        table style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;"
    </style>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h1 style="background-color:powderblue;">Customer Relationship Management</h1>
   <br>
   <br>
   <input type="button" value="Add Customer"
    onclick="window.location.href='showCustomerForm';"
    class="btn btn-primary" />
    <br/><br/>

   <!--div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Student List</div>
    </div-->

    <div class="panel-body">
     <table style="width:100%;" class="table table-striped table-bordered">
      <tr>
       <!--th>Student Id</th-->
       <th style="background-color:powderblue;">First Name</th>
       <th style="background-color:powderblue;">Last Name</th>
       <th style="background-color:powderblue;">Email</th>
       <th style="background-color:powderblue;">Action</th>


      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempCustomer" items="${customers}">

       <!-- construct an "update" link with customer id -->
       <c:url var="updateLink" value="/updateForm">
        <c:param name="customerId" value="${tempCustomer.id}" />
       </c:url>

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteLink" value="/delete">
        <c:param name="customerId" value="${tempCustomer.id}" />
       </c:url>

       <tr>
        <!--td>${tempStudent.id}</td-->
        <td>${tempCustomer.fname}</td>
        <td>${tempCustomer.lname}</td>
		<td>${tempCustomer.email}</td>

        <td>
         <!-- display the update link -->
          <a href="${updateLink}">Update</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
 <br>

</body>
</html>