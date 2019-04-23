package com.springboot.jdbctemplate.dao;

import com.springboot.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int addBook(Book book){
        String sql = "insert into t_book(name,author) values(?,?)";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor());
    }

    public int updateBook(Book book){
        String sql = "update t_book set name=?,author=? where id = ?";
        return jdbcTemplate.update(sql,book.getName(),book.getAuthor(),book.getId());
    }

    public int deleteBook(int id){
        String sql = "delete t_book where id=?";
        return jdbcTemplate.update(sql,id);
    }

    public Book queryBookById(int id){
        String sql = "select * from t_book where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(Book.class),id);

    }

    public List<Book> queryBooks(){
        String sql = "select * from t_book";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

}
