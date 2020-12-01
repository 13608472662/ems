package com.baizhi.action;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller("empAction")
@Scope("prototype")
public class EmpAction {
    private Emp emp;
    @Autowired
    private EmpService empService;
    private List<Emp> list;

    //查一个
    public String selectOne() {
        this.emp = empService.login(emp.getId());
        return "update";
    }

    //查所有
    public String selectAll() {
        this.list = empService.selcetAll();
        return "showAll";
    }

    //添加
    public String add() {
        empService.register(emp);
        return "selectAll";
    }

    //修改
    public String update() {
        empService.update(emp);
        return "selectAll";
    }

    //删除
    public String delete() {
        empService.delete(emp.getId());
        return "selectAll";
    }

    /*public void setEmpService(EmpService empService) {
        this.empService = empService;
    }*/

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }
}
