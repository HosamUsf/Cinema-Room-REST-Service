package cinema.Controllers;

import cinema.Services.Service;
import cinema.models.Purchase;
import cinema.models.Ticket;
import cinema.models.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController

public class PurchaseController {
    @Autowired
    private Service service;

    @PostMapping("/purchase")
    public ResponseEntity<?> setPurchase(@RequestBody Ticket ticket) {
        Purchase purchase = new Purchase();
        ticket.setPrice(ticket.getRow());
        purchase.setTicket(ticket);


        if (purchase.getTicket().getColumn() > 9 || purchase.getTicket().getRow() > 9 || purchase.getTicket().getColumn() < 0 || purchase.getTicket().getRow() < 0) {
            return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }


        if (service.Bookedpurchases().contains(purchase)) {
            return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
        } else
            service.save(purchase);


        return new ResponseEntity<>(purchase, HttpStatus.OK);
    }


    @PostMapping("/return")
    public ResponseEntity<?> refundTicket(@RequestBody Token token){

        List<Purchase> allPuraches= service.Bookedpurchases();
        for (Purchase p:allPuraches) {
            if(p.getToken().equals(token.getToken())){
                service.refundTicket(p);
                return new ResponseEntity<>(Map.of("returned_ticket",p.getTicket()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/stats")
    public ResponseEntity<?>  getStats(@RequestParam(value = "password", required = false) String password){

        if(password==null){
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(service.returnStats(), HttpStatus.OK);
    }
}
