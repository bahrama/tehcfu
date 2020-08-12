/**
 * @author Trevor Broad
 */

$(document).ready(function(){	
  
  // positon splash in center of window
  var margin = $(window).outerHeight() / 2 - $('#splash').outerHeight();       
  $('#splash').css('margin-top', margin);		
  
  // set demo call above footer
  var toeHeight = $('.sticky-toe').outerHeight();
  $('#demo-action-calls').css('bottom', toeHeight);
     
  
  var docHeight =     $(document).outerHeight(true),
      footerHeight =  $('footer').outerHeight(true),
      winHeight =     $(window).outerHeight(true),
      footerTop =     docHeight - footerHeight,
      canary =        1;             
    
  $(window).scroll(function(){
    var scrollPos =   $(window).scrollTop();
    
    // change scroll-call text
    if ( scrollPos > 50 && scrollPos < 100 && canary) {        
      $('#scroll-call p').fadeOut();
      $('#scroll-call').html('<p>Scroll to the bottom...</p>');
      canary = 0;
    }      
    // remove scroll-call text            
    if ( scrollPos + winHeight == footerTop) {        
      $('#scroll-call p').fadeOut();
      $('#scroll-call').animate({backgroundPositionX:"+=1000px"}, 0);
    }    
  });
  
  $('.sticky-toe').click(function(){
    $('#toggle-call').fadeOut();  
  });   
  
  //trigger dynamic footer
	$('footer').stickyFoot();	
	
});