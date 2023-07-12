package cinema.models;

import java.util.Objects;

public class Ticket {
    private int row;
    private int column;
    private int price;


    public Ticket() {

    }

    public Ticket(int row, int column) {
        this.row = row;
        this.column = column;
        if (this.row <= 4) {
            this.price = 10;

        } else
            this.price = 8;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int row) {
        if (row <= 4) {
            this.price = 10;

        } else
            this.price = 8;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return row == ticket.row && column == ticket.column && price == ticket.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, price);
    }
}
