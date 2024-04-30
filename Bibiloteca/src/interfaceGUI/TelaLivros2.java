package interfaceGUI;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import DAO.LivroDAO;
import biblioteca.modelo.Livro;

public class TelaLivros2 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea textAreaLivros;

	public TelaLivros2() {
        setTitle("Lista de Livros");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        textAreaLivros = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaLivros);

        JButton btnEmprestimo = new JButton("Atualizar livro");
        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Executar a tela de atualização
                SwingUtilities.invokeLater(new Runnable() {
                    
                    public void run() {
                        new TelaAtualizacaoLivro();
                    }
                });
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnEmprestimo, BorderLayout.SOUTH);

        add(panel);
        carregarLivros();
    }

    private void carregarLivros() {
        List<Livro> livros = listarLivros();
        StringBuilder sb = new StringBuilder();

        for (Livro livro : livros) {
            sb.append("ID: ").append(livro.getIdlivro()).append("\n");
            sb.append("Título: ").append(livro.getTitulo()).append("\n");
            sb.append("Autor: ").append(livro.getAutor()).append("\n");
            sb.append("Gênero: ").append(livro.getGenero()).append("\n");
            sb.append("Idioma: ").append(livro.getIdioma()).append("\n");
            sb.append("-------------------------").append("\n\n");
        }

        textAreaLivros.setText(sb.toString());
    }

    

    
    private List<Livro> listarLivros() {
        return LivroDAO.listarLivros(); 
    }

    
}
