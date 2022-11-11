# AwsLambdaExamples Java

## Example1
In questo articolo sarà esposto il metodo base e "manuale" per creare funzioni lambda a titolo di esempio per mostrare nel dettaglio ogni singolo componente dell'architettura, in successivi articoli saranno esposti i metodi più automatici grazie ad AWS CLI, AWS SAM e AWS SDK che permettono al programmatore di saltare alcuni passaggi manuali che vengono eseguiti dai tool messi a disposizione dalla piattaforma.
Il primo passo è creare un progetto Java con Maven, questo è possibile sia da Eclipse sia da MS Code, nel file pom.xml bisogna aggiungere alcune dipendenze necessarie per la compilazione
Oppure, nella procedura gruidata di Eclipse, è possibile selezionare il tipo "aws-lambda-s3-example". Quello che bisogna creare è una classe e un metodo specifici che poi saranno il corpo della funzione lambda, in questo caso la classe deve implementare RequestHandler che ha due archetipi: l'elenco scatenante in input e il tipo di output della funzione, infatti poi bisogna definire una funzione che i due tipi in ingresso e in uscita

### To compile
'''mvn pacakge'''
oppure lanciando la procedura guidata di ecplise mettendo "pacakge" come "goals", il comando va a creare un file jar all'interno della cartella target, questo pacchetto è pronto per esser rilaciato in AWS.

### Deploy in AWS
Nella console di AWS, nel servizio lambda si devono eseguire i seguenti passi
Nella console di AWS, nel servizio lambda si devono eseguire i seguenti passi
- creare manualmente una nuova funzione selezionando il nome e il tipo "Java 8 on Amazon Linux 1"
- caricare il jar, selezionado il file dopo aver premuto la tendina "Upload from" nella vista code
- impostare la classe nella sezione "Runtime settings" nella vista code, inserendo il valore nel tipo pacakge::metodo, per esempio "it.alnao.lambda.examples.Esample1::handleRequest"
- impostare memoria e timeout nella scheda General nella vista Configuration, di default i valori sono 512Mb e 15 secondi rispettivamente
- impostare trigger e permission se necessario, in questo primo esempio non sono previsti

### Test
Per provare manualmente la funzione basta andare nella vista test e lanciare il bottone "test", il risultato sarà un messaggio "OK" e aprendo i dettagli si potrà vedere anche il messaggio scritto nella stream di output.
Nella vista monitor sono disposnibili i grafici di tutte le esecuzioni con il dettaglio di errori e un tab specifico per accedere ai log su CloudWatch.