package edu.avans.hartigehap.service.jpa;

import edu.avans.hartigehap.domain.weborder.WebCustomer;
import edu.avans.hartigehap.domain.weborder.WebOrder;
import edu.avans.hartigehap.repository.WebCustomerRepository;
import edu.avans.hartigehap.repository.WebOrderRepository;
import edu.avans.hartigehap.service.WebCustomerService;
import edu.avans.hartigehap.service.WebOrderService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by David-Paul on 15-2-14.
 */
@Service("webCustomerService")
@Repository
@Transactional
public class WebCustomerServiceImpl implements WebCustomerService {
    final Logger logger = org.slf4j.LoggerFactory.getLogger(WebCustomerRepository.class);

    @Autowired
    private WebOrderService webOrderService;

    @Autowired
    private WebCustomerRepository webCustomerRepository;

    @Override
    public WebCustomer getCustomerBySessionId(long sessionId) {
        WebCustomer webCustomer = webOrderService.getWebOrderById(sessionId).getCustomer();
        return webCustomer;
    }

    @Override
    public WebCustomer save(long sessionId, WebCustomer webCustomer) {
        webCustomerRepository.save(webCustomer);
        webOrderService.setWebCustomer(sessionId, webCustomer);
        return webCustomer;
    }

    @Override
    public void delete(WebCustomer webCustomer) {
        webCustomerRepository.delete(webCustomer);
    }
}
