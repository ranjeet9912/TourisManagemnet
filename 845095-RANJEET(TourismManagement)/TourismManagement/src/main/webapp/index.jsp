<html lang="en">
<head>    
	<title>Tourism Management System</title>
    <style type="text/css">
  		<%@include file="css/bootstrap.min.css" %>
  		<%@include file="css/modern-business.css" %>
	</style>
</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="background:#66CCFF">
        <div class="container" >
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp" style="color:#FFFFFF">Tourism Management System</a>
				
				
            </div>
         
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    
					 <li style="color:#FFFFFF">
                        <a style="color:#FFFFFF" href="index.jsp">Home</a>
                    </li>
					

                    <li class="dropdown">
        <a style="color:#FFFFFF" href="#" class="dropdown-toggle" data-toggle="dropdown" href="#"></i>Registration
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
          <li><a href="register1">Tourist</a></li>
          <li><a href="hregister">Tour Guide</a></li> 
        </ul>
      </li> 
      
      	<li class="dropdown">
        <a style="color:#FFFFFF" href="#" class="dropdown-toggle" data-toggle="dropdown" href="#"></i>Login
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          
         
		  <li><a href="login1">Tourist</a></li> 
		   <li><a href="hlogin1">Tour Guide</a></li> 
          
        </ul>
      </li> 
	  
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

		<!-- slider start -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
           
        </ol>

          <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                
                <div class="fill" style="background-image:url('images/img2.jpg');"></div>
				<div class="carousel-caption">
                    
                </div>
            </div>
           
            <div class="item">
                <div class="fill" style="background-image:url('images/img10.jpg');"></div>
                <div class="carousel-caption">
                   
                </div>
            </div>
			
			 <div class="item">
                <div class="fill" style="background-image:url('images/img4.jpg');"></div>
                <div class="carousel-caption">
                   
                </div>
            </div>
			
			
			
			
			
        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
       
    </header>
<!-- slider -->			
	
	
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
         <div class="col-sm-10" style="margin-top:60px;margin-bottom:80px">
				<h2>About Tourist Management System</h2>
				Tourist Management System..

			</div>
			
			
            </div>
            
    </div>
    <!-- /.container -->
</div>
    <!-- jQuery -->
    <script>
    <%@include file="/css/jquery.js" %>
    </script>
    <script> <%@include file="/css/bootstrap.min.js" %>
    </script>

    <!-- Script to Activate the Carousel -->
    
    <script>
    
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>

</body>

</html>
