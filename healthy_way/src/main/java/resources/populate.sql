INSERT INTO admins (email_admin, senha_admin) VALUES ('admin@admin.com', 'admin');

INSERT INTO usuarios(nome_usuario,email_usuario,senha_usuario) VALUES ('felipe','felipe@user.com','123456');
INSERT INTO usuarios(nome_usuario,email_usuario,senha_usuario) VALUES ('murilo','murilo@user.com','123456');

INSERT INTO medicos(nome_medico,email_medico,senha_medico,estado_crm,crm) VALUES ('vitor','vitor@doc.com','123456','sp','654321');
INSERT INTO medicos(nome_medico,email_medico,senha_medico,estado_crm,crm) VALUES ('renan','renan@doc.com','123456','rj','456123');

INSERT INTO tecnologias(nome_tecnologia, descricao_tecnologia) VALUES ('Telemedicina', 'acompanhamento online');
INSERT INTO tecnologias(nome_tecnologia, descricao_tecnologia) VALUES ('Online', 'consulta online');
INSERT INTO tecnologias(nome_tecnologia, descricao_tecnologia) VALUES ('Presencial', 'consulta presencial');

INSERT INTO dados_biometricos_usuario(id_dado_biometrico_usuario,tipo_sanguineo,convenio_medico,genero,usuarios_id_usuario) VALUES(1,'AB','NotreDame','M',141);
INSERT INTO dados_biometricos_usuario(id_dado_biometrico_usuario,tipo_sanguineo,convenio_medico,genero,usuarios_id_usuario) VALUES(2,'AB','Santander','M',141);
INSERT INTO dados_biometricos_usuario(id_dado_biometrico_usuario,tipo_sanguineo,convenio_medico,genero,usuarios_id_usuario) VALUES(3,'A','NotreDame','M',142);