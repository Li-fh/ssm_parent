package com.lfh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfh.dao.ProductDao;
import com.lfh.domain.PageBean;
import com.lfh.domain.Product;
import com.lfh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }

    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    public void update(Product product) {
        productDao.update(product);
    }

    public void delById(Integer id) {
        productDao.delById(id);
    }

    public void delMany(Integer[] ids) {
        //判空
        if (ids != null){
            for (Integer id:ids){
                productDao.delById(id);
            }
        }
    }

    public PageBean<Product> findByPage(Integer currPage, Integer pageSize) {
        //创建PageBean
        PageBean<Product> pageBean = new PageBean<>();
        //封装Bean
        //当前页：页面传参private Integer currPage;
        pageBean.setCurrPage(currPage);
        //每条页数：页面传参 private Integer pageSize;
        pageBean.setPageSize(pageSize);
        //总条数：数据库查询private Integer totalCount;
        Integer totalCount =  productDao.findTotalCount();
        pageBean.setTotalCount(totalCount);
        //总页数：计算 Math.ceil(totalCount * 1.0 /pageSize)private Integer totalPage;
        pageBean.setTotalPage((int) Math.ceil(totalCount * 1.0 /pageSize));
        //页面展示的数据：数据库的查询private List<T> list;
        /**
         * mysql:limit m,n;
         * m:每一页的起始索引 n:每页条数
         *
         */
        Integer startIndex = (currPage-1)*pageSize;
        List<Product> productList = productDao.findByPage(startIndex,pageSize);
        pageBean.setList(productList);
        //返回PageBean
        return pageBean;
    }

/*    @Override
    public void testPageHelper(Integer currPage, Integer pageSize) {
        //1.开始分页
        PageHelper.startPage(currPage,pageSize);
        //2.查询全部
        List<Product> productList = productDao.findAll();
        //3.创建PageInfo对象，相当于pageBean
        //参数1：把查询到的数据传入构造方法
        //参数2：可以指定页面要显示的最多的页码数
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("每页条数："+pageInfo.getPageSize());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("数据："+pageInfo.getList().size());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否下一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        System.out.println("页面上展示的第一个页码："+pageInfo.getNavigateFirstPage());
        System.out.println("页面上展示的最后一个页码："+pageInfo.getNavigateLastPage());
    }*/

    @Override
    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize) {
        //1.开始分页
        PageHelper.startPage(currPage,pageSize);
        //2.查询所有
        List<Product> productList = productDao.findAll();
        //3.创建PageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }

/*    @Override
    public PageInfo<Product> findByPageHelper(Integer currPage, Integer pageSize) {
        //1.开始分页
        PageHelper.startPage(currPage,pageSize);
        //2.查询所有
        List<Product> productList = productDao.findAll();
        //3.创建PageInfo对象
        PageInfo<Product> pageInfo = new PageInfo<>(productList,5);
        return pageInfo;
    }*/
}
