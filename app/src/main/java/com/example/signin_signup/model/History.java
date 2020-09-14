package com.example.signin_signup.model;

public class History {
    private String Title,Author,Image,Summary;

    public History() {
    }

    public History(String title, String author, String image, String summary) {
        this.Title = title;
        this.Author = author;
        this.Image = image;
        this.Summary = summary;
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

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }
}
