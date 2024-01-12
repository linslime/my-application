package com.example.myapplication;


public class DataFriend {
    private int imgId;
    private String content;
    int a = 0;



    public DataFriend(int imgId, String content) {
        this.imgId = imgId;
        this.content = content;
        a = 0;
    }

    public int getImgId() {
        return imgId;
    }

    public String getContent() {
        return content;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

