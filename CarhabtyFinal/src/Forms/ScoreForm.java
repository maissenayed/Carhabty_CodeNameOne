/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Controllers.QuizController;
import Entity.ScoreQuiz;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author azgar
 */
public class ScoreForm extends com.codename1.ui.Form {

    public ScoreForm(QuizForm frm) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
            Button back = new Button("back");
            
            
            this.setBackCommand(new Command("Back") {
            @Override
            public void actionPerformed(ActionEvent evt) {
             frm.show();
            }
        });
            this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            this.add(back);
            
             this.setToolbar(new Toolbar());
             
             back.addActionListener((e) -> {
       
          frm.show();

    });
             
    QuizController qc=new QuizController();
    List <ScoreQuiz> lst=qc.getScores();
    for(ScoreQuiz s:lst)
    {
        System.out.println(s.getNom()+"123");
        add(new ScoreItem(s));
        add(createLineSeparator(0xeeeeee));
        System.out.println(s.getScore());
    }
             
    }
    
    
        
      public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }
    
      
          public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }
          
          
          
    public ScoreForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("ScoreForm");
        setName("ScoreForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
