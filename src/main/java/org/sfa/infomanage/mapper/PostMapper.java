package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sfa.infomanage.bean.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostMapper {

    @Select("select * from post")
    List<Post> getAllPosts();
}
