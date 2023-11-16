BEGIN
  FOR cur_rec IN (SELECT table_name FROM user_tables) LOOP
    EXECUTE IMMEDIATE 'DROP TABLE ' || cur_rec.table_name || ' CASCADE CONSTRAINTS';
  END LOOP;
END;
/

CREATE TABLE admins (
    id_admin    NUMBER NOT NULL,
    email_admin VARCHAR2(50),
    senha_admin VARCHAR2(50)
);

ALTER TABLE admins ADD CONSTRAINT admins_pk PRIMARY KEY ( id_admin );

CREATE TABLE avaliacoes (
    id_avaliacao              NUMBER NOT NULL,
    nota                      NUMBER,
    mensagem                  VARCHAR2(200),
    usuarios_id_usuario       NUMBER NOT NULL,
    tecnologias_id_tecnologia NUMBER NOT NULL
);

ALTER TABLE avaliacoes ADD CONSTRAINT avaliacao_pk PRIMARY KEY ( id_avaliacao );

CREATE TABLE clinica_enderecos (
    id_clinica_endereco NUMBER NOT NULL,
    rua_clinica         VARCHAR2(50),
    numero_clinica      NUMBER,
    estado_clinica      VARCHAR2(50),
    cep_clinica         VARCHAR2(9),
    clinica_id_clinica  NUMBER NOT NULL
);

ALTER TABLE clinica_enderecos ADD CONSTRAINT clinica_enderecos_pk PRIMARY KEY ( id_clinica_endereco );

CREATE TABLE clinica_telefones (
    id_clinica_telefone NUMBER NOT NULL,
    telefone_clinica    VARCHAR2(20),
    clinica_id_clinica  NUMBER NOT NULL
);

ALTER TABLE clinica_telefones ADD CONSTRAINT clinica_telefones_pk PRIMARY KEY ( id_clinica_telefone );

CREATE TABLE clinicas (
    id_clinica   NUMBER NOT NULL,
    nome_clinica VARCHAR2(50)
);

ALTER TABLE clinicas ADD CONSTRAINT clinica_pk PRIMARY KEY ( id_clinica );

CREATE TABLE consultas (
    id_consulta               NUMBER NOT NULL,
    data_consulta             DATE,
    usuarios_id_usuario       NUMBER NOT NULL,
    medicos_id_medico         NUMBER NOT NULL,
    tecnologias_id_tecnologia NUMBER NOT NULL
);

ALTER TABLE consultas ADD CONSTRAINT consultas_pk PRIMARY KEY ( id_consulta );

CREATE TABLE dados_biometricos_usuario (
    id_dado_biometrico_usuario NUMBER NOT NULL,
    idade                      NUMBER,
    altura                     NUMBER(2, 2),
    peso                       NUMBER(3, 2),
    tipo_sanguineo             VARCHAR2(10),
    convenio_medico            VARCHAR2(50),
    pressao_maior              NUMBER(2, 2),
    pressao_menor              NUMBER(2, 2),
    genero                     VARCHAR2(20),
    usuarios_id_usuario        NUMBER NOT NULL,
    cpf                        VARCHAR2(20)
);

ALTER TABLE dados_biometricos_usuario ADD CONSTRAINT dados_biometricos_usuario_pk PRIMARY KEY ( id_dado_biometrico_usuario );

CREATE TABLE exame_por_consulta (
    exames_id_exame       NUMBER NOT NULL,
    consultas_id_consulta NUMBER NOT NULL
);

ALTER TABLE exame_por_consulta ADD CONSTRAINT exame_por_consulta_pk PRIMARY KEY ( exames_id_exame,
                                                                                  consultas_id_consulta );

ALTER TABLE exame_por_consulta ADD CONSTRAINT exame_por_consulta_id_exame_un UNIQUE ( exames_id_exame );

CREATE TABLE exames (
    id_exame   NUMBER NOT NULL,
    data_exame DATE
);

ALTER TABLE exames ADD CONSTRAINT exames_pk PRIMARY KEY ( id_exame );

CREATE TABLE medico_por_clinica (
    data_inicio_contrato DATE,
    data_final_contrato  DATE,
    medicos_id_medico    NUMBER NOT NULL,
    clinica_id_clinica   NUMBER NOT NULL
);

ALTER TABLE medico_por_clinica ADD CONSTRAINT medico_por_clinica_pk PRIMARY KEY ( medicos_id_medico,
                                                                                  clinica_id_clinica );

CREATE TABLE medicos (
    id_medico    NUMBER NOT NULL,
    nome_medico  VARCHAR2(50),
    email_medico VARCHAR2(50),
    senha_medico VARCHAR2(50),
    estado       VARCHAR2(50),
    crm          VARCHAR2(20)
);

ALTER TABLE medicos ADD CONSTRAINT medicos_pk PRIMARY KEY ( id_medico );

CREATE TABLE tecnologias (
    id_tecnologia        NUMBER NOT NULL,
    nome_tecnologia      VARCHAR2(50),
    descricao_tecnologia VARCHAR2(200)
);

ALTER TABLE tecnologias ADD CONSTRAINT tecnologias_pk PRIMARY KEY ( id_tecnologia );

CREATE TABLE usuario_enderecos (
    id_usuario_endereco NUMBER NOT NULL,
    rua_usuario         VARCHAR2(100),
    estado_usuario      VARCHAR2(50),
    numero_usuario      NUMBER,
    cep_usuario         VARCHAR2(9),
    usuarios_id_usuario NUMBER NOT NULL
);

