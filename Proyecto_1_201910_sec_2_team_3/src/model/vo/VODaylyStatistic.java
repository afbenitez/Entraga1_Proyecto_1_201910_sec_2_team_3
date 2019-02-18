package model.vo;

public class VODaylyStatistic 
{
	private String dia;
	
	private int accidentes;
	
	private int infracciones;
	
	private int multasTotales;
	
	public VODaylyStatistic(String pDia)
	{
		dia = pDia;
		accidentes = 0;
		infracciones = 0;
		multasTotales = 0;
	}
	
	public void actualizar(int pMultasTotales, boolean accidente)
	{
		multasTotales+=pMultasTotales;
		if(accidente)
		{
			accidentes++;
		}
		else
			infracciones++;
	}
	
	public String darDia()
	{
		return dia;
	}
	
	public int darAccidentes()
	{
		return accidentes;
	}
	
	public int darInfracciones()
	{
		return infracciones;
	}
	
	public int darMultasTotales()
	{
		return multasTotales;
	}
}
