package com.example.layeredarchitecture.model;

public class CustomDTO {
    //customer related attributes
    private String firstName;
    private String lastName;
    //order related attributes
    private int orderId;
    private String orderDate;
    //Item related attributes
    private int itemId;
    private String itemName;

    public CustomDTO(String firstName, String lastName, int orderId, String orderDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public CustomDTO() {
    }
    public CustomDTO(String firstName, int itemId, String itemName) {
        this.firstName = firstName;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public CustomDTO(String firstName, String lastName, int orderId, String orderDate, int itemId, String itemName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
