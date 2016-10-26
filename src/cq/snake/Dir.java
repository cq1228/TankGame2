package cq.snake;

import javax.swing.ImageIcon;

public enum Dir {
	U(1,new ImageIcon("tankImages/tankU.gif")),D(2,new ImageIcon("tankImages/tankD.gif")),
		L(3,new ImageIcon("tankImages/tankL.gif")),R(4,new ImageIcon("tankImages/tankR.gif"));
	private int direction;
	private ImageIcon body;
	Dir(int dir,ImageIcon body){
		this.direction=dir;
		this.body=body;
	}
	public int getDirection() {
		return direction;
	}
	public ImageIcon getBody() {
		return body;
	}
	
}
