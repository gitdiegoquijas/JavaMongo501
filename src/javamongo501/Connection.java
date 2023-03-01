package javamongo501;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegopadilla
 */
public class Connection {

    MongoClient mongoClient;
    MongoCollection<Document> coleccion;
    Document document;

    public Connection() {
        mongoClient = null;
        try {
            // Conecta a la base de datos
            mongoClient = new MongoClient("localhost", 27017);

            //Crea la Base de Datos
            MongoDatabase db = mongoClient.getDatabase("Actividades501");

            //Crea la coleccion
            coleccion = db.getCollection("Actividades501");

            System.out.println("Conexion Establecida");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Metodos CRUD
    //INSERTAR
    public boolean insertar(String accion) {
            document = new Document().append("accion", accion);
            coleccion.insertOne(document);
            System.out.println("El documento se inserto correctamente");
        return true;
    }

    //Mostrar
    public void mostrar() {
        // Get the list of documents from the DB
            FindIterable<Document> iterobj = coleccion.find();
 
            // Print the documents using iterators
            Iterator itr = iterobj.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }
    }

    //Actualizar
    public boolean actualizar(String accionVieja, String accionNueva) {
        coleccion.updateOne(Filters.eq("accion", accionVieja), Updates.set("accion", accionNueva));
        System.out.println("Se ha actualizado correctamente");
        return true;
    }

    //Eliminar 
    public boolean eliminar(String accion) {
        coleccion.deleteOne(Filters.eq("accion", accion));
        System.out.println("Se ha eliminado correctamente");
        return true;
    }

}
