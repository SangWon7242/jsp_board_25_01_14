console.clear();

function ArticleSave__submitForm(form) {
  form.subject.value = form.subject.value.trim();

  if(form.subject.value.length == 0) {
    alert("제목을 입력해주세요.");
    form.subject.focus();
    return;
  }

  form.content.value = form.content.value.trim();

  if(form.content.value.length == 0) {
    alert("내용을 입력해주세요.");
    form.content.focus();
    return;
  }

  form.submit();
}