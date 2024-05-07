package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.modelo.Editora;
import sql.biblioteca.Conexao;

public class EditoraDAO {

	
	public void atualizarEditora(Editora editora) {
	    String sqlEditora = "UPDATE editora SET nome = ? WHERE idEditora = ?";
	    String sqlLivro = "UPDATE livro SET editora = ? WHERE Editora_idEditora = ?";
	    
	    Connection conexao = null;
	    PreparedStatement psEditora = null;
	    PreparedStatement psLivro = null;

	    try {
	        conexao = Conexao.getConexao();
	        
	        // Atualizar tabela editora
	        psEditora = conexao.prepareStatement(sqlEditora);
	        psEditora.setString(1, editora.getNome());
	        psEditora.setInt(2, editora.getIdEditora());
	        psEditora.executeUpdate(); // Use executeUpdate para atualizações
	        psEditora.close();

	        // Atualizar tabela livro
	        psLivro = conexao.prepareStatement(sqlLivro);
	        psLivro.setString(1, editora.getNome());
	        psLivro.setInt(2, editora.getIdEditora());
	        psLivro.executeUpdate(); // Use executeUpdate para atualizações
	        psLivro.close();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (psEditora != null) {
	                psEditora.close();
	            }
	            if (psLivro != null) {
	                psLivro.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	public void cadastrarEditora(Editora editora) {
			String sql = "INSERT INTO EDITORA (IDEDITORA, NOME) VALUES (?,?)";
			
			PreparedStatement ps = null;
			
			try {
				ps = Conexao.getConexao().prepareStatement(sql);
				ps.setInt(1, editora.getIdEditora());
				ps.setString(2, editora.getNome());
				
				ps.execute();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
		
		 }
	
		
	public void apagarEditora(int idEditora) {
        String sql = "DELETE FROM editora WHERE idEditora = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idEditora);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
	public static void apagarEditora1(Scanner scanner) {
        System.out.print("Digite o ID da editora que você deseja apagar: ");
        int idEditora = scanner.nextInt();
        
        new EditoraDAO().apagarEditora(idEditora);
        System.out.println("Editora apagada com sucesso!");
    }
	
	
	public static List<Editora> listarTodasEditoras() {
	    List<Editora> editoras = new ArrayList<>();
	    String sql = "SELECT * FROM editora";

	    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
		     ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Editora editora = new Editora();
	            editora.setIdEditora(rs.getInt("idEditora"));
	            editora.setNome(rs.getString("nome"));
	            editoras.add(editora);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return editoras;
	}


}
