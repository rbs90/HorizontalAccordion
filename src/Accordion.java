import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class Accordion extends JPanel {

    ArrayList<AccordionElement> elements = new ArrayList<AccordionElement>();

    public Accordion() {
        this.setLayout(new GridLayout(1,1));
    }

    public void addElement(AccordionElement elem){
        elements.add(elem);
    }

    public void draw(){
        for(AccordionElement elem : elements)
            this.add(elem);
    }
}
