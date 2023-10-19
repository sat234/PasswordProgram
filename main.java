package PasswordProgram;

import java.util.Scanner;





public class main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userName;
        String password;

        System.out.println("Welcome! To register, please enter a username! It must meet the following requirements:\nUsername must have 8 characters but cannot exceed 16 characters.\nUsername must have at least 1 number.\nUsername should have at least 1 special character '!@#$%&*'.");
        userName = myObj.nextLine();

        function myFunction = new function();
        myFunction.checkUsername(userName);

      

        System.out.println("\nPlease enter a password! It must meet the following requirements:\nPassword must have 8 characters but cannot exceed 16 characters.\nPassword must have at least 1 number.\nPassword should have at least 1 special character '!@#$%&*'.");
        password = myObj.nextLine();

        myFunction.checkPassword(password);

        



    }
}