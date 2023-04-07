package com.lxd.service;

import com.lxd.bean.CommManager;
import com.lxd.bean.Result;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 兰晓东
 * @create 2023-04-06 19:20
 * @describe:
 */
public interface CommManagerService {

//    根据id删除
    Result deleteByPrimaryKey(Integer id);

//   插入一条数据
    Result insertSelective(CommManager record);

//    查询一条数据
    Result selectByPrimaryKey(Integer id);

//   修改一条数据
    Result updateByPrimaryKeySelective(CommManager record);

    Result getAll(Integer page,Integer limit);

    Result upload(MultipartFile file, String path);

    Result deleteAll(ArrayList<Integer> list);
}
