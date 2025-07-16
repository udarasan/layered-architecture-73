package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<CustomDTO> getAllCustomersByOrderCount() throws SQLException, ClassNotFoundException;
    List<CustomDTO> getAllCustomersItem() throws SQLException, ClassNotFoundException;
}
