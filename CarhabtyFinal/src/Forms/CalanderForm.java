/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entity.CalendarEvent;
import com.codename1.components.FloatingHint;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.events.ActionEvent;
import utils.LienWebService;
import utils.MyNewRequest;


/**
 *
 * @author Maissen
 */
public class CalanderForm extends SideMenuForm {

    public CalanderForm(Resources res, int id) {
        super("Newsfeed", BoxLayout.y());
        
        System.out.println(id);
        MyNewRequest mnr = new MyNewRequest(LienWebService.AFFICHAGE_CAL+ id + "/calendar/json");
        mnr.getConnectionRequest().setPost(false);
       
        mnr.getConnectionRequest().addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("dude" + getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                ArrayList<CalendarEvent> data = new ArrayList<>(getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                if (data.isEmpty()) {
                    new CalanderInsertForm(res, id).show();
                }
                for (CalendarEvent obj : getListEtudiant(new String(mnr.getConnectionRequest().getResponseData()))) {
                    addVoiturelistView(res.getImage("ico-4.png"), obj.getTitle(), obj.getStartDate(), obj.getStartDate(), res);

                }

            }
        });
        
        NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("suivie voiture");
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);
        Tabs swipe = new Tabs();
        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("dude.jpg"), spacer1, " ", "", "  ");
        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
      

        Component.setSameSize(radioContainer, spacer1, spacer2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

    }

    private void addTab(Tabs swipe, Image img, Label spacer, String likesStr, String commentsStr, String text) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if (img.getHeight() < size) {
            img = img.scaledHeight(size);
        }
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 6) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 6);
        }
        ScaleImageLabel image = new ScaleImageLabel(img);
        image.setUIID("Container");
        image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overlay = new Label(" ", "ImageOverlay");

        Container page1
                = LayeredLayout.encloseIn(
                        image,
                        overlay,
                        BorderLayout.south(
                                BoxLayout.encloseY(
                                       
                                        spacer
                                )
                        )
                );

        swipe.addTab("", page1);
    }

    private void addVoiturelistView(Image img, String title, String start, String modele, Resources res) {
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        cnt.setLeadComponent(image);
        TextArea ta = new TextArea(title);
        ta.setUIID("NewsTopLine");
        ta.setEditable(false);
        Label Marque = new Label(start);
        Marque.setTextPosition(RIGHT);
        Label Modele = new Label(modele);
        Modele.setTextPosition(LEFT);
        cnt.add(BorderLayout.CENTER,
                BoxLayout.encloseY(
                        ta, BoxLayout.encloseX(Marque, Modele)
                ));
        add(cnt);
        add(createLineSeparator(0xeeeeee));
        image.addActionListener(e -> ToastBar.showMessage("startdate est " + start, FontImage.MATERIAL_INFO));
        image.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                
        MyNewRequest mnr = new MyNewRequest(LienWebService.AFFICHAGE_EMAIL);
        mnr.getConnectionRequest().setPost(false);
        mnr.getConnectionRequest().addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println("dude" + getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                ArrayList<CalendarEvent> data = new ArrayList<>(getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                System.out.println(data);
             

            }
        });
        
        NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());
  
                Message m = new Message("suivie voiture");

                Display.getInstance().sendMessage(new String[]{"ayed.maissen@gmail.com"}, "suivie voiture", m);
                try {
                    switch (Display.getInstance().getSMSSupport()) {
                        case Display.SMS_NOT_SUPPORTED:
                            System.out.println("not supported for Desktop");
                            return;
                        case Display.SMS_SEAMLESS:
                            Display.getInstance().sendSMS("+21693155033", "il3asba");
                            return;
                        default:
                            Display.getInstance().sendSMS("+21693155033", "il3asba");
                            return;
                    }

                } catch (IOException ex) {
                    System.out.println("kfjfljs");
                }
            }
        });

        this.animateLayout(0);

    }

    public ArrayList<CalendarEvent> getListEtudiant(String json) {
        ArrayList<CalendarEvent> listVoiture = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("Calander");
            for (Map<String, Object> obj : list) {
                CalendarEvent e = new CalendarEvent();
                /*  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = null;
                Date endDate = null;
                String newDateString = null;
                try {
                    startDate = df.parse(obj.get("start_date").toString());
                    newDateString = df.format(startDate);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }*/

                e.setStartDate(obj.get("start_date").toString());
                e.setTitle(obj.get("title").toString());
                listVoiture.add(e);

            }

        } catch (IOException ex) {
        }
        return listVoiture;
    }

 

}
