import javax.swing.JPanel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class AccordionElement extends JPanel{

    String title;
    private AccordionPanel content;
    Boolean expanded;
    int percentage;
    private int id;
    private final TitlePane titlePane;

    public AccordionElement(String title, AccordionPanel content) throws IOException, FontFormatException {
        this.title = title;
        this.content = content;
        this.setLayout(new BorderLayout());
        titlePane = new TitlePane(title, this);
        titlePane.setMaximumSize(new Dimension(30, 500));
        titlePane.setPreferredSize(new Dimension(30, 500));
        this.add(titlePane, BorderLayout.WEST);
        this.add(content, BorderLayout.CENTER);
    }

    public void setExpanded(Boolean expanded){
        TimerTask expandTask = new TimerTask(){

            @Override
            public void run() {
                double act_width = getWidth();
                System.out.println("expand thread of " + id + " with width " + act_width);
                Dimension maximumSize = new Dimension(getWidth() + 1, 500);
                if(act_width == 499) {
                    System.out.println("finished expand of " + id);
                    cancel();
                }

                setSize(maximumSize);

                double act_width_title = titlePane.getMaximumSize().getHeight();
                Dimension maximumSizeTitle = new Dimension(getWidth() + 1, 500);
                if(maximumSizeTitle.getWidth() < 50){
                    titlePane.setMaximumSize(maximumSizeTitle);
                    titlePane.setPreferredSize(maximumSizeTitle);
                }
            }
        };

        TimerTask collapseTask = new TimerTask(){

            @Override
            public void run() {
                double act_width = getSize().getWidth();
                System.out.println("collaps thread of " + id + " with width " + act_width);
                Dimension maximumSize = new Dimension(getWidth() - 1, 500);
                if(act_width <= 31){
                    System.out.println("finished collapse of " + id);
                    cancel();
                }

                setSize(maximumSize);
                setPreferredSize(maximumSize);

                double act_width_title = getMaximumSize().getHeight();
                Dimension maximumSizeTitle = new Dimension(getWidth() - 1, 500);
                if(maximumSizeTitle.getWidth() > 31){
                    titlePane.setMaximumSize(maximumSizeTitle);
                    titlePane.setPreferredSize(maximumSizeTitle);
                }
            }
        };

        this.expanded = expanded;
        if(expanded){
            this.add(content);
            new Timer().schedule(expandTask, 0, 100);
            System.out.println("started expanding");
        }
        else {
            this.remove(content);
            new Timer().schedule(collapseTask, 0, 100);
            System.out.println("started collapsing");
        }

    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
        titlePane.repaint();
    }

    public Boolean isExpanded() {
        return expanded;
    }
}
