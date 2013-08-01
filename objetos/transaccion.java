/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author juanki
 */
public class transaccion {
    private int id;
    private String nombre;
    private String tipo;
    private String fecha;
    private double pu;
    private int cantidad;
    private int saldo_cantidad;
    private double valor;
    private double saldo_valor;
    private int cantidad_entrada=0;
    private int cantidad_salida=0;
    private double valor_entrada=0;
    private double valor_salida=0;
    private int ultimo_saldo_cantidad=0;
    private double ultimo_saldo_valor;
    public transaccion(int id,String nombre,String tipo,String fecha,double pu,int cantidad,int ultimo_saldo,double ultimo_saldo_valor)
    {        
    this.id=id;
    this.nombre=nombre;
    this.tipo=tipo;
    this.fecha=fecha;
    this.pu=pu;
    this.cantidad=cantidad;
    this.ultimo_saldo_cantidad=ultimo_saldo;
    this.ultimo_saldo_valor=ultimo_saldo_valor;
    set_cantidad(cantidad);
    
    }
    public void set_id(int id_nuevo)
    {
        id=id_nuevo;
    }
    public void set_nombre(String nombre_nuevo)
    {
        nombre=nombre_nuevo;
    }
    public void set_tipo(String tipo_nuevo)
    {
        tipo=tipo_nuevo;
    }
    public void set_fecha(String fecha_nueva)
    {
        fecha=fecha_nueva;
    }
    public void set_pu(double  pu_nuevo)
    {
        pu=pu_nuevo;
    }
    public void set_cantidad(int cantidad_nuevo)
    {
        cantidad=cantidad_nuevo;
    }
    public void realizar_calculos()
    {
        if(tipo.equals("entrada"))
        {
            cantidad_entrada=cantidad;
            valor_entrada=pu*cantidad;
            cantidad_salida=0;
            valor_salida=0;
            saldo_cantidad=ultimo_saldo_cantidad+cantidad_entrada;
            saldo_valor=ultimo_saldo_valor+valor_entrada;
        }else{
        if(tipo.equals("salida"))
        {
            cantidad_salida=cantidad;
            valor_salida=pu*cantidad;
            cantidad_entrada=0;
            valor_entrada=0;
            saldo_cantidad=ultimo_saldo_cantidad-cantidad_salida;
            saldo_valor=ultimo_saldo_valor-valor_salida;
        }
        }
    }
    
    
    public int get_id()
    {
        return id;
    }
    public String get_nombre()
    {
        return nombre;
    }
    public String get_tipo()
    {
        return tipo;
    }
    public String get_fecha()
    {
        return fecha;
    }
    public double get_pu()
    {
        return pu;
    }
    public int get_cantidad_entrada()
    {
        return cantidad_entrada;
    }
     public int get_cantidad_salida()
    {
        return cantidad_salida;
    }
     public int get_cantidad_saldo()
    {
        return saldo_cantidad;
    }
     public double get_valor_entrada()
    {
        return valor_entrada;
    }
     public double get_valor_salida()
    {
        return valor_salida;
    }
     public double get_valor_saldo()
    {
        return saldo_valor;
    }  
  

 
    public Object[] get_datos()
    {       
        Object[] datos={get_id(),get_fecha(),get_nombre(),get_pu(),cantidad_entrada,cantidad_salida,saldo_cantidad,valor_entrada,valor_salida,saldo_valor}; 
        return datos;
    }
}
