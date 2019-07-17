package com.example.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.modules.sys.dao.FormStartDao;
import com.example.modules.sys.entity.FormStartEntity;
import com.example.modules.sys.service.FormStartService;


@Service("formStartService")
public class FormStartServiceImpl extends ServiceImpl<FormStartDao, FormStartEntity> implements FormStartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FormStartEntity> page = this.selectPage(
                new Query<FormStartEntity>(params).getPage(),
                new EntityWrapper<FormStartEntity>()
        );

        return new PageUtils(page);
    }

}
