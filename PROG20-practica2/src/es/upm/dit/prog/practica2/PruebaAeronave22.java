package es.upm.dit.prog.practica2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 * @author juancarlosduenaslopez3
 *
 */
public class PruebaAeronave22 {

	// 1s simul = 1s real = 100ms anima
	private static final int TIME_STEP = 1;
	private static final int SIMULATION_SPEED = 100;
	private static final int TIME_SPAN = 100;
	
	// 1px = 1m; circulos 100px = 100m
	// 1px = 10m; circulos 100px = 1000m

	private static final int METERS_PX = 1;
	private static final int N_AES = 10;
	
	private Aeronave[] as;

    public void init() {
    	this.as = new Aeronave[N_AES];
    }
    
    public void step() {
		time = (time + TIME_STEP) % TIME_SPAN;
		f.setTitle ("PruebaAeronave, t = " + time);
		for (Aeronave a: Arrays.asList(as))
			if (a != null) 
				a.mover(time);
		rp.setAeronaves(Arrays.asList(as));
		rp.repaint();    	
    }	
	
	private int time;
	private JFrame f;
	private RadarPanel rp;
	private Timer timer;
	private int lastHeight;
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PruebaAeronave22 pva = new PruebaAeronave22();
                pva.init();
                pva.createAndShowGUI();
            }
        });
    }
    
    private void createAndShowGUI() {
    	this.time = 0;
        System.out.println("Launching PruebaAeronave, t = " + time + " " + 
                SwingUtilities.isEventDispatchThread());
        this.f = new JFrame("PruebaAeronave, t = " + time);
        this.f.setResizable(false);
        this.f.setLayout(new BorderLayout());
        this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    	this.timer = new Timer(SIMULATION_SPEED, new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			step();
    	    }
    	});
    	this.timer.setInitialDelay(100);    	       
        this.rp = new RadarPanel();

        this.f.add(this.rp, BorderLayout.CENTER);

        
        JPanel controles = new JPanel();
    	controles.setLayout(new GridLayout(0,1));
    	this.f.add(controles,BorderLayout.PAGE_END);
    	JPanel controlP1 = new JPanel();
    	controles.add(controlP1, "North");
    	JButton init = new JButton("<<");
    	controlP1.add(init);
    	init.addActionListener(new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			time = 0;
    			timer.start();  
    	    }
    	});
    	JButton start = new JButton(">>");
    	controlP1.add(start);
    	start.addActionListener(new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			timer.start();  
    	    }
    	});
    	JButton stop = new JButton("||");
    	controlP1.add(stop);
    	stop.addActionListener(new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			timer.stop();  
    	    }
    	});
    	JButton step = new JButton(">");
    	controlP1.add(step);
    	step.addActionListener(new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			timer.stop(); 
    			step();
    	    }
    	});
    	
    	JPanel controlP2 = new JPanel();
    	controles.add(controlP2, "Center");
    	JLabel mouseX = new JLabel();
    	mouseX.setText("x= "+",");
    	controlP2.add(mouseX);
       	JLabel mouseY = new JLabel();
    	mouseY.setText("y= "+",");
    	controlP2.add(mouseY);
    	JLabel z = new JLabel();
    	z.setText("z= ");
    	controlP2.add(z);
    	lastHeight = 10000;
    	JFormattedTextField height = new JFormattedTextField(new Integer(lastHeight));
    	controlP2.add(height);
    	height.addActionListener(new ActionListener () {
    		public void actionPerformed(ActionEvent ae) {
    			lastHeight = (int) height.getValue();
    	    }
    	});
    	JLabel msg = new JLabel();
    	msg.setText("Launched...");
    	controlP2.add(msg);
    
        this.rp.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
               	mouseX.setText("x= " + (e.getX() - 400));
            	mouseY.setText("y= " + (300 - e.getY()));
            	Vector pos = new Vector((e.getX() - 400),(300 - e.getY()),lastHeight);
            	for (int i = 0; i < as.length; i++) {
            		if ((as[i] != null) && (as[i].compatibleCon(pos, time))) {
            			as[i].mover(pos, time);
            			return;
            		}
            	}
            	for (int i = 0; i < as.length; i++) {
            		if (as[i] == null) {
            			as[i] = new Aeronave ("AUTO" + i, pos, time, pos, time);
            			return;
            		}
            	}
            }
        });
        
        this.f.pack();
    	this.f.setVisible(true);
    }
}

