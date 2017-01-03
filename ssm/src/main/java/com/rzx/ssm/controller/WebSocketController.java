package com.rzx.ssm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import com.rzx.ssm.util.HTMLFilter; 

@ServerEndpoint(value = "/websocket/chat")
public class WebSocketController {


    private static final String GUEST_PREFIX = "Guest";
    //一个提供原子操作的Integer的类。在Java语言中，++i和i++操作并不是线程安全的，在使用的时候，不可避免的会用到synchronized关键字。而AtomicInteger则通过一种线程安全的加减操作接口。
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    //储存连接的客户端的信息
    private static final Map<String,Object> connections = new HashMap<String,Object>();
    
    //昵称
    private final String nickname;
    //使用session 存入用户身份，然后在发出的时候 根据session里面的 值进行判断发送消息
    private Session session;

    public WebSocketController() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }


    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.put(nickname, this); 
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(message);
    }


    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message);
    }


    /**
     * 消息发送触发方法
     * @param message
     */
    @OnMessage
    public void incoming(String message) {
        // Never trust the client
        String filteredMessage = String.format("%s: %s",
                nickname, HTMLFilter.filter(message.toString()));
        broadcast(filteredMessage);
    }

    @OnError
    public void onError(Throwable t) throws Throwable {
       System.out.println(" onError error");
    }

    /**
     * 消息发送方法
     * @param msg
     */
    private static void broadcast(String msg) {
    	if(msg.indexOf("Guest0")!=-1){
    		sendUser(msg);
    	} else{
    		sendAll(msg);
    	}
    } 
    
    /**
     * 向所有用户发送
     * @param msg
     */
    public static void sendAll(String msg){
    	for (String key : connections.keySet()) {
        	WebSocketController client = null ;
            try {
            	client = (WebSocketController) connections.get(key);
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) { 
               e.printStackTrace();
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }
    
    /**
     * 向指定用户发送消息 
     * @param msg
     */
    public static void sendUser(String msg){
    	WebSocketController c = (WebSocketController)connections.get("Guest0");
		try {
			c.session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
            connections.remove(c);
            try {
                c.session.close();
            } catch (IOException e1) {
                // Ignore
            }
            String message = String.format("* %s %s",
                    c.nickname, "has been disconnected.");
            broadcast(message);  
		} 
    }
}
