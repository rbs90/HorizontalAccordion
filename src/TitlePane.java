import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * User: rbs
 * Date: 12.07.12
 */
public class TitlePane extends JLabel {

    private AccordionElement parent;

    public TitlePane(String text, AccordionElement parent) {
        this.parent = parent;
        this.setText(text);
        this.setBackground(Color.GREEN);
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint( 0, 0, Color.BLACK, w, h, new Color(100 - parent.getPercentage(), parent.getPercentage(), 0));

        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );

        g2d.setColor(Color.BLACK);

        g2d.fillRect(0, 0, 4, h);
        if(!parent.isExpanded())
            g2d.fillRect(w-4, 0, w, h);

        AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(270));

        AffineTransform at2 = null;
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("roboto.ttf"));
            if(parent.expanded) {
                at2 = AffineTransform.getTranslateInstance(36, h - 25);
                font = font.deriveFont(30f);
            }
            else {
                at2 = AffineTransform.getTranslateInstance(23, h - 20);
                font = font.deriveFont(20f);
            }

            g2d.setFont(font);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.transform(at2);
        g2d.transform(at);
        g2d.drawString(getText(), 0, 0);
    }
}
