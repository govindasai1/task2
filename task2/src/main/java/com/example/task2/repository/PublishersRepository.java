package com.example.task2.repository;

import com.example.task2.entity.Publishers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PublishersRepository extends JpaRepository<Publishers, UUID> {
}
