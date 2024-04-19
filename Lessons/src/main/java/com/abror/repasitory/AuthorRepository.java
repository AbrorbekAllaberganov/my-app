package com.abror.repasitory;

import com.abror.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(nativeQuery = true,value = "select author_name from category where category_type = ?1")
    List<String> getAuthorNames(String categoryType);

    @Query(nativeQuery = true,value = "select * from category where author_name=?1 and category_type=?2")
    Author getCategoryByTypeAndAuthorName(String authorName, String categoryType);
}
