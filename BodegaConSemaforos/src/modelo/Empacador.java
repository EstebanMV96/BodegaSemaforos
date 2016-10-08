package modelo;

public class Empacador extends Thread {

	private Bodega bodega;

	public Empacador(Bodega bodega){
		this.bodega = bodega;
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				bodega.crearPaquete();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	
}
