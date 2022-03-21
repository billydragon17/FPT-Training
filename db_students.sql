drop schema db_students;
create schema db_students;
use db_students;


create table Item
(
	id int not null,
    student_name varchar(200),
    age int not null,
    student_description varchar(200),
    image varchar(10000),
    primary key (id)
);

create table Students
(
	student_id int not null,
    student_name varchar(100),
    primary key (student_id)
);

create table Subjects
(
	subject_id int not null,
    subject_name varchar(200),
    primary key (subject_id)
);

create table Students_and_Subjects
(
    student_id int not null,
    subject_id int not null,
    primary key (student_id, subject_id),
    foreign key (student_id) references Students (student_id),
    foreign key (subject_id) references Subjects (subject_id)
);


insert into Students values (1, 'John Smith');
insert into Students values (2, 'Jerry Wang');
insert into Students values (3, 'Mat Jack');

insert into Subjects values (1, 'Math');
insert into Subjects values (2, 'Bio');
insert into Subjects values (3, 'Physics');

insert into Students_and_Subjects values (1,1);
insert into Students_and_Subjects values (1,2);
insert into Students_and_Subjects values (2,1);
insert into Students_and_Subjects values (2,2);
insert into Students_and_Subjects values (3,1);
insert into Students_and_Subjects values (3,3);
insert into Students_and_Subjects values (1,3);




select ST.student_id, ST.student_name, SU.subject_name
from Students_and_Subjects as SS
	join Subjects as SU on SS.subject_id = SU.subject_id
	join Students as ST on SS.student_id = ST.student_id
    /*group by SU.subject_name*/;
    


