import java.util.ArrayList;
import java.util.List;

public class Event
{
    private String argEventID, argEventDate,argEventTime, argEventLocation;
    private List<Boolean> votes;

    public String getArgEventName() {
        return argEventID;
    }

    public void setArgEventID(String argEventID) {
        this.argEventID = argEventID;
    }

    public String getArgEventDate() {
        return argEventDate;
    }

    public void setArgEventDate(String argEventDate) {
        this.argEventDate = argEventDate;
    }

    public String getArgEventTime() {
        return argEventTime;
    }

    public void setArgEventTime(String argEventTime) {
        this.argEventTime = argEventTime;
    }

    public String getArgEventLocation() {
        return argEventLocation;
    }

    public void setArgEventLocation(String argEventLocation) {
        this.argEventLocation = argEventLocation;
    }

    public void voteYes()
    {
        votes.add(true);
    }
    public void voteNo()
    {
        votes.add(false);
    }
    public void getVotes(){
        int count = 0;
        for (Boolean b : votes) {
            count++;
            System.out.print(count+") ");
            System.out.println(b);
        }
    }
    public Event(String argEventID, String argEventDate , String argEventTime, String argEventLocation){
       this.argEventID = argEventID;
       this.argEventDate = argEventDate;
       this.argEventTime = argEventTime;
       this.argEventLocation = argEventLocation;
       votes = new ArrayList<Boolean>();
    }
    public Event(String argEventID){
        this.argEventID = argEventID;
        argEventDate = null;
        argEventTime = null;
        argEventLocation = null;
        votes = new ArrayList<Boolean>();
    }
}
