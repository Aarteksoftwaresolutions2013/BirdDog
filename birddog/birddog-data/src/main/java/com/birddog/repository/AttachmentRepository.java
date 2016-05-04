package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Attachment;

/**
 * 
 * @author Aartek
 *
 */
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

    List<Attachment> findByLeadId(Integer id);


}
