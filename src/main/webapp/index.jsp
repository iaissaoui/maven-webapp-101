<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" href="todo.css"> 
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<!-- <script src="todo.js"></script>  -->
<body>
    <div class="form-group">
      <h1>To-Do <small>List</small></h1>
    <form id="form101" role="form" method="POST" action="Main">
        <input type="text" class="form-control" placeholder="Your Task" name="task">
    </form>
    <button type="submit" form="form101" type="button" class="btn btn btn-primary">Add</button>
     </div>
        <div></div>
    <ul class="list-unstyled" id="todo"></ul>
</body>