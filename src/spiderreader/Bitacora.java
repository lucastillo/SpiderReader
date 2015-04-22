/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiderreader;

/**
 *
 * @author programador1
 */
public class Bitacora {
    private String tipoEvento;
    private String estadoSitio;
    private String paginaVisitada;
    private String tiempoCarga;

    public Bitacora(String tipoEvento, String estadoSitio, String paginaVisitada, String tiempoCarga) {
        this.tipoEvento = tipoEvento;
        this.estadoSitio = estadoSitio;
        this.paginaVisitada = paginaVisitada;
        this.tiempoCarga = tiempoCarga;
    }
    
    
    
}
