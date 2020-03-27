package com.zxc.demo.Model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

@Data
@TableName("zxc_tab")
public class All {

    @TableId
    private String id;

    @TableField("name_ch")
    private String nameCh;

    @TableField("name_en")
    private String nameEn;

    @TableField("delState")
    private String del_state;

}
