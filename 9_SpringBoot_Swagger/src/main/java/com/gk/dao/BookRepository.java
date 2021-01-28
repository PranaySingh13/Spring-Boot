package com.gk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gk.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
