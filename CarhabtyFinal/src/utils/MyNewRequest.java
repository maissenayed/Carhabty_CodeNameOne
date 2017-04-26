/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author skin
 */
public class MyNewRequest {

    private ConnectionRequest connectionRequest;

    public MyNewRequest(String url) {
        connectionRequest = new ConnectionRequest(url);
        makeService();
    }

    public MyNewRequest() {
        makeService();
    }

    private void makeService() {
        connectionRequest.addResponseCodeListener(e -> {
            if (connectionRequest.getResponseCode() == 401) {
                ConnectionRequest cr = Session.refreshToken();
                cr.addResponseListener((NetworkEvent evt) -> {
                    if (cr.getResponseCode() == 400) {
                        Session.logout();
                    }
                });
                cr.addResponseListener(evt -> {
                    if (cr.getResponseCode() == 200) {
                        JSONParser jp = new JSONParser();
                        try {
                            Map<String, Object> token = jp.parseJSON(new CharArrayReader(new String(cr.getResponseData()).toCharArray()));
                            Session.token = (String) token.get("access_token");
                            Session.refreshToken = (String) token.get("refresh_token");
                           
                        } catch (IOException ex) {
                        }

                    }
                });
                NetworkManager.getInstance().addToQueue(cr);
            }
        });
        connectionRequest.addRequestHeader("Authorization", "Bearer " + Session.token);
    }

    public ConnectionRequest getConnectionRequest() {
        return connectionRequest;
    }

}
