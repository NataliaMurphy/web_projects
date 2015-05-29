/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var url= window.location.href;
    var arr= url.split('/')[4];
    if(arr === "confirmOrder"){
    $(".in-buttons").css("display", "none");
    }
   
   $(".main-content").draggable();
   $( ".droppable" ).droppable({
      drop: function(event,ui) {
        $( this )
          .addClass( "red" )
          .find( "p" )
            .html( "Dropped!" );
      }
    });
    $("#selectable").selectable();
    $("#accordion").accordion();
//    $( "input[type=submit], a, button" )
//      .button()
//      .click(function( event ) {
//        alert("click...");
//      });
    
    $( "#progressbar" ).progressbar({
      value: 77
    });
    
   
    var state = true;
    $( "#buttn" ).click(function() {
      if ( state ) {
        $( "#effect" ).animate({
          backgroundColor: "#aa0000",
          color: "#fff",
          width: 500
        }, 1000 );
      } else {
        $( "#effect" ).animate({
          backgroundColor: "#fff",
          color: "#000",
          width: 240
        }, 1000 );
      }
      state = !state;
    });
 
});