package Utilities;
import java.awt.Dimension;

public class AspectRatio {
	private int W;
	private int H;
	
	public AspectRatio(int W, int H) {
		this.W = W;
		this.H = H;
	}
	
	private int resizeHeight(int width) {
		return width*H/W;
	}
	
	private int resizeWidth(int height) {
		return height*W/H;
	}
	
	public Dimension resize(int width, int height) {
		int rH = resizeHeight(width);
		int rW = resizeWidth(height);
		Dimension result = null;
		if (W == H) {
			if (width < height)
				result = new Dimension(width, width);
			else 
				result = new Dimension(height, height);
		} else if (W > H) {
			if (rH <= height) {
				result = new Dimension(width, rH);
			} else {
				result = new Dimension(rW, height);
			}
		}
		
		return result;
	}

}