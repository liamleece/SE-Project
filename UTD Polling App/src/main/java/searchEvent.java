/**
 * Implementation of UC5 Search Event
 * User will receive prompt to input an event name.
 */

public class searchEvent
{
    public static final int MIN_LENGTH_Event_ID = 6;
    public static final int MAX_LENGTH_Event_ID = 30;

    public static String[] existingEventsIDs = {"Monster Bash", "Software Engineering", "Prom Night", "Old Man Yells At Cloud"};
    public static char[] badChars = {',', '/', '\\'};
    public static String eventFound;
    public static Event checkEventExisting(String argEventID){
        for (Event event : createEvent.eventList) {
            String str = event.getArgEventName();
            if (str.compareTo(argEventID) == 0)
                return event;
        }
        return null;
    }
    public static boolean checkForBadCharacters(String str){
        //returns true if bad characters / control characters are PRESENT the incoming String
        //otherwise returns false
        for(char c : badChars){
            if(str.indexOf(c) >= 0){
                return true;
            }
        }
        //made sure that bad characters in the given array are absent in the incoming String
        //now to make sure no control characters are in the incoming String
        for(char c : str.toCharArray()){
            if( Character.isISOControl(c)){
                return true;
            }
        }
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        //made sure that control characters in the given array are absent in EventID
        //we can now return false to mean that none of the unwanted characters are present in incoming string
        return false;
    }

    public static String searchEvent(String argEventID) {

        if (argEventID.equals(" ")) {
            return "Search String Empty";
        }
        if (checkForBadCharacters(argEventID)) {
            return "Search String invalid";
        }
        Event event = checkEventExisting(argEventID);
        if(event != null) {
            System.out.println("Event Name: " + event.getArgEventName());
            System.out.println("Event Date: " + event.getArgEventDate());
            System.out.println("Event Time: " + event.getArgEventTime());
            System.out.println("Event Location: " + event.getArgEventLocation());
        }
        else
            return "Search String invalid";

        return argEventID;
    }
}