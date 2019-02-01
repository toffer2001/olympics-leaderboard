package winterolympics;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author KristofferKeene
 */
public class Event implements Serializable {
    private String eventName;
    private String eventInfo;
    private boolean ifTimed;
    private ArrayList<Competitor> competitors;
    
    public Event() {
        
    }

    public Event(String eventName, String eventInfo, boolean ifTimed) {
        this.eventName = eventName;
        this.eventInfo = eventInfo;
        this.ifTimed = ifTimed;
        this.competitors =  new ArrayList<>();
    } // end OlympicEvent constructor

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public boolean isIfTimed() {
        return ifTimed;
    }

    public void setIfTimed(boolean ifTimed) {
        this.ifTimed = ifTimed;
    }
    
    public void addCompetitor(Competitor competitor) {
        competitors.add(competitor);
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }
    
    


    
    


    

}
