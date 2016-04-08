import java.util.Scanner;

public class Main {


	public static void main(String[] args) throws Error{
		Scanner lee=new Scanner (System.in);
		System.out.println("Dame un dia");
		int dia=lee.nextInt();
		System.out.println("Dame un mes");
		int mes=lee.nextInt();
		System.out.println("Dame un year");
		int year=lee.nextInt();
		Date fecha=new Date(dia,mes,year);
		
		fecha.imprimirFecha(fecha);
		fecha.fallosFecha();
		fecha.fallosFecha_2();
		fecha.DiaDeSemana(fecha,5);
		fecha.Temporada(mes);
		fecha.DiasIguales(mes);
		fecha.mesesQuedan(fecha);
		fecha.FinMes(fecha);
		
	}
	
	public static void tabla(int num){
		for(int i=1; i<=10;i++){
			System.out.println(i*num);
		}
	}

}
