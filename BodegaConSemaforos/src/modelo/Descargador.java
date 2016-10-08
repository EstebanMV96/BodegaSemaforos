package modelo;

import java.util.Random;

public class Descargador extends Thread {
	
	private Bodega bodega;
	
	public Descargador(Bodega bodega){
		this.bodega=bodega;
	}

	@Override
	public void run() {
		Random aleatorio = new Random();
		while(true){
			int tiempoDeDescarga = aleatorio.nextInt(10);
			System.out.println("Tiempo descargando: "+tiempoDeDescarga+" segundos");
			try {
				sleep(tiempoDeDescarga*1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			int tipo = (int) (Math.random()*2+1);
			System.out.println("Se descarga articulo tipo: "+tipo);
			try {
				bodega.descargarArticulo(tipo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	

}
