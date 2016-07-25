package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Edge {
	Node start,  end;
	int weight;
	public Edge(Node start, Node end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public void update() {
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(20));
		
		g.setColor(Color.BLACK);
		int size = start.size;
		
		int difY = Math.abs(end.y - start.y);
		int difX = Math.abs(end.x - start.x);
		
		int middleY = Math.min(end.y, start.y) + difY / 2;
		int middleX = Math.min(end.x, start.x) + difX / 2;
		
		g.drawString(Integer.toString(weight), middleX, middleY);
		g2d.drawLine(start.x + size / 2, start.y + size / 2, end.x + size / 2, end.y + size / 2);
	}
	
}
