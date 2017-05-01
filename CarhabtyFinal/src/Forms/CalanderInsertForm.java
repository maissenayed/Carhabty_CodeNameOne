/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import com.codename1.components.FloatingHint;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

import com.codename1.l10n.SimpleDateFormat;

import com.codename1.ui.events.ActionEvent;

import com.codename1.ui.spinner.Picker;
import utils.LienWebService;
import utils.MyNewRequest;

/**
 *
 * @author Maissen
 */
public class CalanderInsertForm extends SideMenuForm {

    public CalanderInsertForm(Resources res,int id) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("insert new suivie");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        Button btnOk = new Button("Insert");

        Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        add(LayeredLayout.encloseIn(
                sl
        ));

        TextField title = new TextField();
        title.setUIID("TextFieldBlack");
        addStringValue("title", title);
        Picker Startannee = new Picker();
        Startannee.setType(Display.PICKER_TYPE_DATE);
        Startannee.setUIID("TextFieldBlack");
        addStringValue("startannee", Startannee);

        Picker Endannee = new Picker();
        Endannee.setType(Display.PICKER_TYPE_DATE);
        Endannee.setUIID("TextFieldBlack");
        addStringValue("Endannee", Endannee);

        add(BorderLayout.center(btnOk));
        btnOk.requestFocus();

        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
                String mo = title.getText();
                java.util.Date Sanne = Startannee.getDate();
                java.util.Date Eanne = Endannee.getDate();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String so = df.format(Sanne);
                String Eo = df.format(Eanne);
                System.out.println(so);
                if (title.getText().equals("") || so.equals("")) {
                    ToastBar.showMessage("all text field are requird", FontImage.MATERIAL_ERROR);

                    return;
                }
               
                MyNewRequest mnr = new MyNewRequest(LienWebService.INSERT_CAL +"?title=" + mo + "&startdate=" + so + "&enddate=" + Eo + "&id="+id);                
                mnr.getConnectionRequest().setPost(false);
                mnr.getConnectionRequest().addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        String dude = "success";
                        ToastBar.showMessage("startdate est " + s, FontImage.MATERIAL_INFO);
                        new CalanderForm(res,id).show(); 
                    }
                });

                NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());

            }
        });

    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
    private void insertaction(Button  btnOk){
    
    
    
    }
}
