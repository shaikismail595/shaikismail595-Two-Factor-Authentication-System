<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Setup</title>
    <link rel="stylesheet" href="./UserCSS/AddUser.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
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
        <form action="addUser" modelAttribute="usr" method="post">
            <h3>Enter the following details</h3>    
            <tr><td>Corporate Id:</td><td><input type="text" name="CorporateId" value="${corpid}" id="corporateId" readonly/></td></tr><br><br> 
            <tr><td>Login ID:</td><td><input type="text" name="UserId" id="loginId" required/></td></tr><br><br>  
            <tr><td>Password:</td><td><input type="password" name="UserPassword" id="password" required/></td></tr><br><br> 
            <tr><td>Department:</td><td><input type="text" name="Department" id="departmentName" required/></td></tr><br><br>
            <tr><td>Address: <input type="text"name="Address" id="address"/></td></tr><br><br>
            <tr><td>Phone Number: <input type="tel"name="PhoneNumber" maxlength="10" id="phoneNumber"/></td></tr><br><br>
            <input type="hidden" name="DeleteStatus" value="0"/>
            <input type="hidden" name="NewUser" value="0"/>
            <input style="margin-left: 18%;" type="reset" value="Reset" id="reset">
            <input style="margin-left: 7%;" type="submit" value="Submit" id="submit">
            </form>
    </div>
</div>
</nav>
</body>
</html>