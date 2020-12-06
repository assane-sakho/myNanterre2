SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `alias` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of building
-- ----------------------------
INSERT INTO `building` VALUES (1, 'Simone Veil', 'F');
INSERT INTO `building` VALUES (2, 'Maurice Allais', 'G');
INSERT INTO `building` VALUES (3, 'Charlotte Delbo', 'BSL');
INSERT INTO `building` VALUES (4, 'Salle Omnisport', 'H');
INSERT INTO `building` VALUES (5, 'EPHEMERE1', 'M');
INSERT INTO `building` VALUES (6, 'Gymnase', 'I');
INSERT INTO `building` VALUES (7, 'Paul Ricœur', 'L');
INSERT INTO `building` VALUES (8, 'Restaurant Universitaire', NULL);
INSERT INTO `building` VALUES (9, 'Bibiliothèque universitaire', 'BU');
INSERT INTO `building` VALUES (10, 'Maison de l\'étudiant.e', 'MDE');
INSERT INTO `building` VALUES (11, 'Centre sportif', NULL);
INSERT INTO `building` VALUES (12, 'ÉPHÉMÈRE 2', 'N');
INSERT INTO `building` VALUES (13, 'Alice Milliat', 'S');
INSERT INTO `building` VALUES (14, 'Ida Maier', 'V');
INSERT INTO `building` VALUES (15, 'TERRASSE CROUS', NULL);
INSERT INTO `building` VALUES (16, 'Max Weber', 'W');
INSERT INTO `building` VALUES (17, 'René Ginouvès', 'MAE');
INSERT INTO `building` VALUES (18, 'René Remond', 'A');
INSERT INTO `building` VALUES (19, 'Pierre Grapin', 'B');
INSERT INTO `building` VALUES (20, 'Bianca et René Zazzo', 'C');
INSERT INTO `building` VALUES (21, 'Henri Lefèbvre', 'D');
INSERT INTO `building` VALUES (22, 'Jean Rouch', 'DD');
INSERT INTO `building` VALUES (23, 'Clémence Ramnoux', 'E');

-- ----------------------------
-- Table structure for crous
-- ----------------------------
DROP TABLE IF EXISTS `crous`;
CREATE TABLE `crous`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of crous
-- ----------------------------
INSERT INTO `crous` VALUES (1, 'La Croissanterie', 'RDC Batiment G    ');
INSERT INTO `crous` VALUES (2, 'La Terrasse', '8 allée de l\'université');
INSERT INTO `crous` VALUES (3, 'La B.U', 'RDC de la BU');
INSERT INTO `crous` VALUES (4, 'La sandwicherie', 'RDC du Batiment F');
INSERT INTO `crous` VALUES (5, 'L Asiatique', 'RDC du Batiment F');
INSERT INTO `crous` VALUES (6, 'Les Food trucks', 'Allée devant le bâtiment DD');
INSERT INTO `crous` VALUES (7, 'L AnK', 'RDC  \r\nBatiment DD');
INSERT INTO `crous` VALUES (8, 'Le Tex-Mex', '1er étage du RU');
INSERT INTO `crous` VALUES (9, 'L Espace Gourmand', 'RDC du RU');
INSERT INTO `crous` VALUES (10, 'Le Millenium', 'RDC du RU');
INSERT INTO `crous` VALUES (11, 'Le Restaurant Universitaire', '1 allée de l\'université ');

-- ----------------------------
-- Table structure for crous_product
-- ----------------------------
DROP TABLE IF EXISTS `crous_product`;
CREATE TABLE `crous_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crous_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  INDEX `crous_id`(`crous_id`) USING BTREE,
  CONSTRAINT `crous_product_ibfk_2` FOREIGN KEY (`crous_id`) REFERENCES `crous` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `crous_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of crous_product
-- ----------------------------
INSERT INTO `crous_product` VALUES (1, 1, 17);
INSERT INTO `crous_product` VALUES (2, 1, 1);
INSERT INTO `crous_product` VALUES (3, 1, 2);
INSERT INTO `crous_product` VALUES (4, 1, 3);
INSERT INTO `crous_product` VALUES (5, 1, 4);
INSERT INTO `crous_product` VALUES (6, 1, 5);
INSERT INTO `crous_product` VALUES (7, 1, 6);
INSERT INTO `crous_product` VALUES (8, 1, 17);
INSERT INTO `crous_product` VALUES (9, 2, 2);
INSERT INTO `crous_product` VALUES (10, 2, 7);
INSERT INTO `crous_product` VALUES (11, 2, 8);
INSERT INTO `crous_product` VALUES (19, 3, 1);
INSERT INTO `crous_product` VALUES (20, 3, 4);
INSERT INTO `crous_product` VALUES (21, 3, 5);
INSERT INTO `crous_product` VALUES (22, 3, 9);
INSERT INTO `crous_product` VALUES (26, 4, 1);
INSERT INTO `crous_product` VALUES (27, 4, 2);
INSERT INTO `crous_product` VALUES (28, 4, 3);
INSERT INTO `crous_product` VALUES (29, 4, 4);
INSERT INTO `crous_product` VALUES (30, 4, 5);
INSERT INTO `crous_product` VALUES (31, 4, 6);
INSERT INTO `crous_product` VALUES (33, 5, 10);
INSERT INTO `crous_product` VALUES (34, 5, 11);
INSERT INTO `crous_product` VALUES (35, 5, 12);
INSERT INTO `crous_product` VALUES (36, 5, 13);
INSERT INTO `crous_product` VALUES (37, 5, 18);
INSERT INTO `crous_product` VALUES (47, 7, 1);
INSERT INTO `crous_product` VALUES (48, 7, 2);
INSERT INTO `crous_product` VALUES (49, 7, 4);
INSERT INTO `crous_product` VALUES (50, 7, 5);
INSERT INTO `crous_product` VALUES (51, 7, 16);
INSERT INTO `crous_product` VALUES (54, 6, 12);
INSERT INTO `crous_product` VALUES (55, 6, 14);
INSERT INTO `crous_product` VALUES (56, 6, 15);
INSERT INTO `crous_product` VALUES (57, 8, 19);
INSERT INTO `crous_product` VALUES (58, 8, 20);
INSERT INTO `crous_product` VALUES (60, 9, 21);
INSERT INTO `crous_product` VALUES (61, 10, 22);
INSERT INTO `crous_product` VALUES (62, 10, 23);
INSERT INTO `crous_product` VALUES (63, 10, 24);
INSERT INTO `crous_product` VALUES (64, 10, 25);
INSERT INTO `crous_product` VALUES (65, 10, 26);
INSERT INTO `crous_product` VALUES (68, 11, 8);
INSERT INTO `crous_product` VALUES (69, 11, 27);
INSERT INTO `crous_product` VALUES (70, 11, 28);
INSERT INTO `crous_product` VALUES (71, 11, 29);
INSERT INTO `crous_product` VALUES (72, 11, 30);
INSERT INTO `crous_product` VALUES (73, 11, 31);

