package Lib;

import java.io.Serializable;

public class MapPoint implements Serializable
{

	private static final long serialVersionUID = 1L;
	private float x;
	private float y;
	
	public MapPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public MapPoint(float f, float g) {
		x=f;
		y=g;
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	
}
