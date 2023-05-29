package org.dstu.dao;

import org.dstu.domain.Books;
import org.hibernate.query.Query;

import java.util.List;

public class BooksDao extends BaseDaoImpl<Books, Integer> {
    public BooksDao() {
        super(Books.class);
    }

    public List<Books> getAllByGroup(String groupName) {
        Query q = getSession().createQuery("FROM Books WHERE Books.grp = \"" + groupName + "\"");
        return q.list();
    }
}
