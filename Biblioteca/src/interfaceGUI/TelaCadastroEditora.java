package interfaceGUI;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.EditoraDAO;
import biblioteca.modelo.Editora;

public class TelaCadastroEditora {
	private static JFrame frame;
	 
	 /**
	  * @wbp.parser.entryPoint
	  */
	 public static void createAndShowGUI() {
	        frame = new JFrame("Cadastro de Editora");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 884, 281);

	        JLabel idLabel = new JLabel("ID da Editora:");
	        idLabel.setBounds(10, 38, 405, 85);
	        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        JTextField idField = new JTextField();
	        idField.setBounds(206, 62, 668, 41);

	        JLabel nameLabel = new JLabel("Nome da Editora:");
	        nameLabel.setBounds(10, 126, 405, 85);
	        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        JTextField nameField = new JTextField();
	        nameField.setBounds(206, 150, 668, 41);
	        panel.setLayout(null);

	        panel.add(idLabel);
	        panel.add(idField);
	        panel.add(nameLabel);
	        panel.add(nameField);
	        frame.getContentPane().setLayout(null);

	        frame.getContentPane().add(panel);
	        
	        	        JButton cadastrarButton = new JButton("Cadastrar");
	        	        cadastrarButton.setBounds(169, 230, 367, 41);
	        	        panel.add(cadastrarButton);
	        	        cadastrarButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        	        
	        	        	        cadastrarButton.addActionListener(new ActionListener() {
	        	        	            @Override
	        	        	            public void actionPerformed(ActionEvent e) {
	        	        	                cadastrarEditoraFromSwing(Integer.parseInt(idField.getText()), nameField.getText());
	        	        	                JOptionPane.showMessageDialog(frame, "Editora cadastrada com sucesso!");
	        	        	                clearFields(idField, nameField);
	        	        	            }
	        	        	        });
	        frame.setSize(738, 318);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }

	    private static void cadastrarEditoraFromSwing(int id, String nome) {
	        Editora editora = new Editora();
	        editora.setIdEditora(id);
	        editora.setNome(nome);
	        new EditoraDAO().cadastrarEditora(editora);
	    }

	    private static void clearFields(JTextField... fields) {
	        for (JTextField field : fields) {
	            field.setText("");
	        }
	    }
	 
	 
	 
}