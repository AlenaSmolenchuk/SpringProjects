package com.example.ProjectSpringBoot_2.repositories;

import com.example.ProjectSpringBoot_2.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findByTitleStartingWith(String title);
}
