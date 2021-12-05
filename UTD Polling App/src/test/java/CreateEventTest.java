import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEventTest {

    @Test
    @DisplayName("No Error")
    void createEvent_TC1() {
        Event testEvent1 = new Event("Brand New Event", "11-22-2021",  "05:00", "SU 1.11");
        assertEquals( createEvent.createEvent(testEvent1), "Event Registration Successful");
    }
    @Test
    @DisplayName("Date Error")
    void createEvent_TC2() {
        Event testEvent2 = new Event("Ice Cream Social", "yy/yy/yyyy",  "05:00", "SU 1.11");
          assertEquals( createEvent.createEvent(testEvent2), "inputted date is invalid");
    }
    @Test
    @DisplayName("Date Null")
    void createEvent_TC3() {
        Event testEvent3 = new Event("Ice Cream Social", null,  "05:00", "SU 1.11");
          assertEquals( createEvent.createEvent(testEvent3), "event date input empty");
    }
    @Test
    @DisplayName("Time Error")
    void createEvent_TC4() {
        Event testEvent4 = new Event("Ice Cream Social", "11-22-2021",  "26:61pm", "SU 1.11");
          assertEquals( createEvent.createEvent(testEvent4), "inputted time is invalid");
    }
    @Test
    @DisplayName("Time Null")
    void createEvent_TC5() {
        Event testEvent5 = new Event("Ice Cream Social", "11-22-2021",  null, "SU 1.11");
        assertEquals( createEvent.createEvent(testEvent5), "event time input empty");
    }
    @Test
    @DisplayName("Location Error")
    void createEvent_TC6() {
        Event testEvent6 = new Event("Ice Cream Social", "11-22-2021",  "05:00", "//////");
          assertEquals( createEvent.createEvent(testEvent6), "inputted location is invalid");
    }
    @Test
    @DisplayName("Location Null")
    void createEvent_TC7() {
        Event testEvent7 = new Event("Ice Cream Social", "11-22-2021",  "05:00", null);
          assertEquals( createEvent.createEvent(testEvent7), "event location input empty");
    }
    @Test
    @DisplayName("Name Error")
    void createEvent_TC8() {
        Event testEvent8 = new Event("1234567", "11-22-2021",  "05:00", "SU 1.11");
          assertEquals( createEvent.createEvent(testEvent8), "inputted name is invalid");
    }
    @Test
    @DisplayName("Name Null")
    void createEvent_TC9() {
        Event testEvent9 = new Event(null, "11-22-2021",  "05:00", "SU 1.11");
          assertEquals( createEvent.createEvent(testEvent9), "event id input empty");
    }
    @Test
    @DisplayName("Event Already Exists Error")
    void createEvent_TC10() {
        Event testEvent10 = new Event("Monster Bash", "11-22-2021",  "05:00", "SU 1.11");
        assertEquals( createEvent.createEvent(testEvent10), "event id already exists");
    }


}