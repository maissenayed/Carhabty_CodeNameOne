/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Controllers.QuizController;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * GUI builder created Form
 *
 * @author azgar
 */
public class StatistiqueForm extends com.codename1.ui.Form {

    private Button pieGeneral;
    private Button byType;
    private Button progression;
    private Container view;

    public StatistiqueForm(QuizForm quiz) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        Toolbar.setGlobalToolbar(true);
        Toolbar tb = new Toolbar();

        this.setToolbar(new Toolbar());

        Image i = (com.codename1.ui.util.Resources.getGlobalResources()).getImage("back-command.png");
        Command cmdBack = new Command("Back", i);
        this.getToolbar().addCommandToLeftBar(cmdBack);
        this.addCommandListener(e -> {
            if (e.getCommand() == cmdBack) {
                quiz.showBack();
            }
        });
        setLayout(new BorderLayout());

        pieGeneral = new Button("pie");
        byType = new Button("byType");
        progression = new Button("progression");
        view = new Container();
        byType.addActionListener((evt) -> {

        });
       /* pieGeneral.addActionListener((evt) -> {
            QuizController qc = new QuizController();
            Map<String, Integer> dataCorrect = qc.getCorrectByType();
            Map<String, Integer> dataAll = qc.getByType();
            Map<String, Integer> data = new LinkedHashMap<String, Integer>();
            int tmpCorrect = 0;
            int tmpAll = 0;
            for (Map.Entry<String, Integer> item : dataCorrect.entrySet()) {
                tmpCorrect += item.getValue();
            }

            for (Map.Entry<String, Integer> item : dataAll.entrySet()) {
                tmpAll += item.getValue();
            }

            data.put("Correct", tmpCorrect);
            data.put("Faux", tmpAll - tmpCorrect);
            StatistiqueForm.this.view.removeAll();
            StatistiqueForm.this.view.add(new PieChartContainer(data));
            StatistiqueForm.this.animateLayout(0);
            StatistiqueForm.this.refreshTheme();

        });*/

        Container control = new Container(new BoxLayout(BoxLayout.X_AXIS));
        control.add(pieGeneral);
        control.add(byType);
        control.add(progression);

        QuizController qc = new QuizController();
        Map<String, Integer> dataCorrect = qc.getCorrectByType();
        Map<String, Integer> dataAll = qc.getByType();
        Map<String, Integer> data = new LinkedHashMap<String, Integer>();
        int tmpCorrect = 0;
        int tmpAll = 0;
        for (Map.Entry<String, Integer> item : dataCorrect.entrySet()) {
            tmpCorrect += item.getValue();
        }

        for (Map.Entry<String, Integer> item : dataAll.entrySet()) {
            tmpAll += item.getValue();
        }

        data.put("Correct", tmpCorrect);
        data.put("Faux", tmpAll - tmpCorrect);
        setLayout(new FlowLayout());
        ((com.codename1.ui.layouts.FlowLayout)getLayout()).setValign(TOP);
        add(new PieChartContainer(data));
    }

    public StatistiqueForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setTitle("StatistiqueForm");
        setName("StatistiqueForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
