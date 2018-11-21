Integrantes do grupo:  
	- Otávio César Toma da Silva, RA: 726576  
	- Rafael Sales Pavarina, RA: 726583  
	- Caio Vinicius Barbosa Santos, RA: 726503   
	- Jéssica Simões Gama Santos, RA: 511323  
  
Como baixar, instalar e usar o compilador:  
	- O compilador pode ser baixado em    
		https://github.com/Otavios/T3/releases/tag/1.0 (T3.zip)  
	- Não é necessário instalar o compilador, mas o usuário deve ter o Java instalado  
	- Para utilizar o compilador:  
		1. Descompacte o arquivo T3.zip  
		2. Entre na pasta T3 pelo terminal  
		3. Compile seu arquivo da linguagem LA com o comando:  
			java -jar CDL.jar nomeDoArquivoCDL  
		4. O arquivo HTML será gerado com o nome nomeDoArquivoCDL.html  
		
Como compilar o compilador:  
	- Caso queira compilar o projeto novamente, siga estes passos:  
		1. Baixe a pasta do projeto em  
			https://github.com/Otavios/T3  
		2. Entre na pasta src/CDL do projeto pelo terminal  
		3. Execute o ANTLR para gerar os arquivos necessários:  
			java org.antlr.v4.Tool -visitor CDL.g4  
		4. Abra o projeto pelo NetBeans  
		5. Clique em 'Limpar e Construir Projeto'  
		6. Se o projeto foi construído corretamente então o executável .jar será gerado na pasta 'dist' do projeto  
		  

		
