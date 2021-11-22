<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     trimDirectiveWhitespaces="true" %>
	 <!DOCTYPE html>
	 <html lang="ko">
	   <head>
		 <!-- meta -->
		 <meta charset="UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1.0">
		 <meta http-equiv="X-UA-Compatible" content="IE=edge">
		 
		   <title>HappyShare : 나눔이야기 등록양식</title>
		   
		   <!--  link -->
		 <link rel="stylesheet" href="../../assets/css/bootstrap.css">
		 <link rel="stylesheet" href="../../assets/css/maicons.css">
		 <link rel="stylesheet" href="../../assets/vendor/animate/animate.css">
		 <link rel="stylesheet" href="../../assets/vendor/owl-carousel/css/owl.carousel.css">
		 <link rel="stylesheet" href="../../assets/vendor/fancybox/css/jquery.fancybox.css">
		 <link rel="stylesheet" href="../../assets/css/theme.css">
		 <link rel="stylesheet" href="../../assets/css/style.css">
		 </head>
		 
	   <body>
		 <header>
		   <div class="top-bar">
			 <div class="container">
			   <div class="row align-items-center">          
				 <div class="col-md-12 text-right d-none d-md-block">
				   <div class="social-mini-button">
					 <a href="#"><span>로그인</span></a>
					 <a href="#"><span>회원가입</span></a>
					 <a href="#"><span>관리자</span></a>
				   </div>
				 </div>
			   </div>
			   <!-- //row -->
			 </div>
		   </div>
		   <!-- //top-bar -->
		   
		   <nav class="navbar navbar-expand-lg navbar-light">
			 <div class="container">
			   <a href="index.html" class="navbar-brand">Happy<span class="text-primary logo">Share</span></a>
			   <button class="navbar-toggler" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
				 <span class="navbar-toggler-icon"></span>
			   </button>
			   <!-- navbarContent -->
			   
			   <div class="navbar-collapse collapse" id="navbarContent">
				 <ul class="navbar-nav ml-auto pt-3 pt-lg-0">
				   <li class="nav-item">
					 <a href="index.html" class="nav-link">함께해요</a>
				   </li>
				   <li class="nav-item active">
					 <a href="about.html" class="nav-link">소통해요</a>
				   </li>
				   <li class="nav-item">
					 <a href="services.html" class="nav-link">챌린지</a>
				   </li>
				   <li class="nav-item">
					 <a href="portfolio.html" class="nav-link">모금함</a>
				   </li>
				   <li class="nav-item">
					 <a href="blog.html" class="nav-link">고객센터</a>
				   </li>
				 </ul>
			   </div>
			   <!-- //navbarContent -->
			 </div>
			 <!-- container -->
		   </nav>
		   <!-- //navbar -->
		 </header>
	 <!---------------------------------------- main ---------------------------> 

   <main>
    <div class="page-section">
        <div class="container">
          <form action='boardAdd' method='post' >
          <h1 class="title-h">봉사 게시글 등록</h1>
          <div class="join-wrap">
      <h5><span class="required_title"><em class="icon_required">·</em>표시는 반드시 입력하셔야 합니다.</span></h5>
        <div class="base-table">
        <table class="join-table">
          <caption>봉사 게시글 등록양식</caption>
         <tbody>
 
          <div class="form-group">
            <label for="f-title">제목</label>
            <input type="text" class="form-control" id="f-title" name="title">
          </div>
          <!-- //제목 -->

          <div class="form-group">
            <label for="f-content">내용</label>
            <textarea name="content" id="f-content" cols="30" rows="8" class="form-control"></textarea>
          </div>
          <!-- //내용 -->

          <div class="form-group row">
            <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
            <div class="col-sm-11">
              <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
            </div>
            <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
            <div class="col-sm-11">
              <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
            </div>
            <label for="f-file" class="col-sm-1 col-form-label">파일첨부</label>
            <div class="col-sm-11">
              <input type="file" class="form-control-file" id="f-file" name='fileUpload'>
            </div>
          </div>
          <!-- //파일첨부 -->





  
  <div class="mb-3 row">
    <label for='f-title' class="col-sm-2 col-form-label">제목</label>
    <div class="col-sm-8">
      <input id='f-title' type='text' name='title' class="form-control">
    </div>
  </div>
  
  <div class="mb-3 row">
    <label for='f-content' class="col-sm-2 col-form-label">내용</label> 
        <div class="col-sm-8">
      <textarea id='f-content' name='content' class="form-control" rows="5">
    </textarea>
  </div>
  </div>
  







						</tbody>
          </table>
          </div>
            <div class="btn-regi">
              <button type="submit" class="btn btn-primary nBtn" id="abc">등록</button>
              <a href="#" class="btn btn-outline-primary nBtn" role="button">이전</a>
            </div>
          </div>  <!-- //join-wrap -->
         
	
      </script>
				
		 </body>
	 </html>
		 









