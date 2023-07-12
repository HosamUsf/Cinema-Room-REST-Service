package cinema;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    private Cinema cinema = new Cinema(9, 9);
    private Stats stats = new Stats();
    private List<Purchase> bookedpurchases = new ArrayList<>();

    public void save(Purchase purchase) {


        bookedpurchases.add(purchase);
        stats.setNumber_of_available_seats(stats.getNumber_of_available_seats() - 1);
        stats.setCurrent_income(stats.getCurrent_income() + purchase.getTicket().getPrice());
        stats.setNumber_of_purchased_tickets(stats.getNumber_of_purchased_tickets() + 1);
        bookedpurchases.forEach(System.out::println);
        System.out.println("???");


    }

    public Cinema getCinema() {
        return cinema;
    }

    public List<Purchase> Bookedpurchases() {
        return bookedpurchases;
    }

    public void refundTicket(Purchase purchase) {
        bookedpurchases.removeIf(purchase1 -> purchase1.getTicket() == purchase.getTicket());
        stats.setNumber_of_available_seats(stats.getNumber_of_available_seats() + 1);
        stats.setCurrent_income(stats.getCurrent_income() - purchase.getTicket().getPrice());
        stats.setNumber_of_purchased_tickets(stats.getNumber_of_purchased_tickets() - 1);
    }

    public Stats returnStats(){
        return stats;
    }
}
