package com.abror.repository;

import com.abror.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(nativeQuery = true, value = "select * from book where type=?1")
    List<Book> findAllByType(String type);
}
