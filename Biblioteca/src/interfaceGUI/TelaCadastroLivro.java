package interfaceGUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.LivroDAO;
import biblioteca.modelo.Livro;

public class TelaCadastroLivro extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField campoIdLivro;
    private JTextField campoIdEditora;
    private JTextField campoTitulo;
    private JTextField campoAutor;
    private JTextField campoGenero;
    private JTextField campoIdioma;
    private JTextField campoSituacao;

    public TelaCadastroLivro() {
       
        super("Cadastro de Livro");
        setSize(846, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Criar e configurar os componentes
        JLabel labelIdLivro = new JLabel("ID do Livro:");
        labelIdLivro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdLivro.setBounds(10, 7, 93, 13);
        campoIdLivro = new JTextField(10);
        campoIdLivro.setBounds(10, 30, 161, 27);

        JLabel labelIdEditora = new JLabel("ID da Editora:");
        labelIdEditora.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdEditora.setBounds(261, 7, 115, 13);
        campoIdEditora = new JTextField(10);
        campoIdEditora.setBounds(261, 172, 166, 23);

        JLabel labelTitulo = new JLabel("Título:");
        labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTitulo.setBounds(10, 78, 63, 13);
        campoTitulo = new JTextField(20);
        campoTitulo.setBounds(5, 101, 166, 27);

        JLabel labelAutor = new JLabel("Autor:");
        labelAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelAutor.setBounds(10, 148, 63, 13);
        campoAutor = new JTextField(20);
        campoAutor.setBounds(5, 168, 166, 27);

        JLabel labelGenero = new JLabel("Gênero:");
        labelGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGenero.setBounds(261, 150, 63, 13);
        campoGenero = new JTextField(20);
        campoGenero.setBounds(5, 230, 166, 27);

        JLabel labelIdioma = new JLabel("Idioma:");
        labelIdioma.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelIdioma.setBounds(261, 78, 63, 13);
        campoIdioma = new JTextField(20);
        campoIdioma.setBounds(261, 30, 166, 27);

        JLabel labelSituacao = new JLabel("Situação:");
        labelSituacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelSituacao.setBounds(10, 215, 77, 13);
        campoSituacao = new JTextField(20);
        campoSituacao.setBounds(261, 105, 166, 23);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(643, 233, 77, 21);

        // Adicionar os componentes ao painel
        JPanel painel = new JPanel();
        painel.setBounds(0, 0, 1449, 263);
        painel.setLayout(null);
        painel.add(labelIdLivro);
        painel.add(campoIdLivro);
        painel.add(labelIdEditora);
        painel.add(campoIdEditora);
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
        painel.add(botaoCadastrar);

 
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro();
            }
        });
        getContentPane().setLayout(null);

        
        getContentPane().add(painel);

        
        setVisible(true);
    }

    private void cadastrarLivro() {
        // Obter valores dos campos
        int idLivro = Integer.parseInt(campoIdLivro.getText());
        int idEditora = Integer.parseInt(campoIdEditora.getText());
        String titulo = campoTitulo.getText();
        String autor = campoAutor.getText();
        String genero = campoGenero.getText();
        String idioma = campoIdioma.getText();
        String situacao = campoSituacao.getText();

        // Criar objeto Livro com os valores fornecidos
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIdlivro(idLivro);
        livro.setId_Editora(idEditora);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setIdioma(idioma);
        livro.setSituacao(situacao);

        // Chamar o método cadastrarLivro da classe LivroDAO
        new LivroDAO().cadastrarLivro(livro);

        // Limpar os campos após cadastrar
        campoIdLivro.setText("");
        campoIdEditora.setText("");
        campoTitulo.setText("");
        campoAutor.setText("");
        campoGenero.setText("");
        campoIdioma.setText("");
        campoSituacao.setText("");
    }
	
	
	
}
