package modelo;

public class Rectangulo extends FiguraGeometrica {
    private Punto vertice1;
    private Punto vertice2;

    public Rectangulo(Punto v1, Punto v2) {
        this.vertice1 = v1;
        this.vertice2 = v2;
    }

    // === POLIMORFISMO: Implementación de calcularArea() ===
    @Override
    public double calcularArea() {
        double base = Math.abs(vertice2.getX() - vertice1.getX());
        double altura = Math.abs(vertice2.getY() - vertice1.getY());
        return base * altura;
    }

    // === POLIMORFISMO: Implementación de mover() ===
    @Override
    public void mover(double deltaX, double deltaY) {
        vertice1.setX(vertice1.getX() + deltaX);
        vertice1.setY(vertice1.getY() + deltaY);
        vertice2.setX(vertice2.getX() + deltaX);
        vertice2.setY(vertice2.getY() + deltaY);
    }

    // === LÓGICA DE PUNTO DENTRO DE LA FIGURA ===
    public boolean contienePunto(Punto pEvaluar) {
        double minX = Math.min(vertice1.getX(), vertice2.getX());
        double maxX = Math.max(vertice1.getX(), vertice2.getX());
        double minY = Math.min(vertice1.getY(), vertice2.getY());
        double maxY = Math.max(vertice1.getY(), vertice2.getY());

        // Retorna true si el punto está dentro de los límites X e Y
        return (pEvaluar.getX() >= minX && pEvaluar.getX() <= maxX) &&
               (pEvaluar.getY() >= minY && pEvaluar.getY() <= maxY);
    }
}