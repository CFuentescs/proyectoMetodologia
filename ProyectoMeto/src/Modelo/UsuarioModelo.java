package Modelo;

import Controlador.AdministradorControlador;
import Controlador.TrabajadorControlador;
import Vista.Administrador;
import static baseDato.Conexion.getConnection;
import static baseDato.Conexion.stmt;
import Vista.Trabajador;
import Vista.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo
 */
public class UsuarioModelo {
    
    public void IngresoUsuario(char contraseña[], String usuario,Usuario nn) {
        Connection con = getConnection();
        String comando;
        String exp;
        boolean existe = false;
        try {
            char clave[] = contraseña;
            String clave1 = new String(clave);
            if (usuario.isEmpty() && clave1.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Campo de Usuario y/o contraseña Vacio. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                comando = "select *from usuario where pass='" + clave1 + "';";
                stmt = con.createStatement();
                ResultSet rss = stmt.executeQuery(comando);
                while (rss.next()) {
                    existe = true;
                    if (existe == true) {
                        exp = rss.getString("pass");
                        if (clave1.equals(exp)) {
                            ingresousuario(usuario,nn);
                        }
                    }
                }
                if (existe == false) {
                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                            + "Contraseña Incorrecta. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                            JOptionPane.ERROR_MESSAGE);
                }
                stmt.close();
                con.close();

            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }

    public void ingresousuario(String usuario,Usuario nn) {
        Connection con = getConnection();
        String comando;
        String comando1;
        String comando2;
        String exp;
        boolean existe = false;
        boolean n = false;
        try {
            comando = "select *from usuario where usuario='" + usuario + "';";
            stmt = con.createStatement();
            ResultSet rss = stmt.executeQuery(comando);
            while (rss.next()) {
                existe = true;
                if (existe == true) {
                    exp = rss.getString("usuario");
                    if (usuario.equals("root")) {
                        
                          nn.dispose();
                          Administrador adm= new Administrador();
                          AdministradorModelo admM= new AdministradorModelo();
                          AdministradorControlador admC= new AdministradorControlador(adm,admM);
                          admC.AdministradorIniciar();
                          
                    }else {
                        
                        nn.dispose();
                        Trabajador m = new Trabajador();
                        TrabajadorModelo v = new TrabajadorModelo();
                        TrabajadorControlador sc = new TrabajadorControlador(m, v);
                        sc.TrabajadorIniciar();
                    
                    }
                }
            }
            if (existe == false) {
                JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
                        + "Usuario Incorrecto. Por favor espere unos segundos e intente ingresar nuevamente.", "Acceso denegado",
                        JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
            con.close();

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ALERTA: Hubo un error desconocido");
            System.err.println("SQLException: " + err.getMessage());
            System.exit(0);

        }

    }

    public void salir() {
        System.exit(0);
    }
}