-- ----------------------------
-- Table structure for crous_product_availability
-- ----------------------------
DROP TABLE IF EXISTS `crous_product_availability`;
CREATE TABLE `crous_product_availability`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isAvailable` bit(1) NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `crous_product_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `crous_product_availability_ibfk_1`(`crous_product_id`) USING BTREE,
  CONSTRAINT `crous_product_availability_ibfk_1` FOREIGN KEY (`crous_product_id`) REFERENCES `crous_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of crous_product_availability
-- ----------------------------

-- ----------------------------
-- Table structure for crous_schedule
-- ----------------------------
DROP TABLE IF EXISTS `crous_schedule`;
CREATE TABLE `crous_schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_time` time(6) NULL DEFAULT NULL,
  `closing_time` time(6) NULL DEFAULT NULL,
  `crous_id` int(11) NULL DEFAULT NULL,
  `days` varchar(17) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `crous_id`(`crous_id`) USING BTREE,
  CONSTRAINT `crous_schedule_ibfk_1` FOREIGN KEY (`crous_id`) REFERENCES `crous` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of crous_schedule
-- ----------------------------
INSERT INTO `crous_schedule` VALUES (1, '00:08:30.000000', '00:15:00.000000', 1, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (2, '00:11:00.000000', '00:14:30.000000', 2, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (3, '00:08:30.000000', '00:18:30.000000', 3, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (4, '00:10:00.000000', '00:16:00.000000', 3, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (5, '00:08:30.000000', '00:18:00.000000', 4, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (6, '00:08:00.000000', '00:15:00.000000', 5, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (7, '00:11:30.000000', '00:14:00.000000', 6, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (8, '00:08:00.000000', '00:17:00.000000', 7, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (9, '00:11:30.000000', '00:14:30.000000', 8, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (10, '00:11:45.000000', '00:14:00.000000', 9, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (11, '00:08:00.000000', '00:21:00.000000', 10, 'MO-TU-WE-TH-FR');
INSERT INTO `crous_schedule` VALUES (12, '00:11:30.000000', '00:14:00.000000', 11, 'MO-TU-WE-TH-FR');

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL,
  `building_id` int(11) NULL DEFAULT NULL,
  `reception_phone_number` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `building_id`(`building_id`) USING BTREE,
  CONSTRAINT `library_ibfk_1` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES (0, 'LA BIBLIOTHÈQUE UNIVERSITAIRE', 'Campus Nanterre, Bâtiment BU - La Contemporaine (2 allée de la bibliothèque 92000 Nanterre)', 'La bibliothèque universitaire est composée de 5 salles thématiques où vous pouvez travailler et accéder librement à des ouvrages, des films et aux dernières années des revues auxquelles la BU est abonnée.\r\n\r\nCertains ouvrages et revues sont conservés dans les magasins situés dans la Tour du bâtiment. Ces documents doivent être demandés via le catalogue en ligne.\r\n\r\nAttention ! En 2019/2020, l’aile sud de la BU (BUlle, salle des Sciences sociales) est fermée, en raison des travaux de réalisation d\'un centre de ressources et des cultures numériques qui remplacera la BUlle. Les collections de la salle des Sciences sociales restent cependant accessibles en salle des Sciences économiques ou sur demande via le catalogue scd.parisnanterre.fr', 9, '0140977202', NULL);
INSERT INTO `library` VALUES (1, 'BIBLIOTHÈQUE DE L\'UFR DSP', 'Entresol, salle E16', 'La BUFR de DSP rouvre ses portes ce mardi 13 octobre, dès 9 heures.\r\n\r\nDans le cadre de la mobilisation contre l\'épidémie de Covid-19, le nombre de places disponibles est réduit (45 contre 100). Merci de bien respecter les distances de sécurité en ne déplaçant pas les chaises et en suivant les marquages au sol.\r\n\r\nNos horaires sont également modifiés : 9h-17h du lundi au jeudi. Nous restons disponibles à distance pour toutes interrogations le vendredi.\r\n\r\nL\'accès à la salle des photocopieurs sera également limité à une personne à la fois.\r\n\r\nNous rappelons que le port du masque est obligatoire et ce pour toute la durée de votre passage dans la bibliothèque, comme c\'est le cas dans le reste du bâtiment.\r\n\r\nPour toute question ou renseignement, l\'équipe de la BUFR reste à votre disposition au 01.40.97.77.11, ou en écrivant à apare@parisnanterre.fr\r\n', 1, '0140977711', NULL);
INSERT INTO `library` VALUES (2, 'LA BIBLIOTHÈQUE D’HISTOIRE ET D’HISTOIRE DE L’ART (UFR SSA)', 'Rez-de-chaussée', NULL, 23, NULL, NULL);
INSERT INTO `library` VALUES (3, 'LA BIBLIOTHÈQUE DE LANGUES ET CULTURES ETRANGÈRES (UFR LCE)\r\n', '1er étage, salle 108', 'La biblothèque de l\'UFR LCE est fermée pendant toute la durée du confinement.\r\n\r\nLa durée de l\'ensemble des prêts de documents est automatiquement prolongée jusqu\'à la réouverture de la bibliothèque. Aucune pénalité n\'est encourue.\r\n\r\nLa bibliothèque universitaire vous accueille sur rendez-vous pour emprunter et retourner les ouvrages, travailler sur place aux horaires suivants : 10h-13h ; 14h-17h', 14, '0140974943', NULL);
INSERT INTO `library` VALUES (4, 'LA BIBLIOTHÈQUE DE PHILOSOPHIE (UFR PHILLIA)', 'Salle 319', '\r\nEn raison du contexte sanitaire, à partir du 10/11 la BUFR de Philosophie sera ouverte mardi et jeudi de 9h45 à 16h45.\r\n\r\nDes créneaux de réservation sont disponibles pour consultation sur place : 9h45-12h, 12h05-14h20, 14h25-16h45. On pourra réserver un seule créneau ou plusieurs, même toute la journée. \r\nLa réservation se fera par mail à l\'adresse lpicardi@parisnanterre.fr.\r\n\r\nPour le prêt et retour des livres il y aura un créneau d\'une demi-heure à réserver. \r\n\r\nSeuls les usagers avec réservation pourront avoir accès au bâtiment. Les étudiant.e.s pour se déplacer auront besoin de leur attestation dérogatoire, un document et le mail de confirmation de réservation à montrer à l\'accueil du bâtiment.\r\n\r\nLes places disponibles (vous pourrez indiquer votre choix de préférence au moment de la réservation par mail) : \r\n6 places en salle de travail (une pour chaque table), 4 en salle de lecture (une pour chaque table), 2 sur la table ovale, 1 la petite table à côte de la fenêtre, 1 la table derrière à côté des revues non classées, + 2 places ordinateurs (seulement pour l\'utilisation des ordinateurs).\r\n\r\nTout les prêts avec échéance à partir de novembre ont été prolongés jusqu\'au 7 décembre.', 7, '0140977069', NULL);
INSERT INTO `library` VALUES (5, 'LA BIBLIOTHÈQUE DU PÔLE UNIVERSITAIRE LÉONARD DE VINCI', 'Pôle Universitaire Léonard de Vinci\r\n     12 avenue Léonard de Vinci\r\n     92400 Courbevoie\r\n     Bâtiment de l\'infothèque\r\n     1er étage, Salle i 111', 'La bibliothèque du PULV est réservée aux étudiants de l\'IPAG (Institut de Préparation à l\'Administration Générale) et aux étudiants des UFR DSP, SEGMI et PHILLIA de l\'Université Paris Nanterre ayant cours au Pôle Universitaire Léonard de Vinci.\r\n\r\nSituée au 1er étage du bâtiment de l\'infothèque, la bibliothèque offre des espaces et un environnement calme. Elle met à disposition des étudiants et enseignants des places de travail individuel et une salle de travail en groupe.\r\n\r\nDes bibliothécaires sont au service des étudiants pour les accompagner dans leurs recherches documentaires et les former aux bases de données.\r\n\r\n(L\'entrée dans le bâtiment requiert un badge du PULV).', NULL, '0141167362', NULL);
INSERT INTO `library` VALUES (6, 'LA BIBLIOTHÈQUE DE SOCIOLOGIE ET D’ADMINISTRATION ÉCONOMIQUE ET SOCIALE\r\nLA BIBLIOTHÈQUE DE SOCIOLOGIE ET D’ADMINISTRATION ÉCONOMIQUE ET SOCIALE', 'Salle 104', NULL, 22, '0140977401', NULL);
INSERT INTO `library` VALUES (7, 'CENTRE DE DOCUMENTATION DES SCIENCES ET TECHNIQUES DES ACTIVITÉS SPORTIVES (UFR STAPS)', 'Rez-de-chaussée', NULL, 13, NULL, NULL);
INSERT INTO `library` VALUES (8, 'LA BIBLIOTHÈQUE D\'ARTS DU SPECTACLE (UFR PHILLIA)', 'Salle 207', NULL, 7, '0140977340', NULL);
INSERT INTO `library` VALUES (9, 'LA BIBLIOTHÈQUE DE GÉOGRAPHIE/CARTOTHÈQUE (UFR SSA)', 'Salle 410', 'Jusqu\'au 1er décembre, La bibliothèque-cartothèque de géographie est ouverte le jeudi sur rendez-vous de 9h30 à 12h30 et de 13h30 à 16h30\r\nEn raison de la fermeture des bâtiments à 17h la dernière entrée s\'éffectue à 16h30.\r\n\r\nLe nombre de lecteurs en accès simultané en bibliothèque D 410 est limité à 10 personnes.\r\nLa salle de lecture D 411 est en revanche fermée.\r\nIl est possible de :\r\n- rendre et emprunter des livres, consulter livres, cartes, périodiques, mémoires\r\n- travailler individuellement sur place\r\n- faire des photocopies, scans et impressions.\r\nVous devez au préalable m\'envoyer un mail (Anne-Laure Cermak acermak@parisnanterre.fr ) en précisant l\'objet de votre venue ( prêt/retour, recherche, impressions..), la durée sur place envisagée et m\'indiquer notamment si vous avez repérés des titres suite à une recherche dans le catalogue et indiquer les références.\r\nPour les cartes : préciser le titre et si possible le n°IGN.\r\nUn mail vous sera ensuite adressé pour vous confirmer l\'heure de votre rdv.\r\n\r\nEn raison de la situation sanitaire, les livres actuellement en prêt de la bibliothèque de géographie, sont prolongés jusqu\'au 7 décembre. Aucune pénalité n\'est encourue.\r\nPour vos tenir informés , consultez régulièrement cette page web et la page facebook des bibliothèques de géographie et d\'urbanisme.', 21, NULL, NULL);
INSERT INTO `library` VALUES (10, 'LA BIBLIOTHÈQUE DE LETTRES ET DES SCIENCES DU LANGAGE (UFR PHILLIA)', 'Salle 322', 'A partir de cette semaine, la BUFR est accessible deux jours dans la semaine, le mercredi et vendredi :\r\n- aux membres de l\'UFR PHILLIA uniquement\r\n- sur rendez-vous par mail : swegiera@parisnanterre.fr\r\n- Créneaux de 9h00 à 12h00 et/ou de 13h00 à 16h45\r\nPrendre RDV est nécessaire pour accéder à la BUFR, quels que soient les motifs de votre venue (emprunter / retourner des documents, travailler sur place, imprimer / photocopier).\r\nPour venir il vous faut :\r\n- une attestation de déplacement,\r\n- une pièce d\'identité,\r\n- une carte étudiante ou professionnelle UPN,\r\n- votre confirmation de prise de rendez-vous (mail).\r\n\r\nLa durée de prêt des ouvrages empruntés avant le confinement est automatiquement prolongée jusqu\'au 7 décembre. \r\nIl n\'est donc pas nécessaire de vous déplacer uniquement pour retourner des documents.', NULL, '0140977579', 'artsduspectaclebibliotheque@yahoo.com');
INSERT INTO `library` VALUES (11, 'LA BIBLIOTHÈQUE DE SCIENCES ECONOMIQUES, GESTION, MATHÉMATIQUES ET INFORMATIQUE (UFR SEGMI)', 'Salle 113', 'Re-Confinement de novembre - Fermeture de la bibliothèque SEGMI\r\n\r\nSuite aux annonces présidentielles et aux nouvelles consignes sanitaires, la bibliothèque SEGMI ferme ses portes au public jusqu\'à nouvel ordre.\r\nLes ouvrages empruntés avant le confinement peuvent être rendus à la grande BU pendant toute la durée de la fermeture, cependant la durée de prêt de tous les documents a été automatiquement prolongée jusqu’au 7 décembre et le sera au-delà si nécessaire. Il n\'est donc pas nécessaire de vous déplacer pour retourner des documents.\r\n\r\nA titre d\'information, à partir du 9 novembre, la grande BU est accessible aux membres de la communauté universitaire sur rendez-vous, une journée maximum par personne par semaine. Prendre rendez-vous est nécessaire pour accéder à une place de travail individuelle mais aussi pour utiliser les autres services de la BU (prêt / retour de documents, impressions / photocopies).', 2, NULL, NULL);
INSERT INTO `library` VALUES (12, 'LA BIBLIOTHÈQUE DE PSYCHOLOGIE ET SCIENCES DE L’ÉDUCATION (UFR SPSE)', 'Salle R01', 'LA BIBLIOTHÈQUE DE PSYCHOLOGIE ET SCIENCES DE L’ÉDUCATION (UFR SPSE)\r\nConfinement de novembre - Fermeture de la Bibliothèque de l\'UFR SPSE\r\nLa bibliothèque de l\'UFR ferme ses portes au public à partir de ce lundi 2 novembre 2020.\r\n\r\nJe demeure néanmoins joignable via ma messagerie professionnelle ljouvin@parisnanterre.fr et serai théoriquement présente sur site chaque lundi et jeudi.  Ces jours-là, vous pourrez donc m\'obtenir au 01.40.97.74.24.\r\n\r\nPour ce qui est du retour des documents que vous aviez empruntés avant ce confinement, nous avons porté la date de retour au 7 décembre.\r\n\r\nIl est également envisageable de nous adresser les ouvrages par voie postale (Université de Nanterre / Bibliothèque de l\'UFR de SPSE / L. Jouvin / Bât Zazzo RDC / 200 avenue de la République / 92001 NANTERRE)\r\n\r\nLa grande B.U. réouvrant à partir du 9 novembre mais avec des horaires restreints et un nombre limité de places de travail (attention prise de rendez-vous préalable, voir les modalités), en vous y rendant, vous pourrez également déposer chez eux nos ouvrages. Nous nous chargerons de les récupérer ensuite.\r\n\r\nMerci à vous et bonne continuation dans le distanciel.', 20, '0140977044', NULL);
INSERT INTO `library` VALUES (13, 'LA BIBLIOTHÈQUE D\'AMÉNAGEMENT ET URBANISME (UFR SSA)', 'Salle 412', 'Rattachée au département de géographie de l\'UFR SSA, au laboratoire Mosaïques depuis 2006 et à la formation en aménagement, la bibliothèque d\'aménagement et d\'urbanisme accueille en priorité les étudiants à partir du L2, les Master 1 et 2, ainsi que les doctorants et chercheurs de l\'Université Université Paris Nanterre.\r\n\r\nElle autorise aussi l\'accès à toute personne extérieure intéressée par le fonds documentaire (étudiants d\'autres universités, professionnels de l\'aménagement et de la ville, membres d\'associations...) en consultation sur place. (Prêt aux personnes inscrites au préalable à la BU comme Lecteur extérieur.)', 21, NULL, NULL);

-- ----------------------------
-- Table structure for library_consultation_loan_condition
-- ----------------------------
DROP TABLE IF EXISTS `library_consultation_loan_condition`;
CREATE TABLE `library_consultation_loan_condition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_consultation_loan_condition_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_consultation_loan_condition
-- ----------------------------

