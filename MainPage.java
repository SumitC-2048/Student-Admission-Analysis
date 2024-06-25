package INNOVATIVE;

import java.io.File;
import java.util.Scanner;

public class MainPage extends setMap {
    MainPage(File file) {
        super(file);
    }

    public static void main(String[] args) {

        File allInfo = new File("INNOVATIVE\\All_info.txt");
        File dataP = new File("INNOVATIVE\\data.txt");
        setMap objMap = new setMap(allInfo);
        validation func = new validation();
        double percentage=0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("|--------------------------------------Welcome to Home Page--------------------------------------|");
            System.out.println("    --> 1. Sign Up");
            System.out.println("    --> 2. Sign In");
            System.out.println("    --> 3. Forgot Password");
            System.out.println("    --> 4. Clear screen");
            System.out.println("    --> 5. Exit");
            System.out.print("    --> Please choose an option (1/2/3/4/5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {

// ----------------------------------------------------------------------------------------------------------------------------------------------------

                case 1:
                    System.out.println("\n  ------->Sign Up:<-------");
                    System.out.print("  Username: ");
                    String username = scanner.nextLine();
                    while (users.containsKey(username)) {
                        System.out.println("    Enter valid user name");
                        username = scanner.nextLine();
                    }
                    System.out.print("  Password: ");
                    String password = scanner.nextLine();
                    while (users.containsValue(password)) {
                        System.out.println("    This password is already taken, Please try other password");
                        password = scanner.nextLine();
                    }
                    System.out.print("  Confirm Password: ");
                    String confirmPassword = scanner.nextLine();

                    System.out.print("  Mobile Number: ");
                    String mobileNumber = scanner.nextLine();
                    while ((func.isValidmobileNumber(mobileNumber)==false) || (mobileEmailMap.containsKey(mobileNumber) )) {
                        System.out.println("    Enter valid mobile number that is not already be taken");
                        mobileNumber = scanner.nextLine();
                    }

                    System.out.print("  Email: ");
                    String email = scanner.nextLine();
                    while ((func.isValidEmail(email)==false) || (mobileEmailMap.containsValue(email))) {
                        System.out.println("    Enter valid email that is not already be taken");
                        email = scanner.nextLine();
                    }
                    
                    if (users.containsKey(username)) {
                        System.out.println("    Username already exists. Please choose a different username.");
                    } else if (!password.equals(confirmPassword)) {
                        System.out.println("    Password and Confirm Password do not match. Please try again.");
                    } else {
                        users.put(username, password);
                        mobileEmailUserMap.put(mobileNumber + email, username);
                        mobileEmailMap.put(mobileNumber, email);

                        System.out.println("    >>>>>> User registered successfully!");
                    }
                    break;

// ----------------------------------------------------------------------------------------------------------------------------------------------------

                case 2:
                    System.out.println("\n  ------->Sign In:<-------");
                    System.out.print("Username: ");
                    String signInUsername = scanner.nextLine();
                    System.out.print("Password: ");
                    String signInPassword = scanner.nextLine();

                    if (users.containsKey(signInUsername) && users.get(signInUsername).equals(signInPassword)) {
                        System.out.println("Thank you for signing in, " + signInUsername + "!");

                        System.out.println("Enter your name with surname: ");
                        String fullName = scanner.nextLine();
                        System.out.println("Enter your percentage: ");
                        percentage = scanner.nextDouble();

                        textFileAppend temp = new textFileAppend();
                        temp.append(fullName + ": " + percentage + " %", dataP);
                        
                        // generating rank
                        rank newRank = new rank();
                        double Rank = newRank.read(dataP, percentage);
                        System.out.println("Your rank: " + (Rank+1));

                        // Suggestions of University
                        System.out.println("Apply for University:");
                        
                        String[] universityList = {"DAIICT", "NIRMA UNIVERSITY", "DDU", "PDEU", "L.D."};
                        
                        if(percentage>=90){
                            System.out.println("Select Universties from below list: ");
                            for (int i = 0; i < universityList.length; i++) {
                                System.out.println((i+1) + ". " + universityList[i]);
                            }
                            System.out.println("Please choose an option (1/2/3/4/5):");
                            int c = scanner.nextInt();
                            System.out.println("You have been admitted to " + universityList[c-1]);
                        }
                        else if(percentage>=85){
                            System.out.println("Select Universties from below list: ");
                            for (int i = 1; i < universityList.length; i++) {
                                System.out.println((i) + ". " + universityList[i]);
                            }
                            System.out.println("Please choose an option (1/2/3/4):");
                            int c = scanner.nextInt();
                            System.out.println("You have been admitted to " + universityList[c]);
                        }
                        else if(percentage>=80){
                            System.out.println("Select Universties from below list: ");
                            for (int i = 2; i < universityList.length; i++) {
                                System.out.println((i-1) + ". " + universityList[i]);
                            }
                            System.out.println("Please choose an option (1/2/3):");
                            int c = scanner.nextInt();
                            System.out.println("You have been admitted to " + universityList[c+1]);
                        }
                        else if(percentage>=75){
                            System.out.println("Select Universties from below list: ");
                            for (int i = 3; i < universityList.length; i++) {
                                System.out.println((i-2) + ". " + universityList[i]);
                            }
                            System.out.println("Please choose an option (1/2):");
                            int c = scanner.nextInt();
                            System.out.println("You have been admitted to " + universityList[c+2]);
                        }
                        else if(percentage>=70){
                            System.out.println("You have been admitted to " + universityList[4]);
                        }
                        else{
                            System.out.println("You have not enough percentage!!!!!");
                        }
                    }
                    else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;

// ----------------------------------------------------------------------------------------------------------------------------------------------------

                case 3:
                    System.out.println("\n  ------->Forgot Password:<-------");
                    System.out.print("Mobile Number: ");
                    String forgotMobile = scanner.nextLine();
                    System.out.print("Email: ");
                    String forgotEmail = scanner.nextLine();

                    String key = forgotMobile + forgotEmail;
                    if (mobileEmailUserMap.containsKey(key)) {
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Confirm new password: ");
                        String confirmNewPassword = scanner.nextLine();

                        if (newPassword.equals(confirmNewPassword)) {
                            String usernameForPasswordReset = mobileEmailUserMap.get(key);
                            users.put(usernameForPasswordReset, newPassword);
                            System.out.println("Password reset successfully for username: " + usernameForPasswordReset);
                        } else {
                            System.out.println("New password and Confirm Password do not match. Password reset failed.");
                        }
                    } else {
                        System.out.println("No user found with the provided mobile and email combination.");
                    }
                    break;
// ----------------------------------------------------------------------------------------------------------------------------------------------------

                case 4:
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

// ----------------------------------------------------------------------------------------------------------------------------------------------------

                case 5:
                    objMap.setTextFile(allInfo);
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
            }
        }
    }
}