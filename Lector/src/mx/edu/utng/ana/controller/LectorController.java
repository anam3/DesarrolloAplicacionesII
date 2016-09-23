package mx.edu.utng.ana.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.edu.utng.ana.dao.LectorDAO;
import mx.edu.utng.ana.dao.LectorDAOImp;
import mx.edu.utng.ana.model.Lector;
public class LectorController extends HttpServlet {
   private static final String
           LISTA_LECTORES = "/lista_lectores.jsp";
   private static final String 
           AGREGAR_O_CAMBIAR = "lector.jsp";
   private LectorDAO dao;
   
   public LectorController(){
       dao = new LectorDAOImp();
   }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_LECTORES;
            int numeroLector = Integer.parseInt(
                request.getParameter("numeroLector"));
            dao.borrarLector(numeroLector);
            request.setAttribute("lectores",
                    dao.desplegarLector());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int numeroLector = Integer.parseInt(
                request.getParameter("numeroLector"));
             Lector lector = 
                     dao.elegirLector(numeroLector);
             request.setAttribute("lector", lector);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_LECTORES;
             request.setAttribute("lectores", 
                     dao.desplegarLector());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Lector lector = new Lector();
        lector.setNombre(request.getParameter("nombre"));
        lector.setTelefono(request.getParameter("telefono"));
        lector.setDireccion(request.getParameter("direccion"));
        String numeroLector = request.getParameter("numeroLector");
        
        if(numeroLector==null|| numeroLector.isEmpty()||numeroLector.trim().equals("")){
            dao.agregarLector(lector);
        }else{
            lector.setNumeroLector(
                    Integer.parseInt(numeroLector));
            dao.cambiarLector(lector);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_LECTORES);
        request.setAttribute("lectores", 
                dao.desplegarLector());
        view.forward(request, response);
    }
}
