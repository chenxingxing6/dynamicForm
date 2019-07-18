package com.example.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.common.utils.IdGen;
import com.example.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.sys.entity.FormDesignEntity;
import com.example.modules.sys.service.FormDesignService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;

import javax.annotation.Resource;


/**
 * 自定义表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
@RestController
@RequestMapping("sys/formdesign")
public class FormDesignController extends AbstractController{
    @Autowired
    private FormDesignService formDesignService;
    @Resource
    private IdGen idGen;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:formdesign:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = formDesignService.queryPage(params);
        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:formdesign:info")
    public R info(@PathVariable("id") Long id){
        FormDesignEntity formDesign = formDesignService.selectById(id);

        return R.ok().put("formDesign", formDesign);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:formdesign:save")
    public R save(@RequestBody FormDesignEntity formDesign){
        formDesign.setId(idGen.nextId());
        formDesign.setCreateTime(System.currentTimeMillis());
        formDesign.setCreateUser(getUserId().toString());
        formDesignService.insert(formDesign);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:formdesign:update")
    public R update(@RequestBody FormDesignEntity formDesign){
        ValidatorUtils.validateEntity(formDesign);
        formDesign.setOpTime(System.currentTimeMillis());
        formDesign.setOpUser(getUserId().toString());
        formDesignService.updateAllColumnById(formDesign);//全部更新
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:formdesign:delete")
    public R delete(@RequestBody Long[] ids){
        formDesignService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
