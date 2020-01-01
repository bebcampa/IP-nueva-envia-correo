# IP-nueva-envia-correo
Comprueba la IP del router, si esta cambia enviara un correo electrónico.
El funcionamiento es el siguente:
Se guarda en un fichero la IP del router, si el fichero no existe se creará y enviara el mensaje. Para las siguientes comprobaciones, se usa el fichero como referencia, si el valor del fichero coincide con la IP actual del router la aplicación no hará nada, en caso de que no coinciden la aplicación abre una sesión en la cuenta del correo electrónico, se envía el mensaje y se actualiza el fichero.
*Para el envío de mails usamos la librería Javax de JAVA EE(Java Mail), no es necesario un servidor de correo electrónico.
*Se usa cifrado TLS.
*Se puede ejecutar a modo de script o aplicación
