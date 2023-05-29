import org.dstu.dao.ShelfDao;
import org.dstu.dao.BooksDao;
import org.dstu.dao.MagazinesDao;
import org.dstu.domain.Shelf;
import org.dstu.domain.Books;
import org.dstu.domain.Magazines;
import org.dstu.util.HibernateUtil;
import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static void main(final String[] args) throws Exception {
        final Session session = HibernateUtil.getSession();
        BooksDao booksDao = new BooksDao();

        Books books = new Books();
        books.setName("Война и мир");
        books.setPages(50);
        books.setPublisher("Аст");
        books.setLanguage("Русский");
        books.setCountry("Россия");
        books.setAuthor("Толстой");
        books.setGenre("Роман");
        books.setPublished(1867);
        booksDao.save(books);

        ShelfDao shelfDao = new ShelfDao();

        Shelf ist = new Shelf();
        ist.setName("ИСТ");
        int savedId = shelfDao.save(ist);
        System.out.println(savedId);

        MagazinesDao magazinesDao = new MagazinesDao();
        Magazines magazines = new Magazines();
        magazines.setName("Восход");
        magazines.setPages(60);
        magazines.setPublisher("Аст");
        magazines.setLanguage("Русский");
        magazines.setCountry("Россия");
        magazines.setType("Наука");
        magazines.setEditor("Скворцов");
        magazines.setFirst_issue(2023);


        magazinesDao.save(magazines);

        Magazines magazines2 = new Magazines();
        magazines2.setName("Закат");
        magazines2.setPages(120);
        magazines2.setPublisher("Рест");
        magazines2.setLanguage("Русский");
        magazines2.setCountry("Россия");
        magazines2.setType("Творчество");
        magazines2.setEditor("Скворцов");
        magazines2.setFirst_issue(2023);
        magazinesDao.save(magazines2);


        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}