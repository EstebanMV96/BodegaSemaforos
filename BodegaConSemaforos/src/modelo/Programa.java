package modelo;

public class Programa {
	
	private Bodega bodega;
	private  Descargador procesoDescargador;
	private  Empacador procesoEmpacador;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Programa p = new Programa();

	}
	
	public Programa(){
		bodega = new Bodega();
		procesoDescargador = new Descargador(bodega);
		procesoDescargador.start();
		procesoEmpacador = new Empacador(bodega);
		procesoEmpacador.start();
		
	}

	

}
