/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.ana.dao;

import java.util.List;
import mx.edu.utng.ana.model.Estudiante;

public interface EstudianteDAO {
    void agregarEstudiante(Estudiante estudiante);
    void borrarEstudiante(int idEstudiante);
    void cambiarEstudiante(Estudiante estudiante);
    List<Estudiante> desplegarEstudiantes();
    Estudiante elegirEstudiante(int idEstudiante);

}
