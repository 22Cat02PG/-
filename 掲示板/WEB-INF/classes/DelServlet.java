import model.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.util.ArrayList;
import java.util.List;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException{

        ServletContext sc = this.getServletContext();
        PostList postList = (PostList)sc.getAttribute("postList");
        List<Post> posts = postList.getPostList();

        req.setCharacterEncoding("UTF-8");

        int index = Integer.parseInt(req.getParameter("index"));
        posts.remove(index - 1);

        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.print(
"<!DOCTYPE html>"
+ "<html lang=\"en\">"
+ "<head>"
+ "<link rel=\"stylesheet\" href=\"css/cc.css\">"
+ "<meta charset=\"UTF-8\">"
+ "<title>Document</title>"
+ "</head>"
+ "<body>"
+ "<header>"
+ "<div class=\"disc\">"
+ "<ol>"
+ "<li>" + "<div id=\"size\" style=\"text-align: left;\">" + "<font color=\"black\">NNN掲示板</font>" + "&nbsp;&nbsp;　　　　　　　　　　　　　　　　　　　" + "</div>" + "</li>"
+ "<li>" + "<div id=\"size2\" style=\"text-align: right;\"><a href=\"post.html\"><span style=\"color: black;\">投稿</span></a></div>" + "</li>" + "&nbsp; &nbsp; &nbsp;"
+ "<li>" + "<div id=\"size2\" style=\"text-align: right;\"><a href=\"BBSServlet\"><span style=\"color: black;\">掲示板の表示</span></a></div>" + "</li>" + "&nbsp; &nbsp; &nbsp;"
+ "<li>" + "<div id=\"size2\" style=\"text-align: right;\"><a href=\"delete.html\"><span style=\"color: black;\">コメントの削除</span></a></div>" + "</li>"
+ "</ol>"
+ "</div>"
+ "<hr color=\"red\">"
+ "<div style=\"text-align: center;\">"
+ "<h1>削除しました。</h1>"
+ "</div>"
);
        for(int i = 0; i < posts.size(); i++){
            Post post = posts.get(i);
            out.print(i + 1 + " : " + post.getData() + "<br>" + post.getNeko() + "<br><p>"+"</p>");
        }
        out.print(
"<div style=\"text-align: center;\">"
+ "<a href=\"http://localhost:8080/掲示板/index.html\">topに戻る</a>"
+ "</div>"
+ "</body>"
+ "</html>"
        );
    }
}