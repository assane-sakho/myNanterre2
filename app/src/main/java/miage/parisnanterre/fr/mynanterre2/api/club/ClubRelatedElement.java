package miage.parisnanterre.fr.mynanterre2.api.club;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public abstract class ClubRelatedElement extends BaseDbElement {
    protected final Club club;

    public ClubRelatedElement(int id, Club club)
    {
        this.id = id;
        this.club = club;
    }

    /* GETTER */

    protected Club getClub()
    {
        return club;
    }
}