ALTER TABLE usuario_enderecos ADD CONSTRAINT usuario_enderecos_pk PRIMARY KEY ( id_usuario_endereco );

CREATE TABLE usuario_telefones (
    id_usuario_telefone NUMBER NOT NULL,
    telefone_usuario    VARCHAR2(20),
    usuarios_id_usuario NUMBER NOT NULL
);

ALTER TABLE usuario_telefones ADD CONSTRAINT usuario_telefones_pk PRIMARY KEY ( id_usuario_telefone );

CREATE TABLE usuarios (
    id_usuario    NUMBER NOT NULL,
    nome_usuario  VARCHAR2(50),
    email_usuario VARCHAR2(50),
    senha_usuario VARCHAR2(100)
);

ALTER TABLE usuarios ADD CONSTRAINT usuarios_pk PRIMARY KEY ( id_usuario );

ALTER TABLE avaliacoes
    ADD CONSTRAINT avaliacao_tecnologias_fk FOREIGN KEY ( tecnologias_id_tecnologia )
        REFERENCES tecnologias ( id_tecnologia );

ALTER TABLE avaliacoes
    ADD CONSTRAINT avaliacao_usuarios_fk FOREIGN KEY ( usuarios_id_usuario )
        REFERENCES usuarios ( id_usuario );

ALTER TABLE clinica_enderecos
    ADD CONSTRAINT clinica_enderecos_clinica_fk FOREIGN KEY ( clinica_id_clinica )
        REFERENCES clinicas ( id_clinica );

ALTER TABLE clinica_telefones
    ADD CONSTRAINT clinica_telefones_clinica_fk FOREIGN KEY ( clinica_id_clinica )
        REFERENCES clinicas ( id_clinica );

ALTER TABLE consultas
    ADD CONSTRAINT consultas_medicos_fk FOREIGN KEY ( medicos_id_medico )
        REFERENCES medicos ( id_medico );

ALTER TABLE consultas
    ADD CONSTRAINT consultas_tecnologias_fk FOREIGN KEY ( tecnologias_id_tecnologia )
        REFERENCES tecnologias ( id_tecnologia );

ALTER TABLE consultas
    ADD CONSTRAINT consultas_usuarios_fk FOREIGN KEY ( usuarios_id_usuario )
        REFERENCES usuarios ( id_usuario );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE dados_biometricos_usuario
    ADD CONSTRAINT dados_biometricos_usuario_usuarios_fk FOREIGN KEY ( usuarios_id_usuario )
        REFERENCES usuarios ( id_usuario );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE exame_por_consulta
    ADD CONSTRAINT exame_por_consulta_consultas_fk FOREIGN KEY ( consultas_id_consulta )
        REFERENCES consultas ( id_consulta );

ALTER TABLE exame_por_consulta
    ADD CONSTRAINT exame_por_consulta_exames_fk FOREIGN KEY ( exames_id_exame )
        REFERENCES exames ( id_exame );

ALTER TABLE medico_por_clinica
    ADD CONSTRAINT medico_por_clinica_clinica_fk FOREIGN KEY ( clinica_id_clinica )
        REFERENCES clinicas ( id_clinica );

ALTER TABLE medico_por_clinica
    ADD CONSTRAINT medico_por_clinica_medicos_fk FOREIGN KEY ( medicos_id_medico )
        REFERENCES medicos ( id_medico );

ALTER TABLE usuario_enderecos
    ADD CONSTRAINT usuario_enderecos_usuarios_fk FOREIGN KEY ( usuarios_id_usuario )
        REFERENCES usuarios ( id_usuario );

ALTER TABLE usuario_telefones
    ADD CONSTRAINT usuario_telefones_usuarios_fk FOREIGN KEY ( usuarios_id_usuario )
        REFERENCES usuarios ( id_usuario );



CREATE SEQUENCE sq_id_usuario START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_usuario
BEFORE INSERT ON usuarios FOR EACH ROW       
BEGIN
  SELECT sq_id_usuario.nextval
  INTO :NEW.id_usuario
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_usuario_endereco START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_usuario_endereco
BEFORE INSERT ON usuario_enderecos FOR EACH ROW       
BEGIN
  SELECT sq_id_usuario_endereco.nextval
  INTO :NEW.id_usuario_endereco
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_usuario_telefone START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_usuario_telefone
BEFORE INSERT ON usuario_telefones FOR EACH ROW       
BEGIN
  SELECT sq_id_usuario_telefone.nextval
  INTO :NEW.id_usuario_telefone
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_tecnologia START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_tecnologia
BEFORE INSERT ON tecnologia FOR EACH ROW       
BEGIN
  SELECT sq_id_tecnologia.nextval
  INTO :NEW.id_tecnologia
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_medico START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_medico
BEFORE INSERT ON medicos FOR EACH ROW       
BEGIN
  SELECT sq_id_medico.nextval
  INTO :NEW.id_medico
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_medico START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_medico
BEFORE INSERT ON medicos FOR EACH ROW       
BEGIN
  SELECT sq_id_medico.nextval
  INTO :NEW.id_medico
  FROM DUAL;
END;
/

CREATE SEQUENCE sq_id_exame START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_ins_exame
BEFORE INSERT ON exames FOR EACH ROW       
BEGIN
  SELECT sq_id_exame.nextval
  INTO :NEW.id_exame
  FROM DUAL;
END;
/