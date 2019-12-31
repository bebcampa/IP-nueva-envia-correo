/*Clase que envia el correo.
 *
 * 
 * */

package codigo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviaCorreo {

	public static void enviarCorreoIp() throws InterruptedException {
		String ipantigua = " ";//variable donde almacenamos la ip
		try {
			ipantigua = Fichero.ReadFile();//leemos el fichero y guardamos la ip
		} catch (IOException e3) {
			e3.printStackTrace();
		}
		SimpleDateFormat formatea = new SimpleDateFormat(//Formato de fecha 
				"dd-MM-yyyy 'con hora' HH:mm:ss ");
		String ipnueva = " ";//variable de la ip actual
			Date fecha = new Date(System.currentTimeMillis());
			try {
				ipnueva = DameIp.getIp();
			} catch (Exception ex) {
				Logger.getLogger(App.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			if (ipantigua.equals(ipnueva)) {//comprueba si la ip del fichero coincide con la actual
				System.out.println("No se actualiza y no se envia el correo");
			} else {//si no coinciden enviamos el correo y actualizamos el fichero
				try {
					Fichero.writeFile3();//Se escribe la nueva ip en el fichero 
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				//Datos de conexion del correo saliente
				final String usuario = "usuario o el correo @gmail.com";
				final String contrasenia = "contrasenia";
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.starttls.enable", "true"); // Usamos TLS

				Session session = Session.getInstance(prop,
						new javax.mail.Authenticator() {
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(usuario,
										contrasenia);
							}
						});

				try {

					Message mail = new MimeMessage(session);
					mail.setFrom(new InternetAddress(
							"remitente@gmail.com"));//quien envia el correo
					mail.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse("destinatario @gmail.com"));//destinatario
					mail.setSubject("Mail automatico router");//titulo
					try {
						ipantigua = DameIp.getIp();//cuerpo del mail
						mail.setText("Este es un mensaje automatico. \nLa IP es: "
								+ DameIp.getIp()
								+ " ha cambiado "
								+ formatea.format(fecha)
								+ "\nCada vez que cambia la ip se envia este correo. \n"
								+ "No es Spam!");
					} catch (Exception ex) {
						Logger.getLogger(App.class.getName()).log(
								Level.SEVERE, null, ex);
					}

					Transport.send(mail);
					System.out.println("La IP ha cambiado: "//este mensaje es para la consola
							+ formatea.format(fecha));

				} catch (MessagingException e) {
					e.printStackTrace();
				}

			}
			
		}
	}

