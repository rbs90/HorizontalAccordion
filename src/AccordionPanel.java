import javax.swing.*;
import java.awt.*;

/**
 * User: rbs
 * Date: 13.07.12
 */
public class AccordionPanel extends JPanel{

    public AccordionPanel() {
        this.setSize(new Dimension(500, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if ( !isOpaque( ) ) {

            super.paintComponent( g );
            return;

        }

        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint( 0, 0, Color.LIGHT_GRAY, w, h, Color.GRAY );

        g2d.setPaint( gp );
        g2d.fillRect( 0, 0, w, h );

        setOpaque( false );
        super.paintComponent( g );
        setOpaque( true );

        paintComponents(g);
    }
}
