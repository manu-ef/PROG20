package es.upm.dit.prog.practica3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class RadarPanel extends JPanel {
	private List<Aeronave> as;
	private List<Line2D> ls; 
	private boolean enPeligro;
	private Image im;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private int x0;
	private int y0;
	
	public RadarPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
		try {
            this.im = ImageIO.read(new File("paracuellos.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		this.x0 = WIDTH / 2;
		this.y0 = HEIGHT / 2;
		this.enPeligro = false;
	}

	public void setAeronaves (List<Aeronave> as) {
		this.as = as;
	}
	
	public void setLineas (List<Line2D> ls) {
		this.ls = ls;
	}
	
	public void setEnPeligro(boolean p) {
		this.enPeligro = p;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH,HEIGHT);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);    
		if (this.im == null) {
			g.setColor(Color.black);
			g.fillRect(0,0, this.getWidth(), this.getHeight());
		} else
			g.drawImage(this.im, 0, 0, null);

		g.setColor(Color.white);
		this.linea(g, -this.getWidth() / 2, 0, this.getWidth() / 2, 0); 
		this.linea(g, 0, -this.getHeight() / 2, 0, this.getHeight() / 2);
		for (int i = 100; i <= 800; i+=100)
			this.circulo(g, 0, 0, i);

		if (this.as != null)
			for (Aeronave a : this.as) {
				this.paintAeronave (g, a, this.enPeligro);
			}
		if (this.ls != null) {
			for (Line2D linea : this.ls) {
				g.setColor(Color.red);
				this.drawArrowLine(g, (int)linea.getX1() ,(int)linea.getY1()
					,(int)linea.getX2(), (int)linea.getY2(), 20, 6);
			}
		}
	}

    public void paintAeronave(Graphics g, Aeronave a, boolean enPeligro) {
    	g.setColor(new Color(10000 * (int) a.getPos().getZ()));
    	this.triangulo(g, a.getPos().getX(), a.getPos().getY(),
    			Math.atan2(a.getVelocidad().getY(), a.getVelocidad().getX()), 10,
    			new BasicStroke(5), enPeligro);
    	this.triangulo(g, a.getPos0().getX(), a.getPos0().getY(),
    			Math.atan2(a.getVelocidad().getY(), a.getVelocidad().getX()), 10,
    			((Graphics2D)g).getStroke(), false);
    	this.texto(g, a.getId() + ",z="+(int)(a.getPos().getZ()), a.getPos().getX(), a.getPos().getY());
    }

    public void triangulo(Graphics g, double xc, double yc, double angle, double r, Stroke s, boolean fill) {
    	Stroke s0 = ((Graphics2D)g).getStroke();
    	((Graphics2D)g).setStroke(s);
    	int[] xs = new int [] {x0+ (int) (xc+(r*Math.cos(angle))),
    			x0+ (int) (xc+(r*Math.cos(angle + (2*Math.PI / 3)))),
    			x0+ (int) (xc+(r*Math.cos(angle + (2*2*Math.PI / 3))))
    	};
    	int[] ys = new int [] {y0 - (int) (yc+(r*Math.sin(angle))),
    			y0 - (int) (yc + (r*Math.sin(angle+(2*Math.PI/3)))),
    			y0 - (int) (yc + (r*Math.sin(angle+(2*2*Math.PI/3))))
    	};
    	if (! fill)
    		g.drawPolygon (xs, ys, 3);
    	else
    		g.fillPolygon (xs, ys, 3);		  
    	((Graphics2D)g).setStroke(s0);
    }

    public void texto(Graphics g, String str, double x, double y) {
    	g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(str,
    		 (int)Math.round(x+this.x0),
    		 (int)Math.round(this.y0-y));
    }

    public void linea(Graphics g, double x1, double y1, double x2, double y2) {
        g.drawLine((int)Math.round(x1+this.x0),
    	       (int)Math.round(this.y0-y1),
    	       (int)Math.round(x2+this.x0),
    	       (int)Math.round(this.y0-y2));
    }
    
    public void circulo(Graphics g, double x, double y, double radio) {
	   	g.drawOval((int)Math.round(x-radio+this.x0),
	       (int)Math.round(this.y0-y-radio),
	       (int)Math.round(2*radio),
	       (int)Math.round(2*radio));
    }
    
    /**
     * Draw an arrow line between two points.
     * @param g the graphics component.
     * @param x1 x-position of first point.
     * @param y1 y-position of first point.
     * @param x2 x-position of second point.
     * @param y2 y-position of second point.
     * @param d  the width of the arrow.
     * @param h  the height of the arrow.
     */
    public void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        x1 = this.x0+x1;
        x2 = this.x0+x2;
        y1 = this.y0-y1;
        y2 = this.y0-y2;
  	    int dx = x2 - x1;
        int dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double xm = D - d;
        double xn = xm;
        double ym = h;
        double yn = -h;
        double sin = dy / D;
        double cos = dx / D;

        double x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }
    
    public void limpia(Graphics g, double x1, double y1, double x2, double y2) {
        g.clearRect((int)Math.round(x1+x0),
    		(int)Math.round(y0-y1),
    		(int)Math.round(x2+x0),
    		(int)Math.round(y0-y2));
    }
}
