USE
`sql11444178` ;

-- -----------------------------------------------------
-- Table `AutoSkola`.`Kandidat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`Kandidat`
(
    `JMBG` VARCHAR
(
    13
) NOT NULL,
    `Ime` VARCHAR
(
    15
) NOT NULL,
    `ImeOca` VARCHAR
(
    15
) NOT NULL,
    `Prezime` VARCHAR
(
    20
) NOT NULL,
    `DatumRodjenja` DATETIME NOT NULL,
    `MjestoRodjenja` VARCHAR
(
    45
) NOT NULL,
    `MjestoStanovanja` VARCHAR
(
    45
) NOT NULL,
    `Adresa` VARCHAR
(
    45
) NOT NULL,
    `BrojTelefona` VARCHAR
(
    9
) NOT NULL,
    `BrojLicneKarte` VARCHAR
(
    10
) NOT NULL,
    `BrojKnjiziceKandidata` INT NULL,
    `BrojFiskalnogRacuna` INT NULL,
    `BrojLjekarskogUvjerenja` VARCHAR
(
    12
) NULL,
    `UstanovaLjekarsko` VARCHAR
(
    45
) NULL,
    `DatumIzdavanjaLjekarskog` DATETIME NULL,
    `BrojPotvrdePropisi` VARCHAR
(
    12
) NULL,
    `DatumPotvrdePropisi` DATETIME NULL,
    `BrojPotvrdePrvaPomoc` VARCHAR
(
    12
) NULL,
    `DatumPotvrdePrvaPomoc` DATETIME NULL,
    `BrojPotvrdeVoznja` VARCHAR
(
    12
) NULL,
    `DatumPotvrdeVoznja` DATETIME NULL,
    `BrojIzlazakaPropisi` INT NOT NULL,
    `BrojIzlazakaPrvaPomoc` INT NOT NULL,
    `BrojIzlazakaVoznja` INT NOT NULL,
    `GrupaZaTeoretskuNastavu` VARCHAR
(
    12
) NULL,
    `OdslusanihCasovaVoznje` INT NULL,
    `TrebaPlatiti` DOUBLE NULL,
    `DoSadPlatio` DOUBLE NULL,
    `InstruktorJMBG` VARCHAR
(
    13
) NULL,
    `KategorijaTip` INT NULL,
    PRIMARY KEY
(
    `JMBG`
),
    UNIQUE INDEX `InstruktorJMBG_UNIQUE`
(
    `InstruktorJMBG` ASC
) ,
    UNIQUE INDEX `KategorijaTip_UNIQUE`
(
    `KategorijaTip` ASC
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`Instruktor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`Instruktor`
(
    `JMBG` VARCHAR
(
    13
) NOT NULL,
    `Ime` VARCHAR
(
    15
) NOT NULL,
    `ImeOca` VARCHAR
(
    15
) NOT NULL,
    `Prezime` VARCHAR
(
    20
) NOT NULL,
    `DatumRodjenja` DATETIME NOT NULL,
    `MjestoRodjenja` VARCHAR
(
    45
) NOT NULL,
    `MjestoStanovanja` VARCHAR
(
    45
) NOT NULL,
    `Adresa` VARCHAR
(
    45
) NULL,
    `BrojTelefona` VARCHAR
(
    9
) NOT NULL,
    `BrojLicneKarte` VARCHAR
(
    10
) NOT NULL,
    `ZaposlenOd` DATETIME NOT NULL,
    `Plata` DOUBLE NOT NULL,
    `BrojObucenihKandidata` INT NULL,
    `Slika` VARCHAR
(
    100
) NULL,
    PRIMARY KEY
(
    `JMBG`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`Kategorija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`Kategorija`
(
    `Tip`
    INT
    NOT
    NULL,
    `BrojCasovaTeorija`
    INT
    NOT
    NULL,
    `CijenaCasaTeorija`
    FLOAT
    NOT
    NULL,
    `BrojCasovaVoznja`
    INT
    NOT
    NULL,
    `CijenaCasaVoznja`
    FLOAT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `Tip`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`obucava`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`obucava`
(
    `JMBGInstruktor`
    INT
    NOT
    NULL,
    `TipKategorija`
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    `JMBGInstruktor`,
    `TipKategorija`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`DodatniTroskovi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`DodatniTroskovi`
(
    `ID`
    INT
    NOT
    NULL,
    `Naziv`
    VARCHAR
(
    45
) NOT NULL,
    `Iznos` DOUBLE NOT NULL,
    PRIMARY KEY
(
    `ID`
))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`Termin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`Termin`
(
    `ID`
    INT
    NOT
    NULL,
    `KanidatJMBG`
    VARCHAR
(
    13
) NOT NULL,
    `InstruktorJMBG` VARCHAR
(
    13
) NOT NULL,
    `VrijemePocetka` DATETIME NOT NULL,
    `VrijemeZavrsetka` DATETIME NOT NULL,
    `Tip` INT NOT NULL,
    `Lokacija` VARCHAR
(
    45
) NOT NULL,
    `Prevoz` TINYINT NOT NULL,
    PRIMARY KEY
(
    `ID`
),
    UNIQUE INDEX `KanidatJMBG_UNIQUE`
(
    `KanidatJMBG` ASC
) ,
    UNIQUE INDEX `InstruktorJMBG_UNIQUE`
(
    `InstruktorJMBG` ASC
) )
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AutoSkola`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql11444178`.`Admin`
(
    `Username` VARCHAR
(
    15
) NOT NULL,
    `Password` VARCHAR
(
    10
) NOT NULL,
    PRIMARY KEY
(
    `Username`
))
    ENGINE = InnoDB;


SET
SQL_MODE=@OLD_SQL_MODE;
SET
FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET
UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
