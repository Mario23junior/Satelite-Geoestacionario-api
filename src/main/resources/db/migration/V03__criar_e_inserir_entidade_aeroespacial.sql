CREATE TABLE `Aeroespacial` (

    `id` long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `peso` double(20),
    `vida_Util` varchar(50),
    `lancamento` date(20),
    `operador` varchar(80)
   );

INSERT INTO Aeroespacial (id, peso, vida_Util, lancamento, operador) VALUES 
(1,3200,'15 anos', 20111005 ,'Intelsat');