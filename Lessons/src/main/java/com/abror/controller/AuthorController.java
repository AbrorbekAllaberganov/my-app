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
        return authorservice.addAuthor(authorPayload);
    }

    @DeleteMapping("/{authorId}")
    public boolean deleteAuthor(@PathVariable Integer authorId){
        return authorservice.deleteAuthor(authorId);
    }

    @GetMapping("/{authorType}")
    public List<Author> getAuthorAuthorList(@PathVariable String authorType){
        return authorservice.getAuthorListByType(authorType);
    }

    @PutMapping("/{authorId}")
    public boolean updateAuthor(@PathVariable Integer authorId, @RequestBody AuthorPayload authorPayload){
        return authorservice.updateAuthor(authorId, authorPayload);
    }

    @GetMapping
    public List<Author> getAuthorList(){
        return authorservice.getAuthorList();
    }

    @GetMapping("/get/{authorId}")
    public Author getAuthorById(@PathVariable Integer authorId){
        return authorservice.getAuthorById(authorId);
    }

}
