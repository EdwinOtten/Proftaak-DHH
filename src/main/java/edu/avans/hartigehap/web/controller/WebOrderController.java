package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.Ingredient;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.price.PriceCalculatorFactory;
import edu.avans.hartigehap.domain.weborder.WebCustomer;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import edu.avans.hartigehap.repository.WebCustomerRepository;
import edu.avans.hartigehap.service.WebCustomerService;
import edu.avans.hartigehap.service.WebOrderService;
import edu.avans.hartigehap.web.form.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Created by David-Paul on 11-2-14.
 */
@Controller
public class WebOrderController {
    @Autowired
    private WebOrderService webOrderService;
    @Autowired
    private WebCustomerService webCustomerService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "weborders/{weborderid}/customers", params = "form", method = RequestMethod.GET)
    public String createCustomerForm(@PathVariable("weborderid") long id, Model uiModel) {
        WebCustomer customer = new WebCustomer();
        uiModel.addAttribute("customer", customer);
        return "hartigehap/webshop/editcustomer";
    }

    @RequestMapping(value = "weborders/{weborderid}/customers", params="form", method= RequestMethod.POST)
    public String createCustomer(@PathVariable("weborderid") long id, @Valid WebCustomer customer, BindingResult bindingResult,
                                 Model uiModel, HttpServletRequest httpServletRequest,
                                 RedirectAttributes redirectAttributes, Locale locale) {
        if(bindingResult.hasErrors()) {
            uiModel.addAttribute(
                    "message",
                    new Message("error", messageSource.getMessage(
                            "customer_save_fail", new Object[] {}, locale)));
            uiModel.addAttribute("customer", customer);
            return "hartigehap/editcustomer";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute(
                "message",
                new Message("success", messageSource.getMessage(
                        "customer_save_success", new Object[] {}, locale)));

        WebCustomer storedCustomer = webCustomerService.save(id, customer);

//        return "redirect:/restaurants/" + restaurantName + "/customers/"
//                + UrlUtil.encodeUrlPathSegment(storedCustomer.getId().toString(),
//                httpServletRequest);

        return "hartigehap/webwinkel/winkelmandje";

    }


    @RequestMapping(value = "webwinkel/winkelmandje", method = RequestMethod.GET)
    public String showBasket(@CookieValue(value = "webOrderId", defaultValue = "-1") String cookieValue, Model uiModel, HttpServletResponse response) {
        long webOrderId = extractIdFromCookieValue(cookieValue);

        uiModel.addAttribute("webOrderId", webOrderId);

        if (webOrderId < 0) {
            // Either the cookie has been messed with or does not exist.
            createNewWebOrder(webOrderId, uiModel, response);
        }

        WebOrder webOrder = webOrderService.getWebOrderById(webOrderId);

        if (webOrder == null) {
//            uiModel.addAttribute("error", "WebOrder is null");
            createNewWebOrder(webOrderId, uiModel, response);
        } else if (webOrder.getCustomer() != null) {
            uiModel.addAttribute("customerName", webOrder.getCustomer().getName());
        } else {
            uiModel.addAttribute("customerName", "");
        }
        
        if (webOrder != null) {
	        Collection<WebOrderItem> webOrderItems = webOrder.getWebOrderItems();
	        uiModel.addAttribute("orderItems", webOrderItems);
        }
        

        return "hartigehap/webwinkel/winkelmandje";
    }



    private void createNewWebOrder(long cookieid, Model uiModel, HttpServletResponse response) {
        cookieid = webOrderService.createNewWebOrder();
        Cookie newCookie = new Cookie("webOrderId", "" + cookieid);
        newCookie.setMaxAge(60 * 60 * 24 *5);
        response.addCookie(newCookie);
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
