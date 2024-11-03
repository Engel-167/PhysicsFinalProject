package com.Fonts.pack;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

import com.UIComponents.NavigationBar;

public class FontLoader {
	
	public static Font fontGeistRegular() {
		
		Font GeistRegular = null;
		try {			
			GeistRegular = Font.createFont(Font.TRUETYPE_FONT, com.UIComponents.NavigationBar.class.getResourceAsStream("/com/Fonts/pack/Geist-Regular.ttf")).deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return GeistRegular;
	}
	
	public static Font fontGeistBold() {		
		Font GeistBold = null;		
		try {			
			GeistBold = Font.createFont(Font.TRUETYPE_FONT, NavigationBar.class.getResourceAsStream("/com/Fonts/pack/Geist-Bold.ttf")).deriveFont(12f);			
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return GeistBold;
	}
	
	public static Font fontGeistMonoRegular() {
		
		Font GeistMonoRegular = null;
		try {			
			GeistMonoRegular = Font.createFont(Font.TRUETYPE_FONT, NavigationBar.class.getResourceAsStream("/com/Fonts/pack/GeistMono-Regular.ttf")).deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return GeistMonoRegular;
	}
	
	public static Font fontGeistMonoBold() {
		Font GeistBold = null;
		try {			
			GeistBold = Font.createFont(Font.TRUETYPE_FONT, NavigationBar.class.getResourceAsStream("/com/Fonts/pack/GeistMono-Bold.ttf")).deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return GeistBold;
	}
	
	public static Font fontCoolJazz() {
		Font CoolJazz = null;
		try {			
			CoolJazz = Font.createFont(Font.TRUETYPE_FONT, NavigationBar.class.getResourceAsStream("/com/Fonts/pack/Cooljazz.ttf")).deriveFont(12f);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return CoolJazz;
	}

}
