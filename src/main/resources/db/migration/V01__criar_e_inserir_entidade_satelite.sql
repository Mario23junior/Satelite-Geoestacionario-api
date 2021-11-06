CREATE TABLE `Satelite` (

    `id` long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome_De_Diretriz` varchar(20),
    `nome_Comun` varchar(50),
    `fabricante` varchar(50),
    `veiculo` varchar(80),
    
    `comunicacao_id` tinyint(30),
    `geolocalizacao_id` tinyint(30),
    `geomorfologia_id`  tinyint(30)

   );
  
INSERT INTO Satelite (nome_De_Diretriz,nome_Comun,fabricante,veiculo,comunicacao_id,geolocalizacao_id,geomorfologia_id) VALUES 
('11056A','INTELSAT 18 (IS-18)','Orbital Sciences Corporation', 'Zenit-3SL',1,1,1);