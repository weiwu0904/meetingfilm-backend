package com.weiwu.meetingfilm.backend.common.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weiwu.meetingfilm.backend.common.BackendCommonApplicationTests;
import com.weiwu.meetingfilm.common.entity.MoocBackendUserT;
import com.weiwu.meetingfilm.common.mapper.MoocBackendUserTMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

public class UserTests extends BackendCommonApplicationTests {

    @Resource
    private MoocBackendUserTMapper userTMapper;

    @Test
    public void insert() {

        for (int i = 0; i < 5; i++) {
            MoocBackendUserT userT = new MoocBackendUserT();
            userT.setUserName("admin" + i);
            userT.setUserPwd("admin" + i);
            userT.setUserPhone("123123123132");

            userTMapper.insert(userT);
        }
    }

    @Test
    public void select() {

        QueryWrapper<MoocBackendUserT> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", "admin4");
        List<MoocBackendUserT> users = userTMapper.selectList(queryWrapper);
        users.stream().forEach((item) -> {
            System.out.println("item = " + item);
        });
    }


    @Test
    public void update() {
        MoocBackendUserT userT = new MoocBackendUserT();
        userT.setUuid(02);
        userT.setUserName("admin");
        userT.setUserPwd("weiwu");
        userT.setUserPhone("1821231231");

        userTMapper.updateById(userT);
    }
}
