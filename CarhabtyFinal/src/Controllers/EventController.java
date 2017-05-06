package Controllers;

import Entity.Event;
import Entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventController {

  
    public ArrayList<Event> getListEvent(String json) {

        ArrayList<Event> ListEvent = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> event = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) event.get("Event");
            for (Map<String, Object> obj : list) {
                Event o = new Event();
                
                o.setTitle(obj.get("title").toString());         
                o.setDescription(obj.get("description").toString());
                o.setAdresse(obj.get("address").toString());
               
                ListEvent.add(o);
            }
        } catch (IOException ex) {
        }
        return ListEvent;
    }
}
