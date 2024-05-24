package com.example.task2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Publishers_info")
public class Publishers {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @NotNull(message = "name should not be null")
    public String name;
    @NotNull(message = "address should not be null")
    public String address;
    public Date createdAt = new Date();
    public Date updatedAt;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Books.class,orphanRemoval = true)
    @JoinColumn(name = "publishers_id",referencedColumnName = "id")
    @JsonManagedReference
    private List<Books> books;
}
