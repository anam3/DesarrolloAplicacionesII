/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.ana.dao;

import java.util.List;

import mx.edu.utng.ana.model.Lector;

public interface LectorDAO {
    void agregarLector(Lector lector);
    void borrarLector(int idEstudiante);
    void cambiarLector(Lector lector);
    List<Lector> desplegarLector();
    Lector elegirLector(int idEstudiante);

}
