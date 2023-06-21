
package model;
import java.util.ArrayList;
import java.util.List;

public class PostList{
    
    private List<Post> postList = new ArrayList<>();

    public void postInfo(String data, String neko){
        Post post = new Post(data,neko);
        postList.add(post);
    }
    public List<Post> getPostList(){
        return postList;
    }
}