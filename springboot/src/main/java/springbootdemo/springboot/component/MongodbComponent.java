package springbootdemo.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import springbootdemo.springboot.entity.SbUser;

@Component
public class MongodbComponent {
    @Autowired
    private MongoTemplate mongoTemplate;
    public void insert(SbUser sbUser) {
        mongoTemplate.insert(sbUser);
    }
    public void deleteById(int id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        mongoTemplate.remove(query, SbUser.class);
    }
    public void updateById(SbUser roncooUser) {
        Criteria criteria = Criteria.where("id").in(roncooUser.getId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("name", roncooUser.getName());
        update.set("createTime", roncooUser.getCreateTime());
        mongoTemplate.updateMulti(query, update, SbUser.class);
    }
    public SbUser selectById(int id) {
        Criteria criteria = Criteria.where("id").in(id);
        Query query = new Query(criteria);
        return mongoTemplate.findOne(query, SbUser.class);
    }

}
