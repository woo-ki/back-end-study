<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- resources 디렉토리 아래의 image -->
<img alt="사진" width="300px" src="/mvc01/resources/sample.jpeg" />

<!-- resources 디렉토리 아래의 image -->
<img alt="사진" width="300px" src="/mvc01/assets/images/sample.jpeg" />

</body>
</html>
