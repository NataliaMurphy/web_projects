/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {

    $('.go').click( function() {
    window.location = $(this).attr('href') + '=' + $('.search').val();
    return false;
        });
   
   $( "#datepicker" ).datepicker();
   $( "#datepicker1" ).datepicker();
   $( "#datepicker2" ).datepicker();   
   
   $('#myimage').click(function(){
       alert('Advanced search of profile lets you include all details of the person like first & last name , \n\
       department , subject etc so that the profile search is optimized.'); 
   });
 //$('.isbnup').prop('disabled',true);
//     $('.Go-button').click( function() {
//     var userid = $(".userid").val();
//     var user_reg = "/^[A-Za-z0-9._]/";
//     var password = $(".password").val();
//     var firstname = $(".firstname").val();
//     var lastname = $(".lastname").val();
//     var emailid = $(".emailid").val();
//     var emailRegex = "/^[A-Za-z0-9._]*\@[A-Za-z]*\.[A-Za-z]{2,5}$/";
//     var dept = $(".dept").val();
//     var course = $(".course").val();
 
     
//   if($(".userid").val()!== null && $(".userid").val() !==user_reg ){
//   $(".userid").focus();
//   $("#errorBox").html("Enter correct UserID");
//   return false;
//   }
//   if($(".password").val() === "" ){
//   $(".password").focus();
//   $("#errorBox").html("Enter password");
//   return false;
//   }
//   if($(".firstname").val() === "" ){
//   $(".firstname").focus();
//   $("#errorBox").html("Enter First Name");
//   return false;
//   }
//   if($(".lastname").val() === "" ){
//   $(".lastname").focus();
//   $("#errorBox").html("Enter Last Name");
//   return false;
//   }
//   if($(".emailid").val() === "" ){
//   $(".emailid").focus();
//   $("#errorBox").html("Enter email ID");
//   }
//   if($(".emailid").val() !== emailRegex ){
//   $(".emailid").focus();
//   $("#errorBox").html("Enter correct email ID");
//   }
//    
//});
});