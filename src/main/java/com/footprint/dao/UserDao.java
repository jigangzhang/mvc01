package com.footprint.dao;

import com.footprint.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("userDao")
public class UserDao extends HibernateDaoSupport implements IBaseDao<User> {

    @Resource
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        this.setSessionFactory(sessionFactory);
    }

    public void add(User user) {
        this.getHibernateTemplate().save(user);
    }

    public void delete(int id) {
        User user = this.get(id);
        if (user!=null)
            this.getHibernateTemplate().delete(id);
    }

    public void update(User user) {
        this.getHibernateTemplate().update(user);
    }

    public User get(int id) {
        return this.getHibernateTemplate().get(User.class, id);
    }
    public User findUserByName(String name){
        return this.currentSession().createQuery("from t_user where name=?", User.class)
                .setParameter(0, name).uniqueResult();
    }
    public List<User> getUsers(Map<String, Object> params){
//        this.currentSession().createQuery("from t_user where name=? limit ?, ?", User.class);
        return null;
    }
    public List<User> getAll() {
        return this.getHibernateTemplate().loadAll(User.class);
    }
}
