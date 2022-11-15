package mainFunctions;

import java.util.ArrayList;

public class validatePriceMarketData {

public static boolean validatePriceData(ArrayList<String> Price)
{
	ArrayList<Double> PriceInt = new ArrayList<Double>();
	Double x;
	for(String S:Price)
	{
		S = S.replace("$","");
		x = Double.parseDouble(S);
		PriceInt.add(x);
	}
	boolean b = false;
	for(Double k:PriceInt)
	{
		if(k>101&k<1000)
		{
			b = true;
		}
	}
	return b;
}

public static boolean validateMarketData(ArrayList<String> MarketCap)
{
	Long y;
	ArrayList<Long> MarketCapInt = new ArrayList<Long>(); 
	for(String S1:MarketCap)
	{
		if(S1.contains("--"))
		{
			continue;
		}
		else {
		S1 = S1.replace("$","");
		S1 = S1.replace(",", "");
		y = Long.parseLong(S1);
		MarketCapInt.add(y);
		}
	}
		boolean c = false;

		for(Long k:MarketCapInt)
		{
			if(k>1000000000&k<10000000000L)
				c=true;
			
		}
	
	return c;
	
}

}

