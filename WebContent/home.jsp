<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ include file="include/nav.jsp"%>

<style>
/* Make the image fully responsive */
.carousel-inner img {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<div class="container">
		<div id="demo" class="carousel slide" data-ride="carousel">
			<form class="form-inline justify-content-center">
				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<!-- The slideshow -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="images/Fortnite.jpg" alt="Los Angeles" width="600px" height="300px">
					</div>
					<div class="carousel-item">
						<img src="images/starwars.png" alt="Chicago" width="600px" height="300px">
					</div>
					<div class="carousel-item">
						<img src="images/control.jpg" alt="New York" width="600px" height="300px">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next"> <span class="carousel-control-next-icon"></span>
				</a>
			</form>
		</div>
	</div>

	<!-- Main -->
	<section id="main">
		<div class="container">
			<div class="row">
				<div class="col-12">

					<!-- Portfolio -->
					<section>
						<header class="major">
							<h2>무료 게임</h2>
						</header>
						<div class="row">
							<div class="col-4 col-6-medium col-12-small">
								<section class="box">
									<a href="#" class="image featured"><img src="images/Pathway.jpg" alt="" width="200px" height="200px" /></a>
									<header>
										<h3>Ipsum feugiat et dolor</h3>
									</header>
									<p>Lorem ipsum dolor sit amet sit veroeros sed amet blandit consequat</p>

								</section>
							</div>
							<div class="col-4 col-6-medium col-12-small">
								<section class="box">
									<a href="#" class="image featured"><img src="images/AER Memories of Old.jpg" alt="" width="200px" height="200px" /></a>
									<header>
										<h3>Sed etiam lorem nulla</h3>
									</header>
									<p>Lorem ipsum dolor sit amet sit veroeros sed amet blandit</p>

								</section>
							</div>
							<div class="col-4 col-6-medium col-12-small">
								<section class="box">
									<a href="#" class="image featured"><img src="images/Stranger Things 3 The Game.png" width="200px" height="200px" alt="" /></a>
									<header>
										<h3>Consequat et tempus</h3>
									</header>
									<p>Lorem ipsum dolor sit amet sit veroeros sed amet blandit cons</p>

								</section>
							</div>
						</div>
					</section>

				</div>
				<div class="col-12">

					<!-- Blog -->
					<section>
						<header class="major">
							<h2>The Blog</h2>
						</header>
						<div class="row">
							<div class="col-6 col-12-small">
								<section class="box">
									<a href="#" class="image featured"><img src="images/pic08.jpg" alt="" /></a>
									<header>
										<h3>Magna tempus consequat</h3>
										<p>Posted 45 minutes ago</p>
									</header>
									<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem
										feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
									<footer>
										<ul class="actions">
											<li><a href="#" class="button icon solid fa-file-alt">Continue Reading</a></li>
											<li><a href="#" class="button alt icon solid fa-comment">33 comments</a></li>
										</ul>
									</footer>
								</section>
							</div>
							<div class="col-6 col-12-small">
								<section class="box">
									<a href="#" class="image featured"><img src="images/pic09.jpg" alt="" /></a>
									<header>
										<h3>Aptent veroeros aliquam</h3>
										<p>Posted 45 minutes ago</p>
									</header>
									<p>Lorem ipsum dolor sit amet sit veroeros sed et blandit consequat sed veroeros lorem et blandit adipiscing feugiat phasellus tempus hendrerit, tortor vitae mattis tempor, sapien sem
										feugiat sapien, id suscipit magna felis nec elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos lorem ipsum dolor sit amet.</p>
									<footer>
										<ul class="actions">
											<li><a href="#" class="button icon solid fa-file-alt">Continue Reading</a></li>
											<li><a href="#" class="button alt icon solid fa-comment">33 comments</a></li>
										</ul>
									</footer>
								</section>
							</div>
						</div>
					</section>

				</div>
			</div>
		</div>
	</section>

	<%@ include file="include/footer.jsp"%>