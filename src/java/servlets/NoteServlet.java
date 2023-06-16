package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Fortune Agbone
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // to read files
        // get the path to the text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt"); 
        // load the buffered reader in order to read from the text file
        // that was called in the path variable
        // File - Opens the file
        // FileReader - Allows us to read from the file
        // BufferedReader - Allows data to be taken from the file being read
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // read the first and second line from the text file to variables
        String title = br.readLine();
        String contents = br.readLine();
        // close the open file handle
        br.close();
        
        // setting the attributes in the request object
        // to be loaded in the JSP
        request.setAttribute("title", title);
        request.setAttribute("contents", contents);

        // check the edit parameter
        String edit = request.getParameter("edit");
        // if the edit parameter does not exist, user wants to view note
        // if the edit parameter does exist, user wants to edit note
        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // retrieve the incoming parameters from the form
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        // to write to a file 
        // set the path to the text file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // open the print writer with the appropriate path
        // Filewriter - opens the file for writing
        // BufferedWriter - prepares the file to recieve data
        // PrintWriter - specifies what content should be written to the file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        // starting from the top of the text file,
        // write the first line as the title,
        // and write the second line as the contents
        pw.println(title);
        pw.println(contents);
        // close the open file handle
        pw.close();
        
        //redirect the user back to the view page
        response.sendRedirect("note");
        return;

    }
}
