import java.util.*;

public class GlobalKlasse {
    public static HashMap<String,Symbole> functionList = new HashMap<>();
    public static ArrayList<MethodObject> objectsList = new ArrayList<>();

    //get function depend on its name
    public static Symbole getFunction(String functionName){
        return functionList.get(functionName);
    }
    //whenever create a function, add it to function list
    public static void setFunction(String functionName){
        functionList.put(functionName, new Symbole());
        // assign funtion name to Symbole instance
        functionList.get(functionName).functionName = functionName;
        System.out.println("Set function seccessfull: " + functionName);
    }

    //create MethodObject Array from function list
    public static void createSymbolTabelle(){
        Iterator it = functionList.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Symbole> pair = (Map.Entry)it.next();
            objectsList.add( new MethodObject(pair.getKey(), pair.getValue().paraNum,pair.getValue().byteCode));
        }
    }

    //get symbole local or global
    public static String getSymbol(String functionName, String id) throws UnknowSymbolException {
        if(functionList.get(functionName).tabelle.containsKey(id)){
            return getFunction(functionName).getSymbol(id);
        }
        else{
            return getFunction("main").getSymbol(id);
        }
    }
}
