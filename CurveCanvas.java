import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurveCanvas extends JComponent{
    ArrayList<Integer> cap_x = new ArrayList<Integer>();
    ArrayList<Integer> cap_y = new ArrayList<Integer>();

    

    //private CurveFunction function = ( x ) -> cap1.base();;

    protected void paintComponent(Graphics graphics) {
        // TODO Auto-generated method stub
        super.paintComponent(graphics);

        // --- WHITE BACKGROUND ---
        graphics.setColor( Color.WHITE );
        graphics.fillRect(0, 0, getWidth(), getHeight());
        // --- DRAW AXIS ---
        graphics.setColor( Color.GRAY );
        graphics.drawLine(0, (int)(getHeight()*0.97), getWidth(), (int)(getHeight()*0.97)); // axe x
        graphics.drawLine((int)(getWidth()*0.105), 0, (int)(getWidth()*0.105), getHeight()); // axe y

        // --- DRAW VALUES X --- 
        graphics.setColor( Color.BLACK );
        graphics.drawString("0", (int)(getWidth()*0.09), (int)(getHeight()*0.99)); // origine
        graphics.drawString("10", (int)(getWidth()*2*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*2*0.105), (int)(getHeight()*0.96), (int)(getWidth()*2*0.105), (int)(getHeight()*0.98));

        graphics.drawString("20", (int)(getWidth()*3*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*3*0.105), (int)(getHeight()*0.96), (int)(getWidth()*3*0.105), (int)(getHeight()*0.98));
        
        graphics.drawString("30", (int)(getWidth()*4*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*4*0.105), (int)(getHeight()*0.96), (int)(getWidth()*4*0.105), (int)(getHeight()*0.98));

        graphics.drawString("40", (int)(getWidth()*5*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*5*0.105), (int)(getHeight()*0.96), (int)(getWidth()*5*0.105), (int)(getHeight()*0.98));

        graphics.drawString("50", (int)(getWidth()*6*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*6*0.105), (int)(getHeight()*0.96), (int)(getWidth()*6*0.105), (int)(getHeight()*0.98));

        graphics.drawString("60", (int)(getWidth()*7*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*7*0.105), (int)(getHeight()*0.96), (int)(getWidth()*7*0.105), (int)(getHeight()*0.98));

        graphics.drawString("70", (int)(getWidth()*8*0.105), (int)(getHeight()*0.99)); // sur axe x
        graphics.drawLine((int)(getWidth()*8*0.105), (int)(getHeight()*0.96), (int)(getWidth()*8*0.105), (int)(getHeight()*0.98));

        graphics.drawString("Minutes", (int)(getWidth()*8.5*0.105), (int)(getHeight()*0.99)); // sur axe x


        // --- DRAW VALUES Y ---
        graphics.drawString("10", (int)(getWidth()*0.085), (int)(getHeight()*0.097*8.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*9), (int)(getWidth()*0.113), (int)(getHeight()*0.097*9));

        graphics.drawString("20", (int)(getWidth()*0.085), (int)(getHeight()*0.097*7.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*8), (int)(getWidth()*0.113), (int)(getHeight()*0.097*8));

        graphics.drawString("30", (int)(getWidth()*0.085), (int)(getHeight()*0.097*6.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*7), (int)(getWidth()*0.113), (int)(getHeight()*0.097*7));

        graphics.drawString("40", (int)(getWidth()*0.085), (int)(getHeight()*0.097*5.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*6), (int)(getWidth()*0.113), (int)(getHeight()*0.097*6));

        graphics.drawString("50", (int)(getWidth()*0.085), (int)(getHeight()*0.097*4.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*5), (int)(getWidth()*0.113), (int)(getHeight()*0.097*5));

        graphics.drawString("60", (int)(getWidth()*0.085), (int)(getHeight()*0.097*3.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*4), (int)(getWidth()*0.113), (int)(getHeight()*0.097*4));

        graphics.drawString("70", (int)(getWidth()*0.085), (int)(getHeight()*0.097*2.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*3), (int)(getWidth()*0.113), (int)(getHeight()*0.097*3));
    
        graphics.drawString("80", (int)(getWidth()*0.085), (int)(getHeight()*0.097*1.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.097), (int)(getHeight()*0.097*2), (int)(getWidth()*0.113), (int)(getHeight()*0.097*2));

        graphics.drawString("Valeurs", (int)(getWidth()*0.045), (int)(getHeight()*0.097));


        // --- Draw the Curve --- 
        
        principal princi = new principal();
        
        //int taille_max = recup.taille1();

        
        for (int i = 0; i < princi.taille1(); i++) {
            cap_x.add(princi.getList1x(i));
            cap_y.add(princi.getList1y(i));
        }

        int oldX = (int)(getWidth()*0.105);
        int oldY = (int)(getHeight()*0.97);

        for (int i = 0 ; i < cap_y.size() ; i++) {
            
            double ix = cap_x.get(i);
            double iy = cap_y.get(i);

            int x = xToPixel ( ix );
            int y = yToPixel ( iy ); 

            graphics.drawLine(x, y, oldX, oldY);

            oldX = x;
            oldY = y;
        }

    }

    public void setFunction (CurveFunction function){ // retracer courbe (changement capteur)
        //this.function = function;
        this.repaint();
    }

    private int xToPixel ( double x ) {  // Fonction transformation coordonnées pour bonne apparition graphique
        return (int)( ((x / 10) + 1) * getWidth() * 0.105 );// On reflechie un peu en inverse dans la verticale

    }

    private int yToPixel ( double y ) {  // Fonction transformation coordonnées pour bonne apparition graphique
        return (int)( getHeight() * 0.097 * ( 10 - ( y / 10 ) ) );
    }
    
    public static interface CurveFunction {
        public double compute ( double x );
    }
}
