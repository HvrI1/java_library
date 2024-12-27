package com.lm;


import com.lm.mapper.AddMapper;
import com.lm.mapper.DeleteMapper;
import com.lm.mapper.SelectMapper;
import com.lm.mapper.UpdateMapper;
import com.lm.pojo.Book;
import com.lm.service.InitService;
import com.lm.service.UserFrameService;
import com.lm.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Book book = new Book("三国演义", 45, "古典", 0);
//        AddMapper addMapper = new AddMapper();
//        addMapper.addBook(book);

//        String name = "三国演义";
//        new DeleteMapper().deleteBook(name);

//        ArrayList<Book> books = new SelectMapper().selectAllBook();
//        System.out.println(books);

//        Book book = new SelectMapper().selectByNameBook("西游记");
//        System.out.println(book);

//        new UpdateMapper().updateBook(1,"三国演义");

//            JFrame frame = GuiUtils.createAndShowGUI("图书管理系统", 800, 600);
//            Container contentPane = frame.getContentPane();
//            GuiUtils.addLabel(contentPane, "11111", 0, 0, 100, 100, new Color(255,0,255));


            new InitService().init();









    }

}