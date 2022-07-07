<%@ taglib prefix="form" uri ="http://www.springframework.org/tags/form"%>
<html>
   <head>
      <title>Add Customer</title>
   </head>

   <body>
      <h1 style="background-color:powderblue;">Customer Relationship Management</h1>
      <h2>Save Customer</h2>

      <form:form method = "POST" action = "registerCustomer" >
         <table>
            <!--tr>
                <td><form:label path = "id">Id</form:label></td>
                <td><form:input path = "id" /></td>
            </tr-->
            <form:hidden path="id" />
            <tr>
               <td><form:label path = "fname">First Name</form:label></td>
               <td><form:input path = "fname" /></td>
            </tr>
            <tr>
               <td><form:label path = "lname">Last Name</form:label></td>
               <td><form:input path = "lname" /></td>
            </tr>
			<tr>
               <td><form:label path = "email">Email</form:label></td>
               <td><form:input type="email"  path = "email" /></td>
            </tr>

            <tr>
               <td></td>
               <td >
                  <input type = "submit" value = "Save"/>
               </td>
            </tr>
         </table>
      </form:form>
      <br>
      <a href="list">Back to List</a>
   </body>

</html>