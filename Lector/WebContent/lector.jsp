<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lector</title>
    </head>
    <body>
        <form action="LectorController" method="post">
            <fieldset>
                <legend>Formulario de Lector</legend>
                
                <div>
                <label for="numeroLector">Número Lector:</label>
                <input type="text" name="numeroLector"
                       value="${lector.numeroLector}"
                       readonly="readonly" 
                       placeholder="Numero de lector"/>
                </div>
                
                <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre"
                       value="${lector.nombre}"
                       placeholder="Nombre del lector"/>
                </div>
                 
                <div>
                <label for="telefono">Teléfono:</label>
                <input type="text" name="telefono"
                       value="${lector.telefono}"
                       placeholder="Telefono del Lector"/>
                </div>
                
                <div>
                <label for="direccion">Dirección:</label>
                <input type="text" name="direccion"
                       value="${lector.direccion}"
                       placeholder="Direccion"/>
                </div>
                
                 <div>
                     <input type="submit" 
                       value="Guardar" />
                </div>
            </fieldset>
            
        </form>
    </body>
</html>
