package modelo;

import java.util.concurrent.Semaphore;

public class Bodega {

	private int capacidadM;
	private int capacidadoOcupada;
	private int cantA1;
	private int cantA2;
	private Semaphore mutex;
	private Semaphore sinc;

	public Bodega(){

		capacidadM=2000;
		capacidadoOcupada=0;
		cantA1=0;
		cantA2=0;
		mutex = new Semaphore(1);
		
		sinc = new Semaphore(1);
	}
	public void descargarArticulo(int tipo) throws InterruptedException{
		sinc.acquire();
		if (tipo==1){
			//while(capacidadM<capacidadoOcupada+10);
			mutex.acquire();
			capacidadoOcupada+=10;
			cantA1++;
			mutex.release();
			System.out.println("SE HA AGREGADO UN ARTICULO DE 10");

		} if (tipo==2){

			while(capacidadM<capacidadoOcupada+15);
			mutex.acquire();
			capacidadoOcupada+=15;
			cantA2++;
			mutex.release();
			System.out.println("SE HA AGREGADO UN ARTICULO DE 15");
		}
		sinc.release();



	}
	public void crearPaquete() throws InterruptedException{
		sinc.acquire();
		if(cantA1>=3&&cantA2>=4)
		{

			//while(cantA1<3&&cantA2<4);
			mutex.acquire();
			cantA1-=3;
			cantA2-=4;
			capacidadoOcupada-=10*cantA1;
			capacidadoOcupada-=15*cantA2;
			mutex.release();
			System.out.println("PAQUETE CREADO");
		}else
		{

			//System.out.println("NO SE HA PODIDO CREAR EL PAQUETE");
		}
		sinc.release();



	}


}
