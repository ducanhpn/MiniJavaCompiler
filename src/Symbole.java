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


