package com.abror.service;

import com.abror.entity.Lesson;
import com.abror.payload.LessonPayload;
import com.abror.repasitory.AuthorRepository;
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
    private final AuthorRepository authorRepository;

    public boolean addLesson(LessonPayload lessonPayload) {
        try {
            Lesson lesson = Lesson.builder()
                    .title(lessonPayload.getTitle())
                    .description(lessonPayload.getDescription())
                    .videoId(lessonPayload.getVideoId())
                    .author(authorRepository.getById(lessonPayload.getAuthorId()))
                    .build();
            lessonRepository.save(lesson);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add lesson - {}" + e.getMessage());
        }
        return false;
    }

    public List<Lesson> getLessonsByCategory(int authorId) {
//        Category category =categoryRepository.getCategoryByTypeAndAuthorName(authorName, categoryType);
        return lessonRepository.getLessonsByAuthorId(authorId);
    }

    public boolean deleteLesson(Integer lessonId) {
        try {
            lessonRepository.deleteById(lessonId);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of delete lesson - {}" + e.getMessage());
        }
        return false;
    }

    public boolean updateLesson(Integer lessonId, LessonPayload payload) {
        try {
            if (lessonRepository.existsById(lessonId)) {
                Lesson lesson = Lesson.builder()
                        .id(lessonId)
                        .title(payload.getTitle())
                        .description(payload.getDescription())
                        .videoId(payload.getVideoId())
                        .author(authorRepository.getById(payload.getAuthorId()))
                        .build();
                lessonRepository.save(lesson);
                return true;
            }else {
                log.error("Lesson id is not found");
            }
        } catch (Exception e) {
            log.error("Exception is in the method of update lesson - {}" + e.getMessage());
        }
        return false;
    }

}
