🏠 Sistema de Simulação de Financiamentos Imobiliários
Projeto desenvolvido em Java durante as semanas de estudo de Programação Orientada a Objetos (POO).
O sistema simula financiamentos de imóveis (Casa, Apartamento e Terreno), aplicando conceitos de herança, polimorfismo, exceções customizadas e persistência de dados.

📌 Funcionalidades
- ✅ Uso de classe abstrata (Financiamento) e subclasses especializadas (Casa, Apartamento, Terreno).
- ✅ Cada subclasse possui atributos específicos (ex: área construída, número de vagas, tipo de zona).
- ✅ Implementação de polimorfismo com ArrayList<Financiamento>.
- ✅ Tratamento de exceções com try/catch e criação de exceção customizada (AcrescimoMaiorDoQueJurosException).
- ✅ Entrada de dados via usuário (com validação e tratamento de erros).
- ✅ Persistência em arquivo texto (financiamentos.txt) contendo os dados de cada financiamento.
- ✅ Persistência em arquivo serializado (financiamentos.ser) para salvar e recuperar o ArrayList completo.
- ✅ Cálculo e exibição da soma dos valores dos imóveis e da soma dos financiamentos.

🛠️ Tecnologias utilizadas
- Java SE
- POO (Programação Orientada a Objetos)
- Tratamento de Exceções
- Serialização
- Manipulação de Arquivos (I/O)
