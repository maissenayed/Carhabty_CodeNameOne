/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Media;
import Entity.Question;
import Entity.QuizAdapter;
import Entity.Reponse;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import utils.LienWebService;
import utils.Session;

/**
 *
 * @author azgar
 */
public class QuizService {

    private  String urlRdmList ;
    private  String urlSaveQuiz ;
    private String urlGetCorrect;
    private String urlGetByType;
    private String urlGetLineChart;
    
    
    public QuizService(){
    
        urlRdmList=LienWebService.URL_RANDOM_QUIZ;
        urlSaveQuiz=LienWebService.URL_SAVE_QUIZ;
        urlGetCorrect=LienWebService.URL_GETCORRECT;
        urlGetByType=LienWebService.URL_BYTYPE;
        urlGetLineChart=LienWebService.URL_GET_LINECHART;
    }

    public List<QuizAdapter> getRdmFromWeb() {

        List<QuizAdapter> lst = new ArrayList<QuizAdapter>();

        Map<String, Object> result = new LinkedHashMap<String, Object>();
        try {

            ConnectionRequest req = new ConnectionRequest();
            ;
            req.setUrl(urlRdmList);
            req.setPost(false);

            NetworkManager.getInstance().addToQueueAndWait(req);
            result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
        } catch (IOException e) {
        }

        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) result.get("Quiz");

        for (Map<String, Object> obj : content) {

            Question q = parseQuestion((Map<String, Object>) obj.get("question"));
            QuizAdapter tmp = new QuizAdapter(q);
            List<Reponse> reps = new ArrayList<Reponse>();

            for (Object item : (List<Object>) obj.get("reponse")) {
                reps.add(parseReponse((Map<String, Object>) item));
            }
            tmp.setReps(reps);
            lst.add(tmp);

        }

        return lst;
    }

    private Question parseQuestion(Map<String, Object> map) {
        Question q = new Question();
        q.setId(((Double) map.get("id")).intValue());
        q.setMedia(parseMedia((Map<String, Object>) map.get("media")));
        q.setQuestionContent((String) map.get("question_content"));
        q.setExplanation((String) map.get("explanation"));
        q.setQuestionCategory((String) map.get("question_category"));

        return q;
    }

    private Media parseMedia(Map<String, Object> map) {

        Media m = new Media();
        m.setId(((Double) map.get("id")).intValue());
        m.setImageName((String) map.get("image_name"));
        m.setTypeMedia((String) map.get("type_media"));

        return m;
    }

    private Reponse parseReponse(Map<String, Object> map) {

        Reponse rep = new Reponse();
        rep.setId(((Double) map.get("id")).intValue());
        if (((String) map.get("ok")).equals("false")) {
            rep.setOk(false);
        } else {
            rep.setOk(true);
        }

        rep.setReponseContent((String) map.get("reponse_content"));

        return rep;
    }

    public boolean postQuiz(List<Reponse> lst) {
        Map<String, Object> result = new LinkedHashMap<String, Object>();



       

            ConnectionRequest req = new ConnectionRequest();
            req.setUrl(urlSaveQuiz);
            req.setPost(true);

            req.addArgument("data",serialiseArrayReponse(lst));
            req.addArgument("user", Session.getUser().getId()+"");

            NetworkManager.getInstance().addToQueueAndWait(req);
            //result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
           // System.out.println(result);

      
      
       System.out.println(serialiseArrayReponse(lst));
        return true;
    }
    
    
    
    private String serializeReponse(Reponse r)
    {
        String str="";
        str="{"+attributSer("id")+r.getId()+",";
        str+=attributSer("reponseContent")+r.getReponseContent()+",";
        if(r.isOk())
        str+=attributSer("ok")+1+",";
        else
        str+=attributSer("ok")+0+",";
        if(r.getTypeReponse())
        str+=attributSer("typeReponse")+1+",";
        else
        str+=attributSer("typeReponse")+0+",";
        str+=attributSer("quizNumber")+r.getQuizNumber()+",";
        str+=attributSer("question")+r.getQuestion().getId()+",";
        str+=attributSer("user")+r.getUser().getId()+"}";
        
        
        return str;
        
    }
    
    
    private String serialiseArrayReponse(List<Reponse> lst)
    {
            String str="[";
            for(Reponse item:lst)
            {str+=serializeReponse(item)+",";}
                if (str != null && str.length() > 0 && str.charAt(str.length()-1)==',') {
                 str = str.substring(0, str.length()-1);
                 
                 str+="]";
    }
    return str;
    }
    
    
    
    
    public String attributSer(String attr)
    {
       return "\""+attr+"\":";
    }
    
    
    
    public Map<String,Integer> getCorrectByTypeAction()
    { Map<String,Integer> stat=new LinkedHashMap<String,Integer>();
    
     Map<String, Object> result = new LinkedHashMap<String, Object>();
        try {

            ConnectionRequest req = new ConnectionRequest();
            
            req.setUrl(urlGetCorrect+"?user="+Session.getUser().getId());
            req.setPost(false);

            NetworkManager.getInstance().addToQueueAndWait(req);
            result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
        } catch (IOException e) {
        }

        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) result.get("stat");
        for(Map<String,Object>item:content)
        {
            stat.put(item.get("cat").toString(),Integer.parseInt(item.get("repNumber").toString()));
        }
        
       

    
    return stat;
    }
    
    
    
       public Map<String,Integer> getByTypeAction()
    { Map<String,Integer> stat=new LinkedHashMap<String,Integer>();
    
     Map<String, Object> result = new LinkedHashMap<String, Object>();
        try {

            ConnectionRequest req = new ConnectionRequest();
            
            req.setUrl(urlGetByType+"?user="+Session.getUser().getId());
            req.setPost(false);

            NetworkManager.getInstance().addToQueueAndWait(req);
            result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
        } catch (IOException e) {
        }

        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) result.get("stat");
        for(Map<String,Object>item:content)
        {
            stat.put(item.get("cat").toString(),Integer.parseInt(item.get("repNumber").toString()));
        }
        
       

    
    return stat;
    }
     
        
       public Map<Integer,Integer> getLineChartAction()
    { Map<Integer,Integer> stat=new LinkedHashMap<Integer,Integer>();
    
     Map<String, Object> result = new LinkedHashMap<String, Object>();
        try {

            ConnectionRequest req = new ConnectionRequest();
            
            req.setUrl(urlGetLineChart);
            req.setPost(false);

            NetworkManager.getInstance().addToQueueAndWait(req);
            result = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));

        } catch (UnsupportedEncodingException ex) {
        } catch (IOException e) {
        }

        java.util.List<Map<String, Object>> content = (java.util.List<Map<String, Object>>) result.get("stat");
      
       for(Map<String,Object>item:content)
        {
            stat.put(Integer.parseInt(item.get("nbrCorrect").toString()),((Double)item.get("quizNumber")).intValue());
        }
        
        System.out.println(stat);

    
    return stat;
    }
    
    

}
