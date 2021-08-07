package es.eoi.ejercicios.conexionHibernate;

import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Clientes {

    @Id
    //@Column(name="Id") //no necesaria ya que coinciden los nombres exactamente de la tabla con los campos. Si no coincidiesen (alguna mayúscula por ejemplo) entonces pondríamos las anotaciones column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name="Nombre_del_campo_en_BD_si_no_coincide")
    private String nombre;

    private String apellidos;

    private int edad;

    private String direccion;


    public Clientes() {
        // Constructor por defecto vacío
    }

    public Clientes(String nombre, String apellidos, int edad, String direccion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
    }


    /**
     * Gets id.
     *
     * @return value of id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets nombre.
     *
     * @return value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets apellidos.
     *
     * @return value of apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Gets edad.
     *
     * @return value of edad
     */
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Gets direccion.
     *
     * @return value of direccion
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
