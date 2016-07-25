package Main;

import java.awt.Graphics;
import java.util.ArrayList;

public class EdgeManager {
	ArrayList<Edge> edges = new ArrayList();
	public void addEdge(Node start, Node end) {
		if(!contains(start, end) && !contains(end, start))
			edges.add(new Edge(start, end, -1));
	}
	public boolean contains(Node start, Node end) {
		for(int i = 0;i<edges.size();i++) {
			Edge edge = edges.get(i);
			if(edge.start == start && edge.end == end)return true;
		}
		return false;
	}
	public void update() {
		for(int i = 0;i<edges.size();i++) {
			edges.get(i).update();
		}
	}
	
	public void paint(Graphics g) {
		for(int i = 0;i<edges.size();i++) {
			edges.get(i).paint(g);
		}
	}
}
