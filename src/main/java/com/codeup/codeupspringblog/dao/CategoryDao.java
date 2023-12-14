package com.codeup.codeupspringblog.dao;
import com.codeup.codeupspringblog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Long> {

}