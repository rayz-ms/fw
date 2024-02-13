insert into log_levels(level) values ('E'), ('W'), ('I');

insert into logs(application, system, log_id, level) values
    ('app1', 'system1', 1, 2)
;

insert into log_translations(charset, encoding, template, log_id) values
    ('utf-8', 'es-ES', 'Se ha recibido %s', 0),
    ('utf-8', 'es-ES', 'Received %s', 0)
;