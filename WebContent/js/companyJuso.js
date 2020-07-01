function CompanyGoPopup(){
	window.open("/project/juso/companyJusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function CompanyJusoCallBack(roadFullAddr){
	
	$("#companyAddress").val(""+roadFullAddr);
	// document.form.roadFullAddr.value = roadFullAddr;		
}