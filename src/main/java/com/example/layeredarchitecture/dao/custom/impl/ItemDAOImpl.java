package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item");
        ArrayList<ItemDTO> items = new ArrayList<>();
        while (rst.next()) {
            items.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return items;

    }
    @Override
    public void saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        SQLUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
    }
    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
    }
    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("DELETE FROM Item WHERE code=?",code);
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }
    @Override
    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String code = rst.getString("code");
            int newItemCode = Integer.parseInt(code.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemCode);
        } else {
            return "I00-001";
        }
        }
    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT * FROM Item WHERE code=?", code);
        rst.next();
        return new ItemDTO(code, rst.getString("description"),
                rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
    }
