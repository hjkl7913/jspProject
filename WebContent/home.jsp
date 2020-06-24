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
	<br/><br/><br/><br/>
<!-- Page Content -->
  <div class="container">

    <!-- Page Features -->
    <div style="background-color: #2A2A2A;">
    
    <h2><img alt="" src="images/pre.png">무료게임</h2>
    <div class="row text-center justify-content-center">
		
      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/pathway.png" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit amet, co</p>
          </div>

        </div>
      </div>

      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="images/AER.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit amet, conse</p>
          </div>
          
        </div>
      </div>

      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-70">
          <img class="card-img-top" src="images/stranger3.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit ame</p>
          </div>
          
        </div>
      </div>


    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  </div>
  <!-- new -->
  <div class="container">

    <!-- Page Features -->
    <h2>신규게임</h2>
    <div class="row text-center justify-content-center">
		
      <div class="col-lg-3 col-md-6 mb-3">
        <div class="card h-100">
          <img class="card-img-top" src="images/pathway.png" alt="" width="200px" height="200px">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit amet, co</p>
          </div>

        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-3">
        <div class="card h-100">
          <img class="card-img-top" src="images/AER.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit amet, conse</p>
          </div>
          
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-3">
        <div class="card h-70">
          <img class="card-img-top" src="images/stranger.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit ame</p>
          </div>
          
        </div>
      </div>
      
      <div class="col-lg-3 col-md-6 mb-3">
        <div class="card h-70">
          <img class="card-img-top" src="images/stranger.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit ame</p>
          </div>
          
        </div>
      </div>
      
      <div class="col-lg-3 col-md-6 mb-3">
        <div class="card h-70">
          <img class="card-img-top" src="images/stranger.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Card title</h4>
            <p class="card-text">Lorem ipsum dolor sit ame</p>
          </div>
          
        </div>
      </div>


    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
	<%@ include file="include/footer.jsp"%>