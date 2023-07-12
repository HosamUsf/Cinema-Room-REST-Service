package cinema;

import java.util.Objects;

public class Stats {
    private int current_income;
    private int number_of_available_seats;
    private int number_of_purchased_tickets;

    public Stats() {
        this.current_income=0;
        this.number_of_available_seats=81;
        this.number_of_purchased_tickets=0;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return number_of_purchased_tickets;
    }

    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "current_income=" + current_income +
                ", number_of_available_seats=" + number_of_available_seats +
                ", number_of_purchased_tickets=" + number_of_purchased_tickets +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return current_income == stats.current_income && number_of_available_seats == stats.number_of_available_seats && number_of_purchased_tickets == stats.number_of_purchased_tickets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(current_income, number_of_available_seats, number_of_purchased_tickets);
    }
}

