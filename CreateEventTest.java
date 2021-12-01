
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEventTest {

    @Test
    void createEvent_TC1() {
          assertEquals(createEvent.createEvent("Ice Cream Social", "11-22-2021",  "05:00", "SU 1.11"), "Event Registration Successful");
    }
    @Test
    void createEvent_TC2() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "yy/yy/yyyy",  "05:00", "SU 1.11"), "Inputted Date is Invalid");
    }
    @Test
    void createEvent_TC3() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "",  "05:00", "SU 1.11"), "Event id input empty");
    }
    @Test
    void createEvent_TC4() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "11-22-2021",  "26:61pm", "SU 1.11"), "Inputted Time is Invalid");
    }
    @Test
    void createEvent_TC5() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "11-22-2021",  "", "SU 1.11"), "Event Time input empty");
    }
    @Test
    void createEvent_TC6() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "11-22-2021",  "05:00", "//////"), "Inputted Location is invalid");
    }
    @Test
    void createEvent_TC7() {
          assertEquals( createEvent.createEvent("Ice Cream Social", "11-22-2021",  "05:00", ""), "Event location input empty");
    }
    @Test
    void createEvent_TC8() {
          assertEquals( createEvent.createEvent("1234567", "11-22-2021",  "05:00", "SU 1.11"), "Inputted Name is invalid");
    }
    @Test
    void createEvent_TC9() {
          assertEquals( createEvent.createEvent("", "11-22-2021",  "05:00", "SU 1.11"), "event id input empty");
    }
    @Test
    void createEvent_TC10() {
        assertEquals( createEvent.createEvent("Monster Bash", "11-22-2021",  "05:00", "SU 1.11"), "Event id already exists");
    }

}