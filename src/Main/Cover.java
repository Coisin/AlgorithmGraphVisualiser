package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Cover extends JPanel{
	
	static int mouseX, mouseY;
	
	int W = 700, H = W / 13 * 9;
	Dimension size = new Dimension(W, H);
	
	Image buffer=null;
	Graphics bufferG=null, screen=null;
	
	Keyboard board = new Keyboard();
	Mouse mouse = new Mouse();
	
	NodeManager nodeManager;
	EdgeManager edgeManager;
	
	public Cover() {
		
		nodeManager = new NodeManager();
		edgeManager = new EdgeManager();
		
		this.setFocusable(true);
		this.requestFocus();
		
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		this.addKeyListener(board);
		
		this.setPreferredSize(size);
		
	}
	
	public void processClick(int x, int y, boolean pressed) {
		
		if(pressed) {
			if(nodeManager.intersects(x, y)) {
				nodeManager.nodeSelected = nodeManager.get(x, y);
			} else {
				nodeManager.addNode(x, y);
			}
		}else {
			if(nodeManager.intersects(x, y) && nodeManager.nodeSelected != null) {
				Node endOfEdge = nodeManager.get(x, y);
				nodeManager.addEdge(endOfEdge);
			}
			nodeManager.nodeSelected = null;
		}
		
	}
	
	public void update() {
		edgeManager.update();
		nodeManager.update();
	}
	
	public void paint() {
		if(buffer == null) {
			buffer = this.createImage(W, H);
			if(buffer == null) {
				return;
			} else {
				bufferG = buffer.getGraphics();
			}
		}
		
		bufferG.setColor(Color.white);
		bufferG.fillRect(0, 0, W, H);
		
		edgeManager.paint(bufferG);
		nodeManager.paintIt(bufferG);
		
	}
	
	public void cover() {
		screen  = this.getGraphics();
		if(screen != null && buffer != null) {
			screen.drawImage(buffer, 0, 0, W, H, null);
		}
	}
	
}
