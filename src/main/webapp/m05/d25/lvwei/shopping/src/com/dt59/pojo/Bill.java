package com.dt59.pojo;

import java.util.Date;

public class Bill {
    private Integer id; // id

    private String billCode; // �˵�����

    private String productName; // ��Ʒ����

    private String productDesc; // ��Ʒ����

    private String productUnit; // ��Ʒ��λ

    private Double productCount; // ��Ʒ����

    private double totalPrice; // �ܽ��

    private Integer isPayment; // �Ƿ�֧��

    private Integer providerId; // ��Ӧ��ID

    private Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    private Integer createdBy; // ������

    private Date creationDate; // ����ʱ��

    private Integer modifyBy; // ������

    private Date modifyDate;// ����ʱ��

    private String providerName;// ��Ӧ������

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double double1) {
        this.productCount = double1;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double d) {
        this.totalPrice = d;
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

}
