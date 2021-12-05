import java.util.*;
public class LoginUserAccount
{
    static String userName = "admin";
    static String password = "SEisGreat!";
    static String[] users = {"admin","JSmith"};
    static String[] passwords = {"SEIsGreat!","Password123"};

    public static String login(String name, String pw)
    {
       String tempStr;
       for(int i = 0;i<users.length;i++) {
             if ((tempStr = users[i]).compareTo(name) == 0) {
               if ((tempStr = passwords[i]).compareTo(pw) == 0) {
                   return "Login Successful";
               } else
                   return "Error: Incorrect Password";
           }

       }
        return "Error: Incorrect User Name";
    }
}

