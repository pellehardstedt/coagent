INSERT INTO agent(Agent_Username) VALUES("Anna");
INSERT INTO agent(Agent_Username) VALUES("Björn");
INSERT INTO agent(Agent_Username) VALUES("Cecilia");
INSERT INTO agent(Agent_Username) VALUES("Daniel");
INSERT INTO agent(Agent_Username) VALUES("Erik");

INSERT INTO publisher(Publisher_Name) VALUES("Artimus");
INSERT INTO publisher(Publisher_Name) VALUES("Bonnier");
INSERT INTO publisher(Publisher_Name) VALUES("Climax Writers");
INSERT INTO publisher(Publisher_Name) VALUES("Diamond Digital");
INSERT INTO publisher(Publisher_Name) VALUES("Egmont");

INSERT INTO editor(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Adam", "Mystery", 1);
INSERT INTO editor(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Beatrice", "Thriller", 2);
INSERT INTO editor(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Carl", "Autobiography", 3);
INSERT INTO editor(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("David", "Horror", 4);
INSERT INTO editor(Editor_Name, Editor_Interested_In, Publisher_Publisher_Id) VALUES("Efraim", "Crime", 5);

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
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (9,9);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (9,3);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (10,9);
INSERT INTO book_has_theme(Books_Id, Theme_Id) VALUES (10,3);

INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(8, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 5);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(2, 5);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 2);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(2, 2);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 1);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(1, 2);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(9, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(10, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(4, 3);
INSERT INTO submissions(Books_Books_Id, Editor_Editor_Id) VALUES(6, 3);

INSERT INTO contract(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(8, 3, 3);
INSERT INTO contract(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(1, 2, 2);
INSERT INTO contract(Books_Books_Id, Publisher_Publisher_Id, Editor_Editor_Id) VALUES(6, 3, 3);

SELECT * FROM contract;

CREATE VIEW contract_all_info AS
SELECT books.Books_Title, authors.Authors_Name, clients.Clients_Name, editor.Editor_Name, publisher.Publisher_Name, agent.Agent_Username
FROM ((((((contract
INNER JOIN books ON contract.Books_Books_Id=books.Books_Id)
INNER JOIN authors ON books.Authors_Authors_Id = authors.Authors_Id)
INNER JOIN clients ON authors.Clients_Clients_Id = clients.Clients_Id)
INNER JOIN editor ON contract.Editor_Editor_Id = editor.Editor_Id)
INNER JOIN publisher ON editor.Publisher_Publisher_Id = publisher.Publisher_Id)
INNER JOIN agent ON books.Agent_Agent_Id = agent.Agent_Id);

SELECT * FROM contract_all_info WHERE Books_Title LIKE "murder%";

CREATE VIEW theme_search AS
SELECT books.Books_Title, themes.Theme
FROM ((books
INNER JOIN book_has_theme ON books.Books_Id=book_has_theme.Books_Id)
INNER JOIN themes ON book_has_theme.Theme_Id = themes.Theme_Id);


SELECT * FROM theme_search WHERE Theme = "Crime";

CREATE PROCEDURE `Update_Submission` (`reply` varchar(255), `id` int)
BEGIN
UPDATE submissions
SET reply = @reply
WHERE Submissions_Id = @id
END;
EXEC Update_Submission @reply = 'this is great', @id = '12'; 