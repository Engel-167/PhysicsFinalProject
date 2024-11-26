package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.UIComponents.NavigationBar;
import com.UIComponents.RainBow;
import com.UIComponents.CustomButton;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import com.UIComponents.CustomPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import javax.swing.JTextArea;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel mainWindow;
	private JLabel titleLBL;
	private JTextField massOneField;
	private RainBow rainBow;
	private Clip clip;
	
	 /*private int colorIndex = 0;
	    private final Color[] blueGradientColors = {
	        new Color(0, 0, 255), // Blue
	        new Color(0, 128, 255), // Light Blue
	        new Color(0, 255, 255), // Cyan
	        new Color(0, 128, 255), // Light Blue
	        new Color(0, 0, 255) // Blue
	    };*/
	
	private static final double GRAVITY = 9.81; // m/s^2
    private final int AREA_1 = 1; // en metros
    private final int AREA_2 = 2; // en metros
    
    private double massOne = 0;
    private double massTwo = 0;
    
    private double forceOne = 0;
    private double forceTwo = 0;
    
    private double presureOne = 0;
    private double presureTwo = 0;
    
    private JPanel help;
    
    private JTextField massTwoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		// Configurar la aplicación para ser "DPI aware"
		System.setProperty("sun.java2d.dpiaware", "true");
        System.setProperty("sun.java2d.uiScale", "1.0"); // Desactiva el escalado UI
        System.setProperty("sun.awt.disableScaling", "true"); // Desactiva el escalado DPI
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);		
					frame.playSong("/songs/song.wav");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		rainBow = new RainBow();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/images/Iconx64.png")));
		setUndecorated(true);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 556);
		mainWindow = new JPanel();
		mainWindow.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainWindow);
		mainWindow.setLayout(null);
		
		JPanel windowChanger = new JPanel();
		windowChanger.setBorder(new LineBorder(new Color(0, 0, 0)));
		windowChanger.setBackground(new Color(128, 255, 255));
		windowChanger.setBounds(0, 40, 900, 516);
		mainWindow.add(windowChanger);
		windowChanger.setLayout(new CardLayout(0, 0));
		
		JPanel startWindow = new JPanel();
		windowChanger.add(startWindow, "name_83828197695300");
		startWindow.setLayout(null);
		
		CustomButton cstmbtnPascal = new CustomButton();
		cstmbtnPascal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cl = (CardLayout) windowChanger.getLayout();
				cl.show(windowChanger, "name_83845947942100");
				
				rainBow.stopRainbowEffect();
				
				playSoundEffect("/songs/shadow.wav");
				
			}
		});
		
		titleLBL = new JLabel("Simulacion del principio de Pascal");
		titleLBL.addMouseListener(new MouseAdapter() {			
		});
		
		CustomPanel infoContainer = new CustomPanel();
		infoContainer.setBackground(new Color(128, 128, 255));
		infoContainer.setRadius(55);
		infoContainer.setBounds(182, 130, 535, 229);
		startWindow.add(infoContainer);
		infoContainer.setLayout(null);
		
		JTextArea txtrEsteProgramaEs = new JTextArea();
		txtrEsteProgramaEs.setText("       Este Programa es una simulacion del Principio de Pascal el cual\r\n          esta directamente relacionado con los fluidos confinados y \r\n          como la presion aplicada en cualquier punto del sistema\r\n              se ejerce uniformemente a lo largo de todo el fluido\r\n \r\n\r\n        En esta simulacion podra apreciar como se aplica este principio\r\n           en tiempo real a dos pistones con una masa sobre ellos\r\n              y como la fuerza puede llegar a multiplicarse gracias\r\n               la presion ejercida en conductos mas estrechos");
		txtrEsteProgramaEs.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrEsteProgramaEs.setForeground(new Color(255, 255, 255));
		txtrEsteProgramaEs.setBackground(new Color(128, 128, 255));
		txtrEsteProgramaEs.setBounds(23, 22, 491, 183);
		infoContainer.add(txtrEsteProgramaEs);
		titleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		titleLBL.setFont(new Font("Tahoma", Font.BOLD, 24));
		titleLBL.setBounds(90, 10, 720, 67);
		startWindow.add(titleLBL);
		cstmbtnPascal.setText("Iniciar");
		cstmbtnPascal.setRadius(35);
		cstmbtnPascal.setBounds(361, 400, 178, 74);
		cstmbtnPascal.setColorOver(new Color(143, 240, 164));
		cstmbtnPascal.setColorClick(Color.WHITE);
		cstmbtnPascal.setColor(new Color(51, 209, 122));
		cstmbtnPascal.setBorderColor(new Color(38, 162, 105));
		cstmbtnPascal.setBackground(new Color(51, 209, 122));
		
		startWindow.add(cstmbtnPascal);
		
		JLabel backgroundLBL = new JLabel("");
		backgroundLBL.setIcon(new ImageIcon(Main.class.getResource("/com/images/background.jpg")));
		backgroundLBL.setBounds(0, 0, 900, 515);
		startWindow.add(backgroundLBL);
		
		JPanel simulationWindow = new JPanel();
		simulationWindow.setBackground(new Color(128, 255, 255));
		windowChanger.add(simulationWindow, "name_83845947942100");
		simulationWindow.setLayout(null);
		
		CustomButton cstmbtnRegresar = new CustomButton();
		cstmbtnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CardLayout cl = (CardLayout) windowChanger.getLayout();
				cl.show(windowChanger, "name_83828197695300");
				
				titleLBL.setText("Simulacion del principio de Pascal");
				titleLBL.setForeground(Color.BLACK);

				new Thread(() -> {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					rainBow.startRainbowEffect(titleLBL);
				}).start();		
				
				playSoundEffect("/songs/stalker.wav");
			}
		});
		
		CustomButton infoBTN = new CustomButton();
		infoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help	.setVisible(true);
			}
		});
		
		help = new JPanel();
		help.setVisible(false);
		help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO
			}
		});
		help.setBounds(0, 0, 900, 520);
		help.setBackground(new Color(0,0,0,123));		
		simulationWindow.add(help);
		help.setLayout(null);
		
		CustomButton helpOKBTN = new CustomButton();
		helpOKBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help.setVisible(false);
			}
		});
		helpOKBTN.setText("OK");
		helpOKBTN.setRadius(35);
		helpOKBTN.setColorOver(new Color(143, 240, 164));
		helpOKBTN.setColorClick(Color.WHITE);
		helpOKBTN.setColor(new Color(51, 209, 122));
		helpOKBTN.setBorderColor(new Color(38, 162, 105));
		helpOKBTN.setBackground(new Color(51, 209, 122));
		helpOKBTN.setBounds(388, 448, 148, 40);
		help.add(helpOKBTN);
		
		CustomPanel customPanel_2 = new CustomPanel();
		customPanel_2.setBackground(new Color(128, 128, 255));
		customPanel_2.setRadius(55);
		customPanel_2.setBounds(105, 90, 696, 247);
		help.add(customPanel_2);
		customPanel_2.setLayout(null);
		
		JTextArea txtrIngrese = new JTextArea();
		txtrIngrese.setForeground(new Color(255, 255, 255));
		txtrIngrese.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtrIngrese.setText("1 - Ingrese los pesos correspondientes en los campos M1 y M2\r\n2 - Pulse insertar y vea como reacciona el programa\r\n3 - Puede pulsar el boton equilibrar para ver el sistema equilibrado\r\n\r\n\r\nElaborado por:\r\nIsaac Dahir Rodriguez Gutierrez.\r\nEngel Giovany Mendoza Polanco.\r\n\r\nGrupo: 2-M4-CO");
		txtrIngrese.setBackground(new Color(128, 128, 255));
		txtrIngrese.setBounds(69, 34, 577, 184);
		customPanel_2.add(txtrIngrese);
		infoBTN.setText("?");
		infoBTN.setRadius(35);
		infoBTN.setColorOver(new Color(143, 240, 164));
		infoBTN.setColorClick(Color.WHITE);
		infoBTN.setColor(new Color(51, 209, 122));
		infoBTN.setBorderColor(new Color(38, 162, 105));
		infoBTN.setBackground(new Color(51, 209, 122));
		infoBTN.setBounds(10, 460, 75, 40);
		simulationWindow.add(infoBTN);
		cstmbtnRegresar.setText("Regresar");
		cstmbtnRegresar.setRadius(35);
		cstmbtnRegresar.setColorOver(new Color(143, 240, 164));
		cstmbtnRegresar.setColorClick(Color.WHITE);
		cstmbtnRegresar.setColor(new Color(51, 209, 122));
		cstmbtnRegresar.setBorderColor(new Color(38, 162, 105));
		cstmbtnRegresar.setBackground(new Color(51, 209, 122));
		cstmbtnRegresar.setBounds(387, 464, 148, 40);
		simulationWindow.add(cstmbtnRegresar);
		
		CustomPanel customPanel_1 = new CustomPanel();
		customPanel_1.setBackground(new Color(249, 244, 160));
		customPanel_1.setRadius(55);
		customPanel_1.setBounds(10, 31, 168, 394);
		simulationWindow.add(customPanel_1);
		customPanel_1.setLayout(null);
		
		CustomPanel customPanel = new CustomPanel();
		customPanel.setBackground(new Color(249, 244, 160));
		customPanel.setRadius(55);
		customPanel.setBounds(188, 31, 685, 394);
		simulationWindow.add(customPanel);
		customPanel.setLayout(null);
		
		JPanel leftPiston = new JPanel();
		leftPiston.setLayout(null);
		leftPiston.setBackground(new Color(249, 244, 160));
		leftPiston.setBounds(138, 48, 51, 170);
		customPanel.add(leftPiston);
		
		JPanel rightPiston = new JPanel();
		rightPiston.setLayout(null);
		rightPiston.setBackground(new Color(249, 244, 160));
		rightPiston.setBounds(460, 48, 85, 170);
		customPanel.add(rightPiston);
		
		JLabel rightWeightLBL = new JLabel("0 Kg");
		rightWeightLBL.setFont(new Font("Tahoma", Font.BOLD, 10));
		rightWeightLBL.setOpaque(true);
		rightWeightLBL.setHorizontalAlignment(SwingConstants.CENTER);
		rightWeightLBL.setForeground(Color.WHITE);
		rightWeightLBL.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightWeightLBL.setBackground(new Color(64, 128, 128));
		rightWeightLBL.setBounds(20, 61, 45, 45);		
		
		JLabel leftWeightLBL = new JLabel("0 Kg");
		leftWeightLBL.setFont(new Font("Tahoma", Font.BOLD, 10));
		leftWeightLBL.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftWeightLBL.setOpaque(true);
		leftWeightLBL.setHorizontalAlignment(SwingConstants.CENTER);
		leftWeightLBL.setForeground(Color.WHITE);
		leftWeightLBL.setBackground(new Color(64, 128, 128));
		leftWeightLBL.setBounds(3, 61, 45, 45);
		leftPiston.add(leftWeightLBL);
		
		JLabel forceOneLBL = new JLabel("F1=m*g");
		forceOneLBL.setHorizontalAlignment(SwingConstants.CENTER);
		forceOneLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		forceOneLBL.setBounds(10, 46, 148, 23);
		customPanel_1.add(forceOneLBL);
		
		JLabel forceTwoLBL = new JLabel("F2=m*g");
		forceTwoLBL.setHorizontalAlignment(SwingConstants.CENTER);
		forceTwoLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		forceTwoLBL.setBounds(10, 68, 148, 23);
		customPanel_1.add(forceTwoLBL);
		
		JLabel AreaOneLBL = new JLabel("A1=1m^2");
		AreaOneLBL.setHorizontalAlignment(SwingConstants.CENTER);
		AreaOneLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		AreaOneLBL.setBounds(10, 92, 148, 23);
		customPanel_1.add(AreaOneLBL);
		
		JLabel AreaTwoLBL = new JLabel("A2=2m^2");
		AreaTwoLBL.setHorizontalAlignment(SwingConstants.CENTER);
		AreaTwoLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		AreaTwoLBL.setBounds(10, 114, 148, 23);
		customPanel_1.add(AreaTwoLBL);
		
		JLabel PresureOneLBL = new JLabel("P1=F1/A1");
		PresureOneLBL.setHorizontalAlignment(SwingConstants.CENTER);
		PresureOneLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		PresureOneLBL.setBounds(10, 139, 148, 23);
		customPanel_1.add(PresureOneLBL);
		
		JLabel PresureTwoLBL = new JLabel("P2=F2/A2");
		PresureTwoLBL.setHorizontalAlignment(SwingConstants.CENTER);
		PresureTwoLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		PresureTwoLBL.setBounds(10, 163, 148, 23);
		customPanel_1.add(PresureTwoLBL);
		
		JLabel lblAm_2_1_1_1 = new JLabel("<Equilibrio>");
		lblAm_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAm_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAm_2_1_1_1.setBounds(10, 265, 148, 23);
		customPanel_1.add(lblAm_2_1_1_1);
		
		JLabel M2equilibriumLBL = new JLabel("M2= M1(A2/A1)");
		M2equilibriumLBL.setHorizontalAlignment(SwingConstants.CENTER);
		M2equilibriumLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		M2equilibriumLBL.setBounds(10, 313, 148, 23);
		customPanel_1.add(M2equilibriumLBL);
		
		JLabel M1equilibriumLBL = new JLabel("M1= M2(A1/A2)");
		M1equilibriumLBL.setHorizontalAlignment(SwingConstants.CENTER);
		M1equilibriumLBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		M1equilibriumLBL.setBounds(10, 287, 148, 23);
		customPanel_1.add(M1equilibriumLBL);
		
		CustomButton organizeBTN = new CustomButton();
		organizeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double massTwoEquilibrium = massOne * (AREA_2 / AREA_1);
				M2equilibriumLBL.setText("M2 = " + massTwoEquilibrium + " Kg");
				
				double massOneEquilibrium = massTwo / 2;
				M1equilibriumLBL.setText("M1 = " + massOneEquilibrium + " Kg");
				
				if (massOne > massTwo) {
					rightWeightLBL.setText(massTwoEquilibrium + " Kg");
					
					simulate(massOne, massTwoEquilibrium, leftPiston, rightPiston);
				} else {
					leftWeightLBL.setText(massOneEquilibrium + " Kg");

					simulate(massOneEquilibrium, massTwo, leftPiston, rightPiston);
				}
				
				
				playSoundEffect("/songs/underwater.wav");
			}
		});
		organizeBTN.setText("Equilibrar");
		organizeBTN.setColorOver(new Color(143, 240, 164));
		organizeBTN.setColorClick(Color.WHITE);
		organizeBTN.setColor(new Color(51, 209, 122));
		organizeBTN.setBorderColor(new Color(38, 162, 105));
		organizeBTN.setBackground(new Color(51, 209, 122));
		organizeBTN.setRadius(35);
		organizeBTN.setBounds(10, 346, 148, 40);
		customPanel_1.add(organizeBTN);
		
		JLabel lblAm_2_1_1_1_2 = new JLabel("<Datos>");
		lblAm_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAm_2_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAm_2_1_1_1_2.setBounds(10, 13, 148, 23);
		customPanel_1.add(lblAm_2_1_1_1_2);
		
		JLabel lblAm_2_1_1_1_1 = new JLabel("<Fuerza Ejercida>");
		lblAm_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAm_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAm_2_1_1_1_1.setBounds(10, 196, 148, 23);
		customPanel_1.add(lblAm_2_1_1_1_1);
		
		JLabel F1ToF2LBL = new JLabel("F1->F2=F1(A2/A1)");
		F1ToF2LBL.setHorizontalAlignment(SwingConstants.CENTER);
		F1ToF2LBL.setFont(new Font("Tahoma", Font.BOLD, 12));
		F1ToF2LBL.setBounds(10, 232, 148, 23);
		customPanel_1.add(F1ToF2LBL);								
		
		JPanel leftPatch_1 = new JPanel();
		leftPatch_1.setBorder(null);
		leftPatch_1.setBackground(new Color(188, 185, 192));
		leftPatch_1.setBounds(546, 334, 33, 48);
		customPanel.add(leftPatch_1);
		
		JPanel leftPatch = new JPanel();
		leftPatch.setBorder(null);
		leftPatch.setBackground(new Color(188, 185, 192));
		leftPatch.setBounds(104, 334, 33, 48);
		customPanel.add(leftPatch);				
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(208, 172, 126));
		panel.setBounds(0, 148, 51, 22);
		leftPiston.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1m^2");
		lblNewLabel.setBounds(7, 4, 36, 15);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(208, 172, 126));
		panel_2.setBounds(15, 119, 20, 30);
		leftPiston.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBackground(new Color(208, 172, 126));
		panel_3.setBounds(0, 108, 51, 12);
		leftPiston.add(panel_3);
		
		massOneField = new JTextField();
		massOneField.getDocument().addDocumentListener(new DocumentListener() {
			private final String allowedCharacters = "0123456789";

			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					String text = massOneField.getText();
					StringBuilder filteredText = new StringBuilder();
					for (char c : text.toCharArray()) {
						if (allowedCharacters.indexOf(c) != -1) {
							filteredText.append(c);
						}
					}
					if (!text.equals(filteredText.toString())) {
						massOneField.setText(filteredText.toString());
					}
				});
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// No action needed on remove
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// No action needed on change
			}
		});
		massOneField.setColumns(10);
		massOneField.setBounds(228, 48, 51, 30);
		customPanel.add(massOneField);	
		
		rightPiston.add(rightWeightLBL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(new Color(208, 172, 126));
		panel_1.setBounds(0, 148, 85, 22);
		rightPiston.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("2m^2");
		lblNewLabel_1.setBounds(24, 4, 36, 15);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(208, 172, 126));
		panel_2_1.setBounds(32, 119, 20, 30);
		rightPiston.add(panel_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1_1.setBackground(new Color(208, 172, 126));
		panel_1_1.setBounds(0, 108, 85, 12);
		rightPiston.add(panel_1_1);				
		
		JPanel water = new JPanel();
		water.setBorder(new LineBorder(new Color(0, 0, 0)));
		water.setLayout(null);
		water.setBackground(new Color(102, 134, 240));
		water.setBounds(74, 164, 535, 219);
		customPanel.add(water);
		
		JPanel wall_bottom = new JPanel();
		wall_bottom.setBorder(new LineBorder(new Color(0, 0, 0)));
		wall_bottom.setBackground(new Color(188, 185, 192));
		wall_bottom.setBounds(53, 193, 428, 26);
		water.add(wall_bottom);
		
		JPanel wall_right = new JPanel();
		wall_right.setBorder(new LineBorder(new Color(0, 0, 0)));
		wall_right.setBackground(new Color(188, 185, 192));
		wall_right.setBounds(471, 0, 64, 219);
		water.add(wall_right);
		
		JPanel wall_top = new JPanel();
		wall_top.setBorder(new LineBorder(new Color(0, 0, 0)));
		wall_top.setBackground(new Color(188, 185, 192));
		wall_top.setBounds(115, 0, 271, 133);
		water.add(wall_top);
		
		JPanel wall_left = new JPanel();
		wall_left.setBorder(new LineBorder(new Color(0, 0, 0)));
		wall_left.setBackground(new Color(188, 185, 192));
		wall_left.setBounds(0, 0, 64, 219);
		water.add(wall_left);
		wall_left.setLayout(null);
		
		CustomButton startBTN = new CustomButton();
		startBTN.addActionListener(new ActionListener() {					
			public void actionPerformed(ActionEvent e) {
				
				playSoundEffect("/songs/click.wav");
				
				if (!massOneField.getText().isEmpty()) {
					massOne = Double.parseDouble(massOneField.getText());
				} else {
					massOne = 0;
				}
				
				if (!massTwoField.getText().isEmpty()) {
					massTwo = Double.parseDouble(massTwoField.getText());
				} else {
					massTwo = 0;
				}
				
				
				forceOne = massOne * GRAVITY;
				forceTwo = massTwo * GRAVITY;
				
				forceOneLBL.setText(String.format("F1 = %.2fN", forceOne));
				forceTwoLBL.setText(String.format("F1 = %.2fN", forceTwo));
				
				presureOne = forceOne / AREA_1;
				presureTwo = forceTwo / AREA_2;
				
				PresureOneLBL.setText(String.format("P1 = %.2fPa", presureOne));
				PresureTwoLBL.setText(String.format("P1 = %.2fPa", presureTwo));
				
				leftWeightLBL.setText(massOne + " Kg");
				rightWeightLBL.setText(massTwo + " Kg");
				
				F1ToF2LBL.setText(String.format("F1 -> F2 = %.2fN", forceOne * (AREA_2 / AREA_1)));
				
				double massTwoEquilibrium = massOne * (AREA_2 / AREA_1);
				M2equilibriumLBL.setText("M2 = " + massTwoEquilibrium + " Kg");
				
				double massOneEquilibrium = massTwo / 2;
				M1equilibriumLBL.setText("M1 = " + massOneEquilibrium + " Kg");
				
				simulate(massOne, massTwo, leftPiston, rightPiston);
			}			
		});
		startBTN.setText("Insertar");
		startBTN.setRadius(35);
		startBTN.setColorOver(new Color(143, 240, 164));
		startBTN.setColorClick(Color.WHITE);
		startBTN.setColor(new Color(51, 209, 122));
		startBTN.setBorderColor(new Color(38, 162, 105));
		startBTN.setBackground(new Color(51, 209, 122));
		startBTN.setBounds(251, 102, 148, 40);
		customPanel.add(startBTN);
		
		massTwoField = new JTextField();
		massTwoField.getDocument().addDocumentListener(new DocumentListener() {
			private final String allowedCharacters = "0123456789";

			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> {
					String text = massTwoField.getText();
					StringBuilder filteredText = new StringBuilder();
					for (char c : text.toCharArray()) {
						if (allowedCharacters.indexOf(c) != -1) {
							filteredText.append(c);
						}
					}
					if (!text.equals(filteredText.toString())) {
						massTwoField.setText(filteredText.toString());
					}
				});
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// No action needed on remove
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// No action needed on change
			}		
		});
		massTwoField.setColumns(10);
		massTwoField.setBounds(376, 48, 45, 30);
		customPanel.add(massTwoField);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese el peso sobre los pistones");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(199, 10, 250, 21);
		customPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Kg");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(282, 48, 33, 30);
		customPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Kg");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(429, 48, 27, 30);
		customPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("M2 =");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(342, 48, 33, 30);
		customPanel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("M1 =");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2_1.setBounds(192, 48, 33, 30);
		customPanel.add(lblNewLabel_3_2_1);
		
		JLabel backgroundLBL_1 = new JLabel("");
		backgroundLBL_1.setIcon(new ImageIcon(Main.class.getResource("/com/images/background.jpg")));
		backgroundLBL_1.setBounds(0, 0, 900, 515);
		simulationWindow.add(backgroundLBL_1);
		
		NavigationBar navigationBar = new NavigationBar(this, mainWindow);
		navigationBar.setBounds(0, 0, 900, 40);
		mainWindow.add(navigationBar);
		rainBow.startRainbowEffect(titleLBL);
	}
	
	private void simulate(double massOne, double massTwo, JPanel leftPiston, JPanel rightPiston) {
	    int animationDuration = 1000; // Duración de la animación en milisegundos (1 segundo)
	    int delay = 10; // Intervalo de tiempo entre cada actualización (en milisegundos)
	    int minY = 2; // Límite superior de Y
	    int maxY = 70; // Límite inferior de Y
	    
	    // Posiciones iniciales de los pistones
	    int initialYLeft = leftPiston.getY();
	    int initialYRight = rightPiston.getY();
	    
	    // Posiciones finales de los pistones con límites aplicados
	    int targetYLeft = Math.max(minY, Math.min(maxY, 48 + (int) (massOne * 2) - (int) ((massTwo * 2) / 2)));
	    int targetYRight = Math.max(minY, Math.min(maxY, 48 - (int) (massOne) + (int) (massTwo - massOne)));
	    
	    // Diferencia de desplazamiento en píxeles
	    int deltaYLeft = targetYLeft - initialYLeft;
	    int deltaYRight = targetYRight - initialYRight;
	    
	    // Calcular el número total de pasos de la animación
	    int steps = animationDuration / delay;
	    double stepYLeft = (double) deltaYLeft / steps;
	    double stepYRight = (double) deltaYRight / steps;

	    // Crear un Timer para realizar la animación
	    Timer timer = new Timer(delay, new ActionListener() {
	        int currentStep = 0;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (currentStep < steps) {
	                // Calcular la nueva posición con límite aplicado
	                int newYLeft = (int) (initialYLeft + stepYLeft * currentStep);
	                int newYRight = (int) (initialYRight + stepYRight * currentStep);
	                
	                // Asegurarse de que las posiciones están dentro de los límites
	                newYLeft = Math.max(minY, Math.min(maxY, newYLeft));
	                newYRight = Math.max(minY, Math.min(maxY, newYRight));
	                
	                // Actualizar la posición de los pistones
	                leftPiston.setLocation(138, newYLeft);
	                rightPiston.setLocation(460, newYRight);
	                
	                currentStep++;
	            } else {
	                // Detener el Timer cuando se alcanza la posición final
	                ((Timer) e.getSource()).stop();
	            }
	        }
	    });
	    
	    // Iniciar la animación
	    timer.start();	    
	}
	

	private void playSong(String filePath) {
		try {
			// Use getResource to load the file from the classpath
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Main.class.getResource(filePath));

			// Convert the audio format to a supported format
			AudioFormat baseFormat = audioInputStream.getFormat();
			AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream decodedAudioInputStream = AudioSystem.getAudioInputStream(decodedFormat, audioInputStream);

			clip = AudioSystem.getClip();
			clip.open(decodedAudioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}




	private void playSoundEffect(String filePath) {
	    try {
	        // Use getResource to load the file from the classpath
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Main.class.getResource(filePath));
	
	        // Convert the audio format to a supported format
	        AudioFormat baseFormat = audioInputStream.getFormat();
	        AudioFormat decodedFormat = new AudioFormat(
	            AudioFormat.Encoding.PCM_SIGNED,
	            baseFormat.getSampleRate(),
	            16,
	            baseFormat.getChannels(),
	            baseFormat.getChannels() * 2,
	            baseFormat.getSampleRate(),
	            false
	        );
	        AudioInputStream decodedAudioInputStream = AudioSystem.getAudioInputStream(decodedFormat, audioInputStream);
	
	        Clip soundClip = AudioSystem.getClip();
	        soundClip.open(decodedAudioInputStream);
	        soundClip.start();
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}


	
	private void stopSong() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    @Override
    public void dispose() {
        stopSong();
        super.dispose();
    }
}
