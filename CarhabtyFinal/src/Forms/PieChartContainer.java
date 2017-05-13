/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;


import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import com.codename1.ui.layouts.BorderLayout;
import java.util.Map;

/**
 * GUI builder created Container
 *
 * @author azgar
 */
public class PieChartContainer extends com.codename1.ui.Container {
    
    
    
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
    DefaultRenderer renderer = new DefaultRenderer();
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[]{20, 30, 15, 0});
    for (int color : colors) {
        SimpleSeriesRenderer r = new SimpleSeriesRenderer();
        r.setColor(color);
        renderer.addSeriesRenderer(r);
    }
    return renderer;
}
    
    
    
    protected CategorySeries buildCategoryDataset(Map<String,Integer> data) {
    CategorySeries series = new CategorySeries("");
    
    for(Map.Entry<String,Integer> item:data.entrySet())
    {series.add(item.getKey(), item.getValue());}
   /* int k = 0;
    for (double value : values) {
        series.add("Project " + ++k, value);
    }
*/
    return series;
}
    
    
    private ChartComponent CreatePie(Map<String,Integer> data)
    {
 
    int[] colors = new int[]{ColorUtil.argb(255,39,174, 96), ColorUtil.argb(255, 230, 126, 34), ColorUtil.argb(255, 52, 152, 219), ColorUtil.YELLOW, ColorUtil.CYAN};
    DefaultRenderer renderer = buildCategoryRenderer(colors);
    renderer.setZoomButtonsVisible(true);
    renderer.setZoomEnabled(true);
    renderer.setChartTitleTextSize(20);
    renderer.setDisplayValues(true);
    renderer.setShowLabels(true);
  /*  SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setGradientEnabled(true);
    r.setGradientStart(0, ColorUtil.BLUE);
    r.setGradientStop(0, ColorUtil.GREEN);
    r.setHighlighted(true);*/

    // Create the chart ... pass the values and renderer to the chart object.
    PieChart chart = new PieChart(buildCategoryDataset(data), renderer);

    // Wrap the chart in a Component so we can add it to a form
    ChartComponent c = new ChartComponent(chart);
    return c;
    }
    
    
    
    

    public PieChartContainer(Map<String,Integer> data) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER,CreatePie(data));
        
    }
    
    public PieChartContainer(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.FlowLayout());
        setName("PieChartContainer");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
