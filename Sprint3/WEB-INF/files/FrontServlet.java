package etu2063.framework.servlet;

import java.io.*;
import etu2063.framework.annot.*;
import etu2063.framework.Mapping;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.cert.CertStoreException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrl =new HashMap<>();
    
    @Override
    public void init() throws ServletException{
        try{
            for(Class c : inPackage("model")){
                for(Method m : c.getDeclaredMethods()){
                    if(m.isAnnotationPresent(Url.class)){
                        urlMapping.put(m.getAnnotation(Url.class).url(), new Mapping(c.getName(), m.getAnnotation(Url.class).url()));
                    }
                }    
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Class<?>> inPackage(String packageName) throws ClassNotFoundException, URISyntaxException ,IOException{
      List<Class<?>> classes = new ArrayList<>();
      ClassLoader classLoader=Thread.currentThread().getContexClassLoader();
      String path = packageName.replace('.','/') ;
      Enumeration<URL> resources = classLoader.getResources(path);
      while(resources.hasMoreElements()){
        URL resource = resources.nextElement();
        if(resource.getProtocol().equals("files")){
            classes.addAll(indir(new File(resource.toURI()), packageName));
        }

      }
      return classes;
    }

    public List<Class<?>> inDir(File directory, String packageName) throws ClassNotFoundException{
        List<Class<?>> classes = new ArrayList<>();
        if(directory.exists()){
            for(File file : directory.listFile()){
                if(file.isDirectory()){
                    classes.addAll(inDir(file, packageName + "." + file.getName()));
                }
                else if(file.getName().endsWith(".class")){
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }
        return classe;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String url = request.getRequestURL();
        url = url.split("/")[url.split("/").length - 1];
        try{
            Object act = Class.forName(urlMapping.get(url).getClassName()).newInstance();
            out.println(act.getClass().getDeclaredMethod(urlMapping.get(url).getMethode()).invoke(act).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}