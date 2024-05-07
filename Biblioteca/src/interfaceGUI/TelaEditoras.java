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

import DAO.EditoraDAO;
import biblioteca.modelo.Editora;

public class TelaEditoras extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextArea textAreaEditoras;

	public TelaEditoras() {
        setTitle("Lista de Editoras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        textAreaEditoras = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textAreaEditoras);

        JButton btnEmprestimo = new JButton("Atualizar editora");
        btnEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                AtualizarEditora atualizarEditoraFrame = new AtualizarEditora();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        atualizarEditoraFrame.setVisible(true);
                    }
                });
            	
            	
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnEmprestimo, BorderLayout.SOUTH);

        add(panel);
        carregarEditoras();
    }

    private void carregarEditoras(){
        List<Editora> editoras = listarTodasEditoras();
        StringBuilder sb = new StringBuilder();

        for (Editora editora : editoras) {
            sb.append("ID: ").append(editora.getIdEditora()).append("\n");
            sb.append("Título: ").append(editora.getNome()).append("\n");
            sb.append("-------------------------").append("\n\n");
        }

        textAreaEditoras.setText(sb.toString());
    }

    

    
    private List<Editora> listarTodasEditoras() {
        return EditoraDAO.listarTodasEditoras(); 
    }

    
}