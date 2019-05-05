package com.angular.angulardemo.data;

import com.angular.angulardemo.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
}
