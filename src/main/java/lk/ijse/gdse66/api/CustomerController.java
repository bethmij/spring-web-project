package lk.ijse.gdse66.api;

import lk.ijse.gdse66.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("customers")
public class CustomerController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomer(){
        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
        customerDTOS.add(new CustomerDTO("C00-001","Kamal","Galle",50000));
        customerDTOS.add(new CustomerDTO("C00-002","Amal","Colombo",140000));
        customerDTOS.add(new CustomerDTO("C00-003","Sunil","Kandy",80000));

        return customerDTOS;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@RequestBody CustomerDTO customer){
        System.out.println(customer);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        System.out.println(id);
    }

}
