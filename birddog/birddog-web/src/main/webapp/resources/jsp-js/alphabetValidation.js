$(document).ready(
		function() {
			$('.letterOnly').keypress(
					function(e) {
						var code = e.keyCode || e.which;
						if ((code < 65 || code > 90)
								&& (code < 97 || code > 122) && code != 32
								&& code != 46) {

							return false;
						}
					});
		});
