package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;

public interface PlaceOrderBO {
    CustomerDTO searchCustomer(String id) throws SQLException,ClassNotFoundException;
    ItemDTO searchItem(String id) throws SQLException,ClassNotFoundException;
}
