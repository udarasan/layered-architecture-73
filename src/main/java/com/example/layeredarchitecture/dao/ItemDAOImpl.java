package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()) {
            items.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return items;

    }

    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
    Connection connection = DBConnection.getDbConnection().getConnection();
    PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code,description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
    pstm.setString(1, itemDTO.getCode());
    pstm.setString(2, itemDTO.getDescription());
    pstm.setBigDecimal(3, itemDTO.getUnitPrice());
    pstm.setInt(4, itemDTO.getQtyOnHand());
    pstm.executeUpdate();
    }
    public void updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, itemDTO.getDescription());
        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
        pstm.setInt(3, itemDTO.getQtyOnHand());
        pstm.setString(4, itemDTO.getCode());
        pstm.executeUpdate();
    }
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeUpdate()>0;
    }
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
        pstm.setString(1, code);
        return pstm.executeQuery().next();
        }

        public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String code = rst.getString("code");
            int newItemCode = Integer.parseInt(code.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemCode);
        } else {
            return "I00-001";
        }

        }
        public void searchItem(){}

    }
