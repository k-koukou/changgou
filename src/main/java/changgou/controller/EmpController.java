package changgou.controller;

import changgou.pojo.Employee;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @className EmpController
 * @userName 李院斌
 * @DATA 2023-02-02 15:43
 * @nickName 辻弎
 **/
@Controller //标识为控制层组件
public class EmpController {

    @Autowired //自动装配对象
    private changgou.service.EmpService service;

    /*查询所有*/
    @RequestMapping(value = "/getAllUser" , method = RequestMethod.GET)
    public String getAllUser(Model model){
        //调用业务层处理数据
        List<Employee> list = service.getAllUser();
        //共享域对象
        model.addAttribute ("list",list);
        return "employee_list";
    }
    /*添加*/
    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public String addUser(Employee employee ){
        int shuzi =  service.addUser(employee);
        if(shuzi == 0) {
            return "404";
        }
        //重定向到查询所有的功能
        return "redirect:/getAllUser";
    }
    /*修改*/
    @RequestMapping(value = "/updateById/{id}",method = RequestMethod.GET)
    public String updateById(@PathVariable("id") Integer id ,Model model){
        //根据id查询员工信息
        Employee employee = service.getSelectById(id);
        System.err.println (employee);
        model.addAttribute ("employee",employee);
        return "update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateById(Employee employee){
        int update = service.getUpdate(employee);
        if (update == 0 ){
            return "404";
        }
        return "redirect:/getAllUser";
    }
    /*删除*/
    @RequestMapping(value = "/getByIdDelete/{id}",method = RequestMethod.GET )
    public String getByIdDelete(@PathVariable("id") Integer id){

        int delete = service.getByIdDelete(id);

        if (delete == 0 ){
            return "404";
        }
        return "redirect:/getAllUser";
    }


    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/3 18:54
     * @returns: 集合list
     * @Description:   设置页面的分页效果
     **/
    @RequestMapping(value = "/pagehelper/{pageNum}" , method = RequestMethod.GET)
    public String getAllUser(@PathVariable("pageNum") Integer pageNum , Model model){
        //调用业务层处理数据
        PageInfo<Employee> list = service.getallUserPage(pageNum);
        //共享域对象
        model.addAttribute ("pageHelper",list);
        return "employee_list";
    }

    /**
     * @Author: 辻弎
     * @Author: 李院斌
     * @Date: 2023/2/4 10:39
     * @returns:
     * @Description: 事务管理
     **/
    //买书的操作
    @RequestMapping (value = "/shiwu" ,method = RequestMethod.POST)
    public String buyBook(@RequestParam("userId") Integer userId , @RequestParam("bookId")  Integer bookId ){

        System.err.println ("userId ==" + userId + "===>>" + "bookId" + bookId);
        //调用业务层处理数据
        service.buyBook(userId , bookId);

        return "add";
    }

}
