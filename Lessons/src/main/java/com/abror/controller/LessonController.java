package com.abror.controller;

import com.abror.entity.Lesson;
import com.abror.payload.LessonPayload;
import com.abror.service.LessonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public boolean addLesson(LessonPayload lessonPayload) {
        log.info("addLesson: {}", lessonPayload);
        return lessonService.addLesson(lessonPayload);
    }
    
    @GetMapping
    public List<Lesson> getLessonByCategory(@RequestParam("author") String authorName,
                                            @RequestParam("categoryType") String categoryType) {
        return lessonService.getLessonsByCategory(authorName, categoryType);
    }

    @DeleteMapping
    public boolean deleteLesson(@PathVariable Integer lessonId) {
        return lessonService.deleteLesson(lessonId);
    }
}
