BEGIN TRANSACTION;

DROP TABLE IF EXISTS valeurs;

CREATE TABLE valeurs
	(datecpt TEXT NOT NULL,
	ncpt INTEGER NOT NULL,
	val INTEGER NOT NULL,
	unite TEXT NOT NULL);



END TRANSACTION;

