package com.example.demo.VipUser;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VipUserRepository extends MongoRepository<VipUser, String> {

    // Find a VipUser by name
    @Query("{name:'?0'}")
    Optional<VipUser> findVipUserByName(String name);

    // Find a VipUser by email, only returning the name, age and date of birth fields
    @Query(value = "{email:'?0'}", fields = "{'name' : 1, 'age' : 1, 'dob' : 1}")
    Optional<VipUser> findVipUserByEmail(String email);

    // Find VipUser by VIP status
    @Query("{vipStatus: '?0'}")
    Optional<VipUser> findVipUserByVipStatus(String vipStatus);

    // Count VipUsers by age
    @Query(value = "{age: ?0}", count = true)
    long countByAge(Integer age);
}
