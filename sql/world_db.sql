-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Dim 31 Mai 2015 à 17:06
-- Version du serveur :  5.5.39
-- Version de PHP :  5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `world_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) CHARACTER SET latin1 NOT NULL,
  `authority` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('user', 'USER');

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
`id` int(11) NOT NULL,
  `code` varchar(16) NOT NULL,
  `creation_date` datetime NOT NULL,
  `modification_date` datetime NOT NULL,
  `population_count` bigint(20) NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified_by` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `country_ln`
--

CREATE TABLE IF NOT EXISTS `country_ln` (
  `capital_name` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `country_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
`id` int(11) NOT NULL,
  `code` varchar(4) NOT NULL,
  `name` varchar(32) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `language`
--

INSERT INTO `language` (`id`, `code`, `name`) VALUES
(1, 'en', 'en'),
(2, 'fr', 'fr');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `language_id` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `enabled`, `password`, `username`, `language_id`) VALUES
(1, b'1', '$2a$10$7F6h1inso6yO06VBsegO2Ow.AXcyYGkMhAqKgzV01re6NkK/uOqRW', 'user', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `authorities`
--
ALTER TABLE `authorities`
 ADD UNIQUE KEY `authorities_idx_1` (`username`,`authority`);

--
-- Index pour la table `country`
--
ALTER TABLE `country`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UK_b21n3qasjpw15cb0vfv9u39l1` (`created_by`), ADD UNIQUE KEY `UK_3g745vucqlxjsn79d9ry00pi7` (`modified_by`);

--
-- Index pour la table `country_ln`
--
ALTER TABLE `country_ln`
 ADD PRIMARY KEY (`language_id`,`country_id`,`capital_name`,`name`), ADD UNIQUE KEY `UK_r7d1vslpsfltn3md0q0bl3jn3` (`language_id`), ADD KEY `FK_6k3lk082w0o19ren3lvll1k1j` (`country_id`);

--
-- Index pour la table `language`
--
ALTER TABLE `language`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`), ADD KEY `FK_8odbkjsn87dfv44cs4h6ub5ox` (`language_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `country`
--
ALTER TABLE `country`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `language`
--
ALTER TABLE `language`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `country`
--
ALTER TABLE `country`
ADD CONSTRAINT `FK_3g745vucqlxjsn79d9ry00pi7` FOREIGN KEY (`modified_by`) REFERENCES `users` (`id`),
ADD CONSTRAINT `FK_b21n3qasjpw15cb0vfv9u39l1` FOREIGN KEY (`created_by`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `country_ln`
--
ALTER TABLE `country_ln`
ADD CONSTRAINT `FK_6k3lk082w0o19ren3lvll1k1j` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
ADD CONSTRAINT `FK_r7d1vslpsfltn3md0q0bl3jn3` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `FK_8odbkjsn87dfv44cs4h6ub5ox` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
