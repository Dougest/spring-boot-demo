#本项目的数据库暂时不是是读写分离的！！
#所以先用DAO包吧

#but
##DAO支持两种SQL写法

### 写法一：

>直接用注解的方式在DAO数据库操作

    @Query("from User u where u.userName=:userName")
     User findUser(@Param("userName") String userName);
 
 ###写法二：
 >mapper文件的方式
 
  @Mapper
  
    public interface CityDao {
  
     City findCitys(Integer id);
   
    }





&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&copy;青橙山下的老张