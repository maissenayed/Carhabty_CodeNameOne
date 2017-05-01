/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.codename1.io.Storage;
import com.codename1.media.MediaManager;
import com.codename1.media.Media;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author azgar
 */
public class MusicGame {
    
    
    private static MusicGame instance=new MusicGame();
    private Timer timer;
    private Media music;
    
    
    private MusicGame()
    {}
    
    public static MusicGame getInstance()
    {
        return instance;
    }
    
    public void play()
    {
         timer = new Timer();

        timer.schedule( new TimerTask() {
        public void run() {
        try {
            InputStream ms =com.codename1.ui.util.Resources.getGlobalResources().getData("Cheerful-marimba-music-melody-loop.mp3");
            music = MediaManager.createMedia(ms, "mp3"); 
            music.setVolume((int)Storage.getInstance().readObject("volume"));
            music.play();
       
        } catch (IOException ex) {

        }
    }
 }, 0, 62*1000);
        
    }
    
    
    public void stop()
    {
    if(music!=null)    
    if(music.isPlaying())    
    {music.cleanup();
    timer.cancel();}
    }
    
    
    public void setVolume(int v)
    {music.setVolume(v);}
}
