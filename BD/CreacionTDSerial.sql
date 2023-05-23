Create Table Rol(
	ID_Rol serial,
	Rol varchar(15),
	primary key (ID_Rol)
);
CREATE TABLE Mutante(
	Curp serial not null,
	Nombre varchar (20) not null,
	Apellido_Pat varchar (20),
	Apellido_Mat varchar (20),
	Poder varchar(25),
	N_Alias varchar (35),
	fecha_nac date,
	cel varchar(18),
	direcc varchar (35),
	Rol int not null,
	constraint pk_Curp primary key (Curp),
	foreign key (Rol) references Rol(ID_Rol)
);



Create Table Presentaciones(
	N_Presentacion serial not null,
	Presentacion varchar(35),
	Dia date,
	Horario time not null,
	primary key(N_Presentacion)
);

Create Table Asist_Presentacion(
	N_Presentacion int,
	Curp int,
	foreign key (N_Presentacion) references Presentaciones(N_Presentacion),
	foreign key (Curp) references Mutante(Curp)
);


Create TABLE T_Profesores(
	ID_TipoP serial,
	Tiempo varchar(15),
	 primary key (ID_TipoP)
);
Create table Tipo_Leccion(
	ID_TipoL serial,
	Tipo_Leccion varchar (20),
	 primary key (ID_TipoL)
);


Create Table Lecciones(
	ID_Leccion serial not null,
	Leccion varchar (20),
	Horario_Ini time Not Null,
	Horario_Fin time Not null,
	creditos int,
	Tipo_Leccion int,
	Constraint pk_IDLeccion primary key (ID_Leccion),
	foreign key (Tipo_Leccion) references Tipo_Leccion(ID_TipoL) on delete cascade
);

CREATE TABLE Profesor(
	Matricula_P  serial not null,
	Remuneracion int ,
	T_Profesores int,
	Correo_Inst varchar (35),
	Contraseña varchar(30),
	Status varchar(15),
	PRIMARY KEY(Matricula_P),
	foreign key (T_Profesores) references T_Profesores(ID_TipoP) on delete cascade
)INHERITS (Mutante);

Create Table CursoProf(
	Matricula_Prof int,
	ID_Leccion int,
	semestre varchar (15),
	foreign key (Matricula_Prof) references Profesor(Matricula_P),
	foreign key (ID_Leccion) references Lecciones(ID_Leccion) on delete cascade 
);

CREATE TABLE Estudiantes(
	Matricula serial not null,
	Correo_Inst varchar(35),
	Contraseña varchar (30),
	Status varchar(15),
	PRIMARY KEY(Matricula)
)INHERITS (Mutante);

Create Table Curso(
	ID_Est int,
	ID_Leccion int,
	calificacion decimal(10,2),
	foreign key (ID_Est) references Estudiantes(Matricula),
	foreign key (ID_Leccion) references Lecciones(ID_Leccion) on delete cascade
);








