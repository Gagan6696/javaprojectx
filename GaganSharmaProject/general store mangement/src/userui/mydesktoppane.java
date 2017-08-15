/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userui;



import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author user
 */
public class mydesktoppane extends JDesktopPane {
      private Image backimage;

    public mydesktoppane(){
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/userui/2.jpg"));
            backimage = icon.getImage();
        } catch (Exception ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (backimage == null) {
            super.paintComponent(g);
        } else {
            g.drawImage(backimage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    
}
