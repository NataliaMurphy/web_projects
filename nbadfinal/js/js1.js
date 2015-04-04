/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//$( document ).ready(function() {
//    console.log( "ready!" );
//    //alert('ready!!!');
//    
////    $('.search').bind(function(){
////        //alert('ready...!!!');
////    $('.search').after('input type="submit" class="clic" value="Add to Cart" img src="../images/search-img"');
////        });
//        
//    
////    $('.go').click( function() {
////    window.location = $(this).attr('href') + '/' + $('.search').val();
////    return false;
////        });
//    
//});
$(document).ready(function() {
    //alert('hi');
    var url= window.location.href;
    var arr= url.split('/')[3];
    if(arr === "confirmOrder"){
    $(".in-buttons").css("display", "none");
    }    
    
//    $('.anime').click(function(){
//        alert('animeeee');
//        $('.anim').animate({left :'220px'});
//    });

//$(".anime").click(function(){
//        $(".anim").animate({
//            left: '250px',
//            opacity: '0.5',
//            height: '150px',
//            width: '150px'
//        });
//    });

$(".anime").click(function(){
        var div=$(".anim");
        div.animate({height: '300px', opacity: '0.4'}, "slow");
        div.animate({width: '300px', opacity: '0.8'}, "slow");
        div.animate({height: '100px', opacity: '0.4'}, "slow");
        div.animate({width: '100px', opacity: '0.8'}, "slow");
    });
});