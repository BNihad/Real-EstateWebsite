package com.example.secondmainproject.Controller;


import com.example.secondmainproject.Model.WishList;
import com.example.secondmainproject.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {
//    @Autowired
//    private ClothesService clothesService;



    @Autowired
    private PropertyService clothesService;


    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session) {

        return "/wishlist";
    }
    private int isExits(int id, List<WishList> wishLists) {
        for (int i = 0; i < wishLists.size(); i++) {
            if (wishLists.get(i).getPropertyEntity().getId() == id) {
                return i;
            }
        }
        return -1;
    }

//    @GetMapping("/cart")
//    public String cart(Model model) {
//        var productEntities = clothesService.getClothesMen();
//        return "cart";
//    }


    @RequestMapping(value = "add/{id}", method = RequestMethod.GET)
    public String buy(@PathVariable("id") int id, ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("wishlist") == null) {

            List<WishList> wishlist = new ArrayList<WishList>();
            wishlist.add(new WishList(clothesService.findById(id), 1));
            session.setAttribute("wishlist", wishlist);
        } else {
            List<WishList> wishlist= (List<WishList>) session.getAttribute("wishlist");
            int index = isExits(id, wishlist);
            if (index == -1) {
                wishlist.add(new WishList(clothesService.findById(id), 1));
            } else {
                int quantity = wishlist.get(index).getQuantity() + 1;
                wishlist.get(index).setQuantity(quantity);
            }
            session.setAttribute("wishlist", wishlist);


        }
        return "redirect:/wishlist";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String[] quantities = request.getParameterValues("quantity");
        List<WishList> wishlist = (List<WishList>) session.getAttribute("wishlist");
        for (int i = 0; i < wishlist.size(); i++) {
            wishlist.get(i).setQuantity(Integer.parseInt(quantities[i]));
        }
        session.setAttribute("wishlist", wishlist);
        return "redirect:/wishlist";

    }

    @RequestMapping(value = "clear", method = RequestMethod.GET)
    public String clear(HttpServletRequest request)   {
        HttpSession session = request.getSession();

        List<WishList> wishlist = (List<WishList>) session.getAttribute("wishlist");
        wishlist.clear();
        session.setAttribute("wishlist", wishlist);
        if (wishlist==null){

            session.setAttribute("wishlist", "/");
        }

        return "redirect:/wishlist";

    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, HttpServletRequest request) {

        HttpSession session = request.getSession();
        List<WishList> wishlist = (List<WishList>) session.getAttribute("wishlist");
        int index = isExits(id, wishlist);
        wishlist.remove(index);
        session.setAttribute("cart", wishlist);
        return "redirect:/wishlist";

    }


}
