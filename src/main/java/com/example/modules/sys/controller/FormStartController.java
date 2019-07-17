package com.example.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

import com.example.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.sys.entity.FormStartEntity;
import com.example.modules.sys.service.FormStartService;
import com.example.common.utils.PageUtils;
import com.example.common.utils.R;



/**
 * 发起表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
@RestController
@RequestMapping("sys/formstart")
public class FormStartController {
    @Autowired
    private FormStartService formStartService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:formstart:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = formStartService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sys:formstart:info")
    public R info(@PathVariable("id") Long id){
        FormStartEntity formStart = formStartService.selectById(id);

        return R.ok().put("formStart", formStart);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:formstart:save")
    public R save(@RequestBody FormStartEntity formStart){
        formStartService.insert(formStart);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:formstart:update")
    public R update(@RequestBody FormStartEntity formStart){
        ValidatorUtils.validateEntity(formStart);
        formStartService.updateAllColumnById(formStart);//全部更新

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:formstart:delete")
    public R delete(@RequestBody Long[] ids){
        formStartService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
