package com.abror.service;

import com.abror.entity.Lesson;
import com.abror.payload.LessonPayload;
import com.abror.repasitory.CategoryRepository;
import com.abror.repasitory.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LessonService {
    private final LessonRepository lessonRepository;
    private final CategoryRepository categoryRepository;

    public boolean addLesson(LessonPayload lessonPayload) {
        try {
            Lesson lesson = Lesson.builder()
                    .title(lessonPayload.getTitle())
                    .description(lessonPayload.getDescription())
                    .videoId(lessonPayload.getVideoId())
                    .category(categoryRepository.getById(lessonPayload.getCategoryId()))
                    .build();
            lessonRepository.save(lesson);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add lesson - {}" + e.getMessage());
        }
        return false;
    }

    // todo: get lessons by categoryId - > arguments are category_author_name and category_type
    public List<Lesson> getLessonsByCategory(String authorName, String categoryType) {
        return lessonRepository.getLessonsByCategory(authorName, categoryType);
    }
    // todo: delete lesson by lessonId - > lessonId is taken by inline button

    public boolean deleteLesson(Integer lessonId) {
        try {
            lessonRepository.deleteById(lessonId);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of delete lesson - {}" + e.getMessage());
        }
        return false;
    }

}
