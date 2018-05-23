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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lib.*;

public class pnlMap extends JPanel implements Runnable {
	Center CNTR;
	private BufferedImage backgroundImage;
	private BufferedImage planeIm;
	private BufferedImage towerIm;
	private JLabel flightlayer = new JLabel() {
		@Override
		public void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			drawFlights(g);
		}
	};

	  // Some code to initialize the background image.
	  // Here, we use the constructor to load the image. This
	  // can vary depending on the use case of the panel.
	  public pnlMap(String fileName,JTextField x,JTextField y, Center c) throws IOException {
		  this.CNTR = c;
	    backgroundImage = ImageIO.read(new File(fileName));
	    planeIm = ImageIO.read(new File("plane.png"));
	    towerIm = ImageIO.read(new File("tower.png"));
	    setLayout(null);
	    flightlayer.setBounds(0,0, 1936, 1013);
	
	    add(flightlayer);
	
	   this.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e) {
			   pnlAddCountry.posX.setText(String.valueOf(e.getX()));
			   pnlAddCountry.posY.setText(String.valueOf(e.getY()));
			   pnlAddCountry.btnSave.setEnabled(true);
			  // flightlayer.getGraphics().drawString("asdasdasdasdasdasdasd", e.getX(), e.getY());
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
			
			 drawImage(g, towerIm, c.getMp().plus(-16, -16), 0, 0, 0);
			 MapPoint m = c.getMp().plus(-16, -16);
			 g.drawString(c.getName(), (int)m.getX(), (int)m.getY());
			  
			//  drawPlane(g, c.getMp(), 0);
	
		  }
		
	  }
	  
	  public void drawImage(Graphics g,BufferedImage im,MapPoint mp,double d,float height,float width)
	  {
		  double rotationRequired = d;
		  double locationX = im.getWidth() / 2;
		  double locationY = im.getHeight() / 2;
		  AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		  AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		  // Drawing the rotated image at the required drawing locations
		  g.drawImage(op.filter(im, null), (int)mp.getX(), (int)mp.getY(), null);
	  }
	  
	  public void drawPlane(Graphics g,MapPoint mp,double d)
	  { 
		  drawImage(g, planeIm, new MapPoint(mp.getX()-16, mp.getY()-16), d, 32, 32);
	  }
	  
	  public void drawFlights(Graphics g)
	  {
		  
		  for(Flight f :CNTR.getFlights())
		  {
			  if(f.getStatus() == FlightStatus.OnAir)
			  {
				  drawPlane(g, f.getLocation(CNTR.getTimeNOW()), f.getRotation());
				  System.out.println(f.getLocation(CNTR.getTimeNOW()).getX() + " - " + f.getLocation(CNTR.getTimeNOW()).getY());
				  System.out.println(f.getRotation());
				  System.out.println(f.getID());
				  MapPoint mp1,mp2;
				  mp1 = f.getArrAirport().getCity().getMp();
				  mp2 = f.getDepAirport().getCity().getMp();
				  g.drawLine((int)mp1.getX(), (int)mp1.getY(), (int)mp2.getX(), (int)mp2.getY());
			  }
				  
		  }
	  }

	@Override
	public void run() {
		while(Center.timeController.Work)
		{
			flightlayer.repaint();
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	}

