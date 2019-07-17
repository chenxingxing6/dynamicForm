package com.example.modules.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.common.utils.PageUtils;
import com.example.modules.sys.entity.FormStartEntity;

import java.util.Map;

/**
 * 发起表单
 *
 * @author lanxinghua
 * @email lanxinghua@2dfire.com
 * @date 2019-07-17 21:34:56
 */
public interface FormStartService extends IService<FormStartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

