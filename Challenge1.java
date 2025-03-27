import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        
        int accountLoginFail = 0;

        String accountUsername1 = "wchan";
        String accountPassword1 = "kungfupanda4wasgood";
        
        String accountUsername2 = "yanni2";
        String accountPassword2 = "ilovetortoises21";

        String accountUsername3 = "guest";
        String accountPassword3 = "QUguest";

        boolean validUsername = false;
        boolean validPassword = false;

        Scanner userInput = new Scanner(System.in);
        
        System.out.println("\r\n" + //
                        " __      __       .__                                  __                  __________               ._.\r\n" + //
                        "/  \\    /  \\ ____ |  |   ____  ____   _____   ____   _/  |_  ____     _____\\______   \\_____  ___.__.| |\r\n" + //
                        "\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\  \\   __\\/  _ \\   / ____/|    |  _/\\__  \\<   |  || |\r\n" + //
                        " \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/   |  | (  <_> ) < <_|  ||    |   \\ / __ \\\\___  | \\|\r\n" + //
                        "  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >  |__|  \\____/   \\__   ||______  /(____  / ____| __\r\n" + //
                        "       \\/       \\/          \\/            \\/     \\/                     |__|       \\/      \\/\\/      \\/\r\n" + //
                        "");


        System.out.println("\n");
        System.out.println("Guest login:\nUsername: guest\n" + "Password: QUguest");



        System.out.println("\nPlease log in using your QU credentials. If you cannot log in, please use the guest login.");

        try {

            while(!validPassword && !validUsername) {
                System.out.println("Please enter your username:");
                String username = userInput.nextLine();
    
                System.out.println("Please enter your password:");
                String password = userInput.nextLine();

                switch(username) {
                    case "wchan":
                        validUsername = true;
                        break;
                    case "yanni2":
                        validUsername = true;
                        break;
                    case "guest":
                        validUsername = true;
                        break;
                    default:
                        validUsername = false;
                        break;
                }
        
                switch(password) {
                    case "kungfupanda4wasgood":
                        validPassword = true;
                        break;
                    case "ilovetortoises21":
                        validPassword = true;
                        break;
                    case "QUguest":
                        validPassword = true;
                        break;
                    default:
                        validPassword = false;
                        break;
                }

                if (!validPassword || !validUsername) { 
                    accountLoginFail++;
                    if (accountLoginFail >= 3) {
                        System.out.println("You failed logging in too many times. You are now logged out of your account for suspicious activity.");
                        System.exit(0);
                    }
                    
                    System.out.println("The inputted login credential was wrong. Please retry.");
                    validUsername = false;
                    validPassword = false; 
                                       
                } else {
                    validUsername = true;
                    validPassword = true;
                } 
            }

            System.out.println("You are now logged in.");

        } catch (IllegalArgumentException  e) {
            System.out.println("Please retry and and input a string argument.");
        }
    }
}