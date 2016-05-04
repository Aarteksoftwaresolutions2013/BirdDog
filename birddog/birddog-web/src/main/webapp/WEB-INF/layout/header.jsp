<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Homepage</title>
<!-- Loading third party fonts -->
<link href="http://fonts.googleapis.com/css?family=Roboto+Slab:300,400,700" rel="stylesheet" type="text/css">
<link href="resources/fonts/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Loading main css file -->
<link rel="stylesheet" href="resources/jsp-css/animate.css">
<link rel="stylesheet" href="resources/jsp-css/style.css">

<script>
	$('ul.nav li.dropdown').bootstrapDropdownHover(methodName, parameter);
	$('ul.nav li.dropdown').hover(function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
	}, function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
	});
</script>
</head>
<header class="site-header">
	<div class="bottom-header">
		<div class="container">
			<a href="#" class="branding pull-left"> <img src="resources/images/Birddog1.png" width="200" alt="Site title"
				class="logo-icon">
				<nav class="main-navigation pull-right">
					<button type="button" class="menu-toggle">
						<i class="fa fa-bars"></i>
					</button>
					<ul class="menu">
						<li class="menu-item"><a href="#">Home</a></li>
						<li class="menu-item"><a href="#">Services</a></li>
						<li class="menu-item"><a href="#">Contact</a></li>
					</ul>
				</nav> <!-- .main-navigation -->
		</div>
		<!-- .container -->
	</div>
	<!-- .bottom-header -->
</header>
<!-- .site-header -->