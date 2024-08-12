package com.itmuch.contentcenter;


import com.itmuch.contentcenter.dao.share.ShareMapper;
import com.itmuch.contentcenter.domain.entity.share.Share;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    /**
     * // 作业1：课后研究一下@Resource和@Autowired的区别
     * // 面试题
     */
    @Autowired(required = false)
    private final ShareMapper shareMapper;

    @GetMapping("/test")
    public List<Share> testInsert() {
        // 1. 做插入
        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("大目");
        share.setBuyCount(1);

        this.shareMapper.insertSelective(share);

        // 2. 做查询: 查询当前数据库所有的share  select * from share ;

        return this.shareMapper.selectAll();
    }

    // q?id=1&wxId=aaa&...
    @GetMapping("/q")
    public Share query(Share share) {
        return share;
    }
}
