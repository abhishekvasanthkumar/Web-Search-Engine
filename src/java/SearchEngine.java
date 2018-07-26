
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEngine extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        response.setContentType("text/html;charset=UTF-8");
        Document_Parser dp = new Document_Parser();
        Indexing ind = new Indexing();
        HashMap <Integer,String> links = new HashMap();
        double startTime = System.nanoTime();
        try
        {
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/c.txt"),1);
            links.put(1,"C:/Users/vaio1/Desktop/web_docs/c.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/c++.txt"),2);
            links.put(2,"C:/Users/vaio1/Desktop/web_docs/c++.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/Comparison.txt"),3);
            links.put(3,"C:/Users/vaio1/Desktop/web_docs/Comparison.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/JAVA.txt"),4);
            links.put(4,"C:/Users/vaio1/Desktop/web_docs/JAVA.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/Machine_Learning.txt"),5);
            links.put(5,"C:/Users/vaio1/Desktop/web_docs/Machine_Learning.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/MatLab.txt"),6);
            links.put(6,"C:/Users/vaio1/Desktop/web_docs/MatLab.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/Nodejs.txt"),7);
            links.put(7,"C:/Users/vaio1/Desktop/web_docs/Nodejs.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/Python.txt"),8);
            links.put(8,"C:/Users/vaio1/Desktop/web_docs/Python.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/R.txt"),9);
            links.put(9,"C:/Users/vaio1/Desktop/web_docs/R.txt");
            dp.parseFiles(new File("C:\\Users\\vaio1\\Desktop\\web_docs/Ruby.txt"),10);
            links.put(10,"C:/Users/vaio1/Desktop/web_docs/Ruby.txt");
        }
        catch(Exception e)
        {
         System.out.println(e.getMessage());
        }
        PriorityQueue pq = (ind.tfidf(dp.hm,query));
        Indexing.Tuple t=null;
        double stopTime=0.0;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<body style='background-image: url(image1.jpg)'>");
            out.println("</head>");
            out.println("<body>");
        if(pq.size()==0)
            response.getWriter().print("Sorry!!! No Document matching the query");
        else
        {
            List<Integer>result = new ArrayList();
            out.println("<h2 style = 'color: white; text-align: center;'>");
            //out.println("<h2>");
            response.getWriter().print("Query Results: ");
            out.println("</h2>");
            while(pq.size()>0)
            {
                t = (Indexing.Tuple)pq.poll();
                out.println("<h2 style = 'text-align: center;'><a style = 'color: #bac2ba;' href = \"file:///" +links.get(t.doc) + "\">" + links.get(t.doc) + "</a></h2>" );
                
            }
        
            
            stopTime = System.nanoTime();
            out.println("<h2 style = 'color: white; text-align: center;'>");
            response.getWriter().print("Searched Results in: "+ (stopTime-startTime)/(1000000000) + " sec");
            out.println("</h2>");
        }
            out.println("</body>");
            out.println("</html>");
        }

    
}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
