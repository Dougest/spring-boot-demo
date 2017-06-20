package com.hola.dao.dougest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hola.entity.dougest.Message;

public interface MessageDao extends JpaRepository<Message,Long>{

}
