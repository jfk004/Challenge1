import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Challenge1 {


    public static class Item {
        String name;
        String category;
        String FirstName;
        String LastName;
        String Email;
        double price;

        // Constructor to initialize an item
        public Item(String name, String category, String FirstName, String LastName, String Email, double price) {
            this.name = name;
            this.category = category;
            this.FirstName = FirstName;
            this.LastName = LastName;
            this.Email = Email;
            this.price = price;
        }

        @Override
        public String toString() {
            return name + "- $" + price;
        }

        // Gets the detailed information about the item
        public String getDetails() {
            return "Name: " + name + "\nCategory: " + category + "\nSeller: " + FirstName + " " + LastName + "\nEmail: "
                    + Email + "\nPrice: $" + price;
        }
    }

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
        Scanner userInput = new Scanner(System.in);

        // List to store items for sale
        List<Item> itemsForSale = new ArrayList<>();
        // List to store items added to the cart
        List<Item> cart = new ArrayList<>();

        // Add sample items
        itemsForSale.add(new Item("MacBookPro", "Electronics", "Zakaaria", "Paul", "zakaaria.paul@qu.edu", 2500.00));
        itemsForSale.add(new Item("TextBooks", "Education", "Owen", "Luke", "owen.luke@qu.edu", 250.00));
        itemsForSale.add(new Item("TV", "Electronics", "James", "Rud", "james.rud@qu.edu", 300.00));
        itemsForSale.add(new Item("Bobcat Hoodie", "Clothing", "Rahim", "Wengal", "rahim.wengal@qu.edu", 150.00));
        itemsForSale.add(new Item("BoxFan", "Electronics", "Daniel", "Rich", "daniel.rich@qu.edu", 100.00));
        itemsForSale.add(new Item("Bobcat Bag", "Clothing", "Henry", "Demarco", "henry.demarco@qu.edu", 50.00));

        boolean running = true;

        while (running) {
            // Display the main menu
            System.out.println("\nMain Menu:");
            System.out.println("1. Buy");
            System.out.println("2. Cart");
            System.out.println("3. Exit");
            System.out.println("Choose an option:");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Buy menu loop
                    boolean inBuyMenu = true;
                    while (inBuyMenu) {
                        System.out.println("\nItems for Sale:");
                        for (int i = 0; i < itemsForSale.size(); i++) {
                            System.out.println((i + 1) + ". " + itemsForSale.get(i));
                        }
                        System.out.println((itemsForSale.size() + 1) + ". Back to Main Menu");
                        System.out.println("Choose an item to view details or add to cart:");

                        int itemChoice = userInput.nextInt();
                        userInput.nextLine(); // Consume newline

                        if (itemChoice > 0 && itemChoice <= itemsForSale.size()) {
                            Item selectedItem = itemsForSale.get(itemChoice - 1);
                            System.out.println("\nItem Details:");
                            System.out.println(selectedItem.getDetails());
                            System.out.println("\n1. Add to Cart");
                            System.out.println("2. Back to Items List");
                            System.out.println("Choose an option:");

                            int actionChoice = userInput.nextInt();
                            userInput.nextLine(); // Consume newline

                            switch (actionChoice) {
                                case 1:
                                    cart.add(selectedItem);
                                    System.out.println("Item added to cart.");
                                    break;
                                case 2:
                                    System.out.println("Returning to items list...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Returning to items list...");
                            }
                        } else if (itemChoice == itemsForSale.size() + 1) {
                            inBuyMenu = false; // Exit the Buy menu
                        } else {
                            System.out.println("Invalid choice. Returning to items list...");
                        }
                    }
                    break;

                case 2:
                    // Cart menu loop
                    boolean inCartMenu = true;
                    while (inCartMenu) {
                        System.out.println("\nYour Cart:");
                        if (cart.isEmpty()) {
                            System.out.println("Your cart is empty.");
                        } else {
                            for (Item item : cart) {
                                System.out.println(item);
                            }
                        }
                        System.out.println("\n1. Back to Main Menu");
                        System.out.println("Choose an option:");

                        int cartChoice = userInput.nextInt();
                        userInput.nextLine(); 

                        if (cartChoice == 1) {
                            inCartMenu = false; // Exit the Cart menu
                        } else {
                            System.out.println("Invalid choice. Returning to cart menu...");
                        }
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println("Exiting program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        userInput.close();
  
        
        