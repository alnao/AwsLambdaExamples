# AwsLambdaExamples

## py-example1
Creazione con comando e template https://www.serverless.com/framework/docs/providers/aws/cli-reference/create
```
$ sls create --template aws-python3 --path py-example1
```
Modifica del file `handler.py`
```
def hello(event, context):
	print("Ciao");
	return "Ciao example1 py";
```
> Prestare attenzione che i tab non devono esserci ma devono essere 4 spazi.

Modifica al file `serverless.yml` (aggiunte le ultime 2 se non presenti, occhio alla regione che bisogna indicarla con precisione)
```
provider:
  name: aws
  runtime: python2.7
  lambdaHashingVersion: 20201221
  profile: serverless-admin
  region: us-east-1
```
Eseguire il deploy la prima volta con 
```
$ cd py-example1/
$ sls deploy -v
```
oppure deploy successivi della sola funzione specifica con
```
$ sls deploy function -f hello
```
il secondo è più veloce perchè deploya solo la funzione specifica.
Esito del deploy indica tutte le info
Dopo il deploy lanciare da console oppure lanciare da CLI con
```
$ sls invoke -f hello -l
-----------------------------------------------------------
START RequestId: <...> Version: $LATEST
Ciao
END RequestId: <...>
REPORT RequestId: <...>  Duration: 0.97 msBilled Duration: 1 ms   Memory Size: 1024 MB    Max Memory Used: 37 MB
```
Gestione dei log da AWS lambda dentro il Pannello di controllo nelle chiamate ed esecuzioni e su monitoraggio si vedono i log in CloudWatch Logs InsightsInfo
Oppure da riga di comando con
```
sls logs -f hello --startTime 5h
```
per vedere le ultime 5 ore oppure in tail con il comando
```
sls logs -f hello -t 
```
Per rimuovere tutto basta
```
sls remove
```
questo comando rimuove la lambda, i bucket s3, i log e le dipendenze (non l'utenza IAM serverless-admin)

## License
**Free Software, Hell Yeah!**
Documento inizialmente creato con https://dillinger.io/ poi modificato a mano