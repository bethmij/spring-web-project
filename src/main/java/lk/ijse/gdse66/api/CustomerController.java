package lk.ijse.gdse66.api;

import lk.ijse.gdse66.dto.CustomerDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("customers")
@CrossOrigin
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
        System.out.printf("\ncusID : %s ",id);
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable("id") String id, @RequestBody CustomerDTO customer){
        System.out.printf("\n%s : %s ", id, customer);
    }

    @GetMapping("/{id}")
    public CustomerDTO searchCustomer(@PathVariable("id") String id){
        return new CustomerDTO("C00-004", "Kusum", "Matara", 60000);
    }

    @GetMapping("/cusIDList")
    public ArrayList<String> getCusIDList(){
        return new ArrayList<>(Arrays.asList("C00-001", "C00-002", "C00-003"));
    }

}
