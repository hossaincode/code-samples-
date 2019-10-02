<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>



<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
  <script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>



<body>
<h2 class="text-center"><i class="fas fa-tools"></i> List of All Products</h2>

	<table border="2" width="90%" cellpadding="3">  
		<tr>
			<th>Id</th> <th>Product_Name</th> <th> Product_Description</th> <th>Date_Entered </th> <th> Email</th> <th>Country_Manufacturer</th> <th> Subjects</th> <th> Actions</th>
		</tr>  
	  	 <c:forEach var="part" items="${listall}">   
	  	
			   <tr>  
			   		<td>${part.ID}</td>  
				   <td>${part.PRODUCT_NAME}</td>  
				   <td>${part.PRODUCR_DESCIPTION}</td>  
				   <td>${part.DATE_ENTERED}</td>  
				   <td>${part.email}</td>  
				   <td>${part.COUNTRY_MANUFACTUR}</td>
				   <td>${part.SUBJECTS}</td>
				   <td> <a href="/deletepart/${part.ID}"   class="btn btn-danger"> <i class="fa fa-trash"></i> DELETE</a>| <a href="/edit/${part.ID}"   class="btn btn-warning"><i class="fas fa-edit"></i> EDIT</a>  </td>
				   
				    
			   </tr> 
			    
	   	</c:forEach>  
	 </table>  
   <a href="/insert" class="btn btn-primary" ><i class="fa fa-save"></i> Insert</a>
   <a href="/deleteparts/All " class="btn btn-danger" ><i class="fa fa-trash"></i> DELETE ALL </a>

</body>
</html>