package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;

public class NodeManager {
	
	ArrayList<Node> nodes = new ArrayList();
	
	Node nodeSelected = null;
	
	public NodeManager() {
		
	}
	
	public void addNode(int x, int y) {
		nodes.add(new Node(x, y));
	}
	
	public void update() {
		for(int i = 0;i<nodes.size();i++) {
			Node thisNode = nodes.get(i);
			thisNode.update();
		}
	}
	
	public void paintIt(Graphics g) {
		g.setColor(Color.black);
		if(nodeSelected != null) {
			g.drawLine(nodeSelected.x + nodeSelected.size / 2, nodeSelected.y + nodeSelected.size / 2, Cover.mouseX, Cover.mouseY);
		}
		for(int i = 0;i<nodes.size();i++) {
			Node thisNode = nodes.get(i);
			thisNode.paintIt(g, i);
		}
	}
	
	public boolean intersects(int x, int y) {
		for(int i = 0;i<nodes.size();i++) {
			Node thisNode = nodes.get(i);
			if(thisNode.intersects(x, y))return true;
		}
		return false;
	}
	
	public Node get(int x, int y) {
		
		for(int i = 0;i<nodes.size();i++) {
			Node thisNode = nodes.get(i);
			if(thisNode.x <= x && thisNode.x + thisNode.size >= x && thisNode.y <= y && thisNode.y + thisNode.size >= y)
				return thisNode;
		}
		return null;
		
	}
	
	public void addEdge(Node endOfEdge) {
		App.mainCover.edgeManager.addEdge(nodeSelected, endOfEdge);
	}
	
}
