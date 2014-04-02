package com.makduck.controller;

import com.makduck.dao.ItemMapper;
import com.makduck.model.Item;
import com.makduck.model.ItemExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.List;

/**
 * User: dubu
 * Date: 14. 3. 28
 * Time: 오후 3:16
 */
@Controller
public class ItemListController {

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {

        ItemExample itemExample = new ItemExample();
        itemExample.createCriteria().andUnitcostBetween(new BigDecimal("10.0"), new BigDecimal("90.0"));
        List<Item> items = itemMapper.selectByExample(itemExample);
        model.addAttribute("items", items);
        return "item/list";
    }
}
