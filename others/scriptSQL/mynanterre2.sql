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
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
-- Table structure for club
-- ----------------------------
DROP TABLE IF EXISTS `club`;
CREATE TABLE `club`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `image_bytes` longblob NULL,
  `creation_date` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `description` varchar(1000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `is_certificate` binary(1) NOT NULL DEFAULT '',
  `is_validate` binary(1) NOT NULL DEFAULT '',
  `creator_id` int(11) NOT NULL DEFAULT 11,
  `club_type_id` int(11) NOT NULL,
  `website` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `nanterreWebsiteUrl` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `image_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `club_type_id`(`club_type_id`) USING BTREE,
  INDEX `creator_id`(`creator_id`) USING BTREE,
  CONSTRAINT `club_ibfk_2` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `club_ibfk_3` FOREIGN KEY (`club_type_id`) REFERENCES `club_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6161 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of club
-- ----------------------------
INSERT INTO `club` VALUES (2081, 'Article X', NULL, '2020-12-28 20:31:41', 'Cette association a pour but d\'instaurer, de développer et d\'animer une dynamique d\'ouverture au sein de l\'Université, de dynamiser la vie étudiante par des manifestations culturelles à destination de tous les étudiant·e·s et de procurer à ses membres des moyens de formation complémentaire de leur cursus universitaire. Cette association y contribue par une représentation véritablement indépendante de toute formation politique.\r\n\r\nPassionnée de théâtre et persuadée que le rire adoucit les mœurs, l\'association Article X organise depuis 2015 un festival de stand up étudiant, le Festival Arti\'Show, permettant une véritable expression de la voix étudiante au travers de l\'ironie et de la dérision, mais aussi favorisant le lien social et l\'émancipation culturelle pour toutes et tous. Le festival vise à mettre en lien trois médias humoristiques : internet, la voix étudiante et le stand-up. Il a pour but de dénicher des talents étudiants et de les amener vers le professionnel en leur apportant ', 0x31, 0x31, 0, 181, 'https://www.facebook.com/associationarticleX/', 'articleX.paris10@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bât. R) - Boîte postale n°13\r\n200 avenue de la République\r\n92000 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/article-x-536210.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/articlex_1484751163917-png');
INSERT INTO `club` VALUES (2091, 'Dix de Choeur', NULL, '2020-12-28 20:31:41', 'Dix de Chœur, le chœur de l\'Université, agit depuis plus de vingt ans pour sensibiliser les choristes et toute la communauté universitaire à des répertoires musicaux très divers : de la musique de la Renaissance à la musique symphonique du XXè siècle, la musique de film, en passant par les périodes classique et romantique. Le chef de chœur et son assistante s\'efforcent chaque année de proposer des programmes riches et variés afin que chacun y trouve son compte.', 0x31, 0x31, 65, 181, 'http://www.dixdechoeur.fr/', 'contact@dixdechoeur.fr', 'Université Paris Nanterre\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/dix-de-choeur-12627.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/dix-de-choeur_1524207885188-gif');
INSERT INTO `club` VALUES (2101, 'Eloquentia Nanterre', NULL, '2020-12-28 20:31:41', 'Eloquentia est une association créée en 2012 par Stéphane de Freitas. Son but est d\'apprendre la prise de parole en public à des jeunes de moins de 30 ans, via des ateliers, une formation et un concours. Elle propose donc des évènements tout au long de l\'année.', 0x31, 0x31, 65, 181, 'http://eloquentia-nanterre.fr', 'eloquentiananterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bâtiment R)\r\nBoîte postale n°44\r\n200 Avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook : Eloquentia Nanterre', 'https://culture.parisnanterre.fr/service-action-culturelle-et-animation-du-campus/assos/annuaire-des-associations-etudiantes/eloquentia-nanterre-571427.kjsp?RH=1253625868526', 'https://culture.parisnanterre.fr/medias/photo/eloquentia_1530085421719-jpg');
INSERT INTO `club` VALUES (2111, 'Kaméo', NULL, '2020-12-28 20:31:42', 'Kaméo a pour objet en premier lieu de réunir les étudiants aspirant aux métiers du cinéma au sein d\'une communauté.\r\nUne fois les étudiants présentés et répertoriés dans leurs domaines de compétences cinématographiques, ils auront l\'occasion, ensemble, de réaliser des films avec l\'aide de l\'association aussi bien sur un plan logistique que matériel : l\'association mettra à disposition de ses adhérents du matériel de qualité pour la réalisation de leurs films !\r\nEnfin, l\'association organisera régulièrement des ateliers et des master class réalisées par des intervenants professionnels, en plus d\'évènements festifs de rencontre entre les membres. Nous voulons démocratiser la pratique vidéo et transmettre des raisonnements de responsabilité écologique.', 0x31, 0x31, 65, 181, 'https://www.facebook.com/Kameocinema/', 'associationkameo@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'étudiant·e (Bâtiment R)\r\nBoîte postale n°32\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/kameo-781878.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1509961883080-png');
INSERT INTO `club` VALUES (2121, 'La Volt', NULL, '2020-12-28 20:31:42', 'Cette association a pour thème la musique. Elle a vocation à organiser divers évènements autour de cet art qui pourront rassembler les étudiant·e· s de l\'université, quel que soit leur cursus.', 0x31, 0x31, 0, 181, 'https://www.facebook.com/LaVoltAssociation/', 'LaVolt.association@outlook.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte poste n°22\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-volt-831843.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/la-volt_1521026265230-jpg');
INSERT INTO `club` VALUES (2131, 'Les Imp\'Unis', NULL, '2020-12-28 20:31:42', 'L\'association Les Imp\'Unis (Les IMProvisateurs de l\'Université de Nanterre Imaginatifs et Saisissants) propose à ses adhérent·es la pratique de l\'improvisation théâtrale. Elle donne l\'occasion d\'intégrer une équipe soudée, énergique et positive qui souhaite égayer la vie des étudiant·es.', 0x31, 0x31, 65, 181, 'https://www.facebook.com/Les-IMPUnis-de-la-LIPON-367455386734697/', 'lesimpunis@gmail.com', 'Université Paris Nanterre\r\nBoîte postale n°48\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/les-imp-unis-ligue-d-improvisation--571297.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/impunis_1605179369444-jpg');
INSERT INTO `club` VALUES (2141, 'Les Indifférents', NULL, '2020-12-28 20:31:42', 'LES INDIFFÉRENTS est une compagnie de théâtre universitaire. Depuis 1998, elle accueille et forme au sein d\'ateliers toute personne désireuse de s\'initier/se perfectionner dans les arts théâtraux. Elle ne vise pas simplement au divertissement amateur ou à l\'inscription dans le monde théâtral professionnel, mais aussi à la création, la recherche, l\'inédit. Elle a créé à ce jour 38 spectacles, représentés à l\'université ou à l\'occasion de festivals internationaux de théâtre universitaire, où elle a été à chaque fois primée. Elle a aussi pour but de former les formateurs qui mèneront les ateliers de l\'association.', 0x31, 0x31, 0, 181, 'https://www.lesindifferents.com/', 'compagnielesindifferents@gmail.com', 'Page Facebook : Les Indifférents', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/les-indifferents-524080.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/les-indifferents_1493988986438-png');
INSERT INTO `club` VALUES (2151, 'Le Phare Ouest', NULL, '2020-12-28 20:31:42', 'L\'association Le Phare Ouest est un média produit par les étudiant·es de l\'Université Paris Nanterre et à destination de tous les usager·es de l\'université. Celui-ci se développe à la fois par l\'intermédiaire d\'un magazine papier édité et d\'une chaîne Youtube.\r\nNotre ambition est d\'offrir à l\'ensemble des étudiant·es, toutes filières confondues, un média qui leur ressemble, et dans lequel iels peuvent s\'exprimer. Nous permettons également à ses membres, et à ses rédacteur·trices, d\'acquérir des compétences en lien avec le journalisme, les métiers de la communication et de l\'administration.', 0x31, 0x31, 0, 181, 'http://phareouest-nanterre.parisnanterre.fr/', 'phareouestnanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°31\r\n92001 Nanterre Cedex\r\n\r\nFacebook Le Phare Ouest', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/le-phare-ouest-772401.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-le-phare-ouest_1575633901951-jpg');
INSERT INTO `club` VALUES (2161, 'Lysias', NULL, '2020-12-28 20:31:42', 'La Lysias Paris Nanterre organise depuis 1993 un concours de plaidoiries et d\'éloquence à l\'Université, en vue de désigner les représentant·es de l\'Université au concours national Lysias, qui affronteront les lauréat·es d\'autres Lysias et associations de plaidoirie et d\'éloquence judiciaire. De manière générale, Lysias assure également la promotion de l\'art oratoire et de l\'éloquence judiciaire au travers de divers événements, organisés à l\'Université ou avec le Barreau des Hauts-de-Seine.', 0x31, 0x31, 0, 181, 'https://www.facebook.com/lysiasparis10/', 'lysias.paris10@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°74\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nTwitter : @Lysias_Paris10\r\nInstagram : @lysiasnanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/lysias-nanterre-553631.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1576135276336-jpg');
INSERT INTO `club` VALUES (2171, 'Mélo\'dix', NULL, '2020-12-28 20:31:43', 'Soutenu par le service commun de l\'ACA² de l\'Université, l\'Orchestre réunit aujourd\'hui 70 musiciens amateurs et professionnels de la région parisienne. Conduit par un chef exigeant et composé d\'étudiants investis, Mélo\'dix a désormais sa place au sein des très bons orchestres amateurs grâce à des programmes ambitieux et originaux, donnés lors de nombreux concerts.\r\n\r\nEn plus de ses représentations à l\'Université, l\'orchestre est régulièrement invité par des théâtres et des festivals étudiants (Théâtre Molière de Poissy (95), Festival International de Musique Universitaire de Belfort...) et travaille à son rayonnement en région parisienne (Eglise Notre Dame du Travail, Maison des Pratiques Artistiques Amateurs de St Germain des Prés). Mélo\'dix a également l\'honneur d\'accompagner la finale du concours International de pianos \"Piano Campus\", à Pontoise.\r\n\r\nL\'Orchestre recrute toute l\'année de nouveaux musiciens, étudiants à Paris Nanterre ou non, après audition. Pour nous rejoindre : orc', 0x31, 0x31, 0, 181, 'http://www.orchestremelodix.com/', 'orchestremelodix@yahoo.fr', 'Université Paris Nanterre\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/melo-dix-12682.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/melo-dix_1524207969486-png');
INSERT INTO `club` VALUES (2181, 'RCVA', NULL, '2020-12-28 20:31:43', 'L\'objectif de l\'association RCVA est de concevoir et réaliser deux robots pour participer aux Coupes de France et d\'Europe de Robotique et d\'y représenter l\'IUT de Ville d\'Avray et l\'Université de Paris Nanterre.\r\n\r\nLes tâches réalisées par l\'association sont multiples : recherche de partenariats, conception des robots (mécanique, électronique…), création du terrain, assemblage des robots, développement du logiciel informatique des robots, communication sur les réseaux sociaux / forums, participation à différents évènements et participation à la coupe de France et d\'Europe de Robotique.', 0x31, 0x31, 0, 181, 'http://www.rcva.fr', 'team.rcva@gmail.com', '1 chemin Desvallières\r\n92410 Ville d\'Avray\r\n\r\nPage Facebook : RCVA\r\nCompte twitter : @TEAM_RCVA', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/robot-concept-ville-d-avray-rcva--642364.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-rcva_1574241248201-png');
INSERT INTO `club` VALUES (2191, 'Révolte-toi Nanterre', NULL, '2020-12-28 20:31:43', 'Révolte-toi Nanterre forme les orateurs de demain en proposant un entraînement hebdomadaire à la prise de parole en public, accessible à tous librement. Notre association a pour vocation la transmission des outils de perfectionnement de l\'élocution, de la capacité de persuasion et du talent d\'improvisation à travers des exercices scéniques et une initiation au débat parlementaire.', 0x31, 0x31, 0, 181, 'https://www.facebook.com/rvtnanterre/', 'revtoi.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\n200, avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/revolte-toi-nanterre-571437.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/rvtn_1599566664430-png');
INSERT INTO `club` VALUES (2201, 'Nanterre Hangagée', NULL, '2020-12-28 20:31:43', 'Nanterre Hangagée a pour objectif de sensibiliser la communauté universitaire à la question du handicap. Pour cela elle souhaite regrouper tous les acteurs voulant faire changer les choses, les étudiant·es en premier lieu. Par des actions d\'accompagnement, de formation et de sensibilisation, l\'association compte devenir un lieu incontournable pour toute personne qui désire changer le regard sur le handicap.', 0x31, 0x31, 0, 191, 'https://www.facebook.com/NanterreHangagee', 'nanterrehangagee@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°81\r\n200 av de la République\r\n92 001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/nanterre-hangagee-917312.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1560265644362-jpg');
INSERT INTO `club` VALUES (2211, 'VH Insertion', NULL, '2020-12-28 20:31:43', 'Association ayant pour but de favoriser l\'insertion sociale et professionnelle des étudiant·es, notamment ceux et celles en situation de handicap, par le biais :\r\n- d\'actions de sensibilisation, de prévention et d\'éducation à la santé\r\n- d\'activités culturelles et sportives autour du handicap', 0x31, 0x31, 0, 191, NULL, 'vh(point)insertion(arobase)laposte(point)net', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°83\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/vh-insertion-925140.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2221, 'AMAP ETAL', NULL, '2020-12-28 20:31:43', 'L\'AMAP ETAL* est une association créée en 2013 qui appartient au réseau AMAP Ile-de-France et qui a pour objectif de réunir des consommateurs étudiants, des personnels de l\'Université Paris Nanterre et des producteurs partageant des valeurs communes telles que la solidarité et l\'écologie.\r\n\r\nL\'activité principale de l\'association consiste à organiser une distribution hebdomadaire de paniers de légumes aux adhérent·es tous les mercredis, sur deux créneaux horaires : 12h30-13h30 et 17h30-19h à la Maison de l\'Étudiant.e.\r\n\r\n*AMAP : Association pour le Maintien d\'une Agriculture Paysanne - ETAL : Et Tous Au Local', 0x31, 0x31, 0, 201, 'https://amapetal.wordpress.com', 'amap.etal@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant\r\nBoîte postale n°41\r\n200 avenue de la République\r\n92000 Nanterre\r\n\r\nPage Facebook : AMAP ETAL', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/amap-etal-nanterre-et-tous-au-local--539360.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1606229907878-png');
INSERT INTO `club` VALUES (2231, 'Facteur Commun', NULL, '2020-12-28 20:31:43', 'Facteur Commun est une association de sensibilisation au respect de l\'environnement. L\'équipe travaille à créer des espaces de partage, d\'expression et d\'engagement autour de l\'écologie, et à participer à l\'information du public grâce à une médiation ludique et originale.', 0x31, 0x31, 0, 201, 'https://www.facebook.com/AssoFacteurCommun/', 'facteurcommun@ecomail-asso.com', '200 avenue de la République\r\nBoîte postale n°34\r\n92001 NANTERRE https://www.facteurcommun.com', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/facteur-commun-887382.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/facteur-commun_1547562561189-jpg');
INSERT INTO `club` VALUES (2241, 'Les Unis Verts Nanterre', NULL, '2020-12-28 20:31:43', 'Notre association a pour but de sensibiliser la communauté universitaire à la protection de l\'environnement à travers des projets comme la distribution de packs 0 déchets, l\'installation d\'Ecosia sur tout le campus, l\'instauration de fontaines à eaux ou encore un vide-dressing inter-associatif.', 0x31, 0x31, 0, 201, 'https://www.facebook.com/lesunisverts', 'lesunisverts.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°24\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/les-unis-verts/les-unis-verts-nanterre-658882.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2020_1575893585889-jpg');
INSERT INTO `club` VALUES (2251, 'Amphibix', NULL, '2020-12-28 20:31:43', 'Amphibix (BIX) est une association d\'animation mais avant tout de musique dont le but est d\'organiser des open air et des soirées tout au long de l\'année afin de contribuer au dynamisme de l\'université', 0x31, 0x31, 0, 211, 'https://www.facebook.com/asso.bix', 'bixparis10@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°42\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/amphibix-536852.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2016_1484750916206-png');
INSERT INTO `club` VALUES (2261, 'Le Cercle', NULL, '2020-12-28 20:31:44', 'Le Cercle est une association de pétanque de l\'université Paris Nanterre créée en 2015. Celle-ci a pour objet d\'animer la vie du campus de l\'Université Paris Nanterre à travers l\'organisation de tournois de pétanque et de divers événements autour de cette pratique (barbecue, soirée ... ).', 0x31, 0x31, 0, 211, 'https://www.facebook.com/pages/Le-Cercle/1423823117922557?', 'lecercle.paris10@hotmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (bât. R)\r\nBoîte postale n°33\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/le-cercle-612930.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1484752804325-jpg');
INSERT INTO `club` VALUES (2271, 'La Cartouchière', NULL, '2020-12-28 20:31:44', 'Cette association a pour but : la découverte de la chasse et sa culture, l\'organisation de soirée, de repas et de sortie afin d\'illustrer le rôle majeur de la chasse dans les domaines de l\'art de vivre, de la gastronomie et de la table.\r\nElle a aussi pour but la sauvegarde de la vie animale, de la faire connaître et de la protéger. Enfin, elle a pour objectif la formation des étudiant·e·s de Paris Nanterre à l\'examen du permis de chasser et à la connaissance de la nature.', 0x31, 0x31, 0, 211, NULL, 'lacartouchiereparisx@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e - Boîte postale n°17\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-cartouchiere-807913.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/la-cartouchie-re-logo_1574944375834-jpg');
INSERT INTO `club` VALUES (2281, 'La Huit', NULL, '2020-12-28 20:31:44', 'La Huit est une association de loisirs sur le thème du billard. Elle organise des tournois de billard et des afterworks tout au long de l\'année dans le but de divertir les étudiant·es de l\'université.', 0x31, 0x31, 0, 211, 'https://www.facebook.com/association.lahuit', 'association.lahuit@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bât. R)\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-huit-743139.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2291, 'La Rover', NULL, '2020-12-28 20:31:44', 'Créée en 2016, la Rover fait découvrir aux étudiant·es de Nanterre et d\'ailleurs des grandes villes européennes : Prague, Londres, Barcelone, Amsterdam, Bruxelles...\r\nFière de 2 voyages par an, elle participe aussi à la vie du campus avec des barbecues sur les pelouses et afterworks non loin de l\'université.', 0x31, 0x31, 0, 211, 'https://www.facebook.com/assorover', 'larover.parisnanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (bâtiment R)\r\n200 avenue de la République\r\n92000 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-rover-654511.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2017-_1496732483750-jpg');
INSERT INTO `club` VALUES (2301, 'Nanterre Le Rouge', NULL, '2020-12-28 20:31:44', 'Cette association a pour objet l\'initiation, la découverte et la pratique de l\'œnologie, et tout cela dans une ambiance conviviale.', 0x31, 0x31, 0, 211, 'https://www.facebook.com/nanterrelerouge', 'nanterrelerouge@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bâtiment R)\r\n200, avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/nanterre-le-rouge-571436.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2017_1495626099846-jpg');
INSERT INTO `club` VALUES (2311, 'F.A.X', NULL, '2020-12-28 20:31:44', 'La FAX a pour but de coordonner les actions de ses associations adhérentes et de représenter les étudiant·es de l\'Université Paris Nanterre aux différentes instances de l\'Université en défendant les intérêts tant collectifs qu\'individuels.', 0x31, 0x31, 0, 221, 'https://www.facebook.com/fax.associationsnanterre', 'association.fax@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bât. R)\r\nLocal 207\r\n200, avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/fax-federation-des-associations--536819.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/fax-2-_1586174038633-jpg');
INSERT INTO `club` VALUES (2321, 'UNEF Nanterre', NULL, '2020-12-28 20:31:44', 'L\'Union Nationale des Etudiants de France, première organisation étudiante, est le seul syndicat présent dans tous les établissements d\'Enseignement Supérieur. Cette implantation nationale ainsi que sa démarche syndicale fondée sur la construction d\'un rapport de force dans le but d\'obtenir des avancées concrètes lui donne une légitimité et une efficacité importantes. Indépendante des partis politiques, des administrations, comme des gouvernements, l\'UNEF intervient pour représenter, informer et défendre les étudiants quelle que soit leur filière ou leur origine.', 0x31, 0x31, 0, 221, 'https://www.facebook.com/unef.ntr', 'paris10@unef.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (bât. R)\r\nLocal 206\r\n200 avenue de la République\r\n92000 Nanterre\r\n01 40 97 49 45', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/unef-nanterre-553940.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1485181183304-gif');
INSERT INTO `club` VALUES (2331, 'UNI Paris Nanterre', NULL, '2020-12-28 20:31:44', 'L\'UNI a pour objectif de peser dans le débat universitaire et d\'offrir aux étudiants une organisation étudiante défendant un enseignement supérieur de qualité, qui se base sur des valeurs telles que le travail, le mérite et la responsabilité. Nous avons quatre priorités essentielles : l\'insertion professionnelle, la qualité de l\'offre de formation, la qualité des conditions d\'études ainsi que la liberté d\'expression et d\'opinion.', 0x31, 0x31, 0, 221, 'https://www.facebook.com/UNINanterre/', 'uni.nanterre@gmail.com', 'Université Paris Nanterre\r\nLocal F214\r\nBâtiment F', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/uni-paris-nanterre-795986.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/test-logo-uni_1508935085035-jpg');
INSERT INTO `club` VALUES (2341, 'AltiSki Paris Nanterre', NULL, '2020-12-28 20:31:45', 'L\'association L\'Altiski Paris Nanterre, organise un voyage aux sports d\'hiver adaptés à l\'ensemble des étudiant·es, tant sur le plan financier que sur le plan récréatif. L\'association a pour but de se rapprocher des étudiant·es via des évènements organisés sur l\'Université.', 0x31, 0x31, 0, 231, NULL, 'altiski.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'étudiant·e (Bât. R)\r\nBoîte postale N°16\r\n200, av. de la République\r\n92001 Nanterre Cedex.', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/l-altiski-paris-nanterre--536165.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-altiski-_1567782760579-jpg');
INSERT INTO `club` VALUES (2351, 'Bureau des Sports du Pôle Ville d\'Avray (BDS VDA)', NULL, '2020-12-28 20:31:45', 'Le Bureau des Sports de Ville-d\'Avray (BDS VDA) est une association étudiante qui a pour objectif de permettre aux étudiant·e·s du site de Ville-d\'Avray de pratiquer du sport en dehors des heures de cours. Nous proposons également aux adhérent·e·s de participer aux différents championnats nationaux de sport étudiant, ponctuellement de participer à des tournois sportifs et enfin d\'aller voir des matchs de championnats nationaux et européens tous ensemble.', 0x31, 0x31, 0, 231, 'https://www.facebook.com/bdsvda/', 'bds.vda@gmail.com', 'IUT Ville d\'Avray\r\n50 rue de Sèvres\r\n92410 Ville-d\'Avray', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/bureau-des-sports-du-pole-ville-d-avray-886473.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-bds-vda_1547021526671-jpg');
INSERT INTO `club` VALUES (2361, 'Hooligans Paris Nanterre', NULL, '2020-12-28 20:31:45', 'L\'association« Hooligans» de Nanterre est l\'association de rugby universitaire de Paris Nanterre. Les \"Hools\" s\'entraînent tous les lundis au stade Vincent Pascucci et défendent vaillamment les couleurs de l\'université Paris Nanterre les jeudis lors des matchs du championnat universitaire.\r\nTroisième d\'île de France à XV et deuxième d\'île de France à VII l\'an dernier, l\'équipe connait ses meilleurs résultats depuis sa création !\r\n\r\nNouveauté cette année ! Création d\'une équipe de cheerleaders membres à part entière de l\'association ! Ouverts à toutes et à tous, les Hools vous attendent nombreux parmi eux, dans les gradins pour les encourager ou lors des autres activités organisées par l\'association.', 0x31, 0x31, 0, 231, 'https://www.facebook.com/hooligansparisx/', 'hooligansparisx@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'étudiant·e (Bâtiment R)\r\nBoîte postale n°90\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/hooligans-paris-nanterre-681236.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-hools-2017_1509001641750-jpg');
INSERT INTO `club` VALUES (2371, 'Nanterre Association Voile (la NAV)', NULL, '2020-12-28 20:31:45', 'Créée fin 2008, la NAV est une association qui regroupe une trentaine d\'étudiants de Paris Nanterre autour d\'une passion commune : la voile. Grâce à sa motivation, la NAV\' a réussi à participer à différentes courses étudiantes chaque année depuis 2009, telles que la CCE (Course Croisière de l\'Edhec) et la SPI.', 0x31, 0x31, 0, 231, 'https://www.facebook.com/Asso-Nav-1627239174192425', 'assonav@outlook.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°35\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-nav-nanterre-association-de-voile--525229.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1484754921747-png');
INSERT INTO `club` VALUES (2381, 'Red Rams', NULL, '2020-12-28 20:31:45', 'Association sportive de football américain universitaire évoluant au sein de l\'Université Paris Nanterre. A l\'image des valeurs qu\'elle défend, c\'est-à-dire celles de la jeunesse et du sport, l\'association regroupe un ensemble de centre d\'intérêts propres aux étudiant·es et au collectif qui a permis sa création.', 0x31, 0x31, 0, 231, 'redramsnanterre@gmail.com', 'redramsnanterre@gmail.com', NULL, 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/red-rams-811568.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/redrams_1512392256235-jpg');
INSERT INTO `club` VALUES (2391, 'L\'ALTISKI PARIS NANTERRE', NULL, '2020-12-28 20:31:45', 'L\'association L\'Altiski Paris Nanterre, organise un voyage aux sports d\'hiver adaptés à l\'ensemble des étudiant·es, tant sur le plan financier que sur le plan récréatif. L\'association a pour but de se rapprocher des étudiant·es via des évènements organisés sur l\'Université.', 0x31, 0x31, 0, 231, NULL, 'altiski.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'étudiant·e (Bât. R)\r\nBoîte postale N°16\r\n200, av. de la République\r\n92001 Nanterre Cedex.', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/l-altiski-paris-nanterre--536165.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-altiski-_1567782760579-jpg');
INSERT INTO `club` VALUES (2401, 'Amnesty International Groupe Jeunes 3047 (antenne)', NULL, '2020-12-28 20:31:45', 'Les Antennes Jeunes sensibilisent leur environnement aux droits humains, font vivre le mouvement dans leur région : elles diffusent les informations reçues mensuellement, relaient les actions menées au niveau national, mobilisent la presse locale, organisent des événements... et plus selon vos idées !', 0x31, 0x31, 0, 241, 'https://www.facebook.com/AJnanterre', 'amnesty.uparisnanterre@gmail.com', 'Maison des associations\r\n11 rue des Anciennes Mairies\r\n92000 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/amnesty-international-groupe-jeunes-3047-717005.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1485360683166-jpeg');
INSERT INTO `club` VALUES (2411, 'Antenne Jeunes UNICEF Campus Paris Nanterre', NULL, '2020-12-28 20:31:46', 'L\'Antenne UNICEF Campus Nanterre a pour but la sensibilisation et la récolte de dons. A travers divers événements tels que le Talent Show, le concours d\'éloquence inter-antennes ou encore des ventes de gâteaux, elle contribue à son échelle à soutenir l\'UNICEF.\r\n\r\nL\'UNICEF France a pour mission de sensibiliser le public, les institutions, les médias, les leaders d\'opinion et les acteurs économiques français à la situation des enfants, de contribuer à l\'éducation des jeunes à la solidarité, de collecter des ressources pour contribuer aux actions de l\'UNICEF dans le monde, et de veiller au respect de la Convention Internationale des Droits de l\'Enfant en France.', 0x31, 0x31, 0, 241, 'https://www.facebook.com/unicef.paris.nanterre/', 'unicef.parisouest@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°52\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nwww.unicef.fr', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/antenne-unicef-campus-paris-nanterre-539357.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-unicef-campus_1582288821024-jpg');
INSERT INTO `club` VALUES (2421, 'Une Couverture Pour l\'Hiver UCPH', NULL, '2020-12-28 20:31:46', 'Une Couverture Pour l\'Hiver est une association à majorité étudiante d\'aide aux personnes sans-abri. Lors de maraudes hebdomadaires, les bénévoles vont à la rencontre des personnes à la rue afin de lutter contre leur exclusion et apporter des produits de première nécessité. UCPH participe à la déconstruction des cliché et à l\'éveil des consciences en organisant des actions de sensibilisation. Une antenne UCPH est présente sur le campus de Nanterre.', 0x31, 0x31, 0, 241, 'www.unecouverture.fr', 'unecouverture@gmail.com', '322, rue Saint-Jacques\r\n75005, Paris', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/une-couverture-pour-l-hiver-antenne--883375.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/ucph_1544695965100-png');
INSERT INTO `club` VALUES (2431, 'Amicale des Étudiant·es Sénégalais·es (AMESEN)', NULL, '2020-12-28 20:31:46', 'L\'Amicale des Etudiant·es Sénégalais de l\'Université Paris Nanterre (AMESEN) est une initiative estudiantine qui prit conscience de la détresse, du manque d\' information et d\'orientation des primo-arrivant.e.s. Conscient.e.s de l\'importance d\'une arrivée réussie à l\'université, l\'amicale se donne pour vocation d\'accueillir, d\'informer, d\'orienter et d\'accompagner les étudiant·es dans leurs vies estudiantines et démarches administratives pour la réalisation de leurs projets universitaires.\r\nPar ailleurs, pour faciliter un rapport convivial entre étudiant·es, des journées portes ouvertes, des sorties pédagogiques, des journées culturelles sont régulièrement organisées par l\'amicale. L\'association est un lieu de sociabilité, de partage et d\'entre aide dans un esprit de \"Terranga\" Sénégalaise.', 0x31, 0x31, 0, 251, NULL, 'etudiantsenegalais.nanterre1@gmail.com', 'Maison de l\'Étudiant·e\r\nBoîte postale n°80\r\nUniversité Paris Nanterre\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/amicale-des-etudiant-es-senegalais-es-914792.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2441, 'Nanterasmus', NULL, '2020-12-28 20:31:46', 'L\'association Nanterasmus permet aux étudiant·e·s étranger·e·s ayant choisi d\'étudier à l\'Université Paris Nanterre de se rencontrer à travers des événements pouvant être d\'origine culturelle et festive. Nous leur organisons des sorties diverses et variées afin qu\'ils rencontrent à la fois des étudiant·e·s en Erasmus et des français·e·s.', 0x31, 0x31, 0, 251, 'https://www.facebook.com/nanterasmusparis10/', 'nanterasmus@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bât. R)\r\nBoîte postale n°49\r\n200 Avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/nanterasmus-571435.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/nanterasmus_1551083140293-jpg');
INSERT INTO `club` VALUES (2451, 'Primo', NULL, '2020-12-28 20:31:46', 'Primo a pour but de promouvoir la culture italienne à Paris Nanterre. Ouverte à toutes et à tous, Primo souhaite offrir un nouveau regard sur l\'Italie à travers des actions enrichissantes et conviviales, tout en favorisant l\'échange entre étudiant·e·s. Elle propose des événements culturels, festifs et accompagne les élèves s\'engageant dans des cursus italiens.', 0x31, 0x31, 0, 251, 'https://www.facebook.com/PrimoAssociationNanterre/', 'primonanterre@gmail.com', 'https://primonanterre.wordpress.com/', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/primo-811287.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/primo_1516108584244-jpg');
INSERT INTO `club` VALUES (2461, 'Réseau des étudiants guinéens de Nanterre (REGN)', NULL, '2020-12-28 20:31:46', 'Le REGN (Réseau des étudiants Guinéens de Nanterre) est une association regroupant des étudiant·e·s guinéen·ne·s de l\'université Paris Nanterre ainsi que d\'autres étudiant·e·s partagent les mêmes valeurs dans :\r\nL\'accueil et l\'intégration des nouveaux étudiants guinéens à l\'université de Nanterre;\r\nle maintien des liens et d\'entraide mutuelle ;\r\nl\'organisation des activités socioculturelles pour le bien de tous.', 0x31, 0x31, 0, 251, 'https://www.facebook.com/REGNANTERRE/', 'regnanterre.asso@gmail.com', 'Université Paris Nanterre\r\n200 Avenue de la République\r\nMaison de l\'Étudiant·e - Boîte postale n°23 92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/reseau-des-etudiants-guineens-regn--845372.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2471, 'Collectif Féministe Intersectionnel de Nanterre', NULL, '2020-12-28 20:31:46', 'Le Collectif Féministe Intersectionnel de Nanterre (COFIN) cherche à donner parole et visibilité aux personnes assignées et/ou identifiées femmes, aux personnes trans, aux personnes racisées, aux personnes à l\'identité de genre ou orientation sexuelle non normative et à toute personne qui s\'identifierait à nos luttes et nos valeurs. Notre féminisme est inclusif et matérialiste.\r\nÀ travers ateliers, conférences, réunions, expression académique et alternative, nous entendons être un espace d\'échanges et pédagogie et fournir un environnement où chacun·e peut trouver et apporter soutien, réflexion et évolution individuelle et collective.', 0x31, 0x31, 0, 261, 'https://www.facebook.com/CFeministeNU/', 'collectif.feministe.nanterreu@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°86\r\n200 Avenue de la République\r\n92001 Nanterre CEDEX', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/collectif-feministe-intersectionnel--931967.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/cofin_1568619463869-jpg');
INSERT INTO `club` VALUES (2481, 'Étudiants Marxistes de Nanterre', NULL, '2020-12-28 20:31:46', 'Le but du Cercle Marxiste est d\'offrir aux étudiant·es et personnels de l\'université un espace de discussion sur les idées du marxisme, mais aussi un espace politique, et de débat.', 0x31, 0x31, 0, 261, 'https://www.facebook.com/cerclemarxisteP10', 'cmarxisteP10@gmail.com', 'Université Paris Nanterre\r\n200 avenue de la République\r\nMaison de l\'Étudiant·e - Boîte postale n°38\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/etudiants-marxistes-de-nanterre-768392.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/emn_1554975735762-png');
INSERT INTO `club` VALUES (2491, 'Etudiants Musulmans de France Nanterre (EMF Nanterre)', NULL, '2020-12-28 20:31:46', 'EMF Nanterre se consacre à l\'amélioration de la vie étudiante. Elle s\'efforce de veiller au bien-être et à l\'épanouissement de tous les étudiant·es, en les guidant et en les soutenant; sans aucune distinction. De vocation socioculturelle, EMF inscrit son action au sein du campus, son champ naturel d\'action, sans pour autant négliger le rayonnement sur la ville et les questions liées à la société.', 0x31, 0x31, 0, 261, 'https://www.facebook.com/emf.nanterre.18', 'presidence@nanterre.emf-asso.com', 'Université Paris Nanterre\r\nMaison de l\'Etudiant·e\r\nBoîte postale n°92\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nwww.emf-asso.com', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/etudiants-musulmans-de-france-nanterre-955825.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1607677519001-jpg');
INSERT INTO `club` VALUES (2501, 'Le Cas Réouvert', NULL, '2020-12-28 20:31:46', 'Cette association a pour objet de promouvoir le dialogue et le de´bat sur des the´matiques de socie´te´ et d\'actualite´, inviter a` l\'e´coute des diffe´rentes opinions e´nonce´es ainsi qu\'a` la conside´ration de celles-ci dans le champ des ide´es.', 0x31, 0x31, 0, 261, NULL, 'lecasreouvert@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n° (à venir)\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/le-cas-reouvert-988468.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2511, 'L\'Óra du débat', NULL, '2020-12-28 20:31:47', 'Óra a pour but de créer des conférences entre membres associatifs, personnages publics et universitaires, autour des sujets primordiaux de notre époque. Nos conférences seront basées sur des valeurs : le partage, l\'entraide, la solidarité, le respect, l\'égalité, la liberté, la démocratie... Vous pourrez retrouver sur la page Facebook l\'ensemble de nos activités mais aussi de quoi vous repérer au sein de l\'Université Paris Nanterre.', 0x31, 0x31, 0, 261, 'https://ora81.webnode.fr/', 'ora.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°28\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook : loradudebat', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/l-ora-du-debat-863265.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/ora_1537796349796-jpg');
INSERT INTO `club` VALUES (2521, 'Model United Nations Society Paris Nanterre', NULL, '2020-12-28 20:31:47', 'Model United Nations Society Paris Nanterre (MSPN)\r\n\r\nLa MUN Society Paris Nanterre a pour objectif principal de promouvoir les objectifs de l\'Organisation des Nations Unies. Nous organisons et participons à des simulations sur le modèle de l\'ONU qui se déroulent en anglais. Les débats portent sur l\'actualité internationale, les relations internationales et le droit international. Cela permet aux étudiant·es de travailler non seulement leur anglais mais également leur culture générale et leur éloquence.', 0x31, 0x31, 0, 261, 'https://www.facebook.com/mspnofficial', 'societyparisnanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°29\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nInstagram @mspn_official', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/model-united-nations-society-universite--667660.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/mspn2_1571645900665-jpg');
INSERT INTO `club` VALUES (2531, 'Solidaires Etudiant-e-s Paris Nanterre', NULL, '2020-12-28 20:31:47', 'Nous appartenons à la fédération Solidaires Étudiant.e.s qui est un syndicat étudiant, membre de l\'Union syndical solidaire. Nous défendons les droits des étudiants et étudiantes au quotidien, au niveau des conditions d\'études, de logement, des inscriptions, des bourses, des examens... Nous combattons toute forme d\'oppression ( sexisme, racisme, validisme...) et militons pour une transformation sociale.', 0x31, 0x31, 0, 261, 'https://www.facebook.com/SolidairesEtudiantParisX/', 'solidaires.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (bât. R)\r\nLocal 205\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/solidaires-etudiant-e-s-526771.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/solidaires-nanterre_1586246083721-png');
INSERT INTO `club` VALUES (2541, 'Union Générale Etudiante de Nanterre-FSE (UGEN FSE)', NULL, '2020-12-28 20:31:47', 'Union Générale Étudiante de Nanterre - FSE', 0x31, 0x31, 0, 261, 'https://www.facebook.com/FSE.Nanterre/', 'fse.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°96\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/ugen-fse-981324.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1601043147264-jpg');
INSERT INTO `club` VALUES (2551, 'ACFA', NULL, '2020-12-28 20:31:47', 'Association du cursus franco-allemand en droit de l\'université Paris Nanterre/ Potsdam\r\n\r\nL\'Association du Cursus de droit Franco-Allemand Paris Nanterre / Potsdam, fondée en 2008, vise à rassembler les différents étudiant·es du bi-cursus de l\'Université Paris Nanterre / Universität Potsdam. Elle permet d\'établir un lien entre les anciens étudiant·es du cursus, diplômés, et les étudiant·es actuels, de la licence au master.', 0x31, 0x31, 0, 271, 'https://acfananterre.wordpress.com/', 'acfa.info@gmail.com', 'Université Paris Nanterre\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook ACFA', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/acfa-539366.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2017_1480670937066-jpg');
INSERT INTO `club` VALUES (2561, 'ADER', NULL, '2020-12-28 20:31:48', 'L\'Association des Etudiant·es en Droit - Études Russes (ADER) a comme activité principale la promotion de la culture russophone et le développement de la cohésion, l\'entraide, ainsi que les échanges culturels, professionnels et académiques pour l\'ensemble des étudiants et étudiantes russophones et russophiles de l\'Université Paris Nanterre.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/aderparisx/', 'ader.parisx@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°82\r\n200 av de la République\r\n92 001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/ader-droit-etudes-russes--917315.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/ader_1566215041064-jpg');
INSERT INTO `club` VALUES (2571, 'ADPN', NULL, '2020-12-28 20:31:48', 'L\'ADPN est l\'association du M2 de droit pénal et sciences criminelles.\r\nElle réunit les étudiant·es du M2 de droit pénal et sciences criminelles et participe à la cohésion de la promotion. Elle a pour but de promouvoir le droit pénal et permet d\'échanger à propos de l\'actualité pénale française et étrangère.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/ADPNanterre/', 'm2adpn@gmail.com', 'Université Paris Nanterre\r\nCDPC\r\nBâtiment Simone Veil - 4è étage\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-de-droit-penal-de-nanterre-798492.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-adpn_1508157681844-jpg');
INSERT INTO `club` VALUES (2581, 'AEDIN', NULL, '2020-12-28 20:31:48', 'Association des Étudiant·es de Droit International de Nanterre (AEDIN)\r\n\r\nL\'Association développe les relations entre les ancien·nes, actuel·les et futur·es étudiant·es du Master Théorie et pratique du droit international et européen', 0x31, 0x31, 0, 271, 'https://www.aedin.fr/', 'aedin.nanterre@gmail.com', 'Université Paris Nanterre\r\nCEDIN, UFR DSP Bureau 136\r\nBâtiment Simone Veil\r\n200, Avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/aedin-droit-international--595163.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/aedin_1580718958172-png');
INSERT INTO `club` VALUES (2591, 'AEDSN', NULL, '2020-12-28 20:31:48', 'L\'Association des Étudiant·e·s en droit social de Nanterre (AEDSN) a pour buts de tisser du lien, un réseau d\'entraide entre étudiant·es et \"alumnis\" du Master Droit Social de Nanterre, d\'organiser la remise des diplômes et des activités \"hors-les murs\" de l\'Université.', 0x31, 0x31, 0, 271, 'http://aedsn92.wixsite.com/aedsn', 'aedsn92@gmail.com', 'Université Paris Nanterre\r\nBâtiment Veil - 518\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook : AEDSN - Droit Social Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/aedsn-etudiant-e-s-en-droit-social--873088.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/aedsn_1541151130010-jpg');
INSERT INTO `club` VALUES (2601, 'AJEDA', NULL, '2020-12-28 20:31:48', 'L\'Association des Juristes Européens d\'Affaires (AJEDA) a pour objet d\'assurer la renommée du Master 2 Droit des Affaires Parcours Juriste Européen des Affaires de l\'Université Paris-Nanterre, favoriser les interactions entre étudiant·es et avec les professionnel·les ainsi que parfaire la formation juridique de ses membres par l\'organisation d\'évènements divers.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/AJEDA.ParisNanterre/', 'ajeda.parisnanterre@gmail.com', 'Université Paris Nanterre\r\n200 av. de la République\r\nMaison de l\'Étudiant·e\r\nBoîte Postale n°30\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/ajeda-juristes-europeens-d-affaires--873090.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/ajeda_1541152194113-jpg');
INSERT INTO `club` VALUES (2611, 'APX', NULL, '2020-12-28 20:31:48', 'L\'association des Publicistes de l\'Université Paris Nanterre (APX) a pour objet :\r\n\r\n1-Favoriser le lien entre les différentes promotions des Master 2 Droit public financier et Droit public général\r\n2- Promouvoir l\'activité et l\'action des étudiant·es concerné·es dans un objectif de visibilité et de réputation des diplômes\r\n3- Faciliter l\'entraide et l\'intégration entre étudiant·es via l\'organisation d\'événements\r\n4- Offrir un soutien matériel', 0x31, 0x31, 0, 271, NULL, 'associationdpgdpf@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°94\r\n200 av. de la République\r\n92000 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-des-publicistes-apx--717004.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/apx_1591685081965-jpg');
INSERT INTO `club` VALUES (2621, 'Association du Master 2 CIE', NULL, '2020-12-28 20:31:48', 'L\'association du Master 2 Contentieux International et Européen (CIE) s\'occupe de la vie du master et de ses adhérent·es en organisant des colloques, visites de cabinets et des remises de diplômes.', 0x31, 0x31, 0, 271, 'https://master2cie.info/', 'master2cienanterre@gmail.com', 'Université Paris Nanterre\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-du-master-2-cie-751937.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-m2_1587374040088-png');
INSERT INTO `club` VALUES (2631, 'Association du Master 2 DACA', NULL, '2020-12-28 20:31:48', 'Association du Master 2 Droit des Affaires - Contentieux des Affaires\r\n\r\nL\'association tend à établir des relations personnelles, régulières et dynamiques entre étudiant·es et anciens étudiant·es du master II professionnel de droit des affaires spécialité contentieux des affaires de l\'université Paris Nanterre, convaincus de la haute valeur du diplôme, d\'assurer la promotion du diplôme.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/master2daca', 'm2daca@gmail.com', 'Siège social : Université Paris Nanterre\r\nAdresse de gestion (postale) : 106, résidence Élysée 2 78170 La Celle Saint-Cloud', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-du-master-2-daca-833642.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-ass-m2-daca_1606396552793-jpg');
INSERT INTO `club` VALUES (2641, 'Common West', NULL, '2020-12-28 20:31:48', 'Association de la bi-licence Droit Français / Common Law\r\n\r\nCommon West est l\'association des étudiant·es de la bi-licence Droit français / Common Law. Dans un esprit d\'entraide et de soutien, nous organisons parrainages, conférences, visites et voyages, mais nous tenons également à participer à la bonne ambiance sur le campus, parfois en partenariat avec d\'autres associations, en promouvant la culture anglo-saxonne.', 0x31, 0x31, 0, 271, 'http://commonwest.com', 'commonwest.asso@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (bât. R)\r\nBoîte Postale n° 43\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook Common West', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/common-west-553610.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-common-west_1605886790539-png');
INSERT INTO `club` VALUES (2651, 'ELSA Paris Nanterre', NULL, '2020-12-28 20:31:48', 'L\'association ELSA Paris Nanterre est l\'association européenne des étudiant·es en droit, association apolitique présente dans 44 pays européens et comptant 50 000 adhérent·es.\r\nElle a pour objectif :\r\n- de contribuer à la formation juridique des étudiant·e·s en droit\r\n- favoriser et intensifier la coopération entre les étudiant·e·s en droit\r\n- permettre la rencontre entre étudiant·es et professionnel·les du droit (séminaires, colloques et voyages d\'étude).', 0x31, 0x31, 0, 271, 'https://www.facebook.com/elsaparisnanterre/', 'nanterre@fr.elsa.org', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte Postale n°58\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/elsa-paris-nanterre-792904.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/elsa_1530086674566-png');
INSERT INTO `club` VALUES (2661, 'Istya', NULL, '2020-12-28 20:31:48', 'Cette association a pour objet de mettre en lumière les différentes professions liées au domaine juridique, cela par le biais d\'interviews. Dans chaque vidéo, un professionnel du droit sera interrogé sur différents points tel que l\'accès à la profession, les avantages / inconvénients... Des questions liées à l\'actualité pourront également être abordées afin de comparer leurs analyses.', 0x31, 0x31, 0, 271, 'https://www.instagram.com/istyassociation/', 'istya.association@hotmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°87\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/istya--948729.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2671, 'Juris Club Paris Ouest', NULL, '2020-12-28 20:31:49', 'L\'association Juris Club Paris Ouest vise à la représentation et la mobilisation des étudiants en droit autour de la mise en place d\'une permanence juridique gratuite et bénévole accessible à tous, tenue par des étudiants avec le concours et la supervision de professeurs et avocats.', 0x31, 0x31, 0, 271, 'https://jurisclubparisouest.wordpress.com/', 'jurisclub.parisouest@outlook.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant (Bât. R)\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook : Juris Club Paris Ouest', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/juris-club-paris-ouest-547593.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-juris_1606739131629-jpg');
INSERT INTO `club` VALUES (2681, 'La Convention de Nanterre', NULL, '2020-12-28 20:31:49', 'Cette association a pour but l\'organisation et la diffusion de débats, de conférences et d\'entretiens alliant le milieu universitaire juridique et les personnalités publiques.', 0x31, 0x31, 0, 271, NULL, 'laconventiondenanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°84\r\n200 av. de la République\r\n92001 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-convention-de-nanterre-930711.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/cdn_1568015137568-png');
INSERT INTO `club` VALUES (2691, 'Lame de Fond', NULL, '2020-12-28 20:31:49', 'La Lame de Fond, association sans couleur politique, forte de ses 37 ans d\'ancienneté au sein de l\'UFR de Droit, est un pourvoyeur de distraction de l\'Université. Elle a pour but d\'animer la vie étudiante sur le campus de l\'Université.\r\nElle organise des événements tels que le week-end d\'intégration, et plusieurs soirées dont la célèbre soirée d\'Halloween... Par ailleurs, elle organise aussi des événements sur le campus pour permettre une certaine cohésion entre les étudiant·e·s (barbecues, activités sur les pelouses etc.).\r\nCette association participe à la vie étudiante et aide chacun et chacune à sortir de l\'anonymat et à grandir pleinement au sein de l\'Université. Elle exprime une volonté implacable de transmettre ses valeurs étudiantes que sont le partage, la liberté d\'expression ainsi que l\'acceptation de sa prochaine ou son prochain.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/Assolamedefond?fref=ts', 'lame.de.fond@live.fr', 'Université Paris Nanterre\r\nBâtiment Simone Veil\r\nLocal 214 bis\r\n200 Avenue de la République\r\n92000 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/lame-de-fond-536200.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1401819961347-jpg');
INSERT INTO `club` VALUES (2701, 'La Vieille de Nanterre', NULL, '2020-12-28 20:31:49', 'La Vieille de Nanterre (anciennement MBDE), fondée en 1987, a pour but d\'animer la vie étudiante de l\'Université. Elle organise la soirée de Noël, le Gala de fin d\'année, des conférences juridiques et autres, des barbecues, des afterworks ainsi que le week-end d\'intégration.\r\nElle met également à disposition des étudiant.e.s en droit et autres filières le site droitdesavoir qui répertorie les annales des UFR ainsi que des conférences avec des professionnels du droit et autres.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/LaVieilleDeNanterre', 'lavieilledenanterre@gmail.com', 'Université Paris Nanterre\r\nBoîte postale : Maison de l\'Étudiant·e - BP n°63\r\nLocal : Bâtiment Veil - F214\r\n200 Avenue de la République\r\n92000 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/la-vieille-de-nanterre-ex-mbde--536408.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1505220439733-png');
INSERT INTO `club` VALUES (2711, 'Le Juristicier', NULL, '2020-12-28 20:31:49', 'Le juristicier est une association de droit.\r\nSon but est d\'apporter un aspect pratique du droit en parallèle du côté théorique qu\'offre l\'Université. Pour cela, elle organisera des rencontres entre praticien·nes et étudiant·es sur des aspects techniques (comment réussir le concours de l\'ENM ou du Barreau ? En quoi consiste réellement le métier d\'avocat d\'affaire?...).\r\nAussi, l\'association tiendra une gazette juridique mensuelle.', 0x31, 0x31, 0, 271, NULL, 'lejuristicier@outlook.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°88\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/le-juristicier-950111.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2721, 'Themis Paris Nanterre', NULL, '2020-12-28 20:31:49', 'L\'association Thémis aide les étudiants et étudiantes en droit à trouver leur voie.\r\nPour cela, nous organisons des rencontres entre professionnels du droit et étudiant·es lors de conférences. Nous permettons également aux étudiant·es de licence et de master d\'échanger sur les différents parcours possibles lors de cafés master. Enfin, nous présentons les études de droit dans les lycées.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/themisparisnanterre', 'themisparisnanterre@gmail.com', 'Université Paris Nanterre Maison de l\'Étudiant·e\r\nBP n°78\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/themis-paris-nanterre-906828.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-2020_1600672509517-jpg');
INSERT INTO `club` VALUES (2731, 'AFAGE', NULL, '2020-12-28 20:31:49', 'AFAGE : Association Franco-Allemande en Gestion et en Économie\r\n\r\nL\'AFAGE a pour objectif de promouvoir le cursus intégré franco-allemand en sciences économiques / gestion ainsi que le double master en management franco allemand de PME et entreprenariat.', 0x31, 0x31, 0, 271, 'https://ecofrall.com/afage', 'info.afage@gmail.com', 'Adresse postale :\r\nUniversité Paris Nanterre\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook : @assofrancoallemandegestioneconomie', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-franco-allemande-en-gestion--750331.kjsp', 'https://culture.parisnanterre.fr/medias/photo/afage_1594640224269-png');
INSERT INTO `club` VALUES (2741, 'AEMEDN', NULL, '2020-12-28 20:31:49', 'L\'Association des Étudiant·es du Master d\'Economie du Droit de l\'Université Paris Nanterre (AEMEDN) a pour objet d\'aider les étudiant·es du master pour la recherche de stage, l\'entraide entre le Master 1 et le Master 2, de conserver des liens entre ses membres nouveaux et anciens, et de promouvoir l\'association à travers son site internet et des conférences.', 0x31, 0x31, 0, 271, 'http://mastereconomiedudroit.fr/category/presentation/lassociation/', 'aed.upond@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n° (à venir)\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/association-master-d-economie-du-droit-988465.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-clean_1605513432002-png');
INSERT INTO `club` VALUES (2751, 'Eden Miage', NULL, '2020-12-28 20:31:50', 'Etudiants DE Nanterre en MIAGE (EDEN MIAGE)\r\nLe BDE MIAGE Nanterre est une association étudiante qui a pour principal but d\'animer la vie des étudiant·es du parcours MIAGE.', 0x31, 0x31, 0, 271, 'bde.miagenanterre.fr', 'president@bde.miagenanterre.fr', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°93\r\n200 avenue de la République\r\n92001 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/bde-miage-nanterre-alias-eden-miage-531017.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1581429817311-jpg');
INSERT INTO `club` VALUES (2761, 'Paris Nanterre Finance Club', NULL, '2020-12-28 20:31:50', 'Le Paris Nanterre Finance Club est ne´ il y a maintenant plus d\'un an, et s\'est construit autour d\'un constat simple : l\'universite´ Paris Nanterre est tre`s proche du plus grand centre d\'affaires europe´en, mais rien ne les lie. Le but de notre association est de faciliter l\'insertion professionnelle des e´le`ves dans les domaines de la Finance, le conseil, le management et la strate´gie. Pour ce, nous nous efforc¸ons de ba^tir un re´seau solide et de pre´parer les e´le`ves aux futurs me´tiers qu\'ils exerceront.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/Nanterre.financeclub/', 'financeclub.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e (Bâtiment R)\r\nBoîte postale n°25\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/paris-nanterre-finance-club-824066.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/p-finance-club_1520238489031-jpeg');
INSERT INTO `club` VALUES (2771, 'Les Alhumés', NULL, '2020-12-28 20:31:50', 'L\'association Les Alhumés a pour vocation de rapprocher les étudiants de la licence Humanités tout en s\'ouvrant à l\'ensemble de l\'université. Elle souhaite élargir l\'horizon culturel des étudiants en proposant des tarifs réduits (concerts, théâtre, festival, expositions…) et en les soutenant dans l\'élaboration de projets. Enfin, elle participe à dynamiser la vie étudiante du campus lors d\'apéros-concerts ouverts à tous.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/Les-Alhum%C3%A9s-Licence-Humanit%C3%A9s-825874720804437', 'les.alhumes@gmail.com', 'Université Paris Nanterre\r\n200 avenue de la République\r\nMaison de l\'Étudiant (bât. R)\r\nLocal 106\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/les-alhumes-524811.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/alhumes_1510065141327-png');
INSERT INTO `club` VALUES (2781, 'Ciné Rebelle', NULL, '2020-12-28 20:31:50', 'Cette association a pour but l\'organisation du festival Ciné Rebelle, un festival de cinéma engagé et organisé dans le cadre du TD de programmation. Notre ligne directrice : sortir des sentiers battus.', 0x31, 0x31, 0, 271, 'https://festivalcinerebelle.com/', 'cinerebelle@gmail.com', 'Maison de l\'Étudiant·e\r\nBoîte postale n°79\r\nUniversité Paris Nanterre\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook Festival Ciné-Rebelle', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/cine-rebelle-914775.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-cine-rebelle_1573825622649-jpg');
INSERT INTO `club` VALUES (2791, 'Association d\'Ergonomie, de Psychologie du Travail et de l\'Orientation (AEPTO)', NULL, '2020-12-28 20:31:50', 'L\'Association de Psychologie du Travail et d\'Ergonomie de Paris Nanterre a pour but de valoriser les formations de Master en Ergonomie, en Psychologie du travail et des organisations et en Psychologie de l\'Orientation de l\'Université Paris Nanterre. L\'association souhaite augmenter la visibilité de ces formations auprès des étudiants de Licence de Psychologie. L\'association cherche également à constituer un réseau entre les étudiants et les anciens étudiants issus de cette formation.', 0x31, 0x31, 0, 271, NULL, 'ergopsyori@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°95\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/apte-x-981453.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-apte-x_1605278184936-png');
INSERT INTO `club` VALUES (2801, 'Psych\'X', NULL, '2020-12-28 20:31:50', 'Cette association a pour objet d\'accompagner les étudiant·es de la filière de psychologie durant leur parcours universitaire et ce par différents moyens :\r\n- La représentation des étudiant·es auprès de l\'université et d\'entités extérieures\r\n- La prévention en mettant en place divers événements de sensibilisations sur la santé\r\n- La culture en proposant des activités permettant l\'ouverture d\'esprit\r\n- Le divertissement par le biais de divers événements festifs afin de fédérer les étudiants.', 0x31, 0x31, 0, 271, 'psychx.paris10@gmail.com', 'psychx.paris10@gmail.com', NULL, 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/psych-x-676495.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/psychx_1513608489301-png');
INSERT INTO `club` VALUES (2811, 'ASEGA', NULL, '2020-12-28 20:31:50', 'Association Solidaire des Étudiants en Gestion Associative\r\nL\'associatio ASEGA est l\'association des étudiants de la Licence professionelle Gestion des organisations de l\'Economie Sociale et solidaire de l\'Université de Paris Nanterre. Elle poursuit de nombreux but dont : De réaliser et soutenir des actions en lien avec la vie associative / de véhiculer de valeurs de solidarité. Le projet important de l\'ASEGA est la gestion de l\'épicerie sociale AGORAé.', 0x31, 0x31, 0, 271, NULL, 'asega92parisnanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale 57\r\n200 avenue de la République\r\n92001 Nanterre Cedex\r\n\r\nMail de l\'épicerie solidaire : agoraeparisnanterre@gmail.com\r\nPage Facebook : Epicerie Solidaire AGORAé Paris Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/asega-772394.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-asega_1495199631366-jpg');
INSERT INTO `club` VALUES (2821, 'ENAPE', NULL, '2020-12-28 20:31:50', 'Etudiant-e-s de Nanterre en Anthropologie, Préhistoire et Ethnomusicologie (ENAPE)\r\nL\'association a pour but de réunir les étudiant·e·s de la filière d\'anthropologie, et de nourrir une réflexion critique et transciplinaire sur les disciplines de l\'anthropologie, de l\'ethnomusicologie et de la préhistoire.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/ENAPEnanterre/', 'enape.parisnanterre@gmail.com', 'Université Paris Nanterre\r\nBureau E111 - Bâtiment Clémence Ramnoux\r\n200 avenue de la République\r\n9200 Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/enape-820401.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/enape_1516095163740-jpg');
INSERT INTO `club` VALUES (2831, 'Hypothémuse', NULL, '2020-12-28 20:31:51', 'Association des étudiants du Master 2 Conduite de projets culturels et connaissance des publics\r\n\r\nL\'association Hypothémuse a pour principal objectif la valorisation du Master 2 \"Conduite de projets culturels et connaissance des publics\". Acteur à part entière de la vie de l\'Université, l\'association organise chaque année un grand festival pluridisciplinaire et gratuit sur l\'ensemble du campus de Nanterre, à destination des étudiants, du personnel et du corps enseignant.', 0x31, 0x31, 0, 271, 'http://hypothemuse.org', 'hypothemuse@gmail.com', 'Université Paris Nanterre\r\nUFR SSA\r\nBat.Henri Lefebve - bureau 212b\r\n200, avenue de la République\r\n92000 NANTERRE\r\n\r\nPage Facebook : Les Marmites Artistiques', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/hypothemuse-524122.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-hypothemuse_1396536200485-jpg');
INSERT INTO `club` VALUES (2841, 'Kleio', NULL, '2020-12-28 20:31:51', 'Association des étudiants en Histoire\r\n\r\nL\'association Kléio s\'adresse aux étudiants et étudiantes de toutes disciplines intéressés par l\'histoire, et se consacre à la mise en œuvre de projets culturels et à l\'organisation d\'événements conviviaux sur le campus, dans la ville de Nanterre et au-delà.', 0x31, 0x31, 0, 271, 'https://kleionanterre.jimdo.com/', 'kleio.nanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte postale n°76\r\n200 av. de la République\r\n92001 Nanterre Cedex\r\n\r\nPage Facebook Kleio Nanterre', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/kleio-646539.kjsp?RH=1390831346216&RF=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/kleio-logo_1574171580434-png');
INSERT INTO `club` VALUES (2851, 'Urb\'UN', NULL, '2020-12-28 20:31:51', 'Urb\'un est une association de filière qui agit pour la cohésion du master d\'urbanisme de l\'université de Nanterre, entre les promotions et le corps enseignant. Elle organise notamment un voyage d\'étude, des rencontres entre étudiants et professionnels de l\'urbanisme ou encore la maintenance du site internet du master.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/urbuniste/', 'urbun.contact@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte Postale n°85\r\n200 av. de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/urb-un-930725.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-urb-un-officiel_1567786937168-jpg');
INSERT INTO `club` VALUES (2861, 'ADVEVA', NULL, '2020-12-28 20:31:51', 'Association pour le Développement de Véhicules Economes à Ville d\'Avray\r\n\r\nL\'association développe des véhicules électriques à basse consommation d\'énergie. Nous nous rendons à plusieurs compétitions annuelles organisées en France ou à l\'étranger. Le but de ces compétitions est de réaliser, sous forme de course automobile, la consommation d\'énergie la plus faible parmi tous les véhicules participants.', 0x31, 0x31, 0, 271, 'https://fr-fr.facebook.com/ADVEVA92/', 'adveva92@gmail.com', 'IUT de Ville d\'Avray\r\nLocal ADVEVA\r\n50 rue de Sèvres\r\n92410 Ville d\'Avray', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/adveva-523976.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-officiel-adveva_1573224278450-png');
INSERT INTO `club` VALUES (2871, 'BDE La Piste', NULL, '2020-12-28 20:31:51', 'Le BDE La Piste est une association étudiante qui a pour objectif de permettre aux étudiant·e·s de l\'IUT de Ville d\'Avray, préparant un DUT sur le campus de Nanterre, de se réunir en dehors des heures de cours et de faciliter leur intégration dans la vie étudiante qui anime les DUT GEA et CS et, plus globalement, l\'ensemble des filières de l\'IUT de Ville d\'Avray/Saint-Cloud/Nanterre.', 0x31, 0x31, 0, 271, 'https://fb.me/bde.lapiste', 'bde.lapiste@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e BP71\r\n200 avenue de la République\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/bde-la-piste-898852.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/la-piste_1552046000461-png');
INSERT INTO `club` VALUES (2881, 'BDE Owl Night Long', NULL, '2020-12-28 20:31:51', 'BDE du pôle Métiers du livre de l\'IUT de Saint-Cloud\r\nPromotion de la culture, intégration sociale et professionnelle des futurs diplômés, la solidarité et l\'intégration sociale, la solidarité et les échanges entre étudiants, anciens et futurs élèves ainsi qu\'avec les enseignants.', 0x31, 0x31, 0, 271, 'https://www.facebook.com/OWLBDE/', 'bde.owlnightlong@gmail.com', '11 avenue Pozzo di Borgo, 92210 Saint-Cloud', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/bde-owl-night-long-892689.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/bde-owl_1549640089391-jpg');
INSERT INTO `club` VALUES (2891, 'BDE VDA', NULL, '2020-12-28 20:31:51', 'Bureau des Elèves du pôle sciences et technique de Ville d\'Avray (BDE VDA) aussi appelé BDE Old Bar\'hell', 0x31, 0x31, 0, 271, 'https://www.facebook.com/BDE-Old-Barhell-294615601257166/', 'bde.oldbarhell@gmail.com', '50 rue de Sèvres 92410 Ville d\'Avray', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/bde-vda-917923.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo-bde-ville-d-avray_1560512463938-png');
INSERT INTO `club` VALUES (2901, 'Together Connected', NULL, '2020-12-28 20:31:51', 'Dans le cadre des projets tuteurés, l\'association des étudiants du Département Techniques de Commercialisation (TC) de l\'IUT Ville d\'Avray / Nanterre est chargée de promouvoir le département, animer la vie des étudiant·es et permettre une meilleure intégration des nouveaux et nouvelles étudiant·es à travers l\'organisation de toute manifestation culturelle, de loisirs et sportive dans le respect des valeurs de l\'université. Un bureau, élu et renouvelé tous les ans par l\'ensemble des étudiant·es du département veillera à aider et soutenir les étudiants du Département en gérant toute activité nécessaire.', 0x31, 0x31, 0, 271, 'https://www.instagram.com/bde.tcnanterre/', 'bde.tcnanterre@gmail.com', 'Université Paris Nanterre\r\nMaison de l\'Étudiant·e\r\nBoîte Postale n°59\r\n92001 Nanterre Cedex', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/together-connected-tc--981328.kjsp?RH=1390831346216', NULL);
INSERT INTO `club` VALUES (2911, 'Association des Jeunes Chercheurs de Nanterre E.D. 395 (AJCN 395)', NULL, '2020-12-28 20:31:51', 'Association des Jeunes Chercheurs de Nanterre E.D. 395\r\n\r\nL\'association organise des ateliers scientifiques et méthodologiques et aide ses membres à en organiser. Elle participe à l\'organisation de colloques (doctorants, MAE) et à la présentation du doctorat aux étudiants de Master une fois par an.', 0x31, 0x31, 0, 271, 'ajcn395.parisnanterre.fr', 'ajcn395@gmail.com', 'Université Paris Nanterre\r\nBâtiment A - bureau A306B\r\n200 avenue de la République\r\n92001 Nanterre\r\n\r\nPage Facebook : AJCN 395', 'https://culture.parisnanterre.fr/associations/annuaire-des-associations-etudiantes/ajcn-395-676617.kjsp?RH=1390831346216', 'https://culture.parisnanterre.fr/medias/photo/logo_1463581423965-jpg');

-- ----------------------------
-- Table structure for club_publication
-- ----------------------------
DROP TABLE IF EXISTS `club_publication`;
CREATE TABLE `club_publication`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `date` datetime(0) NOT NULL,
  `club_id` int(11) NOT NULL,
  `isEdited` binary(1) NOT NULL DEFAULT '\0',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `club_id`(`club_id`) USING BTREE,
  CONSTRAINT `club_publication_ibfk_1` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8081 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of club_publication
-- ----------------------------
INSERT INTO `club_publication` VALUES (4511, 'publication #CLZ1G9UTPRNOSGY7 du club 2081', '2020-04-14 00:00:00', 2081, 0x00);
INSERT INTO `club_publication` VALUES (4521, 'publication #8JUTN731OAHEA058 du club 2081', '2019-08-10 00:00:00', 2081, 0x00);
INSERT INTO `club_publication` VALUES (4531, 'publication #HXJDQ6PIDRGSXNMI du club 2081', '2020-10-16 00:00:00', 2081, 0x00);
INSERT INTO `club_publication` VALUES (4541, 'publication #XW88LFXR4AFC43YF du club 2091', '2020-06-11 00:00:00', 2091, 0x00);
INSERT INTO `club_publication` VALUES (4551, 'publication #RNQSTE470A8XBV4U du club 2091', '2019-06-14 00:00:00', 2091, 0x00);
INSERT INTO `club_publication` VALUES (4561, 'publication #1V4BXHVA63BVUBGO du club 2101', '2019-03-07 00:00:00', 2101, 0x00);
INSERT INTO `club_publication` VALUES (4571, 'publication #SJF8MZ4HARA22TIQ du club 2101', '2019-10-25 00:00:00', 2101, 0x00);
INSERT INTO `club_publication` VALUES (4581, 'publication #QWU5XKNP5DXB1O9T du club 2111', '2019-02-12 00:00:00', 2111, 0x00);
INSERT INTO `club_publication` VALUES (4591, 'publication #XR7XN7DP5BDXZTBA du club 2111', '2020-02-17 00:00:00', 2111, 0x00);
INSERT INTO `club_publication` VALUES (4601, 'publication #8RLRFUTU6BY8DFXM du club 2111', '2019-09-21 00:00:00', 2111, 0x00);
INSERT INTO `club_publication` VALUES (4611, 'publication #GXHLCFRGHKXJ1A01 du club 2121', '2019-05-31 00:00:00', 2121, 0x00);
INSERT INTO `club_publication` VALUES (4621, 'publication #GAIZMV01THXW28X8 du club 2121', '2019-06-04 00:00:00', 2121, 0x00);
INSERT INTO `club_publication` VALUES (4631, 'publication #XWOHZ4VZYKBB2D3X du club 2131', '2021-02-10 00:00:00', 2131, 0x00);
INSERT INTO `club_publication` VALUES (4641, 'publication #CS33JIASA9B37LVI du club 2131', '2019-12-01 00:00:00', 2131, 0x00);
INSERT INTO `club_publication` VALUES (4651, 'publication #35AD282FY1PJD44P du club 2131', '2019-12-10 00:00:00', 2131, 0x00);
INSERT INTO `club_publication` VALUES (4661, 'publication #KJH9ODRVDYH9OHUN du club 2131', '2019-05-28 00:00:00', 2131, 0x00);
INSERT INTO `club_publication` VALUES (4671, 'publication #IBLC2X7HL4W0QO36 du club 2141', '2019-08-16 00:00:00', 2141, 0x00);
INSERT INTO `club_publication` VALUES (4681, 'publication #IX630W8MY58I6GD0 du club 2141', '2019-02-06 00:00:00', 2141, 0x00);
INSERT INTO `club_publication` VALUES (4691, 'publication #ZVKS39AVCC5Y2JWA du club 2151', '2020-07-16 00:00:00', 2151, 0x00);
INSERT INTO `club_publication` VALUES (4701, 'publication #N5N3FSQOSCITG9MN du club 2151', '2020-05-12 00:00:00', 2151, 0x00);
INSERT INTO `club_publication` VALUES (4711, 'publication #3CKJZUWN6PX0LXP6 du club 2171', '2019-08-13 00:00:00', 2171, 0x00);
INSERT INTO `club_publication` VALUES (4721, 'publication #3KBLADB0Y50XHH53 du club 2171', '2020-02-25 00:00:00', 2171, 0x00);
INSERT INTO `club_publication` VALUES (4731, 'publication #6O9JYAHOFMGK2XFJ du club 2171', '2021-02-03 00:00:00', 2171, 0x00);
INSERT INTO `club_publication` VALUES (4741, 'publication #NNVNGAFJX005RYAM du club 2181', '2021-01-02 00:00:00', 2181, 0x00);
INSERT INTO `club_publication` VALUES (4751, 'publication #QOG7FNN1UARDXSPF du club 2181', '2020-12-06 00:00:00', 2181, 0x00);
INSERT INTO `club_publication` VALUES (4761, 'publication #UUCPAB5SM8RBRXU8 du club 2181', '2020-04-12 00:00:00', 2181, 0x00);
INSERT INTO `club_publication` VALUES (4771, 'publication #XSSMCN3BYHP7Z3GN du club 2191', '2019-04-08 00:00:00', 2191, 0x00);
INSERT INTO `club_publication` VALUES (4781, 'publication #4NOIZXAUQ13XSLK9 du club 2191', '2021-01-09 00:00:00', 2191, 0x00);
INSERT INTO `club_publication` VALUES (4791, 'publication #WEWZGG86JAG7RVGY du club 2201', '2020-06-30 00:00:00', 2201, 0x00);
INSERT INTO `club_publication` VALUES (4801, 'publication #WNCA19OCYT2DQ8WI du club 2201', '2020-01-30 00:00:00', 2201, 0x00);
INSERT INTO `club_publication` VALUES (4811, 'publication #GZKRQH1EIWI6TFWD du club 2201', '2019-12-09 00:00:00', 2201, 0x00);
INSERT INTO `club_publication` VALUES (4821, 'publication #7LY40BUPK4XCQPJL du club 2221', '2020-05-23 00:00:00', 2221, 0x00);
INSERT INTO `club_publication` VALUES (4831, 'publication #37JFUBHD4GP01BRE du club 2231', '2019-02-08 00:00:00', 2231, 0x00);
INSERT INTO `club_publication` VALUES (4841, 'publication #18EKU1QBTPL5LHHJ du club 2241', '2020-03-31 00:00:00', 2241, 0x00);
INSERT INTO `club_publication` VALUES (4851, 'publication #NHADEF3VQZMQ54SC du club 2241', '2020-10-23 00:00:00', 2241, 0x00);
INSERT INTO `club_publication` VALUES (4861, 'publication #T3VXO599DH7FRQHL du club 2241', '2021-01-16 00:00:00', 2241, 0x00);
INSERT INTO `club_publication` VALUES (4871, 'publication #730MAH331ZYFY609 du club 2251', '2020-12-17 00:00:00', 2251, 0x00);
INSERT INTO `club_publication` VALUES (4881, 'publication #Y36T4UIR6HJW3T4I du club 2251', '2020-09-20 00:00:00', 2251, 0x00);
INSERT INTO `club_publication` VALUES (4891, 'publication #2F3GC139V5ZCR8DV du club 2261', '2019-06-26 00:00:00', 2261, 0x00);
INSERT INTO `club_publication` VALUES (4901, 'publication #WK720XWD81J6FGI8 du club 2271', '2020-12-24 00:00:00', 2271, 0x00);
INSERT INTO `club_publication` VALUES (4911, 'publication #HHH80A64B75Z08KD du club 2281', '2020-06-15 00:00:00', 2281, 0x00);
INSERT INTO `club_publication` VALUES (4921, 'publication #KNRTS33IHU7X3ZBU du club 2281', '2019-03-18 00:00:00', 2281, 0x00);
INSERT INTO `club_publication` VALUES (4931, 'publication #ROGQCSRH4TO4XDU7 du club 2281', '2020-09-20 00:00:00', 2281, 0x00);
INSERT INTO `club_publication` VALUES (4941, 'publication #6852NVY5N09FER2V du club 2281', '2020-07-24 00:00:00', 2281, 0x00);
INSERT INTO `club_publication` VALUES (4951, 'publication #VWX4WGJUGSUIL87F du club 2291', '2020-03-01 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (4961, 'publication #VQB7Z8K7OYLD0W0H du club 2291', '2019-08-06 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (4971, 'publication #96SPL7SED5PHRGMH du club 2291', '2019-10-03 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (4981, 'publication #ZSJIX45L85D6NXHY du club 2291', '2020-03-10 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (4991, 'publication #TB6J8AC7IOXS6E5U du club 2291', '2019-10-16 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (5001, 'publication #FEUCUPFCE33ZUR0Z du club 2291', '2019-06-29 00:00:00', 2291, 0x00);
INSERT INTO `club_publication` VALUES (5011, 'publication #VPI07QZT956C2MHH du club 2301', '2019-09-03 00:00:00', 2301, 0x00);
INSERT INTO `club_publication` VALUES (5021, 'publication #LK2L6I926M5NTNU9 du club 2301', '2020-09-11 00:00:00', 2301, 0x00);
INSERT INTO `club_publication` VALUES (5031, 'publication #SCMA1SI03PSOAZRP du club 2301', '2020-04-13 00:00:00', 2301, 0x00);
INSERT INTO `club_publication` VALUES (5041, 'publication #1Z70NWYWBMHK9ZS5 du club 2311', '2019-11-16 00:00:00', 2311, 0x00);
INSERT INTO `club_publication` VALUES (5051, 'publication #RAK8YCXDUG47JH9L du club 2321', '2020-02-03 00:00:00', 2321, 0x00);
INSERT INTO `club_publication` VALUES (5061, 'publication #94P9OQQI057H7Q2F du club 2321', '2019-02-18 00:00:00', 2321, 0x00);
INSERT INTO `club_publication` VALUES (5071, 'publication #2XN46QT2H8LK5TZ0 du club 2331', '2019-10-01 00:00:00', 2331, 0x00);
INSERT INTO `club_publication` VALUES (5081, 'publication #UDPKRQGOPAZE2GL7 du club 2331', '2021-01-09 00:00:00', 2331, 0x00);
INSERT INTO `club_publication` VALUES (5091, 'publication #6BTUNMGFIJ7P31IB du club 2331', '2020-09-30 00:00:00', 2331, 0x00);
INSERT INTO `club_publication` VALUES (5101, 'publication #WWFW0X54NM1CGPJX du club 2341', '2020-05-29 00:00:00', 2341, 0x00);
INSERT INTO `club_publication` VALUES (5111, 'publication #36DJ2NXPH67FQX8C du club 2341', '2021-02-23 00:00:00', 2341, 0x00);
INSERT INTO `club_publication` VALUES (5121, 'publication #OZSL4V0CT9QV7Y7S du club 2341', '2020-01-11 00:00:00', 2341, 0x00);
INSERT INTO `club_publication` VALUES (5131, 'publication #TKZ0YYL8VM1U7K26 du club 2341', '2019-11-09 00:00:00', 2341, 0x00);
INSERT INTO `club_publication` VALUES (5141, 'publication #17XG3SW2G1VB6BO3 du club 2351', '2019-01-19 00:00:00', 2351, 0x00);
INSERT INTO `club_publication` VALUES (5151, 'publication #SU2U57Y5XY0SGQAJ du club 2351', '2021-01-08 00:00:00', 2351, 0x00);
INSERT INTO `club_publication` VALUES (5161, 'publication #9FKBTY4G6ZKX7BQQ du club 2361', '2020-04-04 00:00:00', 2361, 0x00);
INSERT INTO `club_publication` VALUES (5171, 'publication #D60D9DPEYLRNXNG4 du club 2361', '2019-04-27 00:00:00', 2361, 0x00);
INSERT INTO `club_publication` VALUES (5181, 'publication #WQCRMXBDDFBWDNUP du club 2371', '2019-11-13 00:00:00', 2371, 0x00);
INSERT INTO `club_publication` VALUES (5191, 'publication #ODUJMWDMST94Y7CH du club 2371', '2020-05-04 00:00:00', 2371, 0x00);
INSERT INTO `club_publication` VALUES (5201, 'publication #A5GAVWZWT42UJ4WF du club 2371', '2020-02-19 00:00:00', 2371, 0x00);
INSERT INTO `club_publication` VALUES (5211, 'publication #CJJHVQUHLI2KM13P du club 2371', '2019-09-05 00:00:00', 2371, 0x00);
INSERT INTO `club_publication` VALUES (5221, 'publication #JCGCFXWFO6YUKL8Y du club 2381', '2020-02-20 00:00:00', 2381, 0x00);
INSERT INTO `club_publication` VALUES (5231, 'publication #GK4H5PB2BJTWCZ9G du club 2381', '2020-11-08 00:00:00', 2381, 0x00);
INSERT INTO `club_publication` VALUES (5241, 'publication #3EEKK5L8CV6JJUND du club 2391', '2020-10-17 00:00:00', 2391, 0x00);
INSERT INTO `club_publication` VALUES (5251, 'publication #5R7PWCP9QPXLCSBL du club 2391', '2021-02-22 00:00:00', 2391, 0x00);
INSERT INTO `club_publication` VALUES (5261, 'publication #ISUJPLZUYE9UEPNM du club 2391', '2019-05-29 00:00:00', 2391, 0x00);
INSERT INTO `club_publication` VALUES (5271, 'publication #BYWPFFQ82WXJHUK6 du club 2391', '2020-09-01 00:00:00', 2391, 0x00);
INSERT INTO `club_publication` VALUES (5281, 'publication #0J5AS9P925RWKWMZ du club 2401', '2019-07-14 00:00:00', 2401, 0x00);
INSERT INTO `club_publication` VALUES (5291, 'publication #SU0C0N2FQRQD3FCI du club 2401', '2019-11-04 00:00:00', 2401, 0x00);
INSERT INTO `club_publication` VALUES (5301, 'publication #V17TX89KFWQRTNY8 du club 2411', '2020-05-03 00:00:00', 2411, 0x00);
INSERT INTO `club_publication` VALUES (5311, 'publication #LQLU6XJ3IMMLW7H1 du club 2411', '2019-07-11 00:00:00', 2411, 0x00);
INSERT INTO `club_publication` VALUES (5321, 'publication #X2AXWD5GZVWQ9X8Z du club 2421', '2020-04-25 00:00:00', 2421, 0x00);
INSERT INTO `club_publication` VALUES (5331, 'publication #BFJS8I4CGWQWIXOP du club 2421', '2020-03-26 00:00:00', 2421, 0x00);
INSERT INTO `club_publication` VALUES (5341, 'publication #I33G3KYKERWZTUO9 du club 2421', '2020-01-02 00:00:00', 2421, 0x00);
INSERT INTO `club_publication` VALUES (5351, 'publication #11V4BCV8Y8FSKCOB du club 2421', '2019-05-29 00:00:00', 2421, 0x00);
INSERT INTO `club_publication` VALUES (5361, 'publication #VIJ01TY1LTXAXJBE du club 2431', '2020-06-23 00:00:00', 2431, 0x00);
INSERT INTO `club_publication` VALUES (5371, 'publication #FCDOGCIEQYPFCH17 du club 2441', '2019-02-09 00:00:00', 2441, 0x00);
INSERT INTO `club_publication` VALUES (5381, 'publication #2AC9O9Q71DT6P37K du club 2441', '2020-06-19 00:00:00', 2441, 0x00);
INSERT INTO `club_publication` VALUES (5391, 'publication #A1V5DIZO8S1PYPH9 du club 2451', '2019-02-27 00:00:00', 2451, 0x00);
INSERT INTO `club_publication` VALUES (5401, 'publication #EGMY7JJ3ZDYYU4Z8 du club 2461', '2020-09-05 00:00:00', 2461, 0x00);
INSERT INTO `club_publication` VALUES (5411, 'publication #R9AMZ9MW4S6LINRW du club 2471', '2020-04-17 00:00:00', 2471, 0x00);
INSERT INTO `club_publication` VALUES (5421, 'publication #DTCV0KU4L8JRTHOD du club 2471', '2021-03-05 00:00:00', 2471, 0x00);
INSERT INTO `club_publication` VALUES (5431, 'publication #SVESY281WHVYWJVH du club 2471', '2021-03-18 00:00:00', 2471, 0x00);
INSERT INTO `club_publication` VALUES (5441, 'publication #5MPDTX4UG3IR7A39 du club 2481', '2020-04-24 00:00:00', 2481, 0x00);
INSERT INTO `club_publication` VALUES (5451, 'publication #THVCF35D0EWHL8J7 du club 2481', '2021-01-25 00:00:00', 2481, 0x00);
INSERT INTO `club_publication` VALUES (5461, 'publication #TMQHD8DHRHZTQ0LV du club 2481', '2019-06-06 00:00:00', 2481, 0x00);
INSERT INTO `club_publication` VALUES (5471, 'publication #R5TNBZO0VSQTT5HY du club 2481', '2020-08-03 00:00:00', 2481, 0x00);
INSERT INTO `club_publication` VALUES (5481, 'publication #QLK3QU15XADKOSFF du club 2501', '2020-09-01 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5491, 'publication #EH42ZI6PYLTDUR1M du club 2501', '2020-10-11 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5501, 'publication #MKENLBL3JDVBAOQZ du club 2501', '2021-02-22 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5511, 'publication #INCO7P1IYWEG0ZTO du club 2501', '2019-04-12 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5521, 'publication #CJHRG4NR8AZBBK03 du club 2501', '2021-02-15 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5531, 'publication #BIQSR1YOOVOTLGES du club 2501', '2021-01-31 00:00:00', 2501, 0x00);
INSERT INTO `club_publication` VALUES (5541, 'publication #I8R3U7I1X4FOK1IQ du club 2511', '2020-11-22 00:00:00', 2511, 0x00);
INSERT INTO `club_publication` VALUES (5551, 'publication #2ZDPGTSK14L54H6L du club 2511', '2021-01-19 00:00:00', 2511, 0x00);
INSERT INTO `club_publication` VALUES (5561, 'publication #BH4H9NA3UIT9FRIU du club 2511', '2020-10-08 00:00:00', 2511, 0x00);
INSERT INTO `club_publication` VALUES (5571, 'publication #53ZXIM4P3MWHDEU4 du club 2521', '2021-01-29 00:00:00', 2521, 0x00);
INSERT INTO `club_publication` VALUES (5581, 'publication #O1AJYG3IZE7VOVDN du club 2521', '2020-09-21 00:00:00', 2521, 0x00);
INSERT INTO `club_publication` VALUES (5591, 'publication #VB248EFCUH4QTXQU du club 2521', '2019-12-20 00:00:00', 2521, 0x00);
INSERT INTO `club_publication` VALUES (5601, 'publication #8LRIQL485LF32JVA du club 2521', '2019-09-08 00:00:00', 2521, 0x00);
INSERT INTO `club_publication` VALUES (5611, 'publication #X9UDQ55Z6SVPNMRJ du club 2531', '2019-09-13 00:00:00', 2531, 0x00);
INSERT INTO `club_publication` VALUES (5621, 'publication #2HJOVB9JOMDFHOMB du club 2531', '2019-03-21 00:00:00', 2531, 0x00);
INSERT INTO `club_publication` VALUES (5631, 'publication #1MQ28WKY83TRWRIZ du club 2541', '2020-03-08 00:00:00', 2541, 0x00);
INSERT INTO `club_publication` VALUES (5641, 'publication #BDOV77DLB61O74TE du club 2551', '2019-05-31 00:00:00', 2551, 0x00);
INSERT INTO `club_publication` VALUES (5651, 'publication #B9VWBUSREKZIG9A6 du club 2551', '2019-11-19 00:00:00', 2551, 0x00);
INSERT INTO `club_publication` VALUES (5661, 'publication #574FN4ZYRUUFER9O du club 2551', '2019-11-01 00:00:00', 2551, 0x00);
INSERT INTO `club_publication` VALUES (5671, 'publication #CMBMD72PLWKQLSTE du club 2551', '2021-01-11 00:00:00', 2551, 0x00);
INSERT INTO `club_publication` VALUES (5681, 'publication #BKXDC7TEQEPLAGN8 du club 2551', '2021-02-01 00:00:00', 2551, 0x00);
INSERT INTO `club_publication` VALUES (5691, 'publication #0935997KRDZ9IP93 du club 2561', '2020-11-17 00:00:00', 2561, 0x00);
INSERT INTO `club_publication` VALUES (5701, 'publication #XFLOL86ULON9FY7G du club 2571', '2019-07-18 00:00:00', 2571, 0x00);
INSERT INTO `club_publication` VALUES (5711, 'publication #U68HTFSSPKF8RLYU du club 2571', '2020-02-24 00:00:00', 2571, 0x00);
INSERT INTO `club_publication` VALUES (5721, 'publication #AZPX2Y5X5RJ74BHV du club 2581', '2020-02-02 00:00:00', 2581, 0x00);
INSERT INTO `club_publication` VALUES (5731, 'publication #MSIFQ8IFE6UXBOMR du club 2581', '2019-09-17 00:00:00', 2581, 0x00);
INSERT INTO `club_publication` VALUES (5741, 'publication #A19FW7092ZUW0UNK du club 2591', '2020-11-24 00:00:00', 2591, 0x00);
INSERT INTO `club_publication` VALUES (5751, 'publication #J08HDGJPYVGZX7EU du club 2591', '2021-01-28 00:00:00', 2591, 0x00);
INSERT INTO `club_publication` VALUES (5761, 'publication #ZT8FCZ729U3KPBON du club 2601', '2019-09-28 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5771, 'publication #RK3EXPU308MMKTLR du club 2601', '2020-03-01 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5781, 'publication #B1GYTLEY40VW1FEI du club 2601', '2019-07-17 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5791, 'publication #A1K1MVMKL0TSUCDH du club 2601', '2020-12-18 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5801, 'publication #C8J20XJH8RIIJIZ1 du club 2601', '2020-09-18 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5811, 'publication #RQ2QVFHKC53QHAEY du club 2601', '2020-01-20 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5821, 'publication #LGDG6EVTE54PPTE2 du club 2601', '2019-01-01 00:00:00', 2601, 0x00);
INSERT INTO `club_publication` VALUES (5831, 'publication #M521AKQAC4J9MVUN du club 2611', '2019-12-28 00:00:00', 2611, 0x00);
INSERT INTO `club_publication` VALUES (5841, 'publication #6CNJW5N2GYGSOIVT du club 2621', '2019-12-07 00:00:00', 2621, 0x00);
INSERT INTO `club_publication` VALUES (5851, 'publication #CHWZ6DERQJW1PEEV du club 2621', '2020-01-22 00:00:00', 2621, 0x00);
INSERT INTO `club_publication` VALUES (5861, 'publication #8A5X7N32IV70IDQ9 du club 2621', '2019-08-20 00:00:00', 2621, 0x00);
INSERT INTO `club_publication` VALUES (5871, 'publication #MNMZL6DHJJSOK73I du club 2621', '2020-06-20 00:00:00', 2621, 0x00);
INSERT INTO `club_publication` VALUES (5881, 'publication #SATJU4S1SCVXVNEA du club 2621', '2020-07-30 00:00:00', 2621, 0x00);
INSERT INTO `club_publication` VALUES (5891, 'publication #F7RL4LDPL7VKL4RZ du club 2631', '2020-03-10 00:00:00', 2631, 0x00);
INSERT INTO `club_publication` VALUES (5901, 'publication #PNSGIJRUD9791BFS du club 2631', '2019-11-16 00:00:00', 2631, 0x00);
INSERT INTO `club_publication` VALUES (5911, 'publication #PIKW0011RQLIGVPL du club 2651', '2020-08-20 00:00:00', 2651, 0x00);
INSERT INTO `club_publication` VALUES (5921, 'publication #QE4YZQLL042ALDXU du club 2661', '2019-08-15 00:00:00', 2661, 0x00);
INSERT INTO `club_publication` VALUES (5931, 'publication #62CZXPHKGF97SWR0 du club 2661', '2019-07-01 00:00:00', 2661, 0x00);
INSERT INTO `club_publication` VALUES (5941, 'publication #1J5H3R15BQ7CTXVA du club 2661', '2020-09-15 00:00:00', 2661, 0x00);
INSERT INTO `club_publication` VALUES (5951, 'publication #H9TEY8KT25O048GZ du club 2661', '2019-12-25 00:00:00', 2661, 0x00);
INSERT INTO `club_publication` VALUES (5961, 'publication #PURSLSJ2PPDXXQEV du club 2671', '2020-01-29 00:00:00', 2671, 0x00);
INSERT INTO `club_publication` VALUES (5971, 'publication #BANN8IGVMPAQUGFO du club 2671', '2019-12-29 00:00:00', 2671, 0x00);
INSERT INTO `club_publication` VALUES (5981, 'publication #GLRR7P06TUE0L5BF du club 2681', '2020-10-18 00:00:00', 2681, 0x00);
INSERT INTO `club_publication` VALUES (5991, 'publication #TGVBZXISB23ZOS2D du club 2681', '2019-06-07 00:00:00', 2681, 0x00);
INSERT INTO `club_publication` VALUES (6001, 'publication #NDTR8TC4I4MT48JU du club 2681', '2020-03-27 00:00:00', 2681, 0x00);
INSERT INTO `club_publication` VALUES (6011, 'publication #G2GPHVHIE4ZU1Z2S du club 2691', '2019-08-21 00:00:00', 2691, 0x00);
INSERT INTO `club_publication` VALUES (6021, 'publication #FOX4GL0BDYLZFG41 du club 2691', '2020-09-26 00:00:00', 2691, 0x00);
INSERT INTO `club_publication` VALUES (6031, 'publication #PFIRYF0AEHX12TFN du club 2711', '2021-01-10 00:00:00', 2711, 0x00);
INSERT INTO `club_publication` VALUES (6041, 'publication #H5L8U46KMGPUBK3H du club 2711', '2020-03-26 00:00:00', 2711, 0x00);
INSERT INTO `club_publication` VALUES (6051, 'publication #SH6Z8Q002C0TGU1G du club 2711', '2019-12-30 00:00:00', 2711, 0x00);
INSERT INTO `club_publication` VALUES (6061, 'publication #8ROKNK2B2OFZSEL3 du club 2731', '2020-06-05 00:00:00', 2731, 0x00);
INSERT INTO `club_publication` VALUES (6071, 'publication #QU057PA13OP4WNNM du club 2731', '2020-06-01 00:00:00', 2731, 0x00);
INSERT INTO `club_publication` VALUES (6081, 'publication #1KI6CO44WFEOHD0J du club 2731', '2019-03-10 00:00:00', 2731, 0x00);
INSERT INTO `club_publication` VALUES (6091, 'publication #0CKGZL518SJGJKD7 du club 2731', '2021-01-19 00:00:00', 2731, 0x00);
INSERT INTO `club_publication` VALUES (6101, 'publication #2964LNR71T2BCXR8 du club 2731', '2020-04-24 00:00:00', 2731, 0x00);
INSERT INTO `club_publication` VALUES (6111, 'publication #K02XTSLP2TQDRP6D du club 2741', '2019-08-10 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6121, 'publication #U4KT6UWH86LC8QPW du club 2741', '2020-07-15 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6131, 'publication #E3RBTFNONYXUQ99H du club 2741', '2020-12-30 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6141, 'publication #J6KVPB2KVA6Y66Z4 du club 2741', '2020-06-28 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6151, 'publication #GYRMDZTD20V3H0QM du club 2741', '2020-11-13 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6161, 'publication #CWIR1KGW16BQUKMS du club 2741', '2019-09-13 00:00:00', 2741, 0x00);
INSERT INTO `club_publication` VALUES (6171, 'publication #GFJG2KQZL2FWRJ1Z du club 2751', '2020-06-18 00:00:00', 2751, 0x00);
INSERT INTO `club_publication` VALUES (6181, 'publication #VD5DTL3M1OXP4ZWH du club 2761', '2019-04-02 00:00:00', 2761, 0x00);
INSERT INTO `club_publication` VALUES (6191, 'publication #ZYTPIN5JU6PDDGPT du club 2771', '2020-08-04 00:00:00', 2771, 0x00);
INSERT INTO `club_publication` VALUES (6201, 'publication #22RTL1VE48C8UMT8 du club 2781', '2019-04-01 00:00:00', 2781, 0x00);
INSERT INTO `club_publication` VALUES (6211, 'publication #JMJAJSS7HUMIQAEG du club 2781', '2020-08-07 00:00:00', 2781, 0x00);
INSERT INTO `club_publication` VALUES (6221, 'publication #KFJW0XGD249JNVNE du club 2781', '2019-06-14 00:00:00', 2781, 0x00);
INSERT INTO `club_publication` VALUES (6231, 'publication #WG7MPGNFEQFRL24J du club 2791', '2019-11-25 00:00:00', 2791, 0x00);
INSERT INTO `club_publication` VALUES (6241, 'publication #BPCJ8KMFNNDQD52L du club 2801', '2020-01-03 00:00:00', 2801, 0x00);
INSERT INTO `club_publication` VALUES (6251, 'publication #702L21CI2HMHWUR5 du club 2801', '2020-02-22 00:00:00', 2801, 0x00);
INSERT INTO `club_publication` VALUES (6261, 'publication #3V5CBKCWYZXP2YAB du club 2811', '2019-07-12 00:00:00', 2811, 0x00);
INSERT INTO `club_publication` VALUES (6271, 'publication #4ZESL2U2YVUR86Z6 du club 2811', '2019-08-04 00:00:00', 2811, 0x00);
INSERT INTO `club_publication` VALUES (6281, 'publication #KCES3AN0BY7CEH0S du club 2811', '2020-03-28 00:00:00', 2811, 0x00);
INSERT INTO `club_publication` VALUES (6291, 'publication #SVHUGSM68ERMTCFV du club 2841', '2019-12-01 00:00:00', 2841, 0x00);
INSERT INTO `club_publication` VALUES (6301, 'publication #T8II9I7CIPNSW899 du club 2841', '2020-01-01 00:00:00', 2841, 0x00);
INSERT INTO `club_publication` VALUES (6311, 'publication #NMNLLBXWWPDKSLI9 du club 2841', '2020-12-25 00:00:00', 2841, 0x00);
INSERT INTO `club_publication` VALUES (6321, 'publication #A1DH7U0NGXSDVFJO du club 2841', '2020-08-08 00:00:00', 2841, 0x00);
INSERT INTO `club_publication` VALUES (6331, 'publication #HPMHBI2V1HCN9ELG du club 2851', '2019-02-10 00:00:00', 2851, 0x00);
INSERT INTO `club_publication` VALUES (6341, 'publication #MQS4UWG5CFRPNV3Y du club 2851', '2019-09-23 00:00:00', 2851, 0x00);
INSERT INTO `club_publication` VALUES (6351, 'publication #V9470W8P263FEA6J du club 2861', '2020-01-29 00:00:00', 2861, 0x00);
INSERT INTO `club_publication` VALUES (6361, 'publication #C55GWONZ8R3IYKJ8 du club 2861', '2020-07-20 00:00:00', 2861, 0x00);
INSERT INTO `club_publication` VALUES (6371, 'publication #V5WIPT1898RFKQ7Q du club 2861', '2019-03-18 00:00:00', 2861, 0x00);
INSERT INTO `club_publication` VALUES (6381, 'publication #53INXAQEZ7D6710H du club 2871', '2020-12-28 00:00:00', 2871, 0x00);
INSERT INTO `club_publication` VALUES (6391, 'publication #EYID5ATRM50P5F3O du club 2871', '2021-03-05 00:00:00', 2871, 0x00);
INSERT INTO `club_publication` VALUES (6401, 'publication #4TA80NJ5XE1SUR23 du club 2881', '2020-11-13 00:00:00', 2881, 0x00);
INSERT INTO `club_publication` VALUES (6411, 'publication #IJ7LHRZQOQ2NIGCX du club 2891', '2020-06-14 00:00:00', 2891, 0x00);
INSERT INTO `club_publication` VALUES (6421, 'publication #L66MQBF2WNZQZLDA du club 2891', '2020-04-13 00:00:00', 2891, 0x00);
INSERT INTO `club_publication` VALUES (6431, 'publication #S1AXDDTPT3W87TAD du club 2901', '2020-10-05 00:00:00', 2901, 0x00);

-- ----------------------------
-- Table structure for club_type
-- ----------------------------
DROP TABLE IF EXISTS `club_type`;
CREATE TABLE `club_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 272 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of club_type
-- ----------------------------
INSERT INTO `club_type` VALUES (181, 'Associations de culture artistique et scientifique / Médias');
INSERT INTO `club_type` VALUES (191, 'Santé / Handicap');
INSERT INTO `club_type` VALUES (201, 'Environnement / Développement Durable');
INSERT INTO `club_type` VALUES (211, 'Associations de loisirs');
INSERT INTO `club_type` VALUES (221, 'Associations représentatives des étudiant·es siégeant aux conseils centraux');
INSERT INTO `club_type` VALUES (231, 'Sport');
INSERT INTO `club_type` VALUES (241, 'Solidarité');
INSERT INTO `club_type` VALUES (251, 'Etudiant·es Internationaux / Cultures du monde');
INSERT INTO `club_type` VALUES (261, 'Citoyenneté');
INSERT INTO `club_type` VALUES (271, 'Associations de filière');

-- ----------------------------
-- Table structure for crous
-- ----------------------------
DROP TABLE IF EXISTS `crous`;
CREATE TABLE `crous`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `location` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `longitude` float(255, 15) NOT NULL,
  `latitude` double(255, 15) NOT NULL,
  `image_url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of crous
-- ----------------------------
INSERT INTO `crous` VALUES (1, 'La Croissanterie', 'RDC Batiment G    ', 48.904727935791016, 2.208830200000000, 'https://www.parisnanterre.fr/medias/photo/img-1836_1495464819192-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (2, 'La Terrasse', '8 allée de l\'université', 48.905212402343750, 2.212417666406935, 'https://www.parisnanterre.fr/medias/photo/img-0459_1495014800633-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (3, 'La B.U', 'RDC de la BU', 48.892421722412110, 2.215330999999990, 'https://www.parisnanterre.fr/medias/photo/img-0469_1495012451136-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (4, 'La sandwicherie', 'RDC du Batiment F', 48.904727935791016, 2.208830199999970, 'https://www.parisnanterre.fr/medias/photo/img-0587_1495012675531-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (5, 'L\'Asiatique', 'RDC du Batiment F', 48.902664184570310, 2.213463000000000, 'https://www.parisnanterre.fr/medias/photo/img-0597_1495015407859-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (6, 'Les Food trucks', 'Allée devant le bâtiment DD', 48.903961181640625, 2.213141633346390, 'https://www.parisnanterre.fr/medias/photo/img-0555_1495011327880-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (7, 'L\'AnK', 'RDC  \r\nBatiment DD', 48.902469635009766, 2.212353872362268, 'https://www.parisnanterre.fr/medias/photo/img-0561_1495012107646-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (8, 'Le Tex-Mex', '1er étage du RU', 48.903961181640625, 2.213141633346390, 'https://www.parisnanterre.fr/medias/photo/img-1859_1495464671600-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (9, 'L\'Espace Gourmand', 'RDC du RU', 48.903961181640625, 2.213141633346390, 'https://www.parisnanterre.fr/medias/photo/img-1882_1495464656413-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (10, 'Le Millenium', 'RDC du RU', 48.903961181640625, 2.213141633346390, 'https://www.parisnanterre.fr/medias/photo/img-0490_1495012361872-jpg?ID_FICHE=444230');
INSERT INTO `crous` VALUES (11, 'Le Restaurant Universitaire', '1 allée de l\'université ', 48.905834197998050, 2.214278345182794, 'https://www.parisnanterre.fr/medias/photo/img-0484_1495010982379-jpg?ID_FICHE=444230');

-- ----------------------------
-- Table structure for crous_attendance
-- ----------------------------
DROP TABLE IF EXISTS `crous_attendance`;
CREATE TABLE `crous_attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proportion` int(1) NOT NULL,
  `hour` time(6) NOT NULL,
  `crous_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `crous_id`(`crous_id`) USING BTREE,
  CONSTRAINT `crous_attendance_ibfk_1` FOREIGN KEY (`crous_id`) REFERENCES `crous` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 445 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of crous_attendance
-- ----------------------------
INSERT INTO `crous_attendance` VALUES (241, 100, '14:00:00.000000', 5);
INSERT INTO `crous_attendance` VALUES (251, 60, '14:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (261, 100, '14:00:00.000000', 2);
INSERT INTO `crous_attendance` VALUES (271, 60, '14:00:00.000000', 3);
INSERT INTO `crous_attendance` VALUES (281, 30, '14:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (291, 60, '14:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (301, 60, '14:00:00.000000', 4);
INSERT INTO `crous_attendance` VALUES (311, 60, '15:00:00.000000', 10);
INSERT INTO `crous_attendance` VALUES (321, 30, '17:00:00.000000', 4);
INSERT INTO `crous_attendance` VALUES (331, 100, '17:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (341, 100, '17:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (351, 30, '17:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (361, 30, '17:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (371, 100, '17:00:00.000000', 10);
INSERT INTO `crous_attendance` VALUES (381, 30, '17:00:00.000000', 4);
INSERT INTO `crous_attendance` VALUES (391, 30, '18:00:00.000000', 4);
INSERT INTO `crous_attendance` VALUES (401, 100, '18:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (411, 100, '18:00:00.000000', 10);
INSERT INTO `crous_attendance` VALUES (421, 100, '18:00:00.000000', 10);
INSERT INTO `crous_attendance` VALUES (431, 30, '18:00:00.000000', 1);
INSERT INTO `crous_attendance` VALUES (435, 30, '12:00:00.000000', 3);

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
  CONSTRAINT `crous_product_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `crous_product_ibfk_2` FOREIGN KEY (`crous_id`) REFERENCES `crous` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of crous_product
-- ----------------------------
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
INSERT INTO `crous_product` VALUES (74, 3, 3);
INSERT INTO `crous_product` VALUES (75, 5, 29);
INSERT INTO `crous_product` VALUES (76, 7, 3);
INSERT INTO `crous_product` VALUES (77, 7, 18);

-- ----------------------------
-- Table structure for crous_product_availability
-- ----------------------------
DROP TABLE IF EXISTS `crous_product_availability`;
CREATE TABLE `crous_product_availability`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isAvailable` binary(1) NOT NULL DEFAULT 0,
  `date` datetime(0) NOT NULL,
  `crous_product_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `crous_product_availability_ibfk_1`(`crous_product_id`) USING BTREE,
  CONSTRAINT `crous_product_availability_ibfk_1` FOREIGN KEY (`crous_product_id`) REFERENCES `crous_product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 192 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of crous_product_availability
-- ----------------------------
INSERT INTO `crous_product_availability` VALUES (101, 0x30, '2020-12-28 20:40:24', 6);
INSERT INTO `crous_product_availability` VALUES (111, 0x31, '2021-01-04 17:27:01', 6);
INSERT INTO `crous_product_availability` VALUES (121, 0x30, '2021-01-06 15:18:47', 61);
INSERT INTO `crous_product_availability` VALUES (131, 0x30, '2021-01-06 15:25:54', 19);
INSERT INTO `crous_product_availability` VALUES (141, 0x30, '2021-01-06 15:26:55', 6);
INSERT INTO `crous_product_availability` VALUES (151, 0x30, '2021-01-06 15:30:51', 3);
INSERT INTO `crous_product_availability` VALUES (161, 0x30, '2021-01-06 15:30:59', 3);
INSERT INTO `crous_product_availability` VALUES (171, 0x30, '2021-01-06 15:32:56', 2);
INSERT INTO `crous_product_availability` VALUES (181, 0x30, '2021-01-06 15:33:38', 5);
INSERT INTO `crous_product_availability` VALUES (191, 0x31, '2021-01-06 15:33:40', 5);

-- ----------------------------
-- Table structure for crous_schedule
-- ----------------------------
DROP TABLE IF EXISTS `crous_schedule`;
CREATE TABLE `crous_schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_time` time(6) NULL DEFAULT NULL,
  `closing_time` time(6) NULL DEFAULT NULL,
  `crous_id` int(11) NULL DEFAULT NULL,
  `days` varchar(21) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `crous_id`(`crous_id`) USING BTREE,
  CONSTRAINT `crous_schedule_ibfk_1` FOREIGN KEY (`crous_id`) REFERENCES `crous` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of crous_schedule
-- ----------------------------
INSERT INTO `crous_schedule` VALUES (1, '08:30:00.000000', '22:00:00.000000', 1, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (2, '11:00:00.000000', '14:30:00.000000', 2, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (3, '08:30:00.000000', '18:30:00.000000', 3, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (5, '08:30:00.000000', '18:00:00.000000', 4, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (6, '08:00:00.000000', '15:00:00.000000', 5, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (7, '11:30:00.000000', '14:00:00.000000', 6, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (8, '08:00:00.000000', '17:00:00.000000', 7, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (9, '11:30:00.000000', '14:30:00.000000', 8, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (10, '11:45:00.000000', '14:00:00.000000', 9, 'MON-TUE-WED-THU-FFRI');
INSERT INTO `crous_schedule` VALUES (11, '08:00:00.000000', '21:00:00.000000', 10, 'MON-TUE-WED-THU-FRI');
INSERT INTO `crous_schedule` VALUES (12, '11:30:00.000000', '14:00:00.000000', 11, 'MON-TUE-WED-THU-FRI');

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
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES (1, 'Bibliothèque De L\'ufr Dsp', 'Entresol, salle E16', 'La BUFR de DSP rouvre ses portes ce mardi 13 octobre, dès 9 heures.\r\n\r\nDans le cadre de la mobilisation contre l\'épidémie de Covid-19, le nombre de places disponibles est réduit (45 contre 100). Merci de bien respecter les distances de sécurité en ne déplaçant pas les chaises et en suivant les marquages au sol.\r\n\r\nNos horaires sont également modifiés : 9h-17h du lundi au jeudi. Nous restons disponibles à distance pour toutes interrogations le vendredi.\r\n\r\nL\'accès à la salle des photocopieurs sera également limité à une personne à la fois.\r\n\r\nNous rappelons que le port du masque est obligatoire et ce pour toute la durée de votre passage dans la bibliothèque, comme c\'est le cas dans le reste du bâtiment.\r\n\r\nPour toute question ou renseignement, l\'équipe de la BUFR reste à votre disposition au 01.40.97.77.11, ou en écrivant à apare@parisnanterre.fr\r\n', 1, '0140977711', NULL);
INSERT INTO `library` VALUES (2, 'La Bibliothèque D’histoire Et D’histoire De L’art (UFR SSA)', 'Rez-de-chaussée', NULL, 23, NULL, NULL);
INSERT INTO `library` VALUES (3, 'La Bibliothèque De Langues Et Cultures Etrangères (UFR LCE)', '1er étage, salle 108', 'La biblothèque de l\'UFR LCE est fermée pendant toute la durée du confinement.\r\n\r\nLa durée de l\'ensemble des prêts de documents est automatiquement prolongée jusqu\'à la réouverture de la bibliothèque. Aucune pénalité n\'est encourue.\r\n\r\nLa bibliothèque universitaire vous accueille sur rendez-vous pour emprunter et retourner les ouvrages, travailler sur place aux horaires suivants : 10h-13h ; 14h-17h', 14, '0140974943', NULL);
INSERT INTO `library` VALUES (4, 'La Bibliothèque De Philosophie (UFR PHILLIA)', 'Salle 319', '\r\nEn raison du contexte sanitaire, à partir du 10/11 la BUFR de Philosophie sera ouverte mardi et jeudi de 9h45 à 16h45.\r\n\r\nDes créneaux de réservation sont disponibles pour consultation sur place : 9h45-12h, 12h05-14h20, 14h25-16h45. On pourra réserver un seule créneau ou plusieurs, même toute la journée. \r\nLa réservation se fera par mail à l\'adresse lpicardi@parisnanterre.fr.\r\n\r\nPour le prêt et retour des livres il y aura un créneau d\'une demi-heure à réserver. \r\n\r\nSeuls les usagers avec réservation pourront avoir accès au bâtiment. Les étudiant.e.s pour se déplacer auront besoin de leur attestation dérogatoire, un document et le mail de confirmation de réservation à montrer à l\'accueil du bâtiment.\r\n\r\nLes places disponibles (vous pourrez indiquer votre choix de préférence au moment de la réservation par mail) : \r\n6 places en salle de travail (une pour chaque table), 4 en salle de lecture (une pour chaque table), 2 sur la table ovale, 1 la petite table à côte de la fenêtre, 1 la table derrière à côté des revues non classées, + 2 places ordinateurs (seulement pour l\'utilisation des ordinateurs).\r\n\r\nTout les prêts avec échéance à partir de novembre ont été prolongés jusqu\'au 7 décembre.', 7, '0140977069', NULL);
INSERT INTO `library` VALUES (5, 'La Bibliothèque Du Pôle Universitaire Léonard De Vinci', 'Pôle Universitaire Léonard de Vinci\r\n     12 avenue Léonard de Vinci\r\n     92400 Courbevoie\r\n     Bâtiment de l\'infothèque\r\n     1er étage, Salle i 111', 'La bibliothèque du PULV est réservée aux étudiants de l\'IPAG (Institut de Préparation à l\'Administration Générale) et aux étudiants des UFR DSP, SEGMI et PHILLIA de l\'Université Paris Nanterre ayant cours au Pôle Universitaire Léonard de Vinci.\r\n\r\nSituée au 1er étage du bâtiment de l\'infothèque, la bibliothèque offre des espaces et un environnement calme. Elle met à disposition des étudiants et enseignants des places de travail individuel et une salle de travail en groupe.\r\n\r\nDes bibliothécaires sont au service des étudiants pour les accompagner dans leurs recherches documentaires et les former aux bases de données.\r\n\r\n(L\'entrée dans le bâtiment requiert un badge du PULV).', NULL, '0141167362', NULL);
INSERT INTO `library` VALUES (6, 'La Bibliothèque De Sociologie Et D’administration Économique Et Sociale', 'Salle 104', NULL, 22, '0140977401', NULL);
INSERT INTO `library` VALUES (7, 'Centre De Documentation Des Sciences Et Techniques Des Activités Sportives (UFR STAPS)', 'Rez-de-chaussée', NULL, 13, NULL, NULL);
INSERT INTO `library` VALUES (8, 'La Bibliothèque D\'arts Du Spectacle (UFR PHILLIA)', 'Salle 207', NULL, 7, '0140977340', NULL);
INSERT INTO `library` VALUES (9, 'La Bibliothèque De Géographie/Cartothèque (UFR SSA)', 'Salle 410', 'Jusqu\'au 1er décembre, La bibliothèque-cartothèque de géographie est ouverte le jeudi sur rendez-vous de 9h30 à 12h30 et de 13h30 à 16h30\r\nEn raison de la fermeture des bâtiments à 17h la dernière entrée s\'éffectue à 16h30.\r\n\r\nLe nombre de lecteurs en accès simultané en bibliothèque D 410 est limité à 10 personnes.\r\nLa salle de lecture D 411 est en revanche fermée.\r\nIl est possible de :\r\n- rendre et emprunter des livres, consulter livres, cartes, périodiques, mémoires\r\n- travailler individuellement sur place\r\n- faire des photocopies, scans et impressions.\r\nVous devez au préalable m\'envoyer un mail (Anne-Laure Cermak acermak@parisnanterre.fr ) en précisant l\'objet de votre venue ( prêt/retour, recherche, impressions..), la durée sur place envisagée et m\'indiquer notamment si vous avez repérés des titres suite à une recherche dans le catalogue et indiquer les références.\r\nPour les cartes : préciser le titre et si possible le n°IGN.\r\nUn mail vous sera ensuite adressé pour vous confirmer l\'heure de votre rdv.\r\n\r\nEn raison de la situation sanitaire, les livres actuellement en prêt de la bibliothèque de géographie, sont prolongés jusqu\'au 7 décembre. Aucune pénalité n\'est encourue.\r\nPour vos tenir informés , consultez régulièrement cette page web et la page facebook des bibliothèques de géographie et d\'urbanisme.', 21, NULL, NULL);
INSERT INTO `library` VALUES (10, 'La Bibliothèque De Lettres Et Des Sciences Du Langage  (UFR PHILLIA)', 'Salle 322', 'A partir de cette semaine, la BUFR est accessible deux jours dans la semaine, le mercredi et vendredi :\r\n- aux membres de l\'UFR PHILLIA uniquement\r\n- sur rendez-vous par mail : swegiera@parisnanterre.fr\r\n- Créneaux de 9h00 à 12h00 et/ou de 13h00 à 16h45\r\nPrendre RDV est nécessaire pour accéder à la BUFR, quels que soient les motifs de votre venue (emprunter / retourner des documents, travailler sur place, imprimer / photocopier).\r\nPour venir il vous faut :\r\n- une attestation de déplacement,\r\n- une pièce d\'identité,\r\n- une carte étudiante ou professionnelle UPN,\r\n- votre confirmation de prise de rendez-vous (mail).\r\n\r\nLa durée de prêt des ouvrages empruntés avant le confinement est automatiquement prolongée jusqu\'au 7 décembre. \r\nIl n\'est donc pas nécessaire de vous déplacer uniquement pour retourner des documents.', NULL, '0140977579', 'artsduspectaclebibliotheque@yahoo.com');
INSERT INTO `library` VALUES (11, 'La Bibliothèque De Sciences Economiques, Gestion, Mathématiques Et Informatique (UFR SEGMI)', 'Salle 113', 'Re-Confinement de novembre - Fermeture de la bibliothèque SEGMI\r\n\r\nSuite aux annonces présidentielles et aux nouvelles consignes sanitaires, la bibliothèque SEGMI ferme ses portes au public jusqu\'à nouvel ordre.\r\nLes ouvrages empruntés avant le confinement peuvent être rendus à la grande BU pendant toute la durée de la fermeture, cependant la durée de prêt de tous les documents a été automatiquement prolongée jusqu’au 7 décembre et le sera au-delà si nécessaire. Il n\'est donc pas nécessaire de vous déplacer pour retourner des documents.\r\n\r\nA titre d\'information, à partir du 9 novembre, la grande BU est accessible aux membres de la communauté universitaire sur rendez-vous, une journée maximum par personne par semaine. Prendre rendez-vous est nécessaire pour accéder à une place de travail individuelle mais aussi pour utiliser les autres services de la BU (prêt / retour de documents, impressions / photocopies).', 2, NULL, NULL);
INSERT INTO `library` VALUES (12, 'La Bibliothèque De Psychologie Et Sciences De L’éducation (UFR SPSE)', 'Salle R01', 'LA BIBLIOTHÈQUE DE PSYCHOLOGIE ET SCIENCES DE L’ÉDUCATION (UFR SPSE)\r\nConfinement de novembre - Fermeture de la Bibliothèque de l\'UFR SPSE\r\nLa bibliothèque de l\'UFR ferme ses portes au public à partir de ce lundi 2 novembre 2020.\r\n\r\nJe demeure néanmoins joignable via ma messagerie professionnelle ljouvin@parisnanterre.fr et serai théoriquement présente sur site chaque lundi et jeudi.  Ces jours-là, vous pourrez donc m\'obtenir au 01.40.97.74.24.\r\n\r\nPour ce qui est du retour des documents que vous aviez empruntés avant ce confinement, nous avons porté la date de retour au 7 décembre.\r\n\r\nIl est également envisageable de nous adresser les ouvrages par voie postale (Université de Nanterre / Bibliothèque de l\'UFR de SPSE / L. Jouvin / Bât Zazzo RDC / 200 avenue de la République / 92001 NANTERRE)\r\n\r\nLa grande B.U. réouvrant à partir du 9 novembre mais avec des horaires restreints et un nombre limité de places de travail (attention prise de rendez-vous préalable, voir les modalités), en vous y rendant, vous pourrez également déposer chez eux nos ouvrages. Nous nous chargerons de les récupérer ensuite.\r\n\r\nMerci à vous et bonne continuation dans le distanciel.', 20, '0140977044', NULL);
INSERT INTO `library` VALUES (13, 'La Bibliothèque D\'aménagement Et Urbanisme (UFR SSA)', 'Salle 412', 'Rattachée au département de géographie de l\'UFR SSA, au laboratoire Mosaïques depuis 2006 et à la formation en aménagement, la bibliothèque d\'aménagement et d\'urbanisme accueille en priorité les étudiants à partir du L2, les Master 1 et 2, ainsi que les doctorants et chercheurs de l\'Université Université Paris Nanterre.\r\n\r\nElle autorise aussi l\'accès à toute personne extérieure intéressée par le fonds documentaire (étudiants d\'autres universités, professionnels de l\'aménagement et de la ville, membres d\'associations...) en consultation sur place. (Prêt aux personnes inscrites au préalable à la BU comme Lecteur extérieur.)', 21, NULL, NULL);
INSERT INTO `library` VALUES (16, 'La Bibliothèque Universitaire', 'Campus Nanterre, Bâtiment BU - La Contemporaine (2 allée de la bibliothèque 92000 Nanterre)', 'La bibliothèque universitaire est composée de 5 salles thématiques où vous pouvez travailler et accéder librement à des ouvrages, des films et aux dernières années des revues auxquelles la BU est abonnée.\r\n\r\nCertains ouvrages et revues sont conservés dans les magasins situés dans la Tour du bâtiment. Ces documents doivent être demandés via le catalogue en ligne.\r\n\r\nAttention ! En 2019/2020, l’aile sud de la BU (BUlle, salle des Sciences sociales) est fermée, en raison des travaux de réalisation d\'un centre de ressources et des cultures numériques qui remplacera la BUlle. Les collections de la salle des Sciences sociales restent cependant accessibles en salle des Sciences économiques ou sur demande via le catalogue scd.parisnanterre.fr', 9, '0140977202', NULL);

-- ----------------------------
-- Table structure for library_attendance
-- ----------------------------
DROP TABLE IF EXISTS `library_attendance`;
CREATE TABLE `library_attendance`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proportion` int(3) NOT NULL,
  `hour` time(2) NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_attendance_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 191 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library_attendance
-- ----------------------------
INSERT INTO `library_attendance` VALUES (128, 100, '17:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (129, 30, '22:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (130, 60, '14:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (131, 60, '11:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (132, 100, '17:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (133, 30, '11:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (134, 30, '14:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (135, 30, '13:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (136, 60, '14:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (137, 100, '09:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (138, 30, '07:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (139, 100, '23:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (140, 30, '22:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (141, 100, '21:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (142, 30, '23:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (143, 100, '22:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (144, 30, '23:00:00.00', 1);
INSERT INTO `library_attendance` VALUES (145, 100, '17:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (146, 100, '21:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (147, 30, '23:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (148, 60, '15:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (149, 100, '15:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (150, 30, '14:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (151, 60, '17:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (152, 30, '22:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (153, 100, '10:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (154, 60, '08:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (155, 30, '22:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (156, 30, '18:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (157, 30, '21:00:00.00', 2);
INSERT INTO `library_attendance` VALUES (158, 30, '11:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (159, 30, '23:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (160, 30, '17:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (161, 100, '19:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (162, 60, '16:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (163, 60, '16:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (164, 60, '17:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (165, 100, '12:00:00.00', 3);
INSERT INTO `library_attendance` VALUES (166, 100, '16:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (167, 60, '11:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (168, 30, '15:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (169, 30, '16:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (170, 60, '18:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (171, 100, '18:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (172, 30, '16:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (173, 30, '23:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (174, 100, '21:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (175, 100, '22:00:00.00', 4);
INSERT INTO `library_attendance` VALUES (176, 100, '23:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (177, 100, '22:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (178, 60, '22:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (179, 0, '21:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (180, 100, '18:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (181, 10, '10:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (182, 85, '19:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (183, 50, '20:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (184, 40, '11:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (185, 60, '12:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (186, 60, '13:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (187, 20, '14:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (188, 30, '15:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (189, 45, '16:00:00.00', 5);
INSERT INTO `library_attendance` VALUES (190, 75, '17:00:00.00', 5);

-- ----------------------------
-- Table structure for library_consultation_loan_condition
-- ----------------------------
DROP TABLE IF EXISTS `library_consultation_loan_condition`;
CREATE TABLE `library_consultation_loan_condition`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `library_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_consultation_loan_condition_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library_consultation_loan_condition
-- ----------------------------
INSERT INTO `library_consultation_loan_condition` VALUES (1, 'Fonds en libre-accès', 2);
INSERT INTO `library_consultation_loan_condition` VALUES (3, 'Fonds en libre-accès répertorié par langue.', 3);
INSERT INTO `library_consultation_loan_condition` VALUES (4, 'Périodiques empruntables à l\'exception du dernier numéro reçu.', 3);
INSERT INTO `library_consultation_loan_condition` VALUES (5, 'Mémoires consultables sur place uniquement.', 3);
INSERT INTO `library_consultation_loan_condition` VALUES (7, 'Mémoires uniquement consultables sur place.\r\n', 10);
INSERT INTO `library_consultation_loan_condition` VALUES (22, 'Fonds en libre-accès', 4);
INSERT INTO `library_consultation_loan_condition` VALUES (23, 'Bibliothèque de la Pléiade, dictionnaires de langue et sélection d\'ouvrages pour l\'agrégation uniquement consultables sur place', 4);
INSERT INTO `library_consultation_loan_condition` VALUES (24, 'Dictionnaires et encyclopédies : Master, prépa concours, doctorat, enseignants : 1 livre pour 1 semaine', 4);
INSERT INTO `library_consultation_loan_condition` VALUES (26, 'Périodiques cataloguées : 3 numéros pour 2 semaines', 4);
INSERT INTO `library_consultation_loan_condition` VALUES (35, 'Le prêt s\'effectue grâce à la carte d\'étudiant de l\'université Paris Nanterre', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (36, 'Fonds en libre-accès.', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (37, 'Licence : 6 documents pour 14 jours (non renouvelable)', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (38, 'Master et Préparations aux concours : 6 documents pour 14 jours (renouvelable 1 fois via le compte lecteur)', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (39, 'Enseignants : 6 documents pour 28 jours', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (40, 'Administratifs : 6 documents pour 28 jours.', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (41, 'Périodiques : 2 revues pour 14 jours à l \'exception du dernier numéro.', 5);
INSERT INTO `library_consultation_loan_condition` VALUES (42, 'Fonds en libre-accès sauf pour les mémoires (présentation de la carte étudiant)', 11);
INSERT INTO `library_consultation_loan_condition` VALUES (43, 'Périodiques et mémoires uniquement consultables sur place', 11);
INSERT INTO `library_consultation_loan_condition` VALUES (46, 'Fonds en libre-accès.', 6);
INSERT INTO `library_consultation_loan_condition` VALUES (47, 'Périodiques, dictionnaires et mémoires uniquement consultables sur place.', 6);
INSERT INTO `library_consultation_loan_condition` VALUES (48, 'Codes et plans comptables en prêt court.', 6);
INSERT INTO `library_consultation_loan_condition` VALUES (52, 'Fonds en libre-accès', 12);
INSERT INTO `library_consultation_loan_condition` VALUES (53, 'Périodiques, mémoires et documents pédagogiques uniquement consultables sur place.', 12);
INSERT INTO `library_consultation_loan_condition` VALUES (54, 'Authentification nécessaire (login et mot de passe) pour l\'accès aux ressources en ligne de la BU et des BUFR sur le portail documentaire du S.C.D. (scd.parisnanterre.fr)', 12);
INSERT INTO `library_consultation_loan_condition` VALUES (63, 'Aménagement possible des durées selon les cas. A aborder avec la responsable.', 12);
INSERT INTO `library_consultation_loan_condition` VALUES (64, 'Fonds en libre-accès', 7);
INSERT INTO `library_consultation_loan_condition` VALUES (65, 'Pas de prêt à domicile. Consultation des ouvrages sur place uniquement.', 7);
INSERT INTO `library_consultation_loan_condition` VALUES (66, 'Fonds en libre-accès', 13);
INSERT INTO `library_consultation_loan_condition` VALUES (67, 'Périodiques, thèses, mémoires, et rapports de stage sont uniquement consultables sur place', 13);
INSERT INTO `library_consultation_loan_condition` VALUES (72, 'Fonds en libre-accès pour les documents de la salle D410 et présentation de la carte étudiant pour pour la consultation des documents en salle de lecture D 411.', 9);
INSERT INTO `library_consultation_loan_condition` VALUES (73, 'Périodiques, mémoires, cartes et atlas grand format uniquement consultables sur place', 9);
INSERT INTO `library_consultation_loan_condition` VALUES (83, 'Ouvrages en libre-accès : Documents empruntables (anciennes éditions de manuels) : gommettes jaunes ', 1);
INSERT INTO `library_consultation_loan_condition` VALUES (84, 'Ouvrages en libre-accès : Documents consultables : nouvelles éditions de manuels, ouvrages généraux', 1);
INSERT INTO `library_consultation_loan_condition` VALUES (85, 'Ouvrages en libre-accès : Documents exclus du prêt : dictionnaires, traités, certains codes', 1);
INSERT INTO `library_consultation_loan_condition` VALUES (86, 'Périodiques uniquement consultables sur place.', 1);
INSERT INTO `library_consultation_loan_condition` VALUES (101, 'Fonds en accès contrôlé avec la carte étudiante et uniquement consultable sur place', 8);

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
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library_documentary_fund
-- ----------------------------
INSERT INTO `library_documentary_fund` VALUES (2, '1 850 ouvrages', 8);
INSERT INTO `library_documentary_fund` VALUES (3, '3 revues', 8);
INSERT INTO `library_documentary_fund` VALUES (4, 'Thèses', 8);
INSERT INTO `library_documentary_fund` VALUES (5, 'Mémoires', 8);
INSERT INTO `library_documentary_fund` VALUES (6, '5 700 ouvrages', 1);
INSERT INTO `library_documentary_fund` VALUES (7, '78 titres de périodiques (dont 58 abonnements en cours)', 1);
INSERT INTO `library_documentary_fund` VALUES (8, 'Fonds de l’Institut d’études judiciaires (IEJ) : empruntables par les étudiants suivant cette formation', 1);
INSERT INTO `library_documentary_fund` VALUES (9, 'Fonds du Master d’études bilingues des droits de l’Europe (BDE)', 1);
INSERT INTO `library_documentary_fund` VALUES (10, 'Fonds de mélanges', 1);
INSERT INTO `library_documentary_fund` VALUES (11, 'Fonds Guy Carcassonne (FGC)', 1);
INSERT INTO `library_documentary_fund` VALUES (12, '7 000 ouvrages.', 9);
INSERT INTO `library_documentary_fund` VALUES (13, '100 titres de périodiques dont 12 abonnements en cours', 9);
INSERT INTO `library_documentary_fund` VALUES (14, '150 thèses et mémoires', 9);
INSERT INTO `library_documentary_fund` VALUES (15, '36 000 cartes topographiques, géologiques, climatiques et de végétation à différentes échelles (cartes françaises et étrangères)', 9);
INSERT INTO `library_documentary_fund` VALUES (16, '30 000 ouvrages', 2);
INSERT INTO `library_documentary_fund` VALUES (17, '112 titres de périodiques dont 29 abonnements en cours', 2);
INSERT INTO `library_documentary_fund` VALUES (18, '4 500 mémoires', 2);
INSERT INTO `library_documentary_fund` VALUES (19, '11 000 ouvrages', 3);
INSERT INTO `library_documentary_fund` VALUES (20, '6 revues : Courrier International, Time, the Economist, Vocable espagnol, Deutch Perfekt, Monde chinois', 3);
INSERT INTO `library_documentary_fund` VALUES (21, '148 mémoires de Master de Langues (soutenus au sein de l\'Université Paris Nanterre)', 3);
INSERT INTO `library_documentary_fund` VALUES (22, 'Agrégation et CAPES d\'anglais et d\'espagnol : la plupart des ouvrages signalés dans les bibliographies officielles des concours sont disponibles.', 3);
INSERT INTO `library_documentary_fund` VALUES (23, '30 000 ouvrages en lettres modernes et classiques et sciences du langage', 10);
INSERT INTO `library_documentary_fund` VALUES (24, '150 titres de périodiques', 10);
INSERT INTO `library_documentary_fund` VALUES (25, 'Une centaine de mémoires', 10);
INSERT INTO `library_documentary_fund` VALUES (26, 'Rapports du jury CAPES et AGREGATION', 10);
INSERT INTO `library_documentary_fund` VALUES (27, '17 000 ouvrages', 4);
INSERT INTO `library_documentary_fund` VALUES (28, '70 titres de périodiques consultables sur place, plus 13 empruntables (dont 3 abonnements en cours)', 4);
INSERT INTO `library_documentary_fund` VALUES (29, '350 thèses et mémoires consultables sur places (Inventaire à consulter/télécharger)', 4);
INSERT INTO `library_documentary_fund` VALUES (30, 'Copies de concours en consultation sur place', 4);
INSERT INTO `library_documentary_fund` VALUES (31, 'ouvrages', 5);
INSERT INTO `library_documentary_fund` VALUES (32, 'ressources en ligne', 5);
INSERT INTO `library_documentary_fund` VALUES (33, 'bases de données', 5);
INSERT INTO `library_documentary_fund` VALUES (34, 'un fonds concours principalement catégories A et B', 5);
INSERT INTO `library_documentary_fund` VALUES (35, 'revues spécialisées', 5);
INSERT INTO `library_documentary_fund` VALUES (36, '6 500 ouvrages', 11);
INSERT INTO `library_documentary_fund` VALUES (37, '16 revues', 11);
INSERT INTO `library_documentary_fund` VALUES (38, 'Mémoires de master', 11);
INSERT INTO `library_documentary_fund` VALUES (39, '6 200 ouvrages', 6);
INSERT INTO `library_documentary_fund` VALUES (40, '20 titres de périodiques', 6);
INSERT INTO `library_documentary_fund` VALUES (41, '400 à 500 mémoires', 6);
INSERT INTO `library_documentary_fund` VALUES (42, '2 035 ouvrages', 6);
INSERT INTO `library_documentary_fund` VALUES (43, '27 titres de périodiques dont 14 abonnements en cours', 6);
INSERT INTO `library_documentary_fund` VALUES (44, '855 mémoires', 6);
INSERT INTO `library_documentary_fund` VALUES (45, '90 rapports de stage', 6);
INSERT INTO `library_documentary_fund` VALUES (46, 'Environ 20 800 documents', 12);
INSERT INTO `library_documentary_fund` VALUES (47, '12 000 volumes d\'ouvrages', 12);
INSERT INTO `library_documentary_fund` VALUES (48, '74 titres de périodiques dont 48 abonnements en cours', 12);
INSERT INTO `library_documentary_fund` VALUES (49, '891 titres de mémoires, en Sciences de l\'éducation et en Sciences Psychologiques', 12);
INSERT INTO `library_documentary_fund` VALUES (50, 'Documents pédagogiques, tirés a part, veille, annales', 12);
INSERT INTO `library_documentary_fund` VALUES (51, '950 ouvrages', 7);
INSERT INTO `library_documentary_fund` VALUES (52, '654 mémoires', 7);
INSERT INTO `library_documentary_fund` VALUES (53, '3 800 ouvrages', 13);
INSERT INTO `library_documentary_fund` VALUES (54, '10 titres de périodiques', 13);
INSERT INTO `library_documentary_fund` VALUES (55, '1 400 thèses, mémoires et rapports de stages', 13);

-- ----------------------------
-- Table structure for library_domain
-- ----------------------------
DROP TABLE IF EXISTS `library_domain`;
CREATE TABLE `library_domain`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_domain_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
  `full_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `phone_number` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `mail` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_responsable_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library_responsable
-- ----------------------------
INSERT INTO `library_responsable` VALUES (1, 'Alexandre PARÉ', '0140977711', 'apare@parisnanterre.fr', 1);
INSERT INTO `library_responsable` VALUES (2, 'Thibaut DINASQUET', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (3, 'Amirhoushang MOSTARSHEDI', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (4, 'Aurore VERNHES', NULL, NULL, 1);
INSERT INTO `library_responsable` VALUES (5, 'Catherine Lescure', '0140977634', 'catherine.lescure@parisnanterre.fr', 2);
INSERT INTO `library_responsable` VALUES (6, 'Hélène Durand', '0140977581', 'hedurand@parisnanterre.fr', 3);
INSERT INTO `library_responsable` VALUES (7, 'Luca Picardi', '0140977009', 'lpicardi@parisnanterre.fr', 4);
INSERT INTO `library_responsable` VALUES (8, 'Yannick Valmy', '0141167369', 'yvalmy@parisnanterre.fr', 5);
INSERT INTO `library_responsable` VALUES (9, 'Anne-Frédérique Pérol', '0140977510', 'aperol@parisnanterre.fr', 6);
INSERT INTO `library_responsable` VALUES (10, 'Sylia Ait Abdelmalek', '0140977338', 'saitabde@parisnanterre.fr', 6);
INSERT INTO `library_responsable` VALUES (11, 'Isabelle CARTEREAU', '0140977119', 'isabelle.cartereau@parisnanterre.fr', 7);
INSERT INTO `library_responsable` VALUES (12, 'Marie-France NGUYEN', '0140974126', 'faugeron@parisnanterre.fr', 7);
INSERT INTO `library_responsable` VALUES (13, 'Marine Walzer', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (14, 'Martin Audeguis', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (15, 'Marius Bengugiui', NULL, NULL, 8);
INSERT INTO `library_responsable` VALUES (16, 'Anne-Laure Barbeau-Cermak', '0140977560', 'acermak@parisnanterre.fr', 9);
INSERT INTO `library_responsable` VALUES (17, 'Sasha Wegiera', '0140977270', 'swegiera@parisnanterre.fr', 10);
INSERT INTO `library_responsable` VALUES (18, 'Sophie Da Silva', '0140977867', 'sophie.da_silva@parisnanterre.fr', 11);
INSERT INTO `library_responsable` VALUES (19, 'Laura Jouvin', '0140977044', 'laura.jouvin@parisnanterre.fr', 12);
INSERT INTO `library_responsable` VALUES (20, 'Franck Rakotonirina', '0140977582', 'frakoton@parisnanterre.fr', 13);
INSERT INTO `library_responsable` VALUES (21, 'LA BIBLIOTHÈQUE UNIVERSITAIRE', '0140977202', NULL, 0);

-- ----------------------------
-- Table structure for library_schedule
-- ----------------------------
DROP TABLE IF EXISTS `library_schedule`;
CREATE TABLE `library_schedule`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `opening_time` time(6) NOT NULL,
  `closing_time` time(6) NOT NULL,
  `days` varchar(23) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `library_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `library_id`(`library_id`) USING BTREE,
  CONSTRAINT `library_schedule_ibfk_1` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of library_schedule
-- ----------------------------
INSERT INTO `library_schedule` VALUES (1, '09:00:00.000000', '17:00:00.000000', 'MON-TUE-WED-THU-FRI', 1);
INSERT INTO `library_schedule` VALUES (2, '09:00:00.000000', '17:00:00.000000', 'MON-TUE-WED-THU-FRI', 2);
INSERT INTO `library_schedule` VALUES (3, '09:00:00.000000', '18:00:00.000000', 'MON-TUE-WED-THU-FRI', 3);
INSERT INTO `library_schedule` VALUES (4, '09:30:00.000000', '19:30:00.000000', 'MON-TUE-WED-THU', 4);
INSERT INTO `library_schedule` VALUES (5, '09:30:00.000000', '17:30:00.000000', 'FRI', 4);
INSERT INTO `library_schedule` VALUES (6, '09:00:00.000000', '18:00:00.000000', 'MON-TUE-WED-THU-FRI', 5);
INSERT INTO `library_schedule` VALUES (7, '09:15:00.000000', '18:00:00.000000', 'MON-TUE-WED-THU', 6);
INSERT INTO `library_schedule` VALUES (8, '09:15:00.000000', '17:15:00.000000', 'FRI', 6);
INSERT INTO `library_schedule` VALUES (9, '09:15:00.000000', '00:13:00.000000', 'MON-TUE-THU', 7);
INSERT INTO `library_schedule` VALUES (10, '14:00:00.000000', '17:00:00.000000', 'MON-TUE-THU', 7);
INSERT INTO `library_schedule` VALUES (11, '09:15:00.000000', '13:00:00.000000', 'FRI', 7);
INSERT INTO `library_schedule` VALUES (12, '14:00:00.000000', '16:30:00.000000', 'FRI', 7);
INSERT INTO `library_schedule` VALUES (13, '10:00:00.000000', '14:00:00.000000', 'MON-TUE-WED', 8);
INSERT INTO `library_schedule` VALUES (14, '14:30:00.000000', '17:30:00.000000', 'MON-WED', 8);
INSERT INTO `library_schedule` VALUES (15, '14:30:00.000000', '18:30:00.000000', 'TUE', 8);
INSERT INTO `library_schedule` VALUES (16, '09:15:00.000000', '18:00:00.000000', 'MON', 9);
INSERT INTO `library_schedule` VALUES (17, '09:15:00.000000', '17:00:00.000000', 'TUE-WED-THU', 9);
INSERT INTO `library_schedule` VALUES (18, '09:00:00.000000', '13:00:00.000000', 'FRI', 9);
INSERT INTO `library_schedule` VALUES (19, '09:00:00.000000', '19:00:00.000000', 'MON', 10);
INSERT INTO `library_schedule` VALUES (20, '09:00:00.000000', '18:00:00.000000', 'TUE-WED-THU-FRI', 10);
INSERT INTO `library_schedule` VALUES (21, '08:30:00.000000', '19:00:00.000000', 'MON-TUE-WED-THU-FRI', 11);
INSERT INTO `library_schedule` VALUES (22, '09:00:00.000000', '13:00:00.000000', 'MON-TUE', 13);
INSERT INTO `library_schedule` VALUES (23, '14:00:00.000000', '17:00:00.000000', 'MON-TUE', 13);
INSERT INTO `library_schedule` VALUES (24, '09:00:00.000000', '13:00:00.000000', 'WED', 13);
INSERT INTO `library_schedule` VALUES (25, '14:00:00.000000', '17:00:00.000000', 'WED', 13);
INSERT INTO `library_schedule` VALUES (26, '09:00:00.000000', '13:00:00.000000', 'THU', 13);
INSERT INTO `library_schedule` VALUES (27, '14:00:00.000000', '16:30:00.000000', 'THU', 13);
INSERT INTO `library_schedule` VALUES (28, '09:00:00.000000', '14:00:00.000000', 'FRI', 13);

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
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

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
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `lastname` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_type_id` int(11) NOT NULL DEFAULT 1,
  `email` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `roles` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  INDEX `user_type_id`(`user_type_id`) USING BTREE,
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`user_type_id`) REFERENCES `user_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 281 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, 'bot', 'myNanterre', 2, 'bot@parisnanterre.fr', '[]', '$argon2id$v=19$m=65536,t=4,p=1$WURBNGFXc0xPYkQ4eFNVTA$LGzFmBErA2jtdUF7rhnufSf86CS3shEHvwlQVuiAR1A');
INSERT INTO `user` VALUES (65, 'test', 'testeur2', 1, 'test@parisnanterre.fr', '[]', '$argon2id$v=19$m=65536,t=4,p=1$c3VXcHYxVmNRdHRydUpGMA$+DozNKj9gp9c6pm3cY1eTXu5F2b07Cl9ulzu+NyaAOY');
INSERT INTO `user` VALUES (75, 'testeur', 'compte de test', 1, 'testeurcompte@parisnanterre.fr', '[]', '$argon2id$v=19$m=65536,t=4,p=1$aGU5RnZxeUNRSGxsNGhSUQ$lYOAtAQYujaKy0uevU/RBlqS7YraFWtqU/MCOYr9xIo');

-- ----------------------------
-- Table structure for user_type
-- ----------------------------
DROP TABLE IF EXISTS `user_type`;
CREATE TABLE `user_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user_type
-- ----------------------------
INSERT INTO `user_type` VALUES (1, 'student');
INSERT INTO `user_type` VALUES (2, 'administrator');
INSERT INTO `user_type` VALUES (3, 'club account');

-- ----------------------------
-- Table structure for users_clubs
-- ----------------------------
DROP TABLE IF EXISTS `users_clubs`;
CREATE TABLE `users_clubs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  INDEX `club_id`(`club_id`) USING BTREE,
  CONSTRAINT `users_clubs_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `users_clubs_ibfk_2` FOREIGN KEY (`club_id`) REFERENCES `club` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1151 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = FIXED;

-- ----------------------------
-- Records of users_clubs
-- ----------------------------
INSERT INTO `users_clubs` VALUES (1, 0, 2081);
INSERT INTO `users_clubs` VALUES (11, 0, 2091);
INSERT INTO `users_clubs` VALUES (21, 0, 2101);
INSERT INTO `users_clubs` VALUES (31, 0, 2111);
INSERT INTO `users_clubs` VALUES (41, 0, 2121);
INSERT INTO `users_clubs` VALUES (51, 0, 2131);
INSERT INTO `users_clubs` VALUES (61, 0, 2141);
INSERT INTO `users_clubs` VALUES (71, 0, 2151);
INSERT INTO `users_clubs` VALUES (81, 0, 2161);
INSERT INTO `users_clubs` VALUES (91, 0, 2171);
INSERT INTO `users_clubs` VALUES (355, 65, 2551);
INSERT INTO `users_clubs` VALUES (505, 65, 2121);

-- ----------------------------
-- Procedure structure for proc_initData
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_initData`;
delimiter ;;
CREATE PROCEDURE `proc_initData`()
BEGIN  
    DECLARE i INT DEFAULT 2081;  
    WHILE i<=2211 DO    
        INSERT INTO club_publication(message,date, club_id) VALUES('aaaaaaaaaaaaaaaaaaaaaaaaaaaa',NOW(), i);
        SET i = i+1;  
    END WHILE;  
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
