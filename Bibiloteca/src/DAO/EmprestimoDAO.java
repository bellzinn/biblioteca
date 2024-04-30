package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import sql.biblioteca.Conexao;

public class EmprestimoDAO{
	
	
	public void realizarEmprestimo( int idUsuario, int idLivro) {
		
		// obtendo as datas necessárias
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataDevolucaoPrevista = dataAtual.plusWeeks(2); // data de devolução prevista é 2 semanas após a data atual

  
		// comando SQL para inserir o empréstimo
		String sql = "INSERT INTO emprestimo (id_usuario, dataretirada, datareservada, devolucaoprevista) VALUES (?, ?, ?, ?)";
		
		// comando SQL para inserir na tabela de relacionamento emprestimo_has_livro
        String sqlLivro = "INSERT INTO emprestimo_has_livro (emprestimo_id_emprestimo, livro_idlivro) VALUES (?, ?)";

		PreparedStatement ps = null;
		PreparedStatement psLivro = null;
      
		// configurando os parâmetros do comando SQL
		try {
			ps = Conexao.getConexao().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1,idUsuario);
			ps.setDate(2, Date.valueOf(dataAtual)); // data de retirada é a data atual
			ps.setDate(3, Date.valueOf(dataAtual)); // data reservada é a data atual
			ps.setDate(4, Date.valueOf(dataDevolucaoPrevista));
    

			ps.execute();
			
			
			// obter o ID do emprestimo auto gerado pelo sql
            int idEmprestimo = -1;
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                idEmprestimo = generatedKeys.getInt(1);
            }
            
         // inserir na tabela emprestimo_has_livro
            if (idEmprestimo != -1) {
                psLivro = Conexao.getConexao().prepareStatement(sqlLivro);
                psLivro.setInt(1, idEmprestimo);
                psLivro.setInt(2, idLivro);
                psLivro.execute();
                psLivro.close();
                ps.close();
            }
    
		}catch (SQLException e) {
		e.printStackTrace();
    	}
	}
}        
   