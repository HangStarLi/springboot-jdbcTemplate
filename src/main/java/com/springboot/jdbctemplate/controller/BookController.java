package com.springboot.jdbctemplate.controller;

import com.springboot.jdbctemplate.entity.Book;
import com.springboot.jdbctemplate.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService service;
    @GetMapping("/bookOps")
    public void bookOps(){
        Book book = new Book();
        book.setId(20);
        book.setName("王颖");
        book.setAuthor("接口");
        int i = service.addBook(book);
        System.out.println(i);
    }
    @RequestMapping("/query/{id}")
    public String  queryBookById(@PathVariable int id){
        return service.queryBookById(id).toString();
    }
    @RequestMapping("/querylist")
    public String  queryBooks(){
        return service.queryBooks().toString();
    }
}
