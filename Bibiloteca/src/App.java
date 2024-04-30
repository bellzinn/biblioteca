import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import DAO.UsuarioDAO;
import biblioteca.modelo.Usuario;
import interfaceGUI.TelaInicial;
import interfaceGUI.TelaInicialAdmin;


public class App extends JFrame{
	
    
	private static final long serialVersionUID = 1L;
	private JTextField emailTextField;
    private JPasswordField senhaPasswordField;

    public App() {
    	
    	 
        super("Tela de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Layout
        getContentPane().setLayout(new GridLayout(3, 2));

        // Componentes
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();

        JLabel senhaLabel = new JLabel("Senha:");
        senhaPasswordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarLogin();
            }
        });

        // Adicionando componentes ao layout
        getContentPane().add(emailLabel);
        getContentPane().add(emailTextField);
        getContentPane().add(senhaLabel);
        getContentPane().add(senhaPasswordField);
        getContentPane().add(new JLabel()); // Espaço vazio para alinhar o botão com os campos
        getContentPane().add(loginButton);

        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
       

    }

    public void realizarLogin() {
        String email = emailTextField.getText();
        String senha = new String(senhaPasswordField.getPassword());

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioLogado = usuarioDAO.login(email, senha);


        if (usuarioLogado != null) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");

            if (usuarioLogado.getIsAdmin() == 1) {
                JOptionPane.showMessageDialog(this, "Usuário é um administrador.");
                dispose();
                
                TelaInicialAdmin telaInicialadmin = new TelaInicialAdmin();
                telaInicialadmin.setVisible(true);
               
               

            } else {
                JOptionPane.showMessageDialog(this, "Usuário não é um administrador.");
                dispose();
                
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);

                
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha incorretos. Falha no login.");
            
        }
    }
	
  
    public static void main(String[] args) {
    	
    	//tela de login
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
    
     
}
