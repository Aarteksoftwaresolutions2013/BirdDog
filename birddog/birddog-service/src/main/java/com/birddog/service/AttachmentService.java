package com.birddog.service;

import java.util.List;

import com.birddog.model.Attachment;
import com.birddog.model.Lead;

/**
 * 
 * @author Aartek
 *
 */
public interface AttachmentService {
    /**
     * Save images
     * 
     * @param images
     * @param lead
     */
    public void saveImages(List<String> images, Lead lead);

	public List<Attachment> findImageNameById(Integer id);

	public List<Attachment> getAllAttachment(Integer id);
}
