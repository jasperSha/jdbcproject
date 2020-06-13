--sql to create the tables

--A Writing Group is a formalization of the collaboration of multiple writers, for both the purpose of making it easier to write lengthier or more extensive books, as well as improving the quality of their work greater than the sum of their individual efforts combined.
create table WritingGroups (
    groupName VARCHAR(25), --the name of the writing group
    headWriter VARCHAR(25), --the principle writer of the group
    yearFormed SMALLINT, --the year the Writing Group was started
    subject VARCHAR(15), --the realm of topics covered by the group

    CONSTRAINT writinggroups_pk PRIMARY KEY (groupName)
    
);

--A Book is a written or printed work that can be fiction or non-fiction, either for entertainment or for the purpose of teaching, or for both.
create table Books (
    groupName VARCHAR(25), --the name of the writing group that collaborated on the book
    bookTitle VARCHAR(25), --the name of the book
    publisherName VARCHAR(25), --the name of the publisher of the book
    yearPublished SMALLINT, --the year of publication
    numberPages INTEGER, --the number of pages of the book
   
    CONSTRAINT books_pk PRIMARY KEY (groupName, bookTitle),
    
    CONSTRAINT books_writinggroups_fk_01 FOREIGN KEY(groupName)
    REFERENCES WritingGroups(groupName),

    CONSTRAINT books_uk UNIQUE (bookTitle, publisherName)
   
);

--A publisher is a person or company that handles the distribution and sale of book or books written by authors or writing groups.
create table Publishers (
    publisherName VARCHAR(25), --the name of the publisher
    publisherAddress VARCHAR(30), --the address of the publishing company
    publisherPhone VARCHAR(14), --the contact phone of the publisher
    publisherEmail VARCHAR(25), --the contact email of the publisher

    CONSTRAINT publishers_pk PRIMARY KEY(publisherName)
);


alter table Books
ADD CONSTRAINT books_publishers_fk_02 FOREIGN KEY(publisherName)
    REFERENCES Publishers(publisherName);
