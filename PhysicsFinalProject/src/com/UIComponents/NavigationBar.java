package com.UIComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.Fonts.pack.FontLoader;
import javax.swing.ImageIcon;

public class NavigationBar extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xMouse, yMouse;
	private Color hover = new Color(0,0,0);
	private Font GeistBold, GeistMonoRegular;	
	private JLabel windowTitle; 
	private String currentTitle;
	private RainBow rainBow;
	
	public NavigationBar(JFrame MainFrame, JPanel mainPanel) {
		rainBow = new RainBow();
		GeistBold = FontLoader.fontGeistBold();
		GeistMonoRegular= FontLoader.fontGeistMonoRegular();
		initComponents(MainFrame, mainPanel);
	}
	
	private void initComponents(JFrame MainFrame, JPanel mainPanel) {
		JPanel navigationBar = new JPanel();
		navigationBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		navigationBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					MainFrame.setLocation(x - xMouse, y - yMouse);
			}
		});
		navigationBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		navigationBar.setBackground(new Color(255, 190, 111));
		navigationBar.setBounds(0, 0, 900, 40);
		mainPanel.add(navigationBar);
		
		JButton closeBTN = new JButton("X");
		closeBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sethover(closeBTN.getBackground());
				closeBTN.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				closeBTN.setBackground(gethover());
			}
		});
		closeBTN.setFont(GeistBold.deriveFont(12f));
		closeBTN.setFocusPainted(false);
		closeBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
		closeBTN.setBackground(new Color(255, 0, 0));
		closeBTN.setBounds(857, 6, 33, 28);
		closeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		navigationBar.setLayout(null);
		navigationBar.add(closeBTN);
		
		JButton minimizeBTN = new JButton("_");
		minimizeBTN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				sethover(minimizeBTN.getBackground());
				minimizeBTN.setBackground(new Color(255,255,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				minimizeBTN.setBackground(gethover());
			}
			
		});
		minimizeBTN.setFont(GeistBold.deriveFont(12f));
		minimizeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.setState(Frame.ICONIFIED);
				
			}
		});
		minimizeBTN.setFocusPainted(false);
		minimizeBTN.setBorder(new LineBorder(new Color(0, 0, 0)));
		minimizeBTN.setBackground(new Color(128, 128, 255));
		minimizeBTN.setBounds(814, 6, 33, 28);
		navigationBar.add(minimizeBTN);
		
		windowTitle = new JLabel(MainFrame.getTitle());
		windowTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				currentTitle = windowTitle.getText();
				rainBow.startRainbowEffect(windowTitle);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 rainBow.stopRainbowEffect();
	                windowTitle.setText(currentTitle);  // Restaurar el texto original
	                windowTitle.setForeground(Color.BLACK);  // Restaurar color original
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				rainBow.stopRainbowEffect();
				CardLayout cardLayout = (CardLayout) windowChanger.getLayout();
                cardLayout.show(windowChanger, "startWindow");
                
                windowTitle.setText(MainWindow.this.getTitle());
                currentTitle = MainWindow.this.getTitle();
                */
			}
		});
		windowTitle.setFont(GeistMonoRegular.deriveFont(14f));
		windowTitle.setIcon(new ImageIcon(NavigationBar.class.getResource("/com/images/Iconx32.png")));
		windowTitle.setBounds(12, 5, 200, 30);
		navigationBar.add(windowTitle);
	}
	
	private void sethover(Color h) {hover = h;}
	
	private Color gethover() {return hover;}
	
	public void setWindowTitle(String title) {windowTitle.setText(title);}
	
	public JLabel getWindowTitle() {return windowTitle;}
		
}
