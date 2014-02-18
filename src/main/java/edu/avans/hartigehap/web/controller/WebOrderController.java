package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.Ingredient;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.price.PriceCalculatorFactory;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import edu.avans.hartigehap.service.WebOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * Created by David-Paul on 11-2-14.
 */
@Controller
public class WebOrderController {
    @Autowired
    private WebOrderService webOrderService;

    @RequestMapping(value = "hartigehap/webwinkel/winkelmandje", method = RequestMethod.GET)
    public String showBasket(@CookieValue(value = "webOrderId", defaultValue = "-1") String cookieValue, Model uiModel, HttpServletResponse response) {
        long webOrderId = extractIdFromCookieValue(cookieValue);

        if (webOrderId < 0) {
            // Either the cookie has been messed with or does not exist.
            createNewWebOrder(webOrderId, uiModel, response);
        }

        WebOrder webOrder = webOrderService.getWebOrderById(webOrderId);

        if (webOrder == null) {
//            uiModel.addAttribute("error", "WebOrder is null");
            createNewWebOrder(webOrderId, uiModel, response);
        } else if (webOrder.getCustomer() != null) {
            uiModel.addAttribute("result", webOrder.getCustomer().getName());
        }

//        uiModel.addAttribute("webOrderId", "Cookieid " + webOrderId + " was already set." + "\n " );

        return "hartigehap/webwinkel/winkelmandje";
    }



    private void createNewWebOrder(long cookieid, Model uiModel, HttpServletResponse response) {
        cookieid = webOrderService.createNewWebOrder();
        Cookie newCookie = new Cookie("webOrderId", "" + cookieid);
        newCookie.setMaxAge(60 * 60 * 24 *5);
        response.addCookie(newCookie);
        uiModel.addAttribute("webOrderId", "New Cookie id" + cookieid + " is been set.");
    }

    /**
     * Extracts weborder ID from cookie value
     *
     * @param cookieValue
     * @todo move to service?
     * @return long         weborderId
     */
    private long extractIdFromCookieValue(String cookieValue)
    {
        long id = -1L;

        try {
            id = Long.parseLong(cookieValue);
        } catch (NumberFormatException e) {
            // Cookie has been modified, do some logging here.
        }

        return id;
    }

//    public long createNewWebOrder() {
//
//    }
//
//    public String addWebOrderItem(long sessionId, MenuItem menuItem, List<Ingredient> ingredients) {
//
//    }
//
//    public String deleteWebOrderItem(long sessionId, String WebOrderItemName) {
//
//    }
//
//    public String webOrderInProgress(long sessionId) {
//
//    }
//
//    public String webOrderPayed(long sessionId) {
//
//    }
}
