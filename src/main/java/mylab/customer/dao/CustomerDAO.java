package mylab.customer.dao;

import java.util.List;

import mylab.customer.vo.CustomerVO;

public interface CustomerDAO {
	
	List<CustomerVO> selectAllCustomer();

	CustomerVO selectCustomer(int id);
	
	public void insertCustomer(CustomerVO customer);
}
