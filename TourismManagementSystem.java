import java.util.*;

class Tourist {
    private String name;
    private String nationality;
    private int age;
    private String passportNumber;

    public Tourist(String name, String nationality, int age, String passportNumber) {
        this.name = name;
        this.nationality = nationality;
        this.age = age;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Tourist Name: " + name + ", Nationality: " + nationality + ", Age: " + age + ", Passport No: " + passportNumber;
    }
}

class Destination {
    private String name;
    private String location;
    private double pricePerDay;

    public Destination(String name, String location, double pricePerDay) {
        this.name = name;
        this.location = location;
        this.pricePerDay = pricePerDay;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Location: " + location + ", Price per day: " + pricePerDay;
    }
}

class Booking {
    private Tourist tourist;
    private Destination destination;
    private int days;
    private double totalPrice;

    public Booking(Tourist tourist, Destination destination, int days) {
        this.tourist = tourist;
        this.destination = destination;
        this.days = days;
        this.totalPrice = destination.getPricePerDay() * days;
    }

    public void showBookingDetails() {
        System.out.println("Booking Details: ");
        System.out.println(tourist);
        System.out.println(destination);
        System.out.println("Total days: " + days);
        System.out.println("Total Price: " + totalPrice);
    }
}

public class TourismManagementSystem {
    private static List<Tourist> tourists = new ArrayList<>();
    private static List<Destination> destinations = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Sample destinations
        destinations.add(new Destination("Paris", "France", 200.0));
        destinations.add(new Destination("New York", "USA", 300.0));
        destinations.add(new Destination("Tokyo", "Japan", 250.0));
        // Adding more destinations to the list
        destinations.add(new Destination("London", "England", 180.0));
        destinations.add(new Destination("Sydney", "Australia", 220.0));


        while (running) {
            System.out.println("\nTourism Management System");
            System.out.println("1. Add Tourist");
            System.out.println("2. View Destinations");
            System.out.println("3. Make Booking");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add Tourist
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter nationality: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter passport number: ");
                    String passportNumber = scanner.nextLine();
                    tourists.add(new Tourist(name, nationality, age, passportNumber));
                    System.out.println("Tourist added successfully!");
                    break;
                case 2:
                    // View Destinations
                    System.out.println("\nAvailable Destinations:");
                    for (Destination dest : destinations) {
                        System.out.println(dest);
                    }
                    break;
                case 3:
                    // Make Booking
                    if (tourists.isEmpty()) {
                        System.out.println("No tourists added yet.");
                        break;
                    }
                    if (destinations.isEmpty()) {
                        System.out.println("No destinations available.");
                        break;
                    }

                    System.out.println("\nSelect Tourist:");
                    for (int i = 0; i < tourists.size(); i++) {
                        System.out.println(i + 1 + ". " + tourists.get(i).getName());
                    }
                    int touristIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (touristIndex < 0 || touristIndex >= tourists.size()) {
                        System.out.println("Invalid tourist selection.");
                        break;
                    }

                    System.out.println("\nSelect Destination:");
                    for (int i = 0; i < destinations.size(); i++) {
                        System.out.println(i + 1 + ". " + destinations.get(i).getName());
                    }
                    int destinationIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (destinationIndex < 0 || destinationIndex >= destinations.size()) {
                        System.out.println("Invalid destination selection.");
                        break;
                    }

                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Booking booking = new Booking(tourists.get(touristIndex), destinations.get(destinationIndex), days);
                    bookings.add(booking);
                    System.out.println("Booking made successfully!");
                    break;
                case 4:
                    // View Bookings
                    System.out.println("\nBookings List:");
                    for (Booking b : bookings) {
                        b.showBookingDetails();
                    }
                    break;
                case 5:
                    // Exit
                    running = false;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
