public class Country implements  Comparable<Country>{

    private String name  ;
    private String isocode;


    public Country() {
    }

    public Country(String name, String isocode) {
        this.name = name;
        this.isocode = isocode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsocode() {
        return isocode;
    }

    public void setIsocode(String isocode) {
        this.isocode = isocode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Country o) {
        return 0;
    }
}
