package me.pharmacy.services;

import me.pharmacy.dao.DuePayHistryRepository;
import me.pharmacy.model.CustomerInfo;
import me.pharmacy.model.DuePayHistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Minhaz on 1/26/2020.
 */
@Service
public class DuePayHistryService {
    @Autowired
    private DuePayHistryRepository duePayHistryRepository;

    public DuePayHistry saveCustomerInfo(DuePayHistry duePayHistry) {
        return duePayHistryRepository.save(duePayHistry);
    }
    public  List<DuePayHistry> getDuePayHistry(int customerId)
    {
        return duePayHistryRepository.findByCustomerId(customerId);
    }
}
