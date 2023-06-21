import model.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post")
public class PostServlet extends HttpServlet{
    private PostList postList = new PostList();

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException{
        req.setCharacterEncoding("UTF-8");
        String data = req.getParameter("data");
        String neko = req.getParameter("neko");
        postList.postInfo(data,neko);
        
        ServletContext sc = this.getServletContext();
        sc.setAttribute("postList", postList);
        
        RequestDispatcher dispatcher 
        = req.getRequestDispatcher("/update.html");
        
        dispatcher.forward(req,res);
    }
}