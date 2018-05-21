package GUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class pnlMap extends JPanel {
	private Image backgroundImage;

	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public pnlMap(String fileName,JTextField x,JTextField y) throws IOException {
	    backgroundImage = ImageIO.read(new File(fileName));
	   this.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   pnlAddCountry.posX.setText(String.valueOf(e.getX()));
			   pnlAddCountry.posY.setText(String.valueOf(e.getY()));
			   pnlAddCountry.btnSave.setEnabled(true);
			   
		   }
	});
	    
	  }
	  
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    // Draw the background image.
	    g.drawImage(backgroundImage, 0, 0, this);
	  }
	}

