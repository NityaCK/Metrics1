package com.nitya.jmx;

public interface counterMBean {

    public int getWordCount();
    public String getFileName();
    public void setFileName(String fname);
    public void setWordCount(int count); //temporary
}