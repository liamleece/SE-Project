import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginUserAccountTest {
    //
    @Test
    void register_TC1() {
        //all values valid
        assertEquals( LoginUserAccount.login("JSmith", "Password123"), "Login Successful"  );
    }

    @Test
    void register_TC2() {
        //password does not match username
        assertEquals( LoginUserAccount.login("JSmith", "5ra&%-1"), "Error: Incorrect Password"  );

    }
    @Test
    void register_TC3() {
        //username does not exist
        assertEquals( LoginUserAccount.login("alsdfkhjldaf", "Password123"), "Error: Incorrect User Name"  );

    }

}