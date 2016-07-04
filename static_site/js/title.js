window.addEventListener("load", function() {
  document.getElementById('title').innerHTML =
      '<div class="navigation">\n'+
      '<div class="set_word">\n' +
      '<a href="index.html"><img src="image/kehu.png"></a>\n' +
      '  </div>\n' +
      '  <div class="title_search">\n' +
      '      <form>\n' +
      '          <input type="search" id="ts_search">\n' +
      '          <input type="submit" class="submit" value="">\n' +
      '      </form>\n' +
      '  </div>\n' +
      '  <div class="change_content">\n' +
      '      <a id="discover" class="ccp_focus" href="index.html">发现</a>\n' +
      '      <a id="topic" class="ccp_now" href="topic.html">话题</a>\n' +
      '  </div>\n' +
      '  <!--#if(!$isLogin)-->\n' +
      '  <div class="title_right">\n' +
      '      <a href="regist.html" target="_top">注册</a>\n' +
      '      <a href="login.html" target="_top">登录</a>\n' +
      '  </div>\n' +
      '  <!--#else\n' +
      '  <div class="logout">\n' +
      '  <a>退出登录</a>\n' +
      '</div-->\n' +

      '<div class="master_rignt">\n' +
      '  <div class="m_r_div1" id="notification">\n' +
      '    <a>\n' +
      '<img src="image/message.png">\n' +
      '</a>\n' +
      '  </div>\n' +
      '  <div class="m_r_div2" id="title_self">\n' +
      '  <a href="self.html">\n' +
      '<img src="image/my_pic.jpg">\n' +

      '<p>Huster</p>\n' +
      '</a>\n' +
      '</div>\n' +
      '</div>\n'+
      '</div>\n'+

  '<div id="news">\n'+
          '<p>胡一鸣赞了你的评论</p>\n'+
          '<p>唐旻回答了问题：东九被淹了怎么办</p>'+
  '<div>';
    var discover = document.getElementById("discover");
    var topic = document.getElementById("topic");
    var title_self=document.getElementById("title_self");
/*  var discoverContent = document.getElementById("discoverContent");
  var topicContent = document.getElementById("topicContent");*/
    var mynews=document.getElementById("news");
    var message=document.getElementById("notification");


/*

  discover.onclick = function(event) {
    topic.className = "ccp_now";
    discover.className = "ccp_focus";
  };
  topic.onclick = function(event) {
    discover.className = "ccp_now";
    topic.className = "ccp_focus";
  };
*/

    discover.onclick=function(event){
        discover.style.backgroundColor="#55B6A2";
        topic.style.backgroundColor="rgb(94, 206, 184)";
        title_self.style.backgroundColor="rgb(94, 206, 184)";
    };
    topic.onclick=function(event){
        discover.style.backgroundColor="rgb(94, 206, 184)";
        topic.style.backgroundColor="#55B6A2";
        title_self.style.backgroundColor="rgb(94, 206, 184)";
    };
    title_self.onclick=function(event){
        discover.style.backgroundColor="rgb(94, 206, 184)";
        topic.style.backgroundColor="rgb(94, 206, 184)";
        title_self.style.backgroundColor="#55B6A2";
    };

    message.onclick=function(event){
        mynews.style.display="block";
        stopBubble(event);
        document.onclick=function(){
            mynews.style.display='none';
            document.onclick=null;
        }
    };
    mynews.onclick=function(event){
        //只阻止了向上冒泡，而没有阻止向下捕获，所以点击的内部对象时，仍然可以执行这个函数
        stopBubble(event);
    };
    //阻止冒泡函数
    function stopBubble(e){
        if(e && e.stopPropagation){
            e.stopPropagation();  //w3c
        }else{
            window.event.cancelBubble=true; //IE
        }
    }

});
