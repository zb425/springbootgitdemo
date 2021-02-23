package com.bgamq.atcrowd.po;

public class TypePO {
    private Integer id;

    private String bagName;

    private String bagRemark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBagName() {
        return bagName;
    }

    public void setBagName(String bagName) {
        this.bagName = bagName == null ? null : bagName.trim();
    }

    public String getBagRemark() {
        return bagRemark;
    }

    public void setBagRemark(String bagRemark) {
        this.bagRemark = bagRemark == null ? null : bagRemark.trim();
    }
}