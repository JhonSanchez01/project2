import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
  private static int contadorClics = 0;

  public static void main(String[] args) {


    JFrame ventana = new JFrame("Eventos por pantallas");
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setSize(400, 300);
    ventana.setLocationRelativeTo(null); // Centrar ventana


    CardLayout cards = new CardLayout();
    JPanel panelPrincipal = new JPanel(cards);



    JPanel panelClics = new JPanel(null);

    JLabel etiquetaClic = new JLabel("Clics: 0", SwingConstants.CENTER);
    etiquetaClic.setBounds(100, 50, 200, 50);
    etiquetaClic.setOpaque(true);
    etiquetaClic.setBackground(new Color(191, 235, 253)); // celeste claro


    etiquetaClic.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contadorClics++;
        etiquetaClic.setText("Clics: " + contadorClics);
        if (contadorClics == 5) {
          JOptionPane.showMessageDialog(null, "¡Llegaste a 5 clics!");
          contadorClics = 0;
          etiquetaClic.setText("Clics: 0");
        }
      }
    });

    panelClics.add(etiquetaClic);


    JPanel panelLetras = new JPanel(null);

    JTextField campoTexto = new JTextField();
    campoTexto.setBounds(50, 30, 300, 30);

    JLabel etiquetaLetras = new JLabel("Letras escritas: 0");
    etiquetaLetras.setBounds(50, 80, 300, 30);

    JLabel mensajeTecla = new JLabel("Escribe algo");
    mensajeTecla.setBounds(50, 120, 300, 30);


    campoTexto.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        String texto = campoTexto.getText();
        long cantidadLetras = texto.chars()
          .filter(Character::isLetter)
          .count();
        etiquetaLetras.setText("Letras escritas: " + cantidadLetras);
      }

      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          mensajeTecla.setText("¡Presionaste Enter!");
        } else {
          mensajeTecla.setText("Tecla: " + e.getKeyChar());
        }
      }
    });

    campoTexto.addFocusListener(new FocusListener() {
      public void focusGained(FocusEvent e) {
        mensajeTecla.setText("Campo activo");
      }
      public void focusLost(FocusEvent e) {
        mensajeTecla.setText("Campo inactivo");
      }
    });

    panelLetras.add(campoTexto);
    panelLetras.add(etiquetaLetras);
    panelLetras.add(mensajeTecla);


    panelPrincipal.add(panelClics, "Clics");
    panelPrincipal.add(panelLetras, "Letras");


    JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
    JButton botonClics = new JButton("Contar Clics");
    JButton botonLetras = new JButton("Contar Letras");


    botonClics.addActionListener(e -> cards.show(panelPrincipal, "Clics"));
    botonLetras.addActionListener(e -> cards.show(panelPrincipal, "Letras"));

    panelBotones.add(botonClics);
    panelBotones.add(botonLetras);



    ventana.setLayout(new BorderLayout());
    ventana.add(panelBotones, BorderLayout.NORTH);
    ventana.add(panelPrincipal, BorderLayout.CENTER);

    ventana.setVisible(true);
  }
}
