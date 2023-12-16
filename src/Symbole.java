import java.util.*;

public class Symbole{
  HashMap<String, String> tabelle = new HashMap<>();
  public  int paraNum = 0;
  public  String functionName = "";
  public  String byteCode = "";
   Set<String> variableNames = new HashSet<>();
  //addConstant methode
   void addConstant(String id, String wert) throws ConstantAlreadyException {
    if(tabelle.containsKey(id)){
      throw new ConstantAlreadyException("This constant is already exist");
    }
    else{
      tabelle.put(id,wert);
      System.out.println("add contant success");
    }
  }

  // addVariable
   void addVariable(String variableName, String address) throws SymbolAlreadyDefinedException{
    if (tabelle.containsKey(variableName)) {
      throw new SymbolAlreadyDefinedException("This variable is already exist");
    }
    else{
      tabelle.put(variableName,address);
      //state[Integer.parseInt(address)] = value;
      variableNames.add(variableName);
      System.out.println("add variable name :" + variableName + " Address: " + address);
    }
  }
  //getSymbol methode
   String getSymbol(String id) throws UnknowSymbolException {
    if(tabelle.containsKey(id)){
      return tabelle.get(id);
    }
    else{
      throw new UnknowSymbolException("this constant don't exist");
    }
  }
}

//neue Exceptionsklasse erstellen
class ConstantAlreadyException extends Exception {
  public ConstantAlreadyException(String message){
    super(message);
  }
}

class UnknowSymbolException extends Exception {
  public UnknowSymbolException(String message){
    super(message);
  }
}

class SymbolAlreadyDefinedException extends Exception {
  public SymbolAlreadyDefinedException(String message) { super(message);}
}

class WrongParametersException extends Exception{
    public WrongParametersException(String message){super(message);}
}

class RWertException extends Exception{
    public RWertException(String message){super(message);}
}