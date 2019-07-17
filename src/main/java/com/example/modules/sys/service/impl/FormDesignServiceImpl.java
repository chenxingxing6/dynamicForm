package com.example.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.modules.sys.dao.FormDesignDao;
import com.example.modules.sys.entity.FormDesignEntity;
import com.example.modules.sys.service.FormDesignService;


@Service("formDesignService")
public class FormDesignServiceImpl extends ServiceImpl<FormDesignDao, FormDesignEntity> implements FormDesignService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FormDesignEntity> page = this.selectPage(
                new Query<FormDesignEntity>(params).getPage(),
                new EntityWrapper<FormDesignEntity>()
        );

        return new PageUtils(page);
    }

}
