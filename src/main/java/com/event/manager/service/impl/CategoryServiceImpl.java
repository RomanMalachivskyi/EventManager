package com.event.manager.service.impl;

import com.event.manager.repository.CategoryRepo;
import com.event.manager.resource.Category;
import com.event.manager.service.CategoryService;
import com.event.manager.service.exception.CategoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category add(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category deleteById(Integer id) {
        Optional<Category> categoryToDelete = categoryRepo.findById(id);
        if (categoryToDelete.isPresent()){
            categoryRepo.deleteById(id);
            return categoryToDelete.get();
        } else {
            throw new CategoryException();
        }
    }

    @Override
    public Iterable<Category> getAll() {
        return categoryRepo.findAll();
    }
}
