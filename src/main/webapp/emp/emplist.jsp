<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <%--<script type="text/javascript" src="${path}/js/jquery-1.8.3.js"/>--%>
    <script type="text/javascript">
        function deleteEmp(id) {
            if (confirm("确定要删除吗？")) {
                location.href = "${path }/emp/delete?emp.id=" + id;
            }
        }
    </script>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>

                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!&nbsp;${sessionScope.user.username } <a href="${path}/user/out">退出</a>
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${list}" var="e" varStatus="status">
                    <%--状态《status》的下标+1（起始）的属性--%>
                    <c:if test="${ (status.index + 1)%2!=0}">
                        <tr class="row1">
                            <td>
                                    ${e.id}
                            </td>
                            <td>
                                    ${e.name}
                            </td>
                            <td>
                                    ${e.salary}
                            </td>
                            <td>
                                    ${e.age}
                            </td>
                            <td>
                                <a href="javascript:void(0)" onclick="deleteEmp('${e.id}')">delete emp</a>&nbsp;<a
                                    href="${path}/emp/selectOne?emp.id=${e.id}">update emp</a>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${ (status.index + 1)%2==0}">
                        <tr class="row2">
                            <td>
                                    ${e.id}
                            </td>
                            <td>
                                    ${e.name}
                            </td>
                            <td>
                                    ${e.salary}
                            </td>
                            <td>
                                    ${e.age}
                            </td>
                            <td>
                                <a href="javascript:void(0)" onclick="deleteEmp('${e.id}')">delete emp</a>&nbsp;<a
                                    href="${path}/emp/selectOne?emp.id=${e.id}">update emp</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>

            </table>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/emp/add.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
