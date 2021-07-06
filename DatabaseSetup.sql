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
    `jobFamilyName` varchar NOT NULL,
    `disciplineLeadID` mediumint NOT NULL,
    PRIMARY KEY(`jobFamilyID`),
    FOREIGN KEY(`disciplineLeadID`) REFERENCES Employee(`employeeID`)
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
    FOREIGN KEY(`bandID`) REFERENCES Band(bandID)
);
