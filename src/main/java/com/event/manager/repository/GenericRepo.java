package com.event.manager.repository;

import com.event.manager.resource.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepo <O extends Resource> extends CrudRepository<O, Integer> {
}
