package com.example.secondmainproject.Model;

import com.example.secondmainproject.Dao.Entity.PropertyEntity;

public class WishList {
    private PropertyEntity propertyEntity;
    private int quantity;
    private WishList[] wishLists;

    public WishList(PropertyEntity propertyEntity, int quantity) {
        this.propertyEntity = propertyEntity;
        this.quantity = quantity;
    }

    public PropertyEntity getPropertyEntity() {
        return propertyEntity;
    }

    public void setPropertyEntity(PropertyEntity propertyEntity) {
        this.propertyEntity = propertyEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
