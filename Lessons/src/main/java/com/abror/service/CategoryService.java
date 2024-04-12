package com.abror.service;

import com.abror.entity.Category;
import com.abror.entity.CategoryType;
import com.abror.payload.CategoryPayload;
import com.abror.repasitory.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public boolean addCategory(CategoryPayload categoryPayload) {
        try {
            Category category = Category.builder()
                    .name(categoryPayload.getName())
                    .authorName(categoryPayload.getAuthorName())
                    .authorDescription(categoryPayload.getAuthorDescription())
                    .authorPhotoId(categoryPayload.getAuthorPhotoId())
                    .categoryType(getCategoryType(categoryPayload.getCategoryType()))
                    .build();
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of add category - {}" + e.getMessage());
        }
        return false;
    }

    public boolean deleteCategory(Integer categoryId) {
        try {
            categoryRepository.deleteById(categoryId);
            return true;
        } catch (Exception e) {
            log.error("Exception is in the method of delete category - {}" + e.getMessage());
        }
        return false;
    }

    public List<String> getAuthorNames(String categoryType) {
        return categoryRepository.getAuthorNames(categoryType);
    }


    public boolean updateCategory(Integer categoryId, CategoryPayload categoryPayload) {
        try {
            if (categoryRepository.existsById(categoryId)) {
                Category category = Category.builder()
                        .id(categoryId)
                        .name(categoryPayload.getName())
                        .authorName(categoryPayload.getAuthorName())
                        .authorDescription(categoryPayload.getAuthorDescription())
                        .authorPhotoId(categoryPayload.getAuthorPhotoId())
                        .categoryType(getCategoryType(categoryPayload.getCategoryType()))
                        .build();
                categoryRepository.save(category);
                return true;
            }else {
                log.error("Category id is not found");
            }
        } catch (Exception e) {
            log.error("Exception is in the method of update category - {}" + e.getMessage());
        }
        return false;
    }


    public CategoryType getCategoryType(String categoryType) {
        return CategoryType.valueOf(categoryType.toUpperCase());
    }

}
