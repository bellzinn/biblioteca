package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.modelo.Usuario;
import sql.biblioteca.Conexao;

public class UsuarioDAO {

	

	public void cadastrarUsuario(Usuario usuario) {
		String sql = "INSERT INTO USUARIO (NOME, EMAIL, TELEFONE, SENHA, ISADMIN) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, usuario.getNomeUsuario());
			ps.setString(2, usuario.getEmail());
			ps.setLong(3, usuario.getTelefone());
			ps.setString(4, usuario.getSenha());
			ps.setInt(5, usuario.getIsAdmin());
			
			
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public Usuario login(String email, String senha) {
	        String sql = "SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA = ?";
	        
	        
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	            ps = Conexao.getConexao().prepareStatement(sql);
	            ps.setString(1, email);
	            ps.setString(2, senha);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setIdUsuario(rs.getInt("IDUSUARIO"));
	                usuario.setNomeUsuario(rs.getString("NOME"));
	                usuario.setEmail(rs.getString("EMAIL"));
	                usuario.setTelefone(rs.getLong("TELEFONE"));
	                usuario.setSenha(rs.getString("SENHA"));
	                usuario.setIsAdmin(rs.getInt("ISADMIN"));
	                return usuario;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (ps != null) ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        return null; // Se não encontrar nenhum usuário com as informações recebidas
	    }

	
	public List<Usuario> ObterTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM USUARIO";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("IDUSUARIO"));
                usuario.setNomeUsuario(rs.getString("NOME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setTelefone(rs.getLong("TELEFONE"));
                // usuario.setSenha(rs.getString("SENHA"));
                usuario.setIsAdmin(rs.getInt("ISADMIN"));

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuarios;
    }

	
}
	