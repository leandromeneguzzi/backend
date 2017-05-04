/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Cliente;

/**
 *
 * @author Leandro
 */
public class ClienteDAO {

    private final Connection connection;
    private PreparedStatement pstm;
    private boolean res;

    public ClienteDAO() {
        ConnectionFactory cf = new ConnectionFactory();
        connection = cf.getConnection("derby");
    }

    public Integer create(Cliente cliente) {
        ResultSet rs;
        String sql = "INSERT INTO tb_customer_account ("
                + "nm_customer, "
                + "cpf_cnpj, "
                + "is_active, "
                + "vl_total) "
                + "VALUES (?, ?, ?, ?)";
        int key = 0;

        try {
            pstm = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getCadastro());
            pstm.setBoolean(3, cliente.getAtivo());
            pstm.setDouble(4, cliente.getSaldo());
            res = pstm.execute();
            rs = pstm.getGeneratedKeys();

            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    public ArrayList<Cliente> read() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM tb_customer_account";
        try {
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id_customer"), rs.getString("nm_customer"), rs.getString("cpf_cnpj"), rs.getBoolean("is_active"), rs.getDouble("vl_total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

}
