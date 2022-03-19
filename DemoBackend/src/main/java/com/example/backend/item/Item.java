package com.example.backend.item;

import org.hibernate.validator.constraints.URL;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.*;

@Table(value = "item")
public class Item {

    private final Long id;

    @NotNull(message = "name is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "name must be a string")
    @Column(value = "student_name")
    private final String name;

    @NotNull(message = "age is required")
    @Positive(message = "age must be positive")
    @Column(value = "age")
    private final Long age;

    @NotNull(message = "description is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
    @Column(value = "description")
    private final String description;

    @NotNull(message = "image is required")
    @URL(message = "image must be a URL")
    @Column(value = "image")
    private final String image;

    public Item(
            Long id,
            String name,
            Long age,
            String description,
            String image
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.image = image;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Item updateWith(Item item) {
        return new Item(
            this.id,
            item.name,
            item.age,
            item.description,
            item.image
        );
    }

    
}
