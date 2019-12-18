package org.sfa.infomanage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.sfa.infomanage.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMapper {

    private List<User> users = new ArrayList<>();
    public UserMapper(){
        User user1 = new User("shangkexin","123456","e-001","admin");
        User user2 = new User("xiaoming", "123456", "e-002", "emp");
        users.add(user1);
        users.add(user2);
    }

    public List<User> getUsers(){
        return users;
    }

    public User getUserByUsername(String username){
        for(User user:users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
