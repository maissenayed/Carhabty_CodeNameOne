/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entity.QuizAdapter;
import Entity.Reponse;
import Entity.ScoreQuiz;
import Entity.User;
import Services.QuizService;
import java.util.ArrayList;
import java.util.List;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author azgar
 */
public class QuizController {
    
    
            private Boolean created = false;
             private Database db;
    
    
      
    public List<QuizAdapter> getRdmListQuiz()
    {
        QuizService qs=new QuizService();
        List<QuizAdapter> rdm=qs.getRdmFromWeb();
        return rdm;
    }
    
    
    public int saveAction(List<QuizAdapter> lst)
    {
        int gamesc=0;
        List<Reponse> rlst=new ArrayList<Reponse>();
        for(QuizAdapter e:lst)
        
        {   Reponse tmp=new Reponse();
                    if(e.isCorrect())
                    {gamesc++;}
                    
                    tmp.setOk(e.isCorrect());
                    tmp.setQuestion(e.getQ());
                    tmp.setTypeReponse(false);
                    tmp.setUser(new User());
                    
                    rlst.add(tmp);
                
        }
        
        System.out.println(rlst.toString());
        
        
        QuizService qs=new QuizService();
        qs.postQuiz(rlst);
     
        
    return gamesc;
    }
    
    
    
    public void dataBaseLight()
    {
              created = false;
             
                     created = Database.exists("game");

        try {
              db = Database.openOrCreate("game");
              if (created == false) {
       
                db.execute("create table score(id INTEGER, resul INTEGER, nom TEXT);");
            }

        } catch (IOException ex) {
            System.out.println("Erreur");
        }
    
    }
    
    
    
    
  public List<ScoreQuiz> getScores()
  {
      List<ScoreQuiz> score=new ArrayList<ScoreQuiz>();
      try{
          db = Database.openOrCreate("game");
      }catch(Exception e){}
      
      
      
                      Cursor s;
                try {
                    s = db.executeQuery("Select * from score");
                    while (s.next()) {
                        Row r = s.getRow();
                        System.out.println(r.getString(2));
                        ScoreQuiz sq=new ScoreQuiz( r.getString(2), r.getInteger(1));
                        score.add(sq);
                    }
                  
                } catch (IOException ex) {
                    System.out.println("Erreur");
                }
  Collections.reverse(score);
      return score;
  }
  
  public boolean insertScore(ScoreQuiz tmp)
 {
                       try{
          db = Database.openOrCreate("game");
      }catch(Exception e){}
                       
                       
                     try {
                         System.out.println("try insert");
                    db.execute("insert into score (resul,nom) values ('" +tmp.getScore()+ "','" + tmp.getNom()+ "');");

                } catch (IOException ex) {
                    System.out.println("Erreur");
                }
  return true;}
  
  
  
  
   public Map<String,Integer> getCorrectByType()
   {
       Map<String,Integer> myData;
       QuizService qs=new QuizService();
       myData=qs.getCorrectByTypeAction();
       
       return myData;
   }
   
   
   
      public Map<String,Integer> getByType()
   {
       Map<String,Integer> myData;
       QuizService qs=new QuizService();
       myData=qs.getByTypeAction();
       
       return myData;
   }
      
      
      
   public Map<Integer,Integer> getLineChart()
   {
       Map<Integer,Integer> myData;
       QuizService qs=new QuizService();
       myData=qs.getLineChartAction();
       
       return myData;
   }
    
}
