window.onload=function(){
    li_change();
    title_change();
}

function title_change(){
    var p1=document.getElementById("cc_p1");
    var p2=document.getElementById("cc_p2");
    var content=document.getElementById("content");
    var content1=document.getElementById("content1");

    p1.onclick=function(){
        p2.className="ccp_now";
        p1.className="ccp_focus";
        content.style.display="block";
        content1.style.display="none";
    }
    p2.onclick=function(){
        p1.className="ccp_now";
        p2.className="ccp_focus";
        content1.style.display="block";
        content.style.display="none";
    }
}

//////////////////此处没完成
function li_change(){
    var page1=document.getElementById("page1");
    var page2=document.getElementById("page2");
    var page3=document.getElementById("page3");

    page1.addEventListener("click",function(){
        page1.className="li_change";
        page2.className="li_now";
        page3.className="li_now";
        page_change(1);
    });
    page2.addEventListener("click",function(){
        page2.className="li_change";
        page1.className="li_now";
        page3.className="li_now";
        page_change(2);
    });
    page3.addEventListener("click",function(){
        page3.className="li_change";
        page1.className="li_now";
        page2.className="li_now";
        page_change(3);
    });

}

function page_change(page_now){
        var div1=document.getElementById("cld_div1");
        var div2=document.getElementById("cld_div2");
        var div3=document.getElementById("cld_div3");

        div1.className="div_hidden";
        div2.className="div_hidden";
        div3.className="div_hidden";
        if (page_now==1) {
            div1.className="div_show";
        }
        else if(page_now==2){
            div2.className="div_show";
        }
        else if(page_now==3){
            div3.className="div_show";
        }
    }