package model;

//import java.util.ArrayList;

public class Seller extends Person{
    //Clase Seller (Vendedor). Hereda todos los atributos de Person pero agrega las características
    //unicas del Vendedor.
    private long employeeCode;
    private Shift shift;
//  private ArrayList<Sale> sales;
//    Se desbloqueara el comentario en el momento que la clase Sale se desarrolle

    public Seller() {
    }

    public Seller(long employeeCode, Shift shift, String name, long iD, long contactNumber) {
        super(name, iD, contactNumber);
        this.employeeCode = employeeCode;
        this.shift = shift;
    }
    
    public long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    //Metodos de la clase Seller: addSale, searchSale, removeSale
    //Se agregarán a la clase en el momento en el que la clase Sale esté desarrollada
}
