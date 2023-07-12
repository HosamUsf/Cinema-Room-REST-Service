package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(value = "seats", method = RequestMethod.GET)
    public Cinema getAllSeats() {
        return service.getCinema();
    }

}
