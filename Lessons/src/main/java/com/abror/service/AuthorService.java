package com.abror.service;

import com.abror.entity.Author;
import com.abror.entity.CategoryType;
import com.abror.payload.AuthorPayload;
import com.abror.repasitory.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {
    private final AuthorRepository authorRepository;

    public boolean addAuthor(AuthorPayload authorPayload) {
        try {
            Author author = Author.builder()
                    .authorName(authorPayload.getAuthorName())
                    .authorDescription(authorPayload.getAuthorDescription())
                    .authorPhotoId(authorPayload.getAuthorPhotoId())
                    .authorType(getCategoryType(authorPayload.getAuthorType()))
                    .build();
            authorRepository.save(author);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add author - {}" + e.getMessage());
        }
        return false;
    }

    public boolean deleteAuthor(Integer authorId) {
        try {
            authorRepository.deleteById(authorId);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of delete author - {}" + e.getMessage());
        }
        return false;
    }

    public List<Author> getAuthorListByType(String authorType) {
        return authorRepository.getAuthorsByType(authorType);
    }


    public boolean updateAuthor(Integer authorId, AuthorPayload authorPayload) {
        try {
            if (authorRepository.existsById(authorId)) {
                Author author = Author.builder()
                        .id(authorId)
                        .authorName(authorPayload.getAuthorName())
                        .authorDescription(authorPayload.getAuthorDescription())
                        .authorPhotoId(authorPayload.getAuthorPhotoId())
                        .authorType(getCategoryType(authorPayload.getAuthorType()))
                        .build();
                authorRepository.save(author);
                return true;
            }else {
                log.error("Author id is not found");
            }
        } catch (Exception e) {
            log.error("Exception is in the method of update author - {}" + e.getMessage());
        }
        return false;
    }

    public Author getAuthorById(Integer authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }


    public CategoryType getCategoryType(String categoryType) {
        return CategoryType.valueOf(categoryType.toUpperCase());
    }

    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }
}
