/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

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
import Entity.Voiture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import java.util.HashMap;
import utils.LienWebService;
import utils.MyNewRequest;

/**
 *
 * @author Maissen
 */
public class VoitureForm extends SideMenuForm {

    public VoitureForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
         FormControle(res);
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

    private void addVoiturelistView(Image img, String title, String marque, String modele, Resources res, int id) {
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt = BorderLayout.west(image);
        cnt.setLeadComponent(image);
        TextArea ta = new TextArea(title);
        ta.setUIID("NewsTopLine");
        ta.setEditable(false);
        Label Marque = new Label(marque);
        Marque.setTextPosition(RIGHT);
        Label Modele = new Label(modele);
        Modele.setTextPosition(LEFT);
        cnt.add(BorderLayout.CENTER,
                BoxLayout.encloseY(
                        ta, BoxLayout.encloseX(Marque, Modele)
                ));
        add(cnt);
        add(createLineSeparator(0xeeeeee));
        image.addActionListener(e -> new CalanderForm(res, id).show());
        //this.refreshTheme();
        this.animateLayout(0);
    }

    public ArrayList<Voiture> getListEtudiant(String json) {
        ArrayList<Voiture> listVoiture = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("voiture");
            for (Map<String, Object> obj : list) {
                Voiture e = new Voiture();
                System.out.println();
                int i = (int) (Double.parseDouble(obj.get("id").toString()));
                e.setId(i);
                e.setImageName(obj.get("imagename").toString());
                e.setMarque(obj.get("marque").toString());
                e.setModel(obj.get("modele").toString());
                listVoiture.add(e);
            }

        } catch (IOException ex) {
        }
        return listVoiture;

    }

    private Map<String, Object> createListEntry(String name, String date) {
        Map<String, Object> entry = new HashMap<>();
        entry.put("Line1", name);
        entry.put("Line2", date);
        return entry;
    }

    private void FormControle(Resources res) {
     
        MyNewRequest mnr = new MyNewRequest(LienWebService.AFFICHAGE_VOITURE);  
       
        mnr.getConnectionRequest().setPost(false);
        mnr.getConnectionRequest().addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                ArrayList<Voiture> data = new ArrayList<>(getListEtudiant(new String(mnr.getConnectionRequest().getResponseData())));
                System.out.println(data);
                if (data.isEmpty()) {
                    new VoitureInsertForm(res).show();
                }
                for (Voiture obj : getListEtudiant(new String(    mnr.getConnectionRequest().getResponseData()))) {
                    String brochure = obj.getImageName();
                    System.out.println(brochure);
                    EncodedImage img = EncodedImage.createFromImage(Image.createImage(Display.getInstance().getDisplayWidth(), 150), true);
                    URLImage imgg = URLImage.createToStorage(img, LienWebService.IMAGE_VOITURE + brochure, LienWebService.IMAGE_VOITURE  + brochure);
                    imgg.fetch();
                    ImageViewer imgv = new ImageViewer(imgg);
                    addVoiturelistView(imgv.getImage(), obj.getMarque(), obj.getMarque(), obj.getModel(), res, obj.getId());
                }
            }
        });
        
        
        
        NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("voiture");
        getContentPane().setScrollVisible(false);
        super.addSideMenu(res);
        Tabs swipe = new Tabs();
        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("dude.jpg"), spacer1, " ", "", "");
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

}
