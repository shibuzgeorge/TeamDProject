USE `RoleManagement_GroupD`;

CREATE TABLE `Employee`(
    `employeeID` mediumint NOT NULL AUTO_INCREMENT,
    `employeeName` varchar(255) NOT NULL,
    `employeeIDPhoto` mediumblob NOT NULL,
    PRIMARY KEY(`employeeID`)
);

CREATE TABLE `Capability`(
    `capabilityID` mediumint NOT NULL AUTO_INCREMENT,
    `capabilityName` varchar(255) NOT NULL,
    `capabilityLeadID` mediumint,
    PRIMARY KEY(`capabilityID`),
    FOREIGN KEY(`capabilityLeadID`) REFERENCES Employee(`employeeID`)
);

CREATE TABLE `Band`(
    `bandID` mediumint NOT NULL AUTO_INCREMENT,
    `bandName` varchar(255) NOT NULL,
    PRIMARY KEY(`bandID`)
);

CREATE TABLE `JobFamily`(
    `jobFamilyID` mediumint NOT NULL AUTO_INCREMENT,
    `capabilityID` mediumint NOT NULL,
    `jobFamilyName` varchar(255) NOT NULL,
    `disciplineLeadID` mediumint NOT NULL,
    PRIMARY KEY(`jobFamilyID`),
    FOREIGN KEY(`disciplineLeadID`) REFERENCES Employee(`employeeID`),
    FOREIGN KEY(`capabilityID`) REFERENCES Capability(`capabilityID`)
);

CREATE TABLE `Role`(
    `roleID` mediumint NOT NULL AUTO_INCREMENT,
    `roleName` varchar(255) NOT NULL,
    `capabilityID` mediumint NOT NULL,
    `jobFamilyID` mediumint NOT NULL,
    `bandID` mediumint NOT NULL,
    `specification` text NOT NULL,
    PRIMARY KEY(`roleID`),
    FOREIGN KEY(`capabilityID`) REFERENCES Capability(capabilityID),
    FOREIGN KEY(`bandID`) REFERENCES Band(bandID),
    FOREIGN KEY(`jobFamilyID`) REFERENCES JobFamily(`jobFamilyID`)
);

CREATE VIEW `RoleListWithID` AS
    SELECT R.roleID, R.roleName, C.capabilityName, JF.jobFamilyName, B.bandName, R.specification
    FROM `Role` R
    LEFT JOIN `Capability` C
        ON R.capabilityID = C.capabilityID
    LEFT JOIN `Band` B
        ON R.bandID = B.bandID
    LEFT JOIN `JobFamily` JF
        ON R.jobFamilyID = JF.jobFamilyID;

CREATE VIEW `RoleListWithoutID` AS
    SELECT R.roleName, C.capabilityName, JF.jobFamilyName, B.bandName, R.specification
    FROM `Role` R
    LEFT JOIN `Capability` C
        ON R.capabilityID = C.capabilityID
    LEFT JOIN `Band` B
        ON R.bandID = B.bandID
    LEFT JOIN `JobFamily` JF
        ON R.jobFamilyID = JF.jobFamilyID;

CREATE VIEW `CapabilityLeads` AS
SELECT C.capabilityName, E.employeeID, E.employeeName, E.employeeIDPhoto
FROM Capability C
         LEFT JOIN Employee E
                   on C.capabilityLeadID = E.employeeID

INSERT INTO Band (`bandName`) VALUES ("Associate");

INSERT INTO Employee (employeeName) VALUES ("Dean");

INSERT INTO Capability (capabilityName, capabilityLeadID) VALUES ("Engineering", 1);

INSERT INTO JobFamily (capabilityID, jobFamilyName, disciplineLeadID) VALUES (1, "Engineering", 2);

INSERT INTO Role (roleName, capabilityID, jobFamilyID, bandID, specification) VALUES ("Software Engineer", 1, 2, 2, "Spec goes here");