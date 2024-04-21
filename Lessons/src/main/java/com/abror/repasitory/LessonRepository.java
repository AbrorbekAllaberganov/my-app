package com.abror.repasitory;

import com.abror.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM lesson  WHERE author_id=?1")
    List<Lesson> getLessonsByAuthorId(int authorId);
}
