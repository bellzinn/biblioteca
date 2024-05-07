package interfaceGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.UsuarioDAO;
import biblioteca.modelo.Usuario;

public class TelaCadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldTelefone;
    private JTextField textFieldSenha;
    private JCheckBox checkBoxAdmin;

    public TelaCadastroUsuario() {
        // Configurações básicas do frame
        setTitle("Cadastro de Usuário");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adiciona componentes ao painel
        panel.add(new JLabel("Nome de Usuário:"));
        textFieldNome = new JTextField();
        panel.add(textFieldNome);

        panel.add(new JLabel("Email:"));
        textFieldEmail = new JTextField();
        panel.add(textFieldEmail);

        panel.add(new JLabel("Telefone:"));
        textFieldTelefone = new JTextField();
        panel.add(textFieldTelefone);

        panel.add(new JLabel("Senha:"));
        textFieldSenha = new JTextField();
        panel.add(textFieldSenha);

        checkBoxAdmin = new JCheckBox("Administrador");
        panel.add(checkBoxAdmin);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
        panel.add(btnCadastrar);

        // Adiciona o painel ao frame
        getContentPane().add(panel);

    }

    private void cadastrarUsuario() {
        String nomeUsuario = textFieldNome.getText();
        String email = textFieldEmail.getText();
        long telefone = Long.parseLong(textFieldTelefone.getText());
        String senha = textFieldSenha.getText();
        int isAdmin = checkBoxAdmin.isSelected() ? 1 : 0;

        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setEmail(email);
        usuario.setTelefone(telefone);
        usuario.setSenha(senha);
        usuario.setIsAdmin(isAdmin);

        new UsuarioDAO().cadastrarUsuario(usuario);

        // Limpa os campos após o cadastro
        textFieldNome.setText("");
        textFieldEmail.setText("");
        textFieldTelefone.setText("");
        textFieldSenha.setText("");
        checkBoxAdmin.setSelected(false);
    }
} 