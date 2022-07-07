package com.greatlearning.orm.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.greatlearning.orm.model.Customer;
import com.greatlearning.orm.service.RegisterService;

@Controller
@Component
//@RequestMapping("/list-customers")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    /****************/
    @RequestMapping("/")
    public String redirectPage() {
        return "redirect:/list";
    }
    @RequestMapping("/showCustomerForm")
    public ModelAndView showCustomerForm(){
        return new ModelAndView("customer-form","command",new Customer());
    }
    @RequestMapping(value="/registerCustomer",method = RequestMethod.POST)
    public ModelAndView registerCustomer(@ModelAttribute("student") Customer theCustomer){
        //write code to save  object

        System.out.println(theCustomer.getId()+" "+ theCustomer.getFname()+
                " "+ theCustomer.getFname()+" " + theCustomer.getEmail());
        registerService.registerCustomer(theCustomer);
        System.out.println("Student registered Successfully");
        //return new ModelAndView("empform","command",emp);
        return new ModelAndView("redirect:/list");
    }
    /*************************************/

//    @RequestMapping(value="/registration", method = RequestMethod.GET)
//    public String showStudentForm(Model theModel){
//        Student theStudent = new Student();
//       theModel.addAttribute("student",theStudent);
//        return "student-form";
////        theModel.addAttribute("message",
////                "Hello World and Welcome to Spring MVC!");
//        //return "student-form";
//       //return "Student";
//    }
    @GetMapping("/list")
    public String getAllRegisteredCustomers(Model theModel){
        List<Customer> theCustomers = registerService.getRegisterCustomer();
        theModel.addAttribute("customers", theCustomers);
        System.out.println("All registered customers: \n"+ theCustomers.toString());
        return "list-customers";
    }
    @RequestMapping(value="/delete")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteCustomerById(@RequestParam("customerId") int theId){
        registerService.deleteCustomer(theId);
        Model theModel = new RedirectAttributesModelMap();
        System.out.println("The student with Id "+theId+" is deleted successfully");
        return new ModelAndView("redirect:/list");
    }


//    @RequestMapping(value="/updateForm")
//    public String updateStudent(@PathVariable int id, Model m){
//        Emp emp=dao.getEmpById(id);
//        m.addAttribute("command",emp);
//        return "empeditform";
//    }
    @RequestMapping(value="/updateForm")
    public String updateCustomer(@RequestParam("customerId") int theId, Model theModel) {
        Customer theCustomer = registerService.getCustomer(theId);
        System.out.println("The details of student with id "+theId+" are updated from ");
        System.out.println(theCustomer.toString());
        theModel.addAttribute("command", theCustomer);
        return "edit-customer-form";
    }
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("customer") Customer customer){
        registerService.updateCustomerDetails(customer.getId(), customer);
        System.out.println("to :"+ customer.toString());
        return ("redirect:/list");
    }
//    @RequestMapping(value="/homePage")
//    public String showHomePage() {
//        return "index";
//    }



}

