package com.example.signin_signup.model;

public class Payment {
    private String Name;
    private String Email;
    private Long Tel;
    private Long CardNo;
    private String CardValidDate;
    private  String CardCVC;

    public Payment() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getTel() {
        return Tel;
    }

    public void setTel(Long tel) {
        Tel = tel;
    }

    public Long getCardNo() {
        return CardNo;
    }

    public void setCardNo(Long cardNo) {
        CardNo = cardNo;
    }

    public String getCardValidDate() {
        return CardValidDate;
    }

    public void setCardValidDate(String cardValidDate) {
        CardValidDate = cardValidDate;
    }

    public String getCardCVC() {
        return CardCVC;
    }

    public void setCardCVC(String cardCVC) {
        CardCVC = cardCVC;
    }
}
