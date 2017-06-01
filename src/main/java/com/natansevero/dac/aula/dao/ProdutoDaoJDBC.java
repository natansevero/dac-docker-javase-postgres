/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natansevero.dac.aula.dao;

import com.natansevero.dac.aula.connection.ConnFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.natansevero.dac.aula.entidade.Produto;
/**
 *
 * @author natan
 */
public class ProdutoDaoJDBC {
    private final Connection conn;
    
    public ProdutoDaoJDBC() throws ClassNotFoundException, SQLException {
        this.conn = ConnFactory.getConnection();
    }
    
    public List<Produto> listar() {
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement("select * from produto");
            ResultSet rs = stmt.executeQuery();
            
            List<Produto> produtos = new ArrayList<>();
            
            while(rs.next()) {
                produtos.add(new Produto(rs.getString("nome"), rs.getDouble("preco"), rs.getString("tipo")));
            }
            
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Collections.EMPTY_LIST;
    }
}
