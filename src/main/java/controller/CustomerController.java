package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import service.ICustomer;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomer iCustomer;
    @GetMapping("")
    public ModelAndView showAll(){
        List<Customer> list= iCustomer.findAll();
        return new ModelAndView("home","list",list);
    }
    @GetMapping("create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("create","cus",new Customer());
    }
    @PostMapping("create")
    public ModelAndView create(@ModelAttribute Customer cus){
        iCustomer.save(cus);
        return new ModelAndView("redirect:/customers");
    }
    @GetMapping("edit")
    public ModelAndView showFormEidt(@RequestParam int id){
        Customer customer=iCustomer.findById(id);
        return new ModelAndView("edit","cus",customer);
    }
    @PostMapping("edit")
    public ModelAndView edit(@RequestParam int id, @ModelAttribute Customer cus){
        cus.setId(id);
        iCustomer.update(cus);
        List<Customer> list= iCustomer.findAll();
        return new ModelAndView("redirect:/customers");
    }
    @GetMapping("delete")
      public ModelAndView delete(@RequestParam int id ){
        iCustomer.remove(id);
        return new ModelAndView("redirect:/customers");

      }


}
