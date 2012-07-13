import javax.swing.JFrame;
import java.awt.*;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException, IOException, FontFormatException {

        this.setSize(new Dimension(500, 500));
        this.setLayout(new GridLayout(1, 1));
        final Accordion acc = new Accordion();
        acc.addElement(new AccordionElement("1 - Adresse des Stützpunktes", new AccordionPanel()));
        acc.addElement(new AccordionElement("2 - Orte in der Umgebung", new AccordionPanel()));
        acc.addElement(new AccordionElement("3 - Ermitteln des Straßennetzes", new AccordionPanel()));
        acc.addElement(new AccordionElement("4 - Ermitteln von Gebäuden", new AccordionPanel()));

        acc.jumpToElement(2);
        acc.getElement(1).setPercentage(100);
        acc.getElement(2).setPercentage(70);

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                int perc = acc.getElement(0).getPercentage();
                if(perc == 99) //because last run continues
                    cancel();
                acc.getElement(0).setPercentage(perc + 1);
            }
        };

        new Timer().schedule(timerTask, 4000, 100);

        acc.draw();
        this.add(acc);
        this.setVisible(true);
    }
}
