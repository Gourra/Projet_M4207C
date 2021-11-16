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
        graphics.drawLine(0, (int)(getHeight()*0.6875), getWidth(), (int)(getHeight()*0.6875)); // axe x
        graphics.drawLine((int)(getWidth()*0.177), 0, (int)(getWidth()*0.177), getHeight()); // axe y

        // --- DRAW VALUES X --- 
        graphics.setColor( Color.BLACK );
        graphics.drawString("0", (int)(getWidth()*0.16), (int)(getHeight()*0.71)); // origine
        graphics.drawString("10", (int)(getWidth()*2*0.177), (int)(getHeight()*0.71)); // sur axe x
        graphics.drawLine((int)(getWidth()*2*0.177), (int)(getHeight()*0.6775), (int)(getWidth()*2*0.177), (int)(getHeight()*0.6975));

        graphics.drawString("20", (int)(getWidth()*3*0.177), (int)(getHeight()*0.71)); // sur axe x
        graphics.drawLine((int)(getWidth()*3*0.177), (int)(getHeight()*0.6775), (int)(getWidth()*3*0.177), (int)(getHeight()*0.6975));
        
        graphics.drawString("30", (int)(getWidth()*4*0.177), (int)(getHeight()*0.71)); // sur axe x
        graphics.drawLine((int)(getWidth()*4*0.177), (int)(getHeight()*0.6775), (int)(getWidth()*4*0.177), (int)(getHeight()*0.6975));

        graphics.drawString("40", (int)(getWidth()*5*0.177), (int)(getHeight()*0.71)); // sur axe x
        graphics.drawLine((int)(getWidth()*5*0.177), (int)(getHeight()*0.6775), (int)(getWidth()*5*0.177), (int)(getHeight()*0.6975));

        graphics.drawString("Minutes", (int)(getWidth()*5.338*0.177), (int)(getHeight()*0.71)); // sur axe x


        // --- DRAW VALUES Y ---
        graphics.drawString("-20", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*14.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*15), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*15));

        graphics.drawString("-10", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*12.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*13), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*13));

        graphics.drawString(" 10", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*8.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*9), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*9));

        graphics.drawString(" 20", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*6.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*7), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*7));

        graphics.drawString(" 30", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*4.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*5), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*5));
    
        graphics.drawString(" 40", (int)(getWidth()*0.15), (int)(getHeight()*0.0625*2.95)); // sur axe y
        graphics.drawLine((int)(getWidth()*0.169), (int)(getHeight()*0.0625*3), (int)(getWidth()*0.185), (int)(getHeight()*0.0625*3));

        
        graphics.drawString("Valeurs", (int)(getWidth()*0.045), (int)(getHeight()*0.169));


        // --- Draw the Curve --- 
        
        principal princi = new principal();
        
        //int taille_max = recup.taille1();

        


        /*for (int i = 0; i < princi.taille1(); i++) {
            cap_x.add(princi.getList1x(i));
            cap_y.add(princi.getList1y(i));
        }*/
        //cap1.add(liste1);
        cap_x.add(1);
        cap_y.add(10);
        cap_x.add(5);
        cap_y.add(-5);
        cap_x.add(10);
        cap_y.add(30);
        cap_x.add(15);
        cap_y.add(-20);
        cap_x.add(20);
        cap_y.add(30);
        cap_x.add(21);
        cap_y.add(30);
        cap_x.add(22);
        cap_y.add(30);
        cap_x.add(23);
        cap_y.add(10);

        int oldX = (int)(getWidth()*0.177);
        int oldY = (int)(getHeight()*0.6875);

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
        //this.repaint();
    }

    private int xToPixel ( double x ) {  // Fonction transformation coordonnées pour bonne apparition graphique
        return (int)( ((x / 10) + 1) * getWidth() * 0.177 );// On reflechie un peu en inverse dans la verticale

    }

    private int yToPixel ( double y ) {  // Fonction transformation coordonnées pour bonne apparition graphique
        return (int)( getHeight() * 0.0625 * ( 11 - ( 2*y / 10 ) ) );
    }
    
    public static interface CurveFunction {
        public double compute ( double x );
    }
}
