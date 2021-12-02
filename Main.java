import java.util.Scanner;

public class Main {
    public static void menu() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select an option below:");
        System.out.println(
                "  1. Create Account\n" +
                        "  2. Login\n" +
                        "  3. Create Event\n" +
                        "  4. Search Event\n" +
                        "  5. Exit\n");
        System.out.print("Enter a number to choose: ");
        int choice = kb.nextInt();
        kb.nextLine();

        switch (choice) {
            case 1:
                System.out.println("~----- Create Account -----~");
                System.out.print("Enter username: ");
                String un = kb.nextLine();
                System.out.print("Enter password: ");
                String p1 = kb.nextLine();
                System.out.print("Re-enter password: ");
                String p2 = kb.nextLine();
                System.out.println(CreateAccount.createAccount(un,p1,p2));
                break;
            case 2:
                System.out.println("~----- Login -----~");
                System.out.print("Enter username: ");
                String un2 = kb.nextLine();
                System.out.print("Enter password: ");
                String pw2 = kb.nextLine();
                //CreateAccount.createAccount(un2,pw2);
                break;
            case 3:
                System.out.println("~----- Create Event -----~");
                System.out.print("Enter event name: ");
                String n = kb.nextLine();
                System.out.print("Enter event time: ");
                String t = kb.nextLine();
                System.out.print("Enter event date: ");
                String d = kb.nextLine();
                System.out.print("Enter event location: ");
                String l = kb.nextLine();
                System.out.println(createEvent.createEvent(n,t,d,l));
                break;
            case 4:
                System.out.println("~----- Search Event -----~");
                System.out.print("Enter event name: ");
                String n2 = kb.nextLine();
                System.out.println(searchEvent.searchEvent(n2));
                break;
            case 5:
                System.out.println("Exiting UTD poll system");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
    }
    public static void main(String[] args) {
        System.out.println("~----- UTD Poll System -----~\n");
        while(true)
            menu();
    }
}
