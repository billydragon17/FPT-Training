package com.example.backend.item;

import org.hibernate.validator.constraints.URL;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;
// import org.springframework.data.relational.core.mapping.Column;
// import org.springframework.data.relational.core.mapping.Table;

//import javax.annotation.Generated;
import javax.validation.constraints.*;

// @Table(value = "item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @NotNull(message = "name is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "name must be a string")
    // @Column(value = "student_name")
    private String name;

    @NotNull(message = "age is required")
    @Positive(message = "age must be positive")
    // @Column(value = "age")
    private Long age;

    @NotNull(message = "description is required")
    @Pattern(regexp="^[a-zA-Z ]+$", message = "description must be a string")
    // @Column(value = "student_description")
    private  String description;

    @NotNull(message = "image is required")
    @URL(message = "image must be a URL")
    // @Column(value = "image")
    private  String image;

    Item() {}

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


    public Long setId(Long id)
    {
        return this.id = id;
    }

    public Long setAge(Long age)
    {
        return this.age = age;
    }

    public String setName(String name)
    {
        return this.name = name;
    }

    public String setDescription(String description)
    {
        return this.description = description;
    }

    public String setImage(String image)
    {
        return this.image = image;
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
