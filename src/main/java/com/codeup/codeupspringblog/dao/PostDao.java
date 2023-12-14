package com.codeup.codeupspringblog.dao;

import com.codeup.codeupspringblog.models.Post;//object relational mapping
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDao extends JpaRepository<Post, Long> {

}