package generalClass;

import Annontations.myAnnotation;
import java.util.Date;



public class Employees {
    //Reflexion: Caracterisca de un programa para poder leer los valores y comentarios de campos y
    //metodos de una clase con la finalidad de tomar decisiones en modo Runtime
    @myAnnotation(id=1,message="Salario de Empleado")
    private int salary;
    @myAnnotation(id=2,message="Fecha de cumpleaños")
    private Date birthDay;
    //@myAnnotation(id=3, message="gifn")
    @myAnnotation(id=4, message="gifObdc")
    private String data;
    
    
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    
}
