package ru.inc.main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame{
	private JTable table;
	private PersonModel model;

	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(640, 480);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 16, 452, 392);
		getContentPane().add(scrollPane);
		
		model = new PersonModel();
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Person person = new Person();
				person.setName(JOptionPane.showInputDialog("Enter name:"));
				person.setSurname(JOptionPane.showInputDialog("Enter surname:"));
				Main.persons.add(person);
				table.updateUI();
			}
		});
		btnAdd.setBounds(488, 16, 115, 29);
		getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() == -1 || Main.persons.size() == 0) {return;}
				Main.persons.remove(table.getSelectedRow());
				table.updateUI();
			}
		});
		btnRemove.setBounds(488, 61, 115, 29);
		getContentPane().add(btnRemove);
		
		setVisible(true);
	}
}
