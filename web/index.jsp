<%--
  Created by IntelliJ IDEA.
  User: huyiming
  Date: 15/11/13
  Time: 下午7:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>华科问答</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/change.js"></script>
    <script type="text/javascript" src="js/rigist.js"></script>
</head>
<body>
    <div class="title">
        <div class="set_word">
            
        </div>

        <div class="title_search">
            <form>
                <input type="search" id="ts_search">
                <input type="submit" class="submit" value="">
            </form>
        </div>
        
        <div class="change_content">
            <a id="cc_p1" class="ccp_focus">发现</a>
            <a id="cc_p2" class="ccp_now">话题</a>
        </div>

        <div class="title_right">
            <a href="rigister.html">注册</a>
            <a href="logon.html">登录</a>
        </div>
    </div>

    <div class="content" id="content">
        <div class="c_top">
            <div class="ct_top">
                <div class="ctl_div">
                    <p>发现</p>
                </div>

                <div class="ctr_div">
                    <ul>
                        <li id="page1" class="li_change">最新</li>
                        <li id="page2" class="li_now">热门</li>
                        <li id="page3" class="li_now">等待回复</li>
                    </ul>
                </div>
            </div>

            <div class="ct_down">
                <div class="div_show" id="cld_div1">
                    <div class="d_s_div"><!--所有主贴用这个class的样式-->
                        <p class="d_s_d_p">华中科技大学研究生考试时间是什么时候？初试跟复试的</p>
                        <div class="float_left">
                            <div class="f_t_top">
                                <img src="img/up.png">
                                <!--这里的img可以在前面加a做链接-->
                                <p>30</p>  
                            </div>

                            <div class="f_t_down">
                                <img src="img/down.png">  
                            </div>
                        </div>
                        <div class="float_right">
                            <h4>秀秀</h4>
                            <p>按正常以往华科发布的华中科技大学研究生考试时间来看，初始一般在12月27-28号这两天，服饰的话正常实在3-4月份，复试分数线出来以后，就差不多要进行复试面试了。由于是自主划线学校，所以会比国家线晚出。</p>
                            <div class="f_r_com_div">
                                <img src="img/comment.png">
                                <span>3条评论</span>
                                <img src="img/comment.png">
                                <span>添加回答</span>
                            </div>
                        </div>
                        <div class="clear"><!--此处是清除浮动的块--></div>
                    </div>
                </div>
                <div class="div_hidden" id="cld_div2">
                    222
                </div>
                <div class="div_hidden" id="cld_div3">
                    333
                </div>
            </div>
        <div class="clear"></div>
        </div>

        <div class="c_right">

            <p>今天你遇到了什么问题?</p>

            <div class="p_form">
                <form action="" method="post">
                    <input type="text" placeholder="写下你的问题">
                    <label for="miaoshu">问题说明:</label>
                    <textarea id="miaoshu" placeholder="问题的详细描述，选填"></textarea>
                    <label for="huati">选择话题:</label>
                    <input type="text" id="huati"><br>
                    <input type="submit" class="p_f_sub" value="提交问题">
                </form>
            </div>

        </div>
    
    </div>

    <div class="content1" id="content1">
        
    </div>
</body>
</html>