<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
	<body>
		<button type="button" onclick="connect();">Switch</button>
		<c:set var="room" value="${roomById}"/>
		<h1>${room.roomName}</h1>
		<c:if test = "${room.enabled == true}">
			<img id="1" src="/img/green.png">	
		</c:if>
		<c:if test = "${room.enabled == false}">
			<img id="1" src="/img/red.png">	
		</c:if>

		<button id="switchButton" type="button" onclick="sendMessage();">Switch</button>

		<script>
		    var stompClient = null;
		     
		    function connect() {
		        var socket = new SockJS('/request');
		        stompClient = Stomp.over(socket);  
		        stompClient.connect({}, function(frame) {
		            stompClient.subscribe('/topic/messages', function(messageOutput) {
		                showMessageOutput(messageOutput.body);
		            });
		        });
		    }
		     
		    function sendMessage() {
		        var text = ${room.id};
		        stompClient.send("/app/request", {}, text);
		    }
		     
		    function showMessageOutput(messageOutput) {
		    	sendRequest();
		    }
		    function sendRequest()  
		    {
	    	   var roomId = ${room.id}
	           $.ajax({
	               type:'POST',
	               dataType: "json",
	               data: {id:roomId},
	               url:"<c:url value="/changeCondition"/> ",
	               success: funcSuccess
	           });
		    };
		    function funcSuccess(data) {
		    	var image1 = new Image();
		    	var image2 = new Image();
		    	image1.src = '/img/green.png';
		    	image2.src = '/img/red.png';
		    	if(data) {
		    		document.getElementById('1').src = image1.src;	
		    	} else {
		    		document.getElementById('1').src = image2.src;	
		    	}
		    }	 
		</script>	
	</body>
</html>