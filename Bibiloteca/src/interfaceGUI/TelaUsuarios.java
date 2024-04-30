package interfaceGUI;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import biblioteca.modelo.Usuario;

public class TelaUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tabelaUsuarios;
    private DefaultTableModel modeloTabela;

    public TelaUsuarios(List<Usuario> usuarios) {
        setTitle("Lista de Usuários");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Configurar o modelo da tabela
        String[] colunas = {"ID", "Nome", "Email", "Telefone", "isAdmin"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaUsuarios = new JTable(modeloTabela);

        // Adicionar a tabela a um painel de rolagem
        JScrollPane scrollPane = new JScrollPane(tabelaUsuarios);
        add(scrollPane, BorderLayout.CENTER);

        // Preencher a tabela com os dados dos usuários
        preencherTabela(usuarios);
        
    }

    private void preencherTabela(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            Object[] linha = {usuario.getIdUsuario(), usuario.getNomeUsuario(), usuario.getEmail(),
                    usuario.getTelefone(), usuario.getIsAdmin()};
            modeloTabela.addRow(linha);
        }
    }
}