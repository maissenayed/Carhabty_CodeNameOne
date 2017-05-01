/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Entity.ScoreQuiz;
import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 * GUI builder created Container
 *
 * @author azgar
 */
public class ScoreItem extends com.codename1.ui.Container {

    public ScoreItem(ScoreQuiz sc) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        setLayout(new BoxLayout(BoxLayout.X_AXIS));
        Label nom=new Label(sc.getNom());
       
        Label scre=new Label(sc.getScore()+"");
       
        add(nom);
        add(scre);
  
     
        
    }
    
    public ScoreItem(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }
    


//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setName("ScoreItem");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
