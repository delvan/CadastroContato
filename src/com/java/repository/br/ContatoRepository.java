package com.java.repository.br;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.conection.br.ConnetionDB;
import com.java.contato.br.Contato;

public class ContatoRepository {
	
	ConnetionDB connection = new ConnetionDB();
	
	Connection conn = new ConnetionDB().conecta();
	
	PreparedStatement prep = null;
	 
	


	public void addContato(Contato contato) {
		
		
		try {
	     
	        // Prepare a statement to insert a record
	        String sql = "INSERT INTO contato (nome, idade, email) VALUES (?, ?, ?)";
	        
	        prep = conn.prepareStatement(sql);
	    
	        prep.setString(1, contato.getNome());
	        prep.setInt(2, contato.getIdade());
	        prep.setString(3, contato.getEmail());
	        
	        
	        prep.execute();
	       
	    } catch (SQLException e) {
	    }
		
	}
	
	public ArrayList<Contato> listarContatos() throws SQLException{
		
	    String sql = "select * from contato";
	    prep = conn.prepareStatement(sql);
	    ResultSet  rs = prep.executeQuery();
	    
	    ArrayList<Contato> contatos = new ArrayList<Contato>();
	    
	    if(rs.next()){
	        Contato contato = new Contato();
	        contato.setId(rs.getInt("id"));
	        contato.setNome(rs.getString("nome"));
	        contato.setIdade(rs.getInt("idade"));
	        contato.setEmail(rs.getString("email"));
	        contatos.add(contato);
	        
	    }
	    return contatos;
	}
	

}
