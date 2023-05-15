CREATE TABLE Mutante(
	Curp varchar (10) not null,
	Nombre varchar (20) not null,
	Apellido_Pat varchar (20),
	Apellido_Mat varchar (20),
	Poder varchar(25),
	N_Alias varchar (35),
	fecha_nac date,
	cel varchar(18),
	direcc varchar (35),
	Rol varchar(15),
	constraint pk_Curp primary key (Curp)
);

Create Table Presentaciones(
	N_Presentacion varchar (25),
	Dia date,
	Horario time not null,
	Curp varchar(10),
	foreign key (Curp) references Mutante(Curp) on delete cascade
);


Create TABLE T_Profesores(
	ID_TipoP int (1),
	Tiempo varchar(15),
	Constraint pk_IDTipoP primary key (ID_TipoP)
);
Create table Tipo_Leccion(
	ID_TipoL int (1),
	Tipo_Leccion varchar (20),
	Constraint pk_IDTipoL primary key (ID_TipoL)
);


Create Table Lecciones(
	ID_Leccion int (3),
	Leccion varchar (20),
	Horario_Ini time Not Null,
	Horario_Fin time Not null,
	creditos int (2),
	Tipo_Leccion int (2),
	Constraint pk_IDLeccion primary key (ID_Leccion),
	foreign key (Tipo_Leccion) references Tipo_Leccion(ID_TipoL) on delete cascade
);

CREATE TABLE Profesor(
	Matricula_P  serial,
	Remuneracion int (3),
	T_Profesores int (1),
	Correo_Inst varchar (35),
	PRIMARY KEY(Matricula_P),
	foreign key (T_Profesores) references T_Profesores(ID_TipoP) on delete cascade
)INHERITS (Mutante);

Create Table CursoProf(
	Matricula_Prof int(2),
	ID_Leccion int (3),
	semestre varchar (15),
	foreign key (Matricula_Prof) references Profesor(Matricula_P),
	foreign key (ID_Leccion) references Lecciones(ID_Leccion) on delete cascade 
);

CREATE TABLE Estudiantes(
	Matricula Serial,
	Correo_Inst varchar(35),
	PRIMARY KEY(Matricula)
)INHERITS (Mutante);

Create Table Curso(
	ID_Est int (2),
	ID_Leccion int (3),
	calificacion decimal(10,2),
	foreign key (ID_Est) references Estudiantes(Matricula),
	foreign key (ID_Leccion) references Lecciones(ID_Leccion) on delete cascade
);








