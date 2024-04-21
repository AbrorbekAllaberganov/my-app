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
    public boolean addLesson(@RequestBody LessonPayload lessonPayload) {
        return lessonService.addLesson(lessonPayload);
    }

    @GetMapping("/{authorId}")
    public List<Lesson> getLessonByAuthor(@PathVariable Integer authorId) {
        return lessonService.getLessonsByCategory(authorId);
    }

    @DeleteMapping("/{lessonId}")
    public boolean deleteLesson(@PathVariable Integer lessonId) {
        return lessonService.deleteLesson(lessonId);
    }

    @PutMapping("/{lessonId}")
    public boolean updateLesson(@PathVariable Integer lessonId, @RequestBody LessonPayload lessonPayload) {
        return lessonService.updateLesson(lessonId, lessonPayload);
    }

}
