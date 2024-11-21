package br.com.rufuziu.knowledgearea_and_subjects.services;

import br.com.rufuziu.knowledgearea_and_subjects.entity.EducationLevel;
import br.com.rufuziu.knowledgearea_and_subjects.entity.KnowledgeArea;
import br.com.rufuziu.knowledgearea_and_subjects.entity.Subject;
import jakarta.annotation.PostConstruct;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MongoDataInitializer {


    private final MongoTemplate mongoTemplate;


    public MongoDataInitializer(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    private List<EducationLevel> educationLevelsToCheck = Arrays.asList(
            new EducationLevel("Ensino Fundamental - Anos Iniciais"),
            new EducationLevel("Ensino Fundamental - Anos Finais"),
            new EducationLevel("Ensino Médio"));

    /*
    private List<KnowledgeArea> generalKnowledgeAreaToCheck = Arrays.asList(
            new KnowledgeArea("Língua Portuguesa"),
            new KnowledgeArea("Matemática"),
            new KnowledgeArea("Educação Física"),
            new KnowledgeArea("Artes"));

    private List<KnowledgeArea> specificOneKnowledgeAreaToCheck = Arrays.asList(
            new KnowledgeArea("Ciências"),
            new KnowledgeArea("História"),
            new KnowledgeArea("Geografia"),
            new KnowledgeArea("Ensino Religioso"));

    private List<KnowledgeArea> specificTwoKnowledgeAreaToCheck = Arrays.asList(
            new KnowledgeArea("Ciências da Natureza"),
            new KnowledgeArea("Ciências Humanas"),
            new KnowledgeArea("Língua Estrangeira"));

    private List<KnowledgeArea> gradeEnsinoFundamentalAnosIniciais = new ArrayList<>();
    private List<KnowledgeArea> gradeEnsinoFundamentalAnosFinais = new ArrayList<>();
    private List<KnowledgeArea> gradeEnsinoMedio = new ArrayList<>();


    // Ensino Fundamental
    // 0 - Lingua Porgutuesa
    private List<Subject> subject0ToCheck = Arrays.asList(new Subject("Gramática", "Ortografia"), new Subject("Gramática", "Morfologia"), new Subject("Gramática", "Sintaxe"), new Subject("Gramática", "Semântica"), new Subject("Gramática", "Pragática"), new Subject("Leitura e Interpretação de Textos", "Compreensão"), new Subject("Leitura e Interpretação de Textos", "Análise Crítica"), new Subject("Produção Textual", "Redação"), new Subject("Produção Textual", "Estilos e Coerência"), new Subject("Linguística", "Fonética e Fonologia"), new Subject("Linguística", "Sociolinguística"));

    // 1 - Matemática
    private List<Subject> subject1ToCheck = Arrays.asList(new Subject("Números e Operações", "Números Naturais e Inteiros"), new Subject("Números e Operações", "Frações e Decimais"), new Subject("Números e Operações", "Porcentagem"), new Subject("Números e Operações", "Operações Básicas (Adição, Subtração, Multiplicação e Divisão)"), new Subject("Álgebra", "Álgebra Básica e Expressões Algébricas"), new Subject("Álgebra", "Equações Simples"), new Subject("Álgebra", "Inequações Simples"), new Subject("Álgebra", "Sistemas de Equações"), new Subject("Geometria", "Figuras Geométricas Planas"), new Subject("Geometria", "Propriedades dos Polígonos"), new Subject("Geometria", "Perímetro e Área de Figuras Planas"), new Subject("Geometria", "Volume e Área de Superfície de Corpos Geométricos"), new Subject("Medidas", "Unidades de Medida"), new Subject("Medidas", "Conversão de Unidades"), new Subject("Medidas", "Medidas de Comprimento, Massa e Volume"), new Subject("Medidas", "Perímetro, Área e Volume"), new Subject("Estatística e Probabilidade", "Coleta e Organização de Dados"), new Subject("Estatística e Probabilidade", "Gráficos e Tabelas"), new Subject("Estatística e Probabilidade", "Média, Mediana e Moda"), new Subject("Estatística e Probabilidade", "Probabilidade Básica"), new Subject("Funções e Sequências", "Sequências Numéricas"), new Subject("Funções e Sequências", "Funções Simples"), new Subject("Funções e Sequências", "Padrões e Regularidades"), new Subject("Raciocínio Lógico", "Problemas de Lógica e Dedução"), new Subject("Raciocínio Lógico", "Padrões e Sequências Lógicas"), new Subject("Raciocínio Lógico", "Resolução de Problemas e Desafios Matemáticos"), new Subject("Matemática Aplicada", "Aplicações em Situações do Cotidiano"), new Subject("Matemática Aplicada", "Problemas de Situação e Contexto"), new Subject("Matemática Aplicada", "Relações Matemáticas no Dia a Dia"));

    // 2 - Educação Física
    private List<Subject> subject2ToCheck = Arrays.asList(new Subject("Aspectos Teóricos e Históricos", "História da Educação Física"), new Subject("Aspectos Teóricos e Históricos", "Importância da Atividade Física"), new Subject("Aspectos Teóricos e Históricos", "Filosofia da Educação Física"), new Subject("Aspectos Teóricos e Históricos", "Educação Física e Saúde"), new Subject("Atividades Físicas e Esportivas", "Esportes Coletivos (Futebol, Basquete, Vôlei)"), new Subject("Atividades Físicas e Esportivas", "Esportes Individuais (Atletismo, Natação)"), new Subject("Atividades Físicas e Esportivas", "Jogos e Brincadeiras"), new Subject("Atividades Físicas e Esportivas", "Atividades Rítmicas e Danças"), new Subject("Condicionamento Físico", "Treinamento Cardiovascular"), new Subject("Condicionamento Físico", "Treinamento Muscular"), new Subject("Condicionamento Físico", "Flexibilidade e Alongamento"), new Subject("Condicionamento Físico", "Coordenação e Agilidade"), new Subject("Saúde e Bem-Estar", "Higiene e Cuidados Pessoais"), new Subject("Saúde e Bem-Estar", "Nutrição e Alimentação Saudável"), new Subject("Saúde e Bem-Estar", "Prevenção de Lesões"), new Subject("Saúde e Bem-Estar", "Importância do Repouso e Recuperação"), new Subject("Anatomia e Fisiologia", "Sistema Muscular e Esquelético"), new Subject("Anatomia e Fisiologia", "Sistema Cardiovascular"), new Subject("Anatomia e Fisiologia", "Sistema Respiratório"), new Subject("Anatomia e Fisiologia", "Fisiologia do Exercício"), new Subject("Aspectos Psicológicos", "Motivação e Autoestima"), new Subject("Aspectos Psicológicos", "Desenvolvimento Pessoal e Social"), new Subject("Aspectos Psicológicos", "Controle do Estresse"), new Subject("Aspectos Psicológicos", "Comportamento e Atitudes em Atividades Físicas"), new Subject("Metodologia e Didática", "Planejamento de Aulas e Atividades"), new Subject("Metodologia e Didática", "Métodos de Ensino e Avaliação"), new Subject("Metodologia e Didática", "Adaptação de Atividades para Diversos Níveis"), new Subject("Metodologia e Didática", "Inclusão e Diversidade em Atividades Físicas"), new Subject("Cultura e Sociedade", "Esportes e Cultura"), new Subject("Cultura e Sociedade", "Eventos e Competições Esportivas"), new Subject("Cultura e Sociedade", "Relação entre Esporte e Cultura"), new Subject("Cultura e Sociedade", "Esportes e Desenvolvimento Social"));

    // 3 - Artes
    private List<Subject> subject3ToCheck = Arrays.asList(new Subject("História da Arte", "Arte Primitiva e Antiga"), new Subject("História da Arte", "Arte Medieval"), new Subject("História da Arte", "Renascimento e Barroco"), new Subject("História da Arte", "Arte Moderna e Contemporânea"), new Subject("História da Arte", "Movimentos Artísticos Básicos"), new Subject("Desenho e Pintura", "Desenho Livre e Criativo"), new Subject("Desenho e Pintura", "Técnicas de Pintura Básica"), new Subject("Desenho e Pintura", "Uso de Cores e Formas"), new Subject("Desenho e Pintura", "Desenho e Pintura com Diferentes Materiais"), new Subject("Escultura e Modelagem", "Modelagem com Argila e Massa"), new Subject("Escultura e Modelagem", "Construção de Formas Tridimensionais"), new Subject("Escultura e Modelagem", "Técnicas de Escultura e Relevo"), new Subject("Escultura e Modelagem", "Criatividade e Experimentação em Escultura"), new Subject("Gravura e Impressão", "Técnicas Básicas de Gravura"), new Subject("Gravura e Impressão", "Criação de Linhas e Texturas"), new Subject("Gravura e Impressão", "Impressão com Diferentes Materiais"), new Subject("Gravura e Impressão", "Exploração de Estilos de Gravura"), new Subject("Música", "Ritmo e Percussão"), new Subject("Música", "Cantos e Melodias Simples"), new Subject("Música", "Introdução aos Instrumentos Musicais"), new Subject("Música", "História e Diversidade Musical"), new Subject("Dança", "Movimentos Básicos e Coordenação"), new Subject("Dança", "Dança e Expressão Corporal"), new Subject("Dança", "Ritmos e Estilos de Dança"), new Subject("Dança", "Criação de Coreografias Simples"), new Subject("Teatro", "Expressão Facial e Corporal"), new Subject("Teatro", "Atuação e Improvisação"), new Subject("Teatro", "Leitura e Interpretação de Textos Teatrais"), new Subject("Teatro", "Criação de Peças e Apresentações"), new Subject("Artesanato e Criatividade", "Trabalhos Manuais e Criativos"), new Subject("Artesanato e Criatividade", "Uso de Materiais Recicláveis"), new Subject("Artesanato e Criatividade", "Projetos de Artesanato e Decoração"), new Subject("Artesanato e Criatividade", "Exploração de Técnicas e Estilos Diversos"), new Subject("Estética e Sensibilidade", "Percepção e Análise de Obras de Arte"), new Subject("Estética e Sensibilidade", "Desenvolvimento do Olhar Artístico"), new Subject("Estética e Sensibilidade", "Apreciação de Arte e Cultura"), new Subject("Estética e Sensibilidade", "Expressão Pessoal e Criativa"));

    // 4 - Ciências
    private List<Subject> subject4ToCheck = Arrays.asList(new Subject("Ciências da Natureza", "Características dos Seres Vivos"), new Subject("Ciências da Natureza", "Classificação dos Organismos"), new Subject("Ciências da Natureza", "Cadeias Alimentares e Ecossistemas"), new Subject("Corpo Humano", "Sistema Digestivo"), new Subject("Corpo Humano", "Sistema Circulatório"), new Subject("Corpo Humano", "Sistema Respiratório"), new Subject("Corpo Humano", "Sistema Nervoso"), new Subject("Meio Ambiente", "Recursos Naturais"), new Subject("Meio Ambiente", "Preservação e Sustentabilidade"), new Subject("Meio Ambiente", "Poluição e Seus Efeitos"), new Subject("Física", "Leis do Movimento"), new Subject("Física", "Força e Energia"), new Subject("Física", "Propriedades dos Materiais"), new Subject("Física", "Estados da Matéria"), new Subject("Química", "Misturas e Soluções"), new Subject("Química", "Propriedades dos Materiais"), new Subject("Química", "Reações Químicas Básicas"), new Subject("Astronomia", "Sistema Solar"), new Subject("Astronomia", "Fases da Lua"), new Subject("Astronomia", "Estrelas e Constelações"), new Subject("Geologia", "Tipos de Rochas"), new Subject("Geologia", "Formação do Solo"), new Subject("Geologia", "Processos Erosivos"), new Subject("Ciências e Tecnologia", "Invenções e Descobertas"), new Subject("Ciências e Tecnologia", "Impacto da Tecnologia no Cotidiano"), new Subject("Ciências e Tecnologia", "Uso Consciente de Tecnologias"), new Subject("Saúde e Higiene", "Alimentação e Nutrição"), new Subject("Saúde e Higiene", "Cuidados com a Saúde Pessoal"), new Subject("Saúde e Higiene", "Prevenção de Doenças"));

    // 5 - História
    private List<Subject> subject5ToCheck = Arrays.asList(new Subject("História Geral", "Pré-História"), new Subject("História Geral", "Antiga Mesopotâmia"), new Subject("História Geral", "Antigo Egito"), new Subject("História Geral", "Grécia Antiga"), new Subject("História Geral", "Roma Antiga"), new Subject("História do Brasil", "Período Pré-Colonial"), new Subject("História do Brasil", "Descobrimento e Colonização"), new Subject("História do Brasil", "Período Colonial"), new Subject("História do Brasil", "Independência do Brasil"), new Subject("História do Brasil", "Período Imperial"), new Subject("História do Brasil", "República Velha"), new Subject("História do Brasil", "Era Vargas"), new Subject("História do Brasil", "Ditadura Militar"), new Subject("História do Brasil", "Redemocratização e Constituição de 1988"), new Subject("História da América", "Civilizações Pré-Colombianas"), new Subject("História da América", "Colonização da América"), new Subject("História da América", "Independência das Colônias Americanas"), new Subject("História da América", "Consolidação dos Estados Nacionais na América"), new Subject("História Mundial", "Idade Média"), new Subject("História Mundial", "Renascimento"), new Subject("História Mundial", "Revolução Industrial"), new Subject("História Mundial", "Guerras Mundiais"), new Subject("História Mundial", "Guerra Fria"), new Subject("História Social", "Vida Cotidiana na Antiguidade"), new Subject("História Social", "Mudanças Sociais e Econômicas ao Longo do Tempo"), new Subject("História Social", "Movimentos Sociais e Políticos"), new Subject("História e Cultura", "Patrimônio Cultural"), new Subject("História e Cultura", "Tradições e Costumes"), new Subject("História e Cultura", "Influências Culturais e Históricas"), new Subject("História e Atualidade", "Eventos Históricos Recentes"), new Subject("História e Atualidade", "Análise de Conflitos Contemporâneos"), new Subject("História e Atualidade", "Desafios e Tendências Globais"));

    // 6 - Geografia
    private List<Subject> subject6ToCheck = Arrays.asList(new Subject("Geografia Geral", "Formação da Terra"), new Subject("Geografia Geral", "Movimentos da Terra"), new Subject("Geografia Geral", "Climas e Vegetações do Mundo"), new Subject("Geografia Geral", "Relevo e Hidrografia"), new Subject("Geografia do Brasil", "Divisão Geográfica do Brasil"), new Subject("Geografia do Brasil", "Climas e Vegetações do Brasil"), new Subject("Geografia do Brasil", "Relevo e Hidrografia do Brasil"), new Subject("Geografia do Brasil", "Regiões Brasileiras e suas Características"), new Subject("Geografia do Brasil", "Aspectos Econômicos e Sociais"), new Subject("Geografia Regional", "América do Norte"), new Subject("Geografia Regional", "América Central e Caribe"), new Subject("Geografia Regional", "América do Sul"), new Subject("Geografia Regional", "África"), new Subject("Geografia Regional", "Ásia"), new Subject("Geografia Regional", "Oceania"), new Subject("Geografia Regional", "Europa"), new Subject("Geografia Humana", "População e Demografia"), new Subject("Geografia Humana", "Urbanização e Megacidades"), new Subject("Geografia Humana", "Culturas e Tradições"), new Subject("Geografia Humana", "Economia e Comércio"), new Subject("Geografia Econômica", "Recursos Naturais"), new Subject("Geografia Econômica", "Indústria e Agricultura"), new Subject("Geografia Econômica", "Comércio e Globalização"), new Subject("Geografia Econômica", "Desenvolvimento Sustentável"), new Subject("Geografia Ambiental", "Problemas Ambientais Globais"), new Subject("Geografia Ambiental", "Mudanças Climáticas"), new Subject("Geografia Ambiental", "Poluição e Conservação"), new Subject("Geografia Ambiental", "Gestão dos Recursos Naturais"), new Subject("Geografia e Sociedade", "Impactos das Atividades Humanas"), new Subject("Geografia e Sociedade", "Planejamento Urbano"), new Subject("Geografia e Sociedade", "Desigualdades Regionais e Sociais"), new Subject("Geografia e Tecnologia", "Uso de Tecnologias Geográficas"), new Subject("Geografia e Tecnologia", "Sistemas de Informação Geográfica (SIG)"), new Subject("Geografia e Tecnologia", "Geoprocessamento e Cartografia Digital"));

    // 7 - Ensino Religioso
    private List<Subject> subject7ToCheck = Arrays.asList(new Subject("Religiões e Crenças", "Diversidade Religiosa"), new Subject("Religiões e Crenças", "Principais Religiões do Mundo"), new Subject("Religiões e Crenças", "História das Religiões"), new Subject("Textos Religiosos", "Textos Sagrados das Religiões Monoteístas"), new Subject("Textos Religiosos", "Textos Sagrados das Religiões Politeístas"), new Subject("Textos Religiosos", "Literatura Religiosa e Espiritual"), new Subject("Práticas Religiosas", "Rituais e Festividades"), new Subject("Práticas Religiosas", "Cultos e Cerimônias"), new Subject("Práticas Religiosas", "Práticas Espirituais e Meditação"), new Subject("Ética e Moral", "Valores e Princípios Éticos"), new Subject("Ética e Moral", "Comportamento Moral e Decisões"), new Subject("Ética e Moral", "Dilemas Éticos e Resolução de Conflitos"), new Subject("História das Religiões", "Origens e Desenvolvimento das Religiões"), new Subject("História das Religiões", "Religiões e Sociedades Antigas"), new Subject("História das Religiões", "Influência das Religiões na História"), new Subject("Religião e Sociedade", "Religião e Cultura"), new Subject("Religião e Sociedade", "Religião e Identidade Social"), new Subject("Religião e Sociedade", "Religião e Direitos Humanos"), new Subject("Educação Religiosa", "Ensino de Valores Religiosos"), new Subject("Educação Religiosa", "Histórias e Lendas Religiosas"), new Subject("Educação Religiosa", "Educação para a Tolerância Religiosa"), new Subject("Religiões e Ciência", "Relação entre Religião e Ciência"), new Subject("Religiões e Ciência", "Conflitos e Conexões entre Fé e Razão"), new Subject("Religiões e Ciência", "Impactos da Ciência nas Crenças Religiosas"));

    // Ensino Médio

    // 8 - Ciências da Natureza - Biologia
    private List<Subject> subject8ToCheck = Arrays.asList(new Subject("Biologia", "Citologia"), new Subject("Biologia", "Genética"), new Subject("Biologia", "Evolução e Diversidade Biológica"), new Subject("Biologia", "Fisiologia Humana"), new Subject("Biologia", "Ecologia e Meio Ambiente"), new Subject("Biologia", "Botânica"), new Subject("Biologia", "Zoologia"));

    // 9 - Ciências da Natureza - Química
    private List<Subject> subject9ToCheck = Arrays.asList(new Subject("Química", "Estrutura Atômica e Tabelas Periódicas"), new Subject("Química", "Ligações Químicas"), new Subject("Química", "Reações Químicas e Estequiometria"), new Subject("Química", "Química Orgânica"), new Subject("Química", "Química Inorgânica"), new Subject("Química", "Equilíbrios Químicos"), new Subject("Química", "Termoquímica"), new Subject("Química", "Cinética Química"));

    // 10 - Ciências da Natureza - Física
    private List<Subject> subject10ToCheck = Arrays.asList(new Subject("Física", "Mecânica"), new Subject("Física", "Termodinâmica"), new Subject("Física", "Óptica"), new Subject("Física", "Eletromagnetismo"), new Subject("Física", "Ondas e Acústica"), new Subject("Física", "Física Moderna"), new Subject("Física", "Eletromagnetismo e Circuitos Elétricos"));

    // 11 - Ciências da Natureza - Ciências Ambientais
    private List<Subject> subject11ToCheck = Arrays.asList(new Subject("Ciências Ambientais", "Impactos Ambientais e Sustentabilidade"), new Subject("Ciências Ambientais", "Gestão de Recursos Naturais"), new Subject("Ciências Ambientais", "Poluição e Controle Ambiental"), new Subject("Ciências Ambientais", "Mudanças Climáticas e Energias Renováveis"));

    // 12 - Ciências da Natureza - Ciências da Terra
    private List<Subject> subject12ToCheck = Arrays.asList(new Subject("Ciências da Terra", "Geologia e Estrutura da Terra"), new Subject("Ciências da Terra", "Geografia Física"), new Subject("Ciências da Terra", "Meteorologia e Climatologia"), new Subject("Ciências da Terra", "Geodinâmica e Processos Geológicos"), new Subject("Ciências da Terra", "Recursos Minerais e Energéticos"));

    // 13 - Ciências da Natureza - Saúde e Meio Ambiente
    private List<Subject> subject13ToCheck = Arrays.asList(new Subject("Saúde e Meio Ambiente", "Aspectos Ambientais da Saúde"), new Subject("Saúde e Meio Ambiente", "Doenças Relacionadas ao Ambiente"), new Subject("Saúde e Meio Ambiente", "Higiene e Saúde Pública"), new Subject("Saúde e Meio Ambiente", "Sustentabilidade e Qualidade de Vida"));

    // 14 - Ciências Humanas - História Geral
    private List<Subject> subject14ToCheck = Arrays.asList(new Subject("História Geral", "Antiguidade"), new Subject("História Geral", "Idade Média"), new Subject("História Geral", "Idade Moderna"), new Subject("História Geral", "Era Contemporânea"), new Subject("História Geral", "História Global e Relações Internacionais"));

    // 15 - Ciências Humanas - História do Brasil
    private List<Subject> subject15ToCheck = Arrays.asList(new Subject("História do Brasil", "Brasil Colonial"), new Subject("História do Brasil", "Independência e Império"), new Subject("História do Brasil", "República Velha"), new Subject("História do Brasil", "Era Vargas"), new Subject("História do Brasil", "Ditadura Militar e Redemocratização"), new Subject("História do Brasil", "Brasil Contemporâneo"));

    // 16 - Ciências Humanas - Geografia Geral
    private List<Subject> subject16ToCheck = Arrays.asList(new Subject("Geografia Geral", "Formação da Terra"), new Subject("Geografia Geral", "Climas e Vegetações"), new Subject("Geografia Geral", "Relevo e Hidrografia"), new Subject("Geografia Geral", "Geopolítica e Globalização"));

    // 17 - Ciências Humanas - Geografia do Brasil
    private List<Subject> subject17ToCheck = Arrays.asList(new Subject("Geografia do Brasil", "Aspectos Naturais"), new Subject("Geografia do Brasil", "Regiões Brasileiras"), new Subject("Geografia do Brasil", "Dinâmicas Populacionais e Urbanas"), new Subject("Geografia do Brasil", "Questões Ambientais e Desenvolvimento Sustentável"));

    // 18 - Ciências Humanas - Sociologia
    private List<Subject> subject18ToCheck = Arrays.asList(new Subject("Sociologia", "Teorias Sociológicas Clássicas"), new Subject("Sociologia", "Estrutura Social e Instituições"), new Subject("Sociologia", "Processos Sociais e Mudança Social"), new Subject("Sociologia", "Cultura e Identidade"), new Subject("Sociologia", "Desigualdade Social e Mobilidade"));

    // 19 - Ciências Humanas - Filosofia
    private List<Subject> subject19ToCheck = Arrays.asList(new Subject("Filosofia", "Conceitos Fundamentais"), new Subject("Filosofia", "História da Filosofia"), new Subject("Filosofia", "Ética e Moral"), new Subject("Filosofia", "Teorias Políticas e Sociais"), new Subject("Filosofia", "Estética e Crítica da Arte"));

    // 20 - Ciências Humanas - Direitos Humanos
    private List<Subject> subject20ToCheck = Arrays.asList(new Subject("Direitos Humanos", "História dos Direitos Humanos"), new Subject("Direitos Humanos", "Declarações e Tratados Internacionais"), new Subject("Direitos Humanos", "Direitos Civis e Políticos"), new Subject("Direitos Humanos", "Direitos Econômicos, Sociais e Culturais"), new Subject("Direitos Humanos", "Desafios e Questões Atuais"));

    // 21 - Ciências Humanas - Antropologia
    private List<Subject> subject21ToCheck = Arrays.asList(new Subject("Antropologia", "Conceitos Antropológicos"), new Subject("Antropologia", "Culturas e Sociedades"), new Subject("Antropologia", "Religião e Rituais"), new Subject("Antropologia", "Mudança Cultural e Globalização"));

    // 22 - Ciências Humanas - Psicologia Social
    private List<Subject> subject22ToCheck = Arrays.asList(new Subject("Psicologia Social", "Processos de Socialização"), new Subject("Psicologia Social", "Percepção Social e Influência"), new Subject("Psicologia Social", "Atitudes e Comportamento Social"), new Subject("Psicologia Social", "Grupos Sociais e Dinâmicas de Grupo"));

    // 23 - Língua Estrangeira
    private List<Subject> subject23ToCheck = Arrays.asList(new Subject("Língua Inglesa", "Compreensão Oral"), new Subject("Língua Inglesa", "Compreensão de Texto"), new Subject("Língua Inglesa", "Produção Oral"), new Subject("Língua Inglesa", "Produção Escrita"), new Subject("Língua Inglesa", "Gramática e Estruturas"), new Subject("Língua Inglesa", "Vocabulário e Expressões Idiomáticas"), new Subject("Língua Inglesa", "Culturas de Países de Língua Inglesa"), new Subject("Língua Espanhola", "Comprensión Auditiva"), new Subject("Língua Espanhola", "Comprensión de Lectura"), new Subject("Língua Espanhola", "Producción Oral"), new Subject("Língua Espanhola", "Producción Escrita"), new Subject("Língua Espanhola", "Gramática y Estructuras"), new Subject("Língua Espanhola", "Vocabulario y Expresiones Idiomáticas"), new Subject("Língua Espanhola", "Culturas de Países de Habla Hispana"), new Subject("Língua Francesa", "Compréhension Orale"), new Subject("Língua Francesa", "Compréhension Écrite"), new Subject("Língua Francesa", "Production Orale"), new Subject("Língua Francesa", "Production Écrite"), new Subject("Língua Francesa", "Grammaire et Structures"), new Subject("Língua Francesa", "Vocabulaire et Expressions Idiomatiques"), new Subject("Língua Francesa", "Cultures des Pays Francophones"), new Subject("Língua Alemã", "Hörverständnis"), new Subject("Língua Alemã", "Leseverständnis"), new Subject("Língua Alemã", "Mündliche Produktion"), new Subject("Língua Alemã", "Schriftliche Produktion"), new Subject("Língua Alemã", "Grammatik und Strukturen"), new Subject("Língua Alemã", "Wortschatz und Redewendungen"), new Subject("Língua Alemã", "Kulturen der Deutschsprachigen Länder"), new Subject("Língua Italiana", "Ascolto"), new Subject("Língua Italiana", "Comprensione del Testo"), new Subject("Língua Italiana", "Produzione Orale"), new Subject("Língua Italiana", "Produzione Scritta"), new Subject("Língua Italiana", "Grammatica e Strutture"), new Subject("Língua Italiana", "Vocabolario ed Espressioni Idiomatiche"), new Subject("Língua Italiana", "Culture dei Paesi di Lingua Italiana"), new Subject("Língua Portuguesa para Estrangeiros", "Compreensão Oral"), new Subject("Língua Portuguesa para Estrangeiros", "Compreensão de Texto"), new Subject("Língua Portuguesa para Estrangeiros", "Produção Oral"), new Subject("Língua Portuguesa para Estrangeiros", "Produção Escrita"), new Subject("Língua Portuguesa para Estrangeiros", "Gramática e Estruturas"), new Subject("Língua Portuguesa para Estrangeiros", "Vocabulário e Expressões Idiomáticas"), new Subject("Língua Portuguesa para Estrangeiros", "Culturas de Países Lusófonos"));

    // 24 - Língua Portuguesa
    private List<Subject> subject24ToCheck = Arrays.asList(new Subject("Gramática", "Ortografia"), new Subject("Gramática", "Morfologia"), new Subject("Gramática", "Sintaxe"), new Subject("Gramática", "Semântica"), new Subject("Gramática", "Pragática"), new Subject("Literatura", "Análise Literária"), new Subject("Literatura", "História da Literatura"), new Subject("Literatura", "Autores e Obras"), new Subject("Literatura", "Gêneros Literários"), new Subject("Leitura e Interpretação de Textos", "Compreensão"), new Subject("Leitura e Interpretação de Textos", "Análise Crítica"), new Subject("Produção Textual", "Redação"), new Subject("Produção Textual", "Estilos e Coerência"), new Subject("Linguística", "Fonética e Fonologia"), new Subject("Linguística", "Sociolinguística"));

    // 25 - Matemática
    private List<Subject> subject25ToCheck = Arrays.asList(new Subject("Álgebra", "Funções e Gráficas"), new Subject("Álgebra", "Equações e Inequações"), new Subject("Álgebra", "Polinômios e Frações Algébricas"), new Subject("Álgebra", "Sistemas Lineares"), new Subject("Geometria", "Geometria Plana"), new Subject("Geometria", "Geometria Espacial"), new Subject("Geometria", "Trigonometria"), new Subject("Geometria", "Transformações Geométricas"), new Subject("Matemática Financeira", "Juros Simples e Compostos"), new Subject("Matemática Financeira", "Descontos e Acréscimos"), new Subject("Matemática Financeira", "Séries de Pagamentos"), new Subject("Matemática Financeira", "Análise de Investimentos"), new Subject("Estatística e Probabilidade", "Estatística Descritiva"), new Subject("Estatística e Probabilidade", "Probabilidade e Teoria dos Conjuntos"), new Subject("Estatística e Probabilidade", "Distribuições de Probabilidade"), new Subject("Estatística e Probabilidade", "Inferência Estatística"), new Subject("Funções", "Funções Lineares e Quadráticas"), new Subject("Funções", "Funções Exponenciais e Logarítmicas"), new Subject("Funções", "Funções Racionais"), new Subject("Funções", "Funções Trigonométricas"), new Subject("Cálculo", "Limites e Continuidade"), new Subject("Cálculo", "Derivadas e Aplicações"), new Subject("Cálculo", "Integrais e Aplicações"), new Subject("Cálculo", "Sequências e Séries"), new Subject("Lógica e Conjuntos", "Lógica Matemática"), new Subject("Lógica e Conjuntos", "Teoria dos Conjuntos"), new Subject("Lógica e Conjuntos", "Relações e Funções"), new Subject("Geometria Analítica", "Plano Cartesiano"), new Subject("Geometria Analítica", "Retas e Cônicas"), new Subject("Geometria Analítica", "Equações de Cônicas"), new Subject("Geometria Analítica", "Geometria Espacial e Vetores"), new Subject("Matemática Aplicada", "Modelagem Matemática"), new Subject("Matemática Aplicada", "Problemas de Otimização"), new Subject("Matemática Aplicada", "Aplicações em Ciências e Engenharia"));

    // 26 - Educação Física
    private List<Subject> subject26ToCheck = Arrays.asList(new Subject("Aspectos Teóricos e Históricos", "História da Educação Física"), new Subject("Aspectos Teóricos e Históricos", "Teorias e Filosofias da Educação Física"), new Subject("Aspectos Teóricos e Históricos", "Educação Física e Saúde"), new Subject("Atividades Físicas e Esportivas", "Esportes Coletivos"), new Subject("Atividades Físicas e Esportivas", "Esportes Individuais"), new Subject("Atividades Físicas e Esportivas", "Atividades Rítmicas e Danças"), new Subject("Atividades Físicas e Esportivas", "Jogos e Brincadeiras"), new Subject("Condicionamento Físico", "Treinamento Cardiovascular"), new Subject("Condicionamento Físico", "Treinamento Muscular e Força"), new Subject("Condicionamento Físico", "Flexibilidade e Mobilidade"), new Subject("Condicionamento Físico", "Resistência e Recuperação"), new Subject("Saúde e Bem-Estar", "Nutrição e Dieta"), new Subject("Saúde e Bem-Estar", "Prevenção de Lesões"), new Subject("Saúde e Bem-Estar", "Higiene e Cuidados Pessoais"), new Subject("Saúde e Bem-Estar", "Aspectos Psicossociais da Atividade Física"), new Subject("Anatomia e Fisiologia", "Sistema Muscular e Esquelético"), new Subject("Anatomia e Fisiologia", "Sistema Cardiovascular e Respiratório"), new Subject("Anatomia e Fisiologia", "Biomecânica e Movimento"), new Subject("Anatomia e Fisiologia", "Fisiologia do Exercício"), new Subject("Aspectos Psicológicos", "Motivação e Comportamento"), new Subject("Aspectos Psicológicos", "Estresse e Relaxamento"), new Subject("Aspectos Psicológicos", "Psicologia do Esporte"), new Subject("Aspectos Psicológicos", "Apoio Psicológico e Desenvolvimento Pessoal"), new Subject("Metodologia e Didática", "Planejamento de Aulas"), new Subject("Metodologia e Didática", "Avaliação de Desempenho"), new Subject("Metodologia e Didática", "Metodologias de Ensino e Aprendizagem"), new Subject("Metodologia e Didática", "Inclusão e Adaptação de Atividades"), new Subject("Cultura e Sociedade", "Esportes e Cultura"), new Subject("Cultura e Sociedade", "Impactos Sociais e Culturais da Atividade Física"), new Subject("Cultura e Sociedade", "Eventos e Competições Esportivas"), new Subject("Cultura e Sociedade", "Política e Gestão Esportiva"));

    // 27 - Artes
    private List<Subject> subject27ToCheck = Arrays.asList(new Subject("História da Arte", "Arte na Pré-História"), new Subject("História da Arte", "Arte na Antiguidade"), new Subject("História da Arte", "Arte Medieval"), new Subject("História da Arte", "Arte Moderna e Contemporânea"), new Subject("História da Arte", "Movimentos Artísticos e Tendências"), new Subject("Arte Visual", "Desenho e Pintura"), new Subject("Arte Visual", "Escultura e Modelagem"), new Subject("Arte Visual", "Gravura e Técnicas de Impressão"), new Subject("Arte Visual", "Fotografia e Arte Digital"), new Subject("Arte Visual", "Design Gráfico e Ilustração"), new Subject("Teatro", "História do Teatro"), new Subject("Teatro", "Teoria e Prática da Atuação"), new Subject("Teatro", "Direção e Produção Teatral"), new Subject("Teatro", "Roteirização e Dramaturgia"), new Subject("Teatro", "Análise e Crítica Teatral"), new Subject("Música", "Teoria Musical e Composição"), new Subject("Música", "Prática Instrumental e Vocal"), new Subject("Música", "História da Música e Análise"), new Subject("Música", "Cantos e Performance Musical"), new Subject("Música", "Tecnologia e Produção Musical"), new Subject("Dança", "História e Estilos de Dança"), new Subject("Dança", "Técnicas de Dança Clássica e Moderna"), new Subject("Dança", "Coreografia e Composição"), new Subject("Dança", "Expressão Corporal e Improvisação"), new Subject("Dança", "Análise de Performances e Práticas Culturais"), new Subject("Estética e Filosofia da Arte", "Teorias Estéticas"), new Subject("Estética e Filosofia da Arte", "Análise Crítica de Obras de Arte"), new Subject("Estética e Filosofia da Arte", "Estudo da Percepção Artística"), new Subject("Estética e Filosofia da Arte", "Impacto Cultural e Social da Arte"), new Subject("Arte e Sociedade", "Arte e Identidade Cultural"), new Subject("Arte e Sociedade", "Arte e Políticas Públicas"), new Subject("Arte e Sociedade", "Educação e Participação Cultural"), new Subject("Arte e Sociedade", "Arte como Ferramenta de Transformação Social"), new Subject("Projetos e Experimentação", "Desenvolvimento de Projetos Artísticos"), new Subject("Projetos e Experimentação", "Processos Criativos e Experimentação"), new Subject("Projetos e Experimentação", "Exposições e Apresentações Artísticas"), new Subject("Projetos e Experimentação", "Gestão e Produção de Eventos Culturais"));

    public boolean isKnowledgeAreaUnique(KnowledgeArea knowledgeArea, EducationLevel educationLevel) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        educationLevel = mongoTemplate.find(new Query(Criteria.where("name").is(educationLevel.getName())), EducationLevel.class).get(0);
        criteria.andOperator(Criteria.where("id").is(knowledgeArea.getId()), Criteria.where("educationLevel.$id").is(educationLevel.getId()));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, KnowledgeArea.class).isEmpty();
    }

    public boolean isSubjectUnique(Subject subject, KnowledgeArea knowledgeArea, EducationLevel educationLevel) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        knowledgeArea = mongoTemplate.find(
                new Query(
                        Criteria.where("name").is(knowledgeArea.getName()))
                , KnowledgeArea.class).get(0);
        educationLevel = mongoTemplate.find(
                new Query(
                        Criteria.where("name").is(educationLevel.getName()))
                , EducationLevel.class).get(0);
        criteria.andOperator(Criteria.where("id").is(subject.getId()),
                Criteria.where("knowledgeArea.$id").is(knowledgeArea.getId()),
                Criteria.where("knowledgeArea.educationLevel.$id").is(educationLevel.getId()));
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Subject.class).isEmpty();
    }

    private void createSubject(List<Subject> subjectToCheck, KnowledgeArea knowledgeArea, EducationLevel educationLevel) {

        for (Subject subject : subjectToCheck) {
            subject.setId(null);
            if (isSubjectUnique(subject, knowledgeArea, educationLevel)
                    && educationLevel.getId() != null) {
                knowledgeArea.setEducationLevel(educationLevel);
                subject.setKnowledgeArea(knowledgeArea);
                mongoTemplate.save(subject);
            }
        }
    }

    private KnowledgeArea createKnowledgeArea(KnowledgeArea knowledgeArea){
        KnowledgeArea model = new KnowledgeArea();
        model.setId(knowledgeArea.getId());
        model.setName(knowledgeArea.getName());
        model.setEducationLevel(knowledgeArea.getEducationLevel());
        return model;
    }

    @PostConstruct
    public void init() {


        //1 - INSERT EDUCATION LEVELS
        for (EducationLevel educationLevel : educationLevelsToCheck) {
            if (mongoTemplate.find(new Query(Criteria.where("name").is(educationLevel.getName())), EducationLevel.class).isEmpty()) {
                mongoTemplate.save(educationLevel);
            }
        }

        //2 - INSERT KNOWLEDGE AREAS
        //2.1 - GENERAL
        for (KnowledgeArea generalKnowledgeArea : generalKnowledgeAreaToCheck) {
            if (isKnowledgeAreaUnique(generalKnowledgeArea, educationLevelsToCheck.get(0))
                    && educationLevelsToCheck.get(0).getId() != null) {
                generalKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(0));
                mongoTemplate.save(generalKnowledgeArea);
                gradeEnsinoFundamentalAnosIniciais.add(createKnowledgeArea(generalKnowledgeArea));
            }
            generalKnowledgeArea.setId(null);
            if (isKnowledgeAreaUnique(generalKnowledgeArea, educationLevelsToCheck.get(1))
                    && educationLevelsToCheck.get(1).getId() != null) {
                generalKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(1));
                mongoTemplate.save(generalKnowledgeArea);
                gradeEnsinoFundamentalAnosFinais.add(createKnowledgeArea(generalKnowledgeArea));
            }
            generalKnowledgeArea.setId(null);
            if (isKnowledgeAreaUnique(generalKnowledgeArea, educationLevelsToCheck.get(2))
                    && educationLevelsToCheck.get(2).getId() != null) {
                generalKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(2));
                mongoTemplate.save(generalKnowledgeArea);
                gradeEnsinoMedio.add(createKnowledgeArea(generalKnowledgeArea));
            }
        }

        //2.2 - SPECIFIC ONE
        for (KnowledgeArea specificOneKnowledgeArea : specificOneKnowledgeAreaToCheck) {
            if (isKnowledgeAreaUnique(specificOneKnowledgeArea, educationLevelsToCheck.get(0))
                    && educationLevelsToCheck.get(0).getId() != null) {
                specificOneKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(0));
                mongoTemplate.save(specificOneKnowledgeArea);
                gradeEnsinoFundamentalAnosIniciais.add(createKnowledgeArea(specificOneKnowledgeArea));
            }
            specificOneKnowledgeArea.setId(null);
            if (isKnowledgeAreaUnique(specificOneKnowledgeArea, educationLevelsToCheck.get(1))
                    && educationLevelsToCheck.get(1).getId() != null) {
                specificOneKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(1));
                mongoTemplate.save(specificOneKnowledgeArea);
                gradeEnsinoFundamentalAnosFinais.add(createKnowledgeArea(specificOneKnowledgeArea));
            }
        }

        //2.2 - SPECIFIC TWO
        for (KnowledgeArea specificTwoKnowledgeArea : specificTwoKnowledgeAreaToCheck) {
            if (isKnowledgeAreaUnique(specificTwoKnowledgeArea, educationLevelsToCheck.get(2))
                    && educationLevelsToCheck.get(2).getId() != null) {
                specificTwoKnowledgeArea.setEducationLevel(educationLevelsToCheck.get(2));
                mongoTemplate.save(specificTwoKnowledgeArea);
                gradeEnsinoMedio.add(createKnowledgeArea(specificTwoKnowledgeArea));
            }
        }

        //3 - INSERT SUBJECTS
        //2.1 - Ensino Fundamental
        //Lingua Portuguesa
        createSubject(subject0ToCheck, gradeEnsinoFundamentalAnosIniciais.get(0), educationLevelsToCheck.get(0));
        createSubject(subject0ToCheck, gradeEnsinoFundamentalAnosFinais.get(0), educationLevelsToCheck.get(1));
        //Matemática
        createSubject(subject1ToCheck, gradeEnsinoFundamentalAnosIniciais.get(1), educationLevelsToCheck.get(0));
        createSubject(subject1ToCheck, gradeEnsinoFundamentalAnosFinais.get(1), educationLevelsToCheck.get(1));
        //Educação Física
        createSubject(subject2ToCheck, gradeEnsinoFundamentalAnosIniciais.get(2), educationLevelsToCheck.get(0));
        createSubject(subject2ToCheck, gradeEnsinoFundamentalAnosFinais.get(2), educationLevelsToCheck.get(1));
        //Artes
        createSubject(subject3ToCheck, gradeEnsinoFundamentalAnosIniciais.get(3), educationLevelsToCheck.get(0));
        createSubject(subject3ToCheck, gradeEnsinoFundamentalAnosFinais.get(3), educationLevelsToCheck.get(1));
        //Ciências
        createSubject(subject4ToCheck, gradeEnsinoFundamentalAnosIniciais.get(4), educationLevelsToCheck.get(0));
        createSubject(subject4ToCheck, gradeEnsinoFundamentalAnosFinais.get(4), educationLevelsToCheck.get(1));
        //História
        createSubject(subject5ToCheck, gradeEnsinoFundamentalAnosIniciais.get(5), educationLevelsToCheck.get(0));
        createSubject(subject5ToCheck, gradeEnsinoFundamentalAnosFinais.get(5), educationLevelsToCheck.get(1));
        //Geografia
        createSubject(subject6ToCheck, gradeEnsinoFundamentalAnosIniciais.get(6), educationLevelsToCheck.get(0));
        createSubject(subject6ToCheck, gradeEnsinoFundamentalAnosFinais.get(6), educationLevelsToCheck.get(1));
        //Ensino Religioso
        createSubject(subject7ToCheck, gradeEnsinoFundamentalAnosIniciais.get(7), educationLevelsToCheck.get(0));
        createSubject(subject7ToCheck, gradeEnsinoFundamentalAnosFinais.get(7), educationLevelsToCheck.get(1));

        //Ensino Médio
        createSubject(subject8ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));
        createSubject(subject9ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));
        createSubject(subject10ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));
        createSubject(subject11ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));
        createSubject(subject12ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));
        createSubject(subject13ToCheck, gradeEnsinoMedio.get(4), educationLevelsToCheck.get(2));

        createSubject(subject14ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject15ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject16ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject17ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject18ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject19ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject20ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject21ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));
        createSubject(subject22ToCheck, gradeEnsinoMedio.get(5), educationLevelsToCheck.get(2));

        createSubject(subject23ToCheck, gradeEnsinoMedio.get(6), educationLevelsToCheck.get(2));

        createSubject(subject24ToCheck, gradeEnsinoMedio.get(0), educationLevelsToCheck.get(2));
        createSubject(subject25ToCheck, gradeEnsinoMedio.get(1), educationLevelsToCheck.get(2));
        createSubject(subject26ToCheck, gradeEnsinoMedio.get(2), educationLevelsToCheck.get(2));
        createSubject(subject27ToCheck, gradeEnsinoMedio.get(3), educationLevelsToCheck.get(2));

    }
     */
}