package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OderDAOImpl implements OrderDAO {
    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeQuery("SELECT oid FROM `Orders` WHERE oid=?",orderId).next();
    }
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.executeUpdate("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderDTO.getOrderId(),orderDTO.getOrderDate(),orderDTO.getCustomerId());
    }


    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
