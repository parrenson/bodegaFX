/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlUI;

import bodega.Bodega;
import data.Agente;
import data.Producto;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import modelo.OperacionesBodega;

/**
 *
 * @author baron
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextArea TextArea;
    @FXML
    private WebView tablaProducto; 
    
    Timeline time = new Timeline();
    Bodega<Producto> bodega; 

    List<Agente> listaAgentes = new ArrayList<>();
//creación de lista de agentes
//public Agentes(){ 
//listaAgentes.add(new Agente("Agente 1"));
//listaAgentes.add(new Agente("Agente 2"));
//listaAgentes.add(new Agente("Agente 3"));
//for (Agente agente : listaAgentes) {
//    if (agente.isLibre()) {
//         El agente está libre, haz algo con él
//        agente.setLibre(false);
//        agente.setTiempo(System.currentTimeMillis());
//    }
//}
//}    

    private void crearProductos() {
       Bodega<Producto> pilaProductos = new Bodega<>();
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
    
    public String hacerHtmlpila1() {
       

String html = "<html><table border=1 width=100%> \n" ;
html += OperacionesBodega.generarHtml(bodega) + "\n</table></html>";
return html;
}   
    
    private void iniciarFuncion(){
        crearProductos();
        WebEngine engine = tablaProducto.getEngine();
        engine.loadContent(hacerHtmlpila1());
    }




    @FXML
    private void btnIniciar(ActionEvent event) {
      time.play();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         time.setCycleCount(time.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(1), (event) ->{
            iniciarFuncion();
        }));
    }    
    
}
