package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException,ClassNotFoundException ;
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String generateNewCustomerId() throws SQLException, ClassNotFoundException;
}
