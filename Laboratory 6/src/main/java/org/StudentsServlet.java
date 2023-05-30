package org;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.db.DbWorker;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] transcript_num = req.getParameterValues("transcript_num");
        String[] grp = req.getParameterValues("grp");
        DbWorker.demoQuery(transcript_num[0]);
        System.out.println(DbWorker.demoQuery(transcript_num[0]));
        if (!grp[0].equals(2)) {
            DbWorker.dirtyReadDemo(transcript_num[0], grp[0]);

        } else {
            req.getRequestDispatcher("notfound.jsp").forward(req, resp);
        }
    }
}
