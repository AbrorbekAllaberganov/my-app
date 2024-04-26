package com.abror.controller;

import com.abror.entity.Book;
import com.abror.payload.BookPayload;
import com.abror.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;

    @PostMapping
    public boolean addBook(@RequestBody BookPayload bookPayload) {
        log.info("Book payload: " + bookPayload);
        return bookService.addBook(bookPayload);
    }

    @PutMapping("/{bookId}")
    public boolean updateBook(@PathVariable Integer bookId, @RequestBody BookPayload bookPayload) {
        return bookService.updateBook(bookId, bookPayload);
    }

    @DeleteMapping("/{bookId}")
    public boolean deleteBook(@PathVariable Integer bookId) {
        return bookService.deleteBookById(bookId);
    }

    @GetMapping
    public List<Book> getBookListByType(@RequestParam("type") String type) {
        return bookService.getBooksByType(type);
    }

}
