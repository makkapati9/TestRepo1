(function(w, d) {
	$(d).ready(function(e) {

		/*$(".dists").click(function(e) {

			$(".dists").css('display', '');
			location.href = "userReport";

		});*/
		
		/*$(".dists").popupWindow({
			height:500, 
			width:800, 
			top:50, 
			left:50
		});*/
		$(".dists").click(function(e) {
			var url = $(e.currentTarget).attr('url');
			
			event.preventDefault();
	          $.popupWindow(url, {
	            width: 1200,
	            height: 600,
	            centerScreen:1
	          });
			
//			popupWin = window.open(url, 'open_window', 'scrollbars=yes, dependent, width=1200, height=700');
			
		});

	});
}(window, document));
