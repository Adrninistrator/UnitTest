package com.adrninistrator.dao.entity;

import java.math.BigDecimal;
import java.util.Date;

public class TestTable2 {
    private String id;

    private String char1;

    private String char2;

    private String text2;

    private Integer int1;

    private Integer int2;

    private Long decimal1;

    private BigDecimal decimal2;

    private Date datetime1;

    private Date datetime2;

    private Date timestamp1;

    private Date timestamp2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChar1() {
        return char1;
    }

    public void setChar1(String char1) {
        this.char1 = char1 == null ? null : char1.trim();
    }

    public String getChar2() {
        return char2;
    }

    public void setChar2(String char2) {
        this.char2 = char2 == null ? null : char2.trim();
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2 == null ? null : text2.trim();
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public Integer getInt2() {
        return int2;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    public Long getDecimal1() {
        return decimal1;
    }

    public void setDecimal1(Long decimal1) {
        this.decimal1 = decimal1;
    }

    public BigDecimal getDecimal2() {
        return decimal2;
    }

    public void setDecimal2(BigDecimal decimal2) {
        this.decimal2 = decimal2;
    }

    public Date getDatetime1() {
        return datetime1;
    }

    public void setDatetime1(Date datetime1) {
        this.datetime1 = datetime1;
    }

    public Date getDatetime2() {
        return datetime2;
    }

    public void setDatetime2(Date datetime2) {
        this.datetime2 = datetime2;
    }

    public Date getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Date timestamp1) {
        this.timestamp1 = timestamp1;
    }

    public Date getTimestamp2() {
        return timestamp2;
    }

    public void setTimestamp2(Date timestamp2) {
        this.timestamp2 = timestamp2;
    }
}