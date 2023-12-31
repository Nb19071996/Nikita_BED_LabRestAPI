<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Students Directory</title>
</head>

<body>

	<div class="container">

		<h3>Students Directory</h3>
		<hr>

		<!-- Add student form -->
	
				<!-- Add a button -->
				<a href="/Collegefest/students/showFormForAdd"
					class="btn btn-primary btn-sm mb-3"> Add Student </a> 
					<!--<input
					type="search" name="nanameme" placeholder="First Name"
					class="form-control-sm ml-5 mr-2 mb-3" /> <input type="search"
					name="lname" placeholder="Last Name"
					class="form-control-sm mr-2 mb-3" />-->

				<!--<button type="submit" class="btn btn-success btn-sm mb-3">Search</button>-->
					<a href="/Collegefest/logout" 
					class="btn btn-primary btn-sm mb-3 mx-auto" style="float:right"> Logout </a> 

	

		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Student Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Course</th>
					<th>Category</th>
					
					<th>Action</th>
					
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Students}" var="tempStudents">
					<tr>
						<td><c:out value="${tempStudents.id}" /></td>
						<td><c:out value="${tempStudents.fname}" /></td>
						<td><c:out value="${tempStudents.lname}" /></td>
						<td><c:out value="${tempStudents.course}" /></td>
						<td><c:out value="${tempStudents.country}" /></td>
						
						<td>
							<!-- Add "update" button/link --> <a
							href="/Collegefest/students/showFormForUpdate?studentId=${tempStudents.id}"
							class="btn btn-info btn-sm"> Update </a>
							 <!-- Add "delete" button/link -->
							<a href="/Collegefest/students/delete?studentId=${tempStudents.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Student?'))) return false">
								Delete </a>

						</td>
					

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>



