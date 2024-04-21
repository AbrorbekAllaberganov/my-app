package com.abror.repasitory;

import com.abror.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query(nativeQuery = true, value = "select * from author where author_type = ?1")
    List<Author> getAuthorsByType(String authorType);

}
