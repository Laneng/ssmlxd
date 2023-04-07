package com.lxd.controller;

import com.lxd.bean.CommManager;
import com.lxd.bean.Result;
import com.lxd.service.CommManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * @author 兰晓东
 * @create 2023-04-06 19:45
 * @describe:
 */
@RestController
@RequestMapping("/comm")
public class CommManagerController {

    @Autowired
    private CommManagerService commManagerService;

    @GetMapping("")
    public Result getAll(Integer page,Integer limit){
        Result all = commManagerService.getAll(page, limit);
        return all;
    }

    @PostMapping("")
    public Result insert(@RequestBody CommManager commManager){
        Result insertComm = commManagerService.insertSelective(commManager);
        return insertComm;
    }

    @GetMapping("/{id}")
    public Result getOne(@PathVariable("id") Integer id){
        Result getOne = commManagerService.selectByPrimaryKey(id);
        return getOne;
    }

    @PutMapping("")
    public Result update(@RequestBody CommManager commManager){
        Result updateComm = commManagerService.updateByPrimaryKeySelective(commManager);
        return updateComm;
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Result deleteComm = commManagerService.deleteByPrimaryKey(id);
        return deleteComm;
    }


    @PostMapping("/upload")
    public Result upload(MultipartFile file, HttpServletRequest req){
        String path = req.getSession().getServletContext().getRealPath("/images");

        return commManagerService.upload(file,path);
    }


    @RequestMapping("/deleAll")
    public Result deleteAll( String ids){
        String[] ids1 = ids.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String id : ids1) {
            int id1 = Integer.parseInt(id);
            list.add(id1);
        }
        System.out.println(list);
        Result deleteIds = commManagerService.deleteAll(list);
        return deleteIds;
    }
}
