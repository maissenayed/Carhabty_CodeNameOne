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
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.BarChart;
import com.codename1.ui.Form;
import com.codename1.ui.Container;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azgar
 */
public class BarChartCreator extends AbstractDemoChart{

    @Override
    public String getName() {
       
        return "";
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesc() {
        return "";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Form execute() {
               Container c =new Container();
        QuizController qc=new QuizController();
        Map<String,Integer> dataCorrect=qc.getCorrectByType();
         Map<String,Integer> dataAll=qc.getByType();
         
         //**********
             String[] titles = new String[] { "Correct", "Faux" };
             
           List<double[]> myvalues = new ArrayList<double[]>();
           int siz=dataCorrect.values().size();
           double[] tCorrect=new double[siz];
           Integer[] x=new Integer[siz];
           Integer[] tmp=dataCorrect.values().toArray(x);
           for(int i=0;i<tmp.length;i++)
           {tCorrect[i]=(double)tmp[i];}
           
          
           int sizAll=dataAll.values().size();
           double[] tAll=new double[sizAll];
           Integer[] xAll=new Integer[sizAll];
           Integer[] tmpAll=dataAll.values().toArray(xAll);
           for(int i=0;i<tmp.length;i++)
           {tAll[i]=(double)tmpAll[i];}
           
           
           myvalues.add(tCorrect);
           myvalues.add(tAll);
             
   /* List<double[]> values = new ArrayList<double[]>();
    values.add(new double[] { 5230, 7300, 9240, 10540, 7900, 9200, 12030, 11200, 9500, 10500,
        11600, 13500 });
    values.add(new double[] { 14230, 12300, 14240, 15244, 15900, 19200, 22030, 21200, 19500, 15500,
        12600, 14000 });*/
    int[] colors = new int[] {ColorUtil.argb(255,39,174, 96), ColorUtil.argb(255, 230, 126, 34)};
    XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
    renderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
    setChartSettings(renderer, "Monthly sales in the last 2 years", "Month", "Units sold", 0.5,
        12.5, 0, 24000, ColorUtil.GRAY, ColorUtil.LTGRAY);
    renderer.setXLabels(1);
    renderer.setYLabels(10);
    int ddd=0;
    for(String item:dataCorrect.keySet())
    {
    renderer.addXTextLabel(ddd, item);
    ddd+=2;}
 
    int length = renderer.getSeriesRendererCount();
    for (int i = 0; i < length; i++) {
      XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(i);
      seriesRenderer.setDisplayChartValues(true);
    }
        BarChart chart = new BarChart(buildBarDataset(titles, myvalues), renderer,
        BarChart.Type.DEFAULT);
      return wrap("", new ChartComponent(chart));
    }
    
    
    public Container generate()
    {
        Container c =new Container();
        QuizController qc=new QuizController();
        Map<String,Integer> dataCorrect=qc.getCorrectByType();
         Map<String,Integer> dataAll=qc.getByType();
         
         //**********
             String[] titles = new String[] { "Correct", "Faux" };
             
           List<double[]> myvalues = new ArrayList<double[]>();
           int siz=dataCorrect.values().size();
           double[] tCorrect=new double[siz];
           Integer[] x=new Integer[siz];
           Integer[] tmp=dataCorrect.values().toArray(x);
           for(int i=0;i<tmp.length;i++)
           {tCorrect[i]=(double)tmp[i];}
           
          
           int sizAll=dataAll.values().size();
           double[] tAll=new double[sizAll];
           Integer[] xAll=new Integer[sizAll];
           Integer[] tmpAll=dataAll.values().toArray(xAll);
           for(int i=0;i<tmp.length;i++)
           {tAll[i]=(double)tmpAll[i];}
           
           
           myvalues.add(tCorrect);
           myvalues.add(tAll);
             
   /* List<double[]> values = new ArrayList<double[]>();
    values.add(new double[] { 5230, 7300, 9240, 10540, 7900, 9200, 12030, 11200, 9500, 10500,
        11600, 13500 });
    values.add(new double[] { 14230, 12300, 14240, 15244, 15900, 19200, 22030, 21200, 19500, 15500,
        12600, 14000 });*/
    int[] colors = new int[] {ColorUtil.argb(255,39,174, 96), ColorUtil.argb(255, 230, 126, 34)};
    XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
    renderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);
    setChartSettings(renderer, "ByType", "Catégorie", "Nombre réponse", 0.5,
        50, 0,50, ColorUtil.GRAY, ColorUtil.LTGRAY);
    renderer.setXLabels(50);
    renderer.setYLabels(20);
    int ddd=1;
    for(String item:dataCorrect.keySet())
    {
    renderer.addXTextLabel(ddd, item);
    ddd+=2;}
 
    int length = renderer.getSeriesRendererCount();
    for (int i = 0; i < length; i++) {
      XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(i);
      seriesRenderer.setDisplayChartValues(true);
    }
        BarChart chart = new BarChart(buildBarDataset(titles, myvalues), renderer,
        BarChart.Type.DEFAULT);
        c.add(new ChartComponent(chart));
         //**************
    return c;
    }
    
}