-- ----------------------------
-- Table structure for library_documentary_fund
-- ----------------------------
DROP TABLE IF EXISTS `library_documentary_fund`;
CREATE TABLE `library_documentary_fund`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_documentary_fund_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_documentary_fund
-- ----------------------------

-- ----------------------------
-- Table structure for library_domain
-- ----------------------------
DROP TABLE IF EXISTS `library_domain`;
CREATE TABLE `library_domain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_domain_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_domain
-- ----------------------------
INSERT INTO `library_domain` VALUES (2, 'Salle de Droit et Science politique : administration publique, droit public, droit privé, science politique', 0);
INSERT INTO `library_domain` VALUES (3, 'Salle des Sciences économiques : économie, mathématiques, informatique, généralités (préparation concours, orientation professionnelle) ; anthropologie, ethnologie, psychologie, éducation, sciences et médecine, sociologie, STAPS ; films et ouvrages de cin', 0);
INSERT INTO `library_domain` VALUES (4, 'Salle des Sciences Humaines : archéologie, arts du spectacle, géographie, histoire, histoire de l\'art, philosophie, religion', 0);
INSERT INTO `library_domain` VALUES (5, 'Salle des Langues et Littératures : langues, lettres classiques, littérature française, littérature générale, linguistique', 0);
INSERT INTO `library_domain` VALUES (6, 'Droit et Science politique', 1);
INSERT INTO `library_domain` VALUES (7, 'Histoire : Religion, Science Politique, Littérature (sources), Manuels du secondaire en Histoire et Géographie', 2);
INSERT INTO `library_domain` VALUES (8, 'Histoire de l\'art : Archéologie, Musicologie, Philosophie/Esthétique', 2);
INSERT INTO `library_domain` VALUES (9, 'littérature étrangère', 3);
INSERT INTO `library_domain` VALUES (10, 'linguistique / apprentissage des langues', 3);
INSERT INTO `library_domain` VALUES (11, 'civilisation (histoire, économie, arts, médias, société)', 3);
INSERT INTO `library_domain` VALUES (12, 'Philosophie', 4);
INSERT INTO `library_domain` VALUES (13, 'Esthétique', 4);
INSERT INTO `library_domain` VALUES (14, 'Epistémologie', 4);
INSERT INTO `library_domain` VALUES (15, 'Physique', 4);
INSERT INTO `library_domain` VALUES (16, 'Biologie', 4);
INSERT INTO `library_domain` VALUES (17, 'Mathématiques', 4);
INSERT INTO `library_domain` VALUES (18, 'Logique', 4);
INSERT INTO `library_domain` VALUES (19, 'Sciences Sociales', 4);
INSERT INTO `library_domain` VALUES (20, 'Droit', 4);
INSERT INTO `library_domain` VALUES (21, 'Linguistique', 4);
INSERT INTO `library_domain` VALUES (22, 'Psychanalyse', 4);
INSERT INTO `library_domain` VALUES (23, 'Psychologie', 4);
INSERT INTO `library_domain` VALUES (24, 'Sciences cognitives', 4);
INSERT INTO `library_domain` VALUES (25, 'Religion', 4);
INSERT INTO `library_domain` VALUES (26, 'Marxisme', 4);
INSERT INTO `library_domain` VALUES (27, 'Philosophie Orientale (Inde, Chine, Japon, monde Arabe)', 4);
INSERT INTO `library_domain` VALUES (28, 'Droit & Science politique', 5);
INSERT INTO `library_domain` VALUES (29, 'Economie & Gestion', 5);
INSERT INTO `library_domain` VALUES (30, 'Santé publique, Système éducatif, Sociologie', 5);
INSERT INTO `library_domain` VALUES (31, 'Philosophie, Langues, Culture générale', 5);
INSERT INTO `library_domain` VALUES (32, 'Concours administratifs de la fonction publique', 5);
INSERT INTO `library_domain` VALUES (33, 'AES : Droit', 6);
INSERT INTO `library_domain` VALUES (34, 'AES : Comptabilité Gestion', 6);
INSERT INTO `library_domain` VALUES (35, 'AES : Théories des organisations', 6);
INSERT INTO `library_domain` VALUES (36, 'AES : Stratégies des entreprises', 6);
INSERT INTO `library_domain` VALUES (37, 'AES : Analyses financières', 6);
INSERT INTO `library_domain` VALUES (38, 'AES : Finance de marché', 6);
INSERT INTO `library_domain` VALUES (39, 'AES : Economie', 6);
INSERT INTO `library_domain` VALUES (40, 'AES : Marketing', 6);
INSERT INTO `library_domain` VALUES (41, 'AES : Etudes des marchés', 6);
INSERT INTO `library_domain` VALUES (42, 'AES : Management', 6);
INSERT INTO `library_domain` VALUES (43, 'AES : Statistiques', 6);
INSERT INTO `library_domain` VALUES (44, 'AES : Gestion des associations', 6);
INSERT INTO `library_domain` VALUES (45, 'AES : Sociologies', 6);
INSERT INTO `library_domain` VALUES (46, 'AES : Sciences de l’information et de la communication', 6);
INSERT INTO `library_domain` VALUES (47, 'AES : Méthodologie-Enquête-Entretien', 6);
INSERT INTO `library_domain` VALUES (48, 'AES : Psychologie', 6);
INSERT INTO `library_domain` VALUES (49, 'AES : Ressources Humaines', 6);
INSERT INTO `library_domain` VALUES (50, 'AES : Formation', 6);
INSERT INTO `library_domain` VALUES (51, 'AES : Histoire contemporaine', 6);
INSERT INTO `library_domain` VALUES (52, 'AES : Guides et Méthodologies anglaises', 6);
INSERT INTO `library_domain` VALUES (53, 'Sociologie : Démographie', 7);
INSERT INTO `library_domain` VALUES (54, 'Sociologie : Statistiques', 7);
INSERT INTO `library_domain` VALUES (55, 'Sociologie : Problèmes sociaux', 7);
INSERT INTO `library_domain` VALUES (56, 'Sociologie : Psychanalyse', 7);
INSERT INTO `library_domain` VALUES (57, 'Sociologie : Sociologie de la culture', 7);
INSERT INTO `library_domain` VALUES (58, 'Sociologie : Sociologie de la famille', 7);
INSERT INTO `library_domain` VALUES (59, 'Sociologie : Sociologie de la sexualité', 7);
INSERT INTO `library_domain` VALUES (60, 'Sociologie : Sociologie pénale', 7);
INSERT INTO `library_domain` VALUES (61, 'Sociologie : Sociologie politique', 7);
INSERT INTO `library_domain` VALUES (62, 'Sociologie : Sociologie du travail', 7);
INSERT INTO `library_domain` VALUES (63, 'Sociologie : Sociologie urbaine', 7);
INSERT INTO `library_domain` VALUES (64, 'Sociologie : Sociolinguistique', 7);
INSERT INTO `library_domain` VALUES (65, 'Sociologie : Interactions sociales', 7);
INSERT INTO `library_domain` VALUES (66, 'Sociologie : Ethnologie/ anthropologie ', 7);
INSERT INTO `library_domain` VALUES (67, 'Sociologie : Philosophie politique', 7);
INSERT INTO `library_domain` VALUES (68, 'Sociologie : Histoire contemporaine', 7);
INSERT INTO `library_domain` VALUES (69, 'Sociologie : Histoire de la sociologie', 7);
INSERT INTO `library_domain` VALUES (70, 'Sociologie : Corpus d\'auteurs', 7);
INSERT INTO `library_domain` VALUES (71, 'Sociologie : Méthodologie', 7);
INSERT INTO `library_domain` VALUES (72, 'Sciences et Techniques des Activités Sportives', 8);
INSERT INTO `library_domain` VALUES (73, 'Physiologie', 8);
INSERT INTO `library_domain` VALUES (74, 'Neurologie', 8);
INSERT INTO `library_domain` VALUES (75, 'Psychologie', 8);
INSERT INTO `library_domain` VALUES (76, 'Education et Histoire en lien avec le domaine du sport', 8);
INSERT INTO `library_domain` VALUES (77, 'Cinéma', 9);
INSERT INTO `library_domain` VALUES (78, 'Théâtre', 9);
INSERT INTO `library_domain` VALUES (79, 'Musique', 9);
INSERT INTO `library_domain` VALUES (80, 'Littérature française moderne', 10);
INSERT INTO `library_domain` VALUES (81, 'Littératures grecque et latine classiques', 10);
INSERT INTO `library_domain` VALUES (82, 'Sciences du langage', 10);
INSERT INTO `library_domain` VALUES (83, 'Economie', 11);
INSERT INTO `library_domain` VALUES (84, 'Gestion', 11);
INSERT INTO `library_domain` VALUES (85, 'Mathématiques', 11);
INSERT INTO `library_domain` VALUES (86, 'Informatique', 11);
INSERT INTO `library_domain` VALUES (87, 'Enseignement SES', 11);
INSERT INTO `library_domain` VALUES (88, 'Aménagement', 13);
INSERT INTO `library_domain` VALUES (89, 'Urbanisme', 13);
INSERT INTO `library_domain` VALUES (90, 'Droit de l’Urbanisme', 13);
INSERT INTO `library_domain` VALUES (91, 'Services urbains', 13);
INSERT INTO `library_domain` VALUES (92, 'Réseaux urbains', 13);
INSERT INTO `library_domain` VALUES (93, 'Mobilités urbaines', 13);
INSERT INTO `library_domain` VALUES (94, 'Transports urbains', 13);
INSERT INTO `library_domain` VALUES (95, 'Géographie urbaine', 13);
INSERT INTO `library_domain` VALUES (96, 'Sociologie urbaine', 13);
INSERT INTO `library_domain` VALUES (97, 'Population', 13);
INSERT INTO `library_domain` VALUES (98, 'Logement', 13);
INSERT INTO `library_domain` VALUES (99, 'Economie urbaine', 13);

-- ----------------------------
-- Table structure for library_link
-- ----------------------------
DROP TABLE IF EXISTS `library_link`;
CREATE TABLE `library_link`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `link` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `link_type` int(11) NULL DEFAULT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  INDEX `link_type`(`link_type`) USING BTREE,
  CONSTRAINT `library_link_ibfk_2` FOREIGN KEY (`link_type`) REFERENCES `link_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `library_link_ibfk_3` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_link
