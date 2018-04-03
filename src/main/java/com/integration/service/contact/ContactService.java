package com.integration.service.contact;

import com.integration.domain.Contact;
import org.springframework.data.domain.Page;

/**
 *
 */
public interface ContactService {
    Contact create(Contact contact);

    Contact fetch(long id);

    void update(Contact contact);

    void delete(Long id);

    //http://www.baeldung.com/rest-api-pagination-in-spring
    Page<Contact> getAll(Integer page, Integer size);
}
