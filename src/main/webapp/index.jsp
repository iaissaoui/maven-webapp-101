<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<%@page import="java.util.*"%>
<%@page import="model.Task"%>


<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="todo.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<!-- <script src="todo.js"></script>  -->
<body>
	<div class="form-group">
		<h1>
			To-Do <small>List</small>
		</h1>
		<form id="form101" role="form" method="POST" action="Main">
			<input type="text" class="form-control" placeholder="Your Task"
				name="task"> <input type="hidden" class="form-control"
				name="action" value="add">
		</form>
		<button type="submit" form="form101" type="button"
			class="btn btn btn-primary">Add</button>
	</div>
	<div></div>

	<div>
		<ul class="list-group">


					<%  Set<Task> L =  (HashSet<Task>) request.getSession().getAttribute("list"); System.out.println(L);%> 



			<c:forEach var="item" items="${sessionScope.list}">
				<li class="list-group-item"><c:out value="${item.name}" />

					<form id="${item.name}" role="form" method="POST" action="Main">
						<input type="hidden" class="form-control" name="action"
							value="remove">
						<input type="hidden" class="form-control"
							name= "task" value="${item.name}">
					</form>
					<button type="submit" form="${item.name}" type="button"
						class="btn btn btn-primary">Delete</button>
				</li>
			</c:forEach>

		</ul>

	</div>

	<ul class="list-unstyled" id="todo"></ul>
</body>