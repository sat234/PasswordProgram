package PasswordProgram;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class function {
    int tally = 0;
    private Set<String> usernames = new HashSet<>();


    public void checkUsername(String userUsername) {
        if (userUsername.length() >= 8 && userUsername.length() <= 16) {
            System.out.println("\nYour username: " + userUsername + " has met the length requirements!");
    
            Pattern digitPattern = Pattern.compile("\\d");
            Matcher digitMatcher = digitPattern.matcher(userUsername);
    
            if (digitMatcher.find()) {
                System.out.println("\nA digit has been found in " + userUsername + "!");
                tally++;
            } else {
                System.out.println("\nNo digits have been found in " + userUsername + "!");
                System.exit(0);
            }
    
            Pattern specialCharPattern = Pattern.compile("[!@#$%&*]");
            Matcher sCharMatcher = specialCharPattern.matcher(userUsername);
    
            if (sCharMatcher.find()) {
                System.out.println("\nSpecial characters have been found in " + userUsername + "!");
                tally++;
            } else {
                System.out.println("\nNo special characters were found in " + userUsername + "!");
                System.exit(0);
            }
    
            if (usernames.contains(userUsername)) {
                System.out.println("\nThis username is already taken. Please choose a different one.");
                System.exit(0);
            } else {
                usernames.add(userUsername);
            }
        } else {
            System.out.println("\nUsername length does not meet the requirements.");
            System.exit(0);
        }
    }
    

    

    public void checkPassword(String userPassword) {
        if (userPassword.length() >= 8 && userPassword.length() <= 16) {
            System.out.println("\nYour password: " + userPassword + " has met length requirements!");
        } else {
            System.out.println("\nPassword length does not meet the length requirements.");
            System.exit(0);
        }

        Pattern digitPattern = Pattern.compile("\\d");
        Matcher digitMatcher = digitPattern.matcher(userPassword);

        if (digitMatcher.find()) {
            System.out.println("\nA digit has been found in " + userPassword + "!");
            tally++;
        } else {
            System.out.println("\nNo digits have been found in " + userPassword + "!");
            System.exit(0);
        }

        Pattern specialCharPattern = Pattern.compile("[!@#$%&*]");
        Matcher sCharMatcher = specialCharPattern.matcher(userPassword);

        if (sCharMatcher.find()) {
            System.out.println("\nSpecial characters have been found in " + userPassword + "!");
            tally++;
        } else {
            System.out.println("\nNo special characters were found in " + userPassword + "!");
            System.exit(0);
        }

        createFile(usernames, userPassword);
    }

    public void createFile(Set<String> usernames, String password) {
        try {
            File file = new File("Storage.txt");
    
            if (file.createNewFile()) {
                System.out.println("\nFile created: " + file.getName());
            } else {
                System.out.println("\nFile already exists.");
            }
    
            FileWriter writer = new FileWriter("Storage.txt", true);
    
            // Read existing usernames from the file
            Set<String> existingUsernames = new HashSet<>();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    existingUsernames.add(parts[0]);
                }
            }
            scanner.close();
    
            for (String username : usernames) {
                if (existingUsernames.contains(username)) {
                    System.out.println("\nUsername '" + username + "' already exists. Please choose a different one.");
                } else {
                    writer.write(username + ":" + password + "\n");
                }
            }
    
            writer.close();
        } catch (IOException e) {
            System.out.println("\nAn error occurred.");
            e.printStackTrace();
        }
    }
    
}
