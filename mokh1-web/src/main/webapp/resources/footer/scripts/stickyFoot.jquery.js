/**
 * @author 	Trevor Broad
 * @eamil  	TrevorBroad84@gmail.com
 * @website trevorbroad.com
 * 
 * A simple sticky footer jquery plugin that allows you to toggle 
 * footer content anywhere within a page.
 * 
 */

(function($){	
	$.fn.stickyFoot = function(options) {
		
		var defaults = {
			stickyToe: 	$('.sticky-toe'),
			stickyHeel:	$('.sticky-heel'),
			stickyFoot:	$('footer')
			//@TODO MAKE TRIGGER AN OPTION
		};
		
		var options = $.extend(defaults, options);
		
		var docHeight =		$(document).outerHeight(),
			winHeight = 	  $(window).outerHeight(),
			toeHeight =		  options.stickyToe.outerHeight(true), 
			footHeight = 	  options.stickyHeel.outerHeight(true),
			footerHeight = 	options.stickyFoot.outerHeight(true),
			footerTop =		  docHeight - footerHeight,
			scrollPos = 	  $(window).scrollTop(),
			newBodyTop =    parseInt($('body').css('margin-top')) - footerHeight;
					
		
		return this.each(function() {
			
			//@TODO MEASURE FOR SHORT PAGES
			
			// INIT 									
			options.stickyFoot.addClass('fix-foot');									// Fix bar to bottom on init						
			options.stickyFoot.css('margin-top', -toeHeight);				  // Offset footer for smooth docking event				
			options.stickyHeel.hide();													      // hide additional content			
				
			// TOGGLE EVENT		
			options.stickyToe.click(function(){             			          
			  options.stickyHeel.slideToggle();                                           // toggle footer
			                                        
        if ( scrollPos + winHeight == footerTop) {          
          $("html, body").animate({ scrollTop: $(document).height() }, "slow");     // scroll window down on footer bottom  
        }			  

			  /* work in progress
			   * var bodyMargin = parseInt($('body').css('margin-top'));			   
			  if (bodyMargin == newBodyTop) {                                             // toggle body content
			    $('body').animate({'marginTop': '0px'});  
			  } else {			    
			    $('body').animate({'marginTop': newBodyTop});  
			  }*/
			});
			
			// SCROLL EVENTS
			$(window).scroll(function(){
				scrollPos = $(window).scrollTop();				
								
				if ( scrollPos + winHeight < footerTop) {								// Window hasn't reached footer																		
					if (options.stickyHeel.is(':visible')) {							// Hide content if scrolling						
						options.stickyHeel.slideUp('fast');
					}										
					if (!options.stickyFoot.hasClass('fix-foot')) {						// fix footer to window
						options.stickyFoot.addClass('fix-foot');
						options.stickyHeel.hide();
					}
				}								
				if ( scrollPos + winHeight >= footerTop) {								// Window has reached footer																				
					if (options.stickyFoot.hasClass('fix-foot')) {						// undock footer
						options.stickyFoot.removeClass('fix-foot');
						options.stickyHeel.show();
					}
				}												
			});			
		});							
	};			
})(jQuery);