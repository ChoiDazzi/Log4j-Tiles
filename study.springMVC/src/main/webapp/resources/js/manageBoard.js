let modifyBtns = document.querySelectorAll(".modifyBtn");
let deleteBtns = document.querySelectorAll(".deleteBtn");
modifyBtns.forEach((modifyBtn) => {
	modifyBtn.addEventListener("click", () => {
		let boardVO = {
			"boardId": modifyBtn.getAttribute("data-id"),
			"boardNm": modifyBtn.previousElementSibling.value
		}
		
		$.ajax({
			url: '/board/modifyBoard',
			type: 'post',
			data: boardVO,
			success: function() {
				//location.href = "/board/manageBoard";
				window.location.reload();
			},
			error: function(xhr) {
				console.log(xhr.status);
			}
		});
	});
});

deleteBtns.forEach((deleteBtn) => {
	deleteBtn.addEventListener("click", () => {
		let boardId = deleteBtn.getAttribute("data-id");
		console.log(`/board/deleteBoard/${boardId}`)
		$.ajax({
			url: `/board/deleteBoard/${boardId}`,
			type: 'post',
			success: function() {
				window.location.href = "/board/manageBoard";
			},
			error: function(xhr) {
				console.log(xhr.status);
			}
		});
	});
});