package service;

import org.apache.ibatis.annotations.Select;  

import models.User;  
/** 
 * 映射器 
 * 
 */  
public interface UserMapper {  
    public void insert(User user);
    
    @Select("select * from user where user_id=#{id}")
    public User getById(Integer id);
  
}  

