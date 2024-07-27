import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;

public class FenetrePricipale {

	private JFrame frame;
	PanneauDessin z_dessin = new PanneauDessin();
	static JLabel lblHauteur = new JLabel("Hauteur :");
	static JLabel lblLongueur = new JLabel("Longueur :");
	static JLabel lblLargeur = new JLabel("Largeur :");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatIntelliJLaf());

		} catch (Exception e) {
			System.out.println("Echec de chargement de ce theme");
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FenetrePricipale window = new FenetrePricipale();
				window.frame.setVisible(true);
			}
		});

	}

	/**
	 * Create the application.
	 */
	public FenetrePricipale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Geometrie f = new Geometrie();
		JSpinner longueur = new JSpinner();
		longueur.setModel(new SpinnerNumberModel(100, 100, 900, 1));
		JSpinner largeur = new JSpinner();
		largeur.setModel(new SpinnerNumberModel(100, 100, 900, 1));

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);

		JPanel panel_2 = new JPanel();

		JButton btnNouveau = new JButton("");
		btnNouveau.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Create New-24.png")));

		JButton btnOuvrir = new JButton("");
		btnOuvrir.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Add Image.png")));

		JButton btnEnregistrer = new JButton("");
		btnEnregistrer.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Save-24.png")));

		JButton btnAvancer = new JButton("");
		btnAvancer.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Redo-24.png")));

		JButton btnNewButton_5 = new JButton("Avancer");

		JLabel lblNewLabel_8 = new JLabel("DESIGN FORM");
		lblNewLabel_8.setFont(new Font("Yu Gothic Light", Font.PLAIN, 16));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);

		JButton btnReculer = new JButton("");
		btnReculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.previous();
			}
		});
		btnReculer.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Undo-24.png")));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(6)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false).addGroup(gl_panel_2
						.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNouveau, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE).addGap(12)
						.addComponent(btnOuvrir, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
						.addComponent(btnEnregistrer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnReculer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnAvancer, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup().addGap(156).addComponent(btnNewButton_5)))
				.addGap(167)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup()
				.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_8, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnOuvrir, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnEnregistrer, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(btnAvancer, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnReculer, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnNouveau, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
				.addGap(18).addComponent(btnNewButton_5)));
		panel_2.setLayout(gl_panel_2);

		btnAvancer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.next();
			}
		});
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.EnregistrerImage();

			}
		});
		
		btnOuvrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					z_dessin.OuvrirImage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNouveau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.nettoyer();

			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 622, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup().addGap(6)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)));

		JPanel z_config = new JPanel();

