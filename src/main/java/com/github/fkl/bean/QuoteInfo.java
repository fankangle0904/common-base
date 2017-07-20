package com.github.fkl.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by kanglefan on 17-7-10.
 */
public class QuoteInfo implements Serializable {
    private static final long serialVersionUID = -138199961107461200L;
    private String riskCode;
    private String riskName;
    private String riskType;
    private BigDecimal coverage;
    private String insAmount;
    private BigDecimal premium;

    public QuoteInfo() {
    }

    public String getRiskCode() {
        return this.riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskName() {
        return this.riskName;
    }

    public void setRiskName(String riskName) {
        this.riskName = riskName;
    }

    public String getRiskType() {
        return this.riskType;
    }

    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public BigDecimal getCoverage() {
        return this.coverage;
    }

    public void setCoverage(BigDecimal coverage) {
        this.coverage = coverage;
    }

    public String getInsAmount() {
        return this.insAmount;
    }

    public void setInsAmount(String insAmount) {
        this.insAmount = insAmount;
    }

    public BigDecimal getPremium() {
        return this.premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }
}
