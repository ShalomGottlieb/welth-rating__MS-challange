package targil.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import targil.api.bean.Person;
import targil.api.bean.Rich;
import targil.api.jpa.RichRepo;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class myTest {
    private RestTemplate restTemplate;

final String cityUrl   =  "http://central-bank/regional-info/evaluate?city=";
final String wealthThresholdUrl = "hhtp:/central-bank/wealth-threshold";
@Autowired
private RichRepo richRepo;

    @PostMapping("check")
    private ResponseEntity<?> isRich(@RequestBody Person person){
        double city= restTemplate.getForObject(cityUrl+person.getPersonalInfo().getCity(),double.class);
//        double city= 1.5;  //to chek if link not working
        double fortune = person.getFinancialInfo().getCash() + person.getFinancialInfo().getNumberOfAssets()*city;
        double wealthThreshold = restTemplate.getForObject(wealthThresholdUrl,double.class);
//        double wealthThreshold = 200000000;   //to chek if link not working
        if (fortune>wealthThreshold){
            Rich rich =  Rich.builder()
                    .firstName(person.getPersonalInfo().getFirstName())
                    .lastName(person.getPersonalInfo().getLastName())
                    .fortune(fortune).ID(person.getId())
                    .build();
         richRepo.save(rich);
            System.out.println("rich added!");
            return ResponseEntity.ok().body("person is rich");
        } else
            System.out.println("person is not rich");
            return ResponseEntity.ok().body("person is not rich");

    }
    @PostMapping("riches/get")
    private ResponseEntity<?> getRiches(){
return new ResponseEntity<>(richRepo.findAll(),HttpStatus.OK);
    }

    @PostMapping("rich/getOne/{id}")
    private ResponseEntity<?> getRicheById(@PathVariable Integer id){
        return new ResponseEntity<>(richRepo.findById(id),HttpStatus.OK);
    }
}
