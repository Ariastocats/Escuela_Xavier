
Insert into Rol(Rol) values
('Profesor'),
('Estudiante'),
('Aspirante');

Select * from Curso;

Insert into Mutante(Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol)values
('Scott','Summers','','Ráfaga Óptica','Ciclope','1977-09-22','+1 413-475-4928','887 Timbercrest Road',1),
('Jean Elaine','Grey','','telepatía/telequinética','Fénix','1967-01-01','+1 207-932-8680','3606 West Virginia Avenue',1),
('Robbert Louis','Drake','','Termoquinesis','Iceman','1998-06-28','+1 251-644-6467','746 Stanley Avenue',2),
('Lucy','Johnson','Jones','Ilusiones','Divinity','2005-06-08','+1 505-543-0660','2111 Jadewood Drive',3);

Insert into Presentaciones(Presentacion,Dia,Horario)values
('Charla Educativa','2023-09-12','18:00:00'),
('Introduccion','2023-07-15','15:00:00');

Insert into Asist_Presentacion(N_Presentacion,Curp)values
(1,1),
(1,2),
(1,3),
(2,4),
(2,1);

Insert into T_Profesores(Tiempo)values
('Tiempo Completo'),
('Medio Tiempo');

Insert into Tipo_Leccion(Tipo_Leccion)values
('En grupo'),
('Privadas');


Insert into Lecciones(Leccion,Horario_Ini,Horario_Fin,creditos,Tipo_Leccion)values
('Lengua 1','10:00:00','11:00:00',6,1),
('Aritmetica 1','13:00:00','14:00:00',7,2),
('Primeros auxilios','12:00:00','12:30:00',3,1);


Insert into Profesor(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Remuneracion,T_Profesores,Correo_Inst)values
(1,'Scott','Summers','','Ráfaga Óptica','Ciclope','1977-09-22','+1 413-475-4928','887 Timbercrest Road',1,1200,1,'Scott77@EXavier.com'),
(2,'Jean Elaine','Grey','','telepatía/telequinética','Fénix','1967-01-01','+1 207-932-8680','3606 West Virginia Avenue',1,1100,2,'jgrey84@EXavier.com');

Insert into CursoProf(Matricula_Prof,ID_Leccion,semestre)values
(2,1,'Segundo'),
(1,2,'Segundo');


Insert into Estudiantes(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Correo_Inst)values
(3,'Robbert Louis','Drake','','Termoquinesis','Iceman','1998-06-28','+1 251-644-6467','746 Stanley Avenue',2,'BobbyIce98@EXavier.com');

Insert into Curso(ID_Est,ID_Leccion,calificacion)values
(1,2,8.7);









