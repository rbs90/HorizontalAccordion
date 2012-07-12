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

    public TitlePane(String text) {
        this.setText(text);
        this.setBackground(Color.GREEN);
        setOpaque(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();

        Color color1 = getBackground();
        Color color2 = color1.brighter();

        GradientPaint gp = new GradientPaint( 0, 0, Color.ORANGE, w, 0, Color.RED);

        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );

        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.PI/2.0);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("planer.otf")).deriveFont(40f);
            g2d.setFont(font);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.setColor(Color.BLACK);
        g2d.setTransform(at);
        g2d.drawString(getText(), 0, 0);
    }
}
