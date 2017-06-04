/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AdministradorModelo;
import Vista.Administrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author carlos
 */
public class AdministradorControlador implements ActionListener {

     private Administrador adm;
     private AdministradorModelo admM;
    
     public AdministradorControlador(Administrador adm, AdministradorModelo admM) {
        
         
        this.adm = adm;
        this.admM = admM;
        this.adm.Buscar.addActionListener(this);
        this.adm.Actualizar.addActionListener(this);
        this.adm.Factura.addActionListener(this);
        this.adm.buscarTrabajador.addActionListener(this);
        this.adm.ActualizarTra.addActionListener(this);
        this.adm.seccion.addActionListener(this);
        this.adm.salir.addActionListener(this);
        this.adm.bottonResidente.addActionListener(this);
        this.adm.bottonTutor.addActionListener(this);
        this.adm.BottonTrabajador.addActionListener(this);
        this.adm.bottonHorario.addActionListener(this);
        
    }
    public void AdministradorIniciar() {
        
        adm.setVisible(true);
        adm.setTitle("Administrador");
        adm.setLocationRelativeTo(null);
        adm.setResizable(false);
        adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admM.inicarAdministrador();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (adm.Buscar == ae.getSource()){
                        
            try{
                
                admM.VistaResidente(adm.TablaResidente,adm.ResidenteTXT.getText());
                
            }catch (Exception ex){
                
                        JOptionPane.showMessageDialog(null,"no se pudo guardar");
            }  
        }else   if (adm.Actualizar == ae.getSource()){
                        
            try{
                
                admM.VistaResidente(adm.TablaResidente,"");
                
            }catch (Exception ex){
                
                        JOptionPane.showMessageDialog(null,"no se pudo Actualizar");
            }      
        }
    }
}

   

    