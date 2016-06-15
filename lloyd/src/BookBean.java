import java.io.Serializable;

public class BookBean implements Serializable{
    private Integer numberOfPages;
    private String title;
    private String yearPublished;
    private boolean isHardBound;

    public BookBean(){

    }

    public BookBean(Integer numberOfPages, String title, String yearPublished, boolean isHardBound){
        this.numberOfPages = numberOfPages;
        this.title = title;
        this.yearPublished = yearPublished;
        this.isHardBound = isHardBound;
    }
}
