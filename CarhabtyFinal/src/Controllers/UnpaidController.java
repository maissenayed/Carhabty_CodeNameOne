package Controllers;

import Entity.Offre;
import Entity.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnpaidController {

  
    public ArrayList<User> getListPartner(String json) {

        ArrayList<User> ListPartner = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> partner = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) partner.get("user");
            for (Map<String, Object> obj : list) {
                User o = new User();
                o.setId(((Double)obj.get("id")).intValue());
                o.setNomSociete(obj.get("nomsociete").toString());
                o.setTel(obj.get("telephone").toString());
                o.setActivite(obj.get("activite").toString());
                o.setImage(obj.get("photo").toString());
                ListPartner.add(o);
            }
        } catch (IOException ex) {
        }
        return ListPartner;
    }


    








}
