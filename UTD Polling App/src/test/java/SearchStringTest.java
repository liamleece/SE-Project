import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchStringTest {
    //
    @Test
    void register_TC1() {
        //all values valid
        Event testEvent = null;
        assertEquals( searchEvent.searchEvent("Monster Bash" ),"Monster Bash");
    }

    @Test
    void register_TC2() {
        //error null
        assertEquals( searchEvent.searchEvent(" "), "Search String Empty"  );

    }
    @Test
    void register_TC3() {
        //error invalid characters
        assertEquals( searchEvent.searchEvent("~&^8&!(@)"), "Search String invalid"  );
    }

}