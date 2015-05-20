-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 20 Mai 2015 à 15:53
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
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `population_count` bigint(20) NOT NULL,
  `capital_name` varchar(32) NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `creation_date` datetime NOT NULL,
  `modified_by` varchar(50) NOT NULL,
  `modification_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `country_ln`
--

CREATE TABLE IF NOT EXISTS `country_ln` (
`id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
`id` int(11) NOT NULL,
  `name` varchar(32) NOT NULL,
  `code` varchar(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `language`
--

INSERT INTO `language` (`id`, `name`, `code`) VALUES
(1, 'English', 'en'),
(2, 'Francais', 'fr');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `language_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`, `language_id`) VALUES
('user', '$2a$10$7F6h1inso6yO06VBsegO2Ow.AXcyYGkMhAqKgzV01re6NkK/uOqRW', 1, 1);

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
 ADD PRIMARY KEY (`id`), ADD KEY `modified_by` (`modified_by`), ADD KEY `created_by` (`created_by`), ADD KEY `modified_by_2` (`modified_by`), ADD KEY `created_by_2` (`created_by`);

--
-- Index pour la table `country_ln`
--
ALTER TABLE `country_ln`
 ADD PRIMARY KEY (`id`), ADD KEY `country_id` (`country_id`), ADD KEY `language_id` (`language_id`), ADD KEY `country_id_2` (`country_id`), ADD KEY `language_id_2` (`language_id`);

--
-- Index pour la table `language`
--
ALTER TABLE `language`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`username`), ADD KEY `language_id` (`language_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `country`
--
ALTER TABLE `country`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `country_ln`
--
ALTER TABLE `country_ln`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `language`
--
ALTER TABLE `language`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `authorities`
--
ALTER TABLE `authorities`
ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `country`
--
ALTER TABLE `country`
ADD CONSTRAINT `country_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `users` (`username`),
ADD CONSTRAINT `country_ibfk_2` FOREIGN KEY (`modified_by`) REFERENCES `users` (`username`);

--
-- Contraintes pour la table `country_ln`
--
ALTER TABLE `country_ln`
ADD CONSTRAINT `country_ln_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
ADD CONSTRAINT `country_ln_ibfk_2` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`);

--
-- Contraintes pour la table `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`language_id`) REFERENCES `language` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
