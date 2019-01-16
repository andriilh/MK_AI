/*
 * source code copyright under Muhammad Radhial licenses
 *         the 22
 * jaya open source ACEH, jaya JAVA programer ACEH
 *  az_radhial@yahoo.com or radhial22@gmail.com
 */
package ace;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author radhial22
 */
public class panelMenu extends JPanel {
    
    private Image image;
    
    public panelMenu(){
        image=new ImageIcon(getClass().getResource("/pict/formmm.jpg")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D gd=(Graphics2D)g.create();
        
        gd.drawImage(image, 0, 0,getWidth(),getHeight(), null);
        
        
        gd.dispose();
    }
    
    
}