-- ----------------------------
INSERT INTO `library_link` VALUES (1, 'BUFRPhiloNanterre', 1, 4);
INSERT INTO `library_link` VALUES (2, 'Biblioth%C3%A8que-PULV-Universit%C3%A9-Paris-Nanterre-1750855798282373/?__tn__=%2Cd%2CP-R&eid=ARCarhRJ708YjFmQz_lh-XSrLk7m8unY0RrAtttgBy14oZXyyBU72qdHxJvzff1Vzb12bYXnJRc52M9h', 1, 5);
INSERT INTO `library_link` VALUES (3, 'BUFR-AES-Sociologie-Universit%C3%A9-Paris-Nanterre-115785756478230/?modal=admin_todo_tour', 1, 6);
INSERT INTO `library_link` VALUES (4, 'Bibliotheques-Geo-Urba-Paris-Nanterre-692865304234253', 1, 9);
INSERT INTO `library_link` VALUES (5, 'BUFRLettres', 1, 10);
INSERT INTO `library_link` VALUES (6, 'BUNanterre', 1, 0);
INSERT INTO `library_link` VALUES (7, 'BNanterre', 2, 9);
INSERT INTO `library_link` VALUES (8, 'BUNanterre', 2, 0);
INSERT INTO `library_link` VALUES (9, 'https://ufr-segmi.parisnanterre.fr/formation-et-scolarite/bibliotheque-de-l-ufr/bibliotheque-de-l-ufr-271028.kjsp?RH=1390838354908', NULL, 11);
INSERT INTO `library_link` VALUES (10, 'http://www.master-urba-paris-ouest.fr/', NULL, 13);
INSERT INTO `library_link` VALUES (11, 'la-bibliotheque-universitaire-bu-', 4, 0);
INSERT INTO `library_link` VALUES (12, 'bufr-dsp', 4, 1);
INSERT INTO `library_link` VALUES (13, 'bufr-histoire-et-histoire-de-l-art', 4, 2);
INSERT INTO `library_link` VALUES (14, 'bufr-lce', 4, 3);
INSERT INTO `library_link` VALUES (15, 'bufr-philosophie', 4, 4);
INSERT INTO `library_link` VALUES (16, 'bibliotheque-du-pulv', 4, 5);
INSERT INTO `library_link` VALUES (17, 'bufr-sociologie-et-aes', 4, 6);
INSERT INTO `library_link` VALUES (18, 'bufr-staps', 4, 7);
INSERT INTO `library_link` VALUES (19, 'bufr-arts-du-spectacle', 4, 8);
INSERT INTO `library_link` VALUES (20, 'bufr-geographie-cartotheque', 4, 9);
INSERT INTO `library_link` VALUES (21, 'bufr-lettres-et-sciences-du-langage', 4, 10);
INSERT INTO `library_link` VALUES (22, 'bufr-segmi', 4, 11);
INSERT INTO `library_link` VALUES (23, 'bufr-spse', 4, 12);
INSERT INTO `library_link` VALUES (24, 'bufr-urbanisme', 4, 13);

