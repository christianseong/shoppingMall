(function($) {

	"use strict";

	var fullHeight = function() {

		$('.js-fullheight').css('height', $(window).height());
		$(window).resize(function(){
			$('.js-fullheight').css('height', $(window).height());
		});

	};
	
	fullHeight();

	$('#sidebarCollapse').on('click', function () {
      $('#sidebar').toggleClass('active');
  });
	
	$('ul li').click(function(){
		$.ajax({
			type: 'GET',
			url: '/hipster/resources/html/about.html',
			dataType: 'html',
			success: function(response){
				$('.content').html(response);
			}
		});
	});
	
	
	
})(jQuery);


