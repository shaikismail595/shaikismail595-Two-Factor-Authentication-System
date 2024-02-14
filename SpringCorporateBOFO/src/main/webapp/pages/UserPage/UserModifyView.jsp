<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.io.*,java.util.*,java.sql.*"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User list</title>
    <link rel="stylesheet" href="./UserCSS/AddUser.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<sql:setDataSource var="dbsource" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/Main_Project"
                           user="root"  password="23Sachinkt@09"/>
 
        <sql:query dataSource="${dbsource}" var="result1">
             SELECT distinct Corporate.CorporateName,Corporate.CorporateId from Corporate inner join userSetup on Corporate.CorporateId=UserSetup.CorporateId where UserSetup.DeleteStatus=0;
            </sql:query>

        <sql:query dataSource="${dbsource}" var="result">
            SELECT * from UserSetup where DeleteStatus=0;
              </sql:query>
    <div class="mainpage">
        <nav class="navbar">
    <div id="Optionbar">
        <a href="HomePage">Home</a>
        <a href="viewCorporateList">Corporate Setup</a>
        <a href="viewUserForm">User Setup</a>
        <a href="AccountView">Account Setup</a>
        <a href="">User Profile</a>
        <a href="logout">Logout</a>
    </div>
    <div class="menu">
        <nav>
            <a class="adduser" href="addUserForm"><button> <span>Add User </span> </button></a><br><br>
            <a class="modifyuser" href="ModifyView"><button> <span>Modify User </span> </button></a><br>
            <a class="deleteuser" href="DeleteView"><button> <span>Delete User </span> </button></a><br>
            <a class="viewuser" href="viewUserForm"><button> <span>View User List </span> </button></a> 
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br> 
        </nav>
    </div>
     <div class="operation">
       <center> <h2>List Of Users</h2></center> <br>
       <c:forEach var="c" items="${result1.rows}">
       <sql:query dataSource="${dbsource}" var="result2">
            SELECT * from UserSetup where CorporateId=<c:out value="${c.CorporateId}" /> and DeleteStatus=0;
            
        </sql:query>
        <select><option>&nbsp&nbsp<c:out value="${c.CorporateName}"/>&nbsp&nbsp</option></select>
   <table border="1" width="144" style="margin-left:2%">
   <option><tr><th>CorporateId &nbsp</th><th>&nbsp UserId &nbsp</th><th>&nbsp password &nbsp</th><th>&nbsp Department &nbsp</th><th>&nbsp Address &nbsp</th><th>&nbsp Phone &nbsp</th><th>&nbsp Action</th></tr></option>
   <c:forEach var="c1" items="${result2.rows}">
   <option>
   <td><c:out value="${c1.CorporateId}"/></td>
   <td><c:out value="${c1.UserID}"/></td>
   <td><c:out value="${c1.UserPassword}"/></td>
   <td><c:out value="${c1.Department}"/></td>
   <td><c:out value="${c1.Address}"/></td>
   <td><c:out value="${c1.PhoneNumber}"/></td>
    <td><a style="color:Green;" href="modifyUsr?userid=<c:out value="${c1.UserID}" />">Update</a></td>
   </tr></option>
   </c:forEach>
    </table>
   </c:forEach>
    </div>
</div>
</nav>
</body>
</html>
   