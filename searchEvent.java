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
    public static boolean checkEventExisting(String argEventID){
        for(String id : existingEventsIDs) {
            if(argEventID.equals(id)){
                eventFound = id;
                return true;
            }
        }
        return false;
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
            return "Event id input empty";
        }
        if (checkForBadCharacters(argEventID)) {
            return "Inputted Name is invalid";
        }
        if (checkEventExisting(argEventID)) {
            return "Event found: " + eventFound;
        }
        return "Event not found";
    }
}