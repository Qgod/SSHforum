$(document).ready(function(){
	$("#AddressInfo").mouseover(function(){
		$("#AddressInfo").css("color","gray");
	});
	$("#AddressInfo").mouseout(function(){
		$("#AddressInfo").css("color","DarkSeaGreen");
	});
	$("#AddressInfo").click(function(){
		$("#AddressText").fadeToggle(600);
		$("#IntroduceText").hide();
		$("#EducationText").hide();
		$("#WorkText").hide();
	});
	$("#WorkInfo").mouseover(function(){
		$("#WorkInfo").css("color","gray");
	});
	$("#WorkInfo").mouseout(function(){
		$("#WorkInfo").css("color","DarkSeaGreen");
	});
	$("#WorkInfo").click(function(){
		$("#WorkText").fadeToggle(600);
		$("#IntroduceText").hide();
		$("#EducationText").hide();
		$("#AddressText").hide();
	});
	$("#EducationInfo").mouseover(function(){
		$("#EducationInfo").css("color","gray");
	});
	$("#EducationInfo").mouseout(function(){
		$("#EducationInfo").css("color","DarkSeaGreen");
	});
	$("#EducationInfo").click(function(){
		$("#EducationText").fadeToggle(600);
		$("#IntroduceText").hide();
		$("#WorkText").hide();
		$("#AddressText").hide();
	});
	$("#IntroduceMyself").mouseover(function(){
		$("#IntroduceMyself").css("color","gray");
	});
	$("#IntroduceMyself").mouseout(function(){
		$("#IntroduceMyself").css("color","DarkSeaGreen");
	});
	$("#IntroduceMyself").click(function(){
		$("#IntroduceText").fadeToggle(600);
		$("#EducationText").hide();
		$("#WorkText").hide();
		$("#AddressText").hide();
	});
	
	$("#alterAddress").click(function(){
		var address = $(":input[name = 'address']").val();
		if(address == ""){
			alert("请完整输入信息！");
		}else{
			$.post("alter_alterAddress",{"address":address},function(data){
				$("#font1").html(data);
				$("#AddressText").fadeOut();
			});
		}
	});
	
	$("#alterWorktype").click(function(){
		var worktype = $(":input[name = 'worktype']").val();
		if(worktype == ""){
			alert("请完整输入信息！");
		}else{
			$.post("alter_alterWorkType",{"worktype":worktype},function(data){
				$("#font2").html(data);
				$("#WorkText").fadeOut();
				
			});
		}
	});
	$("#alterEducation").click(function(){
		var education = $(":input[name = 'education']").val();
		if(education == ""){
			alert("请完整输入信息！");
		}else{
			$.post("alter_alterEducation",{"education":education},function(data){
				$("#font3").html(data);
				$("#EducationText").fadeOut();
				
			});
		}
	});
	$("#alterIntroduce").click(function(){
		var introduce = $(":input[name = 'introduce']").val();
		if(introduce == ""){
			alert("请完整输入信息！");
		}else{
			$.post("alter_alterIntroduce",{"introduce":introduce},function(data){
				$("#font4").html(data);
				$("#IntroduceText").fadeOut();
			});
		}
	});
});