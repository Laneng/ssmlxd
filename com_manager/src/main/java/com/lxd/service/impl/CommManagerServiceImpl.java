package com.lxd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxd.bean.CommManager;
import com.lxd.bean.Result;
import com.lxd.dao.CommManagerMapper;
import com.lxd.service.CommManagerService;
import com.sun.corba.se.impl.encoding.CDROutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 兰晓东
 * @create 2023-04-06 19:21
 * @describe:
 */
@Service
public class CommManagerServiceImpl implements CommManagerService {

    @Autowired
    private CommManagerMapper commManagerMapper;
    @Override
    public Result deleteByPrimaryKey(Integer id) {
        int i = commManagerMapper.deleteByPrimaryKey(id);
        return i == 1 ? new Result(0,"发送成功",i) : new Result(1,"发送失败",i);
    }

    @Override
    public Result insertSelective(CommManager record) {
        record.setCreateTime(new Date());
        int i = commManagerMapper.insertSelective(record);
        return i == 1 ? new Result(0,"发送成功",i) : new Result(1,"发送失败",i);
    }

    @Override
    public Result selectByPrimaryKey(Integer id) {
        CommManager commManager = commManagerMapper.selectByPrimaryKey(id);
        return commManager != null ? new Result(0,"发送成功",commManager) : new Result(1,"发送失败",commManager);

    }

    @Override
    public Result updateByPrimaryKeySelective(CommManager record) {
        int i = commManagerMapper.updateByPrimaryKeySelective(record);
        return i == 1 ? new Result(0,"发送成功",i) : new Result(1,"发送失败",i);
    }

    @Override
    public Result getAll(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        List<CommManager> commManagers = commManagerMapper.getAll();
        PageInfo<CommManager> commManagerPageInfo = new PageInfo<>(commManagers);
        Long total = commManagerPageInfo.getTotal();
        Result result = new Result(0,"查询成功",commManagers);
        result.setCount(total.intValue());
        return result;
    }

    @Override
    public Result upload(MultipartFile file, String path) {
        String filename = file.getOriginalFilename();
        String pre = filename.split("\\.")[0];
        String suf = filename.split("\\.")[1];
        String newName = pre + UUID.randomUUID().toString() + "." + suf;
        File file1 = new File(path, newName);
        if(!file1.exists()){
            file1.mkdirs();
        }

        try {
            file.transferTo(new File(path,newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Result(0,"上传成功",newName);
    }

    @Override
    public Result deleteAll(ArrayList<Integer> list) {
        int i = commManagerMapper.deleteAll(list);
        return new Result(0,"删除成功",i);
    }


}
