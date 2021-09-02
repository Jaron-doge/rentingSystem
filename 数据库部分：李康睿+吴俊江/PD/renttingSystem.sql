/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/9/2 10:52:01                            */
/*==============================================================*/


drop table if exists House;

drop table if exists Manager;

drop table if exists User;

/*==============================================================*/
/* Table: House                                                 */
/*==============================================================*/
create table House
(
   houseId              int not null,
   userId               decimal(11) not null,
   managerId            decimal(11) not null,
   city                 varchar(16) not null,
   district             varchar(16) not null,
   price                decimal(7,2) not null,
   type                 varchar(16) not null,
   area                 decimal(5,2) not null,
   address              varchar(64) not null,
   detail               text,
   primary key (houseId)
);

/*==============================================================*/
/* Table: Manager                                               */
/*==============================================================*/
create table Manager
(
   managerId            decimal(11) not null,
   managerPwd           varchar(32) not null,
   managerName          varchar(16) default '管理员',
   houseSum             int default 0,
   primary key (managerId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   userId               decimal(11) not null,
   userPwd              varchar(32) not null,
   userName             varchar(16) default '游客',
   primary key (userId)
);

alter table House add constraint FK_manage foreign key (managerId)
      references Manager (managerId) on delete restrict on update restrict;

alter table House add constraint FK_own foreign key (userId)
      references User (userId) on delete restrict on update restrict;

