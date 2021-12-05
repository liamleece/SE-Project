import java.util.ArrayList;
import java.util.List;

public class createEvent
{
    public static final int MIN_LENGTH_Event_ID = 6;
    public static final int MAX_LENGTH_Event_ID = 30;
    public static String[] existingEventsIDs = {"Monster Bash", "Software Engineering", "Prom Night", "Old Man Yells At Cloud"};
    public static char[] badChars = {',', '/', '\\'};
    public static List<Event> eventList;

    static {
        eventList = new ArrayList<Event>();
        eventList.add(new Event("Monster Bash", "12:00", "10-10-2010", "SSB 1.250"));
        eventList.add(new Event("Software Engineering"));
        eventList.add(new Event("Prom Night"));
        eventList.add(new Event("Old Man Yells at Cloud"));
    }

    public static boolean checkEventExisting(String argEventID){
        for (Event event : eventList) {
            if (event.getArgEventName() == argEventID)
                return true;
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

        //made sure that control characters in the given array are absent in EventID
        //we can now return false to mean that none of the unwanted characters are present in incoming string
        return false;
    }
    public static boolean checkEventName(String argEventID){
        return checkForBadCharacters(argEventID) || checkForDigit(argEventID);
    }
    public static boolean checkEventTime(String argEventTime){
        return checkForBadCharacters(argEventTime) || checkTimeValue(argEventTime);
    }
    public static boolean checkEventDate(String argEventDate){
        return checkForBadCharacters(argEventDate) || checkDateValue(argEventDate);
    }
    public static boolean checkTimeValue(String str) {
        char c = ' ';
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            switch (i) {
                case 0:
                    if (Character.valueOf(c) > 50 || Character.valueOf(c) < 48) {return true; } else break; // (#)#:##
                case 3:
                case 4:
                case 1:
                    if (Character.valueOf(c) > 53 || Character.valueOf(c) < 48) { return true; } else break;
                case 2:
                    if (c != ':') { return true; } else break;
                default: break;
            }

        }
        return false;
    }
    public static boolean checkDateValue(String str) { //   00/00/0000
    char c;
    for (int i = 0; i < str.length(); i++) {
        c = str.charAt(i);
        switch (i) {
            case 0: if (Character.valueOf(c) > 49 || Character.valueOf(c) < 48) { return true; } else break;
            case 1:
            case 4:
            case 7:
            case 8:
            case 9: if (Character.valueOf(c) > 57 || Character.valueOf(c) < 48) {return true;} else break;
            case 2:
            case 5: if (c != '-' && c != '/') {return true;} else break;
            case 3: if (Character.valueOf(c) > 51 || Character.valueOf(c) < 48) {return true;} else break;
            case 6: if (Character.valueOf(c) > 50 || Character.valueOf(c) < 48) { return true; } else break;

            default: break;
        }

    }
    return false;
}
    public static boolean checkForDigit(String str){
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }

    public static String createEvent(Event event) {

        if (event.getArgEventName() == null) {
            return "event id input empty";
        }
        if (checkEventExisting(event.getArgEventName())) {
            return "event id already exists";
        }
        if (checkEventName(event.getArgEventName())) {
            return "inputted name is invalid";
        }
        if (event.getArgEventTime() == null) {
            return "event time input empty";
        }
        if (checkEventTime(event.getArgEventTime())) {
            return "inputted time is invalid";
        }
        if (event.getArgEventDate() == null) {
            return "event date input empty";
        }
        if( checkEventDate(event.getArgEventDate())) {
            return "inputted date is invalid";
        }
        if (event.getArgEventLocation() == null) {
            return "event location input empty";
        }
        if(checkForBadCharacters(event.getArgEventLocation())) {
            return "inputted location is invalid";
        }
        eventList.add(event);
        return "Event Registration Successful";
    }
}

