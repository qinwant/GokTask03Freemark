package com.kingwan.freemarkword.pojo;

import lombok.Data;

/**
 * Created by kingwan on 2020/12/6.
 * 说明：简历信息实体类
 */
@Data
public class ResumeInfo {

    private String RsTitle; //简历标题
    private BaseResume resumeInfo; //简历详细信息
}
