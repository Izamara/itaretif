

INSERT INTO `itaretif`.`role`
	(`id`,`nome_role`)
VALUES
	(1, 'ROLE_ADMIN'),
    (2, 'ROLE_SERVIDOR');
    
    
INSERT INTO `itaretif`.`usuario`
	(`id`, `matricula`, `senha`)
VALUES
	(1, '001', '$2a$10$QFfgj1ZikuWqzACSSXFt/uBuQGb4oWwwyppmcwHhMdCCU8HGsTvYG'),
    (2, '002', '$2a$10$QFfgj1ZikuWqzACSSXFt/uBuQGb4oWwwyppmcwHhMdCCU8HGsTvYG'),
    (3, '003', '$2a$10$QFfgj1ZikuWqzACSSXFt/uBuQGb4oWwwyppmcwHhMdCCU8HGsTvYG'),
    (4, '004', '$2a$10$QFfgj1ZikuWqzACSSXFt/uBuQGb4oWwwyppmcwHhMdCCU8HGsTvYG');

    
INSERT INTO `itaretif`.`usuario_roles`
	(`usuario_id`, `roles_id`)
VALUES
	(1, 1),
    (1, 2),
    (2, 2),
    (3, 2),
    (4, 2);