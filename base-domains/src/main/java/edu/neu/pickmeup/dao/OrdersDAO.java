package edu.neu.pickmeup.dao;

import edu.neu.pickmeup.model.Orders;
import javassist.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDAO extends DAO {

	public OrdersDAO() {
	}

	public Orders get(long id) throws NotFoundException {

		try {
			// Fetch user object from the database based on id
			begin();
			Orders order = getSession().get(Orders.class, id);
			commit();
			close();

			return order;
		} catch (HibernateException e) {

			rollback();
			// throw new AdException("Could not fetch user with id: " + id, e);
			throw new NotFoundException("Exception while fetching user with id: " + id + ", " + e.getMessage());
		}

	}

	public Orders create(Orders order) throws NotFoundException {
		try {

			// save user object in the database
			begin();
			getSession().save(order);
			commit();
			close();

			return order;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new NotFoundException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Orders order) throws NotFoundException {
		try {
			// save user object in the database
			begin();
			getSession().delete(order);
			commit();

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create user " + username, e);
			throw new NotFoundException("Exception while deleting user: " + e.getMessage());
		}
	}

	public List<Orders> list() throws NotFoundException {
		try {
			// Fetch all user objects from the database
			begin();
			Query query = getSession().createQuery("from Orders");
			List<Orders> userList = query.list();
			commit();
			close();

			return userList;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not fetch user list", e);
			throw new NotFoundException("Exception while getting user list: " + e.getMessage());
		}
	}
	
	public Orders updateOrder(Orders order) throws NotFoundException {
	    try {
	        begin();
	        getSession().update(order);
	        commit();
	        close();
	        return order;
	    } catch (HibernateException e) {
	        rollback();
	        throw new NotFoundException("Exception while updating order: " + e.getMessage());
	    }
	}

}