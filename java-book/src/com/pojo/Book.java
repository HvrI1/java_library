package com.pojo;

public class Book {
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String name, String author, Integer statm) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.statm = statm;
    }

    private String name;
    private String author;
    private Integer statm;

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", statm=" + statm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStatm() {
        return statm;
    }

    public void setStatm(Integer statm) {
        this.statm = statm;
    }

    public Book(String name, String author, Integer statm) {
        this.name = name;
        this.author = author;
        this.statm = statm;
    }

    public Book() {
    }
}
