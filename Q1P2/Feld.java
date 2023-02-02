package Q1P2;



public class Feld {
	public static void main(String[] args) {
		
		
		//Konstanten festlegen, hier: maximale Anzahl der Feldelemente
		final int cMaxZahlen = 20; //Dimension des Feldes
		final int cMaxZZahl  = 100; //größte Zahl im Feldelement
		
		
		
		
		//Deklaration des Feldes und weiterer Variablen
		int[] zahlen;
		
		//Allokation des Speichers
		zahlen = new int[cMaxZahlen];
		
		//Initialisieren (a)
		System.out.println("====== Feld initialisieren =======");
		FeldFuellen(zahlen,cMaxZahlen,0);
		FeldAusgeben(zahlen,cMaxZahlen);
		//mit Zufallszahlen füllen (b)
		System.out.println("====== Feld mit Zufallszahlen =======");
		FeldFuellenZufallszahl(zahlen,cMaxZahlen,cMaxZZahl);
		FeldAusgeben(zahlen,cMaxZahlen);
		System.out.println("Größte zahl:" +sucheFeldMaxWert(zahlen));
		System.out.println("Kleinste zahl:" +sucheFeldMinWert(zahlen));
		bubbleSort(zahlen);
		System.out.println("Sortiert: ");
		FeldAusgeben(zahlen, cMaxZZahl);
	}
	
	static void FeldFuellen(int[] dasFeld, int maxAnzahl, int fuellWert) {
		
		//Deklation von notwendigen lokalen Variablen
		int counter;

		//Füllen mit Nullen "zu Fuß"
		//Füllen bequem (setzt java.util.Arrays voraus): fill(zahlen,1);
		for (counter = 0; counter < maxAnzahl ; counter++) {
			dasFeld[counter] = fuellWert;
		}
		
		
	}

	static void FeldFuellenZufallszahl(int[] dasFeld, int maxAnzahl, int maxZufallszahl) {
		//Deklaration von notwendigen lokalen Variablen
		int counter;
		
		for (counter = 0; counter < maxAnzahl ; counter++) {
			dasFeld[counter] = (int) (Math.random() * maxZufallszahl) + 1;
		}
	}
	
	static void FeldAusgeben(int[] dasFeld, int maxAnzahl) {
		//Deklation von notwendigen lokalen Variablen
		for (int i: dasFeld) {
			System.out.println(i);
		}
	}
	
	/**
	 * Sucht die Goesste Zahl in einem Array
	 * @param arr das Array das durchsucht werden soll
	 * @return Die groeste Zahl des gegebenen Arrays
	 */
	public static int sucheFeldMaxWert(int[] arr)
	{
		int currentMax = arr[0];
		for(int i:arr) currentMax = (i>currentMax)? i:currentMax;
		return currentMax;
	}
	
	
	/**
	 * Sucht die kleinste Zahl in einem Array
	 * @param arr das Array das durchsucht werden soll
	 * @return Die kleinste Zahl des gegebenen Arrays
	 */
	public static int sucheFeldMinWert(int[] arr)
	{
		int currentMin = arr[0];
		for(int i:arr) currentMin = (i<currentMin)? i:currentMin;
		return currentMin;
	}
	
	/**
	 * Sortiert ein gegbenes Array der größe nach
	 * @param arr das array welches Sortiert werden soll
	 */
	public static void bubbleSort(int[] arr)
	{
		for(int n=arr.length; n>1; n--)
		{
			for(int i=0; i<n-1; i++)
			{
				if (arr[i]>arr[i+1])
				{
					swap(i, i +1, arr);
				}
			}
		}
	}

	private static void swap(int i, int j, int[] arr) 
	{
		int x = arr[i];
		arr[i] = arr[j];
		arr[j] = x;
		
	}
	
	
	/**
	 * Sortiert ein gegebenes int Array nach dem mergeSort algorithmuse 
	 * sehr schnelle Laufzeit O(nlog(n))
	 * @param unsorted 
	 * @return das sortierte Array
	 */
	public static int[] mergeSort(int[] unsorted)
	{
		int lenght = unsorted.length;
		if (lenght < 2)
		{
			return unsorted;
		}
		
		int midIndex = (lenght)/2;
		
		int[] links = new int[midIndex];
		int[] rechts = new int[lenght-midIndex];
		int rechtsIndex = 0;
		for (int i = 0; i<lenght; i++)
		{
			if (i < midIndex)
			{
				links[i] = unsorted[i];
			}
			else
			{
				rechts[rechtsIndex] = unsorted[i];
				rechtsIndex++;
			}
		}
		
		links = mergeSort(links);
		rechts = mergeSort(rechts);
		unsorted = merge(links, rechts);
		return unsorted;
		
		
	}

	private static int[] merge(int[] links, int[] rechts)
	{
		int[] sorted = new int[links.length+rechts.length];
		
		int linksIndex = 0, rechtsIndex = 0; 
		int k = 0;
		
		while((linksIndex < links.length) && (rechtsIndex < rechts.length) && (k < sorted.length))
		{
			if (links[linksIndex] <= rechts[rechtsIndex])
			{
				sorted[k] = links[linksIndex];
				linksIndex++;
			}
			else
			{
				sorted[k] = rechts[rechtsIndex];
				rechtsIndex++;
			}
			k++;
		}
		
		while (rechtsIndex < rechts.length)
		{
			sorted[k] = rechts[rechtsIndex];
			rechtsIndex++;
			k++;
		}
		
		while (linksIndex < links.length)
		{
			sorted[k] = links[linksIndex];
			linksIndex++;
			k++;
		}
		return sorted;
	}
	
	public static int fakultät(int n)
	{	
		return (n == 0)? 1 : n*fakultät(n-1);
	}
	
	public static int fakultätIterativ(int n)
	{
		int result = 1;
		
		do
		{
			result = result * n;
			n--;
		} while (n != 0);
		
		return result;
	}
	
	public static int fakultätFor(int n)
	{
		int result = 1;
		for (int i = n; i>0; i--)
		{
			result *= i;
		}
		return result;
	}
	
	
	
	
	
	
	
}

