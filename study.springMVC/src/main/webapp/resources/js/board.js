let registerBtn = document.querySelector("#registerPost");
let boardId = document.querySelector("#boardNm").getAttribute("data-id");
registerBtn.addEventListener("click", () => {
    location.href = `/board/registerPost/${boardId}`;
});
