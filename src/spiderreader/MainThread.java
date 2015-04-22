    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiderreader;

/**
 *
 * @author Luis
 */
public class MainThread {
   
    public static void main(String[] args) {

		String link1 ="http://www.lateja.co.cr/";
                String link2 ="http://www.nacion.com/";
                String searchWord="CCSS";
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		LinkThread thread1 = new LinkThread(link1, searchWord,initialTime );
		LinkThread thread2 = new LinkThread(link2, searchWord, initialTime);

		thread1.start();
		thread2.start();
	}
}
