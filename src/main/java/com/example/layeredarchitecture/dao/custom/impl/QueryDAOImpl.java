package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomDTO;

import java.sql.SQLException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<CustomDTO> getAllCustomersByOrderCount() throws SQLException, ClassNotFoundException {
        //db operation
        return null;
    }

    @Override
    public List<CustomDTO> getAllCustomersItem() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