//		JPanel z_dessin = new JPanel();
		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addComponent(z_config, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(z_dessin, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addComponent(z_dessin, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
				.addComponent(z_config, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE));
		JLabel lblPositionX = new JLabel("X : ");
		JLabel lblPositionY = new JLabel("Y : ");

		lblLargeur.setBounds(6, 6, 83, 16);
		panel_1.add(lblLargeur);

		lblLongueur.setBounds(93, 6, 104, 16);
		panel_1.add(lblLongueur);

		lblHauteur.setBounds(199, 6, 86, 16);
		panel_1.add(lblHauteur);

		lblPositionY.setBounds(349, 6, 40, 16);
		panel_1.add(lblPositionY);

		lblPositionX.setBounds(297, 6, 40, 16);
		panel_1.add(lblPositionX);

		JRadioButton rdbtnGenAuto = new JRadioButton("Gén. Automatique");
		rdbtnGenAuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (rdbtnGenAuto.isSelected()) {
					z_dessin.setFormeG("GenererMaisonAuto");
					z_dessin.repaint();
				} else {
					z_dessin.setFormeG("GenererMaison");
					z_dessin.repaint();
				}
			}
		});

		z_dessin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblPositionX.setText("X : " + e.getX());
				lblPositionY.setText("Y : " + e.getY());
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				lblPositionX.setText("X : " + e.getX());
				lblPositionY.setText("Y : " + e.getY());
				if (f instanceof Geometrie) {
					f.setWidth(e.getX() - f.getX());
					f.setHeight(e.getY() - f.getY());
					if (z_dessin.getFormeG() == "GenererMaisonAuto") {
						lblHauteur.setText("Hauteur : " + f.getHauteurM());

						lblLongueur.setText("Longueur : " + f.getLargeurM());
					} else {
						lblLargeur.setText("Largeur : " + f.getHauteurM());
						lblLongueur.setText("Longueur : " + f.getLargeurM());
					}
				}
			}
		});
		panel_1.setLayout(null);

		JButton btnManuelle = new JButton();
		btnManuelle.setBounds(4, 28, 48, 28);
		btnManuelle.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Pencil-24.png")));
		btnManuelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("trace_manuelle");
				z_dessin.setTailleFG(3);
				z_dessin.setColFore(Color.BLUE);
				z_dessin.repaint();
			}
		});

		JButton btnCercleV = new JButton();
		btnCercleV.setBounds(4, 91, 48, 28);
		btnCercleV.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Circled.png")));
		btnCercleV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceCercleV");
				;
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnTriangleV = new JButton();
		btnTriangleV.setBounds(4, 120, 48, 28);
		btnTriangleV.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Triangle-24.png")));
		btnTriangleV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceTriangleV");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnRectV = new JButton();
		btnRectV.setBounds(4, 60, 48, 28);
		btnRectV.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icone/icons8-rectangle-24.png")));
		btnRectV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceRectangleV");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnGenHome = new JButton("Valider ");
		btnGenHome.setBounds(6, 335, 122, 21);
		btnGenHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGenAuto.isSelected()) {
					z_dessin.setFormeG("GenererMaisonAuto");
					z_dessin.repaint();
				} else {
					z_dessin.setLargeur((int)largeur.getValue());
					z_dessin.setHauteur((int)longueur.getValue());
					z_dessin.setFormeG("GenererMaison");

					z_dessin.repaint();
				}

			}
		});

		JButton btnPolygoneV = new JButton();
		btnPolygoneV.setBounds(4, 150, 48, 28);
		btnPolygoneV.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Hexagon-24.png")));
		btnPolygoneV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("tracePolygoneV");
				;
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnForeground = new JButton();
		btnForeground.setBounds(6, 380, 52, 30);
		btnForeground.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icone/icons8-color-swatch-48.png")));
		btnForeground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(z_dessin, "Choisissez la couleur de lq fenetre", Color.white);
				z_dessin.setColFore(newColor);
				z_dessin.setOpaque(true);
				z_dessin.repaint();
				btnForeground.setBackground(newColor);
			}
		});
		btnForeground.setBackground(UIManager.getColor("CheckBox.foreground"));

		JButton btnLigne = new JButton("");
		btnLigne.setBounds(78, 28, 48, 28);
		btnLigne.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Line-24.png")));
		btnLigne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("trace_ligne");
				;
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnRectP = new JButton();
		btnRectP.setBounds(78, 60, 48, 28);
		btnRectP.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Rounded Rectangle-24.png")));
		btnRectP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceRectangleP");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnCercleP = new JButton("");
		btnCercleP.setBounds(79, 91, 47, 28);
		btnCercleP.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Ellipse-24.png")));
		btnCercleP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceCercleP");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnTriangleP = new JButton("");
		btnTriangleP.setBounds(78, 120, 48, 28);
		btnTriangleP.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Flip Vertical-24.png")));
		btnTriangleP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("traceTriangleP");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnPolygoneP = new JButton("");
		btnPolygoneP.setBounds(78, 150, 48, 28);
		btnPolygoneP.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Octagon-24.png")));
		btnPolygoneP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.setFormeG("tracePolygoneP");
				z_dessin.getTailleFG();
				z_dessin.getColFore();
				z_dessin.repaint();
			}
		});

		JButton btnBackground = new JButton("");
		btnBackground.setBounds(79, 380, 49, 30);
		btnBackground.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Fill Color-24.png")));
		btnBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(z_dessin, "Choisissez la couleur de lq fenetre", Color.white);
				z_dessin.setColBack(newColor);
				z_dessin.getColBack();
				z_dessin.setOpaque(true);
				z_dessin.repaint();
				btnBackground.setBackground(newColor);
			}
		});
		btnBackground.setBackground(new Color(255, 255, 255));

		JSlider sliderTaille = new JSlider();
		sliderTaille.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				z_dessin.setTailleFG(sliderTaille.getValue());
			}
		});
		sliderTaille.setSnapToTicks(true);
		sliderTaille.setMaximum(20);
		sliderTaille.setMinimum(1);
		sliderTaille.setValue(1);
		sliderTaille.setPaintTicks(true);
		sliderTaille.setPaintLabels(true);
		sliderTaille.setMajorTickSpacing(20);
		sliderTaille.setMinorTickSpacing(1);
		sliderTaille.setBounds(6, 422, 122, 35);

		JLabel lblNewLabel = new JLabel("Forme Geometrique");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 115, 21);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));

		JLabel lblNewLabel_1 = new JLabel("Largeur");
		lblNewLabel_1.setBounds(4, 202, 51, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("Longueur");
		lblNewLabel_2.setBounds(77, 202, 54, 16);
		z_config.setLayout(null);
		z_config.add(lblNewLabel);
		z_config.add(btnManuelle);
		z_config.add(btnLigne);
		z_config.add(btnRectV);
		z_config.add(btnRectP);
		z_config.add(btnCercleV);
		z_config.add(btnCercleP);
		z_config.add(btnTriangleV);
		z_config.add(btnTriangleP);
		z_config.add(btnPolygoneV);
		z_config.add(btnPolygoneP);
		z_config.add(btnGenHome);
		z_config.add(sliderTaille);
		z_config.add(btnForeground);
		z_config.add(lblNewLabel_1);
		z_config.add(lblNewLabel_2);
		z_config.add(btnBackground);

		largeur.setBounds(5, 215, 60, 21);
		z_config.add(largeur);

		longueur.setBounds(67, 215, 60, 21);
		z_config.add(longueur);

		rdbtnGenAuto.setBounds(6, 313, 120, 18);
		z_config.add(rdbtnGenAuto);

		JLabel lblNewLabel_7 = new JLabel("Générer un maison");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(6, 183, 110, 16);
		z_config.add(lblNewLabel_7);

		JButton btnForeground_1 = new JButton();
		btnForeground_1.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Fill Color-24.png")));
		btnForeground_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(z_dessin, "Choisissez la couleur de la fenetre", Color.white);
				z_dessin.setColT(newColor);
				btnForeground_1.setBackground(newColor);
			}
		});
		btnForeground_1.setBackground(UIManager.getColor("Objects.YellowDark"));
		btnForeground_1.setBounds(6, 258, 46, 21);
		z_config.add(btnForeground_1);

		JButton btnBackground_1 = new JButton("");
		btnBackground_1.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Fill Color-24.png")));
		btnBackground_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(z_dessin, "Choisissez la couleur de la fenetre", Color.white);
				z_dessin.setColP(newColor);
				btnBackground_1.setBackground(newColor);
			}
		});
		btnBackground_1.setBackground(UIManager.getColor("Button.background"));
		btnBackground_1.setBounds(78, 258, 43, 21);
		z_config.add(btnBackground_1);

		JLabel lblNewLabel_9 = new JLabel("Toles");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(6, 241, 38, 16);
		z_config.add(lblNewLabel_9);

		JButton btnBackground_1_1 = new JButton("");
		btnBackground_1_1.setIcon(new ImageIcon(FenetrePricipale.class.getResource("/icons/Fill Color-24.png")));
		btnBackground_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color newColor = JColorChooser.showDialog(z_dessin, "Choisissez la couleur", Color.white);
				z_dessin.setColM(newColor);
				btnBackground_1_1.setBackground(newColor);
			}
		});
		btnBackground_1_1.setBackground(UIManager.getColor("Actions.Blue"));
		btnBackground_1_1.setBounds(77, 291, 44, 21);
		z_config.add(btnBackground_1_1);

		JLabel lblNewLabel_9_1 = new JLabel("Mûrs ");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_1.setBounds(83, 274, 38, 16);
		z_config.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("Porte");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_2.setBounds(85, 241, 41, 16);
		z_config.add(lblNewLabel_9_2);

		JLabel lblNewLabel_9_3 = new JLabel("FColor");
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3.setBounds(6, 362, 52, 16);
		z_config.add(lblNewLabel_9_3);

		JLabel lblNewLabel_9_3_1 = new JLabel("BColor");
		lblNewLabel_9_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3_1.setBounds(78, 362, 52, 16);
		z_config.add(lblNewLabel_9_3_1);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("📂 Fichier");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Nouveau");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.nettoyer();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		 mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));


		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Ouvrir");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					z_dessin.OuvrirImage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);

		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sauvegarder");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				z_dessin.EnregistrerImage();
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_2);

		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Fermer");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
		JMenu mnNewMenu_1 = new JMenu("Éditer ");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Reculer");
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Avancer");
		mnNewMenu_1.add(mntmNewMenuItem_5);
	}
}
