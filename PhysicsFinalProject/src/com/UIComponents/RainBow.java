package com.UIComponents;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.Timer;

public class RainBow {
	
	public Color hover = new Color(0,0,0);
	private Timer rainbowTimer;
	private ArrayList<Color> rainbowColors;
	private int currentIndex = 0;
	
	public RainBow() 
	{
		// Arcoiris de colores
        rainbowColors = new ArrayList<>();
        rainbowColors.add(Color.RED);
        rainbowColors.add(Color.ORANGE);
        rainbowColors.add(Color.YELLOW);
        rainbowColors.add(Color.GREEN);
        rainbowColors.add(Color.CYAN);
        rainbowColors.add(Color.BLUE);
        rainbowColors.add(Color.MAGENTA);
        
        hover = new Color(0, 0, 0);
        rainbowTimer = null;
        currentIndex = 0;
	}
	

	
	// Método para iniciar el efecto arcoiris
    public void startRainbowEffect(JLabel title) {
    	String titleText = title.getText();
        currentIndex = 0;  // Resetear el índice
        rainbowTimer = new Timer(100, e -> {
            StringBuilder coloredText = new StringBuilder("<html>");
            for (int i = 0; i < titleText.length(); i++) {
                // Ciclar colores del arcoiris
            	Color color = rainbowColors.get((i + currentIndex) % rainbowColors.size());
                String hexColor = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
                coloredText.append("<font color='").append(hexColor).append("'>").append(titleText.charAt(i)).append("</font>");
            }
            coloredText.append("</html>");
            title.setText(coloredText.toString());            
            currentIndex++;
        });
        rainbowTimer.start();
        
        
    }
    
    // Método para detener el efecto arcoiris
    public void stopRainbowEffect() {
        if (rainbowTimer != null && rainbowTimer.isRunning()) {
            rainbowTimer.stop();
        }
    }

}
