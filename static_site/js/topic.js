function changeLi() {

    console.log("ok");

    var page1 = document.getElementById("topicPage1");
    var page2 = document.getElementById("topicPage2");

    page1.addEventListener("click", function() {
        page1.className = "li_change";
        page2.className = "li_now";
        page_change(1);
    });
    page2.addEventListener("click", function() {
        page2.className = "li_change";
        page1.className = "li_now";
        page_change(2);
    });

}

function page_change(page_now) {
    var div1 = document.getElementById("top_div1");
    var div2 = document.getElementById("top_div2");

    div1.className = "div_hidden";
    div2.className = "div_hidden";
    if (page_now == 1) {
        div1.className = "div_show";
    } else if (page_now == 2) {
        div2.className = "div_show";
    }
}

changeLi();

    var att_btn=document.getElementById("att_btn");
    att_btn.onclick = function(event){
        if(att_btn.className=="cancel_att"){
            att_btn.className="add_att";
            att_btn.value="关注话题+";
        }
        else {
            att_btn.className="cancel_att";
            att_btn.value="—取消关注";
        }
    };

    var att_btn2=document.getElementById("att_btn2");
    att_btn2.onclick = function(event){
        if(att_btn2.className=="cancel_att"){
        att_btn2.className="add_att";
        att_btn2.value="关注话题+";
        }
        else {
            att_btn2.className="cancel_att";
            att_btn2.value="—取消关注";
        }
    };

