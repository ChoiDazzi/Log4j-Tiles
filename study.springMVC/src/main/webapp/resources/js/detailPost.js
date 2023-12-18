let backBtn = document.querySelector('#backBtn');
let postId = document.querySelector('input[name="postId"]').value;
let boardId = document.querySelector('#boardNm').getAttribute('data-id');
let modify = document.querySelector('#modify');
let modifyBtn = document.querySelector('#modifyBtn');
let deleteBtn = document.querySelector('#deleteBtn');
let cancelBtn = document.querySelector('#cancelBtn');
let inputTitle = document.querySelector('input[name="postTtl"]');
let content = document.querySelector('textarea[name="postCnt"]');
let before = document.querySelector('.before');
let after = document.querySelector('.after');
let modifyFileDiv = document.querySelector('#modifyFileDiv');
let accordionBody = document.querySelector('#accordionOne');
let deleteFileBtns = document.querySelectorAll('.deleteFileBtn');
let accordionBtn = document.querySelector('.accordion-button');
let deleteFileIdList = [];

fn_active = () => {
	after.style.display = 'block';
    before.style.display = 'none';
}

fn_inactive = () => {
	after.style.display = 'none';
    before.style.display = 'block';
}

fn_rmAttr = () => {
	inputTitle.removeAttribute('readonly');
    content.removeAttribute('readonly');
}

fn_setAttr = () => {
	inputTitle.setAttribute('readonly', 'true');
	content.setAttribute('readonly', 'true');
}

fn_modifyDnone = () => {
	modifyFileDiv.classList.remove('d-none');
	accordionBody.classList.add('d-none');
	deleteFileBtns.forEach(deleteFileBtn => {
		deleteFileBtn.classList.remove('d-none');
	})
}

fn_deleteFile = (element) => {
    let parentDiv = element.closest('.me-3');
    parentDiv.remove();
    deleteFileIdList.push(element.getAttribute('data-id'));
}

accordionBtn.addEventListener('click', (e) => {
	target = e.target;
	if(target.classList.contains('a-tag')) {
		url = target.getAttribute('href');
		location.href = url;
	}
});

backBtn.addEventListener('click', () => {
    location.href = `/board/board/${boardId}`;
});

modify.addEventListener('click', () => {
	fn_modifyDnone();
    fn_rmAttr();
    fn_active();
});

cancelBtn.addEventListener('click', () => {
    location.reload();
});

modifyBtn.addEventListener('click', () => {
    let frm = document.querySelector('#frm');
    let data = new FormData(frm);
    data.append("deleteFileIdList", deleteFileIdList);

    if (confirm('수정하시겠습니까?')) {
        $.ajax({
            url: '/post/modifyPost',
            type: 'post',
            processData:false,
            contentType:false,
            data: data,
            success: function() {
				location.href = `/post/detailPost/${boardId}/${postId}`;
			},
            error: function (xhr) {
                console.log(xhr.status);
            }
        });
    }
});

deleteBtn.addEventListener('click', () => {
    if (confirm('삭제하시겠습니까?')) {
        $.ajax({
            url: `/post/deletePost`,
            type: 'post',
            data: 'postId='+postId,
            success: function() {
				location.href = `/board/board/${boardId}`;
			},
            error: function (xhr) {
                console.log(xhr.status);
            }
        });
    }
});

