
<!DOCTYPE html>
<html>
  <head>
   <meta charset="utf-8"> 




<link rel="stylesheet" href="frontend.css" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script>
function submit_form()
{
	document.getElementById("parse").submit();
}
</script>
 

 </head>

 <body>

 <h1 class="display-1 text-center"  >Minor Project</h1>
	<br>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark ">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">HOME</a>
    </li>
   <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        ABOUT
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="tech.jsp">Technologies Used</a>
        <a class="dropdown-item" href="proj.jsp">Project</a>
        <a class="dropdown-item" href="https://stanfordnlp.github.io/CoreNLP" target="_blank">References</a>
                <a class="dropdown-item" href="#">Team</a>

      </div>
    </li>
   
  </ul>
</nav> 

	<br>
	<h2 class="text-center"><pre>Named Entity Recognition
Using Stanford Parser</pre></h2>
	<br>
<div class="container">	
<form id="parse" action="ner" method="post">
<div class="row" align="center">
	<div class="col-lg-6" align="center" >

<div class="form-group"  class="container-fluid" >
  <label for="input">Preview:</label>
  <textarea class="form-control" rows="10" id="input" name="input">${input }</textarea>
</div>
</div>

<div class="col-lg-6" align="center">

<div class="form-group"  class="container-fluid">
  <label for="input">Output:</label>
  <textarea class="form-control" rows="10" id="input" disabled>${output }</textarea>
</div>


</div>

</div>

<div class="row" align="center">
<div class="col">
<button type="button" class="btn btn-dark" onclick="submit_form()">Process</button>
</div>
</div>



<br>

</form>

</div>

</body>



</html>



