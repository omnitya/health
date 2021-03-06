package jha.abhishek.healthrestendpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/health")
public class HealthController {

    @Autowired
    private HealthDAO dao;

    @GetMapping(path="/", produces = "application/json")
    public Health getHealth()
    {
        return dao.getHealth();
    }

    @PostMapping(path = "/health", produces = "apploication/json")
    public void addHealth(){

    }
}
