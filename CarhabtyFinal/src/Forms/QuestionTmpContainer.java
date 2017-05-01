/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Controllers.QuizController;
import Entity.Media;
import Entity.Question;
import Entity.QuizAdapter;
import Entity.Reponse;
import Entity.ScoreQuiz;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/**
 * GUI builder created Container
 *
 * @author azgar
 */
public class QuestionTmpContainer extends com.codename1.ui.Container {

    private final String serverImages = "http://localhost/Symf/Carhabty/web/images/question/";

    private QuizAdapter quest;
    private int index;

    private Container controle;
    private Button previous;
    private Button next;
    private TextArea question;
    private Container reponses;
    private boolean flagFinish;
    private Container me = this;
    private Button validate;
    private Button rejouer;

    private List<QuizAdapter> rdmList;

    public QuestionTmpContainer() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        rejouer = new Button("Rejouer");
        rejouer.setUIID("BtnSucces");
        rejouer.addActionListener((evt) -> {
            me.removeAll();
            initGame();
        });

        validate = new Button("Validate");
        validate.setUIID("BtnSucces");

        validate.addActionListener((evt) -> {

            flagFinish = true;
            Dialog.show("Test fini", "Vous pouvez vérifier les réponses maintenant", "OK", "Cancel");
            finshControle();
            QuizController qc=new QuizController();
            int myscore=qc.saveAction(rdmList);
            ScoreQuiz tp=new ScoreQuiz("test", myscore);
            qc.insertScore(tp);

        });

        index = 0;
        QuizController qc = new QuizController();

        rdmList = qc.getRdmListQuiz();

        quest = rdmList.get(index);

        this.flagFinish = false;
        this.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        setComp();
    }

    private void setComp() {
        controle = new Container(new BoxLayout(BoxLayout.X_AXIS));
        QuizForm.badge.setIcon(com.codename1.ui.util.Resources.getGlobalResources().getImage("badgeQ"+(index+1)+".png"));
        previous = new Button("<");
        previous.addActionListener((evt) -> {
            me.removeAll();
            index--;

            quest = rdmList.get(index);
            setComp();
            me.animateHierarchy(0);
        });

        next = new Button(">");
        next.addActionListener((evt) -> {
            index++;
          
            if (index == 10) {
                next.setEnabled(false);

                finshControle();

            } else {
                me.removeAll();

                quest = rdmList.get(index);
                setComp();
                me.animateHierarchy(0);
            }
        });

        if (index == 0) {
            previous.setEnabled(false);
        }
        if (index == 10) {
            next.setEnabled(false);
        }
        if (index > 0) {
            previous.setEnabled(true);
        }
        if (index < 10) {
            next.setEnabled(true);
        }

        controle.add(previous);
        controle.add(getImg(serverImages + quest.getQ().getMedia().getImageName()));
        controle.add(next);

        this.add(controle);
        question = new TextArea(quest.getQ().getQuestionContent(), 3, 30);
        question.setEditable(false);
        this.add(question);

        reponses = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        reponses.setName("repContainer");
        setReponses();
        //reponses.getStyle().setPadding(C, 5);
        me.add(reponses);
        me.animateLayout(0);

    }

    private void setReponses() {
        int i = 0;
        reponses.removeAll();
        for (Entry<Reponse, Boolean> item : quest.getRep().entrySet()) {
            Button btn = new Button(item.getKey().getReponseContent());
            btn.setName("r" + i);
            btn.setUIID("BtnChoix");
            if (flagFinish) {
                btn.setEnabled(false);
            }

            if (item.getValue() && !flagFinish) {
                btn.setUIID("BtnSelect");
            }

            if (flagFinish) {
                if (item.getKey().isOk()) {
                    btn.setUIID("BtnSucces");
                }

                if (!item.getKey().isOk() && item.getValue()) {
                    btn.setUIID("BtnFail");
                }

            }

            btn.addActionListener((evt) -> {
                Button clic = (Button) evt.getSource();
                int posi = getIndex(clic.getName());
                System.out.println(posi);
                quest.setChoice(posi);
                setReponses();
                me.animateLayout(0);

            });
            i++;
            reponses.add(btn);

        }

    }

    private int getIndex(String str) {
        String temp = str.charAt(1) + "";
        return Integer.parseInt(temp);
    }

    public URLImage getImg(String s) {
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(180, 150, 0xffff0000), true);
        URLImage background = URLImage.createToStorage(placeholder, s,
                s);
        background.fetch();

        return background;
    }

    public void finshControle() {

        me.removeComponent(controle);

        me.removeAll();

        controle.removeAll();
        controle.setLayout(new GridLayout(3,3));
        controle.add(new Container());
          controle.add(new Container());
            controle.add(new Container());

        controle.add(previous);

        if (flagFinish) {
            controle.removeComponent(rejouer);
            controle.removeComponent(validate);
            controle.add(rejouer);
        } else {
            controle.removeComponent(rejouer);
            controle.removeComponent(validate);
            controle.add(validate);
        }
        

        
        controle.add(next);
         controle.add(new Container());
          controle.add(new Container());
            controle.add(new Container());
     
        me.add(controle);
        me.animateHierarchy(0);

    }

    public void initGame() {
        index = 0;
        flagFinish=false;
        QuizController qc = new QuizController();
        rdmList = qc.getRdmListQuiz();
        setComp();
        
    }

    public QuestionTmpContainer(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setName("QuestionTmpContainer");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
