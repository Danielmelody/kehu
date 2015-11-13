function pchange(i){
    var p1=document.getElementById("choose1");
    var p2=document.getElementById("choose2");

    var form1=document.getElementById("view1");
    var form2=document.getElementById("view2");

    if (i==1) {
        form1.className="view";
        form2.className="viewn";
        p1.className="pchange";
        p2.className="pbefore";
    }
    if (i==2) {
        form2.className="view";
        form1.className="viewn";
        p1.className="pbefore";
        p2.className="pchange";
    }
}
