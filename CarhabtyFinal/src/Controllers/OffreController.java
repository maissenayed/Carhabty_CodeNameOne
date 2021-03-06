package Controllers;

import Entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OffreController {

  
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


      public int getPrix(String json) {

       
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
                
            }
        } catch (IOException ex) {
        }
        return 0;
    }








}
