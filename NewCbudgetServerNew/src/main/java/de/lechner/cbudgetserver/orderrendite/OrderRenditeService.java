package de.lechner.cbudgetserver.orderrendite;

import de.lechner.cbudgetserver.konto.Konto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderRenditeService {

	@Autowired
	private OrderRenditeRepository orderRenditeRepositoryRepository;


	public List<OrderRendite> getAllOrderRendite() {
		List<OrderRendite> t = new ArrayList<OrderRendite>();
		orderRenditeRepositoryRepository.findAll().forEach(t::add);
		return t;
		//return Kontos;
	}
	public OrderRendite getOrderRendite(Integer id) {
		return  orderRenditeRepositoryRepository.findById(id).orElse(new OrderRendite());
	}


	public void addOrderRendite(OrderRendite orderRendite)
	{
		orderRenditeRepositoryRepository.save(orderRendite);
	}
	public void updateOrderRendite(OrderRendite trans) {
		orderRenditeRepositoryRepository.save(trans);
	}
	public void deleteOrderRendite(int id) {
		orderRenditeRepositoryRepository.deleteById(id);
	}
}
