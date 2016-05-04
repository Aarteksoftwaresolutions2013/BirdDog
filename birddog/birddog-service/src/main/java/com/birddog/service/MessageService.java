package com.birddog.service;

import java.util.List;

import com.birddog.model.Message;

public interface MessageService extends Service<Message> {

	List<Message> getMessage(Integer id);

	List<Message> getAllMessage(Integer id);

}
