package com.abror.repasitory;

import com.abror.entity.Category;
import com.abror.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    @Query(nativeQuery = true,value = "select * from category where category_type =?1 and author_name =?2")
    List<Lesson> getLessonsByCategory(String categoryType, String authorName);

}
