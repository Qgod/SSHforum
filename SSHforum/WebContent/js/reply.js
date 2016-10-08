/**
 * 
 */

$(document).ready(function(){
	$(".replySpan").click(function(){
		$(".reply").slideToggle();
	});
	
	$(".comment-region-praise").click(function(){
		
		//var cm_id = $(":input[name = 'cm_id']").val();
		var $this=$(this);
		var cm_id=$this.children('input').val();
		var url = "praise_AddPraise";
		var args={"commentid":cm_id};
		$.post(url,args,function(data){
			$this.children("span").html("("+data+")");
		});
		
	});
	
	
	
});