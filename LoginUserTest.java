import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginUser_UseCase_Testing {
    //
    @Test
    void register_TC1() {
        //all values valid
        assertEquals( LoginUser.login("JSmith", "Password123"), "Login Successful"  );
    }

    @Test
    void register_TC2() {
        //password does not match username
        assertEquals( LoginUser.login("Jsmith", "5ra&%-1"), "Password incorrect"  );

    }

    @Test
    void register_TC3() {
        //username wrong or null
        assertEquals( RegisterUser.register("null", "Password123), "Username does not exist"  );
    }
    @Test
    void register_TC5() {
        //username and password both wrong
        assertEquals( RegisterUser.register("null", "5ra&%-1"), "Username and password incorrect"  );
    }


}
