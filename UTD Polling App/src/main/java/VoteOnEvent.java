public class VoteOnEvent
{
    public static void vote(Event event, String vote) {

        switch (vote) {
            case "Y":
            case "y":
                event.voteYes();
                System.out.println("Vote Registered Successfully");
                break;
            case "N":
            case "n":
                event.voteNo();
                System.out.println("Vote Registered Successfully");
                break;
            default:
                System.out.println("Error: Invalid Vote");
                break;
        }

    }
}