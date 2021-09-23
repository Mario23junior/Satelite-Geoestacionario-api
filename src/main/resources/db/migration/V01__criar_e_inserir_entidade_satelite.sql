CREATE TABLE `Satelite` (

    `id` long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome_De_Diretriz` varchar(20),
    `nomeComun` varchar(50),
    `fabricante` varchar(50),
    `veiculo` varchar(80)
   );
  
INSERT INTO Satelite (id,nome_De_Diretriz,nomeComun,fabricante,veiculo) VALUES 
(1,'11056A','INTELSAT 18 (IS-18)','Orbital Sciences Corporation', 'Zenit-3SL');