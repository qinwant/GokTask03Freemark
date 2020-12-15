package com.kingwan.freemarkword.pojo;

import lombok.Data;

import java.util.List;

/**
 * Created by kingwan on 2020/12/6.
 * 说明：基础简历模板实体类
 */
@Data
public class BaseResume {
    private String RsName;//姓名
    private String RsBirthday;//生日
    private String RsNative;//籍贯
    private String RsEducation;//学历
    private String RsTelephone;//电话
    private String RsMail;//邮箱
    private String RsAddress;//住址
    private String RsPicUrl;//照片地址
    private String RsPosition;//应聘职位
    private List<String> RsSkills;//个人技能
    private RsEduBackground rsEduBackground;//教育背景
    private String rsSelfEvaluation;//自我评价

}
