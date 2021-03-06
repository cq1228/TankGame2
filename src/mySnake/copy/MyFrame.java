package mySnake.copy;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final static int COW_NUMBER=40;
	protected final static int COL_NUMBER=40;
	protected final static int BLOCK_WIDTH=10;
	protected final static int BLOCK_HEIGHT=10;
	protected final static int WIDTH=(COL_NUMBER+8)*BLOCK_WIDTH;
	protected final static int HEIGHT=(COW_NUMBER+8)*BLOCK_HEIGHT;
	protected static boolean isDead=false;
	private Snake snake;
	private LinkedList<Ball>balls=new LinkedList<Ball>();
	private Handle manager;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		MyFrame myFrame = new MyFrame();
		
	}
	public  MyFrame(){
		this.setSize(WIDTH, HEIGHT);
		this.setLocation(300,300);
		this.snake=new Snake();
		balls.add(new Ball());
		manager=new Handle(snake, balls);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());
		new Thread(new PaintClass()).start();
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if (!isDead) {
			g.drawRect(BLOCK_WIDTH * 4, BLOCK_HEIGHT * 4, COL_NUMBER
					* BLOCK_WIDTH, COW_NUMBER * BLOCK_HEIGHT);
			g.fillRect(40, 40, 400, 10);
			g.fillRect(40, 440, 400, 10);
			g.fillRect(40, 40, 10, 400);
			g.fillRect(440, 40, 10, 410);
			snake.draw(g);
			for (Ball ball : balls) {
				ball.draw(g);
			}
			manager.deal();
		}
		else g.drawString("game over", 100, 100);
	}
	private class PaintClass implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	private class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				snake.changeDir(Direction.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDir(Direction.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.changeDir(Direction.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snake.changeDir(Direction.RIGHT);
				break;
			default:
				break;
			}
		}
	}
}
