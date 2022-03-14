package com.example.backend.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InMemoryItemRepo extends CrudRepository<Item, Long> {}