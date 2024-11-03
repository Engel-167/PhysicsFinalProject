package com.UIComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class CustomButton extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean over;
	private Color color;
	private Color colorOver;
	private Color colorClick;
	private Color borderColor;
	private int radius = 0;
	
	public CustomButton() {
		setColor(color);
		colorOver = new Color(179, 250, 160);
		colorClick = new Color(152, 184, 144);
		borderColor = new Color(30, 136, 56);
		
		setBackground(getColor());
		setForeground(Color.WHITE);
		setFont(new Font("Cool jazz", Font.BOLD, 14));
		
		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		
		addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(colorOver);
				setForeground(new Color(0,0,0));
				over = true;
				setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(getColor());
				over = false;
				setForeground(new Color(255,255,255));
				setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(colorClick);
				
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(over) 
				{
					setBackground(colorOver);
				}
				else 
				{
					setBackground(getColor());
				}
			}
			
		});
		
	}
	
	public boolean isOver() {
		return over;
	}
	
	public void setOver(boolean over) {
		this.over = over;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColorOver() {
		return colorOver;
	}
	
	public void setColorOver(Color colorOver) {
		this.colorOver = colorOver;
	}
	
	public Color getColorClick() {
		return colorClick;
	}
	
	public void setColorClick(Color colorClick) {
		this.colorClick = colorClick;
	}
	
	public Color getBorderColor() {
		return borderColor;
	}
	
	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Paint Border
		g2.setColor(borderColor);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
		g2.setColor(getBackground());
		g2.fillRoundRect(3, 3, getWidth() - 6, getHeight() - 6, radius, radius);
		super.paintComponent(g);
	}

}
