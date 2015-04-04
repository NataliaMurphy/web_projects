<%-- 
    Document   : newuserform
    Created on : 2 Nov, 2014, 9:09:13 PM
    Author     : Arj
--%>

<%@include file="includes/header.jsp" %>
<link href="style1.css" rel="stylesheet" type="text/css">
    
    <div id="content">
    <h2>Enter Your Personal Details Here</h2>
    <form action="newuser"  method="post">
    <div class="left">
    <h3>User ID :  </h3>
    <input type="text" name="userid" class="userid" minlength="5" maxlength="9" required pattern="[0-9]{9}" placeholder="Enter your userid here">
    <div class="label">
    Rules-<br>
    1)Must consist of numbers only<br>
    2)Maximum length is 9 and minimum length is 5.<br>
    </div>
    <h3>Password :  </h3>
    <input type="password" name="password" class="password" minlength="5" maxlength="8" required pattern="[a-zA-Z]+" placeholder="Enter your password here">
    <div class="label">
    Rules-<br>
    1)Must consist of upper case, lower case alphabets only.<br>
    2)Password length must be 5 to 8 chars.<br>
    </div>
    <h3>First Name : </h3>
    <input type="text" name="firstname" class="firstname" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your first name here">
    <h3>Last Name : </h3>
    <input type="text" name="lastname" class="lastname" required pattern="[a-zA-Z]+" required="required" placeholder="Enter your last name here">
    <h3>Address :  </h3>
    <input type="text" name="address" class="address" placeholder="Enter your address here">
    <h3>City :  </h3>
    <input type="text" name="city" class="city"  required pattern="[a-zA-Z]+" placeholder="Enter your city here">  
    <h3>State :  </h3>
    <input type="text" name="state" class="state" required pattern="[a-zA-Z]+" placeholder="Enter your state here">
    <h3>Gender : </h3>
    <input type="radio"  name="gender" value="M">Male<br>
    <input type="radio"  name="gender" value="F">Female<br>
    </div>
    <div class="right">
    <h3>ZipCode :  </h3>
    <input type="text" name="zipcode" class="zipcode" maxlength="5" required pattern="[0-9]{5}" placeholder="Enter your zipcode here">
    <h3>Country :  </h3>
    <input type="text" name="country" class="country"  required pattern="[a-zA-Z]+" placeholder="Enter your country here">
    <h3>EmailID :  </h3>
    <input type="text" name="emailid" class="emailid"  required pattern="^[a-zA-Z0-9-\_.]+@[a-zA-Z0-9-\_.]+\.[a-zA-Z0-9.]{2,5}$" placeholder="Enter your emailid here">
    <h3>Phone Number :  </h3>
    <input type="text" name="phoneno" class="phoneno" maxlength="10" required pattern="[0-9]{10}" placeholder="Enter your phone number here">
    <h3>DOB :  </h3>
    <input type="date" name="DOB" placeholder="Enter your DOB here"><br>
    Format:-
    MM/DD/YYYY<br>
    <h3>Department :  </h3>
    <input type="text" name="dept" class="dept" required pattern="[a-zA-Z]+" placeholder="Enter your department here">
    <h3>Course :  </h3>
    <input type="text" name="course" class="course"  required pattern="[a-zA-Z]+" placeholder="Enter your course here">
    <h3>Clubs :</h3>
    <input type="text" name="club" class="club"  required pattern="[a-zA-Z]+" placeholder="Enter your text here">
    <h3>Security Question: 1</h3>
    <select name="question1">
        <option value="What is the name of your favorite teacher?">What is the name of your favorite teacher? </option>
        <option value="Which is your favorite sport?">Which is your favorite sport? </option>
        <option value="What is the name of your pet?">What is the name of your pet? </option>
    </select>
    <input type="text" name="answer1" placeholder="Enter your answer here">
    <h3>Security Question: 2</h3>
    <select name="question2">
        <option value="What is the name of your school?">What is the name of your school? </option>
        <option value="What is the name of your favorite dish?">What is the name of your favorite dish? </option>
        <option value="What is the name of your favorite dish?">What is the name of your favorite color? </option>
    </select>
    <input type="text" name="answer2" placeholder="Enter your answer here">
    
    <div class="buttons">
        <input type="submit" value="Go" class="Go-button">
    <input type="reset" value="Clear" class="clear-button">
    </div>
   </div>
  </form>
 </div>
    

<%@include file="includes/footer.jsp" %>



