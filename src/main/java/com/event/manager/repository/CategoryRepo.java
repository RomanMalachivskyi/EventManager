package com.event.manager.repository;

import com.event.manager.resource.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends GenericRepo<Category> {
}
