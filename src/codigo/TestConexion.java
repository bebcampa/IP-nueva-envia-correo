/*
 * Clase para tester si hay conexion
 * retornamos un booleano
 * */
package codigo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class TestConexion {

	public boolean testConexion(){
		try {
			final URL url = new URL("https://google.com");
			final URLConnection conn = url.openConnection();
			conn.connect();
			conn.getInputStream().close();
			return true;
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			return false;
		}
	}
}
