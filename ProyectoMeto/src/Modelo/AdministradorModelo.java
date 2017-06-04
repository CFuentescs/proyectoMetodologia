/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.AdministradorControlador;
import static baseDato.Conexion.getConnection;
import static baseDato.Conexion.stmt;
import Vista.Administrador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author carlos
 */
public class AdministradorModelo {
        DefaultTableModel modelo;
        Administrador adm= new Administrador();
    
    public void inicarAdministrador (){
      
            VistaResidente (adm.TablaResidente,"");
    
    }
    
     
    public void VistaResidente (JTable tablaD,String St) {
        Connection con = getConnection();

          DefaultTableModel modo= new DefaultTableModel();
          
          String Sql;
          
        
          if (St.equals("")){
            
           Sql="SELECT * FROM stock";
            } else {
                
              Sql="SELECT * FROM stock WHERE id_stock='"+St+"'";
            }
        
        try {
           Sql = "select*from residente;";
           
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(Sql);
            String[] fila = new String[5];
            String[] titulos = {"ID","Nombre","Apellido_p","Apellido_M","Sexo","Tiempo","Observaciòn"};
            modelo = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                
                fila[0] = rs.getString("ID");
                fila[1] = rs.getString("Nombre");
                fila[2] = rs.getString("Apellido_P");
                fila[3] = rs.getString("Apellido_M");
                fila[4] = rs.getString("Sexo");
                fila[5] = rs.getString("Tiempo");
                fila[6] = rs.getString("Observacion");
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
    
}
