package com.example.layeredarchitecture.bo.custom;

import com.example.layeredarchitecture.bo.SuperBO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException ;
    public boolean saveItem(ItemDTO itemDTO) throws SQLException,ClassNotFoundException ;
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
    public boolean existItem(String id) throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException;
    public String generateNewItemId() throws SQLException, ClassNotFoundException;

}
