package Entity;



import java.util.Date;

/**
 * Created by GARCII on 3/12/2017.
 */
public class Offre {


    private int id ;
    private String nomOffre;    
    private float prix;
    private float reduction;
    private Date dateExp;
    private String image;
    private User user;

    public Offre(){}

     public Offre(int id,String nomOffre, float prix, float reduction) {
       
        this.id=id;
        this.nomOffre = nomOffre;
        this.prix = prix;
        this.reduction = reduction;
     }
    
    
    public Offre(int id,String nomOffre, String descriptionOffre, float prix, float reduction, Date dateExp) {
       
        this.id=id;
        this.nomOffre = nomOffre;
      
        this.prix = prix;
        this.reduction = reduction;
        this.dateExp = dateExp;
    }
    
    
    
    public Offre(String nom, float prix, float reduction, Date dateExp, String image) {
        this.nomOffre = nom;
       
        this.prix = prix;
        this.reduction = reduction;
        this.dateExp = dateExp;
        this.image = image;

    }

    public Offre(String nomOffre,float prix, int reduction) {
        this.nomOffre = nomOffre;
      
        this.prix = prix;
        this.reduction = reduction;
       
    }

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOffre() {
        return nomOffre;
    }

    public void setNomOffre(String nom) {
        this.nomOffre = nom;
    }

   

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

   

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
     //   return "Offre{" + "nom=" + nomOffre + ", prix=" + prix + ", reduction=" + reduction + ", dateExp=" + dateExp + ", image=" + image + ", user=" + user.getId() + '}';
        return "Offre{" + "nom=" + nomOffre  + ", image=" + image + ", reduction=" + reduction + ", prix=" + prix + '}';
    
    }





}
