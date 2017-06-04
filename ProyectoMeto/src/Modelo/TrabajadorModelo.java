/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.UsuarioControlador;
import static baseDato.Conexion.getConnection;
import static baseDato.Conexion.stmt;
import Vista.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class TrabajadorModelo {
 DefaultTableModel modelo;
    public void HorarioTrabajador(JTable tablaD) {
        Connection con = getConnection();
        String comando;
        try {
            comando = "select*from horario;";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(comando);
            String[] fila = new String[5];
            String[] titulos = {"ID_Horario", "Horario_Semanal", "Horario_Usuario", "Hora_Comienzo", "Hora_Fin"};
            modelo = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                fila[0] = rs.getString("id_horario");
                fila[1] = rs.getString("horario_semanal");
                fila[2] = rs.getString("horario_usuario");
                fila[3] = rs.getString("hora_comienzo");
                fila[4] = rs.getString("hora_fin");
                modelo.addRow(fila);
            }
            stmt.close();
            con.close();
            tablaD.setModel(modelo);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }
        
        
    

    public void Residente() {

    }
    public void Turno(){
        
    }
    public void Enfermedad(){
        
    }
    public void HistorialMedico(){
        
    }
    public void Volver() {
        Usuario m = new Usuario();
        UsuarioModelo v = new UsuarioModelo();
        UsuarioControlador sc = new UsuarioControlador(v, m);
        sc.IniciarUsuario();
    }
}
