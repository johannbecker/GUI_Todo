package de.i3a.todo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
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
	
	public Todo() {
		
		this.setTitle("TODO-Liste");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		initComponents();
		initEvents();
		
		this.setVisible(true);		
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
				int i = JOptionPane.showConfirmDialog(Todo.this, "Wollen Sie wirlich beenden?", "Beenden?", JOptionPane.YES_NO_OPTION);
				if (i==JOptionPane.YES_OPTION) {
					System.exit(NORMAL);
				}
			}
			
		});
	}
	
	private void eingabe(){
		String eingabe = jtxtField.getText();
		jtxtArea.append(eingabe + "\n");
		jtxtField.setText("");
	}
}
