package com.lxd.dao;

import com.lxd.bean.CommManager;
import com.lxd.bean.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommManagerMapper {


    int deleteByPrimaryKey(Integer id);

//    int insert(CommManager record);

    int insertSelective(CommManager record);

    CommManager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommManager record);

//    int updateByPrimaryKey(CommManager record);

    List<CommManager> getAll();

    int deleteAll(ArrayList<Integer> list);
}