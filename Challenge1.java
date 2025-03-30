import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Challenge1 {

    public static class Item {
        String name;
        String category;
        String FirstName;
        String LastName;
        String Email;
        double price;

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
            return name + " - $" + price;
        }

        public String getDetails() {
            return "Name: " + name + "\nCategory: " + category + "\nSeller: " + FirstName + " " + LastName + "\nEmail: "
                    + Email + "\nPrice: $" + price;
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // User credentials stored in a HashMap
        HashMap<String, String> accounts = new HashMap<>();
        accounts.put("wchan", "kungfupanda4wasgood");
        accounts.put("yanni2", "ilovetortoises21");
        accounts.put("guest", "QUguest");

        int accountLoginFail = 0;
        boolean isAuthenticated = false;

        System.out.println("\r\n" + //
                        "              U _____ u    _         ____     U  ___ u   __  __   U _____ u       _____      U  ___ u        ___       ____       _        __   __   _    \r\n" + //
                        " __        __ \\| ___\"|/   |\"|     U /\"___|     \\/\"_ \\/ U|' \\/ '|u \\| ___\"|/      |_ \" _|      \\/\"_ \\/       / \" \\   U | __\")u U  /\"\\  u    \\ \\ / / U|\"|u  \r\n" + //
                        " \\\"\\      /\"/  |  _|\"   U | | u   \\| | u       | | | | \\| |\\/| |/  |  _|\"          | |        | | | |      | |\"| |   \\|  _ \\/  \\/ _ \\/      \\ V /  \\| |/  \r\n" + //
                        " /\\ \\ /\\ / /\\  | |___    \\| |/__   | |/__  .-,_| |_| |  | |  | |   | |___         /| |\\   .-,_| |_| |     /| |_| |\\   | |_) |  / ___ \\     U_|\"|_u  |_|   \r\n" + //
                        "U  \\ V  V /  U |_____|    |_____|   \\____|  \\_)-\\___/   |_|  |_|   |_____|       u |_|U    \\_)-\\___/      U \\__\\_\\u   |____/  /_/   \\_\\      |_|    (_)   \r\n" + //
                        ".-,_\\ /\\ /_,-. <<   >>    //  \\\\   _// \\\\        \\\\    <<,-,,-.    <<   >>       _// \\\\_        \\\\           \\\\//    _|| \\\\_   \\\\    >>  .-,//|(_   |||_  \r\n" + //
                        " \\_)-'  '-(_/ (__) (__)  (_\")(\"_) (__)(__)      (__)    (./  \\.)  (__) (__)     (__) (__)      (__)         (_(__)  (__) (__) (__)  (__)  \\_) (__) (__)_) \r\n" + //
                        "");
        System.out.println("\nGuest login:\nUsername: guest\nPassword: QUguest");
        System.out.println(
                "\nPlease log in using your QU credentials. If you cannot log in, please use the guest login.");

        while (!isAuthenticated) {
            System.out.print("Please enter your username: ");
            String username = userInput.nextLine();

            System.out.print("Please enter your password: ");
            String password = userInput.nextLine();

            if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
                isAuthenticated = true;
                System.out.println("You are now logged in.");
            } else {
                accountLoginFail++;
                if (accountLoginFail >= 3) {
                    System.out.println("Too many failed login attempts. You are now locked out of your account due to suspicious activity.");
                    userInput.close();
                    System.exit(0);
                }
                System.out.println("Invalid login. Please try again.");
            }
        }

        // Store available items and cart
        List<Item> itemsForSale = new ArrayList<>();
        List<Item> cart = new ArrayList<>();
        List<Item> userItemsForSale = new ArrayList<>();

        // Sample items
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
            System.out.println("3. Sell");
            System.out.println("4. Logout");

            System.out.print("Choose an option: ");

            int choice = userInput.nextInt();
            userInput.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    boolean inBuyMenu = true;
                    while (inBuyMenu) {
                        System.out.println("\nItems for Sale:");
                        for (int i = 0; i < itemsForSale.size(); i++) {
                            System.out.println((i + 1) + ". " + itemsForSale.get(i));
                        }
                        System.out.println((itemsForSale.size() + 1) + ". Back to Main Menu");
                        System.out.print("Choose an item to view details or add to cart: ");

                        int itemChoice = userInput.nextInt();
                        userInput.nextLine(); // Consume newline

                        if (itemChoice > 0 && itemChoice <= itemsForSale.size()) {
                            Item selectedItem = itemsForSale.get(itemChoice - 1);
                            System.out.println("\nItem Details:");
                            System.out.println(selectedItem.getDetails());
                            System.out.println("\n1. Add to Cart");
                            System.out.println("2. Back to Items List");
                            System.out.print("Choose an option: ");

                            int actionChoice = userInput.nextInt();
                            userInput.nextLine(); // Consume newline

                            if (actionChoice == 1) {
                                cart.add(selectedItem);
                                System.out.println("Item added to cart.");
                            } else {
                                System.out.println("Returning to items list...");
                            }
                        } else if (itemChoice == itemsForSale.size() + 1) {
                            inBuyMenu = false; // Exit Buy menu
                        } else {
                            System.out.println("Invalid choice. Returning to items list...");
                        }
                    }
                    break;

                case 2:
                    boolean inCartMenu = true;
                    while (inCartMenu) {
                        System.out.println("\nCart:");
                        if (cart.isEmpty()) {
                            System.out.println("Your cart is empty.");
                        } else {
                            double totalPrice = 0.0;
                            for (Item item : cart) {
                                System.out.println(item.name + " $" + item.price);
                                totalPrice += item.price;
                            }
                            System.out.println("\n Total Price: $" + totalPrice);
                        }
                        
                        System.out.println("\n1. Checkout");
                        System.out.println("2. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int cartChoice = userInput.nextInt();
                        userInput.nextLine();

                        switch (cartChoice) {
                            case 1:
                                if (!cart.isEmpty()) {

                                    // Remove purchased items from the buy menu
                                    for (Item purchasedItem : cart) {
                                        itemsForSale.remove(purchasedItem);

                                    }

                                    cart.clear();
                                    System.out.println("Thank you for your purchase(s).");
                                }
                                break;

                            case 2:
                                inCartMenu = false; // Exit the cart menu
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;

                case 3:
                    boolean sellMenu = true;
                    while (sellMenu) {
                        System.out.println("\nSell Menu:");
                        System.out.println("1. View My Items for Sale");
                        System.out.println("2. Add New Item for Sale");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Choose an option: ");

                        int sellChoice = userInput.nextInt();
                        userInput.nextLine();

                        switch (sellChoice) {
                            case 1:
                                if (userItemsForSale.isEmpty()) {
                                    System.out.println("You have no items listed for sale.");
                                } else {
                                    System.out.println("Your Items for Sale:");
                                    for (Item item : userItemsForSale) {
                                        System.out.println(item.getDetails());
                                    }
                                }
                                break;

                            case 2:

                            try {
                                System.out.print("Enter the item's name: ");
                                String itemName = userInput.nextLine();

                                System.out.print("Enter the item's category: ");
                                String itemCategory = userInput.nextLine();

                                System.out.print("Enter the item's price: ");
                                double itemPrice = userInput.nextDouble();
                                userInput.nextLine();

                                System.out.print("Enter your first name: ");
                                String itemFirstName = userInput.nextLine();

                                System.out.print("Enter your last name: ");
                                String itemLastName = userInput.nextLine();

                                System.out.print("Enter your Quinnipiac email: ");
                                String itemEmail = userInput.nextLine();

                                Item newItem = new Item(itemName, itemCategory, itemFirstName, itemLastName, itemEmail,
                                        itemPrice);
                                userItemsForSale.add(newItem);
                                itemsForSale.add(newItem);

                                System.out.println("Item successfully added for sale!");
                                break;

                            } catch (InputMismatchException e) {
                                System.out.println("Wrong type of input.");
                                e.printStackTrace();
                            }

                            case 3:
                                sellMenu = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }

                    }
                    break;

                case 4:
                    System.out.println("Thank you for using qBay! You have been successfully logged out.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        userInput.close();
    }
}