package miage.parisnanterre.fr.mynanterre2.api.club;

public abstract class ClubRelatedElement {
    protected final int id;
    protected final Club club;

    public ClubRelatedElement(int id, Club club)
    {
        this.id = id;
        this.club = club;
    }

    /* GETTER */
    protected int getId()
    {
        return id;
    }

    protected Club getClub()
    {
        return club;
    }
}
