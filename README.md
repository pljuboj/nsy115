# Projet de Predrag et Stephane -> NSY115

### Liens utiles
* http://stackoverflow.com/questions/21559260/how-do-i-pass-a-parameter-to-the-onopen-method-with-jee7-websockets
* https://gesker.wordpress.com/2014/09/09/glassfish-4-1-on-ubuntu-14-04/
* http://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.35.zip
* http://stackoverflow.com/questions/11223235/mysql-root-access-from-all-hosts
* http://www.tocker.ca/2014/04/21/installing-mysql-5-6-on-ubuntu-14-04-trusty-tahr.html
* vi /etc/mysql/my.cnf
* https://computingat40s.wordpress.com/how-to-setup-a-jdbc-connection-in-glassfish/
* http://stackoverflow.com/questions/23646389/how-to-configure-and-get-session-in-hibernate-4-3-4-final
* http://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html_single/#transactions-demarcation-nonmanaged
* http://stackoverflow.com/questions/16275928/hibernate-session-save-does-not-reflect-in-database

```
CREATE TABLE `nsy115`.`partie` (
  `idpartie` INT NOT NULL AUTO_INCREMENT,
  `x1` VARCHAR(45) NULL,
  `x2` VARCHAR(45) NULL,
  `x3` VARCHAR(45) NULL,
  `y1` VARCHAR(45) NULL,
  `y2` VARCHAR(45) NULL,
  `y3` VARCHAR(45) NULL,
  `z1` VARCHAR(45) NULL,
  `z2` VARCHAR(45) NULL,
  `z3` VARCHAR(45) NULL,
  PRIMARY KEY (`idpartie`));

CREATE TABLE `nsy115`.`joueur` (
  `idjoueur` VARCHAR(45) NOT NULL,
  `motdepasse` VARCHAR(32) NULL,
  PRIMARY KEY (`idjoueur`));

CREATE TABLE `nsy115`.`jouer` (
  `idjoueur` VARCHAR(45) NOT NULL,
  `idpartie` INT NOT NULL,
  PRIMARY KEY (`idjoueur`, `idpartie`),
  INDEX `idpartie_idx` (`idpartie` ASC),
  CONSTRAINT `idjoueur`
    FOREIGN KEY (`idjoueur`)
    REFERENCES `nsy115`.`joueur` (`idjoueur`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idpartie`
    FOREIGN KEY (`idpartie`)
    REFERENCES `nsy115`.`partie` (`idpartie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
```

