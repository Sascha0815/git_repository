package git_abtra;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Oberflaeche extends JFrame {

	// Swing-Elemente

	private static final long serialVersionUID = 1L;

	public static JFrame frame = new JFrame();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuNew = new JMenu();
	private JMenu menuHelp = new JMenu();
	private JMenu menuSettings = new JMenu();

	private JMenuItem itemApplicant = new JMenuItem();
	private JMenuItem itemJob = new JMenuItem();
	private JMenuItem itemAbout = new JMenuItem();
	private JMenuItem itemExit = new JMenuItem();
	private JMenuItem itemChangeDesign = new JMenuItem();

	private JTabbedPane tabBar = new JTabbedPane(JTabbedPane.TOP,
			JTabbedPane.SCROLL_TAB_LAYOUT);

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panelButton1 = new JPanel();
	private JPanel panelContent1 = new JPanel();
	private JPanel panelInfo1 = new JPanel();
	private JPanel panelButton2 = new JPanel();
	private JPanel panelContent2 = new JPanel();
	private JPanel panelInfo2 = new JPanel();
	private JPanel panelButton3 = new JPanel();
	private JPanel panelContent3 = new JPanel();
	private JPanel panelInfo3 = new JPanel();
	private JPanel panelButton4 = new JPanel();
	private JPanel panelContent4 = new JPanel();
	private JPanel panelInfo4 = new JPanel();

	private JButton buttonAdd = new JButton();
	private JButton buttonDelete = new JButton();
	private JButton buttonEdit = new JButton();
	private JButton buttonSettings = new JButton();
	private JButton buttonJob = new JButton();
	private JButton buttonExit = new JButton();
	private JButton buttonRefreshApplicant = new JButton();
	private JButton buttonRefreshJob = new JButton();

	private DefaultTableModel modelPool = new DefaultTableModel(1, 4) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private DefaultTableModel modelJob = new DefaultTableModel(1, 4) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	private JTable tableJob = new JTable(modelJob);
	private JTable tableApplicant = new JTable();

	private JLabel labelApplicantPic = new JLabel();
	private JLabel labelBackground = new JLabel();
	public static JButton save = new JButton("Speichern");

	// Datentypen

	public String name;
	public String firstName;
	public String street;
	public long houseNr;
	public long postalCode;

	// Objekte

	final Datenbank datenbank = new Datenbank();
	final public static Steuerung steuerung = new Steuerung();

	public final static Vector COLUMN_IDENTIFIERS_APPLICANT = new Vector() {
		{
			add("Name");
			add("Vorname");
			add("Straße");
			add("Hausnummer");
			add("PLZ");
			add("Wohnort");
		}
	};

	public final static Vector COLUMN_IDENTIFIERS_JOB = new Vector() {
		{
			add("Name");
			add("Vorname");
			add("Straße");
			add("Hausnummer");
			add("PLZ");
			add("Wohnort");
		}
	};

	public Oberflaeche(String title) {

		// SWING: Frame
		super(title);
		frame.setSize(1200, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setTitle("Bewerberverwaltung");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);

		// SWING: Panel1
		panel1.setLayout(new BorderLayout(5, 5));
		panel1.add(panelButton1, BorderLayout.EAST);
		panel1.add(panelContent1, BorderLayout.CENTER);
		panelContent1.add(labelApplicantPic);
		labelApplicantPic.setPreferredSize(new Dimension(135, 135));
		panel1.add(panelInfo1, BorderLayout.SOUTH);
		panelButton1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton1.setBackground(Color.LIGHT_GRAY);
		panelButton1.setPreferredSize(new Dimension(150, 0));
		panelContent1.setBackground(Color.LIGHT_GRAY);
		panelInfo1.setBackground(Color.LIGHT_GRAY);
		panelInfo1.setPreferredSize(new Dimension(0, 20));
		try {
			Image applicant = ImageIO.read(getClass().getResource(
					"resources/applicant.png"));
			labelApplicantPic.setIcon(new ImageIcon(applicant));
		} catch (IOException ex) {
		}

		// SWING: Panel2
		panel2.setLayout(new BorderLayout(5, 5));
		panel2.add(panelButton2, BorderLayout.EAST);
		panel2.add(panelContent2, BorderLayout.CENTER);
		panel2.add(panelInfo2, BorderLayout.SOUTH);
		panelButton2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton2.setBackground(Color.LIGHT_GRAY);
		panelButton2.setPreferredSize(new Dimension(150, 0));
		panelContent2.setBackground(Color.LIGHT_GRAY);
		panelInfo2.setBackground(Color.LIGHT_GRAY);
		panelInfo2.setPreferredSize(new Dimension(0, 20));
		buttonRefreshApplicant.setToolTipText("Tabelle aktualisieren");
		panelButton2.add(buttonRefreshApplicant);
		buttonRefreshApplicant.setPreferredSize(new Dimension(135, 135));
		try {
			Image refreshApplicant = ImageIO.read(getClass().getResource(
					"resources/refreshApplicant.png"));
			buttonRefreshApplicant.setIcon(new ImageIcon(refreshApplicant));
		} catch (IOException ex) {
		}
		buttonRefreshApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector results = datenbank.insertDataIntoTable();
				modelPool.setDataVector(results, COLUMN_IDENTIFIERS_APPLICANT);
				modelPool.fireTableDataChanged();
			}
		});
		buttonAdd.setToolTipText("Neuer Bewerber hinzufügen");
		panelButton2.add(buttonAdd);
		buttonAdd.setPreferredSize(new Dimension(135, 135));
		try {
			Image add = ImageIO.read(getClass()
					.getResource("resources/add.png"));
			buttonAdd.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				steuerung.dialogAddApplicant();
			}
		});
		buttonEdit.setToolTipText("Bewerber bearbeiten");
		panelButton2.add(buttonEdit);
		buttonEdit.setPreferredSize(new Dimension(135, 135));
		try {
			Image pencil = ImageIO.read(getClass().getResource(
					"resources/pencil.png"));
			buttonEdit.setIcon(new ImageIcon(pencil));
		} catch (IOException ex) {
		}
		buttonDelete.setToolTipText("Bewerber löschen");
		panelButton2.add(buttonDelete);
		buttonDelete.setPreferredSize(new Dimension(135, 135));
		try {
			Image trashcan = ImageIO.read(getClass().getResource(
					"resources/trashcan.png"));
			buttonDelete.setIcon(new ImageIcon(trashcan));
		} catch (IOException ex) {
		}
		buttonSettings.setToolTipText("Eisntellungen");
		panelButton2.add(buttonSettings);
		buttonSettings.setPreferredSize(new Dimension(135, 135));
		try {
			Image settings = ImageIO.read(getClass().getResource(
					"resources/settings_big.png"));
			buttonSettings.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		buttonExit.setToolTipText("Programm schließen");
		panelButton2.add(buttonExit);
		buttonExit.setPreferredSize(new Dimension(135, 135));
		try {
			Image close = ImageIO.read(getClass().getResource(
					"resources/close_big.png"));
			buttonExit.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
			}
		});

		// SWING: Panel3
		panel3.setLayout(new BorderLayout(5, 5));
		panel3.add(panelButton3, BorderLayout.EAST);
		panel3.add(panelContent3, BorderLayout.CENTER);
		panel3.add(panelInfo3, BorderLayout.SOUTH);
		panelButton3.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton3.setBackground(Color.LIGHT_GRAY);
		panelButton3.setPreferredSize(new Dimension(150, 0));
		panelContent3.setBackground(Color.LIGHT_GRAY);
		panelInfo3.setBackground(Color.LIGHT_GRAY);
		panelInfo3.setPreferredSize(new Dimension(0, 20));
		buttonRefreshJob.setToolTipText("Tabelle aktualisieren");
		panelButton3.add(buttonRefreshJob);
		buttonRefreshJob.setPreferredSize(new Dimension(135, 135));
		buttonRefreshJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		try {
			Image add = ImageIO.read(getClass().getResource(
					"resources/refreshApplicant.png"));
			buttonRefreshJob.setIcon(new ImageIcon(add));
		} catch (IOException ex) {
		}
		buttonJob.setToolTipText("Neue Arbeitstelle hinzufügen");
		panelButton3.add(buttonJob);
		buttonJob.setPreferredSize(new Dimension(135, 135));
		buttonJob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				steuerung.dialogAddVacancy();
			}
		});
		try {
			Image job = ImageIO.read(getClass().getResource(
					"resources/job_small.png"));
			itemJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}
		try {
			Image job = ImageIO.read(getClass()
					.getResource("resources/job.png"));
			buttonJob.setIcon(new ImageIcon(job));
		} catch (IOException ex) {
		}

		// SWING: Panel4
		panel4.setLayout(new BorderLayout(5, 5));
		panel4.add(panelButton4, BorderLayout.EAST);
		panel4.add(panelContent4, BorderLayout.CENTER);
		panel4.add(panelInfo4, BorderLayout.SOUTH);
		panelButton4.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		panelButton4.setBackground(Color.LIGHT_GRAY);
		panelButton4.setPreferredSize(new Dimension(150, 0));
		panelContent4.setBackground(Color.LIGHT_GRAY);
		panelInfo4.setBackground(Color.LIGHT_GRAY);
		panelInfo4.setPreferredSize(new Dimension(0, 20));

		// SWING: MenuBar
		frame.setJMenuBar(menuBar);
		itemApplicant.setText("Neuer Bewerber");
		itemAbout.setText("Über");
		itemJob.setText("Neues Stellenangebot");
		itemExit.setText("Beenden");
		itemChangeDesign.setText("Desgin ändern");
		menuBar.add(menuNew);
		menuNew.setText("Neu");
		menuNew.add(itemApplicant);
		menuNew.add(itemJob);
		menuNew.add(itemExit);
		menuBar.add(menuSettings);
		menuSettings.setText("Einstellungen");
		menuSettings.add(itemChangeDesign);
		menuBar.add(menuHelp);
		menuHelp.setText("Hilfe");
		menuHelp.add(itemAbout);
		try {
			Image close = ImageIO.read(getClass().getResource(
					"resources/close.png"));
			itemExit.setIcon(new ImageIcon(close));
		} catch (IOException ex) {
		}
		try {
			Image plus = ImageIO.read(getClass().getResource(
					"resources/plus.png"));
			itemApplicant.setIcon(new ImageIcon(plus));
		} catch (IOException ex) {
		}
		try {
			Image settings = ImageIO.read(getClass().getResource(
					"resources/settings.png"));
			itemChangeDesign.setIcon(new ImageIcon(settings));
		} catch (IOException ex) {
		}
		try {
			Image about = ImageIO.read(getClass().getResource(
					"resources/about.png"));
			itemAbout.setIcon(new ImageIcon(about));
		} catch (IOException ex) {
		}

		itemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		itemApplicant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				steuerung.dialogAddApplicant();
			}
		});

		// SWING: TabbedPane
		frame.add(tabBar);
		tabBar.addTab("Übersicht", panel1);
		tabBar.addTab("Bewerber", panel2);
		tabBar.addTab("Arbeitsstellen", panel3);

		// SWING: Table Bewerberpool
		modelPool.setColumnIdentifiers(COLUMN_IDENTIFIERS_APPLICANT);
		tableApplicant.getTableHeader().setReorderingAllowed(false);
		tableApplicant = new JTable(modelPool);
		tableApplicant.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				tableApplicant = (JTable) e.getSource();
				int column = tableApplicant.getSelectedColumn();
				System.out.println(column);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JScrollPane scrollPanePool = new JScrollPane(tableApplicant);
		panelContent2.add(scrollPanePool);
		scrollPanePool.setPreferredSize(new Dimension(
				panelContent2.getSize().width - 20,
				panelContent2.getSize().height - 20));
		scrollPanePool
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanePool
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// SWING:Table Arbeitsstellen
		modelJob.setColumnIdentifiers(COLUMN_IDENTIFIERS_JOB);
		tableJob.getTableHeader().setReorderingAllowed(false);
		tableJob = new JTable(modelJob);
		tableJob.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				tableApplicant = (JTable) e.getSource();
				int column = tableApplicant.getSelectedColumn();
				System.out.println(column);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JScrollPane scrollPaneJob = new JScrollPane(tableJob);
		panelContent3.add(scrollPaneJob);
		scrollPaneJob.setPreferredSize(new Dimension(
				panelContent3.getSize().width - 20,
				panelContent3.getSize().height - 15));
		scrollPaneJob
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneJob
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				steuerung.controlInput();
				try {
					datenbank.insertDataIntoDatabase();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				steuerung.closeDialogAddApplicant();
			}

		});
	}
}
