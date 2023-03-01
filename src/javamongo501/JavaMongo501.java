package javamongo501;

/**
 *
 * Diego Uriel Padilla Quijas
 * Programa que conecte Mongo con aplicacion Java
 * Fecha: 27 de febrero del 2023
 * Grupo: DSM-501
 */
public class JavaMongo501 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conexion = new Connection();
        //conexion.mostrar();
        
        //conexion.insertar("Nadar");
        //System.out.println("--Se inserto correctamente--");
        //conexion.mostrar();
        //System.out.println("Otro Más");
        //conexion.actualizar("Nadar", "Brincar");
        //conexion.mostrar();
        //System.out.println("-- Se Actualizo correctamente --");
        
        conexion.eliminar("Brincar");
        conexion.mostrar();
        
        
        
    }
    
}