-- ----------------------------
-- Table structure for library_responsable
-- ----------------------------
DROP TABLE IF EXISTS `library_responsable`;
CREATE TABLE `library_responsable`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `phone_number` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_responsable_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_responsable
-- ----------------------------
INSERT INTO `library_responsable` VALUES (1, 'Alexandre PARÉ', '0140977711', 'apare@parisnanterre.fr', 1);
INSERT INTO `library_responsable` VALUES (2, 'Thibaut DINASQUET', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (3, 'Amirhoushang MOSTARSHEDI', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (4, ' Aurore VERNHES', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (5, 'Catherine Lescure', '0140977634', 'catherine.lescure@parisnanterre.fr', 2);
INSERT INTO `library_responsable` VALUES (6, 'Hélène Durand', '0140977581', 'hedurand@parisnanterre.fr', 3);
INSERT INTO `library_responsable` VALUES (7, 'Luca Picardi', '0140977009', 'lpicardi@parisnanterre.fr', 4);
INSERT INTO `library_responsable` VALUES (8, ' Yannick Valmy', '0141167369', 'yvalmy@parisnanterre.fr', 5);
INSERT INTO `library_responsable` VALUES (9, ' Anne-Frédérique Pérol', '0140977510', 'aperol@parisnanterre.fr', 6);
INSERT INTO `library_responsable` VALUES (10, 'Sylia Ait Abdelmalek\r\nSylia Ait Abdelmalek\r\nSylia Ait Abdelmalek\r\nSylia Ait Abdelmalek', '0140977338', 'saitabde@parisnanterre.fr', 6);
INSERT INTO `library_responsable` VALUES (11, ' Isabelle CARTEREAU', '0140977119', 'isabelle.cartereau@parisnanterre.fr', 7);
INSERT INTO `library_responsable` VALUES (12, 'Marie-France NGUYEN', '0140974126', 'faugeron@parisnanterre.fr', 7);
INSERT INTO `library_responsable` VALUES (13, 'Marine Walzer', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (14, 'Martin Audeguis', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (15, 'Marius Bengugiui', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (16, 'Anne-Laure Barbeau-Cermak', '0140977560', 'acermak@parisnanterre.fr', 9);
INSERT INTO `library_responsable` VALUES (17, 'Sasha Wegiera', '0140977270', 'swegiera@parisnanterre.fr', 10);
INSERT INTO `library_responsable` VALUES (18, 'Sophie Da Silva', '0140977867', 'sophie.da_silva@parisnanterre.fr', 11);
INSERT INTO `library_responsable` VALUES (19, 'Laura Jouvin', '0140977044', 'laura.jouvin@parisnanterre.fr', 12);
INSERT INTO `library_responsable` VALUES (20, 'Franck Rakotonirina', '0140977582', 'frakoton@parisnanterre.fr', 13);
INSERT INTO `library_responsable` VALUES (21, 'LA BIBLIOTHÈQUE UNIVERSITAIRE\r\n', '0140977202', NULL, 0);

-- ----------------------------
-- Table structure for library_schedule
-- ----------------------------
DROP TABLE IF EXISTS `library_schedule`;
CREATE TABLE `library_schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_time` time(6) NOT NULL,
  `closing_time` time(6) NOT NULL,
  `days` varchar(17) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_schedule_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_schedule
-- ----------------------------
INSERT INTO `library_schedule` VALUES (1, '00:09:00.000000', '00:17:00.000000', 'MO-TU-WE-TH-FR', 1);
INSERT INTO `library_schedule` VALUES (2, '00:09:00.000000', '00:17:00.000000', 'MO-TU-WE-TH-FR', 2);
INSERT INTO `library_schedule` VALUES (3, '00:09:00.000000', '00:18:00.000000', 'MO-TU-WE-TH-FR', 3);
INSERT INTO `library_schedule` VALUES (4, '00:09:30.000000', '00:19:30.000000', 'MO-TU-WE-TH', 4);
INSERT INTO `library_schedule` VALUES (5, '00:09:30.000000', '00:17:30.000000', 'FR', 4);
INSERT INTO `library_schedule` VALUES (6, '00:09:00.000000', '00:18:00.000000', 'MO-TU-WE-TH-FR', 5);
INSERT INTO `library_schedule` VALUES (7, '00:09:15.000000', '00:18:00.000000', 'MO-TU-WE-TH', 6);
INSERT INTO `library_schedule` VALUES (8, '00:09:15.000000', '00:17:15.000000', 'FR', 6);
INSERT INTO `library_schedule` VALUES (9, '00:09:15.000000', '00:00:13.000000', 'MO-TU-TH', 7);
INSERT INTO `library_schedule` VALUES (10, '00:14:00.000000', '00:17:00.000000', 'MO-TU-TH', 7);
INSERT INTO `library_schedule` VALUES (11, '00:09:15.000000', '00:13:00.000000', 'FR', 7);
INSERT INTO `library_schedule` VALUES (12, '00:14:00.000000', '00:16:30.000000', 'FR', 7);
INSERT INTO `library_schedule` VALUES (13, '00:10:00.000000', '00:14:00.000000', 'MO-TU-WE', 8);
INSERT INTO `library_schedule` VALUES (14, '00:14:30.000000', '00:17:30.000000', 'MO-WE', 8);
INSERT INTO `library_schedule` VALUES (15, '00:14:30.000000', '00:18:30.000000', 'TU', 8);
INSERT INTO `library_schedule` VALUES (16, '00:09:15.000000', '00:18:00.000000', 'MO', 9);
INSERT INTO `library_schedule` VALUES (17, '00:09:15.000000', '00:17:00.000000', 'TU-WE-TH', 9);
INSERT INTO `library_schedule` VALUES (18, '00:09:00.000000', '00:13:00.000000', 'FR', 9);
INSERT INTO `library_schedule` VALUES (19, '00:09:00.000000', '00:19:00.000000', 'MO', 10);
INSERT INTO `library_schedule` VALUES (20, '00:09:00.000000', '00:18:00.000000', 'TU-WE-TH-FR', 10);
INSERT INTO `library_schedule` VALUES (21, '00:08:30.000000', '00:19:00.000000', 'MO-TU-WE-TH-FR', 11);
INSERT INTO `library_schedule` VALUES (22, '00:09:00.000000', '00:13:00.000000', 'MO-TU', 13);
INSERT INTO `library_schedule` VALUES (23, '00:14:00.000000', '00:17:00.000000', 'MO-TU', 13);
INSERT INTO `library_schedule` VALUES (24, '00:09:00.000000', '00:13:00.000000', 'WE', 13);
INSERT INTO `library_schedule` VALUES (25, '00:14:00.000000', '00:17:00.000000', 'WE', 13);
INSERT INTO `library_schedule` VALUES (26, '00:09:00.000000', '00:13:00.000000', 'TH', 13);
INSERT INTO `library_schedule` VALUES (27, '00:14:00.000000', '00:16:30.000000', 'TH', 13);
INSERT INTO `library_schedule` VALUES (28, '00:09:00.000000', '00:14:00.000000', 'FR', 13);

-- ----------------------------
-- Table structure for library_service
-- ----------------------------
DROP TABLE IF EXISTS `library_service`;
CREATE TABLE `library_service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_service_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library_service
-- ----------------------------
INSERT INTO `library_service` VALUES (1, 'Electrification des tables', 1);
INSERT INTO `library_service` VALUES (2, 'Une table à hauteur variable', 1);
INSERT INTO `library_service` VALUES (3, '45 places assises', 1);
INSERT INTO `library_service` VALUES (4, 'Six ordinateurs avec accès internet (quatre pour les étudiants, deux pour les chercheurs)', 1);
INSERT INTO `library_service` VALUES (5, 'Wifi', 1);
INSERT INTO `library_service` VALUES (6, 'Imprimantes et photocopieuses', 1);
INSERT INTO `library_service` VALUES (7, '200 places assises', 2);
INSERT INTO `library_service` VALUES (8, '1 ordinateur avec accès internet', 2);
INSERT INTO `library_service` VALUES (9, '6 ordinateurs avec accès au portail documentaire uniquement', 2);
INSERT INTO `library_service` VALUES (10, 'Wifi', 2);
INSERT INTO `library_service` VALUES (11, 'Port usb', 2);
INSERT INTO `library_service` VALUES (12, 'Imprimantes et photocopieuses', 2);
INSERT INTO `library_service` VALUES (13, '100 places assises / depuis septembre 2020 : 50 places', 3);
INSERT INTO `library_service` VALUES (14, '1 salle de travail en groupe (maximum 6 personnes, réservation à l\'accueil de la bibliothèque) depuis septembre 2020 : fermée', 3);
INSERT INTO `library_service` VALUES (15, '10 ordinateurs avec accès internet', 3);
INSERT INTO `library_service` VALUES (16, 'Wifi', 3);
INSERT INTO `library_service` VALUES (17, 'Photocopieur/imprimante SEDECO', 3);
INSERT INTO `library_service` VALUES (18, '21 places assises (+ 24 dans la salle de travail 319 à l\'entrée de la bibliothèque)', 4);
INSERT INTO `library_service` VALUES (19, '1 ordinateur avec accès à Internet et à la bureautique', 4);
INSERT INTO `library_service` VALUES (20, '1 ordinateur avec accès à Internet et aux ressources pédagogiques audiovisuelles', 4);
INSERT INTO `library_service` VALUES (21, 'Wifi', 4);
INSERT INTO `library_service` VALUES (22, '66 places assises', 6);
INSERT INTO `library_service` VALUES (23, '3 ordinateurs avec accès internet et portail documentaire', 6);
INSERT INTO `library_service` VALUES (24, 'Wifi', 6);
INSERT INTO `library_service` VALUES (25, 'Port usb', 6);
INSERT INTO `library_service` VALUES (26, 'Imprimante noir et blanc', 6);
INSERT INTO `library_service` VALUES (27, '36 places assises', 7);
INSERT INTO `library_service` VALUES (28, '3 ordinateurs avec accès internet', 7);
INSERT INTO `library_service` VALUES (29, 'Wifi', 7);
INSERT INTO `library_service` VALUES (30, 'Port usb', 7);
INSERT INTO `library_service` VALUES (31, '15 places assises dans la bibliothèque D 410 ( en priorité pour les étudiants de concours et conultant les cartes)', 9);
INSERT INTO `library_service` VALUES (32, '25 places assises dans la salle de lecture D 411 adjacente à la bibliothèque', 9);
INSERT INTO `library_service` VALUES (33, '1 ordinateur avec accès internet et portail documentaire', 9);
INSERT INTO `library_service` VALUES (34, 'Wifi', 9);
INSERT INTO `library_service` VALUES (35, 'Photocopieur/imprimante/scanner couleur SEDECO', 9);
INSERT INTO `library_service` VALUES (36, 'Formation et aide à la recherche documentaire.', 5);
INSERT INTO `library_service` VALUES (37, '31 places de travail en individuel', 5);
INSERT INTO `library_service` VALUES (38, '1 salle de travail en groupe (réservation à l\'accueil de la bibliothèque)', 5);
INSERT INTO `library_service` VALUES (39, '7 ordinateurs avec accès à Internet', 5);
INSERT INTO `library_service` VALUES (40, 'Consultation du portail documentaire', 5);
INSERT INTO `library_service` VALUES (41, 'Accés aux ressources en ligne et aux outils de bureautiques', 5);
INSERT INTO `library_service` VALUES (42, 'Wifi (réseau éduroam)', 5);
INSERT INTO `library_service` VALUES (43, 'Imprimante-Photocopieuse- Scanner', 5);
INSERT INTO `library_service` VALUES (44, '33 places assises', 10);
INSERT INTO `library_service` VALUES (45, '2 ordinateurs avec accès internet', 10);
INSERT INTO `library_service` VALUES (46, 'Wifi', 10);
INSERT INTO `library_service` VALUES (47, 'Port usb', 10);
INSERT INTO `library_service` VALUES (48, '78 places assises', 11);
INSERT INTO `library_service` VALUES (49, '8 ordinateurs avec accès internet', 11);
INSERT INTO `library_service` VALUES (50, 'Wifi', 11);
INSERT INTO `library_service` VALUES (51, 'Port usb', 11);
INSERT INTO `library_service` VALUES (52, 'Imprimante et photocopieuse couleur', 11);
INSERT INTO `library_service` VALUES (53, '15 places assises', 13);
INSERT INTO `library_service` VALUES (54, '2 ordinateurs avec accès internet', 13);
INSERT INTO `library_service` VALUES (55, 'Wifi', 13);
INSERT INTO `library_service` VALUES (56, 'Imprimante', 13);
INSERT INTO `library_service` VALUES (57, '90 places assises', 12);
INSERT INTO `library_service` VALUES (58, 'salle de travail en groupe', 12);
INSERT INTO `library_service` VALUES (59, '8 ordinateurs avec accès au portail documentaire dont 5 avec accès internet', 12);
INSERT INTO `library_service` VALUES (60, 'Wifi', 12);
INSERT INTO `library_service` VALUES (61, 'Port usb, prises électriques', 12);
INSERT INTO `library_service` VALUES (62, 'Prêt de casque audio', 12);
INSERT INTO `library_service` VALUES (63, 'Imprimante (couleur), photocopieuse (couleur) et scanner', 12);

-- ----------------------------
-- Table structure for link_type
-- ----------------------------
DROP TABLE IF EXISTS `link_type`;
CREATE TABLE `link_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `base` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of link_type
-- ----------------------------
INSERT INTO `link_type` VALUES (1, 'facebook', 'https://www.facebook.com');
INSERT INTO `link_type` VALUES (2, 'twitter', 'https://twitter.com');
INSERT INTO `link_type` VALUES (3, 'youtube', 'https://www.youtube.com');
INSERT INTO `link_type` VALUES (4, 'nanterre_library', 'http://scd.parisnanterre.fr');
INSERT INTO `link_type` VALUES (6, 'instagram', 'https://www.instagram.com');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'Sandwichs', 3.00);
INSERT INTO `product` VALUES (2, 'Paninis', 3.00);
INSERT INTO `product` VALUES (3, 'Viennoiseries', 3.00);
INSERT INTO `product` VALUES (4, 'Tartes', 3.00);
INSERT INTO `product` VALUES (5, 'Boissons chaudes', 3.00);
INSERT INTO `product` VALUES (6, 'Jus de fruits frais', 3.00);
INSERT INTO `product` VALUES (7, 'Spécialités asiatiques', 3.00);
INSERT INTO `product` VALUES (8, 'Grillades', 3.00);
INSERT INTO `product` VALUES (9, 'Ciabatta chauds', 3.00);
INSERT INTO `product` VALUES (10, 'Soupes de légumes', 3.00);
INSERT INTO `product` VALUES (11, 'Pasta box', 3.00);
INSERT INTO `product` VALUES (12, 'Kebabs', 3.00);
INSERT INTO `product` VALUES (13, 'Salades composées', 3.00);
INSERT INTO `product` VALUES (14, 'Burgers et frites de fabrication artisanale', 3.00);
INSERT INTO `product` VALUES (15, 'Desserts maison', 3.00);
INSERT INTO `product` VALUES (16, 'Grandes salades', 3.00);
INSERT INTO `product` VALUES (17, 'Wraps', 3.00);
INSERT INTO `product` VALUES (18, 'Jus pressés', 3.00);
INSERT INTO `product` VALUES (19, 'Spécialités de tortillas', 3.00);
INSERT INTO `product` VALUES (20, 'Krous fried chicken', 3.00);
INSERT INTO `product` VALUES (21, 'Restaurant bistronomique', 3.00);
INSERT INTO `product` VALUES (22, 'Bagels', 3.00);
INSERT INTO `product` VALUES (23, 'Clubs', 3.00);
INSERT INTO `product` VALUES (24, 'Bruschetta', 3.00);
INSERT INTO `product` VALUES (25, 'Cheesecake', 3.00);
INSERT INTO `product` VALUES (26, 'Boissons gourmandes de l’après-midi', 3.00);
INSERT INTO `product` VALUES (27, 'Plats mijotés', 3.00);
INSERT INTO `product` VALUES (28, 'Poissons', 3.00);
INSERT INTO `product` VALUES (29, 'Pizzas', 3.00);
INSERT INTO `product` VALUES (30, 'Pâtes', 3.00);
INSERT INTO `product` VALUES (31, 'Saveurs du monde', 3.00);
INSERT INTO `product` VALUES (32, 'Salades', 3.00);


-- ----------------------------
-- Records of library_documentary_fund
-- ----------------------------

INSERT INTO `library_documentary_fund` (`id`, `name`, `library_id`) VALUES
(2, '1 850 ouvrages', 8),
(3, '3 revues', 8),
(4, 'Thèses', 8),
(5, 'Mémoires', 8),
(6, '5 700 ouvrages', 1),
(7, '78 titres de périodiques (dont 58 abonnements en cours)', 1),
(8, 'Fonds de l’Institut d’études judiciaires (IEJ) : empruntables par les étudiants suivant cette formation', 1),
(9, 'Fonds du Master d’études bilingues des droits de l’Europe (BDE)', 1),
(10, 'Fonds de mélanges', 1),
(11, 'Fonds Guy Carcassonne (FGC)', 1),
(12, '7 000 ouvrages.', 9),
(13, '100 titres de périodiques dont 12 abonnements en cours', 9),
(14, '150 thèses et mémoires', 9),
(15, '36 000 cartes topographiques, géologiques, climatiques et de végétation à différentes échelles (cartes françaises et étrangères)', 9),
(16, '30 000 ouvrages', 2),
(17, '112 titres de périodiques dont 29 abonnements en cours', 2),
(18, '4 500 mémoires', 2),
(19, '11 000 ouvrages', 3),
(20, '6 revues : Courrier International, Time, the Economist, Vocable espagnol, Deutch Perfekt, Monde chinois', 3),
(21, '148 mémoires de Master de Langues (soutenus au sein de l\'Université Paris Nanterre)', 3),
(22, 'Agrégation et CAPES d\'anglais et d\'espagnol : la plupart des ouvrages signalés dans les bibliographies officielles des concours sont disponibles.', 3),
(23, '30 000 ouvrages en lettres modernes et classiques et sciences du langage', 10),
(24, '150 titres de périodiques', 10),
(25, 'Une centaine de mémoires', 10),
(26, 'Rapports du jury CAPES et AGREGATION', 10),
(27, '17 000 ouvrages', 4),
(28, '70 titres de périodiques consultables sur place, plus 13 empruntables (dont 3 abonnements en cours)', 4),
(29, '350 thèses et mémoires consultables sur places (Inventaire à consulter/télécharger)\r\n', 4),
(30, 'Copies de concours en consultation sur place\r\n', 4),
(31, 'ouvrages', 5),
(32, 'ressources en ligne', 5),
(33, 'bases de données', 5),
(34, 'un fonds concours principalement catégories A et B', 5),
(35, 'revues spécialisées', 5),
(36, '6 500 ouvrages', 11),
(37, '16 revues', 11),
(38, 'Mémoires de master', 11),
(39, '6 200 ouvrages', 6),
(40, '20 titres de périodiques', 6),
(41, '400 à 500 mémoires', 6),
(42, '2 035 ouvrages', 6),
(43, '27 titres de périodiques dont 14 abonnements en cours', 6),
(44, '855 mémoires', 6),
(45, '90 rapports de stage', 6),
(46, 'Environ 20 800 documents', 12),
(47, '12 000 volumes d\'ouvrages', 12),
(48, '74 titres de périodiques dont 48 abonnements en cours', 12),
(49, '891 titres de mémoires, en Sciences de l\'éducation et en Sciences Psychologiques', 12),
(50, 'Documents pédagogiques, tirés a part, veille, annales', 12),
(51, '950 ouvrages', 7),
(52, '654 mémoires', 7),
(53, '3 800 ouvrages', 13),
(54, '10 titres de périodiques', 13),
(55, '1 400 thèses, mémoires et rapports de stages', 13);


SET FOREIGN_KEY_CHECKS = 1;
