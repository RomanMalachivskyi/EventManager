package com.event.manager.controller;

import com.event.manager.repository.CategoryRepo;
import com.event.manager.resource.Category;
import com.event.manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    public String getAll(Map<String, Object> model) {
        Iterable<Category> categories = categoryService.getAll();
        model.put("category", categories);
        return "category";
    }

    @PostMapping("/category/add")
    public String addNewCategory(@RequestParam String name, Map<String, Object> model) {
        Category n = new Category(name);
        categoryService.add(n);
        return getAll(model);
    }

    @PostMapping("/category/{id}/delete")
    public String delete(@PathVariable Integer id, Map<String, Object> model) {
        categoryService.deleteById(id);
        return getAll(model);
    }
}
