package com.yuansheng.resultful.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * 
 * @author HuangHang
 *
 * @Package com.yuansheng.resultful.handler
 *
 * @Description  websocket 处理类,用户处理websocket请求...
 *
 * @date 2017年11月5日
 *  
 * @version
 *
 */

public class ApplicationWebSocketHandler implements WebSocketHandler {

	
	
	private Logger logger = Logger.getLogger(this.getClass());
    
	// 在线连接连接websocket的数量
	private static final List<WebSocketSession> onlineUsers = new ArrayList<>();
  
	
	// 关闭websocket连接时
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		logger.info("connect websocket closed.......");

		onlineUsers.remove(session);

	}

	// 连接websocket
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		logger.info("connect websocket success ....");

		onlineUsers.add(session);

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

		
		Gson gson = new Gson();
    		
			
		// 将消息JSON格式通过Gson转换成Map
		// message.getPayload().toString() 获取消息具体内容
		Map<String, Object> msg = gson.fromJson(message.getPayload().toString(), new TypeToken<Map<String, Object>>() {
		}.getType());

		logger.info("handleMessage......." + message.getPayload() + "..........." + msg);

		// 处理消息 msgContent消息内容
		TextMessage textMessage = new TextMessage(msg.get("msgContent").toString(), true);

	    sendMsgToAllUsers(textMessage);
	}

	//
	@Override
	public void handleTransportError(WebSocketSession session, Throwable arg1) throws Exception {

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	 // 给所有用户发送 信息
    public void sendMsgToAllUsers(WebSocketMessage<?> message) throws Exception{

        for (WebSocketSession user : onlineUsers) {
            user.sendMessage(message);
        }

    }

}
