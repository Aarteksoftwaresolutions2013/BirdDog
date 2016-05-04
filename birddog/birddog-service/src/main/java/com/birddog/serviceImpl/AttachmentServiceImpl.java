package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birddog.model.Attachment;
import com.birddog.model.Lead;
import com.birddog.repository.AttachmentRepository;
import com.birddog.service.AttachmentService;
import com.birddog.util.DateUtil;
import com.birddog.util.IConstant;

/**
 * 
 * @author Aartek
 *
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
	
    @Autowired
    private AttachmentRepository attachmentRepository;

    public void saveImages(List<String> images, Lead lead) {
        if (null != images && !images.isEmpty()) {
            for (String imagesImage : images) {
                Attachment attachment = new Attachment();
                attachment.setPath(imagesImage);
                attachment.setLead(lead);
                attachment.setCreationTime(DateUtil.todayDate());
                attachment.setUpdationTime(DateUtil.todayDate());
                attachment.setIsDeleted(IConstant.IS_DELETED);
                attachmentRepository.save(attachment);
            }
        }
    }

	public List<Attachment> findImageNameById(Integer id) {
		
		return attachmentRepository.findByLeadId(id);
	}

	public List<Attachment> getAllAttachment(Integer id) {
		return attachmentRepository.findByLeadId(id);
		
	}
}
