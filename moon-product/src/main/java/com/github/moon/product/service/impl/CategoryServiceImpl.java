package com.github.moon.product.service.impl;

import com.github.moon.product.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.common.utils.PageUtils;
import com.github.common.utils.Query;

import com.github.moon.product.dao.CategoryDao;
import com.github.moon.product.entity.CategoryEntity;
import com.github.moon.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @Description: 查出所有分类以及子分类，以树结构组装列表
     * @Param: []
     * @return: java.util.List<com.github.moon.product.entity.CategoryEntity>
     * @Author: wsg
     * @Date: 2021/2/27
     */
    @Override
    public List<CategoryEntity> listWithThree() {
        //1、查出所有分类
        List<CategoryEntity> categoryEntityList = baseMapper.selectList(null);
        //2、组装父子结构
        //一级菜单
        List<CategoryEntity> level1Menus = categoryEntityList.stream().filter((categoryEntity) ->
             categoryEntity.getParentCid() == 0
        ).map((menu)->{
            //递归 2级菜单
            //用一级(0,1)的子id  作为二级的父id(1,2)
            menu.setChildren(getChildrens(menu.getCatId(),categoryEntityList));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) -
                    (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());


        return level1Menus;
    }

    //递归查找所有菜单的子菜单
    private List<CategoryEntity> getChildrens(Long catId,List<CategoryEntity> all){

        List<CategoryEntity> children = all.stream().filter((categoryEntity) -> {
            return categoryEntity.getParentCid().equals(catId);
        }).map((categoryEntity) -> {
            //找到子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity.getCatId(), all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) -
                    (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return children;
    }

    @Override
    public List<CategoryVo> listWithThree2() {
        //1、查出所有分类
        List<CategoryEntity> allCategory = baseMapper.selectList(null);
        //2、组装父子结构
        List<CategoryVo> categoryTree = findChildrenCategory(allCategory, 0L);
        return categoryTree;
    }

    private List<CategoryVo> findChildrenCategory(List<CategoryEntity> allCateGory, Long parentCategoryId) {
        // 找 2 级
        return allCateGory.stream()
                .filter(category -> category.getParentCid().equals(parentCategoryId))
                .map(category -> {
                    // TODO 已处理的数据 进行删除 下一次就不会重新处理
//                    allCateGory.remove(category) ;
                    // 属性对拷
                    CategoryVo categoryVo = new CategoryVo();
                    BeanUtils.copyProperties(category,categoryVo);
                    // 找  3 级
                    categoryVo.setChildren(findChildrenCategory(allCateGory, category.getCatId()));
                    return categoryVo;
                })
                .sorted(Comparator.comparing(CategoryVo::getSort,
                        Comparator.nullsFirst(Comparator.naturalOrder())))//排序，先进行空值判断处理
                .collect(Collectors.toList());
    }

    /**
     * @param asList
     * @Description: 检查当前删除的菜单，是否被别的地方引用
     * @Param: [asList]
     * @return: void
     * @Author: wsg
     * @Date: 2021/2/28
     */
    @Override
    public void removeMenusByIds(List<Long> asList) {

        //TODO 1、检查当前删除的菜单，是否被别的地方引用
        //逻辑删除 只是标识删除 实体需加注解@Tablelogic
        baseMapper.deleteBatchIds(asList);

    }

}