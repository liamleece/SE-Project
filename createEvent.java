public class createEvent
{
    public static final int MIN_LENGTH_Event_ID = 6;
    public static final int MAX_LENGTH_Event_ID = 30;

    public static String[] existingEventsIDs = {"Monster Bash", "Software Engineering", "Prom Night", "Old Man Yells At Cloud"};
    public static char[] badChars = {',', '/', '\\'};

  /*  public static boolean checkEventLength(String argEventID){

        if(MIN_LENGTH_Event_ID <= argEventID.length()  &&  argEventID.length() <= MAX_LENGTH_Event_ID){
            return true;
        }else{
            return false;
        }
    }*/
    public static boolean checkEventExisting(String argEventID){
        for(String id : existingEventsIDs) {
            if(argEventID.equals(id)){
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
    public static boolean checkEventTime(String argEventTime){
        return checkForBadCharacters(argEventTime) && !checkTimeValue(argEventTime);
    }
    public static boolean checkEventDate(String argEventDate){
        return checkForBadCharacters(argEventDate) && !checkDateValue(argEventDate);
    }
    public static boolean checkTimeValue(String str) {
        char c = ' ';
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            switch (i) {
                case 0:
                    if (Character.valueOf(c) > 2 || Character.valueOf(c) < 0) {return false; } else break; // (#)#:##
                case 3:
                case 4:
                    if (Character.valueOf(c) > 9 || Character.valueOf(c) < 0) { return false; } else break;
                case 2:
                    if (c != ':') { return false; } else break;
                default: return false;
            }

        }
        return true;
    }
    public static boolean checkDateValue(String str) {
    char c = ' ';
    for (int i = 0; i < str.length(); i++) {
        c = str.charAt(i);
        switch (i) {
            case 0: if (Character.valueOf(c) > 1 || Character.valueOf(c) < 0) { return false; } else break;
            case 1:
            case 4:
            case 7:
            case 8:
            case 9: if (Character.valueOf(c) > 9 || Character.valueOf(c) < 0) {return false;} else break;
            case 2:
            case 5: if (c != '-') {return false;} else break;
            case 3: if (Character.valueOf(c) > 3 || Character.valueOf(c) < 0) {return false;} else break;
            case 6: if (Character.valueOf(c) > 2 || Character.valueOf(c) < 0) { return false; } else break;

            default: return false;
        }

    }
    return true;
}

//    public static boolean EventPass(String EventID){
//
//        return checkLength(EventID) && !checkExisting(EventID) && !hasExceptionalCharacters(EventID);
//    }
/*
    public static boolean checkPwdForValidCharacters(String argPwd) {
        //returns false in the following cases :
        //      if incoming String has one or more space or control characters
        //      if incoming String does not have at least of the following : one letter or number or  special character
        //return true otherwise
        boolean foundLetter = false;
        boolean foundNumber = false;
        boolean foundSpecialChar = false;
        for (char c : argPwd.toCharArray()) {
            if (Character.isISOControl(c) || Character.isSpaceChar(c)) {
                return false;
            } else if (Character.isLetter(c)) {
                foundLetter = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else {
                foundSpecialChar = true;
            }
        }
        //checked all characters in the incoming string
        return( foundLetter && foundNumber && foundSpecialChar );
    }
*/
//    public static boolean validPwd(String pwd){
//        return checkLength_Pwd(pwd) && hasValidCharacters(pwd);
//    }
//
    //public static boolean checkPwd1Pwd2(String argPwd1, String argPwd2){
    //    if( argPwd1.equals(argPwd2) ){
    //        return true;
   //     }else{
   //         return false;
   //     }
   // }

    public static String createEvent(String argEventID, String argEventTime, String argEventDate, String argEventLocation) {

        if (argEventID.equals(" ")) {
            return "Event id input empty";
        }
        if (checkEventExisting(argEventID)) {
            return "Event id already exists";
        }
        if (checkForBadCharacters(argEventID)) {
            return "Inputted Name is invalid";
        }
        if (argEventTime.equals(" ")) {
            return "Event Time input empty";
        }
        if (checkEventTime(argEventTime)) {
            return "Inputted Time is invalid";
        }
        if (argEventDate.equals(" ")) {
            return "Event Date input empty";
        }
        if( checkEventDate(argEventDate)) {
            return "Inputted Date is invalid";
        }
        if (argEventLocation.equals(" ")) {
            return "Event Location input empty";
        }
        if(checkForBadCharacters(argEventLocation)) {
            return "inputted location is invalid";
        }

        return "Event Registration Successful";
    }
}

