package com.abror.repasitory;

import com.abror.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    @Query(nativeQuery = true,value = "select * from lesson where category_id = ?")
    List<Lesson> getLessonsByCategoryId(Integer categoryId);

    @Query(nativeQuery = true,value = "SELECT l.* FROM lesson l JOIN category c ON l.category_id = c.id " +
            "WHERE c.author_name = ?1 AND c.category_type = ?2")
    List<Lesson> getLessonsByAuthorNameAndCategoryType(String authorName,String categoryType);
}
