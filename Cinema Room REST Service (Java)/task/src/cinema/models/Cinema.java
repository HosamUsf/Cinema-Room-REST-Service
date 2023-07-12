package cinema.models;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Ticket> available_seats = new ArrayList<>();

    public Cinema(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        for (int i = 1; i <=total_rows ; i++) {
            for (int j = 1; j <=total_columns ; j++) {
                Ticket seat = new Ticket(i,j);
                available_seats.add(seat);
            }

        }
    }


    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Ticket> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Ticket> available_seats) {
        this.available_seats = available_seats;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "total_rows=" + total_rows +
                ", total_columns=" + total_columns +
                ", available_seats=" + available_seats +
                '}';
    }
}
