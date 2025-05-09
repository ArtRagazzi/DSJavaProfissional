-- 2. Participantes
INSERT INTO tb_participante(nome, email) VALUES ('Jose Silva', 'jose@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('Thiago Faria', 'thiago@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('Maria do Rosario', 'maria@gmail.com');
INSERT INTO tb_participante(nome, email) VALUES ('Teresa Silva', 'teresa@gmail.com');

-- 1. Categorias
INSERT INTO tb_categoria(descricao) VALUES ('Curso');
INSERT INTO tb_categoria(descricao) VALUES ('Oficina');

-- 3. Atividades (id_categoria: 1 = Curso, 2 = Oficina)
INSERT INTO tb_atividade(nome, descricao, preco, categoria_id)
VALUES ('Curso de HTML', 'Aprenda HTML de forma pratica', 80.0, 1);

INSERT INTO tb_atividade(nome, descricao, preco, categoria_id)
VALUES ('Oficina de Github', 'Controle versoes de seus projetos', 50.0, 2);

-- 4. Blocos (dependem da atividade)
INSERT INTO tb_bloco(inicio, fim, atividade_id) VALUES ('2017-09-25T08:00:00', '2017-09-25T11:00:00', 1);

INSERT INTO tb_bloco(inicio, fim, atividade_id) VALUES ('2017-09-25T14:00:00', '2017-09-25T18:00:00', 2);
-- Corrigido a data de 'fim' para estar após a data de 'inicio'
INSERT INTO tb_bloco(inicio, fim, atividade_id) VALUES ('2017-09-26T08:00:00', '2017-09-26T11:00:00', 2);

-- 5. Relacionamento participante x atividade
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 1);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 2);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (1, 3);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (2, 3);
INSERT INTO tb_participante_atividade(atividade_id, participante_id) VALUES (2, 4);


