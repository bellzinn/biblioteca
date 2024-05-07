package interfaceGUI;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    public TelaInicial() {
        // Configurações da janela
        setTitle("Sistema de Biblioteca");
        setSize(781, 338);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        getContentPane().setLayout(new GridLayout(3, 1));

        // Botão para "Consultar Historico"
        JButton btnConsultarHistorico = new JButton("Consultar Histórico");
        btnConsultarHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // historico de emprestimo :/
                
            }
        });
        getContentPane().add(btnConsultarHistorico);

        // Botão paraa "Buscar Livro"
        JButton btnBuscarLivro = new JButton("Buscar Livro");
        btnBuscarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // buscar todos os livros
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                
                        TelaLivros telaLivros = new TelaLivros();
                        telaLivros.setVisible(true);
                    
                    }
                });
            }
        });
        getContentPane().add(btnBuscarLivro);

        // Botão para "sair"
        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(btnSair);
    }
}