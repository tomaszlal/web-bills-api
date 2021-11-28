package ma.cu.lalewicz.WebBills.repository;

import ma.cu.lalewicz.WebBills.model.Bills;
import org.springframework.data.repository.CrudRepository;

public interface BillsRepository extends CrudRepository<Bills,Integer> {


}
