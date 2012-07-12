import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class MainFrame extends JFrame{

    public MainFrame() throws HeadlessException, IOException, FontFormatException {

        this.setSize(new Dimension(500, 500));
        this.setLayout(new GridLayout(1, 1));
        Accordion acc = new Accordion();
        acc.addElement(new AccordionElement("1 - Adresse des Stützpunktes"));
        acc.draw();
        this.add(acc);
        this.setVisible(true);
    }
}
