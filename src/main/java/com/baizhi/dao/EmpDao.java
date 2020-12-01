package com.baizhi.dao;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDao {
    //查一个
    public Emp selectOne(String id);

    //查所有
    public List<Emp> selcetAll();

    //添加
    public void add(Emp emp);

    //修改
    public void update(Emp emp);

    //删除
    public void delete(String id);
}
