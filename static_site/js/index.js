function changeLi() {

  console.log("ok");

  var page1 = document.getElementById("page1");
  var page2 = document.getElementById("page2");
  var page3 = document.getElementById("page3");

  page1.addEventListener("click", function() {
    page1.className = "li_change";
    page2.className = "li_now";
    page3.className = "li_now";
    page_change(1);
  });
  page2.addEventListener("click", function() {
    page2.className = "li_change";
    page1.className = "li_now";
    page3.className = "li_now";
    page_change(2);
  });
  page3.addEventListener("click", function() {
    page3.className = "li_change";
    page1.className = "li_now";
    page2.className = "li_now";
    page_change(3);
  });
}

function page_change(page_now) {
  var div1 = document.getElementById("cld_div1");
  var div2 = document.getElementById("cld_div2");
  var div3 = document.getElementById("cld_div3");

  div1.className = "div_hidden";
  div2.className = "div_hidden";
  div3.className = "div_hidden";
  if (page_now == 1) {
    div1.className = "div_show";
  } else if (page_now == 2) {
    div2.className = "div_show";
  } else if (page_now == 3) {
    div3.className = "div_show";
  }
}

changeLi();
