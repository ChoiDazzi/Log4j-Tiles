let backBtn = document.querySelector("#backBtn");
let postId = document.querySelector("input[name='postId']").value;
let boardId = document.querySelector("#boardNm").getAttribute("data-id");
let modify = document.querySelector("#modify");
let modifyBtn = document.querySelector("#modifyBtn");
let deleteBtn = document.querySelector("#deleteBtn");
let cancelBtn = document.querySelector("#cancelBtn");
let inputTitle = document.querySelector("input[name='postTtl']");
let content = document.querySelector("textarea[name='postCnt']");
let before = document.querySelector(".before");
let after = document.querySelector(".after");

fn_active = () => {
	after.style.display = "block";
    before.style.display = "none";
}

fn_inactive = () => {
	after.style.display = "none";
    before.style.display = "block";
}

backBtn.addEventListener("click", () => {
    location.href = `/board/board/${boardId}`;
});

modify.addEventListener("click", () => {
    inputTitle.removeAttribute("readonly");
    content.removeAttribute("readonly");
    fn_active();
});

cancelBtn.addEventListener("click", () => {
    fn_inactive();
});

modifyBtn.addEventListener("click", () => {
    let frm = document.querySelector("#frm");
    let postVO = new FormData(frm);
    if (confirm("수정하시겠습니까?")) {
        $.ajax({
            url: '/post/modifyPost',
            type: 'post',
            processData:false,
            contentType:false,
            data: postVO,
            success: function() {
				after.style.display = "none";
    			before.style.display = "block";
			},
            error: function (xhr) {
                console.log(xhr.status);
            }
        });
    }
});

deleteBtn.addEventListener("click", () => {
    if (confirm("삭제하시겠습니까?")) {
        $.ajax({
            url: `/post/deletePost`,
            type: 'post',
            data: "postId="+postId,
            success: function() {
				location.href = `/board/board/${boardId}`;
			},
            error: function (xhr) {
                console.log(xhr.status);
            }
        });
    }
});

