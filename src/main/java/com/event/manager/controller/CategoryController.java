package com.event.manager.controller;

import com.event.manager.repository.CategoryRepo;
import com.event.manager.resource.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/category")
    public String getAll(Map<String, Object> model) {
        Iterable<Category> categories = categoryRepo.findAll();
        model.put("category", categories);
        return "category";
    }

    @PostMapping("/category")
    public String addNewCategory(@RequestParam String name, Map<String, Object> model) {
        Category n = new Category(name);
        categoryRepo.save(n);
        return getAll(model);
    }
}
