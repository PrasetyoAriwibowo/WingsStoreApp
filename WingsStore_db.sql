PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE android_metadata (locale TEXT);
INSERT INTO android_metadata VALUES('en_US');
CREATE TABLE `login` (`userName` TEXT NOT NULL, `password` TEXT NOT NULL, PRIMARY KEY(`userName`));
INSERT INTO login VALUES('aa','bb');
INSERT INTO login VALUES('prasetyo99','qwerasd');
CREATE TABLE `product` (`productCode` TEXT NOT NULL, `productName` TEXT NOT NULL, `price` REAL NOT NULL, `currency` TEXT NOT NULL, `discount` REAL NOT NULL, `dimension` TEXT NOT NULL, `unit` TEXT NOT NULL, `photo` INTEGER NOT NULL, PRIMARY KEY(`productCode`));
INSERT INTO product VALUES('SKLNPW135','So Klin Pewangi',15000.0,'IDR',10.0,'25cm x 15cm x 10cm','Pcs',2131165389);
INSERT INTO product VALUES('GVB11','Giv Biru',16000.0,'IDR',0.0,'20cm x 10cm x 8cm','Pcs',2131165324);
INSERT INTO product VALUES('SKLNLQ11','So Klin Liquid',17999.999999999999999,'IDR',0.0,'25cm x 15cm x 10cm','Pcs',2131165388);
INSERT INTO product VALUES('GVK10','Giv Kuning',13999.999999999999999,'IDR',0.0,'20cm x 10cm x 8cm','Pcs',2131165325);
CREATE TABLE `transactionHeader` (`documentCode` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `documentNumber` TEXT NOT NULL, `userName` TEXT NOT NULL, `total` REAL NOT NULL, `date` TEXT NOT NULL);
INSERT INTO transactionHeader VALUES(1,'DCNB-962728187','aa',27500.0,'2022-10-15T14:06:50.858286');
INSERT INTO transactionHeader VALUES(2,'DCNB-962728187','aa',32000.0,'2022-10-15T14:16:56.422582');
INSERT INTO transactionHeader VALUES(3,'DCNB1554','aa',48000.000000000000001,'2022-10-15T17:09:03.174344');
INSERT INTO transactionHeader VALUES(4,'DCNB1080','aa',32000.0,'2022-10-15T17:09:19.133674');
CREATE TABLE `transactionDetail` (`documentCode` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `documentNumber` TEXT NOT NULL, `productCode` TEXT NOT NULL, `price` REAL NOT NULL, `quantity` INTEGER NOT NULL, `unit` TEXT NOT NULL, `subTotal` REAL NOT NULL, `currency` TEXT NOT NULL);
INSERT INTO transactionDetail VALUES(1,'DCNB-962728190','GVK10',13999.999999999999999,1,'Pcs',13999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(2,'DCNB-962728190','SKLNPW135',13500.0,1,'Pcs',13500.0,'IDR');
INSERT INTO transactionDetail VALUES(3,'DCNB-962728190','GVK10',13999.999999999999999,1,'Pcs',13999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(4,'DCNB-962728190','SKLNLQ11',17999.999999999999999,1,'Pcs',17999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(5,'DCNB1551','GVK10',13999.999999999999999,1,'Pcs',13999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(6,'DCNB1551','GVB11',16000.0,1,'Pcs',16000.0,'IDR');
INSERT INTO transactionDetail VALUES(7,'DCNB1551','SKLNLQ11',17999.999999999999999,1,'Pcs',17999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(8,'DCNB1077','GVK10',13999.999999999999999,1,'Pcs',13999.999999999999999,'IDR');
INSERT INTO transactionDetail VALUES(9,'DCNB1077','SKLNLQ11',17999.999999999999999,1,'Pcs',17999.999999999999999,'IDR');
CREATE TABLE `checkout` (`productCode` TEXT NOT NULL, `quantity` INTEGER NOT NULL, PRIMARY KEY(`productCode`));
INSERT INTO checkout VALUES('GVB11',1);
INSERT INTO checkout VALUES('SKLNLQ11',1);
INSERT INTO checkout VALUES('SKLNPW135',1);
CREATE TABLE room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT);
INSERT INTO room_master_table VALUES(42,'e0f26fd39ebcef669b240f65be9a2431');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('transactionHeader',4);
INSERT INTO sqlite_sequence VALUES('transactionDetail',9);
COMMIT;