<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>


</head>
<body>

  <%@ include file="header.jsp" %>

	<P>Welcome : ${sessionScope.active}</P>
	<hr>

	<table id="myTable" class="table table-stripted">
		<thead>
			<tr class="success">
				<td>FirstName</td>
				<td>LastName</td>
				<td>Company</td>
				<td>Country</td>
				<td>Action</td>
			</tr>
		</thead>

		<tbody>

			<c:forEach var="emp" items="${elist}">

				<tr class="danger">
					<td>${emp.fname}</td>
					<td>${emp.lname }</td>
					<td>${emp.company }</td>
					<td>${emp.address.country }</td>
					<td>
					    <input type="submit" class="btn btn-success" onclick="editEmp(${emp.id})" value="Edit">
					    <input type="submit" class="btn btn-danger" onclick="deleteEmp(${emp.id})" value="Delete">
					</td>
				</tr>

			</c:forEach>

		</tbody>


	</table>


   <script type="text/javascript">
   
     function editEmp(id){
    	 
    	 window.location = "${pageContext.request.contextPath}/"+id+"/edit";
     }
   
     
function deleteEmp(id){
	
	   var msg = confirm("do you want to delete?");
	   
	   if(msg == true){
		   window.location = "${pageContext.request.contextPath}/"+id+"/delete";
	   }
    	 
     }
     
$(document).ready( function () {
    $('#myTable').DataTable();
} );
     
   
   </script>



</body>
</html>
