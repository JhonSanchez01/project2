import javax.swing.*;
import java.awt.event.*;

public class EventosSimples {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Eventos básicos");
        ventana.setSize(300, 250);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton boton = new JButton("Clic aquí");
        boton.setBounds(30, 30, 100, 30);

        // ✅ Ejercicio 1: Segundo botón
        JButton segundoBoton = new JButton("Segundo botón");
        segundoBoton.setBounds(150, 30, 120, 30);

        JLabel etiqueta = new JLabel("Clics: 0");
        etiqueta.setBounds(30, 80, 100, 30);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(30, 130, 150, 30);

        JLabel mensajeTecla = new JLabel("Escribe algo");
        mensajeTecla.setBounds(30, 170, 200, 30);

        // Evento del botón (ActionEvent)
        boton.addActionListener(_ -> JOptionPane.showMessageDialog(null, "¡Botón presionado!"));

        // ✅ Acción del segundo botón
        segundoBoton.addActionListener(e -> JOptionPane.showMessageDialog(null, "¡Segundo botón!"));

        // Evento de mouse (MouseEvent)
        final int[] contador = {0};
        etiqueta.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                contador[0]++;
                etiqueta.setText("Clics: " + contador[0]);
            }
        });

        // Evento de teclado (KeyEvent)
        campoTexto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mensajeTecla.setText("¡Presionaste Enter!");
                } else {
                    mensajeTecla.setText("Tecla: " + e.getKeyChar());
                }
            }
        });

        // ✅ Ejercicio 4: FocusEvent
        campoTexto.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                mensajeTecla.setText("Campo activo");
            }

            public void focusLost(FocusEvent e) {
                mensajeTecla.setText("Campo inactivo");
            }
        });

        // Agregar componentes
        ventana.add(boton);
        ventana.add(segundoBoton); // <-- Agregamos el nuevo botón
        ventana.add(etiqueta);
        ventana.add(campoTexto);
        ventana.add(mensajeTecla);

        ventana.setVisible(true);
    }
}
