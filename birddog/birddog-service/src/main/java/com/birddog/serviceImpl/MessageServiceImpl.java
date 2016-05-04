package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.Message;
import com.birddog.repository.MessageRepository;
import com.birddog.service.MessageService;
import com.birddog.util.DateUtil;
import com.birddog.util.IConstant;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageRepository messageRepository;

	public void save(Message message) {

		message.setCreationTime(DateUtil.todayDate());
		message.setUpdationTime(DateUtil.todayDate());

		message.setIsDeleted(IConstant.ZERO);

		messageRepository.save(message);
		// messageRepository.findByReInvestorId(id);

	}

	public List<Message> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Message update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public List<Message> getMessage(Integer id) {
		// TODO Auto-generated method stub
		return messageRepository.findByReInvestorId(id);
	}

	public List<Message> getAllMessage(Integer id) {
		 List<Message> messageList =messageRepository.findByReInvestorId(id);
		/*for (Message userMessage : messageList) {
			userMessage.setReInvestor(null);
        }*/
		return messageList;
	}

}
