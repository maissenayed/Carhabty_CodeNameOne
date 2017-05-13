/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Controllers.QuizController;
import com.codename1.charts.ChartComponent;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.PointStyle;
import com.codename1.charts.views.TimeChart;
import com.codename1.ui.Component;
import com.codename1.ui.Form;
import java.util.ArrayList;
import java.util.List;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Display;
import java.util.Map;

/**
 * GUI builder created Container
 *
 * @author azgar
 */
public class ProgressionContainer extends com.codename1.ui.Container {

    public ProgressionContainer() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
            QuizController qc = new QuizController();
            Map<Integer, Integer> data = qc.getLineChart();
            List<Integer[]> values=new ArrayList<Integer[]>();
            
            
            for(Map.Entry<Integer,Integer> item:data.entrySet())
            {}
            
    }
    
    public ProgressionContainer(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setName("ProgressionContainer");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
