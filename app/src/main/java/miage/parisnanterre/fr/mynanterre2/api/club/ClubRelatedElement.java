package miage.parisnanterre.fr.mynanterre2.api.club;

import miage.parisnanterre.fr.mynanterre2.api.db.BaseDbElement;

public class ClubRelatedElement extends BaseDbElement {
    protected Club club;

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
