package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Punto;
import modelo.Rectangulo;
import vista.VistaRectangulo;

public class ControladorRectangulo implements ActionListener {

    private VistaRectangulo vista;

    public ControladorRectangulo(VistaRectangulo vista) {
        this.vista = vista;
        // Conectamos los botones a los eventos
        this.vista.getBtnArea().addActionListener(this);
        this.vista.getBtnVerificar().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // === ACCIÓN LIMPIAR ===
        if (e.getSource() == vista.getBtnLimpiar()) {
            vista.getTxtX1().setText(""); vista.getTxtY1().setText("");
            vista.getTxtX2().setText(""); vista.getTxtY2().setText("");
            vista.getTxtPx().setText(""); vista.getTxtPy().setText("");
            vista.getLblResultado().setText("Resultado: -");
            vista.getLblResultado().setForeground(Color.BLACK);
            return;
        }

        try {
            // Capturamos los vértices del rectángulo
            double x1 = Double.parseDouble(vista.getTxtX1().getText().trim());
            double y1 = Double.parseDouble(vista.getTxtY1().getText().trim());
            double x2 = Double.parseDouble(vista.getTxtX2().getText().trim());
            double y2 = Double.parseDouble(vista.getTxtY2().getText().trim());
            
            Punto v1 = new Punto(x1, y1);
            Punto v2 = new Punto(x2, y2);
            Rectangulo rectangulo = new Rectangulo(v1, v2);

            // === ACCIÓN CALCULAR ÁREA ===
            if (e.getSource() == vista.getBtnArea()) {
                double area = rectangulo.calcularArea(); // Llama al método polimórfico
                vista.getLblResultado().setForeground(Color.BLUE);
                vista.getLblResultado().setText(String.format("El área del rectángulo es: %.2f", area));
            } 
            // === ACCIÓN VERIFICAR PUNTO ===
            else if (e.getSource() == vista.getBtnVerificar()) {
                double px = Double.parseDouble(vista.getTxtPx().getText().trim());
                double py = Double.parseDouble(vista.getTxtPy().getText().trim());
                Punto pTest = new Punto(px, py);
                
                if (rectangulo.contienePunto(pTest)) {
                    vista.getLblResultado().setForeground(new Color(0, 150, 0)); // Color Verde
                    vista.getLblResultado().setText("¡El punto SÍ está DENTRO del rectángulo!");
                } else {
                    vista.getLblResultado().setForeground(Color.RED);
                    vista.getLblResultado().setText("El punto está FUERA del rectángulo.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(vista, "Error: Ingrese únicamente valores numéricos en las coordenadas.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}