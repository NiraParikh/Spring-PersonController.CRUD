package io.zipcoder.crudapp;

import org.springframework.data.repository.CrudRepository;

/**
 * @author leon on 08/01/2019.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
