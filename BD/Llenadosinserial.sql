Insert into Mutante(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol)values
('CXXUM0TN','Scott','Summers','','Ráfaga Óptica','Ciclope','1977-09-22','+1 413-475-4928','887 Timbercrest Road','Profesor'),
('CXW4SRJ9','Jean Elaine','Grey','','telepatía/telequinética','Fénix','1967-01-01','+1 207-932-8680','3606 West Virginia Avenue','Profesor'),
('CXS7GQDP','Robbert Louis','Drake','','Termoquinesis','Iceman','1998-06-28','+1 251-644-6467','746 Stanley Avenue','Estudiante'),
('CXGI0SQM','Lucy','Johnson','Jones','Ilusiones','Divinity','2005-06-08','+1 505-543-0660','2111 Jadewood Drive','Aspirante');

Insert into Presentaciones(N_Presentacion,Dia,Horario,Curp)values
('charla educativa','2023-09-12','18:00:00','CXGI0SQM'),
('charla educativa','2023-09-12','18:00:00','CXW4SRJ9'),
('charla educativa','2023-09-12','18:00:00','CXS7GQDP');

Insert into T_Profesores(Tiempo)values
('Tiempo Completo'),
('Medio Tiempo');

Insert into Tipo_Leccion(Tipo_Leccion)values
('En grupo'),
('Privadas');

Insert into Lecciones(ID_Leccion,Leccion,Horario_Ini,Horario_Fin,creditos,Tipo_Leccion)values
('Lg1','Lengua 1','10:00:00','11:00:00',6,1),
('Ap1','Aritmetica 1','13:00:00','14:00:00',7,2),
('Pg1','Primeros auxilios','12:00:00','12:30:00',3,1);

Insert into Profesor(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula_P,Remuneracion,T_Profesores,Correo_Inst)values
('CXXUM0TN','Scott','Summers','','Ráfaga Óptica','Ciclope','1977-09-22','+1 413-475-4928','887 Timbercrest Road','Profesor','Px1',1200,'1','Scott77@EXavier.com'),
('CXW4SRJ9','Jean Elaine','Grey','','telepatía/telequinética','Fénix','1967-01-01','+1 207-932-8680','3606 West Virginia Avenue','Profesor','Px2',1100,'2','jgrey84@EXavier.com');

Insert into CursoProf(Matricula_Prof,ID_Leccion,semestre)values
('Px2','Lg1','Segundo'),
('Px1','Ap1','Segundo');

Insert into Estudiantes(Curp,Nombre,Apellido_Pat,Apellido_Mat,Poder,N_Alias,fecha_nac,cel,direcc,Rol,Matricula,Correo_Inst)values
('CXS7GQDP','Robbert Louis','Drake','','Termoquinesis','Iceman','1998-06-28','+1 251-644-6467','746 Stanley Avenue','Estudiante','Ex1','BobbyIce98@EXavier.com');

Insert into Curso(ID_Est,ID_Leccion,calificacion)values
('Ex1','Ap1',8.7);
