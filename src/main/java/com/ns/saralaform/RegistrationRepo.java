package com.ns.saralaform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepo extends CrudRepository<Registeration, Integer>  {

}
