import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchStringTest {
    //
    @Test
    void register_TC1() {
        //all values valid
        assertEquals( eventDBManager.search("UTD event"), "Success"  );
    }

    @Test
    void register_TC2() {
        //error null
        assertEquals( eventDBManager.search(null), "Event Not Found"  );

    }

    @Test
    void register_TC3() {
        //error too long
        assertEquals( eventDBManager.search("ThisMessageIsTooLongToSearch"), "Event Not Found"  );
    }
    @Test
    void register_TC4() {
        //error invalid characters
        assertEquals( eventDBManager.search("~&^8&!(@)"), "Event Not Found"  );
    }

}