package com.example.signin_signup.model;

public class Project {

    private String Title,Author,Image,Summary;


    public Project(){

    }

    public Project(String Title, String Author, String Summary, String Image) {
        this.Title = Title;
        this.Image = Image;
        this.Author = Author;
        this.Summary = Summary;


    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }


}
