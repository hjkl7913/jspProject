function FilterSearch(filter){
	var keyword = $("#filter").val();
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
	console.log(keyword);
	
	$.ajax({
		type: "get",
		url: `/project/home?cmd=keywordSearch&keyword=${keyword}`,
		dataType: "json"
	}).done(function(keySearchJsons){
		$("#tag__search").empty();
		renderSearchList(keySearchJsons);
	}).fail(function(error){
		alert(error);
		console.log(error);
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
	searchItem += `<img class="card-img-top" src="${tagSearchJson.image}" alt="" height="230px">`
	searchItem += `<div class="card-body">`
	searchItem += `<h5 class="card-title">${tagSearchJson.gamename }</h5>`
	searchItem += `<p class="card-text">${tagSearchJson.developer}</p>`
	searchItem += `<p class="card-text">${tagSearchJson.price}</p>`
	searchItem +=`</div>`
	searchItem +=`</div>`
	searchItem +=`</div>`


	return searchItem;
} 