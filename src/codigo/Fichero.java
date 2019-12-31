/*
 * Clase fichero: 
 * */

package codigo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fichero {
	//escribe la ip en una linea nueva en el fichero.
	public static void writeFile3() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("ips.txt",true));
		try {
			pw.write(DameIp.getIp());
			pw.write("\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}
	//lee la ultima linea del fichero.
	public static String ReadFile () throws IOException{
		Scanner sc = new Scanner(new FileReader("ips.txt"));
		String last=" ";
		while (sc.hasNextLine()){
			last=sc.nextLine();
		}
		sc.close();
		return last;
	}
	


}
