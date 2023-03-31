package etu2063.framework;

public class Mapping{
    String className,Method;

    public String getClassName(){
        return className;
    }

    public void setClassName(String className){
        this.className=className;
    }

    public String getMethode(){
        return Method;
    }

    public void setMethode(String Methode){
        this.Method=Methode;
    }

    public Mapping (String className,String Methode){
        this.className = className;
        this.Method=Methode;
    }
}