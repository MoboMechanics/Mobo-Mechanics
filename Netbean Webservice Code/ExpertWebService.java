/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jess.*;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Saddam
 */
@WebServlet(urlPatterns = {"/NewServlet"})
public class ExpertWebService extends HttpServlet {

        public static String path ="Rules.CLP"; 

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/String");
        List<Model> pts = new ArrayList<>();
        
        
        final StringWriter sw =new StringWriter();
        final ObjectMapper mapper = new ObjectMapper();
        
        mapper.writeValue(sw, pts);
        
        String result = sw.toString();  //use toString() to convert to JSON
        PrintWriter out = response.getWriter();
        
        String got = request.getParameter("symptom");
        
        String [] splitted;
        splitted = got.split("-and-");
        
        Arrays.sort(splitted);
        
        String newStr="";
        
        
        for(int i=0; i<splitted.length; i++)
        {
            newStr = newStr+splitted[i];
            if(i<splitted.length-1)
            {
                newStr= newStr+"-and-";
            }
        }
                    
            
        Rete a= new Rete();
        String temp="";
        
            try {
                        a.batch(path);
                        a.reset();
                        Writer w = new StringWriter();
       
                        Context ctx = null;
                        a.addOutputRouter("t", w);
                        Reader red=new StringReader(newStr);
        
                        a.addInputRouter("t", red, true);
                        a.run();
                        temp=w.toString();
                        
            } catch (JessException ex) {
                Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        out.print(temp);
        sw.close();  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
