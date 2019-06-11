package org.sfa.infomanage.service;

import org.sfa.infomanage.bean.Post;
import org.sfa.infomanage.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public HashMap<String,String> getPostMap(){
        HashMap<String,String> map = new HashMap<>();
        List<Post> posts = postMapper.getAllPosts();
        for(Post post:posts){
            map.put(post.getPostId(), post.getPostName());
        }
        return map;
    }

    public List<Post> getAllPosts(){
        return postMapper.getAllPosts();
    }
}
