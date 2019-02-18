package controller;

import java.io.FileReader;
import java.util.Scanner;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import model.data_structures.ColaEstructura;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.PilaEstructura;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import view.MovingViolationsManagerView;

public class Controller {

	private MovingViolationsManagerView view;

	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private ColaEstructura<VODaylyStatistic> dailyStatisticQueue;

	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private PilaEstructura<VOMovingViolations> movingViolationsStack;


	private VOMovingViolations vio;

	private VODaylyStatistic estats;


	public Controller() 
	{
		view = new MovingViolationsManagerView();

		//TODO, inicializar la pila y la cola
		dailyStatisticQueue = new ColaEstructura<VODaylyStatistic>();
		movingViolationsStack = new PilaEstructura<VOMovingViolations>();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 1:
				this.loadMovingViolations();
				break;

			case 2:
				IQueue<VODaylyStatistic> dailyStatistics = this.getDailyStatistics();
				view.printDailyStatistics(dailyStatistics);
				break;

			case 3:
				view.printMensage("Ingrese el número de infracciones a buscar");
				int n = sc.nextInt();

				IStack<VOMovingViolations> violations = this.nLastAccidents(n);
				view.printMovingViolations(violations);
				break;

			case 4:	
				fin=true;
				sc.close();
				break;
			}
		}
	}



	public void loadMovingViolations() 
	{

		try 
		{
			CSVReader reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_January_2018.csv"));
			String[] nextLine = reader.readNext();

			String dia = null;

			while ((nextLine = reader.readNext()) != null) 
			{	
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]),nextLine[12],nextLine[15],nextLine[14]);
				movingViolationsStack.push(vio);

				boolean accidente = false;

				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente );
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats= new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
				}
			}

			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_February_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while ((nextLine = reader.readNext()) != null) 
			{				
				
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]),nextLine[12],nextLine[15],nextLine[14]);
				movingViolationsStack.push(vio);

				
				boolean accidente = false;

				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_March_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia = nextLine[13].split("T")[0];
					estats = new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_April_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia = nextLine[13].split("T")[0];
					estats = new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_May_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_June_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_July_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_August_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_September_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_October_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_November_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			
			}
			
			reader = new CSVReader(new FileReader("./data/Moving_Violations_Issued_in_December_2018.csv"));
			nextLine = reader.readNext();
			dia = null;
			while (( nextLine = reader.readNext() ) != null) {
				vio = new VOMovingViolations(Integer.parseInt(nextLine[0]), nextLine[2], nextLine[13], Integer.parseInt(nextLine[9]), nextLine[12], nextLine[15], nextLine[14]);
				movingViolationsStack.push(vio);
				
				boolean accidente = false;
				
				if(nextLine[12].equalsIgnoreCase("Yes"))
				{
					accidente = true;
				}
				if(nextLine[13].split("T")[0].equals(dia))
				{
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
				}
				else if (!nextLine[13].split("T")[0].equals(dia))
				{
					dia=nextLine[13].split("T")[0];
					estats=new VODaylyStatistic(dia);
					estats.actualizar(Integer.parseInt(nextLine[8]), accidente);
					dailyStatisticQueue.enqueue(estats);
					
				}
			
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public ColaEstructura<VODaylyStatistic> getDailyStatistics ()
	{

		return dailyStatisticQueue;
	}

	public PilaEstructura<VOMovingViolations> nLastAccidents(int n) 
	{
		PilaEstructura<VOMovingViolations> nueva = new PilaEstructura<VOMovingViolations>();

		for(int i= 0; i < n; i++)
		{
			nueva.push( movingViolationsStack.pop());
		}
		return nueva;
	}
}
