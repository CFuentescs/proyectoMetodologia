package Inicio;

import Controlador.UsuarioControlador;
import Modelo.UsuarioModelo;
import Vista.Usuario;

/**
 *
 * @author Pablo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario m = new Usuario();
        UsuarioModelo v = new UsuarioModelo();
        UsuarioControlador sc = new UsuarioControlador(v, m);
        sc.IniciarUsuario();
    }

}
