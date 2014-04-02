package com.makduck.model.service;

import com.makduck.dao.ProductMapper;
import com.makduck.model.Product;
import com.makduck.model.ProductExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: dubu
 * Date: 14. 3. 28
 * Time: 오후 2:32
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext-test.xml"})
public class ProductServiceTest {



    private static final Log log = LogFactory.getLog(ProductServiceTest.class);

    @Resource
    private ProductMapper productMapper;

    @Test
    public void select() {
        Product rs = productMapper.selectByPrimaryKey("AV-CB-01");
        log.info(rs);
    }

    @Test
    public void catiaTest() {
        ProductExample where = new ProductExample();
        where.createCriteria().andNameEqualTo("Koi").andCategoryEqualTo("FISH");
        List<Product> rs =  productMapper.selectByExample(where);
        log.info(rs);
    }


    @Test
    public void updateTest(){
        Product product = new Product();
        product.setName("KoiXX");

        ProductExample where = new ProductExample();
        where.createCriteria().andProductidEqualTo("FI-FW-01");
        productMapper.updateByExampleSelective(product,where);
    }


}
