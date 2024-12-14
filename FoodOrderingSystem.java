import java.util.Scanner;

public class FoodOrderingSystem {

    // Menu items
    static String[] menuItems = {"Burger", "Pizza", "Pasta", "Sushi", "Salad"};
    static double[] prices = {599.00, 899.00, 749.00, 1299.00, 499.00}; // Prices in rupees

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double totalCost = 0;
        boolean orderComplete = false;

        System.out.println("Welcome to the Food Ordering System!");

        while (!orderComplete) {
            // Display the menu
            displayMenu();

            System.out.print("\nEnter the number of the item you want to order (or 0 to finish): ");
            choice = scanner.nextInt();

            if (choice == 0) {
                // Finish order
                orderComplete = true;
                System.out.println("\nThank you for your order!");
                System.out.println("Total Cost: ₹" + totalCost);
            } else if (choice >= 1 && choice <= menuItems.length) {
                // Add selected item to the order
                totalCost += prices[choice - 1];
                System.out.println(menuItems[choice - 1] + " added to your order.");
            } else {
                // Invalid choice
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to display the menu
    public static void displayMenu() {
        System.out.println("\nMenu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i] + " - ₹" + prices[i]);
        }
    }
}
