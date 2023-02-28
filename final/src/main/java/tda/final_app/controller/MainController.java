package tda.final_app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tda.final_app.entity.Agent;
import tda.final_app.entity.Customer;
import tda.final_app.entity.Insurance;
import tda.final_app.repository.AgentRepository;
import tda.final_app.repository.CustomerRepository;
import tda.final_app.repository.InsuranceRepository;

@RestController
public class MainController {
    @Autowired
    private AgentRepository agentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {

        return new ResponseEntity<>("test", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/agent", method = RequestMethod.GET)
    public ResponseEntity<List<Agent>> getAgent() {
        List<Agent> agent = agentRepository.findAll();
        return new ResponseEntity<List<Agent>>(agent, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> customer = customerRepository.findAll();
        return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/insurance", method = RequestMethod.GET)
    public ResponseEntity<List<Insurance>> getInsurance() {
        List<Insurance> insurance = insuranceRepository.findAll();
        return new ResponseEntity<List<Insurance>>(insurance, HttpStatus.OK);
    }

    @RequestMapping(value = "/agent/{id}", method = RequestMethod.GET)
    public ResponseEntity<Agent> getAgent(@PathVariable("id") int id) {
        Optional<Agent> opt = agentRepository.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<Agent>(opt.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Agent>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Optional<Customer> opt = customerRepository.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<Customer>(opt.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/insurance/{id}", method = RequestMethod.GET)
    public ResponseEntity<Insurance> getInsurance(@PathVariable("id") int id) {
        Optional<Insurance> opt = insuranceRepository.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<Insurance>(opt.get(), HttpStatus.OK);
        else
            return new ResponseEntity<Insurance>(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @RequestMapping(value = "/agent", method = RequestMethod.POST)
    public ResponseEntity<String> postAgent(
            @RequestBody() HashMap<String, String> body) {
        SimpleDateFormat expire_dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = expire_dateFormat.parse(body.get("expire_date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Agent agent = new Agent();
        agent.setUsername((String) body.get("username"));
        agent.setPassword((String) body.get("password"));
        agent.setCert_no(Integer.parseInt(body.get("cert_no")));
        agent.setType((String) body.get("type"));
        agent.setName_title((String) body.get("name_title"));
        agent.setFirstname((String) body.get("firstname"));
        agent.setLastname((String) body.get("lastname"));
        agent.setAddress_no((String) body.get("address_no"));
        agent.setSub_district((String) body.get("sub_district"));
        agent.setDistrict((String) body.get("district"));
        agent.setProvince((String) body.get("province"));
        agent.setTelephone((String) body.get("telephone"));
        agent.setEmail((String) body.get("email"));
        agent.setExpire_date(date);

        agentRepository.save(agent);
        return new ResponseEntity<>("Agent added successfully", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/customer")
    public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customerDto) {
        Customer customer = new Customer();
        customer.setCustomer_name_title(customerDto.getCustomer_name_title());
        customer.setCustomer_firstname(customerDto.getCustomer_firstname());
        customer.setCustomer_lastname(customerDto.getCustomer_lastname());
        customer.setCustomer_id_no(customerDto.getCustomer_id_no());
        customer.setCustomer_address_no(customerDto.getCustomer_address_no());
        customer.setCustomer_sub_district(customerDto.getCustomer_sub_district());
        customer.setCustomer_district(customerDto.getCustomer_district());
        customer.setCustomer_province(customerDto.getCustomer_province());
        customer.setCustomer_email(customerDto.getCustomer_email());
        customer.setCustomer_birthday(customerDto.getCustomer_birthday());
        customer.setStart_cover_day(customerDto.getStart_cover_day());
        customer.setEnd_cover_day(customerDto.getEnd_cover_day());
        customer.setPremium(customerDto.getPremium());
        customer.setBeneficial_info(customerDto.getBeneficial_info());
        customer.setInsurance_info(customerDto.getInsurance_info());
        customer.setInsurance_id(customerDto.getInsurance_id()); 
        customer.setAgent_id(customerDto.getAgent_id());
    
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer added successfully", HttpStatus.OK);
    }
    

    @RequestMapping(value = "/insurance", method = RequestMethod.POST)
    public ResponseEntity<String> addInsurance(
            @RequestParam("name") String name,
            @RequestParam("coverage_class") String coverage_class,
            @RequestParam("price") int price,
            @RequestParam("car_coverage") int car_coverage,
            @RequestParam("medicine_coverage") int medicine_coverage,
            @RequestParam("third_party_coverage") int third_party_coverage,
            @RequestParam("lost") boolean lost,
            @RequestParam("urls") String urls) {
        Insurance insurance = new Insurance();
        insurance.setName(name);
        insurance.setCoverage_class(coverage_class);
        insurance.setPrice(price);
        insurance.setCar_coverage(car_coverage);
        insurance.setMedicine_coverage(medicine_coverage);
        insurance.setThird_party_coverage(third_party_coverage);
        insurance.setLost(lost);
        insurance.setUrls(urls);

        insuranceRepository.save(insurance);
        return new ResponseEntity<>("Insurance added successfully", HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("login")
    public String login(@RequestBody Map<String, String> credentials) {
    String username = credentials.get("username");
    String password = credentials.get("password");
    Agent data = agentRepository.findByUsername(username);
    if (data != null && data.getPassword().equals(password)) {
        return data.getId().toString();
    } else {
        return "Error";
    }
}

}