<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
</head>

<body>
<h4>HeyWorld API</h4>
    <tr>
        <c:forEach items="${classes}" var="cla">
            <tr>
            <td align="center">${cla.className}</td>
            <td align="center">${cla.description}</td>
            </tr>
            <br>
            <td align="center"><c:forEach items="${cla.methodsList}" var="met">
            <tr>
                <td align="center">${met.methodName}</td>
                <td align="center">${met.path}</td>
                <td align="center">${met.description}</td>
            </tr><br>
                <td align="center">
                    <c:forEach items="${met.fieldList}" var="fil">
                        <tr>
                            <td align="center">${fil.fieldName}</td>
                            <td align="center">${fil.type}</td>
                        </tr><br>
                    </c:forEach>
                </td>
        </c:forEach>
    </td>
        </c:forEach>
    </tr>

</body>
</html>