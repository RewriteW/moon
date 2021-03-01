package com.github.moon.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.github.moon.product.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.moon.product.entity.CategoryEntity;
import com.github.moon.product.service.CategoryService;
import com.github.common.utils.PageUtils;
import com.github.common.utils.R;



/**
 * 商品三级分类
 *
 * @author wsg
 * @email wsg@gmail.com
 * @date 2021-02-27 09:56:57
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("product:category:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){
		//categoryService.removeByIds(Arrays.asList(catIds));

		//检查当前删除的菜单，是否被别的地方引用
        categoryService.removeMenusByIds(Arrays.asList(catIds));
        return R.ok();
    }

    /**
     * 查出所有分类以及子分类，以树结构组装列表
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> categoryEntityList = categoryService.listWithThree();
        return R.ok().put("data", categoryEntityList);
    }

    /**
     * 查出所有分类以及子分类，以树结构组装列表2
     */
    @RequestMapping("/list/tree2")
    //@RequiresPermissions("product:category:list")
    public R list2(){
        List<CategoryVo> categoryEntityList = categoryService.listWithThree2();
        return R.ok().put("data", categoryEntityList);
    }

}
