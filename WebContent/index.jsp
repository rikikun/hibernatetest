<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
	<s:form action="addEmployee">
		<s:textfield name="em.firstName" label="First Name" />
		<s:textfield name="em.lastName" label="Last Name" />
		<s:textfield name="em.salary" label="salary" />
		<s:select name="dp.dept_name" label="Department"
			list="{'','Programmer','Account','Sales'}" />
		<s:submit />
	</s:form>
</body>
</html>