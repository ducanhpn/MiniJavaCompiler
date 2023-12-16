/* Generated By:JavaCC: Do not edit this line. MiniJavaProgram.java */
public class MiniJavaProgram implements MiniJavaProgramConstants {

    public static GlobalKlasse globaleList;
    public static JavaClassFileGenerator abc = new JavaClassFileGenerator("ProgramFromGenerator",true,true,true);

    public static void main(String args[]){
        MiniJavaProgram parser = new MiniJavaProgram(System.in);
        try{
            globaleList.setFunction("main");
            parser.start();
        }catch(Exception e){
            System.out.println(e);
        }

        MethodObject[] objs = new MethodObject[globaleList.objectsList.size()];
        objs = globaleList.objectsList.toArray(objs);
        abc.generateClassFile(objs);
    }

  static final public void start() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                  String str="";
    str = programm();
 str+="b1";
globaleList.getFunction("main").paraNum = 0;
globaleList.getFunction("main").byteCode = str;
globaleList.createSymbolTabelle();
    jj_consume_token(0);
//str =str.replaceAll("(?:\\w{2})","$0 ");
System.out.println(str);
  }

  static final public String programm() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                        String str1=""; String str2="";String str3=""; String funcStr="";String procStr="";
    str1 = constDecl("main");
    str2 = varDecl("main",1);
    procStr = procList();
    funcStr = funcList();
    str3 = statement("main");
{if (true) return str1+str2+str3;}
    throw new Error("Missing return statement in function");
  }

  static final public String procList() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                         String procStr=""; String listStr="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VOID:
      procStr = procedure();
      listStr = procList();
      break;
    default:
      jj_la1[0] = jj_gen;
      ;
    }
    {if (true) return procStr + listStr;}
    throw new Error("Missing return statement in function");
  }

  static final public String funcList() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                         String funcStr=""; String listStr="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FUNC:
      funcStr = function();
      listStr = funcList();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    {if (true) return funcStr + listStr;}
    throw new Error("Missing return statement in function");
  }

