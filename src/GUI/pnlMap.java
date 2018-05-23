package GUI;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lib.*;

public class pnlMap extends JPanel {
	Center CNTR;
	private BufferedImage backgroundImage;
	private BufferedImage planeIm;

	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public pnlMap(String fileName,JTextField x,JTextField y, Center c) throws IOException {
		  this.CNTR = c;
	    backgroundImage = ImageIO.read(new File(fileName));
	    planeIm = ImageIO.read(new File("plane.png"));
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
	    drawCities(g);
	  }
	  
	  public void drawCities(Graphics g)
	  {
		  for(City c : CNTR.getCities())
		  {
			  g.drawOval((int)c.getMp().getX()+3,(int)c.getMp().getY()+3,10,10);
			  g.drawString(c.getName(), (int)c.getMp().getX(), (int)c.getMp().getY());
			  drawPlane(g, c.getMp(), 0);
	
		  }
	  }
	  
	  public void drawImage(Graphics g,BufferedImage im,MapPoint mp,float rotation,float height,float width)
	  {
		  double rotationRequired = Math.toRadians (rotation);
		  double locationX = im.getWidth() / 2;
		  double locationY = im.getHeight() / 2;
		  AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		  // Drawing the rotated image at the required drawing locations
		  g.drawImage(op.filter(im, null), (int)mp.getX(), (int)mp.getY(), null);
	  }
	  
	  public void drawPlane(Graphics g,MapPoint mp,float rotation)
	  {
		  
		  drawImage(g, planeIm, new MapPoint(mp.getX()-16, mp.getY()-16), rotation, 32, 32);
	  }
	}

