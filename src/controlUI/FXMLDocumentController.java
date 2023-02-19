/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlUI;

import bodega.Bodega;
import data.Producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 *
 * @author baron
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    
     private TextArea TextArea;
    
     private boolean iniciar;

    /**
     * Get the value of iniciar
     *
     * @return the value of iniciar
     */
    public boolean isIniciar() {
        return iniciar;
    }

    /**
     * Set the value of iniciar
     *
     * @param iniciar new value of iniciar
     */
    public void setIniciar(boolean iniciar) {
        this.iniciar = iniciar;
    }


    
    
    @FXML
    private void btnIniciar(ActionEvent event) {
        
       Bodega<Producto> pilaProductos = new Bodega<>();
       iniciar = true;
       while(iniciar){
            // Generar entre 1 a 5 productos cada segundo
        int cantidadProductos = (int)(Math.random() * 5) + 1;
        for (int i = 0; i < cantidadProductos; i++) {
            // Generar un producto aleatorio
            String nombre_producto = "Producto " + (pilaProductos.pilaProductos.size() + 1);
            int cantidad = (int) (Math.random() * 100) + 1;
            double valor = Math.random() * 100;
            int tiempo_despacho = (int) (Math.random() * 6) + 2;
 
            // Añadir el producto a la bodega
            Producto objP = new Producto(nombre_producto, cantidad, valor, tiempo_despacho);
            pilaProductos.apilar(objP);
            
            TextArea.setText(pilaProductos.toString());
       }
   
    }
    
    }
    
    
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
