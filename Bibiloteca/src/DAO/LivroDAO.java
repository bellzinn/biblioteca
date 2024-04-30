package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.modelo.Livro;
import sql.biblioteca.Conexao;

public class LivroDAO {
	
	//buscar nome da editora com base no "idEditora" de um livro para associar o nome dela ao livro em si
	public String buscarNomeEditoraPorId(int idEditora) {
        String nomeEditora = null;
        String sql = "SELECT nome FROM editora WHERE idEditora = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idEditora);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    nomeEditora = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomeEditora;
    }
	

	public void atualizarLivro(Livro livro, boolean atualizarTitulo, boolean atualizarAutor,
			                   boolean atualizarGenero, boolean atualizarIdioma, boolean atualizarSituacao) {
        
		
		
		StringBuilder sql = new StringBuilder("UPDATE livro SET ");
        boolean setComma = false;

        if (atualizarTitulo) {
            sql.append("TITULO = ?, ");
            setComma = true;
        }
        if (atualizarAutor) {
            sql.append("AUTOR = ?, ");
            setComma = true;
        }
        if (atualizarGenero) {
            sql.append("GENERO = ?, ");
            setComma = true;
        }
        if (atualizarIdioma) {
            sql.append("IDIOMA = ?, ");
            setComma = true;
        }
        if (atualizarSituacao) {
            sql.append("SITUACAO = ?, ");
            setComma = true;
        }

        if (setComma) {
            sql.setLength(sql.length() - 2);
        }

        sql.append(" WHERE IDLIVRO = ?");

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql.toString());

            int index = 1;
            if (atualizarTitulo) {
                ps.setString(index++, livro.getTitulo());
            }
            if (atualizarAutor) {
                ps.setString(index++, livro.getAutor());
            }
            if (atualizarGenero) {
                ps.setString(index++, livro.getGenero());
            }
            if (atualizarIdioma) {
                ps.setString(index++, livro.getIdioma());
            }
            if (atualizarSituacao) {
                ps.setString(index++, livro.getSituacao());
            }

            // IDLIVRO sempre será atualizado
            ps.setInt(index, livro.getIdlivro());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
		
	public void cadastrarLivro(Livro livro) {
		String sql = "INSERT INTO LIVRO (TITULO, IDLIVRO, EDITORA_IDEDITORA, AUTOR, GENERO, IDIOMA, EDITORA, SITUACAO) VALUES (?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setString(1, livro.getTitulo());
			ps.setInt(2, livro.getIdlivro());
			ps.setInt(3, livro.getId_Editora());
			ps.setString(4, livro.getAutor());
			ps.setString(5, livro.getGenero());
			ps.setString(6, livro.getIdioma());
			ps.setString(8, livro.getSituacao());
			
			String nomeEditora = new LivroDAO().buscarNomeEditoraPorId(livro.getId_Editora());
	        ps.setString(7, nomeEditora);
			
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void apagarLivro(int idLivro) {
	    String sql = "DELETE FROM livro WHERE IDLIVRO = ?";

	    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
	        ps.setInt(1, idLivro);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public static List<Livro> listarLivros() {
	    List<Livro> livros = new ArrayList<>();
	    String sql = "SELECT * FROM livro";

	    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            Livro livro = new Livro();
	            livro.setIdlivro(rs.getInt("IDLIVRO"));
	            livro.setTitulo(rs.getString("TITULO"));
	            livro.setId_Editora(rs.getInt("EDITORA_IDEDITORA"));
	            livro.setAutor(rs.getString("AUTOR"));
	            livro.setGenero(rs.getString("GENERO"));
	            livro.setIdioma(rs.getString("IDIOMA"));
	            livros.add(livro);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return livros;
	}

	
}
