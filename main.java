package PasswordProgram;
// Package allows us to use variables outside of this file and interact with other files in the program

import java.util.Scanner; // We use this to scan user input

public class main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String userName; // Initialize our username string
        String password; // Initialize password string

        // Welcome message and username requirements
        System.out.println("Welcome! To register, please enter a username! It must meet the following requirements:\nUsername must have 8 characters but cannot exceed 16 characters.\nUsername must have at least 1 number.\nUsername should have at least 1 special character '!@#$%&*'.");
        userName = myObj.nextLine(); // Taking user input for the username

        function myFunction = new function();
        myFunction.checkUsername(userName); // Passing the username to the checkUsername method

        // Password entry and password requirements
        System.out.println("\nPlease enter a password! It must meet the following requirements:\nPassword must have 8 characters but cannot exceed 16 characters.\nPassword must have at least 1 number.\nPassword should have at least 1 special character '!@#$%&*'.");
        password = myObj.nextLine(); // Taking user input for the password

        myFunction.checkPassword(password); // Passing the password to the checkPassword method
    }
}
