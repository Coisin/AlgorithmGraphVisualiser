package Main;

import java.awt.Graphics;

import javax.swing.JFrame;

public class App extends JFrame implements Runnable{
	
	Graphics screen;
	
	Thread loop=null;
	boolean running = false;
	
	static Cover mainCover=null;
	
	public static void main(String args[]) {
		
		new App();
		
	}
	
	public App() {
		
		mainCover = new Cover();
		
		this.add(mainCover);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		start();
		
	}
	
	public void start() {
		screen = this.getGraphics();
		running = true;
		if(loop == null) {
			
			loop = new Thread(this);
			loop.start();
		}
	}
	
	public void stop() {
		running = false;
	}
	
	public void run() {
		
		while(running) {
			try {
				mainCover.update();
				mainCover.paint();
				mainCover.cover();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
