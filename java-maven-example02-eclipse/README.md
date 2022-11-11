# AwsLambdaExamples Java

## Example2 eclipse
progetto creato in eclipse con plugin AWS importabile dal 


https://aws.amazon.com/eclipse


dopo bisogna creare progetto eclipse di tipo "AWS Lambda Java project"


### To compile
'''mvn pacakge'''
oppure lanciando la procedura guidata di ecplise mettendo "pacakge" come "goals", il comando va a creare un file jar all'interno della cartella target, questo pacchetto pronto per esser rilaciato in AWS.

### Deploy in AWS
Selezionando la classe Handler cliccando con il tasto destro del mout, selezionando la voce "AWS, Upload lambda" bisogna impostare - nome
- region
- regola IAM (conviene crearne una specifica per lambda)
- bucket di upload del jar
e si esegue upload su AWS. Prima deve essere comunque configurato profilo AWS CLI tramite IAM e credenziali programmatiche.

### Nota
Io ho sempre errore di creazione del jar oppure errore in libreria JAXB, dipende dalla versione di Java che si esegue (eclipse necessita la > 11 ma JAXB = 1.8). Non ho trovato soluzione al problema