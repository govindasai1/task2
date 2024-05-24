package com.example.task2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books_info")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @NotNull(message = "title should not be null")
    public String title;
    @NotNull(message = "description should not be null")
    public String description;
    @NotNull(message = "category should not be null")
    public String category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publishers_id")
    @JsonBackReference
    public Publishers publisher;
    public Date createdAt = new Date();
    public Date updatedAt;
}
