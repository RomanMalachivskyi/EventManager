package com.event.manager.controller;

import com.event.manager.repository.CategoryRepo;
import com.event.manager.resource.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Category> getAllUsers() {
        return categoryRepo.findAll();
    }

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name) {
        Category n = new Category(name);
        categoryRepo.save(n);
        return "Saved";
    }


}
