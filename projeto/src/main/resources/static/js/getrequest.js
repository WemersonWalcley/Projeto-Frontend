$( document ).ready( () => {
	
	var url = window.location;
	
	$("#btnGetFiles").click( (event) => {
		event.preventDefault();
		ajaxGet();
	});
	
	function ajaxGet(){
		$.ajax({
			type : "GET",
			dataType: "json",	
			url : "/api/file/all",
			success: (data) => {
				$("#listFiles").append('<ul>');
				$.each(data, (index, file) => {
					$("#listFiles").append('<li><a href=' + url + 'api/file/' + file.id	 +'>' + file.nome + '</a></li>');
				});
				$("#listFiles").append('</ul>');
			},
			error : (err) => {
				$("#listFiles").html(err.responseText);
			}
		});	
	}
})