/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.ana.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.ana.model.Lector;
import mx.edu.utng.ana.util.UtilDB;


public class LectorDAOImp implements LectorDAO{

    private Connection connection;
    
    public LectorDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarLector(Lector lector) {
        try {
          String query = "INSERT INTO lectores (nombre, telefono, "
                  + " direccion) VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getTelefono());
            ps.setString(3, lector.getDireccion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarLector(int numeroLector) {
        try {
             String query = "DELETE FROM lectores WHERE numero_lector = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, numeroLector);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarLector(Lector lector) {
    try {
          String query = "UPDATE lectores SET nombre = ?, "
                  + " telefono= ?, direccion=? WHERE "
                  + " numero_lector = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, lector.getNombre());
            ps.setString(2, lector.getTelefono());
            ps.setString(3, lector.getDireccion());
            ps.setInt(4, lector.getNumeroLector());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Lector> desplegarLector() {
        List<Lector> lectores = new ArrayList<Lector>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM lectores");
            while (resultSet.next()) {
              Lector lector = new Lector(
              resultSet.getInt("numero_lector"),
              resultSet.getString("nombre"),
              resultSet.getString("telefono"),
              resultSet.getString("direccion"));
              lectores.add(lector);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lectores;
    }

    @Override
    public Lector elegirLector(int idLector) {
       Lector lector = new Lector();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM lectores WHERE "
                                + " numero_lector = ?");
        statement.setInt(1, idLector);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              lector.setNumeroLector(
                      resultSet.getInt("numero_lector"));
              lector.setNombre(
                      resultSet.getString("nombre"));
              lector.setTelefono(
                      resultSet.getString("telefono"));
              lector.setDireccion(
                      resultSet.getString("direccion"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lector;
    }
    
    
}
