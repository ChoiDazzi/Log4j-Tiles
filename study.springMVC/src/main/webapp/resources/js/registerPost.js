let backBtn = document.querySelector("#backBtn");
let registerPost = document.querySelector("#registerPost");
let frm = document.querySelector("#frm");
let boardId = document.querySelector('input[name=boardId]');

backBtn.addEventListener("click", () => {
    location.href = `/board/board/${boardId.value}`;
});

registerPost.addEventListener("click", () => {
  // console.log(frm.getAttribute("postTtl"));
  frm.submit();
})