/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

//mport Objetos.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.kardex;
import objetos.transaccion;

public class Operaciones extends Conexion{
    /**
     * Constructor for objects of class Operaciones
     */
    public Operaciones()
    {
        // initialise instance variables
    }
    
    public boolean insertar(String sql){
        boolean valor = true;
        conectar();
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
                valor = false;
                JOptionPane.showMessageDialog(null, e.getMessage());
            }      
        finally{  
            try{    
                 consulta.close();  
                 conexion.close();  
             }catch (Exception e){                 
                 e.printStackTrace();  
             }  
        }
        return valor;
    }
    public ResultSet consultar(String sql){
        conectar();
        ResultSet resultado = null;
        try {
            resultado = consulta.executeQuery(sql);

        } catch (SQLException e) {
                System.out.println("Mensaje:"+e.getMessage());
                System.out.println("Estado:"+e.getSQLState());
                System.out.println("Codigo del error:"+e.getErrorCode());
                JOptionPane.showMessageDialog(null, ""+e.getMessage());
            }
        return resultado;
    }

    /*public void guardarUsuario(Persona persona){
        insertar("insert into Persona values("+persona.getId()
                    +",'"+persona.getPrimer_nombre()
                    +"','"+persona.getSegundo_nombre()
                    +"','"+persona.getPrimer_apellido()
                    +"','"+persona.getSegundo_apellido()+"')");
    } 
  */
    public void totalPersonas(DefaultTableModel tableModel){
        ResultSet resultado = null;
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        String sql = "select * from Persona";
        try {
            resultado = consultar(sql);
            if(resultado != null){
                int numeroColumna = resultado.getMetaData().getColumnCount();
                for(int j = 1;j <= numeroColumna;j++){
                    tableModel.addColumn(resultado.getMetaData().getColumnName(j));
                }
                while(resultado.next()){
                    Object []objetos = new Object[numeroColumna];
                    for(int i = 1;i <= numeroColumna;i++){
                        objetos[i-1] = resultado.getObject(i);
                    }
                    tableModel.addRow(objetos);
                }
            }
        }catch(SQLException e){
        }

        finally
     {
         try
         {
             consulta.close();
             conexion.close();
             if(resultado != null){
                resultado.close();
             }
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
     }
    }
    public void insertar_transaccion(transaccion tran)
    {
         
        String sql="insert into kardex values ("+tran.get_id()+",'"+tran.get_fecha()+"','"+tran.get_nombre()+"',"+tran.get_pu()+","+tran.get_cantidad_entrada()+","+tran.get_cantidad_salida()+","+tran.get_cantidad_saldo()+","+tran.get_valor_entrada()+","+tran.get_valor_salida()+","+tran.get_valor_saldo()+")";
        System.out.println(sql);
        insertar(sql);
        
    }
    public void insertar_kardex(kardex k)
    {
       
        String sql="insert into Material values ("+k.get_id()+",'"+k.get_nombre()+"')";
        insertar(sql);
    }
}