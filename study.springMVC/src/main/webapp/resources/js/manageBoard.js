fn_modifyBoard = (id) => {
	let nm = document.querySelector(`input[data-id="${id}"]`).value;
	let boardVO = {
		"boardId": id,
		"boardNm": nm
	}
	console.log(boardVO)
	$.ajax({
		url: '/board/modifyBoard',
		type: 'post',
		data: boardVO,
		success: function() {
			document.location.href = document.location.href;
		},
		error: function(xhr) {
			console.log(xhr.status);
		}
	});
}

fn_deleteBoard = (id) => {
	$.ajax({
		url: `/board/deleteBoard`,
		type: 'post',
		data: "id="+id,
		success: function() {
			document.location.href = document.location.href;
		},
		error: function(xhr) {
			console.log(xhr.status);
		}
	});
}

