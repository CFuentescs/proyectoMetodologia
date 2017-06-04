/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.UsuarioModelo;
import Vista.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class UsuarioControlador implements ActionListener {

    private UsuarioModelo dd;
    private Usuario ff;

    public UsuarioControlador(UsuarioModelo dd, Usuario ff) {
        this.dd = dd;
        this.ff = ff;
        this.ff.Aceptar.addActionListener(this);
        this.ff.Salir.addActionListener(this);

    }
    public void IniciarUsuario() {
        ff.setVisible(true);
        ff.setTitle("Usuario");
        ff.setLocationRelativeTo(null);
        ff.setResizable(false);
        ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ff.Aceptar == ae.getSource()) {

            try {

                dd.IngresoUsuario(ff.Contraseña.getPassword(), ff.Usuario.getText(),ff);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (ff.Salir == ae.getSource()) {
            try {
                dd.salir();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        }
    }
}
