package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

   /* public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }*/

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp login(String id) {
        return empDao.selectOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> selcetAll() {
        return empDao.selcetAll();
    }

    @Override
    public void register(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.add(emp);
    }

    @Override
    public void update(Emp emp) {
        empDao.update(emp);
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }
}
