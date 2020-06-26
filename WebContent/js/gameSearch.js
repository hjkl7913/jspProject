function FilterSearch(filter){
	console.log(filter);
	$.ajax({
		type: "get",
		url: `/project/home?cmd=tagSearch&tags=${filter}`,
		dataType: "json"
	}).done(function(tagSearchJsons){
		$("#tag__search").empty();
		renderSearchList(tagSearchJsons);
	}).fail(function(error){
		alert(error);
		console.log(error);
	});
	
}


function Search(){
	var keyword = $("#search").val();
	
	if(keyword == null || keyword == "" ){
	alert("검색 키워드가 없습니다.");
	}
	
	$.ajax({
		type: "get",
		url: `/project/home?cmd=keywordSearch&keyword=${keyword}`,
		dataType: "json"
	}).done(function(keySearchJsons){
		$("#tag__search").empty();
		renderSearchList(keySearchJsons);
	}).fail(function(error){
	});
	
}


function renderSearchList(tagSearchJsons){
	for(var tagSearchJson of tagSearchJsons){
		$("#tag__search").append(makeItem(tagSearchJson));
	}
}


function makeItem(tagSearchJson){
	console.log(tagSearchJson);
	var searchItem = `<div class="col-lg-3 col-md-6 mb-4">`
	searchItem += `<div class="card h-80" id="card__div__free">`
	searchItem += `<a href="/project/home?cmd=detail&id=${tagSearchJson.id}">`
	searchItem += `<img class="card-img-top" src="${tagSearchJson.image}" alt="" height="260px">`
	searchItem += `<div class="card-body">`
	searchItem += `<p class="card-text"><a href="/project/home?cmd=detail&id=${tagSearchJson.id}">${tagSearchJson.gamename }</a></p>`
	searchItem += `<p class="card-text"><a style="color: #8e8e8e" href="/project/home?cmd=detail&id=${tagSearchJson.id}">${tagSearchJson.developer}</a></p>`
	searchItem += `<h5 class="card-title"><a href="/project/home?cmd=detail&id=${tagSearchJson.id}">${tagSearchJson.price}</a></h5>`
	searchItem +=`</div>`
	searchItem +=`</div>`
	searchItem +=`</div>`


	return searchItem;
} 