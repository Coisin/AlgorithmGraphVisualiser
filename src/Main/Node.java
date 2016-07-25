package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Node extends JComponent{
	
	int x, y;
	int size;
	
	public Node(int x, int y) {
		size = 50;
		this.x = x - size / 2;
		this.y = y - size / 2;
	}
	
	public boolean intersects(int x, int y) {
		if(x >= this.x && x <= this.x + size) {
			if(y >= this.y && y <= this.y + size) {
				return true;
			}
		}
		return false;
	}
	
	public void update() {
		
	}
	
	public void paintIt(Graphics g, int id) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(20));
		
		g2d.setColor(Color.BLACK);
		g2d.drawOval(x, y, size, size);
		g.setColor(Color.red);
		g.fillOval(x, y, size, size);
	}
	
}