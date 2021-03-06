#Introduction
With this package it is possible to access data from the NCBI Webservice inside R and use this data for further processing.
The package provides the returned data in the form of a list object. This list can be inspected further, see the [Examples](https://github.com/MartinUndDerWolf/rncbi/wiki/Examples) for more details.

# Installation
Installation of the package is quite easy as it doesn't need to compile anything.
The only precondition is to provide [Java 5](http://www.java.com/) or higher.<br>
To successfully install the RNCBI package the following packages are necessary.
## rJava
To install this package, simply type 

    install.packages("rJava")

into the R console. Further informations on this package can be found at the [rJava site](http://www.rforge.net/rJava/).
<blockquote><font color="red">If you are on a unix system, make sure R was configured with Java support.</font></blockquote>
To do this without re-installing R do

    R CMD javareconf

on the command line, maybe root privileges are required to do this.
## XML
This also can be installed with the package system from R, simply type 

    install.packages("XML")

Further informations can be found on http://cran.r-project.org/web/packages/XML/index.html.

## RNCBI
The package itself can be installed from http://cran.r-project.org/ directly.
To do this inside R type:

    install.packages("RNCBI")
