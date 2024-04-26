package com.abror.service;

import com.abror.entity.Book;
import com.abror.entity.Type;
import com.abror.payload.BookPayload;
import com.abror.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public boolean addBook(BookPayload bookPayload) {
        try {
            Book book = Book.builder()
                    .name(bookPayload.getName())
                    .description(bookPayload.getDescription())
                    .fileId(bookPayload.getFileId())
                    .type(getType(bookPayload.getType()))
                    .build();

            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add book - {}" + e.getMessage());
        }
        return false;
    }

    public boolean deleteBookById(Integer id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of delete book - {}" + e.getMessage());
        }
        return false;
    }

    public boolean updateBook(Integer id, BookPayload bookPayload) {
        try {
            if (bookRepository.existsById(id)) {
                Book book = Book.builder()
                       .id(id)
                       .name(bookPayload.getName())
                       .description(bookPayload.getDescription())
                       .fileId(bookPayload.getFileId())
                       .type(getType(bookPayload.getType()))
                       .build();

                bookRepository.save(book);
                return true;
            } else {
                log.error("Book id is not found");
            }
        } catch (Exception e) {
            log.error("Exception is in the method of update book - {}" + e.getMessage());
        }
        return false;
    }

    public List<Book> getBooksByType(String type) {
        return bookRepository.findAllByType(type);
    }


    public Type getType(String type) {
        return switch (type) {
            case "READING" -> Type.READING;
            case "WRITING" -> Type.WRITING;
            case "CAMBRIDGE" -> Type.CAMBRIDGE;
            case "GRAMMAR" -> Type.GRAMMAR;
            case "SPEAKING" -> Type.SPEAKING;
            default -> Type.LISTENING;
        };
    }

}
