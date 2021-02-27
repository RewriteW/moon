package com.github.moon.product.vo;




import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;
/**
 * @Author: wsg
 * @Date: 2021/02/27/14:39
 * @Description:
 */
/**
 * 分类 的 页面数据
 *
 * @author aqiang9  2020-07-27
 */
@Data
@ApiModel
public class CategoryVo {
    @ApiModelProperty(value = "分类id" , notes = "添加时不能有, 修改必须指定")
    private Long catId;


    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("父分类id")
    private Long parentCid;

    @ApiModelProperty(value = "层级", allowableValues = "1,2,3")
    private Integer catLevel;

    @ApiModelProperty(value = "是否显示[0-不显示，1显示]", allowableValues = "0,1")
    private Integer showStatus;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序", allowableValues = "[0,infinity]")
    private Integer sort;


    @ApiModelProperty(value = "图标地址" , dataType = "String")
    private String icon;
    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位" , dataType = "String")
    private String productUnit;
    /**
     * 商品数量
     */

    @ApiModelProperty(value = "商品数量" , allowableValues = "[0,infinity]")
    @PositiveOrZero(message = "商品数量必须 大于0 ")
    private Integer productCount;
    /**
     * 子菜单
     */
    @ApiModelProperty(value = "子菜单" , allowEmptyValue = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CategoryVo> children;
}
