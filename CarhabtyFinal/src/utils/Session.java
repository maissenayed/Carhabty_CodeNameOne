/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import Carhabty.Carhabty;
import Entity.User;
import Forms.ProfileForm;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 *
 * @author skin
 */
public class Session {
    
     public static String token;
     public static String refreshToken;

   
     

    public static void Login(String username, String password) {
        ConnectionRequest cr = new ConnectionRequest(LienWebService.LOGIN);
      
        
        cr.addResponseCodeListener((NetworkEvent evt) -> {
            
            
            if (cr.getResponseCode() == 400) {
                ToastBar.showErrorMessage("Nom d'utilisateur ou mot de passe sont invalide");
            }
        });
        cr.setPost(true);
       
        cr.addArgument("grant_type", "password");
       
        cr.addArgument("client_id", "2_3bcbxd9e24g0gk4swg0kwgcwg4o8k8g4g888kwc44gcc0gwwk4");
        
        cr.addArgument("client_secret", "4ok2x70rlfokc8g0wws8c8kwcokw80k44sg48goc0ok4w0so0k");
       
        cr.addArgument("username", username);
       
        cr.addArgument("password", password);
       
        cr.addResponseListener((NetworkEvent evt) -> {
            if (cr.getResponseCode() == 200) {
                JSONParser jp = new JSONParser();
                try {
                    
                    Map<String, Object> token = jp.parseJSON(new CharArrayReader(new String(cr.getResponseData()).toCharArray()));
                   
                    Session.token = (String) token.get("access_token");
                    
                    Session.refreshToken = (String) token.get("refresh_token");
                    

                } catch (IOException ex) {

                }
                if (token != null) {
                    
                    MyNewRequest mnr = new MyNewRequest(LienWebService.CUSER);
                    mnr.getConnectionRequest().addResponseListener((NetworkEvent e) -> {
                        
                        try {
                            
                             JSONParser j = new JSONParser();
                             Map<String, Object> offres = j.parseJSON(new CharArrayReader(new String(mnr.getConnectionRequest().getResponseData()).toCharArray()));
                                
                            
                            System.out.println(new String(mnr.getConnectionRequest().getResponseData()));
                           
                            Map<String, Object> json = jp.parseJSON(new CharArrayReader(new String(mnr.getConnectionRequest().getResponseData()).toCharArray()));                     
                            User user = new User();  
                            user.setEmail((String) json.get("email"));
                            user.setNom((String) json.get("nom"));
                            user.setPrenom((String) json.get("prenom"));
                            user.setUsername((String) json.get("username"));
                            //user.setRole((String) json.get("role"));
                            
                            Session.setUser(user);
                            Access();
                        } catch (IOException ex) {

                        }

                    });
                    NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());
                }
            }
        });
        NetworkManager.getInstance().addToQueue(cr);
    }

    
     public static void Access() {
      
        new ProfileForm(Carhabty.getTheme()).show();
      
    }
    
    public static void logout() {
      
           
            Session.setUser(null);
            Session.token = null;
            Session.refreshToken = null;
            

       
    }

    public static ConnectionRequest refreshToken() {
        ConnectionRequest cr = new ConnectionRequest(LienWebService.LOGIN);
        cr.addResponseCodeListener(e -> {
            if (cr.getResposeCode() == 400) {
                logout();
            }
        }
        );
        cr.setPost(true);
        cr.addArgument("grant_type", "refresh_token");
        cr.addArgument("client_id", "2_3bcbxd9e24g0gk4swg0kwgcwg4o8k8g4g888kwc44gcc0gwwk4");
        cr.addArgument("client_secret", "4ok2x70rlfokc8g0wws8c8kwcokw80k44sg48goc0ok4w0so0k");
        cr.addArgument("refresh_token", refreshToken);
        return cr;

    }
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Session.user = user;
    }
    
    
}
