package com.jiyad.dto;

import java.math.BigDecimal;

public class PGUpdateDTO {
    private String name;
    private String ownerName;
    private String contactNumber;
    private String address;
    private BigDecimal rentSingle;
    private BigDecimal rentDouble;
    private Boolean foodProvided;
    private Boolean wifiAvailable;
    private Boolean acAvailable;
    private String alternateContact;
    private String landmark;
    private BigDecimal rentTriple;

    // Getters and Setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public BigDecimal getRentSingle() { return rentSingle; }
    public void setRentSingle(BigDecimal rentSingle) { this.rentSingle = rentSingle; }

    public BigDecimal getRentDouble() { return rentDouble; }
    public void setRentDouble(BigDecimal rentDouble) { this.rentDouble = rentDouble; }

    public Boolean getFoodProvided() { return foodProvided; }
    public void setFoodProvided(Boolean foodProvided) { this.foodProvided = foodProvided; }

    public Boolean getWifiAvailable() { return wifiAvailable; }
    public void setWifiAvailable(Boolean wifiAvailable) { this.wifiAvailable = wifiAvailable; }

    public Boolean getAcAvailable() { return acAvailable; }
    public void setAcAvailable(Boolean acAvailable) { this.acAvailable = acAvailable; }

    public String getAlternateContact() { return alternateContact; }
    public void setAlternateContact(String alternateContact) { this.alternateContact = alternateContact; }

    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }

    public BigDecimal getRentTriple() { return rentTriple; }
    public void setRentTriple(BigDecimal rentTriple) { this.rentTriple = rentTriple; }
}
