/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author juanki
 */
public class kardex {
    private int id;
    private String nombre;
   
    
    public kardex(int id,String nombre)
    {
    this.id=id;
    this.nombre=nombre;
    
    }
    public void set_id(int id_nuevo)
    {
        id=id_nuevo;
    }
    public void set_nombre(String nombre_nuevo)
    {
        nombre=nombre_nuevo;
    }
   
    public int get_id()
    {
        return id;
    }
    public String get_nombre()
    {
        return nombre;
    }
    
} 
