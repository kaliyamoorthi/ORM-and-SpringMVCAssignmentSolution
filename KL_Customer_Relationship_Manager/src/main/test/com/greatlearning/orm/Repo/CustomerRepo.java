package com.greatlearning.orm.Repo;


import com.greatlearning.orm.model.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Component
@Transactional
public class CustomerRepo {
    @Autowired
    private SessionFactory sessionFactory;
    private List<Customer> customers = new ArrayList<Customer>();

    public Customer registerCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
        //students.add(student);
        //System.out.println("Registered Students:"+students.toString());
        return customer;
    }

    public List<Customer> getRegisteredCustomers(){
        Session session = sessionFactory.getCurrentSession();
        List<Customer> listCustomers = session.createQuery("from Customer", Customer.class).getResultList();
        return listCustomers;
    }
    public Customer updateCustomerDetails(int id, Customer updatedCustomer){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updatedCustomer);

//            Optional<Student> studentOptional = students
//                                               .stream()
//                                               .filter(order -> order.getId() == id)
//                                                .findAny();
//            if(studentOptional.isPresent()) {
//                Student studentFetchedFromList = studentOptional.get();
//                studentFetchedFromList.setName(updatedStudent.getName());
//                studentFetchedFromList.setDepartment(updatedStudent.getDepartment());
//                studentFetchedFromList.setId(updatedStudent.getId());
//                studentFetchedFromList.setCountry(updatedStudent.getCountry());
//                return studentFetchedFromList;
//            }
            return null;
    }

    public void deleteCustomerById(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class,id));
        //students.removeIf(student -> student.getId()==id);
        return;
    }


    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

	public List<Customer> getRegisterCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
}

