import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void menu() {
        Scanner kb = new Scanner(System.in);
        System.out.println("\nSelect an option below:");
        System.out.println(
                "  1. Create Account\n" +
                        "  2. Create Event\n" +
                        "  3. View List of Events\n" +
                        "  4. Search and Vote on Event\n" +
                        "  5. Search and View Votes on Event\n" +
                        "  6. Exit\n");
        System.out.print("Enter a number to choose: ");
        int choice = kb.nextInt();
        kb.nextLine();

        switch (choice) {
            case 1:
                System.out.println("\n~----- Create Account -----~");
                System.out.print("Enter username: ");
                String un = kb.nextLine();
                System.out.print("Enter password: ");
                String p1 = kb.nextLine();
                System.out.print("Re-enter password: ");
                String p2 = kb.nextLine();
                System.out.println(CreateAccount.createAccount(un,p1,p2));
                break;
            case 2:
                System.out.println("\n~----- Create Event -----~");
                System.out.print("Enter event name: ");
                String n = kb.nextLine();
                System.out.print("Enter event time (XX:XX): ");
                String t = kb.nextLine();
                System.out.print("Enter event date (XX-XX-XXXX): ");
                String d = kb.nextLine();
                System.out.print("Enter event location: ");
                String l = kb.nextLine();
                Event event = new Event(n,d,t,l);
                System.out.println(createEvent.createEvent(event));

                break;
            case 3:
                System.out.println("\n~----- Event List -----~");
                for (Event e : createEvent.eventList) {
                       System.out.println(e.getArgEventName());
                }
                break;
            case 4:
                System.out.println("\n~----- Search Event -----~");
                System.out.print("Enter event name: ");
                String n2 = kb.nextLine();
                String foundEvent = searchEvent.searchEvent(n2);
                for(Event e : createEvent.eventList)
                {
                    String str = e.getArgEventName();
                    if(str.compareTo(foundEvent) == 0) {
                        System.out.println("\n~----- Vote On Event -----~");
                        System.out.print("please vote on if you want the event to happen (Y/N): ");
                        String vote = kb.nextLine();
                        VoteOnEvent.vote(e, vote);
                        break;
                    }
                }
                break;
            case 5:
                System.out.println("\n~----- Search Event -----~");
                System.out.print("Enter event name: ");
                n2 = kb.nextLine();
                foundEvent = searchEvent.searchEvent(n2);
                for(Event e : createEvent.eventList)
                {
                    String str = e.getArgEventName();
                    if(str.compareTo(foundEvent) == 0) {
                        System.out.println("\n~----- View Votes On Event -----~");
                        e.getVotes();
                        break;
                    }
                }
                break;
            case 6:
                System.out.println("Exiting UTD poll system");
                System.exit(1);
                break;
            default:
                System.out.println("Invalid selection.");
                break;
        }
    }
    public static boolean login(){
        Scanner kb = new Scanner(System.in);
        System.out.println("~----- Login -----~");
        System.out.print("Enter username: ");
        String un2 = kb.nextLine();
        System.out.print("Enter password: ");
        String pw2 = kb.nextLine();
        String msg = LoginUserAccount.login(un2,pw2);
        System.out.println(msg);
        if(msg.compareTo("Login Successful") == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        System.out.println("~----- UTD Poll System -----~\n");
        boolean auth = false;
        while((auth = login()) == false){

        }
        while(true)
            menu();
    }
}
