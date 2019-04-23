package com.springboot.jdbctemplate.service;

import com.springboot.jdbctemplate.dao.BookDao;
import com.springboot.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public int addBook(Book book){
        return bookDao.addBook(book);
    }
    public int updateBook(Book book){
        return bookDao.updateBook(book);
    }
    public int deleteBook(int id){
        return bookDao.deleteBook(id);
    }
    public Book queryBookById(int id){
        return bookDao.queryBookById(id);
    }
    public List<Book> queryBooks(){
        return bookDao.queryBooks();
    }


}
