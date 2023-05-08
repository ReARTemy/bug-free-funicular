package domain;

public abstract class PrintedMatter implements PrintedType {
    private String name;
    private String pages;
    private String publisher;
    private String language;
    private String country;

    public PrintedMatter(String name, String pages, String publisher, String language, String country) {
        this.name = name;
        this.pages = pages;
        this.publisher = publisher;
        this.language = language;
        this.country = country;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(" name: ");
        builder.append(country);
        builder.append(" | pages: ");
        builder.append(pages);
        builder.append(" | publisher: ");
        builder.append(publisher);
        builder.append(" | language: ");
        builder.append(language);
        builder.append(" | country: ");
        builder.append(country);
        return builder.toString();
    }

}
