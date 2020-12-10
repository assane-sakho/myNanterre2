package miage.parisnanterre.fr.mynanterre2.api.club;

import java.sql.Blob;
import java.time.LocalDateTime;

import miage.parisnanterre.fr.mynanterre2.api.User.User;

public class Club {
    private int id;
    private String name;
    private Blob image;
    private LocalDateTime creationDate;
    private String description;
    private boolean isCertificate;
    private boolean isValidate;
    private User Creator;
    private Type type;
}
