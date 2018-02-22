package u6_12_06_hotel;

public class Hotel {
    
    int numHabitacion, cont = -1;
    String nombre, tipoHabitacion;
    float pago;
    double gastosExtras;

    public Hotel(int numHabitacion, String nombre, String tipoHabitacion, float pago, double gastosExtras) {
        this.numHabitacion = numHabitacion;
        this.nombre = nombre;
        this.tipoHabitacion = tipoHabitacion;
        this.pago = pago;
        this.gastosExtras = gastosExtras;
    }
    
}
