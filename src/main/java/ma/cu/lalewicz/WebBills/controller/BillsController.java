package ma.cu.lalewicz.WebBills.controller;

import ma.cu.lalewicz.WebBills.model.Bills;
import ma.cu.lalewicz.WebBills.model.Category;
import ma.cu.lalewicz.WebBills.service.BillsService;
import ma.cu.lalewicz.WebBills.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillsController {

    @Autowired
    BillsService billsService;



    @GetMapping("/category")
    private List<Category> getAllCategory(){
        return billsService.getAllCategory();
    }

    @GetMapping("/category/{categoryid}")
    private Category getCategoryById(@PathVariable("categoryid") int categoryid){
        return billsService.getCategoryById(categoryid);
    }

//    @PostMapping("/categories")
//    private int saveCatagory(@RequestBody Category category){
//        billsService.saveOrUpdateCategory(category);
//        return category.getId();
//    }

    @PostMapping("/categories")
    private Category saveCatagory(@RequestBody Category category){
        billsService.saveOrUpdateCategory(category);
        return category;
    }

    @DeleteMapping("/category/{catagoryid}")
    private boolean deleteCategory(@PathVariable("catagoryid") int categoryid){
        //sprawdzenie czy można usunąć kategorie
        return billsService.deleteCategory(categoryid);
    }

    @PutMapping("/categories")
    private Category updateCategory(@RequestBody Category category){
        billsService.updateCategory(category);
        return category;
    }



//endpointy do rachunków

    @GetMapping("/bill")
    private  List<Bills> getAllBills(){
        return billsService.getAllBills();
    }

    @GetMapping("/bill/{billid}")
    private Bills getBillById(@PathVariable("billid") int billid){
        return billsService.getBillById(billid);
    }

    @PostMapping("/bills")
    private int saveBill(@RequestBody Bills bill){
        billsService.saveOrUpdateBill(bill);
        return bill.getId();
    }

    @DeleteMapping("/bill/{billid}")
    private void deleteBill(@PathVariable("billid") int billid){
        billsService.deleteBill(billid);
    }

    @PutMapping("/bills")
    private Bills updateBill(@RequestBody Bills bill){
        billsService.updateBill(bill);
        return bill;
    }
// sprawdzenie poprawnosci nr konta
    @GetMapping("/accountcheck/{accountnumber}")
    private boolean checkAccountNumber(@PathVariable("accountnumber") String accountnumber){
        return Utils.isCorrectAccountNumber(accountnumber);
    }
}
