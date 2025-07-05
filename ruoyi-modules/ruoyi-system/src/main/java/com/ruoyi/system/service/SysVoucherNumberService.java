package com.ruoyi.system.service;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.MapstructUtils;
import com.ruoyi.common.mybatis.core.domain.BaseEntity;
import com.ruoyi.common.mybatis.core.page.TableDataInfo;
import com.ruoyi.common.mybatis.core.page.PageQuery;
import com.ruoyi.common.core.utils.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.bo.SysVoucherNumberBo;
import com.ruoyi.system.domain.vo.SysVoucherNumberVo;
import com.ruoyi.system.domain.entity.SysVoucherNumber;
import com.ruoyi.system.mapper.SysVoucherNumberMapper;

import java.util.List;
import java.util.Map;
import java.util.Collection;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ${author}
 * @date 2025-07-03
 */
@RequiredArgsConstructor
@Service
public class SysVoucherNumberService {

    private final SysVoucherNumberMapper sysVoucherNumberMapper;

    public SysVoucherNumberVo queryVoucherNumber(String voucherTypeCode) {
        SysVoucherNumberVo sysVoucherNumberVo1 = sysVoucherNumberMapper.selectVoOne(buildQueryWrapper(voucherTypeCode));
        if(sysVoucherNumberVo1 == null){
            SysVoucherNumberBo sysVoucherNumberBo = SysVoucherNumberBo.builder()
                .voucherCode(voucherTypeCode)
                .bDate(DateUtils.getNowDate(DateUtils.YYYY_MM_DD))
                .build();
            sysVoucherNumberMapper.update(MapstructUtils.convert(sysVoucherNumberBo, SysVoucherNumber.class), buildUpdateWrapper(sysVoucherNumberBo));
        }
        SysVoucherNumberVo sysVoucherNumberVo = sysVoucherNumberMapper.selectVoOne(buildQueryWrapper(voucherTypeCode));
        StringBuilder voucherCode = new StringBuilder();
        switch (sysVoucherNumberVo.getRule()) {
            case 1->{
                voucherCode = new StringBuilder(sysVoucherNumberVo.getVoucherCode()
                    .concat(DateUtils.dateTime())
                    .concat(generateSerNo(sysVoucherNumberVo.getNumber(), sysVoucherNumberVo.getSize())));
            }
            case 2->{
                voucherCode = new StringBuilder(sysVoucherNumberVo.getVoucherCode()
                    .concat(DateUtils.dateTimeNow(DateUtils.YY_MM_DD))
                    .concat(generateSerNo(sysVoucherNumberVo.getNumber(), sysVoucherNumberVo.getSize())));
            }
        }
        sysVoucherNumberVo.setVoucherCode(voucherCode.toString());
        return sysVoucherNumberVo;
    }

    /**
     * 修改【流水号】
     *
     * @param bo 【请填写功能名称】
     */
    public void updateVoucherNumber(SysVoucherNumberBo bo){
        bo.setBDate(DateUtils.getNowDate());
        sysVoucherNumberMapper.update(MapstructUtils.convert(bo, SysVoucherNumber.class), buildUpdateWrapper(bo));
    }


    private static String generateSerNo(int maxNo,int size) {
        String format = "";
        if(size == 4){
            if (maxNo < 0) {
                throw new IllegalArgumentException("maxNo 不能为负数");
            }
            if (maxNo < 10) {
                format = "000%d";
            } else if (maxNo < 100) {
                format = "00%d";
            } else if (maxNo < 1000) {
                format = "0%d";
            } else {
                throw new IllegalArgumentException("maxNo 超出范围（必须小于1000）");
            }
        }else if(size == 8){
            // 先不写
        }
        return String.format(format, maxNo);
    }

    private LambdaQueryWrapper<SysVoucherNumber> buildQueryWrapper(String bo) {
        LambdaQueryWrapper<SysVoucherNumber> lqw = Wrappers.lambdaQuery();
        lqw.eq(StringUtils.isNotBlank(bo), SysVoucherNumber::getVoucherCode, bo);
        lqw.eq(SysVoucherNumber::getBDate, DateUtils.getNowDate(DateUtils.YYYY_MM_DD));
        return lqw;
    }

    private LambdaUpdateWrapper<SysVoucherNumber> buildUpdateWrapper(SysVoucherNumberBo bo) {
        LambdaUpdateWrapper<SysVoucherNumber> luw = Wrappers.lambdaUpdate();
        luw.setSql("number = number + 1");
        luw.eq(SysVoucherNumber::getVoucherCode, bo.getVoucherCode());
        return luw;
    }
}