//const declaration
  static final public String constDecl(String functionName) throws ParseException, ConstantAlreadyException {
                                                                       String ret="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FINAL:
      jj_consume_token(FINAL);
      jj_consume_token(INT);
      ret = constZuw(functionName);
      constList(functionName);
      jj_consume_token(21);
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
 {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public String constZuw(String functionName) throws ParseException, ConstantAlreadyException {
                                                                      Token t1=null; Token t2=null;
    t1 = jj_consume_token(IDENT);
    jj_consume_token(22);
    t2 = jj_consume_token(NUMBER);
    globaleList.getFunction(functionName).addConstant(t1.image, t2.image);
    if(functionName.equals("main")) {if (true) return "";}
    {if (true) return "";}
    throw new Error("Missing return statement in function");
  }

  static final public void constList(String functionName) throws ParseException, ConstantAlreadyException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      constZuw(functionName);
      constList(functionName);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
  }

//variable declaration
  static final public String varDecl(String functionName, int i) throws ParseException, SymbolAlreadyDefinedException {
                                                                                 Token varName=null; String str1=""; String str2="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      varName = jj_consume_token(IDENT);
      str1 = varZuw(functionName, varName,i);
      str2 = varList(functionName, i+1);
      jj_consume_token(21);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
{if (true) return str1+str2;}
    throw new Error("Missing return statement in function");
  }

  static final public String varZuw(String functionName, Token varName,int index) throws ParseException, SymbolAlreadyDefinedException {
                                                                                                  Token value=null; String str="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 22:
      jj_consume_token(22);
      value = jj_consume_token(NUMBER);
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
int i;
if(value==null) i=0 ;
else i = Integer.parseInt(value.image);
//add variable
globaleList.getFunction(functionName).addVariable(varName.image, String.valueOf(index));
if(i <= 15) {str= "100" + Integer.toHexString(i);}
else if(i <=255) str = "10" + Integer.toHexString(i);
else if(i <= 4095) str = "110" + Integer.toHexString(i);
else str="11" + Integer.toHexString(i);
str += "36";
if(index <= 15) str+= "0"+index;
else str += index;
{if (true) return str;}
    throw new Error("Missing return statement in function");
  }

  static final public String varList(String functionName, int i) throws ParseException, SymbolAlreadyDefinedException {
                                                                                 Token varName=null; String str1=""; String str2="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      varName = jj_consume_token(IDENT);
      str1 = varZuw(functionName, varName,i);
      str2 = varList(functionName, i+1);
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
{if (true) return str1+str2;}
    throw new Error("Missing return statement in function");
  }

  static final public String expression(String functionName) throws ParseException, UnknowSymbolException {
                                                                      String strTerm=""; String strSumme="";
    strTerm = term(functionName);
    strSumme = summe(functionName);
     {if (true) return strTerm+strSumme;}
    throw new Error("Missing return statement in function");
  }

  static final public String summe(String functionName) throws ParseException, UnknowSymbolException {
                                                                String strTerm=""; String strSumme="";Token plusToken=null; Token minusToken=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case MINUS:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        plusToken = jj_consume_token(PLUS);
        break;
      case MINUS:
        minusToken = jj_consume_token(MINUS);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      strTerm = term(functionName);
      strSumme = summe(functionName);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
    if(plusToken != null){
        strTerm= strTerm+"60"+strSumme;
    }
    if(minusToken!=null){
        strTerm= strTerm+"64"+strSumme;
    }
 {if (true) return strTerm;}
    throw new Error("Missing return statement in function");
  }

  static final public String term(String functionName) throws ParseException, UnknowSymbolException {
                                                               String strFaktor=""; String strProduct="";
    strFaktor = faktor(functionName);
    strProduct = product(functionName);
    {if (true) return strFaktor+strProduct;}
    throw new Error("Missing return statement in function");
  }

  static final public String product(String functionName) throws ParseException, UnknowSymbolException {
                                                                  Token malToken=null; Token geteiltToken=null; String strFaktor=""; String strProduct="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAL:
    case GETEILT:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MAL:
        malToken = jj_consume_token(MAL);
        break;
      case GETEILT:
        geteiltToken = jj_consume_token(GETEILT);
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      strFaktor = faktor(functionName);
      strProduct = product(functionName);
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
    if(malToken!= null) strFaktor=strFaktor+"68"+strProduct;
    if(geteiltToken !=null) strFaktor= strFaktor+"6c"+strProduct;
 {if (true) return strFaktor;}
    throw new Error("Missing return statement in function");
  }

  static final public String faktor(String functionName) throws ParseException, UnknowSymbolException {
                                                                 Token num=null; Token ident=null; String exp =""; String str="";int i=0;String tmp=""; Token check=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      num = jj_consume_token(NUMBER);
    i = Integer.parseInt(num.image);

            // print bytecode
            if(i <= 15) str= "100" + Integer.toHexString(i);
            else if(i <=255) str = "10" + Integer.toHexString(i);
            else if(i <= 4095) str = "110" + Integer.toHexString(i);
            else str="11" + Integer.toHexString(i);
            {if (true) return str;}
      break;
    case IDENT:
      ident = jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 24:
        check = jj_consume_token(24);
        tmp = functionCall(functionName);
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
if(check == null){
    if(globaleList.getFunction(functionName).tabelle.containsKey(ident.image)){ // es gibt Variable in der Symbole Tabelle
        //Go, let find in this function
        if(globaleList.getFunction(functionName).variableNames.contains(ident.image)){//variable
                    //print byte code
                    i = Integer.parseInt(globaleList.getSymbol(functionName,ident.image));
                    if( i<=15) str="150"+ Integer.toHexString(i);
                    else str = "15"+Integer.toHexString(i);
                    //
            }
            else{//konstant
                    //print byte code
                    i=Integer.parseInt(globaleList.getSymbol(functionName,ident.image));
                    if( i<=15) str="100"+ Integer.toHexString(i);
                    else str = "10"+Integer.toHexString(i);
                    //
            }
    }
    else{ // find in main
        if(globaleList.getFunction("main").variableNames.contains(ident.image)){//variable
                    //print byte code
                    i = Integer.parseInt(globaleList.getSymbol(functionName,ident.image));
                    if( i<=15) str="150"+ Integer.toHexString(i);
                    else str = "15"+Integer.toHexString(i);
                    //
            }
            else{//konstant
                    //print byte code

                    i=Integer.parseInt(globaleList.getSymbol("main",ident.image));

                    if( i<=15) str="100"+ Integer.toHexString(i);
                    else str = "10"+Integer.toHexString(i);
                    //
            }
    }

    {if (true) return "b2[aX]"+str+"b3[aX]";}
}
else{
    exp = "b8(".concat( ident.image+")");
    {if (true) return tmp + exp;}
}
      break;
    case 24:
      jj_consume_token(24);
      exp = expression(functionName);
      jj_consume_token(25);
 {if (true) return exp;}
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String condition(String functionName) throws ParseException, LWertException, UnknowSymbolException {
                                                                                   String exp1=""; String exp2=""; Token vergleichToken=null; String ret="";
    exp1 = expression(functionName);
    vergleichToken = jj_consume_token(COMPOP);
    exp2 = expression(functionName);
    //Hier ist die Java Code. Hier wird eine Bytecode String erstellt und der String wird genau an den Opcode für If beendet. Die String Länge wird danach gemessen
    //indem wir die String Länge durch 2 geteilt. Hier entscheiden wir nur, welche Bytecode mit der Opcode passt.
        ret += exp1;
        ret += exp2;
        String op = vergleichToken.image;
        switch(op){
            case "==": ret += "a0";  break;
            case "<=": ret += "a3"; break;
            case "<": ret += "a2"; break;
            case ">": ret += "a4"; break;
            case ">=": ret += "a1"; break;
            case "!=": ret += "9f"; break;
            default: {if (true) return "";}
        }
        {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public String statement(String functionName) throws ParseException, LWertException, UnknowSymbolException {
                                                                                   String temp=""; String stm = ""; String condStr = ""; String ret="";Token token=null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
      token = jj_consume_token(IDENT);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 24:
        jj_consume_token(24);
        ret = procCall(functionName);
        break;
      case 22:
        jj_consume_token(22);
        temp = expression(functionName);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(21);
if(!temp.equals("")){ // Zuweisung
    ret = temp;
    temp = token.image; // change temp to variable name
    if(globaleList.getFunction(functionName).tabelle.containsKey(temp) || globaleList.getFunction("main").tabelle.containsKey(temp)){
        ret += "36";
        int i = Integer.parseInt(globaleList.getSymbol(functionName, temp));

        if(i <= 15) ret+= "0"+Integer.toHexString(i);
        else ret += Integer.toHexString(i);
        {if (true) return ret;}
    }
    else{
        {if (true) throw new LWertException("variable doesn't exist");}
    }
}
else{
{if (true) return ret+"b8(" + token.image +")";}
}
      break;
    case PRINT:
      jj_consume_token(PRINT);
      jj_consume_token(24);
      temp = expression(functionName);
      jj_consume_token(25);
      jj_consume_token(21);
                                                      {if (true) return temp+"b8(print)";}
      break;
    case 26:
      jj_consume_token(26);
      ret = stmtList(functionName);
      jj_consume_token(27);
 {if (true) return ret;}
      break;
    case IF:
      jj_consume_token(IF);
      condStr = condition(functionName);
      stm = statement(functionName);
//ax xx xx a7 xx xx
int i = (6+stm.length()+6) /2;
if(i <= 15) condStr+= "000" + Integer.toHexString(i);
else if(i <=255) condStr += "00" + Integer.toHexString(i);
else if(i <= 4095) condStr += "0" + Integer.toHexString(i);
else condStr+= Integer.toHexString(i);
ret = condStr+stm+"a7";
      stm = optElse(functionName);
    i=(6+ stm.length()) / 2;
    if(i <= 15) ret+= "000" + Integer.toHexString(i);
    else if(i <=255) ret += "00" + Integer.toHexString(i);
    else if(i <= 4095) ret += "0" + Integer.toHexString(i);
    else ret+= Integer.toHexString(i);
    ret+= stm;
    {if (true) return ret;}
      break;
    case WHILE:
      jj_consume_token(WHILE);
      condStr = condition(functionName);
      stm = statement(functionName);
 //
    i = stm.length() / 2 + 3 + 3;
    if(i <= 15) condStr+= "000" + Integer.toHexString(i);
    else if(i <=255) condStr += "00" + Integer.toHexString(i);
    else if(i <= 4095) condStr += "0" + Integer.toHexString(i);
    else condStr+= Integer.toHexString(i);

    int backward = 65535 - i;
    ret = condStr+stm+"a7";
    if(backward <= 15) ret+= "000" + Integer.toHexString(backward);
    else if(backward <=255) ret += "00" + Integer.toHexString(backward);
    else if(backward <= 4095) ret += "0" + Integer.toHexString(backward);
    else ret+= Integer.toHexString(backward);

    {if (true) return ret;}
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String optElse(String functionName) throws ParseException, LWertException, UnknowSymbolException {
                                                                                 String ret="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      ret = statement(functionName);
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public String stmtList(String functionName) throws ParseException, LWertException, UnknowSymbolException {
                                                                                  String stm="";String list = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHILE:
    case IF:
    case PRINT:
    case IDENT:
    case 26:
      stm = statement(functionName);
      list = stmtList(functionName);
      break;
    default:
      jj_la1[16] = jj_gen;
      ;
    }
    {if (true) return stm + list;}
    throw new Error("Missing return statement in function");
  }

//function call ( optional )
  static final public String functionCall(String functionName) throws ParseException, UnknowSymbolException {
                                                                       String exp1=""; String exp2="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case IDENT:
    case 24:
      exp1 = expression(functionName);
      exp2 = expList(functionName);
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
    jj_consume_token(25);
    {if (true) return exp1+exp2;}
    throw new Error("Missing return statement in function");
  }

  static final public String expList(String functionName) throws ParseException, UnknowSymbolException {
                                                                  String exp1=""; String exp2="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      exp1 = expression(functionName);
      exp2 = expList(functionName);
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    {if (true) return exp1+exp2;}
    throw new Error("Missing return statement in function");
  }

//procall
  static final public String procCall(String functionName) throws ParseException, UnknowSymbolException {
                                                                   String exp1=""; String exp2="";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case IDENT:
    case 24:
    case 25:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case IDENT:
      case 24:
        exp1 = expression(functionName);
        exp2 = expList(functionName);
        break;
      default:
        jj_la1[19] = jj_gen;
        ;
      }
      jj_consume_token(25);
      break;
    default:
      jj_la1[20] = jj_gen;
      ;
    }
    {if (true) return exp1+exp2;}
    throw new Error("Missing return statement in function");
  }

// parameters
  static final public int routinenParameter(String functionName) throws ParseException {
                                            int i=0; Token vName=null; int ret =i;
    jj_consume_token(INT);
    vName = jj_consume_token(IDENT);
                     globaleList.getFunction(functionName).tabelle.put(vName.image,String.valueOf(i));i+=1; ret=i;
    ret = parameterList(functionName, i);
System.out.println("How many parameter: " + ret);
{if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  static final public int parameterList(String functionName, int i) throws ParseException {
                                               Token vName=null;int ret=i;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 23:
      jj_consume_token(23);
      jj_consume_token(INT);
      vName = jj_consume_token(IDENT);
                             globaleList.getFunction(functionName).tabelle.put(vName.image,String.valueOf(i));i++;ret=i;
      ret = parameterList(functionName, i);
      break;
    default:
      jj_la1[21] = jj_gen;
      ;
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

//function /procedure scope. constDecl & varDerDecl können schon leer sein
  static final public String routinenBlock(String functionName,int i) throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                                                        String varStr="";String stm="";
    constDecl(functionName);
    varStr = varDecl(functionName, i);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHILE:
    case IF:
    case PRINT:
    case IDENT:
    case 26:
      stm = statement(functionName);
      break;
    default:
      jj_la1[22] = jj_gen;
      ;
    }
    {if (true) return varStr + stm;}
    throw new Error("Missing return statement in function");
  }

// func def
  static final public String function() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                        String blockStr=""; String exp=""; int i=0; Token mName=null;
    jj_consume_token(FUNC);
    mName = jj_consume_token(IDENT);
                          globaleList.setFunction(mName.image);
    jj_consume_token(24);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      i = routinenParameter(mName.image);
      break;
    default:
      jj_la1[23] = jj_gen;
      ;
    }
                                                                                                          // set function parameter number
                                                                                                              globaleList.getFunction(mName.image).paraNum = i;
    jj_consume_token(25);
    jj_consume_token(26);
    blockStr = routinenBlock(mName.image, i);
    jj_consume_token(RETURN);
    exp = expression(mName.image);
    jj_consume_token(21);
    jj_consume_token(27);
    // store byte code
    globaleList.getFunction(mName.image).byteCode = blockStr + exp + "ac" ;

    {if (true) return blockStr + exp + "ac";}
    throw new Error("Missing return statement in function");
  }

//procedure def
  static final public String procedure() throws ParseException, LWertException, ConstantAlreadyException, SymbolAlreadyDefinedException, UnknowSymbolException {
                                                                                                                         String blockStr="";int i=0; Token mName=null;
    jj_consume_token(VOID);
    mName = jj_consume_token(IDENT);
                     // add function to list
                             globaleList.setFunction(mName.image);
    jj_consume_token(24);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      routinenParameter(mName.image);
      break;
    default:
      jj_la1[24] = jj_gen;
      ;
    }
// set function parameter number
        globaleList.getFunction(mName.image).paraNum = i;
    jj_consume_token(25);
    jj_consume_token(26);
    blockStr = routinenBlock(mName.image,i);
    jj_consume_token(27);
        // store byte code
        globaleList.getFunction(mName.image).byteCode = blockStr + "b1";
{if (true) return blockStr+"b1";}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MiniJavaProgramTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[25];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x2000,0x1000,0x400,0x800000,0x800,0x400000,0x800000,0x300,0x300,0xc0,0xc0,0x1000000,0x1080020,0x1400000,0x409c000,0x20000,0x409c000,0x1080020,0x800000,0x1080020,0x3080020,0x800000,0x409c000,0x800,0x800,};
   }

  /** Constructor with InputStream. */
  public MiniJavaProgram(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MiniJavaProgram(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MiniJavaProgramTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MiniJavaProgram(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MiniJavaProgramTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MiniJavaProgram(MiniJavaProgramTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MiniJavaProgramTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 25; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 25; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
