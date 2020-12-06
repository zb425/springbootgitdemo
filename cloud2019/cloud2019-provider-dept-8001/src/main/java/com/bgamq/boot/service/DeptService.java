package com.bgamq.boot.service;

import com.bgamq.boot.entity.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDept(Dept dept);
    public Dept findById(Long  id);
    public List<Dept> findAll();
}
