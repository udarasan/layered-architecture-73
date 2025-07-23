package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.dao.SuperDAO;
import com.example.layeredarchitecture.dto.CustomDTO;
import com.example.layeredarchitecture.entity.Custom;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Custom> getAllCustomersByOrderCount() throws SQLException, ClassNotFoundException;
    List<Custom> getAllCustomersItem() throws SQLException, ClassNotFoundException;
}
