package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.SQLUtil;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> customers=new ArrayList<>();
        while (rst.next()) {
            CustomerDTO customerDTO=new CustomerDTO(rst.getString("id"),rst.getString("name"),rst.getString("address"));
            customers.add(customerDTO);
        }
        return customers;
    }
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)"
                ,customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",
                customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
    }
    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);
    }
    @Override
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }
    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }
}
