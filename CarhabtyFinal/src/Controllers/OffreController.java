package Controllers;

import Entity.Offre;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OffreController {

    public String ParseOffre() {

        ConnectionRequest req = new ConnectionRequest();
        req.setUrl("http://localhost/Carhabtyy/web/app_dev.php/services/listOffre");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                getListOffre(new String(req.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueue(req);
    return new String(req.getResponseData());
    }

    
    
    public ArrayList<Offre> getListOffre(String json) {

        ArrayList<Offre> ListOffres = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> offres = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) offres.get("offre");
            for (Map<String, Object> obj : list) {
                Offre o = new Offre();
                o.setReduction(Float.parseFloat(obj.get("reduction").toString()));
                o.setNomOffre(obj.get("nomoffre").toString());
                o.setPrix(Float.parseFloat(obj.get("prix").toString()));
                o.setImage(obj.get("image").toString());
                ListOffres.add(o);
            }
        } catch (IOException ex) {
        }
        return ListOffres;
    }
}
