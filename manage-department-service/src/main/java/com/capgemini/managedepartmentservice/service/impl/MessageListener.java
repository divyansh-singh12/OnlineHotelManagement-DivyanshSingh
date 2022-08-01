package com.capgemini.managedepartmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.capgemini.managedepartmentservice.MqConfig;
import com.capgemini.managedepartmentservice.model.CustomMessage;

@Component
public class MessageListener {

	private static List<String> messageList = new ArrayList<String>();

	@RabbitListener(queues = MqConfig.QUEUE)
	public void listener(CustomMessage message) {
		try {
		notifications(message);
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	public void notifications(CustomMessage message) {
		StringBuilder str = new StringBuilder(message.getMessage());
		str.append("at ").append(message.getMessageDate());
		messageList.add(str.toString());

	}

	public static List<String> getMessageList() {
		return messageList;
	}

	public static void setMessageList(List<String> messageList) {
		MessageListener.messageList = messageList;
	}
}