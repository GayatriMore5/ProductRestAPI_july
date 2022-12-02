package com.jbk.product.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 
import com.jbk.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isAdded = false;
		try {
			session.save(product);
			transaction.commit();
			isAdded = true;     		
		} catch (Exception e) {
		e.printStackTrace();
		}
		finally {
			if(session != null) {
				session.close();
			}
		}
		return isAdded;
	}

}
 	 	