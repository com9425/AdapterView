package com.example.customlistview;

public class ItemData {
    private int imgID;
    private String title;
    private String content;

    public ItemData(int imgID , String title , String content) {//생성과동시에 리스트항목에 뿌려주기위해
        this.imgID=imgID;//필드와 매개변수가 같을때 구분하는문자 this
        this.title=title;
        this.content=content;
    }
    public int getImgID() {
        return imgID;
    }
    public String getTitle() {
        return title;
    }

    public String getContent(){
        return content;
    }
    public void setImgID(int imgID){
        this.imgID=imgID;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setContent(String content) {
        this.content=content;
    }
}
