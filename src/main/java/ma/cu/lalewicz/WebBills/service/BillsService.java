package ma.cu.lalewicz.WebBills.service;

import ma.cu.lalewicz.WebBills.model.Bills;
import ma.cu.lalewicz.WebBills.model.Category;
import ma.cu.lalewicz.WebBills.repository.BillsRepository;
import ma.cu.lalewicz.WebBills.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillsService {

    @Autowired
    BillsRepository billsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        List<Category> categoryList = new ArrayList<>();
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        for (Category category : categoryIterable) {
            categoryList.add(category);
        }
        return categoryList;
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    public void saveOrUpdateCategory(Category category) {
        categoryRepository.save(category);
    }

    public boolean deleteCategory(int categoryid) {
        //wyszukiwanie czy kategoria nie jest połączona z rachunkiem i dopiero usunięcie
        Iterable<Bills> billsIterable = billsRepository.findAll();
        for (Bills bills: billsIterable) {
            if (bills.getCategory().getId() == categoryid){
                return false;
            }

        }
        categoryRepository.deleteById(categoryid);
        return true;
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Bills> getAllBills() {
        List<Bills> billsList = new ArrayList<>();
        Iterable<Bills> billsIterable = billsRepository.findAll();
        for (Bills bill : billsIterable) {
            billsList.add(bill);
        }
        return billsList;
    }


    public Bills getBillById(int billid) {
            return billsRepository.findById(billid).get();
    }

    public void saveOrUpdateBill(Bills bills) {
        billsRepository.save(bills);
    }

    public void deleteBill(int billid){
        billsRepository.deleteById(billid);
    }

    public void updateBill(Bills bills){
        billsRepository.save(bills);
    }


}
