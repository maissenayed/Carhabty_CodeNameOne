/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package Forms;

import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.io.CharArrayReader;
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
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.LienWebService;
import utils.MyNewRequest;
import utils.Session;

public class PaimentForm extends SideMenuForm {

    Integer somme = 0;
    List<String> test = new ArrayList<>();

    public PaimentForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Carhabty");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        tb.addSearchCommand(e -> {
           
            
        });

        Tabs swipe = new Tabs();

        Label spacer1 = new Label();
        Label spacer2 = new Label();
        addTab(swipe, res.getImage("noir.jpg"), spacer1, "", "", "");

        swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

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

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton offre = RadioButton.createToggle("Paiment Partenaire", barGroup);
        offre.setUIID("SelectBar");

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(1, offre)
        ));

        TextField t1 = new TextField("", "Insérer référence coupon", 20, TextField.ANY);
        t1.setUIID("TextFieldBlack");
        addStringValue("", t1);

        Label l3 = new Label("");
        addStringValue("", l3);

        Button b = new Button("valider");
        b.setUIID("Button");
        addStringValue("", b);
        
        Button b1 = new Button("Terminer");
        b.setUIID("Button");
        addStringValue("", b1);

        b.addActionListener((evt) -> {

            MyNewRequest mnr = new MyNewRequest(LienWebService.PRIX);

            mnr.getConnectionRequest().setPost(true);
            if (!test.contains(t1.getText())) {

                test.add(t1.getText());

                mnr.getConnectionRequest().addArgument("ref", t1.getText());             
                mnr.getConnectionRequest().addResponseListener((NetworkEvent e) -> {

                    try {

                        JSONParser j = new JSONParser();

                        Map<String, Object> json = j.parseJSON(new CharArrayReader(new String(mnr.getConnectionRequest().getResponseData()).toCharArray()));

                        List p = (ArrayList) (json.get("root"));
                        Map x = (Map<String, Object>) p.get(0);
                        Integer prix = ((Double) x.get("prix")).intValue();

                        somme = somme + prix;
                        System.out.println(somme);
                        l3.setText("somme à payer : " + somme.toString());
                        for (int i = 0; i < test.size(); i++) {

                            System.out.println(test.get(i));

                        }

                    } catch (IOException o) {
                    }
                });
                NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());

            } else {

                ToastBar.showErrorMessage("référence coupon déja pris en compte");

            }
        this.refreshTheme();});

          b1.addActionListener((evt) -> {
                 MyNewRequest mnr = new MyNewRequest(LienWebService.PRIX);
                mnr.getConnectionRequest().setPost(true);            
                mnr.getConnectionRequest().addArgument("id",String.valueOf(Session.getUser().getId()));             
                mnr.getConnectionRequest().addResponseListener((NetworkEvent e) -> {
              
                    System.out.println(Session.getPartner().getId());
                      System.out.println(new String(mnr.getConnectionRequest().getResponseData()).toCharArray());
                   });
                NetworkManager.getInstance().addToQueue(mnr.getConnectionRequest());
      
    
          
          this.refreshTheme();
          });
    
    }

    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.SOUTH, v));
    
    }

    private void addTab(Tabs swipe, Image img, Label spacer, String likesStr, String commentsStr, String text) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
        if (img.getHeight() < size) {
            img = img.scaledHeight(size);
        }
        Label likes = new Label(likesStr);
        Style heartStyle = new Style(likes.getUnselectedStyle());
        heartStyle.setFgColor(0xff2d55);

        likes.setTextPosition(RIGHT);

        Label comments = new Label(commentsStr);

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
                                        new SpanLabel(text, "LargeWhiteText"),
                                        FlowLayout.encloseIn(likes, comments),
                                        spacer
                                )
                        )
                );

        swipe.addTab("", page1);
    }

}
