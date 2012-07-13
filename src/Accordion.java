import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class Accordion extends JPanel {

    ArrayList<AccordionElement> elements = new ArrayList<AccordionElement>();
    int activeElement = 0;

    public Accordion() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void addElement(AccordionElement elem){
        elements.add(elem);
        elem.setID(elements.size());
        if(elements.size() != 1)
            elem.setExpanded(false);
        else
            elem.setExpanded(true);
    }

    public void draw(){
        for(AccordionElement elem : elements)
            this.add(elem);
    }

    public void jumpToElement(int elem){
        elements.get(activeElement).setExpanded(false);
        activeElement = elem;
        elements.get(activeElement).setExpanded(true);
    }

    public AccordionElement getElement(int index) {
        return elements.get(index);
    }
}
