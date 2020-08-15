package com.adrninistrator.dao.entity;

public class TestTable2WithBLOBs extends TestTable2 {
    private byte[] blob1;

    private byte[] blob2;

    private String text1;

    public byte[] getBlob1() {
        return blob1;
    }

    public void setBlob1(byte[] blob1) {
        this.blob1 = blob1;
    }

    public byte[] getBlob2() {
        return blob2;
    }

    public void setBlob2(byte[] blob2) {
        this.blob2 = blob2;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1 == null ? null : text1.trim();
    }
}