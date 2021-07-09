USE `RoleManagement_GroupD`;

DROP TABLE IF EXISTS `Employee`
CREATE TABLE `Employee`(
    `employeeID` mediumint NOT NULL AUTO_INCREMENT,
    `employeeName` varchar(255) NOT NULL,
    `employeeIDPhoto` mediumblob NOT NULL,
    PRIMARY KEY(`employeeID`)
);

DROP TABLE IF EXISTS `Capability`
CREATE TABLE `Capability`(
    `capabilityID` mediumint NOT NULL AUTO_INCREMENT,
    `capabilityName` varchar(255) NOT NULL,
    `capabilityLeadID` mediumint,
    `capabilityLeadMessage` varchar(300),
    PRIMARY KEY(`capabilityID`),
    FOREIGN KEY(`capabilityLeadID`) REFERENCES Employee(`employeeID`)
);

DROP TABLE IF EXISTS `Band`
CREATE TABLE `Band`(
    `bandID` mediumint NOT NULL AUTO_INCREMENT,
    `bandName` varchar(255) NOT NULL,
    PRIMARY KEY(`bandID`)
);

DROP TABLE IF EXISTS `JobFamily`
CREATE TABLE `JobFamily`(
    `jobFamilyID` mediumint NOT NULL AUTO_INCREMENT,
    `capabilityID` mediumint NOT NULL,
    `jobFamilyName` varchar(255) NOT NULL,
    `disciplineLeadID` mediumint NOT NULL,
    PRIMARY KEY(`jobFamilyID`),
    FOREIGN KEY(`disciplineLeadID`) REFERENCES Employee(`employeeID`),
    FOREIGN KEY(`capabilityID`) REFERENCES Capability(`capabilityID`)
);

DROP TABLE IF EXISTS `Role`
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

DROP VIEW IF EXISTS `RoleListWithID`
CREATE VIEW `RoleListWithID` AS
    SELECT R.roleID, R.roleName, C.capabilityName, JF.jobFamilyName, B.bandName, R.specification, R.roleSummary
    FROM `Role` R
    LEFT JOIN `Capability` C
        ON R.capabilityID = C.capabilityID
    LEFT JOIN `Band` B
        ON R.bandID = B.bandID
    LEFT JOIN `JobFamily` JF
        ON R.jobFamilyID = JF.jobFamilyID
    ORDER BY C.capabilityName, JF.jobFamilyName, B.bandID;

DROP VIEW IF EXISTS `RoleListWithoutID`
CREATE VIEW `RoleListWithoutID` AS
    SELECT R.roleName, C.capabilityName, JF.jobFamilyName, B.bandName, R.specification
    FROM `Role` R
    LEFT JOIN `Capability` C
        ON R.capabilityID = C.capabilityID
    LEFT JOIN `Band` B
        ON R.bandID = B.bandID
    LEFT JOIN `JobFamily` JF
        ON R.jobFamilyID = JF.jobFamilyID
    ORDER BY C.capabilityName, JF.jobFamilyName, B.bandID;

DROP VIEW IF EXISTS `CapabilityLeads`
CREATE VIEW `CapabilityLeads` AS
    SELECT C.capabilityName, E.employeeID, E.employeeName, E.employeeIDPhoto
    FROM Capability C
    LEFT JOIN Employee E
        ON C.capabilityLeadID = E.employeeID;

INSERT INTO Band (`bandName`) VALUES ('Apprentice');
INSERT INTO Band (`bandName`) VALUES ('Trainee');
INSERT INTO Band (`bandName`) VALUES ('Associate');
INSERT INTO Band (`bandName`) VALUES ('Senior Associate');
INSERT INTO Band (`bandName`) VALUES ('Consultant');
INSERT INTO Band (`bandName`) VALUES ('Manager');
INSERT INTO Band (`bandName`) VALUES ('Principal');

INSERT INTO Employee (employeeName) VALUES ('Peter');
INSERT INTO Employee (employeeName) VALUES ('Dean');
INSERT INTO Employee (employeeName) VALUES ('Shibu');
INSERT INTO Employee (employeeName) VALUES ('Seweryn');
INSERT INTO Employee (employeeName) VALUES ('Conor');

INSERT INTO Capability (capabilityName, capabilityLeadID) VALUES ('Engineering', 1);
INSERT INTO Capability (capabilityName, capabilityLeadID) VALUES ('Artificial Intelligence', 2);
INSERT INTO Capability (capabilityName, capabilityLeadID) VALUES ('Platforms', 3);

INSERT INTO JobFamily (capabilityID, jobFamilyName, disciplineLeadID) VALUES (1, 'Testing And Quality Assurance', 1);
INSERT INTO JobFamily (capabilityID, jobFamilyName, disciplineLeadID) VALUES (2, 'Engineering', 2);
INSERT INTO JobFamily (capabilityID, jobFamilyName, disciplineLeadID) VALUES (3, 'Artificial Intelligence (AI) Engineering', 3);

INSERT INTO Role VALUES (1, 'Test Engineer', 1, 1, 2, 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EcGbc8drFRlBoh2H2BZSeVwBV1tAiDCTwirdTmrz2EYYmQ?e=XMqXJh', 'Developing and executing functional automated and manual tests');
INSERT INTO Role VALUES (2, 'Software Engineer', 1, 2, 3, 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EYTCv1ssl6pOuH59zXtoF9YB8qNaEMNSkZIkCthDAY5Kjg?e=Ht84rW', 'Developing high quality programming solutions');
INSERT INTO Role VALUES (3,'Apprentice AI Engineer', 2, 3, 1, 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/Eci7E2WouKdNr5A-q3F9f8wBe9UEdviulHqKp0LVh3BH3A?e=gEI9JV', 'The development of high-quality solutions which integrate AI and ML technologies');
INSERT INTO Role VALUES (5, 'Senior AI Engineer', 2, 3, 4, 'https://kainossoftwareltd.sharepoint.com/:b:/g/people/EWi__EluLhNIvhHUYsUb9noBwzGggNoYcTzOZD4NAeNhHg?e=VJqYaX', 'High quality solutions that use AI and ML technologies');
