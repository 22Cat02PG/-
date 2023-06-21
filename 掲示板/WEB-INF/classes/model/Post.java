package model;

public class Post{
    private String data;
    private String neko;

    public Post(String data, String neko){
        this.data = data;
        this.neko = neko;
    }
    public String getData(){
        return data;
    }
    public String getNeko(){
        return neko;
    }
}
