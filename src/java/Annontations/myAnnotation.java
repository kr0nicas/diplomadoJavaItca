package Annontations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author JAO
 */

// Para declararla como anotacion la palabra reservada interfaces se le debe colocar una arroba
// Y la propiedades de la anotacion deben ser declaradas como metodos
// finalmente se le deben establecer las propiedades @Retention @Target
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface myAnnotation {
    
//    Para declarar anotaciones se hacen por medio de interfaces
    int id();
    String message();
    
    
    
}
