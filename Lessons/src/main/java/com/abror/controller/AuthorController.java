package com.abror.controller;

import com.abror.entity.Author;
import com.abror.payload.AuthorPayload;
import com.abror.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lessons/author")
@RequiredArgsConstructor
@Slf4j
public class AuthorController {
    private final AuthorService authorservice;

    @PostMapping
    public boolean addAuthor(@RequestBody AuthorPayload authorPayload){
        System.out.println(authorPayload);
        return authorservice.addCategory(authorPayload);
    }

    @DeleteMapping("/{categoryId}")
    public boolean deleteCategory(@PathVariable Integer categoryId){
        return authorservice.deleteAuthor(categoryId);
    }

    @GetMapping("/{categoryType}")
    public List<String> getCategoryAuthorNames(@PathVariable String categoryType){
        return authorservice.getAuthorNames(categoryType);
    }

    @PutMapping("/{categoryId}")
    public boolean updateCategory(@PathVariable Integer categoryId, @RequestBody AuthorPayload authorPayload){
        return authorservice.updateAuthor(categoryId, authorPayload);
    }

    @GetMapping
    public List<Author> getAuthorList(){
        return authorservice.getAuthorList();
    }

}
