import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing for UC1 Create Account
 */
class CreateAccountTest {
    //
    @Test
    void createAccount_TC1() {
        //all values valid
        assertEquals( CreateAccount.createAccount("newuser@hmail.com", "xft123%PLM",  "xft123%PLM"), "Account Successfully Created!"  );
    }

    @Test
    void createAccount_TC2() {
        //retyped does not match
        assertEquals( CreateAccount.createAccount("newuser@hmail.com", "xft123%PLM",  "yyyyyyyyy"), "Retyped password does not match the password"  );

    }

    @Test
    void createAccount_TC3() {
        //pwd length is  8 but does not satisfy rules
        assertEquals( CreateAccount.createAccount("newuser@hmail.com", "zzzzzzzz",  "xft123%PLM"), "Password does not satisfy rules for a valid password"  );
    }
    @Test
    void createAccount_TC4() {
        //pwd length is 1
        assertEquals( CreateAccount.createAccount("newuser@hmail.com", "x",  "xft123%PLM"), "Password does not satisfy length requirement"  );
        //public static String register(String argLoginID, String argPwd1, String argPwd2){
    }

    @Test
    void createAccount_TC5() {
        //sending an existing user
        assertEquals( CreateAccount.createAccount("olduser@hmail.com", "xft123%PLM",  "xft123%PLM"), "Login id exists !!!"  );
    }
    @Test
    void createAccount_TC6() {
        //login id has space in it
        assertEquals( CreateAccount.createAccount("new user@hmail.com", "xft123%PLM",  "xft123%PLM"), "Login id has space/control/special character in it"  );
    }


}