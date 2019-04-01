package pakiet1;

public class OperacjeBankowe {

	public double procentZlozony(double kwota, double oprocentowanie, int iloscLat) 
			throws Exception{
		double result =0.0;
		if (oprocentowanie>1) throw new Exception("Zbyt Wysokie Oprocentowanie");
		for (int i=0; i<iloscLat; i++){
			result = (kwota + result)*oprocentowanie;
		}
		return result;
	}
	
	public double rataKredytu(double kwota, double oprocentowanie, int iloscRat) 
			throws Exception{
		return (procentZlozony(kwota,oprocentowanie,iloscRat)+kwota)/iloscRat;
	}
	
	
	public static void main(String[] a) throws Exception{
		OperacjeBankowe ob = new OperacjeBankowe();
		System.out.println(ob.procentZlozony(1500, 12.5, 15));
		System.out.println(ob.rataKredytu(5000, 1.2, 24));
	}
}
