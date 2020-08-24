package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book
{
    private String title;
    private String author;
    private Integer isbn;

    public Book()
    { }

    public Book(String title, String author, Integer isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle()
    { return title; }

    public void setTitle(String title)
    { this.title = title; }

    public String getAuthor()
    { return author; }

    public void setAuthor(String author)
    { this.author = author; }

    public Integer getIsbn()
    { return isbn; }

    public void setIsbn(Integer isbn)
    { this.isbn = isbn; }
}
