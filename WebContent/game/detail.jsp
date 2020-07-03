<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<script src="js/jssor.slider-28.0.0.min.js" type="text/javascript"></script>
<script src="js/jssor.slider-28.0.0.min2.js" type="text/javascript"></script>

 	<br/><br/>
 	<div class="container ">
    <div class="col-lg-12 d-flex justify-content-start">
	<p style="color: white;">${homeDetailGameInfo.gamename}</p>
</div>
	</div>
    <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:380px;overflow:hidden;visibility:hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
            <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="img/spin.svg" />
        </div>
        <div data-u="slides" style="cursor:pointer;position:relative;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
            <div>
               	<iframe  width="720" height="315" src="https://www.youtube.com/embed/${homeDetailGameInfo.movie}?autoplay=1&mute=1&amp;playlist=${homeDetailGameInfo.movie}&amp;loop=1" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""></iframe>
            </div>
            <div>
                <img data-u="image" src="${homeDetailGameInfo.gamePlayImage1}" />
            </div>
            <div>
                <img data-u="image" src="${homeDetailGameInfo.gamePlayImage2}" />
            </div>
            <div>
                <img data-u="image" src="${homeDetailGameInfo.gamePlayImage3}" />
            </div>
        </div><a data-scale="0" href="https://www.jssor.com" style="display:none;position:absolute;">animation</a>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb051" style="position:absolute;bottom:16px;right:16px;" data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
            <div data-u="prototype" class="i" style="width:12px;height:12px;">
                <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <circle class="b" cx="8000" cy="8000" r="5800"></circle>
                </svg>
            </div>
        </div>
        <!-- Arrow Navigator -->
        <div data-u="arrowleft" class="jssora051" style="width:65px;height:65px;top:0px;left:35px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
            <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
            </svg>
        </div>
        <div data-u="arrowright" class="jssora051" style="width:65px;height:65px;top:0px;right:35px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
            <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
            </svg>
        </div>
    </div><br/>
    <div class="container ">
    <div class="col-lg-12 d-flex justify-content-end">
	<p style="color: white;">${homeDetailGameInfo.price}</p>
</div>
	</div>
    <script type="text/javascript">jssor_1_slider_init();
    </script>
    <!-- #endregion Jssor Slider End -->


<div class="container" id="game__detail">

<div class="col-lg-12">

<div class="row">
	
	<div class="col-lg-4">
		<img alt="" src="${homeDetailGameInfo.contentImage}" width="300px" height="170px">
	</div>
	<div class="col-lg-5">
		<p>${homeDetailGameInfo.content}</p>
	</div>
	<div class="col-lg-3">
		<div class="btn-group a">
		
		<button class="buy-button" type="button" onclick="gameBuyCheck('${homeDetailGameInfo.id}','${sessionScope.principal.id}','${homeDetailGameInfo.gamename}')" >지금 구매</button>
		<button class="buy-button2" type="button" onclick="CartAddCheck('${homeDetailGameInfo.id}','${sessionScope.principal.id}','${homeDetailGameInfo.gamename}','${homeDetailGameInfo.contentImage}','${homeDetailGameInfo.price}')"><span data-tooltip-text="위시리스트에 추가"><img src="/project/image/whi.png"></span></button>
		</div>
	</div>
</div>
</div>
</div>
<br/><br/>
<div class="container" id="game__detail">
	
<!-- 	<iframe src="http://www.youtube.com/embed/TgOu00Mf3kI?version=2&amp;showinfo=0&amp;autoplay=1&amp;loop=1" width="640px" height="360px" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""></iframe> -->
<!-- 	<embed width="640" height="360" src="https://www.youtube.com/v/TgOu00Mf3kI?version=2&autoplay=1&loop=1" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed> -->
	
	<div class="row">
	<div class="col-lg-4">
	<h4>게임 정보</h4>
	</div>
	<div class="col-lg-8">
		<table class="table table-borderless " id="game__detail__table">
			<thead>
				<tr>
					<th>개발사</th>
					<th>퍼블리셔</th>
					<th>출시일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.developer}</td>
					<td>${homeDetailGameInfo.publisher}</td>
					<td>${homeDetailGameInfo.releasedate}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>태그</th>
					<th>게임이용등급</th>
					<th>플랫폼</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.tags}</td>
					<td>${homeDetailGameInfo.rating}</td>
					<td>${homeDetailGameInfo.platform}</td>
				</tr>
			</tbody>
		</table>
		
		<h5>스토리</h5>
	<p>${homeDetailGameInfo.explanation}</p>
	<img alt="" src="">
	
	</div>
	</div>

</div>

<div class="container" id="game__detail">
	
<!-- 	<iframe src="http://www.youtube.com/embed/TgOu00Mf3kI?version=2&amp;showinfo=0&amp;autoplay=1&amp;loop=1" width="640px" height="360px" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=""></iframe> -->
<!-- 	<embed width="640" height="360" src="https://www.youtube.com/v/TgOu00Mf3kI?version=2&autoplay=1&loop=1" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true"></embed> -->
	
	<div class="row">
	<div class="col-lg-4">
	<h4>사양</h4>
	</div>
		<div class="col-lg-8">
		<div class="row">
		<div class="col-lg-10">
		<table class="table table-borderless " id="game__detail__table">
			<thead>
				<tr>
					<th>최소</th>
					<th>권장</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th></th>
					<td></td>
					
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>운영체제</th>
					<th>운영체제</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.minOS}</td>
					<td>${homeDetailGameInfo.recomOS}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>프로세서</th>
					<th>프로세서</th>
				</tr>
			</thead>
			<tbody>
				<tr>					
					<td>${homeDetailGameInfo.minProcessor}</td>
					<td>${homeDetailGameInfo.recomProcessor}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>메모리</th>
					<th>메모리</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					
					<td>${homeDetailGameInfo.minMemory}</td>
					<td>${homeDetailGameInfo.recomMemory}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>그래픽 카드</th>
					<th>그래픽 카드</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.minGraphics}</td>
					<td>${homeDetailGameInfo.recomGraphics}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>Direct X</th>
					<th>Direct X</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.minDirectX}</td>
					<td>${homeDetailGameInfo.recomDirectX}</td>
				</tr>
			</tbody>
			<thead>
				<tr>
					<th>저장공간</th>
					<th>저장공간</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${homeDetailGameInfo.minStorage}</td>
					<td>${homeDetailGameInfo.recomStorage}</td>
				</tr>
			</tbody>
			
		</table>
	</div>
	<div class="col-lg-2">
	</div><br/>
		
		<h5 style="color: #6D6D6D;">지원언어 &emsp;&emsp;&emsp; &emsp;&emsp;&emsp; </h5><p></p>
	&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;<p>${homeDetailGameInfo.languagesSupported}</p>
	<img alt="" src="">
	<br/><br/><br/>
	</div>
	</div>

</div>
</div>

<script src="/project/js/buy.js"></script>

<%@ include file="../include/footer.jsp"%>