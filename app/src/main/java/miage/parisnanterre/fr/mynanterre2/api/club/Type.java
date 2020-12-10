package miage.parisnanterre.fr.mynanterre2.api.club;

public class Type extends ClubRelatedElement {
    private String name;

    public Type(int id, Club club) {
        super(id, club);
    }

    public String getName() {
        return name;
    }
}
