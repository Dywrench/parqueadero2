package co.edu.konradlorenz.model;

public class Vehiculo {
    private String placa;
    private String tipoVehiculo;
    private static final byte precioBicicletaPorMinuto = 13; // Precio por minuto
    private static final byte precioCarroPorMinuto = 71; // Precio por minuto
    private static final byte precioMotoPorMinuto = 43; // Precio por minuto
    private int duracionHoras; // Duración en horas
    private double valorPagar;

    // Constructor
    public Vehiculo(String placa, String tipoVehiculo, int duracionHoras) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.duracionHoras = duracionHoras;
        calcularPrecio(); // Calcular el precio en el constructor
    }

    // Getters y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        calcularPrecio(); // recalcula el precio si se cambia el tipo de vehículo
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
        calcularPrecio(); // recalcula el precio si se cambia la duración
    }

    public double getValorPagar() {
        return valorPagar;
    }

    // Método para calcular el precio
    private void calcularPrecio() {
        int duracionMinutos = duracionHoras * 60; // Convertir horas a minutos
        switch (tipoVehiculo.toLowerCase()) {
            case "bicicleta":
                valorPagar = precioBicicletaPorMinuto * duracionMinutos;
                break;
            case "moto":
                valorPagar = precioMotoPorMinuto * duracionMinutos;
                break;
            case "carro":
            default:
                valorPagar = precioCarroPorMinuto * duracionMinutos;
                break;
        }
    }

    // Método para calcular el IVA
    public double calcularIva() {
        return valorPagar * 0.19;
    }

    // Método para redondear al múltiplo más cercano de 50
    public int calcularMultiplo50(double valor) {
        int multiplo = (int) (valor % 50);
        if (multiplo == 0) {
            return (int) valor;
        } else {
            return (int) (valor + (50 - multiplo));
        }
    }

    // Método para calcular el valor total final redondeado
    public int calcularValorTotal() {
        double valorConIva = valorPagar + calcularIva();
        return calcularMultiplo50(valorConIva);
    }

    @Override
    public String toString() {
        return "Vehiculo placa=" + placa + ", tipoVehiculo=" + tipoVehiculo + ", duracion=" + duracionHoras + " horas";
    }
}
