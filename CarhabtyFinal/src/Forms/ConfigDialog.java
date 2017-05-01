/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entity.MusicGame;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;


/**
 * GUI builder created Dialog
 *
 * @author azgar
 */
public class ConfigDialog extends com.codename1.ui.Dialog {

    public ConfigDialog() {

        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        Storage s = Storage.getInstance();
  
        this.setTitle("Volume");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        CheckBox c = new CheckBox("Musique");
        c.addActionListener((evt) -> {
               s.writeObject("music",c.isSelected());
               if(c.isSelected())
              {MusicGame.getInstance().play();}
               else
                      {MusicGame.getInstance().stop();}
                   
        });
        c.setSelected((boolean) s.readObject("music"));
        
        
        c.setUIID("CtCheck");
        Button save = new Button("ok");
        save.addActionListener((evt) -> {
            this.dispose();
        });
 
     
        Container controle = new Container(new BorderLayout());
                controle.add(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE,save);
    
        addComponent(c);
        Slider jSlider = new Slider();
        jSlider.setMaxValue(100);
        jSlider.setMinValue(0);
        jSlider.setProgress((int)s.readObject("volume")); // Set  the starting value
        jSlider.setEditable(true);
        jSlider.setText("Volume");
        jSlider.setTextPosition(0);
        jSlider.addActionListener((evt) -> {
            s.writeObject("volume",jSlider.getProgress() );
            MusicGame.getInstance().setVolume(jSlider.getProgress());
        });

        addComponent(jSlider);
        addComponent(createLineSeparator(0xeeeeee));
        addComponent(controle);
       

    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public ConfigDialog(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("ConfigDialog");
        setName("ConfigDialog");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
