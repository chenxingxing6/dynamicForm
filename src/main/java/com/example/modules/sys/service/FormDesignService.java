package com.example.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.common.utils.PageUtils;
import com.example.modules.sys.entity.FormDesignEntity;

import java.util.Map;

/**
 * 自定义表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
public interface FormDesignService extends IService<FormDesignEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

