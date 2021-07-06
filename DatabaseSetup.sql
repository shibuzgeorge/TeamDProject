USE `RoleManagement_GroupD`;

CREATE TABLE `Employee`(
    `employeeID` mediumint NOT NULL AUTO_INCREMENT,
    `employeeName` varchar(255) NOT NULL,
    `employeeIDPhoto` blob NOT NULL,
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

INSERT INTO Band (`bandName`) VALUES ("Trainee");

INSERT INTO Employee (employeeName) VALUES ("Peter");

INSERT INTO Capability (capabilityName, capabilityLeadID) VALUES ("Engineering", 1);

INSERT INTO JobFamily (capabilityID, jobFamilyName, disciplineLeadID) VALUES (1, "Testing and Quality Assurance", 1);

INSERT INTO Role (roleName, capabilityID, jobFamilyID, bandID, specification) VALUES ("Trainee Test Engineer", 1, 1, 1, "Spec goes here");