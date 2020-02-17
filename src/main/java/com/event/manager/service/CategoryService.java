package com.event.manager.service;

import com.event.manager.resource.Category;

public interface CategoryService {
    Category add(Category category);
    Category deleteById(Integer id);
    Iterable<Category> getAll();
}
