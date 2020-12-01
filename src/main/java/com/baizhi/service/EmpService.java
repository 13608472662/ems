package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    //查一个
    public Emp login(String id);

    //查所有
    public List<Emp> selcetAll();

    //添加
    public void register(Emp emp);

    //修改
    public void update(Emp emp);

    //删除
    public void delete(String id);
}
