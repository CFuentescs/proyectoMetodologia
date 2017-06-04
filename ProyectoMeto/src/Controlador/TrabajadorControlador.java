/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.TrabajadorModelo;
import Vista.Trabajador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class TrabajadorControlador implements ActionListener {

    private Trabajador n;
    private TrabajadorModelo de;

    public TrabajadorControlador(Trabajador n, TrabajadorModelo de) {
        this.n = n;
        this.de = de;
        this.n.Actividades.addActionListener(this);
        this.n.Volver.addActionListener(this);
        this.n.Enfermedad.addActionListener(this);
        this.n.Turno.addActionListener(this);
        this.n.Historial_Medico.addActionListener(this);
    }

    public void TrabajadorIniciar() {
        n.setVisible(true);
        n.setTitle("Trabajador");
        n.setLocationRelativeTo(null);
        n.setResizable(false);
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        de.HorarioTrabajador(n.jTable2Horario);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (n.Actividades == ae.getSource()) {

            try {

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (n.Historial_Medico == ae.getSource()) {
            try {

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (n.Turno == ae.getSource()) {
            try {

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (n.Enfermedad == ae.getSource()) {
            try {

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        } else if (n.Volver == ae.getSource()) {
            try {
                n.dispose();
                de.Volver();
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "No se pudo realizar el siguiente evento");
            }
        }
    }
}
