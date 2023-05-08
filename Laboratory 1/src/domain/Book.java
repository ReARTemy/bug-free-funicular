package domain;

public class Book extends PrintedMatter {
    private String author;
    private String genre;
    private int published = 1;

    public Book(String[] line) {
        super(line[1], line[2], line[3], line[4], line[5]);
        author = line[6];
        genre = line[7];
        published = Integer.parseInt(line[8]);;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Книга. ");
        builder.append(super.toString());
        builder.append(" author: ");
        builder.append(author);
        builder.append(" | genre: ");
        builder.append(genre);
        builder.append(" | published: ");
        builder.append(published);
        return builder.toString();
    }
}
