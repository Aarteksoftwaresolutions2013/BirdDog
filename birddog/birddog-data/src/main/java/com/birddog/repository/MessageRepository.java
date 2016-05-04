package com.birddog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByReInvestorId(Integer id);
}
