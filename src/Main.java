import javax.swing.*;
import java.awt.event.*;

public class Main {
  private static int contadorClics = 0;

  public static void main(String[] args) {
    JFrame ventana = new JFrame("Contador de clics y letras");
    ventana.setLayout(null); // Layout manual

    // Etiqueta para contar clics
    JLabel etiquetaClic = new JLabel("Haz clic aquí", SwingConstants.CENTER);
    etiquetaClic.setBounds(50, 30, 200, 50);

    // Campo de texto para escribir letras
    JTextField campoTexto = new JTextField();
    campoTexto.setBounds(50, 100, 200, 30);

    // Etiqueta que muestra cantidad de letras
    JLabel etiquetaLetras = new JLabel("Letras escritas: 0");
    etiquetaLetras.setBounds(50, 140, 200, 30);

    // Lógica para contar clics
    etiquetaClic.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contadorClics++;
        if (contadorClics == 5) {
          JOptionPane.showMessageDialog(null, "¡Llegaste a 5 clics!");
          contadorClics = 0; // Reinicia si se desea repetir
        }
      }
    });

    // Lógica para contar letras escritas (solo letras)
    campoTexto.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        String texto = campoTexto.getText();
        long cantidadLetras = texto.chars()
          .filter(Character::isLetter)
          .count();
        etiquetaLetras.setText("Letras escritas: " + cantidadLetras);
      }
    });

    // Añadir componentes a la ventana
    ventana.add(etiquetaClic);
    ventana.add(campoTexto);
    ventana.add(etiquetaLetras);

    ventana.setSize(320, 250);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLocationRelativeTo(null); // Centrar ventana
    ventana.setVisible(true);
  }
}
