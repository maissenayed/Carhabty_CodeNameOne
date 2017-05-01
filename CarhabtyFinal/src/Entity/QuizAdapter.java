/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Entity.Question;
import Entity.Reponse;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Azgard
 */
public class QuizAdapter {

    private Question q;
    private Map<Reponse, Boolean> rep;

    public QuizAdapter(Question q) {
        this.q = q;
        rep=new LinkedHashMap<Reponse,Boolean>();

  
    }

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }

    public Map<Reponse, Boolean> getRep() {
        return rep;
    }

    public void setRep(Map<Reponse, Boolean> rep) {
        this.rep = rep;
    }

    public void setChoice(int i) {
        int x = 0;
        for (Map.Entry<Reponse, Boolean> tmp : rep.entrySet()) {
           
            if (i == x) {
                tmp.setValue(Boolean.TRUE);
            } else {
                tmp.setValue(Boolean.FALSE);
            }
             x++;
        }
    }

    public boolean choiceIsSet() {

        boolean ok = false;
        Iterator it = rep.entrySet().iterator();

        while (!ok && it.hasNext()) {
            Entry<Reponse, Boolean> thisRep = (Entry) it.next();
            ok = thisRep.getValue();
        }

        return ok;
    }

    public boolean isCorrect() {

        Boolean ok = false;
        Iterator it = rep.entrySet().iterator();

        while (!ok && it.hasNext()) {
            Entry<Reponse, Boolean> thisRep = (Entry) it.next();
            if(thisRep.getKey().isOk()&&thisRep.getValue())
            ok = true;
        }

        return ok;
    }
    
    
    public void setReps(List<Reponse> testReps)
    {
       for(Reponse item:testReps)
       {rep.put(item, Boolean.FALSE);}
           
        System.out.println(rep.size());
       
    }
    


}
