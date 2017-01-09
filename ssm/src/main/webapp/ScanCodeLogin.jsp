<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<!-- jquery-qrcode -->
<script type="text/javascript"
	src="http://cdn.staticfile.org/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<!-- 中文转码 -->
<script type="text/javascript">  
var each;
var randomValue=24838094943420424;
/**
 *识别中文 
 **/
function toUtf8(str) {    
    var out, i, len, c;    
    out = "";    
    len = str.length;    
    for(i = 0; i < len; i++) {    
        c = str.charCodeAt(i);    
        if ((c >= 0x0001) && (c <= 0x007F)) {    
            out += str.charAt(i);    
        } else if (c > 0x07FF) {    
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));    
            out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));    
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
        } else {    
            out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));    
            out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
        }    
    }    
    return out;    
} 
/**
 * 生成随机数 
 */
function GetRandomNum(Min,Max)
{   
	var Range = Max - Min;   
	var Rand = Math.random();   
	return(Min + Math.round(Rand * Range));   
}  

/**
 * ajax 请求服务器数据
 */
function ajaxGetLoginResult(){
// 	alert('迭代器id = '+each);
	$.get("./scan/login/"+randomValue,
	 	function(data,status){
		if(data==true ){
			alert(randomValue);
            alert("登录成功");
            window.location.href="https://www.baidu.com";
/**
 * window.location.href="./index.jsp";
 */
        }   
	  });
}
    /**
    	网页加载完成后执行里面的方法
    **/
    $(function(){ 
    	//randomValue=GetRandomNum(100000,1000000);
    	$("#qcode").qrcode({ 
    	    render: "table", //table方式 
    	    width: 80, //宽度 
    	    height:80, //高度 
//     	    text: randomValue+"" //任意内容
    	    text:"./login/24838094943420424/"+randomValue
    	}); 
    	ajaxGetLoginResult();
//     	each=window.setInterval("ajaxGetLoginResult()",1000);
    	}); 
</script>
</head>
<body>
	get qcode
	<a></a>
	<div id="qcode"></div>
</body>
</html>