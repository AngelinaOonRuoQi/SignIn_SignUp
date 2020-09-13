package com.example.signin_signup.model;

public class Cart
{
    private String Title,Author,Image;

    public Cart() {
    }

    public Cart(String Title, String Author,String Image) {
        this.Title = Title;
        this.Author = Author;
        this.Image=Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
}

