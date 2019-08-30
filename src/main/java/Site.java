public class Site {

    private String id;
    private String name;
    private Categorie myCategori;

    public Site(){

    }

    public Site(String id, String name, Categorie myCategoria) {
        this.id = id;
        this.name = name;
        this.myCategori = myCategoria;
    }

    public Site(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categorie getMyCategori() {
        return myCategori;
    }

    public void setMyCategoria(Categorie myCategoria) {
        this.myCategori = myCategoria;
    }
}
