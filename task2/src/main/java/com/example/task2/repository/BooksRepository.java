package com.example.task2.repository;

import com.example.task2.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BooksRepository extends JpaRepository<Books, UUID> {
    @Query("SELECT b FROM Books b WHERE b.publisher.id = :id ")
    List<Books> getBooksForUser(@Param("id") UUID id);

//    @Query("SELECT b FROM Books b WHERE b.publishers_id=:id OR b.Publishers_fk_id=:id")
//    List<Books> getBooksForUser(@Param("id") UUID id);

}
