package ae.kbgroup.sapphire.model;

/**
 * Created by karthikeyan.mani on 3/24/2017.
 */
public class Customer {

    private String nameEn;
    private String nameAr;
    private Long id;

    public Customer(String nameEn, String nameAr, Long id) {
        this.nameEn = nameEn;
        this.nameAr = nameAr;
        this.id = id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
