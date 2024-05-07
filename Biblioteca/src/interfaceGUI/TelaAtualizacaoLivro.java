package interfaceGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import DAO.LivroDAO;
import biblioteca.modelo.Livro;

public class TelaAtualizacaoLivro extends JFrame {

	    private static final long serialVersionUID = 1L;
	    private JTextField campoIdLivro;
	    private JTextField campoTitulo;
	    private JTextField campoAutor;
	    private JTextField campoGenero;
	    private JTextField campoIdioma;
	    private JTextField campoSituacao;

	    public TelaAtualizacaoLivro() {
	        // Configurar o JFrame
	        super("Atualização de Livro");
	        setSize(445, 348);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLocationRelativeTo(null);

	        // Criar e configurar os componentes
	        JLabel labelIdLivro = new JLabel("ID do Livro:");
	        labelIdLivro.setBounds(7, 9, 101, 13);
	        campoIdLivro = new JTextField(10);
	        campoIdLivro.setBounds(5, 32, 86, 19);

	        JLabel labelTitulo = new JLabel("Novo Título:");
	        labelTitulo.setBounds(5, 61, 103, 13);
	        campoTitulo = new JTextField(20);
	        campoTitulo.setBounds(5, 84, 166, 19);

	        JLabel labelAutor = new JLabel("Novo Autor:");
	        labelAutor.setBounds(6, 116, 121, 13);
	        campoAutor = new JTextField(20);
	        campoAutor.setBounds(5, 147, 166, 19);

	        JLabel labelGenero = new JLabel("Novo Gênero:");
	        labelGenero.setBounds(10, 188, 117, 13);
	        campoGenero = new JTextField(20);
	        campoGenero.setBounds(5, 212, 166, 19);

	        JLabel labelIdioma = new JLabel("Novo Idioma:");
	        labelIdioma.setBounds(248, 9, 91, 13);
	        campoIdioma = new JTextField(20);
	        campoIdioma.setBounds(248, 32, 166, 19);

	        JLabel labelSituacao = new JLabel("Nova Situação:");
	        labelSituacao.setBounds(248, 61, 137, 13);
	        campoSituacao = new JTextField(20);
	        campoSituacao.setBounds(248, 84, 166, 19);

	        // Adicionar os componentes ao painel
	        JPanel painel = new JPanel();
	        painel.setBounds(0, 0, 477, 263);
	        painel.setLayout(null);
	        painel.add(labelIdLivro);
	        painel.add(campoIdLivro);
	        painel.add(labelTitulo);
	        painel.add(campoTitulo);
	        painel.add(labelAutor);
	        painel.add(campoAutor);
	        painel.add(labelGenero);
	        painel.add(campoGenero);
	        painel.add(labelIdioma);
	        painel.add(campoIdioma);
	        painel.add(labelSituacao);
	        painel.add(campoSituacao);
	        getContentPane().setLayout(null);

	        // Adicionar o painel ao JFrame
	        getContentPane().add(painel);
	        
	        	        JButton botaoAtualizar = new JButton("Atualizar");
	        	        botaoAtualizar.setBounds(156, 280, 102, 21);
	        	        getContentPane().add(botaoAtualizar);
	        	        
	        	        	        // Adicionar ação ao botão Atualizar
	        	        	        botaoAtualizar.addActionListener(new ActionListener() {
	        	        	            @Override
	        	        	            public void actionPerformed(ActionEvent e) {
	        	        	                atualizarLivro();
	        	        	            }
	        	        	        });

	        // Tornar o JFrame visível
	        setVisible(true);
	    }

	    private void atualizarLivro() {
	    	
	    	// Obter valores dos campos
	        int idLivro = Integer.parseInt(campoIdLivro.getText());
	        String novoTitulo = campoTitulo.getText();
	        String novoAutor = campoAutor.getText();
	        String novoGenero = campoGenero.getText();
	        String novoIdioma = campoIdioma.getText();
	        String novaSituacao = campoSituacao.getText();

	        // Criar objeto Livro com os valores fornecidos
	        Livro livro = new Livro();
	        livro.setIdlivro(idLivro);

	        // Adicionar apenas os campos que foram preenchidos pelo usuário
	        if (!novoTitulo.isEmpty()) {
	            livro.setTitulo(novoTitulo);
	        }
	        if (!novoAutor.isEmpty()) {
	            livro.setAutor(novoAutor);
	        }
	        if (!novoGenero.isEmpty()) {
	            livro.setGenero(novoGenero);
	        }
	        if (!novoIdioma.isEmpty()) {
	            livro.setIdioma(novoIdioma);
	        }
	        if (!novaSituacao.isEmpty()) {
	            livro.setSituacao(novaSituacao);
	        }

	        // Chamar o método atualizarLivro da classe LivroDAO
	        boolean atualizarTitulo = !novoTitulo.isEmpty();
	        boolean atualizarAutor = !novoAutor.isEmpty();
	        boolean atualizarGenero = !novoGenero.isEmpty();
	        boolean atualizarIdioma = !novoIdioma.isEmpty();
	        boolean atualizarSituacao = !novaSituacao.isEmpty();

	        new LivroDAO().atualizarLivro(livro, atualizarTitulo, atualizarAutor, atualizarGenero, atualizarIdioma, atualizarSituacao);

	        // Limpar os campos após atualizar
	        campoIdLivro.setText("");
	        campoTitulo.setText("");
	        campoAutor.setText("");
	        campoGenero.setText("");
	        campoIdioma.setText("");
	        campoSituacao.setText("");
	    	
	    	
	    }
	        

}
