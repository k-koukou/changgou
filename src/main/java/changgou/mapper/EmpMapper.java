package changgou.mapper;

import changgou.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @className EmpMapper
 * @userName 李院斌
 * @DATA 2023-02-02 15:44
 * @nickName 辻弎
 **/
public interface EmpMapper {

    /*查询所有*/
    List<Employee> getAllUser();
    /*添加信息*/
    int addUser (@Param("employee") Employee employee);
    /*根据ID删除*/
    int getByIdDelete (@Param ("id") Integer id);
    /*根据id查询*/
    Employee getSelectById (@Param ("id") Integer id);
    /*修改用户信息*/
    int updateById (@Param ("emp") Employee employee);

    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/4 12:14
     * @returns: a
     * * @Description: 事务管理
     * **/
    /*更新图书价格*/
    Integer getPriceByBookId (@Param ("bookId") Integer bookId);
    /*更新图书库存*/
    void updateBookById (@Param ("bookId") Integer bookId);
    /*更新自己的余额*/
    void updateUserBalance (@Param ("userId") Integer userId,  @Param ("price") Integer price);

}
