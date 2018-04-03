package com.integration.service.contact.impl;

import com.integration.domain.Contact;
import com.integration.dao.jpa.ContactsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class ContactServiceImpl implements com.integration.service.contact.ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public ContactServiceImpl() {
    }

    @Override
    public Contact create(Contact contact) {
        return contactsRepository.save(contact);
    }

    @Override
    public Contact fetch(long id) {
        return contactsRepository.findOne(id);
    }

    @Override
    public void update(Contact contact) {
        contactsRepository.save(contact);
    }

    @Override
    public void delete(Long id) {
        contactsRepository.delete(id);
    }

    //http://www.baeldung.com/rest-api-pagination-in-spring
    @Override
    public Page<Contact> getAll(Integer page, Integer size) {
        Page pageOfContacts = contactsRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("com.integration.service.contact.impl.ContactService.getAll.largePayload");
        }
        return pageOfContacts;
    }
}
