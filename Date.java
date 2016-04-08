import java.util.*;


public class Date {
		private int dia;
		private int mes;
		private int year;
		
		public Date (int dia, int mes) throws Error{
			StringBuffer fecha = new StringBuffer ();
			
			if(dia<32 && dia >0 && mes>0 && mes<13){
				this.dia=dia;
				this.mes=mes;
			}
			else{
				fecha.append ("Fecha incorrecta");
			}
			if(fecha.length()!=0){
				throw new Error(fecha.toString());
			}
		}
		
		public Date (int dia, int mes, int year) throws Error{
			StringBuffer fecha = new StringBuffer();
			if( fechaCorrecta(dia,mes,year)){
				this.dia=dia;
				this.mes=mes;
				this.year=year;
			}
			else{
				fecha.append("Fallo de fecha");
				System.out.println(fecha);
				System.exit(0);
			}
			if(fecha.length()!=0){
				throw new Error(fecha.toString());
			}
		}
		
public boolean MismoDia(int unDia){
	if(dia==unDia){
		return true;
	}
	return false;
}

public boolean MismoMes(int unMes){
	if(mes==unMes){
		return true;
	}
	return false;
}

public boolean Mismoyear(int unyear){
	if(year==unyear){
		return true;
	}
	return false;
}

public boolean Igual(Date unaFecha){
	if(dia==unaFecha.dia && mes==unaFecha.mes && year==unaFecha.year){
		return true;
	}
	return false;	
}

public boolean fechaCorrecta(int dia, int mes, int year){
	if(dia<=0 || dia >31 || year<0 || mes <=0 || mes>12){
		return false;
	}
	if((dia<=31) && (mes==1 || mes==3 || mes==5 || mes ==7 || mes ==8 || mes==10 || mes==12)){
		return true;
	}
	else if((dia<=30) && (mes==4 || mes==6 || mes==9 || mes==11)){
		return true;
	}
	else if(dia<29 && mes==2){
		return true;
	}
	else{
		return false;
		}
	}

public String MesAString (int unMes){
	String mesString;
	switch (unMes){
		case 1: mesString= "Enero";break;
		case 2: mesString= "Febrero";break;
		case 3: mesString= "Marzo";break;
		case 4: mesString= "Abril";break;
		case 5: mesString= "Mayo";break;
		case 6: mesString= "Junio";break;
		case 7: mesString= "Julio";break;
		case 8: mesString= "Agosto";break;
		case 9: mesString= "Septiembre";break;
		case 10: mesString= "Octubre";break;
		case 11: mesString= "Noviembre";break;
		case 12: mesString= "Diciembre";break;
		
		default: mesString="";break;
	}
	return mesString;
}

public void imprimirFecha(Date fecha){
	String mesString=MesAString(fecha.mes);
	
	System.out.println(fecha.dia+" de "+ mesString+" de "+fecha.year);
}

public int fallosFecha() throws Error{
	
	int intentos=0;
	
	Random randomNumber=new Random();
	randomNumber.setSeed(System.currentTimeMillis());
	
	Date fechaAleatoria = null;
	do{
		int diaAleatorio=randomNumber.nextInt(31)+1;
		int mesAleatorio=randomNumber.nextInt(12)+1;
		if(fechaCorrecta(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio, mesAleatorio, year);
			intentos++;
		}
	}while(!Igual(fechaAleatoria));
	
	System.out.println("Intentos: "+intentos);
	return intentos;
}

public int fallosFecha_2() throws Error{
	
	int intentos=0;
	
	Random randomNumber=new Random();
	randomNumber.setSeed(System.currentTimeMillis());
	
	Date fechaAleatoria = new Date(1,1,5000);
	while(!Igual(fechaAleatoria)){
		int diaAleatorio=randomNumber.nextInt(31)+1;
		int mesAleatorio=randomNumber.nextInt(12)+1;
		if(fechaCorrecta(diaAleatorio,mesAleatorio,year)){
			fechaAleatoria=new Date(diaAleatorio, mesAleatorio, year);
			intentos++;
		}
	}
	System.out.println("Intentos 2: "+intentos);
	return intentos;
	}

public void DiaDeSemana(Date fecha, int diaSemana){
	String[] dias={"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
	int diasTranscurridos=TranscurridosEnyear(fecha);
	int resto=diasTranscurridos%7;
	
	int diaBuscado=(diaSemana+resto)%7;
	
	System.out.println("Hoy es : "+diaBuscado);
}

public int TranscurridosEnyear(Date fecha){
	int diasTotales=0;
	switch(fecha.mes){
		case 1:diasTotales=0;break;
		case 2:diasTotales=31;break;
		case 3:diasTotales=59;break;
		case 4:diasTotales=90;break;
		case 5:diasTotales=120;break;
		case 6:diasTotales=151;break;
		case 7:diasTotales=181;break;
		case 8:diasTotales=212;break;
		case 9:diasTotales=243;break;
		case 10:diasTotales=273;break;
		case 11:diasTotales=304;break;
		case 12:diasTotales=334;break;
	}
	diasTotales+=fecha.dia;
	System.out.println("Han pasado "+diasTotales+ " del year");
	return diasTotales;
}

public int mesesQuedan(Date fecha){
	int i;
	int transcurridos=1;
	int restantes=0;

		transcurridos+=fecha.mes-1;
		restantes=12-transcurridos;
		
		System.out.println("Quedan "+restantes+" meses del year");
		return restantes;
}

public void FinMes(Date fecha){
	
	if(mes==1 || mes==3 || mes==5 || mes ==7 || mes ==8 || mes==10 || mes==12)
		System.out.println("Quedan: "+ (31-fecha.dia)+" del mes");
	else if(mes==4 || mes==6 || mes==9 || mes==11)
		System.out.println("Quedan: "+ (30-fecha.dia)+" del mes");
	else
		System.out.println("Quedan: "+ (28-fecha.dia)+" del mes");
	
}

public void Temporada(int unMes){
	String mesString;
	if(unMes==11 || unMes==12 || unMes==1 || unMes==2)
		System.out.println("Invierno");
	else if(unMes==3||unMes==4|| unMes==5)
		System.out.println("Primavera");
	else if(unMes==6||unMes==7||unMes==8)
		System.out.println("Verano");
	else
		System.out.println("Autumn");
}

public void DiasIguales(int unMes){
	if(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
		System.out.println("Meses de 31 dias: Enero,Marzo,Mayo,Julio,Agosto,Octumbre y Diciembre");
	}
	else if(mes==4||mes==6||mes==9||mes==11){
		System.out.println("Meses de 30 dias: Abril,Junio,Septiembre y Noviembre");
	}
	else{
		System.out.println("Febrero es el unico mes con 28 dias, 29 si es year bisiesto");
	}
}


}

