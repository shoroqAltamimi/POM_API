package api.endpoints;


//In this class we will maintain only URLs 

//URL: https://www.almosafer.com
//List of prices with currencies (GET) : https://www.almosafer.com/api/system/currency/list  
//Advance search (Post) : // https://www.almosafer.com/api/accommodation/property/advance-search


public class Routes {
	
	public static String base_URL="https://www.almosafer.com/api";
	public static String advanceSearch_URL=base_URL+"/accommodation/property/advance-search";
	public static String currencyList_URL=base_URL+"/system/currency/list";

}
