package com.abror.controller;

import com.abror.payload.CategoryPayload;
import com.abror.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lessons/categories")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public boolean addCategory(@RequestBody CategoryPayload categoryPayload){
        log.info(categoryPayload.toString());
        return categoryService.addCategory(categoryPayload);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable Integer categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/{categoryType}")
    public List<String> getCategory(@PathVariable String categoryType){
        return categoryService.getAuthorNames(categoryType);
    }

    @PutMapping("/{categoryId}")
    public boolean updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryPayload categoryPayload){
        return categoryService.updateCategory(categoryId, categoryPayload);
    }

}
