import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class AccordionElement extends JPanel{

    String title;
    int percentage;
    private final JLabel content;

    public AccordionElement(String title) throws IOException, FontFormatException {
        this.title = title;
        this.setLayout(new BorderLayout());
        TitlePane comp = new TitlePane(title);
        comp.setMaximumSize(new Dimension(30, 500));
        comp.setPreferredSize(new Dimension(30, 500));
        this.add(comp, BorderLayout.WEST);
        content = new JLabel();
        content.setText("Hallo123");
        Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("masterplan.ttf")).deriveFont(24f);
        content.setOpaque(true);
        content.setForeground(Color.WHITE);
        content.setFont(font);
        content.setBackground(Color.BLACK);
        this.add(content, BorderLayout.CENTER);
    }

    public void setExpanded(Boolean expanded){
        if(expanded){
            content.setVisible(true);
        }
        else {
            content.setVisible(false);
        }

    }
}
