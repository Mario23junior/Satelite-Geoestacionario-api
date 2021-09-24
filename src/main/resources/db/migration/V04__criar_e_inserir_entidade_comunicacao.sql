CREATE TABLE `Comunicacao` (

    `id` long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `tipo_Banda` varchar(20),
    `ativo` tinyint(12),
    `periodo_Orbital` double(23),
    `Anomalia_Media` double(23)
   );
  
INSERT INTO Comunicacao (id, tipo_Banda, ativo, periodo_Orbital, Anomalia_Media) VALUES 
(1,'Banda C',1, 1436070, 306403);