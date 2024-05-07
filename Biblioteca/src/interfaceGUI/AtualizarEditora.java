package interfaceGUI;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.EditoraDAO;
import biblioteca.modelo.Editora;

public class AtualizarEditora extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JTextField idEditoraField;
    private JTextField novoNomeField;
    private JButton atualizarButton;

    public AtualizarEditora() {
        setTitle("Atualizar Editora");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addComponents();
        addListeners();
    }

    private void initComponents() {
        idEditoraField = new JTextField(10);
        novoNomeField = new JTextField(20);
        atualizarButton = new JButton("Atualizar");
    }

    private void addComponents() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("ID da Editora:"));
        add(idEditoraField);

        add(new JLabel("Novo Nome:"));
        add(novoNomeField);

        add(new JLabel());
        add(atualizarButton);
    }

    private void addListeners() {
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarEditora();
            }
        });
    }

    private void atualizarEditora() {
        int idEditora = Integer.parseInt(idEditoraField.getText());
        String novoNome = novoNomeField.getText();

        Editora editora = new Editora();
        editora.setIdEditora(idEditora);
        editora.setNome(novoNome);

        new EditoraDAO().atualizarEditora(editora);

        JOptionPane.showMessageDialog(this, "Editora atualizada com sucesso!");
        clearFields();
    }

    private void clearFields() {
        idEditoraField.setText("");
        novoNomeField.setText("");
    }

}