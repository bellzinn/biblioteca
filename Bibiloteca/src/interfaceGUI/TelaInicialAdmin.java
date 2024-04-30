package interfaceGUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import DAO.UsuarioDAO;
import biblioteca.modelo.Usuario;

public class TelaInicialAdmin extends JFrame {
	
	private static final long serialVersionUID = 1L;

    public TelaInicialAdmin() {
        super("Sistema de Biblioteca - Administrador");

        // Configurações básicas da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(919, 342);
        setLocationRelativeTo(null);
        JButton btnVerificarCadastro = new JButton("Usuarios Cadastrados");
        btnVerificarCadastro.setBounds(308, 104, 259, 32);
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.setBounds(308, 146, 259, 32);
        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        btnCadastrarLivro.setBounds(308, 232, 259, 32);
        JButton btnCadastrarEditora = new JButton("Cadastrar Editora");
        btnCadastrarEditora.setBounds(308, 62, 259, 32);
        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(396, 274, 79, 21);
        
        JButton btnMostrarTodosLivros = new JButton("Livros");
        btnMostrarTodosLivros.setBounds(308, 190, 259, 32);
        getContentPane().add(btnMostrarTodosLivros);
                getContentPane().setLayout(null);
        
                // Botões
                JButton btnConsultarHistorico = new JButton("Editoras");
                btnConsultarHistorico.setBounds(308, 20, 259, 32);
                
                        // Adiciona os botões à janela
                        getContentPane().add(btnConsultarHistorico);
                        
                                
                                btnConsultarHistorico.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        
                                    	SwingUtilities.invokeLater(new Runnable() {
                                            @Override
                                            public void run() {
                                        
                                                TelaEditoras telaEditoras = new TelaEditoras();
                                                telaEditoras.setVisible(true);
                                            
                                            }
                                        });
                                      
                                    }
                                });
        getContentPane().add(btnVerificarCadastro);
        getContentPane().add(btnCadastrarUsuario);
        getContentPane().add(btnCadastrarLivro);
        getContentPane().add(btnCadastrarEditora);
        getContentPane().add(btnSair);

        btnVerificarCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                SwingUtilities.invokeLater(() -> {
                    List<Usuario> usuarios = new UsuarioDAO().ObterTodosUsuarios();
                    TelaUsuarios tela = new TelaUsuarios(usuarios);
                    tela.setVisible(true);
                });
            }
        });
        
        
        

        btnCadastrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	 SwingUtilities.invokeLater(new Runnable() {
                     public void run() {
                         new TelaCadastroUsuario().setVisible(true);
                     }
                 });
            }
        });

        btnCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                TelaCadastroLivro telacadastrolivro = new TelaCadastroLivro();
                telacadastrolivro.setVisible(true);
            }
        });

        btnCadastrarEditora.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                SwingUtilities.invokeLater(() -> TelaCadastroEditora.createAndShowGUI());
                
                
            }
        });
        
        btnMostrarTodosLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	 // buscar todos os livros
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                
                        TelaLivros2 telaLivros2 = new TelaLivros2();
                        telaLivros2.setVisible(true);
                    
                    }
                });
            }
        });

        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

   
}