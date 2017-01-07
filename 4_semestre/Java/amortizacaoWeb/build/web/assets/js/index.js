$(document).ready(function(){
  
  var offset = 30;
  $(window).scroll(function(event){
    if($(this).scrollTop() > offset){
      $(".navbar-name-me").css({"background-color":"black", "font-color" : "white"});
    }else{
      $(".navbar-name-me").css({"background-color":"transparent", "font-color" : "white"});
    }   
  });
  
});