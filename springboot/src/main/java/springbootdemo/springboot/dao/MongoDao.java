package springbootdemo.springboot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import springbootdemo.springboot.entity.JpaUser;

public interface MongoDao extends MongoRepository<JpaUser, Integer> {
    JpaUser findByUserName(String string);
    JpaUser findByUserNameAndUserIp(String string, String ip);
    Page<JpaUser> findByUserName(String string, Pageable pageable);

}
