package com.abror.repasitory;

import com.abror.entity.Category;
import com.abror.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(nativeQuery = true,value = "select author_name from category where category_type = ?1")
    List<String> getAuthorNames(String categoryType);


}
