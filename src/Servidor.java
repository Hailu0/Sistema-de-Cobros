import java.io.DataInputStream;  /*Paquete para poder recibir datos del cliente */
import java.io.DataOutputStream; /*Paquete para enviar datos al cliente */
import java.io.IOException;      /*Paquete para detectar cualquier error en el proceso de conexion con el cliente */
import java.net.ServerSocket;    
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {
    public static void main(String[] args) {
        ServerSocket Servidor = null;        /*Inicializacion del servidor */
        Socket sc = null;                    /*Inicializacion de cliente */
        final int puerto = 8003;             /*Declaracion del numero de puerto del servidor*/
        DataInputStream in;                  /*Declaracion objeto que recibira lo datos del cliente */
        DataOutputStream out;                /*Declaracion objeto que enviara los datos al cliente */

        

        try {                                                       /*Ejecutara el codigo hasta que ocurra un error de conexion */
            Servidor = new ServerSocket(puerto);                    /*Asignacion de la direccion del servidor (puerto) */
            System.out.println("Servidor iniciado");  

            while (true) {                                          /*Ciclo para mantener el servidor siempre activo, esperando por una peticion de los clientes */
                
                sc = Servidor.accept();                             /*El servidor espera a que un cliente se conecte, al conectarse asigna la direccion del cliente (su puerto) a "sc"*/
                in = new DataInputStream(sc.getInputStream());      /*Asigna a "in" los datos que se recibiran del cliente "sc" */
                out = new DataOutputStream(sc.getOutputStream());   /*Asigna a "in" los datos que se enviaran al cliente "sc" */

                String mensajeRecibido =  in.readUTF();             /*lee lo que envia el cliente y lo guarda en la variable mensajeRecibido */
                System.out.println(mensajeRecibido);

                out.writeUTF("Qiuvolas");                           /*El servidor manda un mensaje al cliente */

                sc.close();                                         /*Se cierra la sesion con el cliente */
                System.out.println("Sesion terminada");

            }
            
        } catch (Exception ex) {           /*Si ocurre un error se ejecuta el codigo en catch, y "exception" crea un objeto "ex" con los datos del error ocurrido */   
            Logger.getLogger(Servidor.class.getName()) .log(Level.SEVERE, null, ex);



        }
    }

}
