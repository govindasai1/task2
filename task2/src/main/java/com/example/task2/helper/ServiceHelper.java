package com.example.task2.helper;

import com.example.task2.constants.Constants;
import com.example.task2.entity.Books;
import com.example.task2.entity.Publishers;
import com.example.task2.exception.CommonException;

public class ServiceHelper {
    public static Publishers handlePublisher(Publishers publishers){
        if (publishers==null){
            throw new CommonException(Constants.PUBLISHER_NOT_FOUND);
        }else {
            return publishers;
        }
    }
    public static Books handleBook(Books book){
        if (book==null){
            throw new CommonException(Constants.BOOK_NOT_FOUND);
        }else {
            return book;
        }
    }
}
