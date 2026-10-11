package modelo;

public abstract class FiguraGeometrica {
    // Métodos abstractos que obligan a las clases hijas a usar Polimorfismo
    public abstract double calcularArea();
    public abstract void mover(double deltaX, double deltaY);
}