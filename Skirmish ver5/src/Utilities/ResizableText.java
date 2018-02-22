package Utilities;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MainMenu.ParentPanel;

public class ResizableText extends JLabel {

    private static final int SIZE = 100;
    private BufferedImage image;
    private Color color;

    public ResizableText(String string, Color c) {
        super(string);
        color=c;
        image = createImage(string);
    }
    
    public ResizableText() {
    	super("hello");
    }
    
    @Override
    public void setText(String text) {
        image = createImage(text);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth() / 2, image.getHeight() / 2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println(getWidth());
        //g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.drawImage(image, getWidth()*1/12, getHeight()*1/12, getWidth()*5/6, getHeight()*5/6, null);

    }

    private BufferedImage createImage(String label) {
        Font font = new Font("default", Font.BOLD, SIZE);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        TextLayout layout = new TextLayout(label, font, frc);
        Rectangle r = layout.getPixelBounds(null, 0, 0);
        BufferedImage bi;
        if(label.contains("q")||label.contains("y")||label.contains("p")||label.contains("g")){
        	bi= new BufferedImage(
            //r.width+1, r.height+1, BufferedImage.TYPE_INT_ARGB);
        		r.width*4/3, r.height*32/30, BufferedImage.TYPE_INT_ARGB);}
        else{
        	bi= new BufferedImage(
                	r.width*4/3, r.height*4/3, BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D g2d = (Graphics2D) bi.getGraphics();
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(color);
        layout.draw(g2d, 0, -r.y);
        //layout.draw(g2d, r.width-r.width*1/2, (float) (-r.y*1.5));
        g2d.dispose();
        return bi;
    }
    
    public static BufferedImage createImage(String label, Color t, Color b) {
        Font font = new Font("haha", Font.BOLD, SIZE);
        FontRenderContext frc = new FontRenderContext(null, true, true);
        TextLayout layout = new TextLayout(label, font, frc);
        Rectangle r = layout.getPixelBounds(null, 0, 0);
        BufferedImage bi;
        if(label.contains("q")||label.contains("y")||label.contains("p")||label.contains("g")){
        	bi= new BufferedImage(
        		r.width*2, r.height*8/5, BufferedImage.TYPE_INT_ARGB);}
        else{
        	bi= new BufferedImage(
                	r.width*2, r.height*2, BufferedImage.TYPE_INT_ARGB);
        }
        Graphics2D g2d = (Graphics2D) bi.getGraphics();
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(b);
        g2d.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g2d.setComposite(AlphaComposite.Src);
        g2d.setColor(t);
        //layout.draw(g2d, r.width-r.width*7/8, -r.y*8/7);
        layout.draw(g2d, r.width-r.width*1/2, (float) (-r.y*1.5));
        //System.out.println(-r.y);
        g2d.dispose();
        return bi;
    }
    
    public static void main(String[] args){
    	JFrame f = new JFrame();
    	f.setTitle("title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ResizableText t = new ResizableText("abq",Color.black);
		f.getContentPane().add(t);
		f.getContentPane().setBackground(Color.white);
		f.setSize(300, 300);
		f.setVisible(true);
    }
}

