package com.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vn.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product create(Product product) {
		return null;
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<Product> findAll(Integer pageNum, Integer pageSize) {
		try (Session session = sessionFactory.openSession()){
			
			org.hibernate.Query query = session.createQuery("SELECT p FROM Product p");
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);
			return query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	@Override
	public Product detail(Integer id) {
		try (Session session = sessionFactory.openSession()){
			
			return session.get(Product.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

