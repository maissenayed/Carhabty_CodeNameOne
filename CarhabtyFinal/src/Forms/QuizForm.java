/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Controllers.QuizController;
import Entity.MusicGame;
import com.codename1.components.ScaleImageLabel;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;



/**
 * GUI builder created Form
 *
 * @author azgar
 */
public class QuizForm extends SideMenuForm {

    QuestionTmpContainer q;
    public static Label badge;

    public QuizForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        QuizController qc=new QuizController();
        qc.dataBaseLight();
       
        
        Storage s = Storage.getInstance();
        if(!s.exists("music"))
            s.writeObject("music",true);
        if(!s.exists("volume"))
            s.writeObject("volume", 50);
        
        
        if((boolean)s.readObject("music"))
        {MusicGame.getInstance().play();}
        
        getContentPane().setScrollVisible(false);
        
         super.addSideMenu(res);

         
        badge=new Label(res.getImage("badgeQ1.png"), "Badge");
      
       
        Image img = res.getImage("quizBg.png");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 8) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight()/8);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        

        //res.getImage("config-logo.png")
        Image im=res.getImage("config-logo.png");
        im=im.scaled(40, 40);
        Button conf = new Button(im);
    
       
    
        conf.setUIID("qdqsq");
        conf.setEnabled(true);
        conf.setHeight(40);
        
        conf.setWidth(40);
        

       
        conf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new ConfigDialog().show();
            }
        });
       
       
      Button scoreBtn=new Button("score");
      scoreBtn.setUIID("BtnSucces");
      scoreBtn.addActionListener((evt) -> {
          
          new ScoreForm(this).show();
          
      });
    
      Button StatBtn=new Button("stat");
      StatBtn.setUIID("BtnSucces");
      StatBtn.addActionListener((evt) -> {
          StatistiqueForm st=new StatistiqueForm(this);
          st.show();
      });
     
      Container pst=new Container(new GridLayout(3));
    
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(3, 
                            new Label(""),
                          
                            FlowLayout.encloseCenter(
                                badge),
                            new Label("")       
                    )
                )
        ));
        pst.setHeight(40);
     
       pst.add(FlowLayout.encloseRight(StatBtn));
       pst.add(FlowLayout.encloseRight(scoreBtn));
       pst.add(FlowLayout.encloseRight(conf));
       add(pst);
     
     add(createLineSeparator(0xeeeeee));
       
        q = new QuestionTmpContainer();
        this.add(q);
        

          


            // music.play();
            //md.setVisible(false);

            //this.add(md);

   

    }

//-- DON'T EDIT BELOW THIS LINE!!!
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("QuizForm");
        setName("QuizForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
