/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nathasha
 */

@WebServlet(
        name = "AddressBookServlet",
        urlPatterns = "/AddressBook",
        initParams = { @WebInitParam (name = "filename",value = "addressBook.txt")}
)

public class AddressBookServlet extends HttpServlet {
       
    String filename;
   
    
    //Servlet initialization
    public void init() throws ServletException {
        
        ServletConfig config = getServletConfig();
        
        //get the value of the init-parameter
        filename = config.getInitParameter("filename");
        ServletContext sc = config.getServletContext();
        String path = sc.getRealPath(filename);
        AddressBook.initAddressBook(path);
        
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
            
  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        addEntry(request, response);
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

  
    private void addEntry(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<contact> cntListSess = new ArrayList<>();
        HttpSession session = request.getSession();
        session.setAttribute("SessionList", cntListSess);
        
        String name = request.getParameter("addName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        
        if(name.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()){
            PrintWriter out = response.getWriter();
            out.println("<h3>Fields can't be empty</h3>");
            out.println("<button onclick=\"location.href='add.html'\">Back</button>");
        }else{
            contact cntSess= new contact(name,phoneNumber,email);
            cntListSess.add(cntSess);
            
            PrintWriter out = response.getWriter();
            out.println("Successfully added");
            out.println("<button onclick=\"location.href='search.html'\">Back to Home</button>");
        }
        
    }
    
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /*TODO*/
        //process request parameters and return details of searched name
        
        HttpSession session = request.getSession();
       
        String name = request.getParameter("name");
        String result = AddressBook.search(name);

        List<contact> SessionList = (List<contact>) session.getAttribute("SessionList");
        
        if(SessionList==null){
            
        }
        
        String sessionResult = search(SessionList,name);
        //String sessionResult = "noMatch";

        if(result=="noMatch" && sessionResult=="noMatch"){
            PrintWriter out = response.getWriter();
            out.println("<h2>Status Code : 204</h2><br><h3>NO_CONTENT</h3>  No matches found"); 
            //response.setStatus(204);      //if the status is set to 204 then page doesn't show any change. therefore it's commented
        }else if(result=="noMatch"){
            PrintWriter out = response.getWriter();
            out.println("Your search details here      "+sessionResult); 
        }else{
            PrintWriter out = response.getWriter();
            out.println("Your search details here      "+result);
        }

        
        
    }


    private String search(List<contact> SessionList, String name) {
        System.out.println();
    boolean SessNoMatch = true;
    String SessName=null;
    String SessPhoneNumber=null;
    String SessEmail=null;
        //SessNoMatch = true;
        
        for (contact cntList1 : SessionList) {
            if (cntList1.getName().equals(name)) {
                SessName = cntList1.getName();
                SessPhoneNumber = cntList1.getPhoneNo();
                SessEmail = cntList1.getEmail();
                SessNoMatch = false;
            }
        }
        
        if(SessNoMatch){
            return "noMatch";
        }else{
            SessNoMatch = true;
            return SessName+"\n"+SessPhoneNumber+"\n"+SessEmail;
        }
        
    }

}
