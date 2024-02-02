import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TrainTicket {
    private String from;
    private String to;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String price;
    private String section;
    private String seat;

    public TrainTicket(String from, String to, String userFirstName, String userLastName, String userEmail,  String price) {
        this.from = from;
        this.to = to;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.price = price;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPrice() {
        return price;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

class TrainTicketSystem {
    private static Map<String, TrainTicket> tickets = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String PRICE_PATTERN = "\\$20";

    public static void purchaseTicket(String from, String to, String userFirstName, String userLastName, String userEmail, String price) {
        TrainTicket ticket = new TrainTicket(from, to, userFirstName, userLastName, userEmail, price);
        tickets.put(userEmail, ticket);
    }

    public static TrainTicket getTicket(String userEmail) {
        return tickets.get(userEmail);
    }

    public static void assignSeat(String userEmail, String section, String seat) {
        TrainTicket ticket = tickets.get(userEmail);
        if (ticket != null) {
            ticket.setSection(section);
            ticket.setSeat(seat);
        }
    }
    public static String getPriceInput() {
        String price;
        Pattern pattern = Pattern.compile(PRICE_PATTERN);

        do {
            System.out.print("Price Paid: ");
            price = scanner.nextLine();
            Matcher matcher = pattern.matcher(price);

            if (!matcher.matches()) {
                System.out.println("Invalid price format. Please enter $20");
            }
        } while (!price.matches(PRICE_PATTERN));

        return price;
    }
    public static String getSectionInput() {
        String section;
        do {
            System.out.print("Section (A/B): ");
            section = scanner.nextLine().toUpperCase(); 
            if (!section.equals("A") && !section.equals("B")) {
                System.out.println("Invalid section. Please enter either 'A' or 'B'.");
            }
        } while (!section.equals("A") && !section.equals("B"));

        return section;
    }
    public static void viewUsersBySection(String requestedSection) {
        System.out.println("Users and Seats Allocated in Section " + requestedSection + ":");
        for (TrainTicket ticket : tickets.values()) {
            if (ticket.getSection() != null && ticket.getSection().equalsIgnoreCase(requestedSection)) {
                System.out.println("User: " + ticket.getUserFirstName() + " " + ticket.getUserLastName());
                System.out.println("Email: " + ticket.getUserEmail());
                System.out.println("Seat: " + ticket.getSeat());
                System.out.println("-------------");
            }
        }
    }
    
    public static void displayAllUsers() {
        System.out.println("All Users and Their Seats:");
        for (TrainTicket ticket : tickets.values()) {
            System.out.println("User: " + ticket.getUserFirstName() + " " + ticket.getUserLastName());
            System.out.println("Email: " + ticket.getUserEmail());
            System.out.println("Section: " + ticket.getSection());
            System.out.println("Seat: " + ticket.getSeat());
            System.out.println("-------------");
        }
    }
    
    public static void removeUser(String userEmail){
        tickets.remove(userEmail); 
        System.out.println("User has been Removed Successfully");
    }
    public static void modifyUserSeat(String userEmail, String newSeat) {
        TrainTicket ticket = tickets.get(userEmail);
        if (ticket != null) {
            ticket.setSeat(newSeat);
            System.out.println("Seat for user " + userEmail + " has been modified to " + newSeat);
        } else {
            System.out.println("User not found.");
        }
    }
    

    public static void printReceipt(String userEmail) {
        TrainTicket ticket = tickets.get(userEmail);
        if (ticket != null) {
            System.out.println("Receipt Details:");
            System.out.println("From: " + ticket.getFrom());
            System.out.println("To: " + ticket.getTo());
            System.out.println("User: " + ticket.getUserFirstName() + " " + ticket.getUserLastName());
            System.out.println("Email: " + ticket.getUserEmail());
            System.out.println("Price Paid: " + ticket.getPrice());
            System.out.println("Section: " + ticket.getSection());
            System.out.println("Seat: " + ticket.getSeat());
        } else {
            System.out.println("User not found.");
        }
    }

    public static void main(String[] args) {
            System.out.println("Welcome to the Train Ticket System!");
            
            
            while (true) {
                // user input for ticket purchase
                System.out.print("From: ");
                String from = scanner.nextLine();

                System.out.print("To: ");
                String to = scanner.nextLine();

                System.out.print("First Name: ");
                String firstName = scanner.nextLine();

                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                String price = getPriceInput();
                
                purchaseTicket(from, to, firstName, lastName, email, price);
                // user input for seat assignment
                System.out.print("Enter user email for seat assignment: ");
                String userEmail = scanner.nextLine();

                String section = getSectionInput();
                
                System.out.print("Seat: ");
                String seat = scanner.nextLine();

                assignSeat(userEmail, section, seat);
                
                System.out.print("Do you want to add another user? (yes/no): ");
                String addAnother = scanner.nextLine().toLowerCase();
                if (!addAnother.equals("yes")) {
                    break;
                }
            }
            Scanner scanner1 = new Scanner(System.in);
            boolean exit = false;
            
            while(!exit) {
            
            System.out.println("Choose an operation");
            System.out.println("1.View user by section");
            System.out.println("2.Print receipt");
            System.out.println("3.Display All users");
            System.out.println("4.Modify user seat");
            System.out.println("5.Remove user");
            System.out.println("6. Exit");
            
            int Option = scanner1.nextInt();

            switch (Option) {
                case 1:
                	 System.out.print("Enter section to view (A/B): ");
                     String requestedSection = scanner.nextLine().toUpperCase();

                     viewUsersBySection(requestedSection);
                    break;
                case 2:
                	// Display receipt
                    System.out.print("Enter user email for receipt: ");
                    String receiptEmail = scanner.nextLine();
                    printReceipt(receiptEmail);
                    break;
                case 3:
                	// Display Users
                	displayAllUsers();
                    break;
                case 4:
                	 System.out.print("Enter user email for seat modification: ");
                     String modifyUserEmail = scanner.nextLine();

                     System.out.print("Enter new seat: ");
                     String newSeat = scanner.nextLine();

                     modifyUserSeat(modifyUserEmail, newSeat);
                    break;
                case 5:
                	// removing a user
                    System.out.print("Enter user email for removal: ");
                    String removalEmail = scanner.nextLine();
                    removeUser(removalEmail);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Option. Please choose a valid operation.");
            }}

            scanner.close();
        }    }
  

