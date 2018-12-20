/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.session;

import com.mongodb.MongoClient;
import ec.edu.espe.arquitectura.model.Funcionalidad;
import ec.edu.espe.arquitectura.model.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 *
 * @author User
 */
@Stateless
@LocalBean
public class FuncionalidadFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void insertarFuncionalidad(Funcionalidad funcIn) {
        Morphia morphia = new Morphia();

        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        ds.ensureIndexes();
        //datastore.ensureIndexes();
        System.out.println("conexion establecida con MongoDB!");
        Funcionalidad func = new Funcionalidad();

        func.setCodigoFuncionalidad(funcIn.getCodigoFuncionalidad());
        func.setNombreFuncionalidad(funcIn.getNombreFuncionalidad());
        func.setRecurso(funcIn.getRecurso());

        /*
        user.setNombres(nombres);
        user.setApellidos(apellidos);
        user.setCorreoElectronico(correoElectronico);
        user.setCorreoElectronico(correoElectronico);
         */
        ds.save(func);
        System.out.println("Funcionalidad Creada");
    }

    public List<Funcionalidad> listaFuncionalidadesTodas() {
        Morphia morphia = new Morphia();
        morphia.mapPackage("ec.edu.espe.arquitectura.model");
        Datastore ds = morphia.createDatastore(new MongoClient(), "proyArquiP2");
        System.out.println("conexion establecida");

        List<Funcionalidad> listaFunc = ds.createQuery(Funcionalidad.class).asList();
        System.out.println(listaFunc);
        return listaFunc;
    }
}
