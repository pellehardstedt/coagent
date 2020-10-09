INSERT INTO agents(Agent_Username) VALUES("Anna");
INSERT INTO agents(Agent_Username) VALUES("Björn");
INSERT INTO agents(Agent_Username) VALUES("Cecilia");
INSERT INTO agents(Agent_Username) VALUES("Daniel");
INSERT INTO agents(Agent_Username) VALUES("Erik");

INSERT INTO publishers(Publisher_Name) VALUES("Artimus");
INSERT INTO publishers(Publisher_Name) VALUES("Bonnier");
INSERT INTO publishers(Publisher_Name) VALUES("Climax Writers");
INSERT INTO publishers(Publisher_Name) VALUES("Diamond Digital");
INSERT INTO publishers(Publisher_Name) VALUES("Egmont");

INSERT INTO editors(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Adam", "Mystery", 1);
INSERT INTO editors(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Beatrice", "Thriller", 2);
INSERT INTO editors(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Carl", "Autobiography", 3);
INSERT INTO editors(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("David", "Horror", 4);
INSERT INTO editors(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Efraim", "Crime", 5);

INSERT INTO clients(Clients_Name) VALUES("Artsy Writers");
INSERT INTO clients(Clients_Name) VALUES("Bewildered Books");
INSERT INTO clients(Clients_Name) VALUES("Constant Stream");
INSERT INTO clients(Clients_Name) VALUES("Dawn Of Words");
INSERT INTO clients(Clients_Name) VALUES("Eclectic Writers");

INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES("Aghata Cristie",1);
INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES("Bam Magera", 2);
INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES("Cecil Con", 3);
INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES("Daniel Radcliffe", 4);
INSERT INTO authors(Authors_Name, Clients_Clients_Id) VALUES("Eric Clapton", 5);

INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Murder On The Nile", 1, 1);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Orient Express", 1, 1);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("CKY tales", 2, 2);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Skate or Die", 2, 2);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("The Art of Cheating", 3, 3);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("I tought Trump all he knows", 3, 3);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Hairy Potter", 4, 4);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Performing Naked", 4, 4);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Slow Hand", 5, 5);
INSERT INTO books(Books_Title, Agent_Agent_Id, Authors_Authors_Id) VALUES("Layla", 5, 5);

INSERT INTO themes(Theme) VALUES("Crime");
INSERT INTO themes(Theme) VALUES("Mystery");
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (1,1);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (1,2);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (2,1);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (2,2);

INSERT INTO themes(Theme) VALUES("Autobiography");
INSERT INTO themes(Theme) VALUES("Extreme sports");
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (3,3);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (3,4);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (4,3);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (4,4);

INSERT INTO themes(Theme) VALUES("Self help");
INSERT INTO themes(Theme) VALUES("Non-fiction");
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (5,5);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (5,6);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (6,5);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (6,6);

INSERT INTO themes(Theme) VALUES("celebrity");
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (7,7);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (7,1);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (8,7);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (8,3);

INSERT INTO themes(Theme) VALUES("music");
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (9,7);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (9,3);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (10,7);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (10,3);

INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(8, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 5);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(2, 5);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 2);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(2, 2);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 1);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(9, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(10, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(4, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(6, 3);

INSERT INTO contracts(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(8, 3, 3);
INSERT INTO contracts(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(1, 2, 2);
INSERT INTO contracts(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(6, 3, 3);

#A view to view all important info in all contracts, not just IDs
#Super nice to query for all contracts that an author, editor, publisher etc have signed
CREATE VIEW contract_all_info AS
SELECT books.Books_Title, authors.Authors_Name, clients.Clients_Name, editors.Editor_Name, publishers.Publisher_Name, agents.Agent_Username
FROM ((((((contracts
INNER JOIN books ON contracts.Books_Books_Id=books.Books_Id)
INNER JOIN authors ON books.Authors_Authors_Id = authors.Authors_Id)
INNER JOIN clients ON authors.Clients_Clients_Id = clients.Clients_Id)
INNER JOIN editors ON contracts.Editor_Editor_Id = editors.Editor_Id)
INNER JOIN publishers ON editors.Publisher_Publisher_Id = publishers.Publisher_Id)
INNER JOIN agents ON books.Agent_Agent_Id = agents.Agent_Id);

#Example query; search for the contract of the book 'murder on the nile'
SELECT * FROM contract_all_info;
SELECT * FROM contract_all_info WHERE Books_Title LIKE "murder%";

#View to view all themes assigned to a book in a pretty fashion
#Super nice to query for all books with a theme, or every theme a book has
CREATE VIEW theme_search AS
SELECT books.Books_Title, themes.Theme
FROM ((books
INNER JOIN book_has_theme ON books.Books_Id=book_has_theme.Books_Id)
INNER JOIN themes ON book_has_theme.Theme_Id = themes.Theme_Id);
#Select all books with theme Crime in the view theme_search
SELECT * FROM theme_search WHERE Theme = "Crime";

#A view with contract_all_info but with book themes
#Created to search for an editor to see what themes they might be interesed in
CREATE VIEW search_for_book_theme_editor AS
SELECT books.Books_Title, contract_all_info.Authors_Name, themes.Theme, contract_all_info.Editor_Name
FROM (((contract_all_info
INNER JOIN books ON contract_all_info.Books_Title=books.Books_Title)
INNER JOIN book_has_theme ON books.Books_Id=book_has_theme.Books_Id)
INNER JOIN themes ON book_has_theme.Theme_Id = themes.Theme_Id);
#Search the view to see what books/themes Beatrice have signed
SELECT * FROM search_for_book_theme_editor WHERE Editor_Name LIKE "Beatrice%";


# Stored procedure to update Submission when a editor replys
DELIMITER $$
DROP PROCEDURE IF EXISTS `Update_Submission_Reply`$$
CREATE PROCEDURE `Update_Submission_Reply`(
	`book_id` int,
    `editor_id` int,
	`reply` varchar(255))
BEGIN
	UPDATE submissions
	SET reply = `reply`
	WHERE Editor_Editor_Id = `editor_id` AND Books_Books_Id = `book_id`;
END $$
DELIMITER ;

#Use the stored procedure to update the submission with Id 1
CALL Update_Submission_Reply(2, 2, "this is great");

DELIMITER $$
DROP PROCEDURE IF EXISTS `Update_Submission_Reply_Grade`$$
CREATE PROCEDURE `Update_Submission_Reply_Grade`(
	`book_id` int,
    `editor_id` int,
    `reply_grade` int)
BEGIN
	UPDATE submissions
	SET Reply_Grade = `reply_grade`
	WHERE Editor_Editor_Id = `editor_id` AND Books_Books_Id = `book_id`;
END $$
DELIMITER ;
#Use the stored procedure to update the submission with Id 1
CALL Update_Submission_Reply_Grade(3, 3, 6);