package com.company;

public class Main {

    public static void main(String[] args) {

        IDAndPassword idAndPassword = new IDAndPassword();

        LoginPage loginPage = new LoginPage(idAndPassword.getLoginInfo());



    }
}
