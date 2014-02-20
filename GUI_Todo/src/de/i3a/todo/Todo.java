package de.i3a.todo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Todo extends JFrame {

	private static final long serialVersionUID = 1L;
	private Container c;
	private JTextField jtxtField;
	private JTextArea jtxtArea;
	private JButton jbtnEintragen;
	private JPanel jpanel;
	private JScrollPane jscrollPane;
	private JMenuBar jmenu;
	private JMenuItem jmiSpeichern, jmiBeenden, jmiUeber;
	
	public Todo() {
		
		this.setTitle("TODO-Liste");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		createMenu();
		initComponents();
		initEvents();
		this.setJMenuBar(jmenu);
		this.setVisible(true);		
	}

	private void createMenu() {
		jmenu = new JMenuBar();
		
		JMenu jmenuDatei = new JMenu("Datei");
		JMenu jmenuHilfe = new JMenu("Hilfe");

		jmiSpeichern = new JMenuItem("Speichern");
		jmiBeenden = new JMenuItem("Beenden");
		jmiUeber = new JMenuItem("Über");

		jmenuDatei.add(jmiSpeichern);
		jmenuDatei.addSeparator();
		jmenuDatei.add(jmiBeenden);
		jmenuHilfe.add(jmiUeber);
		
		jmenu.add(jmenuDatei);
		jmenu.add(jmenuHilfe);
	}

	private void initComponents() {
		c = this.getContentPane();
		
		jtxtArea = new JTextArea();
		jscrollPane = new JScrollPane(jtxtArea);
		jtxtArea.setEditable(false);
		jtxtField = new JTextField(20);
		jbtnEintragen = new JButton("Eintragen");
		jpanel = new JPanel();
		jpanel.add(jtxtField);
		jpanel.add(jbtnEintragen);
		
		c.add(jscrollPane);
		c.add(jpanel, BorderLayout.PAGE_END);
	}

	private void initEvents() {
		
		jbtnEintragen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eingabe();
			}
		});
		
		jtxtField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eingabe();
			}
		});
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				beenden();
			}			
		});		
				
				
		jmiSpeichern.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Es wird gespeichert.");
			}
		});
		
		jmiBeenden.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();
			}

		});
		
		jmiUeber.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String infoText = "Version 0.0.1\nJohann Becker";
				JOptionPane.showMessageDialog(null, infoText);
			}
		});
	}
	
	private void beenden() {
		int i = JOptionPane.showConfirmDialog(Todo.this,
				"Wollen Sie wirlich beenden?", "Beenden?", JOptionPane.YES_NO_OPTION);
		if (i==JOptionPane.YES_OPTION) {
			System.exit(NORMAL);
		}
	}
	
	private void eingabe(){
		String eingabe = jtxtField.getText();
		jtxtArea.append(eingabe + "\n");
		jtxtField.setText("");
	}
}
