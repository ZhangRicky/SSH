package com.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息接收者
 * 
 * @author Mark
 *
 */
public class MessagerReceiver {
	// 默认连接名
	public static final String USER_NAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码
	public static final String PASS_WORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认连接地址
	public static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	// 发送的消息数量
	public static final Integer NUMBER = 10;

	public static void main(String[] args) throws JMSException {
		// 连接工程
		ConnectionFactory fatory;
		// 连接
		Connection conn = null;
		// Session
		Session session = null;
		// 消息的目的地
		Destination destination;
		//消息的消费者
		MessageConsumer messageConsumer;
		try{
			fatory = new ActiveMQConnectionFactory(USER_NAME, PASS_WORD, BROKEURL);
			conn = fatory.createConnection();
			// 先要启动连接
			conn.start();
			// 创建Session
			session = conn.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 创建一个Hello的消息队列
			destination = session.createQueue("World");
			//创建接收者
			messageConsumer = session.createConsumer(destination);
			while(true){
				TextMessage textMessage =(TextMessage) messageConsumer.receive(100000);
				if(textMessage != null){
	                System.out.println("收到的消息:" + textMessage.getText());
	            }else {
	                break;
	            }
			}
				
		}catch(JMSException e){
			session.rollback();
			e.printStackTrace();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}

