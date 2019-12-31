package codigo;

import java.util.Timer;
import java.util.TimerTask;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 *Uso del programa como si fuera un script, para comprobar la IP hay que ejecutarlo periodicamente.
		 *En mi caso lo tengo automatizado con crontab en linux. 
		 *
		 * */
		
		//muesta mensaje en consola en caso de que no hay conexion.
		TestConexion test = new TestConexion();
		boolean hayconex = test.testConexion();
		if(hayconex==true){//si hay conexion comprobamos datos
			EnviaCorreo.enviarCorreoIp();
			
		}else{//mensaje en consola
			System.out.println("Sin conexion");
		}

	/*
	
	 * Este bloque comentado es para usar el programa ejecutandolo una sola vez, se comprueba la IP cada 300 segundos.
	 * 
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//Aqui Van las tareas que se ejecutan cada x tiempo
				
				try {
					TestConexion test = new TestConexion();
		boolean hayconex = test.testConexion();
		if(hayconex==true){//si hay conexion comprobamos datos
			EnviaCorreo.enviarCorreoIp();
			
		}else{//mensaje en consola
			System.out.println("Sin conexion");
		}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		//Hay que crear un Timer
		Timer timer = new Timer();
		//crear variables de intervalo y tiempo.
		long delay = 0;
		long interval = 1*300000;//se ejecuta cada 300 segundos
		// usar el timer creado.
		timer.scheduleAtFixedRate(tarea, delay, interval);
		
		*/
	}

}
