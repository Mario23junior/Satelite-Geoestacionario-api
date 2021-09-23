CREATE TABLE `Geolocalizacao` (

    `id` long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `orbita` varchar(40),
    `posicao_Em_orbita` varchar(50),
    `localizacao_Orbital` varchar(50),
    `cobertura` varchar(80)
   );
  
INSERT INTO Geolocalizacao (id, orbita ,posicao_Em_orbita,localizacao_Orbital,cobertura) VALUES 
(1,'Geoestacionaria','-179.9944705','180°E','Oceano Pacífico , Austrália , Ásia , Estados Unidos , Polinésia Francesa');