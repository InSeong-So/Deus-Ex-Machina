create table criminal(
    `no` int not null,
    name varchar(5) not null,
    sido varchar(2) not null,
    gungu varchar(15) not null,
    residence varchar(50) not null,    
    realResidence varchar(50) not null,
    delYn varchar(1) not null,
    `addDate` DATETIME DEFAULT CURRENT_TIMESTAMP
);

create table `users` (
    `userNo` int not null,
    `userEmail` varchar(30) not null,
    `userPassword` varchar(16) not null,
    `userName` varchar(8) not null,
    `userNumb` varchar(12) not null,
    `userAuthority` varchar(5) not null,
    `userDeleteYn` varchar(1) not null
);

create table `board` (
    `boardNo` int not null,
    `userNo` int not null,
    `boardTitle` varchar(30) not null,
    `boardContents` varchar(300) not null,
    `boardClass` varchar(5) not null,
    `comYn` varchar(1) not null,
    `regDate` DATETIME,
    `delYn` varchar(1) not null
);