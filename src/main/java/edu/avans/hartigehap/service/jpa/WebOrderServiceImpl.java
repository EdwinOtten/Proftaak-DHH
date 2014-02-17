package edu.avans.hartigehap.service.jpa;

import edu.avans.hartigehap.domain.Ingredient;
import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.WebOrderItem;
import edu.avans.hartigehap.domain.price.PriceCalculatorFactory;
import edu.avans.hartigehap.domain.weborder.WebCustomer;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import edu.avans.hartigehap.repository.WebOrderRepository;
import edu.avans.hartigehap.service.WebOrderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by David-Paul on 11-2-14.
 */
@Service("weborderService")
@Repository
@Transactional
public class WebOrderServiceImpl implements WebOrderService{
    final Logger logger = org.slf4j.LoggerFactory.getLogger(WebOrderRepository.class);

    @Autowired
    private WebOrderRepository webOrderRepo;

    @Transactional(readOnly = true)
    @Override
    public WebOrder getWebOrderById(long sessionId) {
        return webOrderRepo.findOne(sessionId);
    }

    @Override
    public WebOrder save(WebOrder webOrder) {
        return webOrderRepo.save(webOrder);
    }

    @Override
    public void delete(WebOrder webOrder) {
        webOrderRepo.delete(webOrder);
    }

    @Override
    public long createNewWebOrder() {
        WebOrder webOrder = new WebOrder(PriceCalculatorFactory.getInstance().create());
        save(webOrder);
        return webOrder.getId();
    }

    @Override
    public void setWebCustomer(long sessionId, WebCustomer webCustomer) {
        WebOrder webOrder = webOrderRepo.findOne(sessionId);
        webOrder.setCustomer(webCustomer);
        webOrderRepo.save(webOrder);
    }
}
