/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import data.Agente;
import java.util.LinkedList;
import org.json.JSONObject;

/**
 *
 * @author baron
 */
public class CreateFile {
    public static boolean createFileJSON(LinkedList<Agente> listaA) {
        boolean isCreate = false;
        JSONObject json = new JSONObject();
        Agente objA = listaA.get(0);
        return isCreate;
    }
}
