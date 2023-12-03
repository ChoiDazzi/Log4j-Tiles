let backBtn = document.querySelector("#backBtn");
let registerPost = document.querySelector("#registerPost");
let frm = document.querySelector("#frm");

backBtn.addEventListener("click", () => {
    location.href = `/board/board/${boardId}`;
});

registerPost.addEventListener("click", () => {
  frm.submit();
})