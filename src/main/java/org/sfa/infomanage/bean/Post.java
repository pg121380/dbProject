package org.sfa.infomanage.bean;

public class Post {
    private String postId;  //岗位号
    private String postName;    //岗位名

    public Post(String postId, String postName) {
        this.postId = postId;
        this.postName = postName;
    }

    public Post() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }
}
