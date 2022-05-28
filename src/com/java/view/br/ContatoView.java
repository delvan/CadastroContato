package com.java.view.br;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ContatoView {

	private JFrame frame;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtEmail;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContatoView window = new ContatoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContatoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 975, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome: ");
		lblNewLabel.setBounds(20, 152, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(54, 149, 177, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Idade: ");
		lblNewLabel_1.setBounds(20, 180, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		txtIdade = new JTextField();
		txtIdade.setBounds(54, 177, 46, 20);
		frame.getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setBounds(20, 212, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		txtEmail = new JTextField();
		txtEmail.setBounds(54, 209, 177, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(315, 103, 569, 289);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		Object[] columns = { "Id", "Nome", "Idade", "E-mail" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = table.getSelectedRow();

				txtId.setText(model.getValueAt(i, 0).toString());
				txtNome.setText(model.getValueAt(i, 1).toString());
				txtIdade.setText(model.getValueAt(i, 2).toString());
				txtEmail.setText(model.getValueAt(i, 3).toString());

			}
		});

		scrollPane.setViewportView(table);

		Object[] row = new Object[4];
		JButton btnAdd = new JButton("ADICIONAR");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Contato contato = new Contato();

				row[0] = txtId.getText();
				row[1] = txtNome.getText();
				row[2] = txtIdade.getText();
				row[3] = txtEmail.getText();

				model.addRow(row);

			}
		});

		btnAdd.setBounds(20, 314, 104, 23);
		frame.getContentPane().add(btnAdd);

		JButton btnUpdate = new JButton("ATUALIZAR");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();

				if (i >= 0) {
					model.setValueAt(txtId.getText(), i, 0);
					model.setValueAt(txtNome.getText(), i, 1);
					model.setValueAt(txtIdade.getText(), i, 2);
					model.setValueAt(txtEmail.getText(), i, 3);

				} else {
					System.out.println("Update error");
				}
			}
		});
		btnUpdate.setBounds(150, 314, 110, 23);
		frame.getContentPane().add(btnUpdate);

		JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
				} else {
					System.out.println("Erro ao deletar");
				}
			}
		});
		btnNewButton_1.setBounds(20, 369, 104, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnClear = new JButton("New button");
		btnClear.setBounds(150, 369, 110, 23);
		frame.getContentPane().add(btnClear);

		JLabel lblNewLabel_3 = new JLabel("Cadastro Contato");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 38));
		lblNewLabel_3.setBounds(260, 24, 397, 39);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Id:");
		lblNewLabel_4.setBounds(20, 124, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);

		txtId = new JTextField();
		txtId.setBounds(54, 121, 46, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);

	}
}
