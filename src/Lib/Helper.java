package Lib;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.KeyListener;

public class Helper {
	public static void setShortcutListener(JFrame frame,KeyListener k) {
	    List<Component> comp_list = Helper.getAllComponents(frame);
	    for (Component component : comp_list) {
	        component.addKeyListener(k);
	    }
	}
	public static List<Component> getAllComponents(final Container c) {
	    Component[] comps = c.getComponents();
	    List<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);
	        if (comp instanceof Container) {
	            compList.addAll(getAllComponents((Container) comp));
	        }
	    }
	    return compList;
	}
	
	public static double distance2D(MapPoint mp1,MapPoint mp2)
	{
		double y =mp2.getY() - mp1.getY();
		double x =mp2.getX() - mp1.getX();
		
		return Math.sqrt(x*x+y*y);
	}
	public static float getAngle(MapPoint mp1, MapPoint mp2) {

        double theta = Math.atan2(
                mp2.getY() - mp1.getY(), mp2.getX() - mp1.getX());
        return (float) theta;
    }
	
	public static void clearTextFields(Component[] x)
    {

        for (Component c : x)
        {
            if (c instanceof JTextField)
            {
                JTextField j = (JTextField)c;
                j.setText("");
            }
        }
    }
}
