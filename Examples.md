Once the package is installed, you can start sending requests to the NCBI webservice using R.
This will show some short examples how to use the package. For further examples and detailed explanations see the [RNCBIManual.pdf](http://rncbi.googlecode.com/files/RNCBIManual-0.9-1.pdf) in
the download section.

## Initialization ##
The very first step is to load the library we installed a moment ago.
```
library(RNCBI)
```
To use the interface to the webservice, we first need to create a java object inside R.
This can be done like this:
```
ncbi <- NCBI()
```
If your R environment has a proxy set correctly, then this call will be sufficient and the proxy is set automatically.


But if you need to set a user and password for your proxy to connect to the internet:
```
ncbi <- NCBI(proxy="http://host:port")
setProxyUser(user="user", password="password")
```
If you only need to set the user, leave the password argument blank or omit it.

## Doing some stuff ##
With this object, we can do several stuff.
We can get a list of all supported operations of the webservice for example or a list of all supported databases of the EFetch operation.
```
getOperations(ncbi)

getEFetchDatabases(ncbi)
```
## Doing some more stuff ##
Now we want to fetch some data from the webservice.
As example we choose to fetch something with the einfo operation.
To do this, we need an object for the corresponding operation from the EUtils.
```
einfo <- EInfo(ncbi)
```
This is the object we will work with.
Now we need to set some request parameters to this object. In case of einfo, we don't have to set request parameters, as this operation returns a list of databases, if called without any parameter.
But we want to get some information about the "pubmed" database, so we do:
```
einfo <- setRequestParameter(einfo, "db", "pubmed")
```
This sets the parameter "db" to the value "pubmed". To get a full list of all available parameters, you always can call
```
getRequestParameter(ncbi,"name_of_the_operation")
```
In our case the name of the operation would be "einfo".
In case of the EFetch operations, an object has to be created first (see the [RNCBIManual.pdf](http://rncbi.googlecode.com/files/RNCBIManual-0.9-1.pdf) for more information on this).
With the request parameters set, we can do the request now and save the results.
```
einfo <- requestEInfo(einfo)

results <- getResults(einfo)
```
The results are always available in the "einfo" object, but for further processing, we save them into our own variable.
Now we see that this is a list six entries.
```
"lastupdate" "fieldlist" "description" "dbname" "linklist" "menuname"
```
If we inspect this list further more, we recognize that "linklist" and "fieldlist" are a complex lists, consisting of further sub-lists.
To convert this to a more readable form, we will build a dataframe out of "linklist":
```
x <- do.call(cbind, lapply(results$linklist, unlist))
linklist <- data.frame(x, stringsAsFactors=FALSE)
```

This can be done with all the results returned from each operation.

