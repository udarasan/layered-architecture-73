package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.dto.CustomDTO;
import com.example.layeredarchitecture.entity.Custom;

import java.sql.SQLException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Custom> getAllCustomersByOrderCount() throws SQLException, ClassNotFoundException {
        //db operation
        return null;
    }

    @Override
    public List<Custom> getAllCustomersItem() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
