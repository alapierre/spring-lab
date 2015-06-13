/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.softproject.spring.lab1_08.model;

import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author S108_11
 */
@Component
public class Shipment {
    private Long id;
    private Date shipmentDate;
    private Address shipmentAddress;
    private boolean shipmentStatus;
    private Order orderId;
    private enum shipmentType {COURIER, POST};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public Address getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(Address shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public boolean isShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(boolean shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Enum getShipmentType() {
        return shipmentType;
    }

    public void setShipmentType(Enum shipmentType) {
        this.shipmentType = shipmentType;
    }
    
    
}
