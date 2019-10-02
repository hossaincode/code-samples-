<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>




<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>

<title>Insert title here</title>
</head>





<body>

<div class="form-Container">

<h2 class="text-center"> <i class="fas fa-tools"></i> Enter Parts Details: </h2>
<br/>
<br/>
<form:form method="POST" modelAttribute="parts" class="form-horizontal" action="save">


	<div class="input-tag">
		<label for="PRODUCT_NAME">PRODUCT_NAME </label>
		<form:input  type="text" path="PRODUCT_NAME" placholder="" name=" product_name" id="product_name" class="form-control"/>	
		<form:errors path="PRODUCT_NAME" cssStyle="color: #ff0000;" />
	</div>
	<div class="input-tag">
		<label for="PRODUCR_DESCIPTION">PRODUCT_DESCRIPTION </label>
		<form:input  type="text" path="PRODUCR_DESCIPTION" placholder="PRODUCT_DESCRIPTION" name=" product_DESCRIPTION" class="form-control" />	
		<form:errors path="PRODUCR_DESCIPTION" cssStyle="color: #ff0000;" />
	</div>
	<div class="input-tag">
		<label for="email">Email: </label>
		<form:input  type="text" path="email" placholder="email" name=" email" class="form-control" />	
		<form:errors path="email" cssStyle="color: #ff0000;" />
	</div>
	<div class="input-tag">
		<label for="COUNTRY_MANUFACTUR">Country_Manufacturer </label>
		<form:input  type="text" path="COUNTRY_MANUFACTUR"  name=" country" class="form-control" />	
		<form:errors path="COUNTRY_MANUFACTUR" cssStyle="color: #ff0000;" />
	</div>
	<div class="input-tag">
		<label for="DATE_ENTERED">DATE_ENTERED: </label>
		<form:input type="text"  path="DATE_ENTERED" name="date" class="form-control"/>
		<form:errors path="DATE_ENTERED" cssStyle="color: #ff0000;" />
	
	</div>
	<div class="input-tag">
		<label for="SUBJECTS">Enter Product Subject Here: </label>
		<form:input  type="text" path="SUBJECTS" placeholder="subjects"  name="subjects" class="form-control" />	
		<form:errors path="SUBJECTS" cssStyle="color: #ff0000;" />
	</div>
	

	
	<div class="row">
		
		
		<input  class="col-md-8" type="submit" class="btn btn-primary" value="Save"> 
	
	

	 	<a  class=" col-md-4" href="/listallparts"><i class="fas fa-list"></i> List All Products </a>
	</div>
	
              
             

   


</form:form>







</div>


</body>




</html>