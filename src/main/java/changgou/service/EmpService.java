package changgou.service;

import changgou.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @className EmpService
 * @userName 李院斌
 * @DATA 2023-02-02 15:44
 * @nickName 辻弎
 **/
public interface EmpService {
    /*查询所有*/
    List<Employee> getAllUser ();
    /*添加用户信息*/
    int addUser (Employee employee);
    /*更具ID删除*/
    int getByIdDelete (Integer id);
    /*更具id查询*/
    Employee getSelectById (Integer id);
    /*修改用户信息*/
    int getUpdate (Employee employee);

    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/3 18:59
     * @returns: list
     * * @Description:   分页的功能
     **/
   PageInfo<Employee> getallUserPage (Integer pageNum);

    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/4 11:58
     * @returs:
     * @Descripton: 事务管理
     **/
    void buyBook (Integer userId, Integer bookId);
}
