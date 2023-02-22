package changgou.service.impl;

import changgou.pojo.Employee;
import changgou.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @className EmpServiceImpl
 * @userName 李院斌
 * @DATA 2023-02-02 15:44
 * @nickName 辻弎
 **/
@Service //标识为业务层组件

public class EmpServiceImpl implements changgou.service.EmpService {


    //设置日志文件
    private static final Logger LOGGER = Logger.getLogger (changgou.service.impl.EmpServiceImpl.class);
    @Autowired  //自动装配
    private  changgou.mapper.EmpMapper mapper;



    @Override
    public List<Employee> getAllUser () {
        return  mapper.getAllUser ();
    }

    @Override
    public int addUser (Employee employee) {
        return mapper.addUser(employee);
    }

    @Override
    public int getByIdDelete (Integer id) {
        return mapper.getByIdDelete(id);
    }

    @Override
    public Employee getSelectById (Integer id) {
        return mapper.getSelectById(id);
    }

    @Override
    public int getUpdate (Employee employee) {
        return mapper.updateById(employee);
    }

    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/3 18:59
     * @returns: list
     * * @Description:   分页的功能
     **/
    @Override
    public PageInfo<Employee> getallUserPage (Integer pageNum) {
        //在业务层实现分页的功能，在查询之前使用PageHelper.startPage(int pageNum, int pageSize)开启分页功能
        PageHelper.startPage (pageNum , 5);
        List<Employee> allUser = mapper.getAllUser ();
        //在查询获取list集合之后，使用PageInfo<T> pageInfo = new PageInfo<>(List<T> list, int navigatePages)获取分页相关数据
        return new PageInfo<> (allUser , 5);
    }

    /**
     * @param userId
     * @param bookId
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/4 11:58
     * @returs:
     * @Descripton: 事务管理
     */

    @Override
    @Transactional()
    public void buyBook (Integer userId, Integer bookId) {
        try {
            //查询图书价格
            Integer price = mapper.getPriceByBookId(bookId);
            //更新图书库存
            mapper.updateBookById(bookId);
            //更新自己的余额
            mapper.updateUserBalance(userId , price);
        } catch (Exception e) {
            if (true){
                throw new RuntimeException ("购买异常");
            }
            LOGGER.error (e.getMessage (), e);
        }
    }
}
