package es.upm.dit.prog.practica4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



public class PruebaTorreControl42 { //implements ActionListener {

	// 1s simul = 1s real = 100ms anima
	private static final int TIME_STEP = 1;
	private static final int SIMULATION_SPEED = 100;
	private static final int TIME_SPAN = 100;
	
	// 1px = 1m; circulos 100px = 100m
	// 1px = 10m; circulos 100px = 1000m

	private static final int METERS_PX = 1;
	private static final int N_AES = 10;
	private TorreControl tc;
	
	private boolean selectorTrue;
	private boolean selectorAmenazadas;
	private boolean selectorAmenazas;

    public void init() {
    	this.tc = new TorreControl();
    	this.selectorTrue = true;
    	this.selectorAmenazadas = false;
    	this.selectorAmenazas = false;
    }
    
    public void step() {
		time = (time + TIME_STEP) % TIME_SPAN;
		f.setTitle ("PruebaTorreControl, t = " + time);
		Aeronave[] aes = this.tc.getAeronaves(new SelectorAeronaveTrue());
		for (Aeronave a: aes)
			a.mover(time);
		this.rp.setAeronaves(new ArrayList<Aeronave>());
		this.rp.setLineas(new ArrayList<Line2D>());
		this.rp.setEnPeligro(false);
		
		if (this.selectorTrue)
			this.rp.setAeronaves(Arrays.asList(aes));
		if (this.selectorAmenazadas) {
			this.rp.setEnPeligro(true);
			aes = this.tc.getAeronaves(new SelectorAeronaveAmenazada(aes));
//			List<Line2D> lineas = new ArrayList<Line2D>();
//			for (Aeronave a: aes) {
//				for (Aeronave b: Arrays.asList(this.tc.getAeronaves(new SelectorAeronaveAmenazaA(a))))
//					lineas.add(new Line2D.Double(a.getPos().getX(), a.getPos().getY()
//							, b.getPos().getX(), b.getPos().getY()));
//			}
			this.rp.setAeronaves(Arrays.asList(aes));
//			this.rp.setLineas(lineas);
		}
		if (this.selectorAmenazas) {
			this.rp.setEnPeligro(false);
			aes = this.tc.getAeronaves(new SelectorAeronaveAmenazada(aes));
			List<Aeronave> amenazas = new ArrayList<Aeronave>();
//			List<Line2D> lineas = new ArrayList<Line2D>();
			for (Aeronave a: aes) {
				for (Aeronave b: Arrays.asList(this.tc.getAeronaves(new SelectorAeronaveAmenazaA(a)))) {
					amenazas.add(b);
//					lineas.add(new Line2D.Double(a.getPos().getX(), a.getPos().getY()
//							, b.getPos().getX(), b.getPos().getY()));
				}
			}
//			this.rp.setLineas(lineas);
			this.rp.setAeronaves(amenazas);			
		}
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
                PruebaTorreControl42 pva = new PruebaTorreControl42();
                pva.init();
                pva.createAndShowGUI();
            }
        });
    }
    
    private void createAndShowGUI() {
    	this.time = 0;
        System.out.println("Launching PruebaTorreControl, t = " + time + " " + 
                SwingUtilities.isEventDispatchThread());
        this.f = new JFrame("PruebaTorreControl, t = " + time);
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
        
    	this.rp.setAeronaves(Arrays.asList(this.tc.getAeronaves(new SelectorAeronaveTrue())));

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
                tc.addDeteccion( new Vector((e.getX() - 400),(300 - e.getY()),lastHeight), time);
            }
        });

       	JPanel controlP4 = new JPanel();
    	controles.add(controlP4, "South");
    	controlP4.setLayout(new GridLayout(0,1));
 
    	JRadioButton b1 = new JRadioButton("SelectorTrue");
        b1.setSelected(true);
        b1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectorTrue = (e.getStateChange() == ItemEvent.SELECTED);
				msg.setText("SelectorTrue= " + (selectorTrue ? "true" : "false"));
			}
        });
        JRadioButton b2 = new JRadioButton("SelectorAmenazadas");
        b2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectorAmenazadas = (e.getStateChange() == ItemEvent.SELECTED);
				msg.setText("SelectorAmenazadas= " + (selectorAmenazadas ? "true" : "false"));
			}
        });
        JRadioButton b3 = new JRadioButton("selectorAmenazas");
        b3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				selectorAmenazas = (e.getStateChange() == ItemEvent.SELECTED);
				msg.setText("selectorAmenazas= " + (selectorAmenazas ? "true" : "false"));

			}
        });    
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        bg.add(b3);
        
        controlP4.add(b1);
        controlP4.add(b2);
        controlP4.add(b3);

        this.f.pack();
    	this.f.setVisible(true);
    }
}

